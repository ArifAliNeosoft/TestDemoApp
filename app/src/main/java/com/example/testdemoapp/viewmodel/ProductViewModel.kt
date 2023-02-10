package com.example.testdemoapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.testdemoapp.models.DummyDataModel
import com.example.testdemoapp.models.ProductSliderModel

class ProductViewModel : ViewModel() {
    private val product = DummyDataModel.getProduct()
    fun getProductList(): List<ProductSliderModel> {
        return product
    }


}