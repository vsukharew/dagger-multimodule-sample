package vsukharew.multimodule.dagger.core.ui

import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator

abstract class BaseFlowFragment(@LayoutRes layoutResId: Int) :
    Fragment(layoutResId) {

    @get:IdRes
    protected abstract val containerId: Int
    protected abstract val navigatorHolder: NavigatorHolder

    private val navigator by lazy {
        AppNavigator(requireActivity(), containerId, childFragmentManager)
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }
}