package com.mcode.mercadolibre.usecases

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mcode.mercadolibre.models.api.PriceItem
import com.mcode.mercadolibre.models.plp.PricePlp
import com.mcode.mercadolibre.viewmodels.PlpViewModel
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.*
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit


class UseCasePlpTest{

    val lock: CountDownLatch = CountDownLatch(1)
    var useCasePlp: UseCasePlp = UseCasePlp()

    val thread = newSingleThreadContext("UI thread")

    var application: Application? = null

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp(){
        Dispatchers.setMain(thread)
        application = mockk(relaxUnitFun = true)
    }

    @Test
    fun `getPricePlpCorrectly`(){
        val priceItem = PriceItem("1", "promotion", 800000F, 1000000F, "COP")
        val expected = PricePlp("$ 800.000", "COP", "20% OFF")
        Assert.assertEquals(expected, useCasePlp.getPricePlp(priceItem))
    }

    @Test
    fun `getPricePlpInCorrectly`(){
        val priceItem = PriceItem("1", "promotion", 800000F, 0F, "COP")
        val expected = PricePlp("$ 800.000", "COP", "20% OFF")
        Assert.assertNotEquals(expected, useCasePlp.getPricePlp(priceItem))
    }

    @Test
    fun `getPriceCorrectly`(){
        val priceItem = PriceItem("1", "promotion", 800000F, 1000000F, "COP")
        val priceItem2 = PriceItem("1", "standard", 800000F, 0F, "COP")

        val array = arrayListOf(priceItem, priceItem2)
        Assert.assertEquals(priceItem, useCasePlp.getPrice(array))
    }

    @Test
    fun getSearchProductListTest() = runBlockingTest{
        var assert : Boolean? = null
        useCasePlp.getSearchProductList("Motorola",
            onSuccess = {
                assert = true
            }, onFailure = {
                assert = false
            })

        lock.await(10000, TimeUnit.MILLISECONDS)
        Assert.assertNotNull(assert)
    }

    @After
    fun tearDown(){
        Dispatchers.resetMain()
        application = null
        thread.close()
    }
}