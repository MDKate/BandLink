package com.example.bl1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = findViewById(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = Adapter(generateFakeValues())
    }
    private fun generateFakeValues(): List<String> {
        val values = mutableListOf<String>()
        for (i in 0..5) {
            values.add("$i element")
        }
        return values
    }

    //class Adapter: RecyclerView.Adapter <Adapter.ViewHolder> ()
    class Adapter (private val values: List<String>): RecyclerView.Adapter<Adapter.ViewHolder>()
    {
        override fun detItemCount() = values.size
        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
            val itemView = LayoutInflater.from(parent?.context).interflate(R.layout.recycler, parent, false)
            return ViewHolder(itemView)
        }
        override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
            holder?.textView?.text = values[position]
        }

        class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
            var textView: TextView? = null
            init {
                textView = itemView?.findViewById(R.id.__text__)
            }
        }
    }

}