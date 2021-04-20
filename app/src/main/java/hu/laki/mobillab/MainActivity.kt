package hu.laki.mobillab

import android.os.Bundle
import co.zsmb.rainbowcake.navigation.SimpleNavActivity
import com.google.android.material.appbar.MaterialToolbar
import hu.laki.mobillab.helpers.ToolbarHandler
import hu.laki.mobillab.ui.jokes.JokesFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : SimpleNavActivity(), ToolbarHandler {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            navigator.add(JokesFragment())
        }
    }

    override fun getToolbar(): MaterialToolbar {
        return toolbar
    }

}
