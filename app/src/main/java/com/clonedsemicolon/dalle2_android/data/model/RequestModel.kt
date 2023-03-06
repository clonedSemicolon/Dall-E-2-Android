package com.clonedsemicolon.dalle2_android.data.model

import com.google.gson.annotations.SerializedName

data class RequestModel(
    @SerializedName("count")
    val count:Int,
    @SerializedName("promptCommand")
    val promptCommand:String,
    @SerializedName("imageSize")
    val size:String
)
