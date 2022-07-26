package com.example.supertajnyprojekt.features.locations.details.presentation

import com.example.supertajnyprojekt.BR
import com.example.supertajnyprojekt.R
import com.example.supertajnyprojekt.core.base.BaseFragment
import com.example.supertajnyprojekt.databinding.FragmentLocationDetailsBinding
import com.example.supertajnyprojekt.features.locations.presentation.model.LocationDisplayable
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationDetailsFragment :
    BaseFragment<LocationDetailsViewModel, FragmentLocationDetailsBinding>(
        BR.locationDetailsViewModel,
        R.layout.fragment_location_details
    ) {

    override val viewModel: LocationDetailsViewModel by viewModel()

    companion object {
        const val LOCATION_DETAILS_KEY = "locationDetailsKey"
    }

    override fun initObservers() {
        super.initObservers()
        getLocation()
    }

    private fun getLocation() {
        arguments?.getParcelable<LocationDisplayable>(LOCATION_DETAILS_KEY)
            ?.let {
                viewModel.passLocation(it)
            }
    }
}