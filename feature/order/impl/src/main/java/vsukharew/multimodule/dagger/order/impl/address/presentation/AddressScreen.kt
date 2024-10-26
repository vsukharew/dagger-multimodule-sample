package vsukharew.multimodule.dagger.order.impl.address.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

internal object AddressScreen : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return AddressFragment()
    }
}