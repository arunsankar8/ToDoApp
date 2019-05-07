package com.tiffin.metal.dl.models.downsync.container

import com.google.gson.annotations.SerializedName


data class SyncDataContainer(

        @SerializedName("code") val code:Int,
        @SerializedName("message") val msg:String,
        @SerializedName("date") val date:String,
        @SerializedName("data") val data : SyncDataContainerDetails,
        @SerializedName("inactive") val inactive : SyncInactivceDataContainerDetails
) {
}