package io.github.sds100.keymapper.fragment

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.preference.*
import io.github.sds100.keymapper.R
import io.github.sds100.keymapper.WidgetsManager
import io.github.sds100.keymapper.service.MyAccessibilityService
import io.github.sds100.keymapper.util.BluetoothUtils
import io.github.sds100.keymapper.util.NotificationUtils
import org.jetbrains.anko.alert
import org.jetbrains.anko.defaultSharedPreferences
import org.jetbrains.anko.okButton

class SettingsFragment : PreferenceFragmentCompat(),
    Preference.OnPreferenceChangeListener,
    SharedPreferences.OnSharedPreferenceChangeListener {

    private val mBluetoothDevicesPreferences by lazy {
        findPreference<MultiSelectListPreference>(getString(R.string.key_pref_bluetooth_devices))!!
    }

    private val mAutoShowIMEDialogPreference by lazy {
        findPreference<SwitchPreference>(getString(R.string.key_pref_auto_show_ime_picker))!!
    }

    private var mShowingNoPairedDevicesDialog = false

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.preferences)

        mBluetoothDevicesPreferences.setOnPreferenceClickListener {
            populateBluetoothDevicesPreference()

            //if there are no bluetooth device entries, explain to the user why
            if (mBluetoothDevicesPreferences.entries.isEmpty()) {

                /* This awkward way of showing the "can't find any paired devices" dialog
                 * with a CancellableMultiSelectPreference is necessary since you can't
                 * cancel showing the dialog once the preference has been clicked.*/

                if (!mShowingNoPairedDevicesDialog) {
                    mShowingNoPairedDevicesDialog = true

                    context!!.alert {
                        title = getString(R.string.dialog_title_cant_find_paired_devices)
                        message = getString(R.string.dialog_message_cant_find_paired_devices)
                        okButton { dialog ->
                            mShowingNoPairedDevicesDialog = false
                            dialog.dismiss()
                        }

                        //if the dialog is closed by clicking outside the dialog
                        onCancelled { mShowingNoPairedDevicesDialog = false }
                    }.show()
                }

                return@setOnPreferenceClickListener false
            }

            true
        }

        mAutoShowIMEDialogPreference.onPreferenceChangeListener = this

        context!!.defaultSharedPreferences.registerOnSharedPreferenceChangeListener(this)
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        onPreferenceChange(
            findPreference(key!!),
            //Use .all[index] because we don't know the data type
            sharedPreferences!!.all[key]
        )
    }

    override fun onPreferenceChange(preference: Preference?, newValue: Any?): Boolean {
        when (preference) {


        }

        return true
    }


    override fun onDestroy() {
        super.onDestroy()

        context!!.defaultSharedPreferences.unregisterOnSharedPreferenceChangeListener(this)
    }

    private fun populateBluetoothDevicesPreference() {
        val pairedDevices = BluetoothUtils.getPairedDevices()

        if (pairedDevices != null) {
            //the user will see the names of the devices
            mBluetoothDevicesPreferences.entries = pairedDevices.map { it.name }.toTypedArray()

            //the unique addresses of the device will be saved to shared preferences
            mBluetoothDevicesPreferences.entryValues =
                pairedDevices.map { it.address }.toTypedArray()
        }
    }

}