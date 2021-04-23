package hu.laki.mobillab.helpers

import androidx.fragment.app.Fragment
import co.zsmb.rainbowcake.navigation.navigator
import com.google.android.material.appbar.MaterialToolbar
import hu.laki.mobillab.R

interface ToolbarHandler {
    fun getToolbar(): MaterialToolbar
}

fun Fragment.setToolbarTitle(title: String, pop: Boolean = false) {
    (activity as? ToolbarHandler)?.getToolbar()?.setTitle(title)

    if (pop) {
        (activity as? ToolbarHandler)?.getToolbar()?.setNavigationIcon(R.drawable.ic_arrow_back)
        (activity as? ToolbarHandler)?.getToolbar()?.setNavigationOnClickListener { navigator?.pop() }
    } else {
        (activity as? ToolbarHandler)?.getToolbar()?.setNavigationIcon(null)
    }
}

