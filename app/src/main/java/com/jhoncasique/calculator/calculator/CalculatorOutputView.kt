package com.jhoncasique.calculator.calculator

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.jhoncasique.calculator.R
import kotlinx.android.synthetic.main.view_calculator_outpoot.view.*

class CalculatorOutputView(context:Context, attributeSet: AttributeSet?) : LinearLayout(context, attributeSet), CalculatorOutputInterface {

    init {
        //Set orientation
        orientation = VERTICAL
        //Set gravity
        gravity = Gravity.CENTER_VERTICAL

        LayoutInflater.from(context).inflate(R.layout.view_calculator_outpoot, this, true)
    }

    fun addItem(item: String) {
        CalculatorOutputPresenter.addItem(item)
    }

    fun removeItem() {
        CalculatorOutputPresenter.removeItem()
    }

    fun solve(){
        CalculatorOutputPresenter.solve()
    }

    fun clear(){
        CalculatorOutputPresenter.clear()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        CalculatorOutputPresenter.onAttach(this)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        CalculatorOutputPresenter.onDetach()
    }

    override fun setEquation(equation: String) {
        calculator_input_equation.text = equation
    }

    override fun setOutcome(outcome: String) {
        calculator_input_outcome.text = outcome
    }

}