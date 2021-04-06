package hu.laki.mobillab

import android.os.Bundle
import co.zsmb.rainbowcake.navigation.SimpleNavActivity
import hu.laki.mobillab.ui.jokes.JokesFragment

class MainActivity : SimpleNavActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            navigator.add(JokesFragment())
        }
    }

}
