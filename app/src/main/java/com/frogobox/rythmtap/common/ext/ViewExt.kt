package com.frogobox.rythmtap.common.ext

import android.content.Context
import android.os.Vibrator
import android.view.View
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by Faisal Amir on 24/10/22
 * -----------------------------------------
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) Frogobox ID / amirisback
 * All rights reserved
 */


fun vibrate(context: Context, power: Long) {
    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
        val vibratorManager = context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as? android.os.VibratorManager
        vibratorManager?.defaultVibrator?.vibrate(android.os.VibrationEffect.createOneShot(power, android.os.VibrationEffect.DEFAULT_AMPLITUDE))
    } else if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
        val v = context.getSystemService(Context.VIBRATOR_SERVICE) as? Vibrator
        v?.vibrate(android.os.VibrationEffect.createOneShot(power, android.os.VibrationEffect.DEFAULT_AMPLITUDE))
    } else {
        val v = context.getSystemService(Context.VIBRATOR_SERVICE) as? Vibrator
        v?.vibrate(power)
    }
}

fun View.setOnClickListenerExt(onClick: (v: View) -> Unit) {
    vibrate(context, 30)
    setOnClickListener { onClick(it) }
}