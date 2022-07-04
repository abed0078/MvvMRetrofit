package com.example.myapplication.network


import com.example.myapplication.models.UserList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {
 /*   //base
    @GET("/posts")
    // suspend fun getPosts( @Query("{userId}") userId:Int): Response<ResponseBody>
    fun getPosts(): Call<List<UserList.User>>*/

    //test
    @GET("/posts")
    fun groupList(@Query("{userId}") userId: String): Call<List<UserList.User>>

}