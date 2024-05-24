package com.nabiha.data.apiservice

import com.nabiha.apiresponse.likes.LikeApiRequest
import com.nabiha.apiresponse.likes.LikeApiResponse
import com.nabiha.apiresponse.likes.LikesApiResponse
import com.nabiha.apiresponse.likes.UnlikeApiResponse
import com.nabiha.apiresponse.products.ProductApiResponse
import com.nabiha.apiresponse.products.ProductsApiResponse
import com.nabiha.apiresponse.users.UserApiLoginRequest
import com.nabiha.apiresponse.users.UserApiLoginResponse
import com.nabiha.apiresponse.users.UserApiRegisterRequest
import com.nabiha.apiresponse.users.UserApiResponse
import com.nabiha.apiresponse.users.UserApiUpdateRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {
    //user endpoint
    @GET("/users/account/profile")
    suspend fun fetchProfile(
        @HeaderMap headers : Map<String, String>
    ):Response<UserApiResponse>

    @POST("/users/account/register")
    @Headers("Accept: application/json")
    suspend fun fetchRegisterUser(
        @Body data: UserApiRegisterRequest
    ):Response<UserApiResponse>

    @POST("/users/account/login")
    @Headers("Accept: application/json")
    suspend fun fetchLoginUser(
        @Body data: UserApiLoginRequest
    ):Response<UserApiLoginResponse>

    @PUT("/users/{id}")
    @Headers("Accept: application/json")
    suspend fun fetchUpdaterUser(
        @HeaderMap headers : Map<String, String>,
        @Path("id") id: Long,
        @Body data: UserApiUpdateRequest
    ):Response<UserApiResponse>


    @GET("/products")
    suspend fun fetchProducts(
        @HeaderMap headers : Map<String, String>
    ):Response<ProductsApiResponse>

    @GET("/products/{id}")
    suspend fun fetchProduct(
        @HeaderMap headers : Map<String, String>,
        @Path("id") id: Long
    ):Response<ProductApiResponse>

    @GET("/likes")
    suspend fun fetchWhistLists(
        @HeaderMap headers : Map<String, String>,
    ): Response<LikesApiResponse>

    @POST("/likes")
    suspend fun likeProduct(
        @HeaderMap headers : Map<String, String>,
        @Body request: LikeApiRequest
    ): Response<LikeApiResponse>

    @DELETE("/likes/{id}")
    suspend fun unlikeProduct(
        @HeaderMap headers : Map<String, String>,
        @Path("id") id: Long
    ): Response<UnlikeApiResponse>
}