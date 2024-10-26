package vsukharew.multimodule.dagger.order.impl.flow.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

internal class OrderFlowScreen : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return OrderFlowFragment()
    }
}