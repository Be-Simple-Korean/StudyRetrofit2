package com.example.studyretrofit2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.studyretrofit2.network.NaverAPI;
import com.example.studyretrofit2.network.vo.MovieDataVO;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://openapi.naver.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        NaverAPI naverAPI = retrofit.create(NaverAPI.class);
        Call<MovieDataVO> callMovieData = naverAPI.getMovieTitle(
                "hhWYTgIoUyV9WAJnjMPm",
                "jIa69C_Gn7",
                "귀멸",
                1, 1);
        ImageView iv =findViewById(R.id.iv);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callMovieData.enqueue(new Callback<MovieDataVO>() {
                    @Override
                    public void onResponse(Call<MovieDataVO> call, Response<MovieDataVO> response) {
                        if (response.code() == 200) {
                            Log.e("getDataTotal", response.body().getTotal() + "");
                            Log.e("link", response.body().getItems().get(0).getImage());
                            String imgLink = response.body().getItems().get(0).getImage();
//                            Glide.with(MainActivity.this)
//                                    .load(imgLink)
//                                    .into(iv);
                            Picasso.get().load(imgLink).into(iv);
                        }
                    }

                    @Override
                    public void onFailure(Call<MovieDataVO> call, Throwable t) {
                        Log.e("Call data", "FAIL");
                        Log.e("error", t.getMessage());
                    }
                });
            }
        });


    }
}