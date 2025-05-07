package com.cursosandroidant.nilo.profile

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.devcom.ferretaxf.Colecciones.direccion
import com.devcom.ferretaxf.Producto.MainActivity
import com.devcom.ferretaxf.Producto.MainAux
import com.devcom.ferretaxf.R
import com.devcom.ferretaxf.VarConstantes
import com.devcom.ferretaxf.databinding.ActivityMainBinding
import com.devcom.ferretaxf.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import java.io.ByteArrayOutputStream


class ProfileFragment : Fragment() {

    private var binding: FragmentProfileBinding? = null
    private var direc: direccion? = null

    private var userid: String? = null

    private val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if (it.resultCode == Activity.RESULT_OK){
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        binding?.let {
            return  it.root
        }

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getUser()
        configButtons()
    }
    private fun getUser() {
        binding?.let { binding ->
        FirebaseAuth.getInstance().currentUser?.let {  user ->
            val db = FirebaseFirestore.getInstance()

            db.collection("direccion")
                .get()
                .addOnSuccessListener {
                    for (document in it){
                        val direccion = document.toObject(direccion::class.java)
                        if(direccion.idcliente == user.uid){
                        binding.nombre.setText(direccion.nombre)
                        binding.apellido.setText(direccion.apellido)
                        binding.telefono.setText(direccion.telefono)
                        binding.calle.setText(direccion.calle)
                            binding.colonia.setText(direccion.colonia)
                        binding.nexterior.setText(direccion.nexterior)
                        }
                    }
                }
        }

        }
    }

    private fun setupActionBar(){
        (activity as? AppCompatActivity)?.let {
            it.supportActionBar?.setDisplayHomeAsUpEnabled(true)
            it.supportActionBar?.title = getString(R.string.profile_title)
            setHasOptionsMenu(true)
        }
    }

    @SuppressLint("SuspiciousIndentation")
    private fun configButtons() {
        binding?.let { binding->
            binding.btnUpdate.setOnClickListener {
                binding.nombre.clearFocus()
                //binding.etPhotoUrl.clearFocus()
                FirebaseAuth.getInstance().currentUser?.let { user ->
                    if (binding.nombre.text.toString() == "" ) {
                        Toast.makeText(activity, "Ingresa Nombre", Toast.LENGTH_SHORT).show()
                    }else if(binding.apellido.text.toString() == ""){
                        Toast.makeText(activity, "Ingresa Apellido", Toast.LENGTH_SHORT).show()
                    }else if(binding.calle.text.toString() == ""){
                        Toast.makeText(activity, "Ingresa Calle", Toast.LENGTH_SHORT).show()
                    }else if(binding.colonia.text.toString() == ""){
                        Toast.makeText(activity, "Ingresa Colonia", Toast.LENGTH_SHORT).show()
                    }else if(binding.nexterior.text.toString() == ""){
                        Toast.makeText(activity, "Ingresa Numero Exterior", Toast.LENGTH_SHORT).show()
                    }else if(binding.telefono.text.toString() == ""){
                        Toast.makeText(activity, "Ingresa Telefono", Toast.LENGTH_SHORT).show()
                    }else{
                         direc = direccion(
                            idcliente = user.uid,
                            nombre = binding.nombre.text.toString().trim(),
                            apellido = binding.apellido.text.toString().trim(),
                            telefono = binding.telefono.text.toString().trim(),
                            calle = binding.calle.text.toString().trim(),
                            colonia = binding.colonia.text.toString().trim(),
                            nexterior = binding.nexterior.text.toString().trim())
                        actualizarDatosEnvios(direc!!)

                    }
                }
            }
        }
    }



    private fun actualizarDatosEnvios(direc: direccion) {
            val db = FirebaseFirestore.getInstance()
            direc.idcliente?.let { idcliente ->
                db.collection("direccion")
                    .document(idcliente)
                    .set(direc)
                    .addOnSuccessListener {
                        Toast.makeText(activity, "Datos de envio actualizados.", Toast.LENGTH_SHORT).show()
                        activity?.onBackPressed()
                    }
                    .addOnFailureListener {
                        Toast.makeText(activity, "Error al actualizar.", Toast.LENGTH_SHORT).show()
                    }

            }
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            activity?.onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroyView() {
        (activity as? MainAux)?.showButton(true)
        super.onDestroyView()
        binding = null
    }

    override fun onDestroy() {
        (activity as? AppCompatActivity)?.let {
            it.supportActionBar?.setDisplayHomeAsUpEnabled(false)
            setHasOptionsMenu(false)
        }
        super.onDestroy()
    }
}