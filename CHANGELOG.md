# Changelog 

All notable changes to this project will be documented in this file. This project adheres to semantic versioning.

## [1.1.7-ReconQuest](https://github.com/VRtinker/KeyMapper/releases/tag/1.1.7-ReconQuest)
#### Mar 2020

### Removed
- Every UI reference to functions that require ROOT
- Every UI reference to functions that require WRITE_SECURE
- Every UI reference and code to functions that require the use of the IME Keyboard (the keyboard picker does not render on the Oculus Quest)
- Every UI reference to KEY, KEYCODE and TEXT functions that do not work on the Oculus Quest
- Every UI reference and code to shortcuts in "Other" that do not work on the Oculus Quest
- Every UI reference to functions in the Settings Menu that do not work on the Oculus Quest
- Keyboard Picker shortcut
- 1 slide from the stock Intro activity

### Added
- 6 extra slides to the Intro activity
- extra icon assets
- extra colors

### Changes
- Modified IntroActivity.kt to include a list of slides that launches every app requiring initial setup to complete ReconQuest's Post-Install process
- Heavily modified strings.xml to account for removed/added functions and reworded a lot of existing text
- Changed default values for any feature relevant to the Oculus Quest
- 2 slides from the Intro activity were repurposed

## [Unreleased](https://github.com/sds100/KeyMapper/tree/develop)

## [1.1.7](https://github.com/sds100/KeyMapper/releases/tag/v1.1.7)
#### 07 Jan 2020

### Bug Fixes
- KEYCODE_BACK appeared twice in the keycode list.
- crashed when the battery optimisation settings couldn't be found.
- some trigger keys have no name.
- unable to uncheck the "show volume dialog" flag.
- on some devices (e.g Oxygen OS 10),  the volume buttons up keyevents need to be consumed to stop them from changing the volume when performing an action.
- couldn't necessarily press the back button to get back to Key Mapper when opening the accessibility settings.

### Added
- support for Jelly Bean 4.2 and 4.3.
- setting to show the toast message when an action fails to perform.
- action to open the device settings.
- action to open a URL.
- action to switch the input method (ROOT only)
- action to show the power dialog (Android 5.0+)
- action to lock the device without root (only Android 9.0+)
- action to toggle split screen (Android 7.0+)

### Changes
- Removed Firebase.

## [1.1.6](https://github.com/sds100/KeyMapper/releases/tag/v1.1.6)
#### 03 Nov 2019

F-Droid can now build.

## [1.1.5](https://github.com/sds100/KeyMapper/releases/tag/v1.1.5)
#### 03 Nov 2019
This is the first release to be released on F-Droid.

### Removed
- Firebase library.

### Bug Fix
- KEYCODE_BACK appeared twice in the keycode action list. #247 

## [1.1.4](https://github.com/sds100/KeyMapper/releases/tag/v1.1.4)
#### 22 Aug 2019
### Bug Fixes
- App crashed when opening the choose action activity on KitKat devices.

## [1.1.3](https://github.com/sds100/KeyMapper/releases/tag/v1.1.3)
#### 20 Aug 2019
### Bug Fixes
- App crashed after updating.

## [1.1.2](https://github.com/sds100/KeyMapper/releases/tag/v1.1.2)
#### 19 Aug 2019
### Bug Fixes
- Make all slides in the intro activity scrollable so the content can be displayed on smaller devices
- Remapping the recents button would still open recents
- Crash when the app was rotated in the "choose action" activity
- Triggers are ignored when another trigger is being detected.

### Added
- Action to show the keyboard picker
- Guide the user to grant WRITE_SECURE_SETTINGS for the app so features previously restricted to rooted devices can be used on all devices.
- Slide to enable Do Not Disturb in the intro activity.

### Changed
- Rename strings for the keyboard picker notification
- Use unique keyboard names for CI and debug builds.

## [1.1.1](https://github.com/sds100/KeyMapper/releases/tag/v1.1.1)
#### 27 July 2019
Exact same as 1.1.0 besides the version code and name. I messed up the versioning on Google play so had to increment the version code.

## [1.1.0](https://github.com/sds100/KeyMapper/releases/tag/v1.1.0)
#### 27 July 2019

The initial release for Key Mapper.

Changes from 1.1.0 Beta 8:
- Moved the dialog to opt in to analytics to a slide in the intro activity.

## [1.1.0 Beta 8](https://github.com/sds100/KeyMapper/releases/tag/v1.1.0-beta.8)
#### 20 July 2019
### Bug Fixes
- Changes to a keymap wouldn't persist after a configuration change (e.g rotation)
- The keyboard service status layout at the top of the homescreen wouldn't update.
- fix minor inconsistencies in the app icons

### Changed
- The action to simulate the menu button no longer requires root
- Use a countdown timer when recording a trigger
- Support Android Q

### Added
- Show an error on the homescreen and if an action needs the Key Mapper keyboard to be enabled.
- Show an error when trying to use an action which requires the Key Mapper keyboard and it is disabled.
- Action to move the cursor to the end of a file
- Actions to toggle, show and hide the keyboard
- Button to change the keyboard in the homescreen menu
- About: link to the Telegram channel
- Show a prompt to enable the accessibility service when the app is first opened.
- Explain why the "record trigger" button is greyed out
- labels for the KEYCODE_BUTTON_START and KEYCODE_BUTTON_SELECT keycodes
- An introduction activity the first time the app is opened
- Logger: log when recording a trigger has started and stopped
- Show a dialog the first time the Key Mapper keyboard is chosen explaining why another keyboard can't be used.
- ChooseActionActivity: A tab to which lists all the actions which aren't supported and why.
- Show a "requires root" message for actions which need it

## [1.1.0 Beta 7](https://github.com/sds100/KeyMapper/releases/tag/v1.1.0-beta.7)
#### 27 May 2019
### Bug Fixes
- App would crash when trying to read a system setting which doesn't exist
- App would crash if couldn't find the Do Not Disturb settings page
- Logger: send icon was grey but should be white 

### Added
- The status card at the top of the homescreen can now be expanded and collapsed
- Show a toast message when a foreseen error is encountered
- Logger: log whenever the accessibility service is started/stopped

## [1.1.0 Beta 6](https://github.com/sds100/KeyMapper/releases/tag/v1.1.0-beta.6)
#### 19 May 2019
### Bug Fixes
 - Don't show NFC actions on devices without NFC
 - Couldn't change volume when short pressing a volume button remapped to a long press action

## [1.1.0 Beta 5](https://github.com/sds100/KeyMapper/releases/tag/v1.1.0-beta.5)
#### 19 May 2019
 - Updated libraries
### Added
 - Action to enable, disable and toggle NFC.
 - Action to switch between portrait and landscape mode.
 - Action to cycle through and change the ringer mode.
 - Action to fast forward and rewind.
 - Option to log events and send them to the developer so it is easier to debug issues with the app.
 - Button to Help page on homescreen.
 - Translation instuctions to the About activity.
 
### Changes
 - Add the trigger after the 5 seconds rather than having to press the button so the app can work with devices which only have remotes as input.
 - Cleanup Settings strings.
 - Use slightly darker homescreen background.
 - Don't show the "Key mapper is performing an action" toast message by default.
 - Allow the volume to be changed while in Do Not Disturb mode.
 - Minimum vibration duration is 1ms rather than 100ms
 
### Bug Fixes
- The landscape mode action wouldn't work.
- Would potentially crash when trying to open the write-settings permission page.
- Don't show a toast message when enabling/disabling the device admin.
- Would crash when selecting a shortcut without the correct permissions.
- Device would go to the homescreen when using a trigger with the home button in it.

## [1.1.0 Beta 4](https://github.com/sds100/KeyMapper/releases/tag/v1.1.0-beta.4)
#### 10 Apr 2019
### Added
- Option to choose which flash to use for flashlight actions
- Optimised the New and Edit Keymap activities for various screen sizes
- Slightly optimised the homescreen for wide screens

### Bug Fixes
- Could potentially crash when trying to switch to the Key Mapper input method
- Could potentially crash when removing a trigger from the list
- Would crash if it couldn't find the input method settings page
- Would crash when trying to change a specific volume stream while the device is in a Do Not Disturb state
- Would crash when using an app shortcut without the correct permissions.

## [1.1.0 Beta 3](https://github.com/sds100/KeyMapper/releases/tag/v1.1.0-beta.3)
#### 4 Apr 2019
- Reduced the repeat delay to 5ms
- Force expand the menu on the homescreen
- Made the cards on the homescreen slightly more compact

### Added
- Flag to vibrate and an option to force vibrate for all actions
- Action which just consumes the keyevent and does nothing
- Action to lock the device (ROOT only for now) and an option to lock the device securely (without root).

### Bug fixes
- The bottom app bar on the homescreen would overlap the list items
- The app would potentially crash when trying to perform a flashlight action whilst the camera is in use in another app.
- Short press actions with the same trigger as a long press action would be performed with the long press action
- A keymap would still have the "Show volume dialog" flag if the action is changed to a non volume related action
- The app would crash if trying to show the menu on the homescreen if it is already showing.
- The accessibility service status on the homescreen wouldn't change when the service is started/stopped.

## [1.1.0 Beta 2](https://github.com/sds100/KeyMapper/releases/tag/v1.1.0-beta.2)
#### 31 Mar 2019
- Won't immediately crash on KitKat anymore! :)

### Bug fixes
- Persistent IME notification wouldn't automatically show when it is enabled.
- App would crash if it couldn't find the device's accessibility settings page.

## [1.1.0 Beta 1](https://github.com/sds100/KeyMapper/releases/tag/v1.1.0-beta.1)
#### 27 Mar 2019
### Added
- Setting to change the long-press delay.
- Persistent notification which can pause/resume your remaps. It can also open the accessibility settings on the device to enable/disable the service. Rooted devices can start/stop the accessibility service without going into settings and just tap the notification.
- Use Material Design 2 for homescreen.

### Bug fixes
- Persistent notifications wouldn't show on boot
- The app would crash if using the "open google assistant" action if the Google app wasn't installed.
- Prevent the accessibility service from stopping if there is a fatal exception and show a toast when it happens.


## [1.0.0 Beta 6](https://github.com/sds100/KeyMapper/releases/tag/v1.0.0-beta.6)
#### 22 Mar 2019
- Changed developer email.
- Added link to the XDA Thread in the About activity.

## [1.0.0 Beta 5](https://github.com/sds100/KeyMapper/releases/tag/v1.0.0-beta.5)
#### 22 Mar 2019
- Updated build-tools to 28.0.4
- Updated Room library to 2.1.0-alpha05
- Updated Firebase core library to 16.0.8

#### Bug fixes
- App would crash when using brightness actions because it needed write system settings permission.

## [1.0.0 Beta 4](https://github.com/sds100/KeyMapper/releases/tag/v1.0.0-beta.4)
#### 9 Mar 2019
- Added more labels for keys.
- Added a link to the app in the device's Accessibility settings.
- Updated the Gradle version to 3.3.2
- When the long-press flag is chosen, show a warning saying it will only work properly for volume and navigation buttons.
- Enable the show-volume-ui flag by default.

#### Bug fixes
- App would crash when choosing flags for a keymap without an action.
- Buttons being repeatedly pressed.
- Enabling the long-press flag would stop the button from working when it is pressed without a long press. 

## Accidentally skipped Beta 3 release. Oops.

## [1.0.0 Beta 2](https://github.com/sds100/KeyMapper/releases/tag/v1.0.0-beta.2)
#### 2 Mar 2019
- added option to email developer in the About activity.
- created privacy policy and ability to opt in/out of Firebase analytics

## [1.0.0 Beta 1](https://github.com/sds100/KeyMapper/releases/tag/v1.0.0-beta.1)
#### 2 Mar 2019
- Initial release!
- Option to automatically change the input method and/or show the input method picker when a chosen Bluetooth device is connected and switch back to the old one when disconnected
- Option to show a notification, which when clicked on, will show the input method picker. Android 8.1+ needs root.
- Option to show a toast message whenever an action is performed.
- A Help activity
- An About activity
- No limit on the amount of triggers for a keymap and how many keys can be used to create a trigger.
- Optional flags for each keymap so it can only be triggered on a long press and whether to show the volume dialog for volume related actions.
- Ability to enable/disable specific/all keymaps.

   #### Added these actions
   - Open App
   - Open App shortcut
   - A keycode
   - A key
   - A block of text
   
   - Go back
   - Go home
   - Open recents
   - Open menu
   
   - Expand notification drawer
   - Expand quick settings
   - Collapse status bar
   
   - Toggle/enable/disable WiFi  
   - Toggle/enable/disable Bluetooth
   - Toggle/enable/disable mobile data
   
   - Toggle Play/pause media
   - Pause,play media
   - Next/previous track
   
   - Volume up/down
   - Increase/decrease a specific volume stream
   - Show the volume dialog
   - Mute/unmute/toggle mute
   
   - Toggle/enable/disable auto-rotate
   - Force portrait/landscape mode
   
   - Toggle/enable/disable auto-brightness
   - Increase/decrease brightness
   
   - Toggle/enable/disable flashlight
   
   - Screenshot
   - Open Google Assistant
   - Open camera
