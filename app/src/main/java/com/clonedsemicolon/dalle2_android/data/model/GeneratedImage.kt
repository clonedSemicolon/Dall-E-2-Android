package com.clonedsemicolon.dalle2_android.data.model

import com.google.gson.annotations.SerializedName

data class GeneratedImage(
    @SerializedName("created")
    val created:Int,
    @SerializedName("data")
    val items:List<RemoteItem>
)
