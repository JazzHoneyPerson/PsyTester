package com.tester.psytester

import android.graphics.*
import android.graphics.drawable.Drawable
import android.support.v4.content.res.ResourcesCompat.getColor

class RedPoint(x:Int,y:Int):Drawable() {
    private val  mPaint=Paint(Paint.ANTI_ALIAS_FLAG)
    private val mPath = Path()

    private var x=0f
    private var y=0f

    init{
        this.x=x*bounds.width()/100f
        this.y=y*bounds.height()/100f
        mPaint.color=Color.RED
    }
    override fun draw(canvas: Canvas) {
        canvas.drawPath(mPath, mPaint)
    }
    override fun setAlpha(alpha: Int) {
        mPaint.setAlpha(alpha)
    }

    override fun setColorFilter(colorFilter: ColorFilter) {
        mPaint.setColorFilter(colorFilter)
    }

    override fun getOpacity(): Int {
        return PixelFormat.TRANSLUCENT
    }
    override  fun onBoundsChange(bounds: Rect) {
        super.onBoundsChange(bounds)

        val width = bounds.width()/10f
        mPath.reset()
        mPath.moveTo(x,y)
        mPath.lineTo(x+0f, y+0f);
        mPath.lineTo(x+width, y+0f);
        mPath.lineTo(x+width, y+width);
        mPath.lineTo(x+0f, y+width);
        mPath.close()
    }
}