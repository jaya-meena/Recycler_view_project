package com.example.task3.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task3.*

class Chapter_Fragment : Fragment(), OnItemClickListener {

    lateinit var communicator: Communicator

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_chapter_, container, false)

        view.findViewById<Toolbar>(R.id.toolbar).setNavigationOnClickListener{
            getActivity()?.getSupportFragmentManager()?.popBackStack();
        }



        val pos = arguments?.getInt("positionS")

        communicator= activity as Communicator
        val data = communicator.FetchData_Subjects()

        val item : ArrayList<Pair<String,Int>> = ArrayList<Pair<String,Int>>()

        for ( i in data.listS[(pos!!)-1].listC)
        {
            Log.e("list", i.name)
            Log.e("list", i.id.toString())
            val pair = Pair( i.name, i.id)
            item.add(pair)
        }


        view.findViewById<RecyclerView>(R.id.recyclerView_ch)?.layoutManager = LinearLayoutManager(activity)

        val adapter : Adapter = Adapter(this, item)
        view.findViewById<RecyclerView>(R.id.recyclerView_ch).adapter = adapter
        return view
    }

    override fun onItemClicked(adapterPosition: Int) {
        communicator= activity as Communicator
        communicator.passDataCom_CtoT(adapterPosition)
        communicator.call_Topics()
    }


}