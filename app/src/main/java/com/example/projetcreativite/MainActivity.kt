import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.projetcreativite.R

class MainActivity : AppCompatActivity() {

    private lateinit var nom: EditText
    private lateinit var prenom: EditText
    private lateinit var email: EditText
    private lateinit var affiche: Button
    private lateinit var boutton: Button
    private lateinit var view: TextView
    private lateinit var gridView: GridView
    private lateinit var tableLayout: TableLayout
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nom = findViewById(R.id.editTextText)
        prenom = findViewById(R.id.editTextText2)
        email = findViewById(R.id.editTextText3)
        affiche = findViewById(R.id.button)
        boutton = findViewById(R.id.button2)
        view = findViewById(R.id.textView)
        gridView = findViewById(R.id.GridView)
        tableLayout = findViewById(R.id.tableLayout)
        progressBar = findViewById(R.id.progressBar)

        affiche.setOnClickListener {
            afichage()
        }

        boutton.setOnClickListener {
            list()
        }
    }

    private fun afichage() {
        val anarana = nom.text.toString()
        val prenome = prenom.text.toString()
        val emaile = email.text.toString()

        if (anarana.isEmpty() && prenome.isEmpty() && emaile.isEmpty()) {
            Toast.makeText(this, "fenoy ny banga", Toast.LENGTH_SHORT).show()
        } else {
            val mess = "nom:$anarana"
            val a = "prenom:$prenome"
            val b = "email:$emaile"
            Toast.makeText(this, mess, Toast.LENGTH_LONG).show()
            Toast.makeText(this, a, Toast.LENGTH_LONG).show()
            Toast.makeText(this, b, Toast.LENGTH_LONG).show()
        }
    }

    private fun list() {
        val anarana = nom.text.toString()
        val prenome = prenom.text.toString()
        val emaile = email.text.toString()

        if (anarana.isEmpty() && prenome.isEmpty() && emaile.isEmpty()) {
            Toast.makeText(this, "fenoy ny banga", Toast.LENGTH_SHORT).show()
        } else {
            val message = "nom:$anarana\nprenom:$prenome\nemail:$emaile\n"
            view.text = message

            // Afficher la ProgressBar pendant 3 secondes (3000 millisecondes)
            progressBar.visibility = View.VISIBLE
            progressBar.progress = 0
            val duration = 3000L
            val interval = 100L
            val steps = duration / interval
            val increment = 100 / steps

            val timer = object : CountDownTimer(duration, interval) {
                override fun onTick(millisUntilFinished: Long) {
                    progressBar.progress += increment.toInt()
                }

                override fun onFinish() {
                    progressBar.visibility = View.INVISIBLE
                }
            }
            timer.start()

            // GridView
            val gridAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayListOf(message))
            gridView.adapter = gridAdapter

            // TableLayout
            val tableRow = TableRow(this)
            val textView = TextView(this)
            textView.text = message
            tableRow.addView(textView)
            tableLayout.addView(tableRow)
        }
    }
}
