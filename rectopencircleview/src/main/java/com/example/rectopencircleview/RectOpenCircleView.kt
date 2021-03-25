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

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.sinify() : Float = Math.sin(this * Math.PI).toFloat()

fun Canvas.drawRectOpenCircle(scale : Float, w : Float, h : Float, paint : Paint) {
    val size : Float = Math.min(w, h) / 2
    val sf : Float = scale.sinify()
    val sf1 : Float = sf.divideScale(0, parts)
    val sf2 : Float = sf.divideScale(1, parts)
    val sf3 : Float = sf.divideScale(2, parts)
    save()
    translate(w / 2, h / 2)
    for (j in 0..1) {
        save()
        scale(1f - 2 * j, 1f)
        drawRect(RectF(-w / 2, -h / 2, -w / 2 * sf2, -h / 2 + h * sf1), paint)
        restore()
    }
    drawArc(RectF(-size, -size, size, size), 0f, deg * sf3, true, paint)
    restore()
}

fun Canvas.drawROCNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    paint.color = colors[i]
    drawRectOpenCircle(scale, w, h, paint)
}
