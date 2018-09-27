package com.tester.psytester

import android.graphics.*
import android.graphics.drawable.Drawable

import android.support.v4.content.res.ResourcesCompat.getColor

class RandomPoint(width:Int,height:Int,color:Int):Drawable() {
    private val  mPaint=Paint(Paint.ANTI_ALIAS_FLAG)
    private val mPath = Path()
    var imageWidth=0
    var imageHeight=0



    init{
        imageWidth=width
        imageHeight=height
        mPaint.color=color
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
        val x=Randomizer().randInt(0,bounds.width()-width.toInt()).toFloat()
        val y=Randomizer().randInt(0,bounds.height()-width.toInt()).toFloat()

        mPath.reset()
        mPath.moveTo(x,y)
        mPath.lineTo(x+0f, y+0f);
        mPath.lineTo(x+width, y+0f);
        mPath.lineTo(x+width, y+width);
        mPath.lineTo(x+0f, y+width);
        mPath.close()
    }
}