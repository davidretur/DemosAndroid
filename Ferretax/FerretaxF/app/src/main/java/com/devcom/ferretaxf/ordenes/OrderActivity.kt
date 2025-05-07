package com.devcom.ferretaxf.ordenes

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.devcom.ferretaxf.Colecciones.Order
import com.devcom.ferretaxf.R
import com.devcom.ferretaxf.VarConstantes
import com.devcom.ferretaxf.databinding.ActivityOrderBinding
import com.devcom.ferretaxf.track.TrackFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query

class OrderActivity : AppCompatActivity() , OnOrderListener, OrderAux{

    private lateinit var binding: ActivityOrderBinding

    private lateinit var adapter: OrderAdaper

    private lateinit var orderSelected: Order

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        setupFirestore()

        checkIntent(intent)
    }

    private fun checkIntent(intent: Intent?) {
        intent?.let {
            val actionIntent = it.getIntExtra(VarConstantes.ACTION_INTENT, 0)
            if (actionIntent == 1) {
                val id = intent.getStringExtra(VarConstantes.PROP_ID) ?: ""
                val status = intent.getIntExtra(VarConstantes.PROP_STATUS, 0)
                orderSelected = Order(id = id, status = status)

                val fragment = TrackFragment()
                supportFragmentManager
                    .beginTransaction()
                    .add(R.id.containerMain, fragment)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    private fun setupRecyclerView() {
        adapter = OrderAdaper(mutableListOf(), this)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@OrderActivity)
            adapter = this@OrderActivity.adapter
        }
    }

    private fun setupFirestore(){
        FirebaseAuth.getInstance().currentUser?.let {  user ->
            val db = FirebaseFirestore.getInstance()

            db.collection(VarConstantes.COLL_REQUESTS)
                .get()
                .addOnSuccessListener {
                    for (document in it){
                        val order = document.toObject(Order::class.java)
                        if(order.clientId == user.uid){
                        order.id = document.id
                        adapter.add(order)
                        }
                    }
                }
                .addOnFailureListener {
                    Toast.makeText(this, "Error al consultar los datos.", Toast.LENGTH_SHORT)
                        .show()
                }
        }
    }

    override fun onTrack(order: Order) {
        orderSelected = order

        val fragment = TrackFragment()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.containerMain, fragment)
            .addToBackStack(null)
            .commit()
    }


    override fun getOrderSelected(): Order = orderSelected
}