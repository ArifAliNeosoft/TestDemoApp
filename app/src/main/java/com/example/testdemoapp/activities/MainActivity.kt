package com.example.testdemoapp.activities


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.example.testdemoapp.adapter.ProductListAdapter
import com.example.testdemoapp.adapter.ProductSliderAdapter
import com.example.testdemoapp.databinding.ActivityMainBinding
import com.example.testdemoapp.models.ProductListModel
import com.example.testdemoapp.viewmodel.ProductViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var positionOfSearch: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        getSupportActionBar()!!.hide()
        setContentView(binding.root)
        val productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
        binding.viewPager.adapter = ProductSliderAdapter(productViewModel.getProductList())
        binding.tabLayout.setupWithViewPager(binding.viewPager)
        var layoutManager = LinearLayoutManager(
            this@MainActivity,
            LinearLayoutManager.VERTICAL,
            false
        )
        binding.rvList.layoutManager = layoutManager
        binding.rvList.adapter =
            ProductListAdapter(
                productViewModel.getProductList().get(0).list
            )

        CoroutineScope(Dispatchers.Main).launch {
            sliderDataChange(productViewModel)
            searchByProductName(productViewModel)
        }


    }

    private fun sliderDataChange(productViewModel: ProductViewModel) {
        binding.viewPager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                positionOfSearch = position
                binding.rvList.adapter =
                    ProductListAdapter(
                        productViewModel.getProductList().get(position).list
                    )
            }
        })
    }

    private fun searchByProductName(productViewModel: ProductViewModel) {
        binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                val rvProductList = ArrayList<ProductListModel>()
                rvProductList.clear()
                if (s.length != 0) {
                    for (list in productViewModel.getProductList().get(positionOfSearch).list) {
                        if (list.title.contains(s.toString(), ignoreCase = true)) {
                            rvProductList.add(list)
                        }
                    }
                    binding.rvList.adapter =
                        ProductListAdapter(
                            rvProductList
                        )
                } else {
                    binding.rvList.adapter =
                        ProductListAdapter(
                            productViewModel.getProductList().get(positionOfSearch).list
                        )
                }
            }
        })
    }
}