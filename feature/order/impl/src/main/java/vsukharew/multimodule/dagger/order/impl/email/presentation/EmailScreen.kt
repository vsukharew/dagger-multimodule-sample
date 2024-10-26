package vsukharew.multimodule.dagger.order.impl.email.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

internal object EmailScreen : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return EmailFragment()
    }
}
