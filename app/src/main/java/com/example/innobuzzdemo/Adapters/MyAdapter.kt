package com.example.innobuzzdemo.Adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.innobuzzdemo.R
import com.example.innobuzzdemo.RoomDataBase.Entity

class MyAdapter(val context: Context, val arrayList: List<Entity>): RecyclerView.Adapter<MyAdapter.ViewHolder>() {
lateinit var setOnClickListner: SetOnClickListner

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(context).inflate(R.layout.item_list_layout,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.textView.setText(arrayList.get(position).title)
        holder.itemView.setOnClickListener(View.OnClickListener {
          setOnClickListner.onClick(arrayList.get(position))
        })
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)  {
       val textView = itemView.findViewById<AppCompatTextView>(R.id.title_text)

    }
    public interface SetOnClickListner{
        fun onClick(entity: Entity)
    }
  public fun get_data(setOnClickListner: SetOnClickListner){
        this.setOnClickListner = setOnClickListner
    }
}