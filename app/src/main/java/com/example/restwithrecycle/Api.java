package com.example.restwithrecycle;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL = "https://uniqueandrocode.000webhostapp.com/hiren/retrofit/";
    @GET("getdata.php")
    Call<List<imageList>> getImage();
}
