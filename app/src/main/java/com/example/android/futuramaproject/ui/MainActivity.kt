package com.example.android.futuramaproject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.futuramaproject.R
import com.example.android.futuramaproject.ui.main.mainscreen.MainFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }
}
