package com.jhoncasique.calculator

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import com.jhoncasique.calculator.calculator.CalculatorOutputPresenter
import kotlinx.android.synthetic.main.view_calculator_input.view.*
import java.lang.reflect.Type

class CalculatorInputView(context: Context, attributeSet: AttributeSet?) : RelativeLayout(context, attributeSet) {

    init {

        LayoutInflater.from(context).inflate(R.layout.view_calculator_input, this, true)

        //Read Attr set
        attributeSet?.run {
            val typeArray: TypedArray = context.obtainStyledAttributes(attributeSet, R.styleable.CalculatorInputView)
            val textResource = typeArray.getString(R.styleable.CalculatorInputView_item_text)
            val iconResource = typeArray.getResourceId(R.styleable.CalculatorInputView_item_icon, -1)

            when {
                iconResource != -1 -> {
                    input_element_text.visibility = View.GONE
                    input_element_image.apply {
                        visibility = View.VISIBLE
                        setImageResource(iconResource)
                    }
                }
                !textResource.isNullOrEmpty() -> {
                    input_element_image.visibility = View.GONE
                    input_element_text.apply {
                        visibility = View.VISIBLE
                        text = textResource
                    }
                }
                else -> {
                    input_element_image.visibility = View.GONE
                    input_element_text.visibility = View.GONE
                }
            }
            typeArray.recycle()
        }
    }

    override fun setOnClickListener(l: OnClickListener?) {
        input_element_click.setOnClickListener(l)
    }

}