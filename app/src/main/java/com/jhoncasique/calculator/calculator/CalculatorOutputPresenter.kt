package com.jhoncasique.calculator.calculator

import bsh.Interpreter
import java.lang.Exception

object CalculatorOutputPresenter {

    private var view: CalculatorOutputInterface? = null
    private var currentEquation : String = ""
    private var currentOutcome: String = ""
    //The actual class who make calculations
    private val interpreter = Interpreter()

    fun onAttach(view: CalculatorOutputInterface) {
        this.view = view
    }

    fun onDetach() {
        view = null
    }

    fun addItem(item: String) {
        when {
            item.endsWith("+") -> {
                currentEquation = currentOutcome.plus(item)
            }
            item.endsWith("-") -> {
                currentEquation = currentOutcome.plus(item)
            }
            item.endsWith("*") -> {
                currentEquation = currentOutcome.plus(item)
            }
            item.endsWith("/") -> {
                currentEquation = currentOutcome.plus(item)
            }
            item.endsWith("%") -> {
                currentEquation = currentOutcome.plus(item)
            }
        }
        currentEquation = currentEquation.plus(item)
        updateEquation()
        calculateOutcome()
        updateOutcome()
    }

    fun removeItem() {
        currentEquation = if (currentEquation.length > 1) {
            currentEquation.substring(0, currentEquation.length -1)
        } else {
            ""
        }
        updateEquation()
        calculateOutcome()
        updateOutcome()
    }

    fun solve() {
        if (currentOutcome.isNotEmpty()) {
            currentEquation = currentOutcome
            currentOutcome = ""
        }
        updateEquation()
        updateOutcome()
    }

    fun clear() {
        currentEquation = ""
        currentOutcome = ""
        updateEquation()
        updateOutcome()
    }

    private fun calculateOutcome() {
        if (currentEquation.isNotEmpty()) {
            try {
                interpreter.eval("result = $currentEquation")
                val result = interpreter.get("result")
                if (result != null && result is Int) {
                    currentOutcome = result.toString()
                }
            } catch (e: Exception) {
                currentOutcome = ""
            }
        } else {
            currentOutcome = ""
        }
    }

    private fun updateEquation() {
        view?.setEquation(currentEquation)
    }

    private fun updateOutcome() {
        view?.setOutcome(currentOutcome)
    }

}