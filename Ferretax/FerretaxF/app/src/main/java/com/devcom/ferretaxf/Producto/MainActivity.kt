package com.devcom.ferretaxf.Producto


import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.cursosandroidant.nilo.profile.ProfileFragment
import com.devcom.ferretaxf.Colecciones.Order
import com.devcom.ferretaxf.carrito.CartFragment
import com.devcom.ferretaxf.detalles.DetailFragment
import com.devcom.ferretaxf.Colecciones.Product
import com.devcom.ferretaxf.Colecciones.direccion
import com.devcom.ferretaxf.R
import com.devcom.ferretaxf.VarConstantes
import com.devcom.ferretaxf.databinding.ActivityMainBinding
import com.devcom.ferretaxf.databinding.FragmentCartBinding
import com.devcom.ferretaxf.ordenes.OrderActivity
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.ErrorCodes
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import com.google.firebase.firestore.Query

class MainActivity : AppCompatActivity() , OnProductListener, MainAux {

    private lateinit var binding: ActivityMainBinding
    private lateinit var comFragCart: FragmentCartBinding

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var authStateListener: FirebaseAuth.AuthStateListener

    private lateinit var adapter: ProductAdapter

    private lateinit var firestoreListener: ListenerRegistration
    private var queryPagination: Query? = null

    private var productSelected: Product? = null
    private val productCartList = mutableListOf<Product>()
    protected var iduser = ""




    private val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        val response = IdpResponse.fromResultIntent(it.data)

        if (it.resultCode == RESULT_OK){
            val user = FirebaseAuth.getInstance().currentUser
            if (user != null){
                Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show()
            }
        } else {
            if (response == null){
                Toast.makeText(this, "Hasta pronto", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                response.error?.let {
                    if (it.errorCode == ErrorCodes.NO_NETWORK){
                        Toast.makeText(this, "Sin red", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Código de error: ${it.errorCode}",
                            Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
    private fun getuser() {
        val user = FirebaseAuth.getInstance().currentUser
        user?.let { myUser ->
            iduser= myUser.uid
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Autenticar()
        configRecyclerView()
        configButtons()
    }




    // crear usuario con correo y Google
    private fun Autenticar(){
        firebaseAuth = FirebaseAuth.getInstance()
        authStateListener = FirebaseAuth.AuthStateListener{auth->
            if (auth.currentUser != null){
                supportActionBar?.title = auth.currentUser?.displayName
                binding.llProgress.visibility = View.GONE
                binding.nsvProducts.visibility = View.VISIBLE
              //  binding.efab.show()
            }else {
                //vincular email
                val providers = arrayListOf(
                    AuthUI.IdpConfig.EmailBuilder().build(),
                    AuthUI.IdpConfig.GoogleBuilder().build())
                //configuracion mas basica
                resultLauncher.launch(
                    AuthUI.getInstance()
                        .createSignInIntentBuilder().setAvailableProviders(providers)
                        .setIsSmartLockEnabled(false)
                        .setLogo(R.drawable.logologin)
                        .setTheme(R.style.LoginTheme)
                        .build()
                )
            }
        }
    }

    override fun onResume() {
        super.onResume()
        firebaseAuth.addAuthStateListener(authStateListener)
        configFirestoreRealtime()
    }

    override fun onPause() {
        super.onPause()
        firebaseAuth.removeAuthStateListener(authStateListener)
        firestoreListener.remove()
    }

    private fun configRecyclerView(){
        adapter = ProductAdapter(mutableListOf(Product()), this)
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 3,
                GridLayoutManager.HORIZONTAL, false)
            adapter = this@MainActivity.adapter
        }
    }

    private fun configButtons(){
        binding.btnViewCart.setOnClickListener {
            val fragment = CartFragment()
            fragment.show(supportFragmentManager.beginTransaction(), CartFragment::class.java.simpleName)
        }
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_sign_out -> {
                AuthUI.getInstance().signOut(this)
                    .addOnSuccessListener {
                        Toast.makeText(this, "Sesión terminada.", Toast.LENGTH_SHORT).show()
                    }
                    .addOnCompleteListener {
                        if (it.isSuccessful){
                            binding.nsvProducts.visibility = View.GONE
                            binding.llProgress.visibility = View.VISIBLE
                        } else {
                            Toast.makeText(this, "No se pudo cerrar la sesión.", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
            R.id.action_order_history -> startActivity(Intent(this, OrderActivity::class.java))

        R.id.action_profile -> {
                val fragment = ProfileFragment()
                supportFragmentManager
                    .beginTransaction()
                    .add(R.id.containerMain, fragment)
                    .addToBackStack(null)
                    .commit()

                showButton(false)
            }
            /*
                      R.id.action_settings -> {
                          startActivity(Intent(this, SettingsActivity::class.java))
                      }
                      R.id.action_promo -> {
                          val fragment = PromoFragment()
                          supportFragmentManager
                              .beginTransaction()
                              .add(R.id.containerMain, fragment)
                              .addToBackStack(null)
                              .commit()

                          showButton(false)
                      }*/
        }
        return super.onOptionsItemSelected(item)
    }

    private fun configFirestoreRealtime(){
        val db = FirebaseFirestore.getInstance()
        val productRef = db.collection(VarConstantes.COLLECION_PRODUCTOS)
        firestoreListener = productRef
            .limit(10)
            .addSnapshotListener { snapshots, error ->
                if (error != null){
                    Toast.makeText(this, "Error al consultar datos.", Toast.LENGTH_SHORT).show()
                    return@addSnapshotListener
                }
                snapshots?.let { items ->
                    val lastItem = items.documents[items.size() - 1]
                    queryPagination = productRef
                        .startAfter(lastItem)
                        .limit(6)

                    for (snapshot in snapshots!!.documentChanges){
                        val product = snapshot.document.toObject(Product::class.java)
                        product.id = snapshot.document.id
                        when(snapshot.type){
                            DocumentChange.Type.ADDED -> adapter.add(product)
                            DocumentChange.Type.MODIFIED -> adapter.update(product)
                            DocumentChange.Type.REMOVED -> adapter.delete(product)
                        }
                    }
                }
        }
    }

    override fun onClick(product: Product) {
        val index = productCartList.indexOf(product)
        if (index != -1){
            productSelected = productCartList[index]
        } else {
            productSelected = product
        }

        val fragment = DetailFragment()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.containerMain, fragment)
            .addToBackStack(null)
            .commit()

                showButton(false)

    }

    override fun getProductsCart(): MutableList<Product> = productCartList

    override fun getProductSelected(): Product? = productSelected

    override fun showButton(isVisible: Boolean) {
        binding.btnViewCart.visibility = if (isVisible) View.VISIBLE else View.GONE
    }

    override fun addProductToCart(product: Product) {
        val index = productCartList.indexOf(product)
        if (index != -1){
            productCartList.set(index, product)
        } else {
            productCartList.add(product)
        }

        updateTotal()
    }
    override fun updateTotal() {
        var total = 0.0
        productCartList.forEach { product ->
            total += product.totalPrice()
        }
        if (total == 0.0){
            binding.tvTotal.text = getString(R.string.product_empty_cart)
            clearCart()
        } else {
            binding.tvTotal.text = getString(R.string.product_full_cart, total)
        }
    }

    override fun clearCart() {
        productCartList.clear()
    }

    override fun updateTitle(user: FirebaseUser) {
        supportActionBar?.title = user.displayName
    }

}