package com.devcom.ferretaxf.Producto

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.devcom.ferretaxf.Colecciones.Product
import com.devcom.ferretaxf.R
import com.devcom.ferretaxf.databinding.ItemProductBinding

class ProductAdapter(private val productList: MutableList<Product>,
                     private val listener: OnProductListener
) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = productList[position]

        holder.setListener(product)

        if(product.id == null){
            holder.binding.containerProduct.visibility = View.GONE

        } else {
            holder.binding.containerProduct.visibility = View.VISIBLE

            holder.binding.tvName.text = product.nombre
            holder.binding.tvPrice.text = context.getString(R.string.product_list_precio, product.precio)
            holder.binding.tvQuantity.text = product.cantidad.toString()

            Glide.with(context)
                .load(product.imgUrl)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.ic_access_time)
                .error(R.drawable.ic_broken_image)
                .centerCrop()
                .into(holder.binding.imgProduct)
        }
    }

    override fun getItemCount(): Int = productList.size

    fun add(product: Product){
        if (!productList.contains(product)){
            //productList.add(product)
            productList.add(productList.size - 1, product)
            notifyItemInserted(productList.size - 2)
        } else {
            update(product)
        }
    }

    fun update(product: Product){
        val index = productList.indexOf(product)
        if (index != -1){
            productList.set(index, product)
            notifyItemChanged(index)
        }
    }

    fun delete(product: Product){
        val index = productList.indexOf(product)
        if (index != -1){
            productList.removeAt(index)
            notifyItemRemoved(index)
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val binding = ItemProductBinding.bind(view)

        fun setListener(product: Product){
            binding.root.setOnClickListener {
                listener.onClick(product)
            }
        }
    }
}