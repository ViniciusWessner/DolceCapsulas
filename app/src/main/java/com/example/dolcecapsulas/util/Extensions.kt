package com.example.dolcecapsulas.util

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.dolcecapsulas.R
import com.example.dolcecapsulas.databinding.LayoutBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

fun Fragment.initToolbar(
    toolbar: Toolbar,
    homeAsUpEnable: Boolean = true
) {
    (activity as AppCompatActivity).setSupportActionBar(toolbar)
    (activity as AppCompatActivity).title = ""
    (activity as AppCompatActivity).supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_back)
    (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(homeAsUpEnable)
    toolbar.setNavigationOnClickListener { activity?.onBackPressedDispatcher?.onBackPressed() }
}


fun Fragment.showBottomSheet(
    title: Int? = null,
    message: String?,
    titleButton: Int? = null,
    onClick: () -> Unit = {}
){

    val bottomSheetDialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialog)
    val bottomSheetBinding: LayoutBottomSheetBinding =
        LayoutBottomSheetBinding.inflate(layoutInflater, null, false)

    bottomSheetBinding.txtTitulo.text = getString(title ?: R.string.atencion )
    bottomSheetBinding.txtMensagem.text = message ?: getText(R.string.error)
    bottomSheetBinding.btnOk.text = getString(title ?: R.string.Entendido)

    bottomSheetBinding.btnOk.setOnClickListener {
        bottomSheetDialog.dismiss()
        onClick()
    }

    bottomSheetDialog.setContentView(bottomSheetBinding.root)
    bottomSheetDialog.show()


}