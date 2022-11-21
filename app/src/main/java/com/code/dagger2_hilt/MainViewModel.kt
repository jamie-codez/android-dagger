package com.code.dagger2_hilt

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.code.dagger2_hilt.db.UserDao
import com.code.dagger2_hilt.di.RetrofitService
import com.code.dagger2_hilt.model.RecyclerList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainViewModel(application: Application):AndroidViewModel(application) {
    @Inject
    lateinit var retrofitService: RetrofitService
    private lateinit var liveDataList: MutableLiveData<RecyclerList>
    init {
        (application as MyApplication).getRetrofitComponent().injectRetrofitMainViewModel(this)
        liveDataList = MutableLiveData()
    }
    fun getLiveDataObserver():MutableLiveData<RecyclerList> = liveDataList
    fun makeApiCall(){
        val call:Call<RecyclerList>? = retrofitService.getDataFromAPI("atl")
        call?.enqueue(object :Callback<RecyclerList>{
            override fun onResponse(call: Call<RecyclerList>, response: Response<RecyclerList>) {
                if (response.isSuccessful) liveDataList.postValue(response.body())
                else liveDataList.postValue(null)
            }

            override fun onFailure(call: Call<RecyclerList>, t: Throwable) {
                liveDataList.postValue(null)
            }
        })
    }
}