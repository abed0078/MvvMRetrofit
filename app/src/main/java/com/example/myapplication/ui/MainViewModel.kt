package com.example.myapplication.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.models.UserList
import com.example.myapplication.repository.MainRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private var appRepository: MainRepository = MainRepository()
    private var appResponseLiveData: LiveData<List<UserList.User>?> =
        appRepository.getAppResponseLiveDataLiveData()

    fun getMethod() {
        appRepository.getMethod()
    }

    fun getAppResponseLiveData(): LiveData<List<UserList.User>?> {
      return appResponseLiveData
    }


}