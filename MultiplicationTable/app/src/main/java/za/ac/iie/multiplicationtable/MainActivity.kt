package za.ac.iie.multiplicationtable

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.findViewTreeViewModelStoreOwner

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val btnGenerate = findViewById<Button>(R.id.btnGenerate)
        val btnClear = findViewById<Button>(R.id.btnClear)
        val edtNumber = findViewById<EditText>(R.id.edtNumber)
        val txtOutput1 = findViewById<TextView>(R.id.output1)

        btnGenerate.setOnClickListener {
            val numberstr = edtNumber.text.toString()

            if (numberstr.isEmpty()) {
                Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show()
            }
            val number = numberstr.toInt()
            var answer = ""
            var i = 1
            while (i < 11) {
                answer += "$number x $i = ${number * i}\n"
                i++

            }
            txtOutput1.text = answer
        }


        btnClear.setOnClickListener {
            edtNumber.text.clear()
            txtOutput1.text = ""
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}