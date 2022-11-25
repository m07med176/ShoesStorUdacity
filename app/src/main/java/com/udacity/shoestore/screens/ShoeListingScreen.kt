package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.udacity.shoestore.R
import com.udacity.shoestore.viewmodel.ShoesListViewModel
import com.udacity.shoestore.databinding.FragmentShoeListingScreenBinding
import com.udacity.shoestore.databinding.ItemListShoeBinding
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.models.Shoe

class ShoeListingScreen : Fragment() {

    val viewModel: ShoesListViewModel by activityViewModels()
    lateinit var binding: FragmentShoeListingScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_listing_screen,
            container,
            false)

        setHasOptionsMenu(true)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.fab.setOnClickListener {
            findNavController().navigate(ShoeListingScreenDirections.actionShoeListFragmentToShoeDetailFragment())
        }
        return binding.root
    }

    private fun addShoeToView(
        container: ViewGroup?,
        shoe: Shoe
    ) {
        val itemViewList: ItemListShoeBinding = DataBindingUtil.inflate(
            layoutInflater, R.layout.item_list_shoe, container, false
        )
        itemViewList.shoe = shoe
        binding.itemList.addView(itemViewList.root)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        findNavController().navigate(ShoeListingScreenDirections.actionShoeListFragmentToLoginFragment())
        return true
    }
}