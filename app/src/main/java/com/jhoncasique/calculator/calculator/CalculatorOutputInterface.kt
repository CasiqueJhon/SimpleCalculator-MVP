package com.jhoncasique.calculator.calculator

//This is the futures the presenter will call
interface CalculatorOutputInterface {

    fun setEquation(equation: String)

    fun setOutcome(outcome: String)

}