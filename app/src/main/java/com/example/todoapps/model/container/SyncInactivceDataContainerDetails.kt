package com.tiffin.metal.dl.models.downsync.container

import com.example.todoapps.model.container.ContainerData
import com.google.gson.annotations.SerializedName


data class SyncInactivceDataContainerDetails(@SerializedName("inactive_containers") val inactive_containers: List<ContainerData>) {

}
