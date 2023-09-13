package com.example.papewall.recyclerView

import android.view.View
import com.example.papewall.databinding.ItemViewpagerBinding
import com.example.papewall.model.domain.Data

interface ViewPagerInterface{
    fun positionItem(data:Data, position:Int)
    fun onClickCategory(data : Data, view: View,binding: ItemViewpagerBinding)
}