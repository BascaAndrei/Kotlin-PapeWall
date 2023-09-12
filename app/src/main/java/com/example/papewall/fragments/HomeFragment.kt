package com.example.papewall.fragments

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class HomeFragment : BaseFragment (
)  {

    private val viewModel: HomeViewModel by viewModels()

    override fun initViewModel() {
        lifecycleScope.launch {
            viewModel.homePage.collectLatest {
                recyclerViewAdapter.submitData(it)
            }
        }
    }


    override var recyclerViewAdapter: RecyclerViewAdapter = RecyclerViewAdapter(this)




}