package vsukharew.multimodule.dagger.order.impl.email.presentation

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
import vsukharew.multimodule.dagger.order.impl.databinding.FragmentEmailBinding
import vsukharew.multimodule.dagger.order.impl.email.di.EmailScreenComponent
import javax.inject.Inject

internal class EmailFragment : Fragment(R.layout.fragment_email) {

    private val component by lazy { getOrCreateComponent { EmailScreenComponent.build(this) } }
    private var _binding: FragmentEmailBinding? = null
    private val binding
        get() = _binding!!

    @Inject
    lateinit var factory: EmailViewModel.Factory

    private val viewModel by viewModels<EmailViewModel> {
        ViewModelFactory(this) {
            factory.create(
                component.dependencies().flowRouter(),
                it
            )
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
        _binding = FragmentEmailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback(
            viewLifecycleOwner,
            onBackPressed = { viewModel.back() })
        binding.apply {
            next.setOnClickListener {
                viewModel.next()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        EmailScreenComponent.release(this)
    }
}