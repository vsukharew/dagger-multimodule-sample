package vsukharew.multimodule.sample

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import vsukharew.multimodule.dagger.calendar.impl.di.component.CalendarApiComponent
import vsukharew.multimodule.dagger.core.di.component.DaggerCoreComponent
import vsukharew.multimodule.dagger.core.di.utils.getOrCreateComponent

class CalendarSampleActivity : AppCompatActivity() {
    private val navigator: Navigator = AppNavigator(this, R.id.main)
    private var navigatorHolder: NavigatorHolder? = null
    private val component by lazy {
         getOrCreateComponent { DaggerCoreComponent.create() }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calendar_sample)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        navigatorHolder = component.navigatorHolder()
        component.router()
            .let(CalendarApiComponent::build)
            .calendarRouter()
            .navigateToCalendar()
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder?.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder?.removeNavigator()
    }
}