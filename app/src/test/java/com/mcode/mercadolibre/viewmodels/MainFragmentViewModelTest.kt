package com.mcode.mercadolibre.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import junit.framework.Assert.assertNull
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainFragmentViewModelTest {

    lateinit var mainFragmentViewModel:  MainFragmentViewModel
    val thread = newSingleThreadContext("UI thread")

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp(){
        Dispatchers.setMain(thread)
        mainFragmentViewModel = MainFragmentViewModel()
    }

    @Test
    fun `startGoSearchNavigationCorrectly`() = runBlockingTest{
        mainFragmentViewModel.startGoSearchNavigation()
        assertTrue(mainFragmentViewModel.goSearchNavigation.value!!)
    }

    @Test
    fun `clearGoSearchNavigationCorrectly`() = runBlockingTest{
        mainFragmentViewModel.clearGoSearchNevigation()
        assertNull(mainFragmentViewModel.goSearchNavigation.value)
    }

    @After
    fun tearDown(){
        Dispatchers.resetMain()
        thread.close()
    }
}