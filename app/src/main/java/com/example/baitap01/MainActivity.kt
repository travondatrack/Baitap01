package com.example.baitap01

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge

class MainActivity : ComponentActivity() {

    private lateinit var etNumbers: EditText
    private lateinit var btnProcessNumbers: Button
    private lateinit var tvNumberResult: TextView
    private lateinit var etInput: EditText
    private lateinit var btnReverse: Button
    private lateinit var tvOutput: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Initialize views
        initViews()

        // Set up click listeners
        setupClickListeners()

        // Demo ArrayList processing on app start
        demoArrayListProcessing()
    }

    private fun initViews() {
        etNumbers = findViewById(R.id.etNumbers)
        btnProcessNumbers = findViewById(R.id.btnProcessNumbers)
        tvNumberResult = findViewById(R.id.tvNumberResult)
        etInput = findViewById(R.id.etInput)
        btnReverse = findViewById(R.id.btnReverse)
        tvOutput = findViewById(R.id.tvOutput)
    }

    private fun setupClickListeners() {
        // Requirement 4: ArrayList number processing
        btnProcessNumbers.setOnClickListener {
            processNumberArrayFromInput()
        }

        // Requirement 5: String reversal
        btnReverse.setOnClickListener {
            processStringReversal()
        }
    }

    // Requirement 4: Process ArrayList of numbers and log odd/even numbers separately
    private fun processNumberArrayFromInput() {
        val input = etNumbers.text.toString().trim()

        if (input.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập các số cách nhau bằng dấu cách", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            // Convert input string to ArrayList of integers
            val numbers = ArrayList<Int>()
            val inputNumbers = input.split(" ")

            for (numStr in inputNumbers) {
                val trimmedNum = numStr.trim()
                if (trimmedNum.isNotEmpty()) {
                    val num = trimmedNum.toInt()
                    numbers.add(num)
                }
            }

            // Separate odd and even numbers
            val oddNumbers = ArrayList<Int>()
            val evenNumbers = ArrayList<Int>()

            for (number in numbers) {
                if (number % 2 == 0) {
                    evenNumbers.add(number)
                } else {
                    oddNumbers.add(number)
                }
            }

            // Log the results as required
            Log.d("NumberArray", "Original ArrayList: $numbers")
            Log.d("NumberArray", "Odd numbers: $oddNumbers")
            Log.d("NumberArray", "Even numbers: $evenNumbers")

            // Display results in tvNumberResult TextView
            tvNumberResult.text = "Lẻ: $oddNumbers\nChẵn: $evenNumbers"
            tvNumberResult.visibility = TextView.VISIBLE

            // Show results in Toast
            Toast.makeText(this, "Lẻ: $oddNumbers\nChẵn: $evenNumbers", Toast.LENGTH_LONG).show()

        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Vui lòng chỉ nhập các số hợp lệ", Toast.LENGTH_SHORT).show()
        }
    }

    // Demo function to show ArrayList processing on app start
    private fun demoArrayListProcessing() {
        // Create a demo ArrayList with sample numbers
        val demoNumbers = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 15, 20, 25, 30)

        val oddNumbers = ArrayList<Int>()
        val evenNumbers = ArrayList<Int>()

        // Separate odd and even numbers
        for (number in demoNumbers) {
            if (number % 2 == 0) {
                evenNumbers.add(number)
            } else {
                oddNumbers.add(number)
            }
        }

        // Log the demo results
        Log.d("DemoArray", "Demo ArrayList: $demoNumbers")
        Log.d("DemoArray", "Demo Odd numbers: $oddNumbers")
        Log.d("DemoArray", "Demo Even numbers: $evenNumbers")
    }

    // Requirement 5: String reversal functionality
    private fun processStringReversal() {
        val input = etInput.text.toString().trim()

        if (input.isEmpty()) {
            Toast.makeText(this, "Please enter text to reverse", Toast.LENGTH_SHORT).show()
            return
        }

        // Reverse words in the string and convert to uppercase
        val reversedText = reverseWords(input)

        // Display in TextView
        tvOutput.text = reversedText
        tvOutput.visibility = TextView.VISIBLE

        // Show in Toast
        Toast.makeText(this, reversedText, Toast.LENGTH_LONG).show()
    }

    // Function to reverse words in a string and convert to uppercase
    private fun reverseWords(input: String): String {
        return input
            .split(" ")
            .reversed()
            .joinToString(" ")
            .uppercase()
    }
}