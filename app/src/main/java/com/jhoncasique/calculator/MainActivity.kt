package com.jhoncasique.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        key_0.setOnClickListener { calculatorOutputView.addItem(getString(R.string.key_0)) }
        key_1.setOnClickListener { calculatorOutputView.addItem(getString(R.string.key_1)) }
        key_2.setOnClickListener { calculatorOutputView.addItem(getString(R.string.key_2)) }
        key_3.setOnClickListener { calculatorOutputView.addItem(getString(R.string.key_3)) }
        key_4.setOnClickListener { calculatorOutputView.addItem(getString(R.string.key_4)) }
        key_5.setOnClickListener { calculatorOutputView.addItem(getString(R.string.key_5)) }
        key_6.setOnClickListener { calculatorOutputView.addItem(getString(R.string.key_6)) }
        key_7.setOnClickListener { calculatorOutputView.addItem(getString(R.string.key_7)) }
        key_8.setOnClickListener { calculatorOutputView.addItem(getString(R.string.key_8)) }
        key_9.setOnClickListener { calculatorOutputView.addItem(getString(R.string.key_9)) }

        key_clear.setOnClickListener { calculatorOutputView.clear() }
        key_delete.setOnClickListener { calculatorOutputView.removeItem() }
        key_equal.setOnClickListener { calculatorOutputView.solve() }

        key_divide.setOnClickListener { calculatorOutputView.addItem(getString(R.string.divide_operator)) }
        key_minus.setOnClickListener { calculatorOutputView.addItem(getString(R.string.minus_operator)) }
        key_plus.setOnClickListener { calculatorOutputView.addItem(getString(R.string.plus_operator)) }
        key_multiply.setOnClickListener { calculatorOutputView.addItem(getString(R.string.multiply_operator)) }
        key_percent.setOnClickListener { calculatorOutputView.addItem(getString(R.string.percent_operator)) }

    }
}