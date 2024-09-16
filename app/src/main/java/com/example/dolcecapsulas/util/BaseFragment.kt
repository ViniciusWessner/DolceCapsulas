package com.example.dolcecapsulas.util

import android.content.Context
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment

open class BaseFragment: Fragment() {

    fun hideKeyboard(){
        val view = activity?.currentFocus
        if (view != null) {
            val imn = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imn.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}