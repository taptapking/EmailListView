package vn.edu.hust.listemail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class MainActivity_recycle : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_recycle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.inbox)

        val date = getCurrentDateTime()
        val dateInString = date.toString("yyyy/MM/dd HH:mm:ss")

        val items = arrayListOf<ItemModel>()
        repeat(28){
            val index = it+1
            val displayname : Int = resources.getIdentifier("name_$index", "string", packageName)
            Log.v("name",getString(displayname))
            items.add(ItemModel(getString(displayname),"Title $index","Content $index", dateInString, resources.getIdentifier("thumb$index", "drawable", packageName) ))
        }
        val adapter = ItemAdapterRecycle(items, object: ItemAdapterRecycle.ItemClickListener{
            override fun ItemClick(position: Int){
                Log.v("action", "clicked $position")
            }
        })

        val l = findViewById(R.id.recycler_view) as RecyclerView
        l.layoutManager = LinearLayoutManager(this)
        l.adapter =  adapter
    }
    fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
        val formatter = SimpleDateFormat(format, locale)
        return formatter.format(this)
    }
    fun getCurrentDateTime(): Date {
        return Calendar.getInstance().time
    }
}