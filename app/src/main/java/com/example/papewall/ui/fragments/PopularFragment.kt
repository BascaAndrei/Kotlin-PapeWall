package com.example.papewall.ui.fragments

import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.paging.LoadState
import androidx.recyclerview.widget.GridLayoutManager
import com.example.papewall.databinding.FragmentPopularBinding
import com.example.papewall.model.domain.Data
import com.example.papewall.model.paging.loadingState.LoadStateAdapter
import com.example.papewall.recyclerView.RecyclerViewAdapter
import com.example.papewall.recyclerView.WallInteractionListener
import com.khater.retromvvm.ui.fragments.base.BaseFragment
import com.khater.retromvvm.viewModels.PopularViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class PopularFragment : BaseFragment ()  {
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