package za.ac.iie.multiplytable

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TableDisplay : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_table_display)

       //get the table number from the bundle
        val bundle = Bundle? = intent.extras
        val tableString: String? bundle?.getString( key = "tableNumber")

        //converting the string back into a number ready for multiplication
        val tableNumber = tableString?. toInt()

        //display the heading so we can see the value in action
        val multiplyTable = findViewById<TextView>(
                                   R.id.tableDisplayTextView)
        multiplyTable.text = '$tableNumber * table'

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}