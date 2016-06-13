# MaterialDesignUtils

[![Build Status](https://travis-ci.org/FarbodSalamat-Zadeh/MaterialDesignUtils.svg?branch=master)](https://travis-ci.org/FarbodSalamat-Zadeh/MaterialDesignUtils)

A utilities library to help with implementing Material Design guidelines in apps.

## Gradle (Android Studio)
You can add this Android library to your Gradle dependencies.

To do so, add the following to your app module's `build.gradle` file:

```groovy
dependencies {
    ...
    compile 'com.satsuware.lib:mdutils:1.2.0'
}
```

## Converting existing values

You are able to convert existing values (color, for example) in your project to reference the MaterialDesignUtils library.
Here is an example for `colors.xml`:

Before:

```xml
<resources>
    <color name="theme_primary">#F44336</color>
</resources>
```

After:

```xml
<resources>
    <color name="theme_primary">@color/mdu_red_500</color>
</resources>
```

Although you could change these color values one by one, if you have numerous color values and/or want to save time, I would highly recommend looking at the [mdu-file-converter](https://github.com/FarbodSalamat-Zadeh/mdu-file-converter) program I made, which is a Python program you run to automatically convert these values to references to this library.

## Copyright

```
Copyright 2016 Farbod Salamat-Zadeh

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
