

package com.bewizyu.mvvmarchitecture.core.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bewizyu.mvvmarchitecture.app.common.ViewModelProviderFactory
import com.bewizyu.mvvmarchitecture.app.home.viewmodel.HomeViewModel

import com.bewizyu.mvvmarchitecture.app.login.viewmodel.LoginViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(lvm: LoginViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(hvm: HomeViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory
}
