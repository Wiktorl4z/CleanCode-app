package com.example.supertajnyprojekt.features.characters.presentation

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.supertajnyprojekt.BR
import com.example.supertajnyprojekt.R
import com.example.supertajnyprojekt.core.base.BaseFragment
import com.example.supertajnyprojekt.databinding.FragmentCharacterBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class CharacterFragment : BaseFragment<CharacterViewModel, FragmentCharacterBinding>(
    BR.characterViewModel,
    R.layout.fragment_character
) {

    override val viewModel: CharacterViewModel by viewModel()

    private val linearLayoutManager: LinearLayoutManager by inject()
    private val divider: DividerItemDecoration by inject()
    private val characterAdapter: CharacterAdapter by inject()

    override fun initViews(binding: FragmentCharacterBinding) {
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

    private fun initRecycler(binding: FragmentCharacterBinding) {
        with(binding.recyclerView) {
            layoutManager = linearLayoutManager
            addItemDecoration(divider)
            setHasFixedSize(true)
            adapter = characterAdapter
        }
        characterAdapter.setOnCharacterClickListener { viewModel.onCharacterClick(it) }
    }
}