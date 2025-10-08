package com.example.mexc_lp_balancer

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

import com.example.mexc_lp_balancer.R

class MainActivity : AppCompatActivity() {

    private lateinit var modeSwitch: Switch
    private lateinit var modeLabel: TextView
    private lateinit var apiKeyInput: EditText
    private lateinit var apiSecretInput: EditText
    private lateinit var saveButton: Button
    private lateinit var statusLabel: TextView

    private var testMode: Boolean = true
    private var apiKey: String = ""
    private var apiSecret: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        modeSwitch = findViewById(R.id.switchMode)
        modeLabel = findViewById(R.id.textMode)
        apiKeyInput = findViewById(R.id.inputApiKey)
        apiSecretInput = findViewById(R.id.inputApiSecret)
        saveButton = findViewById(R.id.btnSaveKeys)
        statusLabel = findViewById(R.id.statusLabel)

        updateModeLabel(testMode)

        saveButton.setOnClickListener {
            apiKey = apiKeyInput.text.toString().trim()
            apiSecret = apiSecretInput.text.toString().trim()
            statusLabel.text = "Ключи сохранены: $apiKey / $apiSecret"
        }

        modeSwitch.setOnCheckedChangeListener { _, isChecked ->
            testMode = isChecked
            updateModeLabel(isChecked)
        }
    }

    private fun updateModeLabel(isTestMode: Boolean) {
        if (isTestMode) {
            modeLabel.text = "Тестовый режим"
            modeLabel.setTextColor(getColor(android.R.color.holo_blue_light))
        } else {
            modeLabel.text = "Боевой режим"
            modeLabel.setTextColor(getColor(android.R.color.holo_red_light))
        }
    }
}
