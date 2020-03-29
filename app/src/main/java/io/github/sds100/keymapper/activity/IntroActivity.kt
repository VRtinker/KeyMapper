package io.github.sds100.keymapper.activity

import android.Manifest
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.PowerManager
import android.provider.Settings
import androidx.annotation.RequiresApi
import com.heinrichreimersoftware.materialintro.app.IntroActivity
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide
import com.heinrichreimersoftware.materialintro.slide.Slide
import io.github.sds100.keymapper.Constants
import io.github.sds100.keymapper.R
import io.github.sds100.keymapper.util.PermissionUtils
import io.github.sds100.keymapper.util.isPermissionGranted
import org.jetbrains.anko.longToast


/**
 * Created by sds100 on 07/07/2019.
 * Modified by VRTinker in Feb 2020.
 */

@RequiresApi(Build.VERSION_CODES.M)
class IntroActivity : IntroActivity() {

    companion object {
        const val REQUEST_CODE_INTRO = 123
    }

    private val mReconQuestPostInstall by lazy {
        SimpleSlide.Builder().apply {
            title(R.string.showcase_ReconQuestPostInstall_title)
            description(R.string.showcase_ReconQuestPostInstall_message)
            background(R.color.purple)
            backgroundDark(R.color.purpleDark)
            image(R.drawable.reconquest)
            canGoBackward(true)
            scrollable(true)
        }.build()
    }
    private val mLaunchAutoLaunch by lazy {
        SimpleSlide.Builder().apply {
            title(R.string.showcase_launch_AutoLaunch_title)
            description(R.string.showcase_launch_AutoLaunch_message)
            background(R.color.autolaunch)
            backgroundDark(R.color.autolaunchDark)
            image(R.drawable.autolaunch)
            canGoBackward(true)
            scrollable(true)

            buttonCtaLabel(R.string.showcase_launch_AutoLaunch_button)
            buttonCtaClickListener {
                val launchIntent = packageManager.getLaunchIntentForPackage("com.joaomgcd.autoapps")
                startActivity(launchIntent)
            }
        }.build()
    }

    private val mLaunchAutoTools by lazy {
        SimpleSlide.Builder().apply {
            title(R.string.showcase_launch_AutoTools_title)
            description(R.string.showcase_launch_AutoTools_message)
            background(R.color.autotools)
            backgroundDark(R.color.autotoolsDark)
            image(R.drawable.autotools)
            canGoBackward(true)
            scrollable(true)

            buttonCtaLabel(R.string.showcase_launch_AutoTools_button)
            buttonCtaClickListener {
                val launchIntent = packageManager.getLaunchIntentForPackage("com.joaomgcd.autotools")
                startActivity(launchIntent)
            }
        }.build()
    }

    private val mLaunchAutoToolsSecureSettings by lazy {
        SimpleSlide.Builder().apply {
            title(R.string.showcase_launch_AutoToolsSecureSettings_title)
            description(R.string.showcase_launch_AutoToolsSecureSettings_message)
            background(R.color.autotoolsSecureSettings)
            backgroundDark(R.color.autotoolsSecureSettingsDark)
            image(R.drawable.autotools)
            canGoBackward(true)
            scrollable(true)

            buttonCtaLabel(R.string.showcase_launch_AutoToolsSecureSettings_button)
            buttonCtaClickListener {
                val settingsIntent = Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS, Uri.parse("package:com.joaomgcd.autotools"))
                startActivity(settingsIntent)
            }
        }.build()
    }




    private val mLaunchTasker by lazy {
        SimpleSlide.Builder().apply {
            title(R.string.showcase_launch_Tasker_title)
            description(R.string.showcase_launch_Tasker_message)
            background(R.color.tasker)
            backgroundDark(R.color.taskerDark)
            image(R.drawable.tasker)
            canGoBackward(true)
            scrollable(true)

            buttonCtaLabel(R.string.showcase_launch_Tasker_button)
            buttonCtaClickListener {
                val launchIntent = packageManager.getLaunchIntentForPackage("net.dinglisch.android.taskerm")
                startActivity(launchIntent)
            }
        }.build()
    }

    private val mLaunchRemoteLauncher by lazy {
        SimpleSlide.Builder().apply {
            title(R.string.showcase_launch_RemoteLauncherFree_title)
            description(R.string.showcase_launch_RemoteLauncherFree_message)
            background(R.color.remotelauncher)
            backgroundDark(R.color.remotelauncherDark)
            image(R.drawable.remotelauncher)
            canGoBackward(true)
            scrollable(true)

            buttonCtaLabel(R.string.showcase_launch_RemoteLauncherFree_button)
            buttonCtaClickListener {
                val launchIntent = packageManager.getLaunchIntentForPackage("com.owtroid.remotelauncherfree")
                startActivity(launchIntent)
            }
        }.build()
    }

    private val mLaunchSecureTask by lazy {
        SimpleSlide.Builder().apply {
            title(R.string.showcase_launch_SecureTask_title)
            description(R.string.showcase_launch_SecureTask_message)
            background(R.color.securetask)
            backgroundDark(R.color.securetaskDark)
            image(R.drawable.securetask)
            canGoBackward(true)
            scrollable(true)

            buttonCtaLabel(R.string.showcase_launch_SecureTask_button)
            buttonCtaClickListener {
                val launchIntent = packageManager.getLaunchIntentForPackage("com.balda.securetask")
                startActivity(launchIntent)
            }
        }.build()
    }

    private val mNoteFromDevSlide by lazy {
        SimpleSlide.Builder().apply {
            title(R.string.showcase_note_from_the_developer_title)
            description(R.string.showcase_note_from_the_developer_message)
            background(R.color.red)
            backgroundDark(R.color.redDark)
            image(R.drawable.ic_launcher_foreground)
            canGoBackward(true)
            scrollable(true)
        }.build()
    }

    private val mEnableAccesssibilityServiceSlide by lazy {
        SimpleSlide.Builder().apply {
            title(R.string.showcase_enable_accessibility_service_title)
            description(R.string.showcase_enable_accessibility_service_message)
            background(R.color.blue)
            backgroundDark(R.color.blueDark)
            image(R.drawable.ic_accessibility)
            canGoBackward(true)
            scrollable(true)

            buttonCtaLabel(R.string.showcase_enable_accessibility_service_button)
            buttonCtaClickListener {
                val settingsIntent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)

                settingsIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                        or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        or Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS)

                startActivity(settingsIntent)
            }



        }.build()
    }

    private val mDndAccessSlide: Slide by lazy {
        SimpleSlide.Builder().apply {
            title(R.string.showcase_dnd_access_title)
            description(R.string.showcase_dnd_access_description)
            background(R.color.red)
            backgroundDark(R.color.redDark)
            image(R.drawable.ic_do_not_disturb_white_64dp)
            canGoBackward(true)
            scrollable(true)

            buttonCtaLabel(R.string.pos_grant)
            buttonCtaClickListener {
                PermissionUtils.requestPermission(this@IntroActivity, Manifest.permission.ACCESS_NOTIFICATION_POLICY)
            }
        }.build()
    }

    private val currentSlide: Slide
        get() = getSlide(currentSlidePosition)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        isSkipEnabled = false

        addSlide(mReconQuestPostInstall)

        addSlide(mLaunchAutoLaunch)

        addSlide(mLaunchAutoTools)

        addSlide(mLaunchAutoToolsSecureSettings)

        addSlide(mLaunchTasker)

        addSlide(mLaunchRemoteLauncher)

        addSlide(mLaunchSecureTask)

        addSlide(mNoteFromDevSlide)

        addSlide(mEnableAccesssibilityServiceSlide)

        addSlide(mDndAccessSlide)

    }

    override fun onResume() {
        super.onResume()

        if (isPermissionGranted(Manifest.permission.ACCESS_NOTIFICATION_POLICY) && currentSlide == mDndAccessSlide) {
            nextSlide()
            removeSlide(mDndAccessSlide)
        }
    }
}