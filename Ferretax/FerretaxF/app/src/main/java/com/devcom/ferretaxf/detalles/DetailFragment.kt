package com.devcom.ferretaxf.detalles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.devcom.ferretaxf.Colecciones.Product
import com.devcom.ferretaxf.Producto.MainAux
import com.devcom.ferretaxf.R
import com.devcom.ferretaxf.VarConstantes
import com.devcom.ferretaxf.databinding.FragmentDetailBinding
import com.google.firebase.storage.FirebaseStorage


class DetailFragment : Fragment() {
    private var binding: FragmentDetailBinding? = null
    private var product: Product? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        binding?.let {
            return it.root
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getDetallesProducto()
        setupButtons()
    }

    private fun getDetallesProducto() {
        product = (activity as? MainAux)?.getProductSelected()
        product?.let { product ->
            binding?.let { it
                it.tvName.text = product.nombre
                it.tvDescription.text = product.descripcion
                it.tvQuantity.text = getString(R.string.detail_quantity, product.cantidad)
                setNewQuantity(product)

                     Glide.with(this)
                    .load(product.imgUrl)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.ic_access_time)
                    .error(R.drawable.ic_broken_image)
                    .centerCrop()
                    .into(it.imgProduct)
                /*context?.let { context ->
    val productRef = FirebaseStorage.getInstance().reference
        .child(product.VendedorId)
        .child(VarConstantes.PATH_PRODUCT_IMAGES)
        .child(product.id!!)

    productRef.listAll()
        .addOnSuccessListener { imgList ->
            val detailAdapter = DetailAdapter(imgList.items, context)
            binding.vpProduct.apply {
                adapter = detailAdapter
            }
        }
}*/
            }
        }
    }

    private fun setNewQuantity(product: Product) {
        binding?.let {
            it.etNewQuantity.setText(product.newQuantity.toString())

            val newQuantityStr = getString(
                R.string.detail_total_price, product.totalPrice(),
                product.newQuantity, product.precio)
            it.tvTotalPrice.text = HtmlCompat.fromHtml(newQuantityStr, HtmlCompat.FROM_HTML_MODE_LEGACY)
        }
    }

    private fun setupButtons(){
        product?.let { product ->
            binding?.let { binding ->
                binding.ibSub.setOnClickListener {
                    if (product.newQuantity > 1){
                        product.newQuantity -= 1
                        setNewQuantity(product)
                    }
                }
                binding.ibSum.setOnClickListener {
                    if (product.newQuantity < product.cantidad){
                        product.newQuantity += 1
                        setNewQuantity(product)
                    }
                }
                binding.efab.setOnClickListener {
                    if(product.newQuantity >= 1){
                        product.newQuantity = binding.etNewQuantity.text.toString().toInt()
                        addToCart(product)
                    }else{
                        Toast.makeText(activity, "Minima cantidad 1.", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun addToCart(product: Product) {
        (activity as? MainAux)?.let {
            it.addProductToCart(product)
            activity?.onBackPressed()
        }
    }

    override fun onDestroyView() {
        (activity as? MainAux)?.showButton(true)
        super.onDestroyView()
        binding = null
    }
}