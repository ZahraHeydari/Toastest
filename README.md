# Toastest
[![API](https://img.shields.io/badge/API-17%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=17)

This is for customizing toasts!

## Prerequisites

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```

## Dependency

Add this to your module's `build.gradle` file (make sure the version matches the JitPack badge above):

```gradle
dependencies {
	...
	implementation 'com.github.ZahraHeydari:Toastest:1.0.0'
}
```


## Usage

Each method always returns a `Toast` object, so you can customize the Toast with below methods.

This displays a Toast with an icon.

``` kotlin
Toastest.makeToast(context, "This is a toast with an icon.", iconDrawable,Toast.LENGTH_SHORT).show()
```

This displays a Toast with a new background.

``` kotlin
Toastest.makeToast(context, background, "This a toast with a background.", Toast.LENGTH_SHORT).show()
```

This displays a Toast with a new font type.

``` kotlin
Toastest.makeToast(context, "This a toast with a new font type.", TEXT_TYPEFACE, Toast.LENGTH_SHORT).show()
```

This displays a Toast with a new text size.

``` kotlin
Toastest.makeToast(context, "This a toast with a new text size.", TEXT_SIZE, Toast.LENGTH_SHORT).show()
```

And you can create your custom Toasts with the `custom()` method:
``` kotlin
Toastest.custom(context, "This is a fully customized toast.", iconDrawable, backgroundDrawable, TEXT_SIZE, TEXT_TYPEFACE, Toast.LENGTH_SHORT).show()
```

## Author
* ZARA
