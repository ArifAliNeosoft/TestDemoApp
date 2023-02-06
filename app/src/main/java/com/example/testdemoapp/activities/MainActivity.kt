package com.example.testdemoapp.activities


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.example.testdemoapp.R
import com.example.testdemoapp.adapter.ListDataAdapater
import com.example.testdemoapp.adapter.ViewPagerAdapter
import com.example.testdemoapp.databinding.ActivityMainBinding
import com.example.testdemoapp.models.ListModel
import com.example.testdemoapp.models.ViewPagerModel



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        getSupportActionBar()!!.hide()
        setContentView(binding.root)
        val list = ArrayList<ListModel>()
        list.add(ListModel(R.drawable.search, "Test"))
        var viewPagerModel = ArrayList<ViewPagerModel>()
        var mainList = ViewPagerModel(0, R.drawable.car1, list)
        viewPagerModel.add(mainList)
        viewPagerModel.add(mainList)
        viewPagerModel.add(mainList)
        viewPagerModel.add(mainList)
        binding.viewPager.adapter = ViewPagerAdapter(viewPagerModel)
        binding.tabLayout.setupWithViewPager(binding.viewPager)
        var layoutManager = LinearLayoutManager(
            this@MainActivity,
            LinearLayoutManager.VERTICAL,
            false
        )


        var rvDataList = ArrayList<String>()
        rvDataList.add("TEST")
        rvDataList.add("DATA")
        rvDataList.add("TEST")
        rvDataList.add("DATA")
        rvDataList.add("TEST")
        rvDataList.add("DATA")
        rvDataList.add("TEST")
        rvDataList.add("DATA")
        rvDataList.add("TEST")
        rvDataList.add("DATA")
        binding.rvList.layoutManager = layoutManager

        binding.rvList.adapter =
            ListDataAdapater(applicationContext, MainActivity(), rvDataList, 10)


        binding.viewPager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                if (position == 0) {
                    binding.rvList.adapter =
                        ListDataAdapater(applicationContext, MainActivity(), rvDataList, 10)
                } else if (position == 1) {
                    binding.rvList.adapter =
                        ListDataAdapater(applicationContext, MainActivity(), rvDataList, 4)
                } else if (position == 2) {
                    binding.rvList.adapter =
                        ListDataAdapater(applicationContext, MainActivity(), rvDataList, 1)
                } else if (position == 3) {
                    binding.rvList.adapter =
                        ListDataAdapater(applicationContext, MainActivity(), rvDataList, 6)
                }

            }
        })

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
                if (s.length != 0) {
                    val rvDataList1 = ArrayList<String>()
                    rvDataList1.clear()
                    for (list in rvDataList) {
                        if (list.contains(s.toString(), ignoreCase = true)) {

                            rvDataList1.add(list)

                        }
                    }
                    binding.rvList.adapter =
                        ListDataAdapater(applicationContext, MainActivity(), rvDataList1, 0)
                } else {
                    binding.rvList.adapter =
                        ListDataAdapater(applicationContext, MainActivity(), rvDataList, 10)
                }
            }
        })

    }
}