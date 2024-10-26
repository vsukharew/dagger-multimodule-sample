package vsukharew.multimodule.main_menu.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

class MainMenuScreen : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return MainMenuFragment()
    }
}