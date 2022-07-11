package com.example.myapplication.repository

import androidx.lifecycle.MutableLiveData
import com.example.myapplication.models.UserList
import com.example.myapplication.network.Service
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainRepository {
    private val AppService: Service
    private val AppResponseLiveData: MutableLiveData<List<UserList.User>?>

    fun getMethod() {
        AppService.groupList("1")
            .enqueue(object : Callback<List<UserList.User>> {

                override fun onResponse(
                    call: Call<List<UserList.User>>,
                    response: Response<List<UserList.User>>
                ) {

                    AppResponseLiveData.postValue(response.body())
                }

                override fun onFailure(call: Call<List<UserList.User>>, t: Throwable) {
                    AppResponseLiveData.postValue(null)

                }

            })
    }
    fun getAppResponseLiveDataLiveData(): MutableLiveData<List<UserList.User>?> {
        return AppResponseLiveData
    }
    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    }
    init {
        AppResponseLiveData = MutableLiveData<List<UserList.User>?>()
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        AppService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Service::class.java)
    }

}




