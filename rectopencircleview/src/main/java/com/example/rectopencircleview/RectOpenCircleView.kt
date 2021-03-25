package com.example.rectopencircleview

import android.view.View
import android.view.MotionEvent
import android.content.Context
import android.app.Activity
import android.graphics.Paint
import android.graphics.Color
import android.graphics.RectF
import android.graphics.Canvas

val colors : Array<Int> = arrayOf(
    "#f44336",
    "#3F51B5",
    "#00BCD4",
    "#BF360C",
    "#2E7D32"
).map {
    Color.parseColor(it)
}.toTypedArray()
val parts : Int = 4
val scGap : Float = 0.02f / parts
val backColor : Int = Color.parseColor("#BDBDBD")
val deg : Float = 360f
val delay : Long = 20