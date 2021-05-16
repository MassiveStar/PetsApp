package com.example.petsapp25042021.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.petsapp25042021.R
import com.example.petsapp25042021.data.PetDatabase
import com.example.petsapp25042021.databinding.FragmentBlankTwoBinding
import com.example.petsapp25042021.viewmodels.PetsViewModel
import com.example.petsapp25042021.viewmodels.PetsViewModelFactory

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragmentTwo.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragmentTwo : Fragment() {

    lateinit var binding: FragmentBlankTwoBinding
    lateinit var viewModel: PetsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_blank_two,container,false)

        val application = requireActivity().application
        val dataSource = PetDatabase.getInstance(application).petDatabaseDao
        val viewModelFactory = PetsViewModelFactory(dataSource, application)

        viewModel = ViewModelProvider(requireActivity(), viewModelFactory)
            .get(PetsViewModel::class.java)

        binding.buttonSecond.setOnClickListener {
            it.findNavController().navigate(R.id.action_blankFragmentTwo_to_blankFragmentOne)
        }

        return binding.root
    }
}