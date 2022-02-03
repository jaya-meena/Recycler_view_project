package com.example.task3.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.example.task3.Communicator
import com.example.task3.R

class Topic_Fragment : Fragment() {

    lateinit var communicator: Communicator

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=  inflater.inflate(R.layout.fragment_topic_, container, false)

        view.findViewById<Toolbar>(R.id.toolbar).setNavigationOnClickListener{
            getActivity()?.getSupportFragmentManager()?.popBackStack();
        }

        val id = arguments?.getInt("positionC")
        Log.e("topic", id.toString() )

        communicator= activity as Communicator
        val list = communicator.FetchData_Subjects()
            //communicator.FetchData_Subjects()

        var display_Message:String =""

        when (id)
        {
            101 -> display_Message = list.listS[0].listC[0].description
            102 -> display_Message = list.listS[0].listC[1].description
            201 -> display_Message = list.listS[1].listC[0].description
            202 -> display_Message = list.listS[1].listC[1].description
        }


        communicator= activity as Communicator
        val data = communicator.FetchData_Subjects()

        Log.e("topic", display_Message )
        view.findViewById<TextView>(R.id.topic_name).text = display_Message
        return view

    }



}