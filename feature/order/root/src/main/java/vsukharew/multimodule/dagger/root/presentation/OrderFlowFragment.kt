package vsukharew.multimodule.dagger.root.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.github.terrakok.cicerone.NavigatorHolder
import vsukharew.multimodule.dagger.core.di.Flow
import vsukharew.multimodule.dagger.core.di.ViewModelFactory
import vsukharew.multimodule.dagger.core.di.provider.DependenciesProvider
import vsukharew.multimodule.dagger.core.di.dependencies.HasDependencies
import vsukharew.multimodule.dagger.core.di.utils.getOrCreateComponent
import vsukharew.multimodule.dagger.core.di.utils.resolveDependency
import vsukharew.multimodule.dagger.core.ui.BaseFlowFragment
import vsukharew.multimodule.dagger.order.impl.R
import vsukharew.multimodule.dagger.order.impl.databinding.FragmentOrderFlowBinding
import vsukharew.multimodule.dagger.root.di.provider.OrderFlowDependenciesProvider
import vsukharew.multimodule.dagger.root.di.component.OrderFlowScreenComponent
import javax.inject.Inject

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
internal class OrderFlowFragment : BaseFlowFragment(R.layout.fragment_order_flow), HasDependencies {

    private var _binding: FragmentOrderFlowBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<OrderFlowViewModel> {
        ViewModelFactory(this) { savedStateHandle ->
            factory.create(savedStateHandle)
        }
    }
    private val component by lazy {
        getOrCreateComponent { OrderFlowScreenComponent.build(resolveDependency()) }
    }

    @Inject
    lateinit var factory: OrderFlowViewModel.Factory

    @Inject
    @Flow
    override lateinit var navigatorHolder: NavigatorHolder
    override val containerId: Int = R.id.order_flow_container_id
    override val dependenciesProvider: DependenciesProvider by lazy {
        OrderFlowDependenciesProvider(component)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component.inject(this)
        savedInstanceState ?: viewModel.startFlow()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOrderFlowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        OrderFlowScreenComponent.release(this)
    }
}