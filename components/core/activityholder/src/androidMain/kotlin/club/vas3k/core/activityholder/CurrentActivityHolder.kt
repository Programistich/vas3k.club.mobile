package club.vas3k.core.activityholder

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.os.Bundle
import java.lang.ref.WeakReference

object CurrentActivityHolder : Application.ActivityLifecycleCallbacks {
    private var currentActivity = WeakReference<Activity>(null)

    fun register(application: Application) {
        application.registerActivityLifecycleCallbacks(this)
    }

    fun getCurrentActivity(): Activity? = club.vas3k.core.activityholder.CurrentActivityHolder.currentActivity.get()

    override fun onActivityResumed(activity: Activity) {
        club.vas3k.core.activityholder.CurrentActivityHolder.currentActivity = WeakReference(activity)
    }

    // Unused fun
    override fun onActivityStarted(activity: Activity) = Unit
    override fun onActivityPaused(activity: Activity) = Unit
    override fun onActivityStopped(activity: Activity) = Unit
    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) = Unit
    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) = Unit
    override fun onActivityDestroyed(activity: Activity) = Unit
}

fun club.vas3k.core.activityholder.CurrentActivityHolder.startActivity(intent: Intent, fallback: Context) {
    var contextForLaunch: Context? =
        club.vas3k.core.activityholder.CurrentActivityHolder.getCurrentActivity()
    if (contextForLaunch == null) {
        contextForLaunch = fallback
        intent.setFlags(FLAG_ACTIVITY_NEW_TASK)
    }
    contextForLaunch.startActivity(intent)
}
