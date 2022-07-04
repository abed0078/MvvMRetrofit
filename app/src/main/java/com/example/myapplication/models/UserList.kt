package com.example.myapplication.models

class UserList {

    data class User(val userId:Int,val id:Int,val title:String,val body:String)
    data class UserList(val data:List<User>)
}