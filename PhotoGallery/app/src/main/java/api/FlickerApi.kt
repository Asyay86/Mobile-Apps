package api

import retrofit2.http.GET
import retrofit2.http.Query


private const val API_KEY = "921156ea95a45659188651942417fa56"
interface FlickrApi {
    @GET("services/rest/?=method=flickr.interestingness.getList")
    suspend fun fetchPhotos(): FlickrResponse

    @GET("services/rest?method=flickr.photos.search")
    suspend fun searchPhotos(@Query("text") query: String): FlickrResponse

}