package com.example.papewall.fragments

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class PopularFragment : ()  {
    private val viewModel: PopularViewModel by viewModels()
    override var recyclerViewAdapter: RecyclerViewAdapter = RecyclerViewAdapter(this)

    override fun initViewModel() {
        lifecycleScope.launch  {
            viewModel.popularPage.collectLatest {
                recyclerViewAdapter.submitData(it)
            }
        }

    }



}