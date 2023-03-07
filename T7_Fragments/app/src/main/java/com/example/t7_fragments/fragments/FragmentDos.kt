package com.example.t7_fragments.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.t7_fragments.databinding.FragmentDosBinding


class FragmentDos : Fragment(){
    private lateinit var binding: FragmentDosBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDosBinding.inflate(inflater, container, false)
        return binding.root
    }
}