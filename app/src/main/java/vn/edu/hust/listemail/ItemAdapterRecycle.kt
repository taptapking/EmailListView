package vn.edu.hust.listemail
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.view.View
import android.view.ViewGroup

class ItemAdapterRecycle(val items: ArrayList<ItemModel>, val listener: ItemClickListener? = null) : RecyclerView.Adapter<ItemAdapterRecycle.ItemViewHolderRecycle>() {
    override fun getItemCount(): Int {
        return items.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolderRecycle {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.itememail, parent, false)
        return ItemViewHolderRecycle(itemView, listener)
    }

    override fun onBindViewHolder(holder: ItemViewHolderRecycle, position: Int) {
        holder.thumbnail?.setImageResource(items[position].avatar)
        holder.checkbox?.isChecked = items[position].selected
        holder.sender?.text = items[position].name
        holder.title?.text = items[position].title
        holder.content?.text = items[position].content
        holder.time?.text = items[position].time
    }
    class ItemViewHolderRecycle(val itemView: View, val listener: ItemClickListener?): RecyclerView.ViewHolder(itemView){
        var sender: TextView? = null
        var title: TextView? = null
        var content: TextView? = null
        var time: TextView? = null
        var thumbnail: ImageView? = null
        var checkbox: CheckBox? = null
        init {
            sender = itemView.findViewById(R.id.sender)
            title = itemView.findViewById(R.id.title)
            content = itemView.findViewById(R.id.content)
            time = itemView.findViewById(R.id.time)
            thumbnail = itemView.findViewById(R.id.thumbnail)
            checkbox = itemView.findViewById(R.id.checkbox)

            itemView.setOnClickListener{
                listener?.ItemClick(adapterPosition)
            }
            Log.v("load", "findViewById")
        }
    }
    interface ItemClickListener{
        fun ItemClick(position: Int)
    }
}