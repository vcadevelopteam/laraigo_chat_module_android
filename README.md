# Laraigo Chat Module

A laraigo chat module for android native development

## Installation

First download the repository from the github repository. After the download you will have four folders and a Kotlin file, extract it wherever you want.
![folder with the repository downloaded](https://media.discordapp.net/attachments/593247279196930049/1087745810181136404/image.png)

Secondly, you will go to the root of your android project. In this case I will use an empty project. Go to your **gradle.settings** and add this dependencies into **dependencyResolutionManagement**
```gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        ...
        maven {
            url 'route of your extracted respotory (root)'
        }
        maven {
            url "https://storage.googleapis.com/download.flutter.io"
        }
    }
}
```
After that, save the Kotlin file wherever you want inside your app. You will get some reference errors, no problem just add the dependencies to your app **build.gradle**

```python
dependencies {
    ...
    releaseImplementation 'laraigo.app.laraigo_chat_module:flutter_release:1.0'
    debugImplementation 'laraigo.app.laraigo_chat_module:flutter_debug:1.0'
}

```
## Usage
If you want to use the laraigo chat you will need to add the activity to you **AndroidManifest.xml.**.

```xml
    <activity
            android:name="io.flutter.embedding.android.FlutterActivity"
            android:configChanges="orientation|keyboardHidden|keyboard|screenSize|locale|layoutDirection|fontScale|screenLayout|density|uiMode"
            android:hardwareAccelerated="true"
            android:windowSoftInputMode="adjustResize"
            />
```
and use this line of code to initialize the chat wherever and whenever you want.


```kotlin
LaraigoChatSocket().initChatSocket("YOUR INTEGRATION ID",this)
```

or even initialize it with a button
```kotlin
binding!!.btnChatButton.setOnClickListener {
 LaraigoChatSocket().initChatSocket("YOUR INTEGRATION ID",this)
}
```
and

![ff](https://media.discordapp.net/attachments/593247279196930049/1087752300124196954/image.png)
## Contributing

Creditos: [Lino Mac Kay](https://github.com/LinoMacKay) y [Jean Aguirre](https://github.com/jeanmarko2703)
