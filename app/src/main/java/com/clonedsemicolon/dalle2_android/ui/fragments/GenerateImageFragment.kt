package com.clonedsemicolon.dalle2_android.ui.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clonedsemicolon.dalle2_android.R
import com.clonedsemicolon.dalle2_android.databinding.FragmentGenerateImageBinding
import com.clonedsemicolon.dalle2_android.ui.viewmodel.GenerateImageViewModel

class GenerateImageFragment : Fragment() {

    companion object {
        fun newInstance() = GenerateImageFragment()
    }

    private lateinit var viewModel: GenerateImageViewModel
    private lateinit var binding: FragmentGenerateImageBinding
    private val hdImageSize = 1024

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGenerateImageBinding.inflate(inflater)
        return inflater.inflate(R.layout.fragment_generate_image, container, false)
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GenerateImageViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    init {
        binding.btnGenerate.setOnClickListener {

        }
    }

}