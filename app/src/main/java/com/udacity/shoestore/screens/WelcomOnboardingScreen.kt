package com.udacity.shoestore.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListingScreenBinding
import com.udacity.shoestore.databinding.FragmentWelcomeOnboardingScreenBinding

class WelcomOnboardingScreen : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentWelcomeOnboardingScreenBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_welcome_onboarding_screen,
            container,
            false)

        binding.instructionsButton.setOnClickListener {
            findNavController().navigate(WelcomOnboardingScreenDirections.actionWelcomeFragmentToInstructionsFragment())
        }

        return binding.root
    }
}