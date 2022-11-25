package com.udacity.shoestore.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailScreenBinding
import com.udacity.shoestore.databinding.FragmentShoeListingScreenBinding


class ShoeListingScreen : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentShoeListingScreenBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_listing_screen,
            container,
            false)

        return binding.root
    }
}