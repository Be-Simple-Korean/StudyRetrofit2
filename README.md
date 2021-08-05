# StudyRetrofit2

## 순서
1. 의존성 추가

```
 annotationProcessor 'com.github.bumptech.glide:compiler:4.11.0'  // Glide 
 implementation 'com.github.bumptech.glide:glide:4.12.0'       // Glide    
 implementation 'com.squareup.retrofit2:converter-gson:2.6.2'   // Retrofit으로 Json데이터를 가져올때 사용하는 컨버터
 implementation 'com.squareup.retrofit2:retrofit:2.6.0'        // Retrofit2
```
2. 결과값을 담을 데이터 클래스 생성

3. API Interface 정의
ex) 형식
```
    @GET("/v1/search/movie.json") // REST 메서드, 요청 URL
    Call<MovieDataVO> getMovieTitle(
            @Query("query") String query, //검색어
            @Query("display") int display, //결과 출력 개수
            @Query("start") int start
    );
```

4. Retrofit2, API 인터페이스 변수 생성
5. API 인터페이스에 만들어놓은 메소드 호출
```
 Call<MovieDataVO> callMovieData = naverAPI.getMovieTitle(파라미터);
```
6. 데이터 받아오기
```
  callMovieData.enqueue(new Callback<MovieDataVO>() {
            @Override
            public void onResponse(Call<MovieDataVO> call, Response<MovieDataVO> response) {
                // 요청 결과 코드에 맞춰서 데이터 처리
            }

            @Override
            public void onFailure(Call<MovieDataVO> call, Throwable t) {

            }
        });
```

## OkHttpClient.Builder().addInterceptor
* Retrofit에 들어갈 헤더값을 레트로핏에 .client(client)로 한번만 호출해주면 편리하게 사용가능
