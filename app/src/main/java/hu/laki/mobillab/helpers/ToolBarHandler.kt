package hu.laki.mobillab.helpers

import androidx.fragment.app.Fragment

interface ToolbarHandler {
    fun setToolbarTitle(title: String)
}

fun Fragment.setToolbarTitle(title: String) {
    (activity as? ToolbarHandler)?.setToolbarTitle(title)
}
