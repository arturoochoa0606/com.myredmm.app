package com.myredmm.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.myredmm.app.ui.ScannerScreen
import com.myredmm.app.ui.theme.MyRedMMTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(
        savedInstanceState: Bundle?
    ) {
        super.onCreate(savedInstanceState)

        setContent {
            MyRedMMTheme {
                ScannerScreen()
            }
        }
    }
}
