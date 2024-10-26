package vsukharew.multimodule.dagger

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.google.android.material.snackbar.Snackbar

import vsukharew.multimodule.dagger.core.di.utils.getOrCreateComponent
import vsukharew.multimodule.dagger.databinding.ActivityMainBinding
import vsukharew.multimodule.main_menu.presentation.MainMenuScreen
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val navigator: Navigator = AppNavigator(this, R.id.main_container)

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var navigatorHolder: NavigatorHolder
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        getOrCreateComponent { MainComponent.build(this) }.inject(this)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        savedInstanceState ?: router.replaceScreen(MainMenuScreen())
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun onDestroy() {
        super.onDestroy()
        MainComponent.release(this)
    }
}