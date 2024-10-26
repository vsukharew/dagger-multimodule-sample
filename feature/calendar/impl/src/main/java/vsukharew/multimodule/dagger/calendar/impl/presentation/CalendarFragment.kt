package vsukharew.multimodule.dagger.calendar.impl.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import vsukharew.multimodule.calendar.impl.R
import vsukharew.multimodule.calendar.impl.databinding.FragmentCalendarBinding
import vsukharew.multimodule.dagger.calendar.impl.di.component.CalendarScreenComponent
import vsukharew.multimodule.dagger.core.di.ViewModelFactory
import vsukharew.multimodule.dagger.core.di.utils.getOrCreateComponent
import javax.inject.Inject

internal class CalendarFragment : Fragment(R.layout.fragment_calendar) {

    private var _binding: FragmentCalendarBinding? = null
    private val binding
        get() = _binding!!

    private val viewModel by viewModels<CalendarViewModel> {
        ViewModelFactory(this) { factory.create(it) }
    }

    @Inject
    lateinit var factory: CalendarViewModel.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getOrCreateComponent { CalendarScreenComponent.build(this) }.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCalendarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback(
            viewLifecycleOwner,
            onBackPressed = { viewModel.back() }
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        CalendarScreenComponent.release(this)
    }
}