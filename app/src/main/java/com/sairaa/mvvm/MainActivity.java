package com.sairaa.mvvm;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.sairaa.mvvm.Adapter.RV_Adapter;
import com.sairaa.mvvm.Model.Image_List;
import com.sairaa.mvvm.ViewModels.MainActivityViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FloatingActionButton floatind_button;
    private ProgressBar progress_bar;
    private RV_Adapter adapter;

    private MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerView);
        progress_bar=findViewById(R.id.progress_bar);
        floatind_button=findViewById(R.id.floatind_button);
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        mainActivityViewModel.init();
        mainActivityViewModel.getImages().observe(this, new Observer<ArrayList<Image_List>>() {
            @Override
            public void onChanged(@Nullable ArrayList<Image_List> image_lists) {
                adapter.notifyDataSetChanged();
            }
        });

        mainActivityViewModel.getIsUpdating().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if (aBoolean){
                    ShowProgressBar();
                }
                else {
                    HideProgressBar();
                    recyclerView.smoothScrollToPosition(mainActivityViewModel.getImages().getValue().size()-1);
                }
            }
        });

        floatind_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivityViewModel.getNewList(
                        new Image_List("http://2.bp.blogspot.com/-ThSnqv-BjjE/UhBNTgM8eGI/AAAAAAAAoxw/nYE3yaKjY68/s1600/Prabhas+HD+Wallpapers+1.jpg","new Image"));
            }
        });

        initRecyclerView();
    }

    private void initRecyclerView() {

        adapter=new RV_Adapter(this,mainActivityViewModel.getImages().getValue());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration itemDecoration=new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(itemDecoration);
    }

    private void ShowProgressBar(){
        progress_bar.setVisibility(View.VISIBLE);

    }
    private void HideProgressBar(){
        progress_bar.setVisibility(View.GONE);

    }
}
