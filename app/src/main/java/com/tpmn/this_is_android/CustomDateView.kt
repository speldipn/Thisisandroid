package com.tpmn.this_is_android

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class CustomDateView : AppCompatTextView {
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        val typed = context.obtainStyledAttributes(attrs, R.styleable.CustomText)
        val size = typed.indexCount
        for (i in 0 until size) {
            when(typed.getIndex(i)) {
                R.styleable.CustomText_delimeter -> {
                    val delimeter = typed.getString(typed.getIndex(i)) ?: "-"
                    process(delimeter)
                }
            }
        }
    }

    fun process(delimeter: String) {
        val one = text.substring(0, 4)
        val two = text.substring(4, 6)
        val three = text.substring(6)

        text = "$one$delimeter$two$delimeter$three"
    }

}