package com.example.supertajnyprojekt.features.locations.presentation

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.supertajnyprojekt.BR
import com.example.supertajnyprojekt.R
import com.example.supertajnyprojekt.core.base.BaseFragment
import com.example.supertajnyprojekt.databinding.FragmentLocationBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class LocationFragment :
    BaseFragment<LocationViewModel, FragmentLocationBinding>(
        BR.locationViewModel,
        R.layout.fragment_location
    ) {

    override val viewModel: LocationViewModel by viewModel()

    private val linearLayoutManager: LinearLayoutManager by inject()
    private val divider: DividerItemDecoration by inject()
    private val locationAdapter: LocationAdapter by inject()

    override fun initViews(binding: FragmentLocationBinding) {
        super.initViews(binding)
        initRecycler(binding)
    }

    override fun onDestroyView() {
        binding?.recyclerView?.let {
            it.layoutManager = null
            it.adapter = null
        }
        super.onDestroyView()
    }

    private fun initRecycler(binding: FragmentLocationBinding) {
        with(binding.recyclerView) {
            layoutManager = linearLayoutManager
            addItemDecoration(divider)
            setHasFixedSize(true)
            adapter = locationAdapter
        }
        locationAdapter.setOnLocationClickListener { viewModel.onLocationClick(it) }
    }
}