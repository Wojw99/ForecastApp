package com.example.forecastapp.view

import android.icu.util.LocaleData
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.forecastapp.databinding.FragmentListBinding
import com.example.forecastapp.model.HistDailyTest
import com.example.forecastapp.model.HistoricalDailyModel
import com.example.forecastapp.viewmodel.HistoricalDailyWeatherViewModel
import java.sql.*

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    lateinit var historyweather:HistoricalDailyWeatherViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentListBinding.inflate(inflater, container, false)

        val adapter = ListAdapter()
        binding.recyclerViewList.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewList.adapter = adapter


        historyweather = ViewModelProvider(this).get(HistoricalDailyWeatherViewModel::class.java)

val history1=HistoricalDailyModel(1,1,
       1,1,2.2,2.2,
        1,1,1.1,1.1,1.1,"",1.1,1.1,1.1)

        val history2=HistoricalDailyModel(2,4,
                6,1,5.2,2.2,
                1,1,1.1,1.1,1.1,"",1.1,1.1,1.1)


        historyweather.addhistoricalweather(history1)
        historyweather.addhistoricalweather(history2)

        var test = historyweather.historicalall

        Log.d("test", test.toString())

        adapter.setData(
            listOf(
                HistDailyTest(
                1,1, Date(2021,1,23),Date(2021,1,20),
                "Gliwice",52.2342,18.5452,"?",1,1,2.2,2.2,
                1,1,1.1,1.1,1.1,"",1.1,1.1,1.1),
                HistDailyTest(
                    1,1, Date(2021,1,24),Date(2021,1,20),
                    "Paniówki",52.2342,18.5452,"?",1,1,2.2,2.2,
                    1,1,1.1,1.1,1.1,"",1.1,1.1,1.1),
                HistDailyTest(
                    1,1, Date(2021,1,25),Date(2021,1,20),
                    "Katowice",52.2342,18.5452,"70%",1,1,2.2,2.2,
                    1,1,1.1,1.1,1.1,"",1.1,1.1,1.1)
            )
        )

        return binding.root
    }

/*
lateinit var listViewModel: ListViewModel
    lateinit var viewManager: RecyclerView.LayoutManager
    lateinit var adapterweatherlist: Adapterweatherlist
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listViewModel = ViewModelProvider(requireActivity()).get(ListViewModel::class.java)


        viewManager = LinearLayoutManager(requireContext())

        adapterweatherlist = Adapterweatherlist(listViewModel.forecastBody)

        recyclerViewWeather.apply {
            adapter = adapterweatherlist
            layoutManager = viewManager
        }


       // listViewModel.forecastBody.observe(viewLifecycleOwner, Observer {
       //     adapterweatherlist.notifyDataSetChanged()
       // })
    }

     */
}