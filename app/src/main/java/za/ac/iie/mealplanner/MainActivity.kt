package za.ac.iie.mealplanner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val mealMap = mapOf(
        "morning" to "Eggs",
        "mid-morning" to "Fruit",
        "afternoon" to "Sandwich",
        "mid-afternoon" to "Cake",
        "dinner" to "Pasta",
        "after dinner" to "Ice cream"

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTime = findViewById<EditText>(R.id.editTime)
        val buttonSuggest = findViewById<Button>(R.id.buttonSuggest)
        val buttonReset = findViewById<Button>(R.id.buttonReset)
        val textSuggestion = findViewById<TextView>(R.id.textSuggestion)

        buttonSuggest.setOnClickListener {
            val input = editTime.text.toString().trim().lowercase()
            val suggestion = mealMap[input]

            textSuggestion.text = suggestion ?: "Invalid time. Try: Morning, Mid-morning, Afternoon, Mid-afternoon, Dinner, After Dinner"
        }

        buttonReset.setOnClickListener{
            editTime.text.clear()
            textSuggestion.text = ""
        }
    }
}