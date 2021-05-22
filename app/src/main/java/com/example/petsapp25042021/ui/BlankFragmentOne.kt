package com.example.petsapp25042021.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.petsapp25042021.R
import com.example.petsapp25042021.data.PetDatabase
import com.example.petsapp25042021.databinding.FragmentBlankOneBinding
import com.example.petsapp25042021.viewmodels.PetsViewModel
import com.example.petsapp25042021.viewmodels.PetsViewModelFactory

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragmentOne.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragmentOne : Fragment() {

    lateinit var binding: FragmentBlankOneBinding
    lateinit var viewModel: PetsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_blank_one,container,false)

        setHasOptionsMenu(true)

        val application = requireActivity().application
        val dataSource = PetDatabase.getInstance(application).petDatabaseDao
        val viewModelFactory = PetsViewModelFactory(dataSource, application)

        viewModel = ViewModelProvider(requireActivity(), viewModelFactory)
            .get(PetsViewModel::class.java)

        binding.floatingActionButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_blankFragmentOne_to_blankFragmentTwo) }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_pets, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_insert_dummy_data -> true
            R.id.action_delete_all_entries -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}