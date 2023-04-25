package com.example.whatsappclone.communities.addChat

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.whatsappclone.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChatCreateActivity: AppCompatActivity(R.layout.fragment_create_chat) {

    private val viewModel by viewModel<ChatCreateViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupView()
        observeViewModel()
    }

    private fun setupView() {
        val button = findViewById<Button>(R.id.addButton)
        val nameET = findViewById<EditText>(R.id.titleEditText)
        val descET = findViewById<EditText>(R.id.descriptionEditText)

        button.setOnClickListener {
            viewModel.saveGroupInfo(nameET.text.toString(), descET.text.toString())
        }
    }

    private fun observeViewModel() = with(viewModel) {
        success.observe(this@ChatCreateActivity){
            finish()
        }
    }
}