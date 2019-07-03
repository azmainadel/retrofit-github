package com.example.firsttest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.firsttest.api.model.GithubRepo;
import com.example.firsttest.api.service.GithubClient;
import com.example.firsttest.api.constants.Constants;
import com.example.firsttest.ui.adapter.GithubRepoAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

//    @BindView(R.id.repo_list) ListView listView;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);

        listView = (ListView) findViewById(R.id.repo_list);

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        GithubClient githubClient = retrofit.create(GithubClient.class);
        Call<List<GithubRepo>> call = githubClient.repos(Constants.USER);

        call.enqueue(new Callback<List<GithubRepo>>() {
            @Override
            public void onResponse(Call<List<GithubRepo>> call, Response<List<GithubRepo>> response) {
                List<GithubRepo> githubRepoList = response.body();

                listView.setAdapter(new GithubRepoAdapter(MainActivity.this, githubRepoList));
            }

            @Override
            public void onFailure(Call<List<GithubRepo>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed to retrieve repositories",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}
