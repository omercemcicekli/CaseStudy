package com.omercemcicekli.casestudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.omercemcicekli.assignment.AssignmentView

class ManualScrollingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manual_scrolling)

        val view = findViewById<AssignmentView>(R.id.assignment_view)

        view.setImageData(ImageDataGenerator.getTestData())
    }
}