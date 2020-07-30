package com.jhoncasique.calculator

import com.jhoncasique.calculator.calculator.CalculatorOutputInterface
import com.jhoncasique.calculator.calculator.CalculatorOutputPresenter
import org.junit.Test
import org.mockito.BDDMockito.then
import org.mockito.Mockito

class CalculatorOutputTest {

    private val presenter : CalculatorOutputPresenter = CalculatorOutputPresenter
    private val mockView: CalculatorOutputInterface = Mockito.mock(CalculatorOutputInterface::class.java)

    @Test
    fun onePlusOneEqualTwo() {
        //Given that the view is attached
        presenter.onAttach(mockView)
        //When
        presenter.addItem("1")
        //Then
        then(mockView).should().setEquation("1")

        //When add logical operators
        presenter.addItem("+")
        //Then
        then(mockView).should().setEquation("1+")

        //When add other item after logical operators
        presenter.addItem("1")
        //Then
        then(mockView).should().setEquation("1+1")
        //Then outcome should be correct
        then(mockView).should().setOutcome("2")
        presenter.clear()
    }

    @Test
    fun twoPlusTwoMinusOne() {
        //Given that the view is attached
        presenter.onAttach(mockView)
        //When
        presenter.addItem("2")
        //Then
        then(mockView).should().setEquation("2")

        //When add logical operators
        presenter.addItem("+")
        //Then
        then(mockView).should().setEquation("2+")

        //When add other item after logical operators
        presenter.addItem("2")
        //Then
        then(mockView).should().setEquation("2+2")
        //Then outcome should be correct
        then(mockView).should().setOutcome("4")

        presenter.addItem("-")
        then(mockView).should().setEquation("2+2-")
        presenter.addItem("1")
        then(mockView).should().setEquation("2+2-1")
        then(mockView).should().setOutcome("3")
        presenter.clear()
    }

    @Test
    fun fiveMultiplyByFiveIsEqualTo25() {
        presenter.onAttach(mockView)
        presenter.addItem("5")
        then(mockView).should().setEquation("5")
        presenter.addItem("*")
        then(mockView).should().setEquation("5*")
        presenter.addItem("5")
        then(mockView).should().setEquation("5*5")
        then(mockView).should().setOutcome("25")
        presenter.addItem("*")
        then(mockView).should().setEquation("5*5*")
        presenter.addItem("10")
        then(mockView).should().setEquation("5*5*10")
        then(mockView).should().setOutcome("250")
        presenter.clear()
    }

    @Test
    fun divideFiveByFive() {
        presenter.onAttach(mockView)
        presenter.addItem("5")
        then(mockView).should().setEquation("5")
        presenter.addItem("/")
        then(mockView).should().setEquation("5/")
        presenter.addItem("5")
        then(mockView).should().setEquation("5/5")
        then(mockView).should().setOutcome("1")
        presenter.addItem("*")
        then(mockView).should().setEquation("5/5*")
        presenter.addItem("10")
        then(mockView).should().setEquation("5/5*10")
        then(mockView).should().setOutcome("10")
        presenter.clear()

    }
}