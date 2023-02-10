package com.example.testdemoapp.models

import com.example.testdemoapp.R

class DummyDataModel {
    companion object {

        var viewPagerModelList = ArrayList<ProductSliderModel>()
        fun getProduct(): List<ProductSliderModel> {
            var productList1 = ArrayList<ProductListModel>()
            productList1.add(ProductListModel(R.drawable.car1,"ProductName 1"))
            productList1.add(ProductListModel(R.drawable.car1,"ProductName 2"))
            productList1.add(ProductListModel(R.drawable.car1,"ProductName 3"))
            productList1.add(ProductListModel(R.drawable.car1,"ProductName 4"))
            productList1.add(ProductListModel(R.drawable.car1,"ProductName 5"))
            productList1.add(ProductListModel(R.drawable.car1,"ProductName 6"))
            viewPagerModelList.add(ProductSliderModel(0,R.drawable.car1,productList1))

            var productList2 = ArrayList<ProductListModel>()
            productList2.add(ProductListModel(R.drawable.car1,"ProductName 1"))
            productList2.add(ProductListModel(R.drawable.car1,"ProductName 2"))
            viewPagerModelList.add(ProductSliderModel(1,R.drawable.car1,productList2))

            var productList3 = ArrayList<ProductListModel>()
            productList3.add(ProductListModel(R.drawable.car1,"ProductName 1"))
            productList3.add(ProductListModel(R.drawable.car1,"ProductName 2"))
            productList3.add(ProductListModel(R.drawable.car1,"ProductName 3"))
            productList3.add(ProductListModel(R.drawable.car1,"ProductName 4"))
            viewPagerModelList.add(ProductSliderModel(2,R.drawable.car1,productList3))

            var productList4 = ArrayList<ProductListModel>()
            productList4.add(ProductListModel(R.drawable.car1,"ProductName 1"))
            productList4.add(ProductListModel(R.drawable.car1,"ProductName 2"))
            productList4.add(ProductListModel(R.drawable.car1,"ProductName 3"))
            productList4.add(ProductListModel(R.drawable.car1,"ProductName 4"))
            productList4.add(ProductListModel(R.drawable.car1,"ProductName 5"))
            productList4.add(ProductListModel(R.drawable.car1,"ProductName 6"))
            productList4.add(ProductListModel(R.drawable.car1,"ProductName 7"))
            productList4.add(ProductListModel(R.drawable.car1,"ProductName 8"))
            productList4.add(ProductListModel(R.drawable.car1,"ProductName 9"))
            viewPagerModelList.add(ProductSliderModel(3,R.drawable.car1,productList4))

            return viewPagerModelList
        }


    }


}