package com.mcode.mercadolibre.usecases

import com.mcode.mercadolibre.models.api.PriceItem
import com.mcode.mercadolibre.models.plp.PricePlp
import org.junit.Assert
import org.junit.Test


class UseCasePlpTest{

    var useCasePlp: UseCasePlp = UseCasePlp()
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
}