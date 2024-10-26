package vsukharew.multimodule.dagger.order.impl.address.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import vsukharew.multimodule.dagger.core.di.ViewModelFactory
import vsukharew.multimodule.dagger.core.di.utils.getOrCreateComponent
import vsukharew.multimodule.dagger.order.impl.R
import vsukharew.multimodule.dagger.order.impl.address.di.AddressScreenComponent
import vsukharew.multimodule.dagger.order.impl.databinding.FragmentAddressBinding
import javax.inject.Inject

internal class AddressFragment : Fragment(R.layout.fragment_address) {
    private val component by lazy {
        getOrCreateComponent { AddressScreenComponent.build(this) }
    }
    private var _binding: FragmentAddressBinding? = null
    private val binding
        get() = _binding!!

    @Inject
    lateinit var factory: AddressViewModel.Factory

    private val viewModel by viewModels<AddressViewModel> {
        ViewModelFactory(this) {
            component.run {
                factory.create(
                    addressScreenExternalDependencies().calendarFeatureApi(),
                    addressScreenInternalDependencies().globalRouter(),
                    addressScreenInternalDependencies().flowRouter(),
                    it
                )
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddressBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback(
            viewLifecycleOwner,
            onBackPressed = { viewModel.back() })

        binding.apply {
            createOrder.setOnClickListener {
                viewModel.createOrder()
            }
            openCalendar.setOnClickListener {
                viewModel.openCalendar()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        AddressScreenComponent.release(this)
    }
}