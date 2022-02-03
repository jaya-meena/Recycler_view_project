package com.example.task3

interface Communicator {
    // THIS FUNDTION WILL RECEIVE THW TEXT INPUT
    fun passDataCom_StoC(adapterPosition: Int)
    fun passDataCom_CtoT(adapterPosition: Int)

    fun call_Subjects()
    fun call_Chapters()
    fun call_Topics()
    fun FetchData_Subjects(): DataModel
}