package com.example.retrofit1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    private MyJsonPlaceHolderApi myJsonPlaceHolderApi;
////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tvResult);


        ///////////////////////////   1   ///////////////////////////////
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("")   // Ana URI girilecek
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ///////////////////////////   2   ///////////////////////////////
        myJsonPlaceHolderApi = retrofit.create(MyJsonPlaceHolderApi.class);

        ///////////////////////////   3   ///////////////////////////////

//        getPosts();

        getComments();



    }
////////////////////////////////////////////////////////////////////////////////////////////////////
    private void getPosts(){
        Call<List<PostModel>> call = myJsonPlaceHolderApi.getPosts();
        call.enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {

                if(response.isSuccessful()){
                    tvResult.setText("Code: "+response.code());
                }

                List<PostModel> postModels = response.body();
                for(PostModel postModel:postModels){
                    String content ="";
                    content += "ID: "+ postModel.getId() + "\n";
                    content += "User ID: " + postModel.getUserID() + "\n";
                    content += "Title: " + postModel.getTitle() + "\n";
                    content += "Text: " + postModel.getText() + "\n*********\n";

                    tvResult.append(content);
                }

            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                Log.i("tag_hata","Hata: ! "+t);
            }
        });
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////
    private void getComments(){
        Call<List<Comment>> call = myJsonPlaceHolderApi.getComments();
        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {

                if(response.isSuccessful()){
                    tvResult.setText("Code: "+response.code());
                }

                List<Comment> comments = response.body();
                for(Comment comment:comments){
                    String content ="";
                    content += "ID: "+ comment.getId() + "\n";
                    content += "User ID: " + comment.getPostID() + "\n";
                    content += "Title: " + comment.getName() + "\n";
                    content += "Title: " + comment.getEmail() + "\n";
                    content += "Text: " + comment.getText() + "\n*********\n";

                    tvResult.append(content);
                }

            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                Log.i("tag_hata","Hata: ! "+t);
            }
        });
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////


}