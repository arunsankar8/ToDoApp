package com.example.todoapps.model.container

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull
import android.support.annotation.Nullable
import com.google.gson.annotations.SerializedName

/**
 * Created by inapp on 21/01/19.
 */



        data class ContainerData( @PrimaryKey var id: String,
                                 @ColumnInfo(name = "container_number") @SerializedName("container_number") var containerNumber : String?,
                                 @ColumnInfo(name = "location_id")  @SerializedName("location_id") var locationId:String?,
                                 @ColumnInfo(name = "created_by") @SerializedName("created_by")  var createdBy : Int?,
                                 @ColumnInfo(name = "created_on")  @SerializedName("created_on") var createdOn : String?,
                                 @ColumnInfo(name = "updated_by") @SerializedName("updated_by") var updatedBy : Int?,
                                 @ColumnInfo(name = "updated_on") @SerializedName("updated_on") var updatedOn : String?,
                                  @ColumnInfo(name = "temp_container_id") @SerializedName("temp_container_id") var temp_container_id : String?=null
                                 )

{
    constructor():this("","","",0,"",0,"",null)
}