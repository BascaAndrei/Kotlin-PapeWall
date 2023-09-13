package com.example.papewall.ui.fragments


import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.papewall.recyclerView.RecyclerViewAdapter
import com.example.papewall.ui.fragments.base.BaseFragment
import com.example.papewall.viewModels.HomeViewModel
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
