package com.example.retrofit1;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface MyJsonPlaceHolderApi  {

//    @GET("posts") // bu bolume ana uri den sonra gelen kısım yazılıyor
//    Call<List<PostModel>> getPosts();

//    @GET("posts/2/comments")
//    Call<List<Comment>> getComments();

    @GET("posts/{id}/comments")
    Call<List<Comment>> getComments(@Path("id") int postId);

//    @GET("posts")
//    Call<List<PostModel>> getPosts(@Query("userId") int userId); // key value ilişkisi ile arama


//    @GET("posts")
//    Call<List<PostModel>> getPosts(
//            @Query("userId") Integer userId,    // Eğer int ile tanımlanırsa, null değer verilemiyor
//            @Query("_sort") String sort,        // sıralama işlemini bu şekilde parametre isteyerek
//            @Query("_order") String order       // yapabilirsin. null da girilebiliyor.
//                                   );


//    @GET("posts")
//    Call<List<PostModel>> getPosts(
//            @Query("userId") Integer userId,
//            @Query("userId") Integer userId2,       // İkinci bir arama istenirse yapılabilir
//            @Query("_sort") String sort,
//            @Query("_order") String order
//    );

    @GET("posts")
    Call<List<PostModel>> getPosts(
            @Query("userId") Integer[] userId,          // Yada List<> içine de alınarak birçok arama isteği yapılabilir
            @Query("_sort") String sort,
            @Query("_order") String order
    );

    @GET("posts")
    Call<List<PostModel>> getPosts(
            @QueryMap Map<String, String> parameters    // yada tüm istekler map yapılıp iletilebilir
    );

    @GET
    Call<List<PostModel>> getPosts(
            @Url String url                 // çalışmadı, anlamadım
    );

    @GET
    Call<List<Comment>> getComments(
            @Url String url                 // eğer url girilecekse get yanı boş bırakılacak
    );
}
