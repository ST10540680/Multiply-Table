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

       //get the table number from the bundle
        val bundle : Bundle? = intent.extras
        var tableDisplay: String? = bundle?.getString("tableNumber")

        //converting the string back into a number ready for multiplication
        val tableNumber = tableDisplay!!. toInt()

        //display the heading so we can see the value in action
        val multiplyTable = findViewById<TextView>(R.id.Tabledisplayact)

        //start with the heading and two new lines
        multiplyTable.text = "$tableNumber x table\n\n"

        //loop 10 times keep adding to the string

        //declare the control variable
        val counter = 1
        while (counter <= 10){ //check the control variable
            //skip 3
            if (counter == 3){
                counter++
                continue
            }
            val answer = tableNumber * counter
            tableDisplay += "$tableNumber x $counter = $answer"
        }
        //set the string onto the display
        multiplyTable.text = tableDisplay

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}