package com.example.pillreminder.storage

import android.content.Context
import android.content.SharedPreferences
import com.example.pillreminder.util.PreferenceKeys
import javax.inject.Inject

class GlobalPreferences @Inject constructor(private val context: Context) {
    lateinit var preferences: SharedPreferences

    var token: String?
        get() = preferences.getString(PreferenceKeys.TOKEN, null)
        set(value) = preferences.edit().putString(PreferenceKeys.TOKEN, value).apply()
}