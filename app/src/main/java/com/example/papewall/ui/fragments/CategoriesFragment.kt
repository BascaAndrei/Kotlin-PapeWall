package com.example.papewall.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
 import com.example.papewall.databinding.FragmentCategoriesBinding
import com.example.papewall.model.domain.Category
import com.example.papewall.recyclerView.CategoriesAdapter
import com.example.papewall.recyclerView.CategoryInteractionListener
import com.example.papewall.utils.ApiListCategory


class CategoriesFragment : Fragment() ,CategoryInteractionListener{
    private lateinit var binding: FragmentCategoriesBinding

    private lateinit var recyclerViewAdapter :CategoriesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoriesBinding.inflate(inflater, container, false)
        recyclerAdapter()

        return binding.root
    }

    private fun recyclerAdapter() {
        val layoutManager = GridLayoutManager(context, 2)
        recyclerViewAdapter = CategoriesAdapter(ApiListCategory.list,this)
        binding.categoriesRecyclerView.layoutManager = layoutManager
        binding.categoriesRecyclerView.adapter = recyclerViewAdapter
    }

    override fun onClickCategory(category: Category, view: View) {
        val action = MainFragmentDirections.actionTestFragmentToSpecificCategoryFragment(category.categoryName)
        Navigation.findNavController(view)
            .navigate(action)

    }


}