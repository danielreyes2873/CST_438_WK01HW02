package com.example.cst_438_wk01hw02;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JsonPlaceHolderAPI {
    @GET("posts")
    Call<List<Post>> getPosts(@Query("userId") int userId);
}
