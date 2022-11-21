package com.code.dagger2_hilt

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.code.dagger2_hilt.db.UserDao
import com.code.dagger2_hilt.model.UserEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.w3c.dom.ls.LSException
import javax.inject.Inject

class RoomViewModel(application: Application) : AndroidViewModel(application) {
    @Inject
    lateinit var userDao: UserDao
    lateinit var allUserList:MutableLiveData<List<UserEntity>>

    init {
        (application as MyApplication).getRoomDBComponent().injectRoomMainViewModel(this)
        allUserList = MutableLiveData()
        getAllRecords()
    }
    fun geRecordObserver():MutableLiveData<List<UserEntity>> = allUserList
    fun getAllRecords(){
        CoroutineScope(Dispatchers.IO).launch{
            val list = userDao.selectAll()
            allUserList.postValue(list)
        }
    }
    fun insertRecord(userEntity: UserEntity){
        CoroutineScope(Dispatchers.IO).launch {
            userDao.insert(userEntity)
        }
    }
}