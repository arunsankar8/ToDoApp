package com.tiffin.metal.dl.models.downsync.container

import com.example.todoapps.model.container.ContainerData
import com.google.gson.annotations.SerializedName


data class SyncDataContainerDetails(@SerializedName("container") val containers: List<ContainerData>) {
}