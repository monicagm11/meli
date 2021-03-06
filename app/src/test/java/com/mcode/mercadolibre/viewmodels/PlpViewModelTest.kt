package com.mcode.mercadolibre.viewmodels

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.*

class PlpViewModelTest {

    lateinit var plpViewModel: PlpViewModel
    val thread = newSingleThreadContext("UI thread")

    var application: Application? = null

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp(){
        Dispatchers.setMain(thread)
        application = mockk(relaxUnitFun = true)
        plpViewModel = PlpViewModel(application!!)
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
        application = null
        thread.close()
    }



}