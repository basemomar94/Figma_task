package com.bassem.figmatask

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import com.bassem.figmatask.MainActivity.Companion.paintBrush
import com.bassem.figmatask.MainActivity.Companion.path

class PaintView : View {
    var parms: ViewGroup.LayoutParams? = null

    companion object {
        var pathsList = ArrayList<Path>()
        var currentBrush = Color.BLACK
        var colorList = ArrayList<Int>()
    }

    constructor(context: Context) : this(context, null) {
        initialize()
    }

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0) {
        initialize()

    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initialize()

    }

    private fun initialize() {
        paintBrush.isAntiAlias = true
        paintBrush.color = Color.BLUE
        paintBrush.style = Paint.Style.STROKE
        paintBrush.strokeJoin = Paint.Join.ROUND
        paintBrush.strokeWidth = 8f
        parms = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        var x = event.x
        var y = event.y

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                path.moveTo(x, y)
                return true
            }
            MotionEvent.ACTION_MOVE -> {
                path.lineTo(x, y)
                pathsList.add(path)
                colorList.add(currentBrush)

            }
            else -> return false

        }
        postInvalidate()
        return false
    }

    override fun onDraw(canvas: Canvas?) {
        for (i in pathsList.indices){
            paintBrush.color= colorList[i]
            canvas?.drawPath(pathsList[i], paintBrush)
        }
    }
}