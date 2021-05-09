package com.example.petsapp25042021.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.petsapp25042021.R
import com.example.petsapp25042021.databinding.FragmentBlankOneBinding

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragmentOne.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragmentOne : Fragment() {

    lateinit var binding: FragmentBlankOneBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_blank_one,container,false)

        binding.floatingActionButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_blankFragmentOne_to_blankFragmentTwo) }

        return binding.root
    }
}