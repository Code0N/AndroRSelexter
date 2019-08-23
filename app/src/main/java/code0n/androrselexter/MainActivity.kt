package code0n.androrselexter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.appcompat.app.AlertDialog
import android.R.string.cancel
import android.content.DialogInterface
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun clearOE(view: View) {
        optET.setText("")
    }

    fun randomSelect(view: View) {
        fun getLines(view: TextView): List<CharSequence> {
            var lines: MutableList<CharSequence> = mutableListOf()
            val lay: Layout = view.layout
            if (lay != null) {
                var lineCount = lay.lineCount
                var text: CharSequence = lay.text
                var i = 0
                var startIndex = 0
                while (i < lineCount) {
                    var endIndex = lay.getLineEnd(i)
                    lines.add(text.subSequence(startIndex, endIndex))
                    startIndex = endIndex
                    i++
                }
            }
            return lines
        }
        val lines = getLines(optET)
        val builder = AlertDialog.Builder(this@MainActivity)
        builder.setTitle("Случайный выбор")
            .setMessage(lines[Random().nextInt(lines.size)].toString())
            .setCancelable(false)
            .setNegativeButton("OK",
                DialogInterface.OnClickListener { dialog, id -> dialog.cancel() })
        val alert = builder.create()
        alert.show()
    }
}
