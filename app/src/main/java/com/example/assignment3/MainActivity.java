package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView Total, Recovered, Deaths;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Total =  findViewById(R.id.totalData);
        Recovered = findViewById(R.id.recovered);
        Deaths = findViewById(R.id.death);

        getDataApi();
    }

    private void getDataApi() {
        APIService.api().getData().enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                String totalcases = String.valueOf(response.body().getUpdated());
                String recovered = String.valueOf(response.body().getRecovered());
                String deaths = String.valueOf(response.body().getDeaths());
                if (response.isSuccessful()) {
                    Total.setText(totalcases);
                    Recovered.setText(recovered);
                    Deaths.setText(deaths);
                    return;
                }
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Ada Error", Toast.LENGTH_LONG).show();
            }
        });
    }
}