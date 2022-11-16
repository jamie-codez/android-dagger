package com.code.dagger2_hilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.code.dagger2_hilt.model.RecyclerData
import com.code.dagger2_hilt.model.RecyclerList
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        initViewModel()
    }
    private fun initRecyclerView(){
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerViewAdapter = RecyclerViewAdapter()
        recyclerView.adapter = recyclerViewAdapter
    }
    fun initViewModel(){
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mainViewModel.getLiveDataObserver().observe(this,object :Observer<RecyclerList>{
            override fun onChanged(t: RecyclerList?) {
                if (t!=null){
                    recyclerViewAdapter.setUpdateData(t.items)
                    recyclerViewAdapter.notifyDataSetChanged()
                }else{
                    Snackbar.make(recyclerView,"No data retrieved",Snackbar.LENGTH_LONG)
                        .apply {
                            animationMode = Snackbar.ANIMATION_MODE_SLIDE
                            show()
                        }
                }
            }
        })
        mainViewModel.makeApiCall()
    }
}