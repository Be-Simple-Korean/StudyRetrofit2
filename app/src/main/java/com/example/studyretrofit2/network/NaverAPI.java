package com.example.studyretrofit2.network;

import com.example.studyretrofit2.network.vo.MovieDataVO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NaverAPI {

    @GET("/v1/search/movie.json")
    Call<MovieDataVO> getMovieTitle(
            @Query("query") String query, //검색어
            @Query("display") int display, //결과 출력 개수
            @Query("start") int start
    );
}
