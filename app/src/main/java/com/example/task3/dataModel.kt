package com.example.task3
import android.accounts.AuthenticatorDescription
import android.widget.ArrayAdapter
import java.io.Serializable

open class DataModel : Serializable {
    open val listS : ArrayList<Subjects> = ArrayList<Subjects>()
    open val listC : ArrayList<Chapters> = ArrayList<Chapters>()
    open val name : String = "null"
    open val description : String = "null"
    open val id : Int = 0
}

class Syllabaus (
    override val listS: ArrayList<Subjects>
): DataModel()

class Subjects(
    override val name: String,
    override val id: Int,
    override val listC: ArrayList<Chapters>
): DataModel()

class Chapters(
    override val name: String,
    override val id: Int,
    override val description: String
): DataModel()








/*open class dataModel : Serializable {
    open val listS : ArrayList<Subjects> = ArrayList<Subjects>()
    open val listC : ArrayList<Chapters> = ArrayList<Chapters>()
    open val name : String = "null"
    open val description : String = "null"
    open val id : Int = 0
}

    class syllabaus (
        override val listS: ArrayList<Subjects>
    ): dataModel()

    class Subjects(
        override val name: String,
        override val id: Int,
        override val listC: ArrayList<Chapters>
    ): dataModel()

    class Chapters(
        override val name: String,
        override val id: Int,
        override val description: String
    ): dataModel()
*/