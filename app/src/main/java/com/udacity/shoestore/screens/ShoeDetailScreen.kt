package com.udacity.shoestore.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginScreenBinding
import com.udacity.shoestore.databinding.FragmentShoeDetailScreenBinding
import com.udacity.shoestore.viewmodel.ShoeDetailsViewModel
import com.udacity.shoestore.viewmodel.ShoesListViewModel

class ShoeDetailScreen : Fragment() {
    val shoesViewModel: ShoesListViewModel by activityViewModels()
    lateinit var shoeDetailsViewModel: ShoeDetailsViewModel
    lateinit var binding: FragmentShoeDetailScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_detail_screen,
            container,
            false)

        shoeDetailsViewModel = ViewModelProvider(this)[ShoeDetailsViewModel::class.java]
        binding.viewModel = shoeDetailsViewModel
        binding.lifecycleOwner = this


        binding.cancelButton.setOnClickListener {
            findNavController().navigate(ShoeDetailScreenDirections.actionShoeDetailFragmentToShoeListFragment())
        }

        binding.saveButton.setOnClickListener {
            if (shoeDetailsViewModel.validateFields()) {
                val shoe = shoeDetailsViewModel.buildShoe()
                shoesViewModel.addShoe(shoe)
                findNavController().navigate(ShoeDetailScreenDirections.actionShoeDetailFragmentToShoeListFragment())
            } else {
                Toast.makeText(context, getString(R.string.empty_alert), Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

}