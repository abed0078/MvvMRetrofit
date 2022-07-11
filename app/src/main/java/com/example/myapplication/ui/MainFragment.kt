package com.example.myapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.RecyclerViewAdapter
import com.example.myapplication.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val mainViewModel by viewModels<MainViewModel>()
    private lateinit var recyclerAdapter: RecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return _binding!!.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        mainViewModel.getAppResponseLiveData().observe(viewLifecycleOwner) {
            if (it != null) {
                binding.recyclerView.apply {

                    layoutManager = LinearLayoutManager(context)

                    recyclerAdapter = RecyclerViewAdapter(this@MainFragment, it)
                    binding.recyclerView.adapter=recyclerAdapter
                }
            }
        }
        mainViewModel.getMethod()

    }
}

