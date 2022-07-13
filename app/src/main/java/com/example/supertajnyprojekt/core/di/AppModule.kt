package com.example.supertajnyprojekt.core.di

import android.content.Context
import android.net.ConnectivityManager
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.supertajnyprojekt.R
import com.example.supertajnyprojekt.core.exception.ErrorMapper
import com.example.supertajnyprojekt.core.exception.ErrorMapperImpl
import com.example.supertajnyprojekt.core.exception.ErrorWrapper
import com.example.supertajnyprojekt.core.exception.ErrorWrapperImpl
import com.example.supertajnyprojekt.core.navigation.FragmentNavigator
import com.example.supertajnyprojekt.core.navigation.FragmentNavigatorImpl
import com.example.supertajnyprojekt.core.network.NetworkStateProviderImpl
import com.example.supertajnyprojekt.core.provider.ActivityProvider
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    factory { LinearLayoutManager(androidContext()) }
    factory { GridLayoutManager(androidContext(), 2) }
    factory { DividerItemDecoration(androidContext(), LinearLayoutManager.VERTICAL) }
    factory { androidContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager }
    factory { NetworkStateProviderImpl(get()) }
    factory<ErrorWrapper> { ErrorWrapperImpl() }
    factory<ErrorMapper> { ErrorMapperImpl(androidContext()) }
    single(createdAtStart = true) { ActivityProvider(androidApplication()) }
    factory<FragmentNavigator> {
        FragmentNavigatorImpl(
            activityProvider = get(),
            navHostFragmentRes = R.id.nav_host_fragment,
            homeDestinationRes = R.id.characters_screen
        )
    }
}