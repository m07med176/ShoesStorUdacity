package com.udacity.shoestore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoesListViewModel:ViewModel() {
    private val shoesListData = MutableLiveData<MutableList<Shoe>>() // create Mutable Live List Private
    val shoesList: LiveData<MutableList<Shoe>>                       // create UnMutable Live List Public

    get() = shoesListData



    fun addShoe(shoe: Shoe) {
        if (shoesListData.value == null) {
            shoesListData.value = mutableListOf(shoe)
        } else {
            shoesListData.value?.add(shoe)
        }
    }

    fun isShoesEmpty(): Boolean {
        // return boolean if Data list have Null Value or Have Empty String
        return shoesListData.value == null || shoesListData.value?.isEmpty() == true
    }
}