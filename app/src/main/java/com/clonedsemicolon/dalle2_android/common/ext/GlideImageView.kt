package com.clonedsemicolon.dalle2_android.common.ext

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.clonedsemicolon.dalle2_android.R
import jp.wasabeef.glide.transformations.BlurTransformation

object GlideImageView{

    fun loadImage(
        context: Context,
        imageView:ImageView,
        imageUrl:String,
        isBlur:Boolean = false){

        when(isBlur){
            isBlur -> loadBlurImageIntoImageView(context,imageUrl,imageView)
            else -> loadClearImageIntoImageView(context,imageUrl,imageView)
        }
    }

    private fun loadBlurImageIntoImageView(
        context: Context,
        url:String,
        imageView: ImageView){
        Glide.with(context).load(url)
            .override(500, 500)
            .transition(DrawableTransitionOptions.withCrossFade())
            .apply(RequestOptions.bitmapTransform(BlurTransformation(10, 1)))
            .diskCacheStrategy(DiskCacheStrategy.DATA)
            .placeholder(CircularProgressDrawable(context))
            .error(R.drawable.error_sign)
            .into(imageView)
    }


    private fun loadClearImageIntoImageView(
        context: Context,
        url:String,
        imageView: ImageView){
        Glide.with(context).load(url)
            .override(500, 500)
            .diskCacheStrategy(DiskCacheStrategy.DATA)
            .placeholder(CircularProgressDrawable(context))
            .error(R.drawable.error_sign)
            .into(imageView)
    }
}