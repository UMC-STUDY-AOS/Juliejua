package com.example.umc_flo


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.umc_flo.databinding.FragmentSongfileBinding
import com.example.umc_flo.databinding.FragmentStorageBinding

class StorageFragment : Fragment(){

    lateinit var binding: FragmentStorageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentStorageBinding.inflate(inflater, container, false)
        return binding.root
    }
}