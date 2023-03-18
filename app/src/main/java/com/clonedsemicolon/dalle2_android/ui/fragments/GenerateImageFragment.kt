package com.clonedsemicolon.dalle2_android.ui.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.clonedsemicolon.dalle2_android.R
import com.clonedsemicolon.dalle2_android.common.ImageProgressStatus
import com.clonedsemicolon.dalle2_android.common.ext.GlideImageView
import com.clonedsemicolon.dalle2_android.data.model.RequestModel
import com.clonedsemicolon.dalle2_android.databinding.FragmentGenerateImageBinding
import com.clonedsemicolon.dalle2_android.ui.viewmodel.GenerateImageViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class GenerateImageFragment : Fragment() {

    companion object {
        fun newInstance() = GenerateImageFragment()
    }

    private lateinit var viewModel: GenerateImageViewModel
    private lateinit var binding: FragmentGenerateImageBinding
    private val hdImageSize = "1024x1024"

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
        viewModel = ViewModelProvider(this)[GenerateImageViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    init {
        binding.btnGenerate.setOnClickListener {
            val promptText = binding.etPrompt.text.toString()
            if(promptText.isNotBlank()){
                viewModel.generateImageFromPrompt(RequestModel(6,promptText,hdImageSize))
            }
        }

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.state.collect{
                when(it){
                    is ImageProgressStatus.Success -> {
                        binding.glGridGenerateImage.visibility = View.VISIBLE
                        GlideImageView.loadImage(requireContext(),binding.generatedImageView,it.data.items[0].url)
                        GlideImageView.loadImage(requireContext(),binding.generatedImageView2,it.data.items[1].url)
                        GlideImageView.loadImage(requireContext(),binding.generatedImageView3,it.data.items[2].url)
                        GlideImageView.loadImage(requireContext(),binding.generatedImageView4,it.data.items[3].url)
                        GlideImageView.loadImage(requireContext(),binding.generatedImageView5,it.data.items[4].url)
                        GlideImageView.loadImage(requireContext(),binding.generatedImageView6,it.data.items[5].url)
                    }

                    is ImageProgressStatus.Error -> {
                        binding.glGridGenerateImage.visibility = View.GONE
                    }

                    else -> {}
                }
            }
        }
    }

}