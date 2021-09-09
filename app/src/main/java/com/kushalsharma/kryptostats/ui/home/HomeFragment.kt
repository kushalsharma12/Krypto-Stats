package com.kushalsharma.kryptostats.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.kushalsharma.kryptostats.KryptoInterface
import com.kushalsharma.kryptostats.RetrofitService
import com.kushalsharma.kryptostats.databinding.FragmentHomeBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var homeAdapter : HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        val retrofitService = RetrofitService()
        val api = retrofitService.getInstance().create(KryptoInterface::class.java)
        GlobalScope.launch {
            val result = api.getCoins()
            if (result != null) {
                val resultArray = result.body()
                if (resultArray != null) {

                    resultArray.forEach {
                        Log.d("yum", it.name.toString())
                        homeAdapter = HomeAdapter(this@HomeFragment,it)
                        binding.coinRecyclerView.adapter = homeAdapter
                    }
                }
            }

        }



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}