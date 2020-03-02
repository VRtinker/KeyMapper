package io.github.sds100.keymapper.util

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import io.github.sds100.keymapper.*
import io.github.sds100.keymapper.SystemAction.CATEGORY_BLUETOOTH
import io.github.sds100.keymapper.SystemAction.CATEGORY_MEDIA
import io.github.sds100.keymapper.SystemAction.CATEGORY_OTHER
import io.github.sds100.keymapper.SystemAction.CATEGORY_VOLUME
import io.github.sds100.keymapper.SystemAction.CATEGORY_WIFI
import io.github.sds100.keymapper.SystemAction.DISABLE_BLUETOOTH
import io.github.sds100.keymapper.SystemAction.DISABLE_WIFI
import io.github.sds100.keymapper.SystemAction.ENABLE_BLUETOOTH
import io.github.sds100.keymapper.SystemAction.ENABLE_WIFI
import io.github.sds100.keymapper.SystemAction.FAST_FORWARD
import io.github.sds100.keymapper.SystemAction.NEXT_TRACK
import io.github.sds100.keymapper.SystemAction.SHOW_POWER_MENU
import io.github.sds100.keymapper.SystemAction.PAUSE_MEDIA
import io.github.sds100.keymapper.SystemAction.PLAY_PAUSE_MEDIA
import io.github.sds100.keymapper.SystemAction.PREVIOUS_TRACK
import io.github.sds100.keymapper.SystemAction.REWIND
import io.github.sds100.keymapper.SystemAction.SCREENSHOT
import io.github.sds100.keymapper.SystemAction.TOGGLE_BLUETOOTH
import io.github.sds100.keymapper.SystemAction.TOGGLE_WIFI
import io.github.sds100.keymapper.util.ErrorCodeUtils.ERROR_CODE_FEATURE_NOT_AVAILABLE
import io.github.sds100.keymapper.util.ErrorCodeUtils.ERROR_CODE_SDK_VERSION_TOO_HIGH
import io.github.sds100.keymapper.util.ErrorCodeUtils.ERROR_CODE_SDK_VERSION_TOO_LOW
import io.github.sds100.keymapper.util.ErrorCodeUtils.ERROR_CODE_SYSTEM_ACTION_NOT_FOUND

/**
 * Created by sds100 on 01/08/2018.
 * Modified by VRTinker in Feb 2018.
 */

object SystemActionUtils {

    /**
     * Maps system action category ids to the string resource of their label
     */
    val CATEGORY_LABEL_MAP = mapOf(
        CATEGORY_WIFI to R.string.system_action_cat_wifi,
        CATEGORY_BLUETOOTH to R.string.system_action_cat_bluetooth,
        CATEGORY_VOLUME to R.string.system_action_cat_volume,
        CATEGORY_MEDIA to R.string.system_action_cat_media,
        CATEGORY_OTHER to R.string.system_action_cat_other
    )

    /**
     * A sorted list of system action definitions
     */
    @SuppressLint("NewApi")
    private val SYSTEM_ACTION_DEFINITIONS = listOf(

        //WIFI
        SystemActionDef(
            id = TOGGLE_WIFI,
            category = CATEGORY_WIFI,
            iconRes = R.drawable.ic_network_wifi_black_24dp,
            descriptionRes = R.string.action_toggle_wifi
        ),
        SystemActionDef(
            id = ENABLE_WIFI,
            category = CATEGORY_WIFI,
            iconRes = R.drawable.ic_network_wifi_black_24dp,
            descriptionRes = R.string.action_enable_wifi
        ),
        SystemActionDef(
            id = DISABLE_WIFI,
            category = CATEGORY_WIFI,
            iconRes = R.drawable.ic_signal_wifi_off_black_24dp,
            descriptionRes = R.string.action_disable_wifi
        ),
        //WIFI

        //BLUETOOTH
        SystemActionDef(
            id = TOGGLE_BLUETOOTH,
            category = CATEGORY_BLUETOOTH,
            iconRes = R.drawable.ic_bluetooth_black_24dp,
            descriptionRes = R.string.action_toggle_bluetooth
        ),
        SystemActionDef(
            id = ENABLE_BLUETOOTH,
            category = CATEGORY_BLUETOOTH,
            iconRes = R.drawable.ic_bluetooth_black_24dp,
            descriptionRes = R.string.action_enable_bluetooth
        ),
        SystemActionDef(
            id = DISABLE_BLUETOOTH,
            category = CATEGORY_BLUETOOTH,
            iconRes = R.drawable.ic_bluetooth_disabled_black_24dp,
            descriptionRes = R.string.action_disable_bluetooth
        ),
        //BLUETOOTH

        //MEDIA
        SystemActionDef(
            id = PLAY_PAUSE_MEDIA,
            category = CATEGORY_MEDIA,
            iconRes = R.drawable.ic_play_pause_24dp,
            descriptionRes = R.string.action_play_pause_media
        ),
        SystemActionDef(
            id = PAUSE_MEDIA,
            category = CATEGORY_MEDIA,
            iconRes = R.drawable.ic_pause_black_24dp,
            descriptionRes = R.string.action_pause_media
        ),
        SystemActionDef(
            id = PLAY_PAUSE_MEDIA,
            category = CATEGORY_MEDIA,
            iconRes = R.drawable.ic_play_arrow_black_24dp,
            descriptionRes = R.string.action_play_media
        ),
        SystemActionDef(
            id = NEXT_TRACK,
            category = CATEGORY_MEDIA,
            iconRes = R.drawable.ic_skip_next_black_24dp,
            descriptionRes = R.string.action_next_track
        ),
        SystemActionDef(
            id = PREVIOUS_TRACK,
            category = CATEGORY_MEDIA,
            iconRes = R.drawable.ic_skip_previous_black_24dp,
            descriptionRes = R.string.action_previous_track
        ),
        SystemActionDef(
            id = FAST_FORWARD,
            category = CATEGORY_MEDIA,
            iconRes = R.drawable.ic_fast_forward_outline,
            descriptionRes = R.string.action_fast_forward,
            messageOnSelection = R.string.action_fast_forward_message
        ),
        SystemActionDef(
            id = REWIND,
            category = CATEGORY_MEDIA,
            iconRes = R.drawable.ic_outline_fast_rewind_24px,
            descriptionRes = R.string.action_rewind,
            messageOnSelection = R.string.action_rewind_message
        ),
        //MEDIA

        //VOLUME
        SystemActionDef(
            id = SystemAction.VOLUME_UP,
            category = CATEGORY_VOLUME,
            iconRes = R.drawable.ic_volume_up_black_24dp,
            descriptionRes = R.string.action_volume_up,
            permissions = arrayOf(Manifest.permission.ACCESS_NOTIFICATION_POLICY)
        ),
        SystemActionDef(
            id = SystemAction.VOLUME_DOWN,
            category = CATEGORY_VOLUME,
            iconRes = R.drawable.ic_volume_down_black_24dp,
            descriptionRes = R.string.action_volume_down,
            permissions = arrayOf(Manifest.permission.ACCESS_NOTIFICATION_POLICY)
        ),

        //VOLUME

        //OTHER
        SystemActionDef(
            id = SCREENSHOT,
            category = CATEGORY_OTHER,
            minApi = Build.VERSION_CODES.P,
            iconRes = R.drawable.ic_screenshot_black_24dp,
            descriptionRes = R.string.action_screenshot
        ),
        SystemActionDef(
            id = SHOW_POWER_MENU,
            category = CATEGORY_OTHER,
            descriptionRes = R.string.action_show_power_menu,
            iconRes = R.drawable.ic_settings_power_black_24dp,
            minApi = Build.VERSION_CODES.LOLLIPOP
        )
    )

    /**
     * Get all the system actions which are supported by the system.
     */
    fun getSupportedSystemActions(ctx: Context) = SYSTEM_ACTION_DEFINITIONS.filter { it.isSupported(ctx) == null }

    fun getUnsupportedSystemActions(ctx: Context) = SYSTEM_ACTION_DEFINITIONS.filter { it.isSupported(ctx) != null }

    fun getUnsupportedSystemActionsWithReasons(ctx: Context) =
        SYSTEM_ACTION_DEFINITIONS.filter { it.isSupported(ctx) != null }.map {
            Pair(it, it.isSupported(ctx))
        }

    fun areAllActionsSupported(ctx: Context) = getUnsupportedSystemActions(ctx).isEmpty()

    /**
     * @return null if the action is supported.
     */
    fun SystemActionDef.isSupported(ctx: Context): ErrorResult? {
        if (Build.VERSION.SDK_INT < minApi) {
            return ErrorResult(
                errorCode = ERROR_CODE_SDK_VERSION_TOO_LOW,
                data = minApi.toString()
            )
        }

        for (feature in features) {
            if (!ctx.packageManager.hasSystemFeature(feature)) {
                return ErrorResult(
                    errorCode = ERROR_CODE_FEATURE_NOT_AVAILABLE,
                    data = feature
                )
            }
        }

        if (Build.VERSION.SDK_INT > maxApi) {
            return ErrorResult(
                errorCode = ERROR_CODE_SDK_VERSION_TOO_HIGH,
                data = maxApi.toString()
            )
        }

        val options = getOptions(ctx)

        if (options.isFailure) {
            if (options.errorResult?.errorCode != ErrorCodeUtils.ERROR_CODE_OPTIONS_NOT_REQUIRED) {
                return options.errorResult
            }
        }

        return null
    }

    fun getSystemActionDef(id: String): Result<SystemActionDef> {
        val systemActionDef = SYSTEM_ACTION_DEFINITIONS.find { it.id == id }

        return systemActionDef.result(ERROR_CODE_SYSTEM_ACTION_NOT_FOUND, id)
    }
}