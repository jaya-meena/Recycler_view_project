package com.example.task3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import com.example.task3.Fragments.Chapter_Fragment
import com.example.task3.Fragments.Subjects_Fragment
import com.example.task3.Fragments.Topic_Fragment

class MainActivity : AppCompatActivity() , Communicator{

    val fragmentS= Subjects_Fragment()
    var fragmentC= Chapter_Fragment()
    val fragmentT= Topic_Fragment()

    override fun call_Subjects()
    {
        val transaction = this.supportFragmentManager.beginTransaction()
        transaction.add(R.id.layout, fragmentS, "fragment_s")
        transaction.addToBackStack("fragment_s")
        transaction.commit()
    }
    override fun call_Chapters()
    {
        val transaction = this.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.layout, fragmentC, "fragment_c")
        transaction.addToBackStack("fragment_c")
        transaction.commit()
    }
    override fun call_Topics()
    {
        val transaction = this.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.layout, fragmentT, "fragment_t")
        transaction.addToBackStack("fragment_t")
        transaction.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        call_Subjects()
    }

    override fun passDataCom_StoC(adapterPosition: Int) {
        val bundle = Bundle()
        bundle.putInt("positionS", adapterPosition)
        fragmentC.arguments= bundle
    }

    override fun passDataCom_CtoT(adapterPosition: Int) {
        val bundle = Bundle()
        bundle.putInt("positionC", adapterPosition)
        fragmentT.arguments= bundle
    }


    override fun FetchData_Subjects(): DataModel
    {

        val dbms_ch1 = Chapters( "Normalization", 101,
            "Normalization Normalization is the process of organizing data in a database. This includes creating tables and establishing relationships between those tables according to rules designed both to protect the data and to make the database more flexible by eliminating redundancy and inconsistent dependency. good")
        val dbms_ch2 = Chapters( "Entity Diagram", 102,
            "An ER diagram shows the relationship among entity sets. ... In terms of DBMS, an entity is a table or attribute of a table in database, so by showing relationship among tables and their attributes, ER diagram shows the complete logical structure of a database.")

        val sub1 = ArrayList<Chapters>()
        sub1.add(dbms_ch1)
        sub1.add(dbms_ch2)

        val dbms= Subjects("DBMS", 1, sub1)

        val os_ch1 = Chapters( "Deadlock", 201,
            "In concurrent computing, a deadlock is a state in which each member of a group waits for another member, including itself, to take action, such as sending a message or more commonly releasing a lock.")
        val os_ch2 = Chapters( "Paging", 202,
            "The physical memory is divided into equal sized frames. The main memory is divided into fixed size pages. The size of a physical memory frame is equal to the size of a virtual memory frame.")

        val sub2 = ArrayList<Chapters>()
        sub2.add(os_ch1)
        sub2.add(os_ch2)

        val os= Subjects("Operating System", 2, sub2)

        val sub = ArrayList<Subjects>()
        sub.add(dbms)
        sub.add(os)

        val item = Syllabaus(sub)

        return item
    }


}




