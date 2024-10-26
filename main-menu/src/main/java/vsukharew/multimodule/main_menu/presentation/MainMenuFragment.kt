package vsukharew.multimodule.main_menu.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import vsukharew.multimodule.dagger.core.di.ViewModelFactory
import vsukharew.multimodule.dagger.core.di.utils.getOrCreateComponent
import vsukharew.multimodule.main_menu.R
import vsukharew.multimodule.main_menu.databinding.FragmentMainMenuBinding
import vsukharew.multimodule.main_menu.di.MainMenuComponent
import javax.inject.Inject

class MainMenuFragment : Fragment(R.layout.fragment_main_menu) {

    private var _binding: FragmentMainMenuBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var factory: MainMenuViewModel.Factory

    private val viewModel by viewModels<MainMenuViewModel> {
        ViewModelFactory(this) { factory.create(it) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getOrCreateComponent { MainMenuComponent.build(this) }.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            registration.setOnClickListener {
                viewModel.order()
            }
            calendar.setOnClickListener {
                viewModel.calendar()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        MainMenuComponent.release(this)
    }
}