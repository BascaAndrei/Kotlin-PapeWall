package com.example.papewall.recyclerView

import android.view.View
import com.example.papewall.model.domain.Data

interface WallInteractionListener {
    fun onClickItem(data : Data, view: View)
}