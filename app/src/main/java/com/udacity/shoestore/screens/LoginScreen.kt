package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginScreenBinding


class LoginScreen : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentLoginScreenBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_login_screen,
            container,
            false)

        binding.buttonSignUp.setOnClickListener {
            findNavController().navigate(LoginScreenDirections.actionLoginFragmentToWelcomeFragment())
        }

        binding.buttonLogin.setOnClickListener {
            findNavController().navigate(LoginScreenDirections.actionLoginFragmentToWelcomeFragment())
        }

        return binding.root
    }
}