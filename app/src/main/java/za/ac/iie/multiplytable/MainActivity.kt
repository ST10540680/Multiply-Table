package za.ac.iie.multiplytable

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //create variables to hold UI elements
        val multiplyBtn = findViewById<Button>(R.id.multiplyBtn)
        val numTxtInput =
            findViewById<EditText>(R.id.numTxtInput)

        //Created a set click listener to listener for the button click
        multiplyBtn.setOnClickListener {

            // created an explicit intent to switch between pages(Switching between main page to table)
            val intent = Intent(this, TableDisplay::class.java)

            //add the table number to the intent
            intent.putExtra("tableNumber", numTxtInput.text.toString())

            // start the activity
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}