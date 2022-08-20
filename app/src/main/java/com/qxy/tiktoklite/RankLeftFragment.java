package com.qxy.tiktoklite;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class RankLeftFragment extends BaseFragment {

    private BaseActivity activity;
    private List<Movie> filmList, tvplayList, varietyList;
    private RecyclerView filmRecyclerView;
    private RecyclerView tvplayRecyclerView;
    private RecyclerView varietyRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.rank_left_frag, container, false);
        activity = (BaseActivity) getActivity();

        return view;
    }

    @Override
    public void initView()
    {

        filmRecyclerView = (RecyclerView) activity.findViewById(R.id.film_list);
        tvplayRecyclerView = (RecyclerView) activity.findViewById(R.id.tvplay_list);
        varietyRecyclerView = (RecyclerView) activity.findViewById(R.id.variety_list);

        activity.findViewById(R.id.back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.finish();
            }
        });

        activity.findViewById(R.id.center_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CenterActivity.actionStart(activity);
            }
        });

        activity.findViewById(R.id.film_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(filmRecyclerView.getVisibility() == View.GONE) {
                    filmRecyclerView.setVisibility(View.VISIBLE);
                    tvplayRecyclerView.setVisibility(View.GONE);
                    varietyRecyclerView.setVisibility(View.GONE);
                }
            }
        });

        activity.findViewById(R.id.tvplay_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tvplayRecyclerView.getVisibility() == View.GONE) {
                    filmRecyclerView.setVisibility(View.GONE);
                    tvplayRecyclerView.setVisibility(View.VISIBLE);
                    varietyRecyclerView.setVisibility(View.GONE);
                }
            }
        });

        activity.findViewById(R.id.variety_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(varietyRecyclerView.getVisibility() == View.GONE) {
                    filmRecyclerView.setVisibility(View.GONE);
                    tvplayRecyclerView.setVisibility(View.GONE);
                    varietyRecyclerView.setVisibility(View.VISIBLE);
                }
            }
        });



        initFilms();
        LinearLayoutManager filmlayoutManager = new LinearLayoutManager(activity);
        filmRecyclerView.setLayoutManager(filmlayoutManager);
        filmRecyclerView.setAdapter(new MovieAdapter(filmList, Movie.FILM));
        initTvPlays();
        LinearLayoutManager tvlayoutManager = new LinearLayoutManager(activity);
        tvplayRecyclerView.setLayoutManager(tvlayoutManager);
        tvplayRecyclerView.setAdapter(new MovieAdapter(tvplayList, Movie.TVPLAY));
        initVarieties();
        LinearLayoutManager varietylayoutManager = new LinearLayoutManager(activity);
        varietyRecyclerView.setLayoutManager(varietylayoutManager);
        varietyRecyclerView.setAdapter(new MovieAdapter(varietyList, Movie.VARIETY));

    }

    public void initFilms() {
        TikDebug tikDebug = new TikDebug();
        filmList = new ArrayList<>();
        int amount = tikDebug.nextInt(21);
        for(int i=1; i<= amount; i++) {
            filmList.add(new Movie(tikDebug.nextString(),tikDebug.nextString(),tikDebug.nextString(),tikDebug.nextString()
            ,tikDebug.nextString(),tikDebug.nextString(),tikDebug.nextString(),tikDebug.nextString(),tikDebug.nextString()));
        }
    }

    public void initTvPlays() {
        TikDebug tikDebug = new TikDebug();
        tvplayList = new ArrayList<>();
        int amount = tikDebug.nextInt(21);
        for(int i=1; i<= amount; i++) {
            tvplayList.add(new Movie(tikDebug.nextString(),tikDebug.nextString(),tikDebug.nextString(),tikDebug.nextString()
                    ,tikDebug.nextString(),tikDebug.nextString(),tikDebug.nextString(),tikDebug.nextString(),tikDebug.nextString(),tikDebug.nextString()));
        }
    }

    public void initVarieties() {
        TikDebug tikDebug = new TikDebug();
        varietyList = new ArrayList<>();
        int amount = tikDebug.nextInt(21);
        for(int i=1; i<= amount; i++) {
            varietyList.add(new Movie(tikDebug.nextString(),tikDebug.nextString(),tikDebug.nextString()
                    ,tikDebug.nextString(),tikDebug.nextString(),tikDebug.nextString(),tikDebug.nextString()));
        }
    }
}
