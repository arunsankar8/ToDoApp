package com.example.todoapps.api

import com.tiffin.metal.dl.models.downsync.container.SyncDataContainer
import retrofit2.Call
import retrofit2.http.*
import rx.Observable
import java.util.*

interface ApiService {


    @GET
    fun requestDownSyncContainer(@Url url:String,
                                 @Header("authorization")token:String):Observable<SyncDataContainer>


   /* @POST("up_sync")
    fun requestUpTransaction(@Header ("authorization") token:String,
                             @Body transactionRequest: List<TransactionData>): Call<RequestUpTransactionResponse>*/



}