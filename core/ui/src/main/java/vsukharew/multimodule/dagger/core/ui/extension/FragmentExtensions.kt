package vsukharew.multimodule.dagger.core.ui.extension

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment

val Fragment.allParents: Sequence<Any>
    get() {
        return generateSequence(parentFragment ?: activity ?: context?.applicationContext) {
            when {
                it is Fragment && it.parentFragment != null -> it.parentFragment
                it is Fragment -> it.activity ?: it.context
                it is Activity -> it.application
                it is Application -> null
                else -> null
            }
        }
    }