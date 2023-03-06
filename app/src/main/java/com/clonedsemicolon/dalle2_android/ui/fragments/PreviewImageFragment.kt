package com.clonedsemicolon.dalle2_android.ui.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clonedsemicolon.dalle2_android.R
import com.clonedsemicolon.dalle2_android.ui.viewmodel.PreviewImageViewModel

class PreviewImageFragment : Fragment() {

    companion object {
        fun newInstance() = PreviewImageFragment()
    }

    private lateinit var viewModel: PreviewImageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_preview_image, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PreviewImageViewModel::class.java)
        // TODO: Use the ViewModel
    }

}