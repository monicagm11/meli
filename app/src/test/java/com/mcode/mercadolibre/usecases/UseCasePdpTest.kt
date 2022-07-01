package com.mcode.mercadolibre.usecases

import com.mcode.mercadolibre.models.api.*
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Test
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

class UseCasePdpTest {
    var useCasePdp: UseCasePdp = UseCasePdp()
    val lock: CountDownLatch = CountDownLatch(1)

    @Test
    fun `getPicturesUrlCorrectly`(){
        val picture = Pictures(url = "imagen_de_pruebaa.jpg")
        Assert.assertEquals(listOf("imagen_de_pruebaa.jpg"), useCasePdp.getPicturesUrl(listOf(picture)))
    }

    @Test
    fun `getLocationCorrectly`(){
        val sellerAddress = SellerAddress(city = City(name = "Barranquilla"), state = State(name = "Atlántico"))
        Assert.assertEquals("Barranquilla, Atlántico", useCasePdp.getLocationText(sellerAddress))
    }

    @Test
    fun `getAttributesEmptyCorrectly`(){
        val attribute1 = Attributes(id = "1", name= null, valueName = "value _1", valueId = 1)
        Assert.assertTrue(useCasePdp.getAttributesList(listOf(attribute1)).isEmpty())
    }

    @Test
    fun getDetailProductListCorrectly() = runBlockingTest{
        var assert : Boolean? = null
        useCasePdp.getDetailProductList("Motorola",
            onSuccess = {
                assert = true
            }, onFailure = {
                assert = false
            })

        lock.await(10000, TimeUnit.MILLISECONDS)
        Assert.assertNotNull(assert)
    }
}