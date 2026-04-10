package za.ac.iie.multiplytable

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TableDisplay : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_table_display)

        // Get the table number from the intent extras
        val tableNumberString = intent.getStringExtra("tableNumber")
        
        // Convert the string to an integer, defaulting to 0 if invalid or null
        val tableNumber = tableNumberString?.toIntOrNull() ?: 0

        val multiplyTable = findViewById<TextView>(R.id.Tabledisplayact)

        // Use a StringBuilder to efficiently build the multiplication table string
        val resultBuilder = StringBuilder()
        resultBuilder.append("$tableNumber Times Table\n\n")

        var counter = 1
        // Loop up to 20 to generate the table
        while (counter <= 20) {
            // Example requirement: skip 3 (as seen in original code)
            if (counter == 3) {
                counter++
                continue
            }
            
            val answer = tableNumber * counter
            resultBuilder.append("$tableNumber x $counter = $answer\n")
            
            counter++ // Increment counter to avoid infinite loop
        }

        // Set the built string to the TextView
        multiplyTable.text = resultBuilder.toString()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}