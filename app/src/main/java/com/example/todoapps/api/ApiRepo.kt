package com.example.todoapps.api

import com.example.todoapps.api.Injection
import com.tiffin.metal.dl.models.downsync.container.SyncDataContainer
import rx.Observable

class ApiRepo {

    val authorisation="eyJhbGciOiJIUzI1NiIsInR5cCI6Ikp" +
            "XVCJ9.eyJlbWFpbCI6IiIsIm9yaWdfaWF0IjoxNTU2ODY2Njc" +
            "zLCJ1c2VybmFtZSI6ImF0aGlyYSIsInVzZXJfaWQiOjUsImV4cCI6MTU1N" +
            "jg5NTQ3M30.6yB8Uebu2ecAo17OMIJ33T1a6RoYDFp_pWZV_O8siFo"

    fun callContainerDownSyncApi():Observable<SyncDataContainer>{

        return Injection.provideApiService().requestDownSyncContainer("part/0",authorisation)
           /* .enqueue(object:retrofit2.Callback<Observable<SyncDataContainer>>{
                override fun onFailure(call: Call<Observable<SyncDataContainer>>, t: Throwable) {




                }

                override fun onResponse(
                    call: Call<Observable<SyncDataContainer>>,
                    response: Response<Observable<SyncDataContainer>>
                ) {



                }
            })*/








    }




}