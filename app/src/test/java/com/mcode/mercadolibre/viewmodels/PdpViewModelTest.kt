package com.mcode.mercadolibre.viewmodels

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PdpViewModelTest {

    lateinit var pdpViewModel: PdpViewModel
    val thread = newSingleThreadContext("UI thread")

    var application: Application? = null

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp(){
        Dispatchers.setMain(thread)
        application = mockk(relaxUnitFun = true)
        pdpViewModel = PdpViewModel(application!!)
    }

    @After
    fun tearDown(){
        Dispatchers.resetMain()
        application = null
        thread.close()
    }

    @Test
    fun `showLoadingCorrectly`(){
        pdpViewModel.showLoading()
        assertTrue(pdpViewModel.showLoading.value!!)
    }

    @Test
    fun `showEmptyCorrectly`(){
        pdpViewModel.showEmptyState()
        assertTrue(pdpViewModel.showEmptyState.value!!)
    }

    @Test
    fun `showPdpContentCorrectly`(){
        pdpViewModel.showPdpContent()
        assertTrue(pdpViewModel.showPdpContent.value!!)
    }

}