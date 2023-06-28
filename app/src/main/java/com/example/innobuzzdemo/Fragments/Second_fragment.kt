package com.example.innobuzzdemo.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.innobuzzdemo.Adapters.MyAdapter
import com.example.innobuzzdemo.ModelViewClass.MyViewModel
import com.example.innobuzzdemo.ModelViewFactory.MyViewModelFactory
import com.example.innobuzzdemo.R
import com.example.innobuzzdemo.RoomDataBase.DataBaseBuilder
import com.example.innobuzzdemo.RoomDataBase.Entity
import com.example.innobuzzdemo.SharedPreference.MySharedPref
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class Second_fragment : Fragment() {
    lateinit var adapter:MyAdapter;
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second_fragment, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        var arrayList : MutableList<Entity> = mutableListOf()
        val viewmodel = ViewModelProviders.of(this,
            context?.let { MyViewModelFactory(context = it) }).get(MyViewModel::class.java)
        viewmodel.get_List().observe(viewLifecycleOwner, Observer {
            for(i in 0 until it.size){
                val itemList = it[i].id?.let { it1 -> Entity(id = it1, title = it[i].title, userId = it.get(i).userId, body = it[i].body) }
                if (itemList != null) {
                    arrayList.add(itemList)
                }
            }
        })
        GlobalScope.launch {
            context?.let {
                DataBaseBuilder.getInstance(it).itemDao().insertAll(arrayList)
            }
        }

        context?.let {
            val liveData = DataBaseBuilder.getInstance(it).itemDao().getAll()
            liveData.observe(viewLifecycleOwner, Observer {
                 adapter = MyAdapter(requireContext(),it)
                recyclerView.layoutManager = LinearLayoutManager(context)
                recyclerView.adapter = adapter
                adapter.get_data(object : MyAdapter.SetOnClickListner{
                    override fun onClick(entity: Entity) {
                        context?.let { MySharedPref(it).setPreferences(MySharedPref.id,entity.id.toString())
                            MySharedPref(it).setPreferences(MySharedPref.userId,entity.userId.toString())
                            MySharedPref(it).setPreferences(MySharedPref.title,entity.title.toString())
                            MySharedPref(it).setPreferences(MySharedPref.body,entity.body.toString())
                            findNavController().navigate(R.id.item_view)
                        }
                    }
                })
            })

        }

        return view;
    }


    }
