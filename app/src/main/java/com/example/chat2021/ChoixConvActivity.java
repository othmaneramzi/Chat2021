package com.example.chat2021;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class ChoixConvActivity extends AppCompatActivity implements RecycleViewer  {

    private static final String CAT = "LE4-SI";
    APIInterface apiService;
    String hash;
    String login;
    RecyclerView recyclerView;



    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_conversation);
        recyclerView = findViewById(R.id.choixConversation_conv);

        Bundle bdl = this.getIntent().getExtras();
        Log.i(CAT,bdl.getString("hash"));
        hash = bdl.getString("hash");

        apiService = APIClient.getClient().create(APIInterface.class);
        Call<ListConversation> call1 = apiService.doGetListConversation(hash);
        call1.enqueue(new Callback<ListConversation>() {
            @Override
            public void onResponse(Call<ListConversation> call, Response<ListConversation> response) {
                ListConversation lc = response.body();
                Log.i(CAT,lc.toString());
                recycleviewerFill(lc);
            }

            @Override
            public void onFailure(Call<ListConversation> call, Throwable t) {
                call.cancel();
            }
        });


    }

    @Override
    public void recyclerViewListClicked(Conversation conversation) {
        Log.i(CAT,"init click");
        Conversation c = conversation;
        Log.i(CAT,c.getId().toString());
        Log.i(CAT,c.toString());
        Intent intentConv = new Intent(ChoixConvActivity.this,ShowConvActivity.class);
        Bundle b= new Bundle();
        b.putString("hash",hash);
        b.putString("idConv",c.getId());
        b.putString("login",login);
        intentConv.putExtras(b);
        startActivity(intentConv);
        Log.i(CAT,"end click");
    }



    private void recycleviewerFill(ListConversation lc){
        MyAdapter adp = new MyAdapter(lc.conversations,this,this);
        recyclerView.setAdapter(adp);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }



    @Override
    protected void onStart() {
        super.onStart();
    }



}
