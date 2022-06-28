package com.mcode.mercadolibre.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.*

class PlpViewModelTest {

    lateinit var plpViewModel: PlpViewModel
    val thread = newSingleThreadContext("UI thread")

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp(){
        Dispatchers.setMain(thread)
        plpViewModel = PlpViewModel()
    }

    @Test
    fun `startGoSearchNavigationCorrectly`() = runBlockingTest{
        plpViewModel.initNavigateToSearch()
        Assert.assertTrue(plpViewModel.navigateToSearch.value!!)
    }

    @Test
    fun `clearGoSearchNavigationCorrectly`() = runBlockingTest{
        plpViewModel.clearNavigateToSearch()
        Assert.assertNull(plpViewModel.navigateToSearch.value)
    }

    @After
    fun tearDown(){
        Dispatchers.resetMain()
        thread.close()
    }



}