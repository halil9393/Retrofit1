package com.example.retrofit1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyJsonPlaceHolderApi  {

    @GET("posts") // bu bolume ana uri den sonra gelen kısım yazılıyor
    Call<List<PostModel>> getPosts();

    @GET("posts/2/comments")
    Call<List<Comment>> getComments();

}
