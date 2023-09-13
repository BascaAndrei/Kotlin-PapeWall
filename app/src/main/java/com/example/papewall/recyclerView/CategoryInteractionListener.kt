package com.example.papewall.recyclerView

import android.view.View
import com.example.papewall.model.domain.Category

interface CategoryInteractionListener {
    fun onClickCategory(category :Category, view: View)
}