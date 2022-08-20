package com.qxy.tiktoklite;

import android.Manifest;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CenterLeftFragment extends BaseFragment {

    private BaseActivity activity;
    private List<Video> videoList;
    private List<Fans> fansList;
    private List<Fans> followingsList;
    private RecyclerView videoRecyclerView;
    private RecyclerView fansRecyclerView;
    private RecyclerView followingRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.center_left_frag, container, false);
        activity = (BaseActivity) getActivity();

        return view;
    }

    @Override
    public void initView() {
        activity.findViewById(R.id.back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.finish();
            }
        });

        activity.findViewById(R.id.video_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(videoRecyclerView.getVisibility() == View.GONE) {
                    videoRecyclerView.setVisibility(View.VISIBLE);
                    followingRecyclerView.setVisibility(View.GONE);
                    fansRecyclerView.setVisibility(View.GONE);
                }
            }
        });

        activity.findViewById(R.id.following_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(followingRecyclerView.getVisibility() == View.GONE) {
                    videoRecyclerView.setVisibility(View.GONE);
                    followingRecyclerView.setVisibility(View.VISIBLE);
                    fansRecyclerView.setVisibility(View.GONE);
                }
            }
        });

        activity.findViewById(R.id.fans_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fansRecyclerView.getVisibility() == View.GONE) {
                    videoRecyclerView.setVisibility(View.GONE);
                    followingRecyclerView.setVisibility(View.GONE);
                    fansRecyclerView.setVisibility(View.VISIBLE);
                }
            }
        });

        initVideos();
        videoRecyclerView = activity.findViewById(R.id.video_list);
        GridLayoutManager videoLayoutManager = new GridLayoutManager(activity,3);
        videoRecyclerView.setLayoutManager((videoLayoutManager));
        videoRecyclerView.setAdapter(new VideoAdapter(videoList));

        initFollowings();
        followingRecyclerView = activity.findViewById(R.id.following_list);
        LinearLayoutManager followingLayRecyclerView = new LinearLayoutManager(activity);
        followingRecyclerView.setLayoutManager(followingLayRecyclerView);
        followingRecyclerView.setAdapter(new FansAdapter(followingsList));

        initFans();
        fansRecyclerView = activity.findViewById(R.id.fans_list);
        LinearLayoutManager fansLayoutManager = new LinearLayoutManager(activity);
        fansRecyclerView.setLayoutManager(fansLayoutManager);
        fansRecyclerView.setAdapter(new FansAdapter(fansList));

    }

    public void initVideos() {
        TikDebug tikDebug = new TikDebug();
        int amount = tikDebug.nextInt(60);
        tikDebug.setVal(10000);
        videoList = new ArrayList<>();
        for(int i=1; i<= amount; i++) {
            videoList.add(new Video(tikDebug.nextString(),tikDebug.nextString(),tikDebug.nextString(),tikDebug.nextString()
                    ,tikDebug.nextString(),tikDebug.nextString(),tikDebug.nextString(),tikDebug.nextString(),tikDebug.nextString(),tikDebug.nextString()));
        }
    }

    public void initFollowings() {
        TikDebug tikDebug = new TikDebug();
        int amount = tikDebug.nextInt(60);
        tikDebug.setVal(10000);
        followingsList = new ArrayList<>();
        for(int i=1; i<= amount; i++) {
            followingsList.add(new Fans(tikDebug.nextString(),tikDebug.nextString(),
                    tikDebug.nextString(),Male.toMale(tikDebug.nextInt(3))));
        }
    }

    public void initFans() {
        TikDebug tikDebug = new TikDebug();
        int amount = tikDebug.nextInt(60);
        tikDebug.setVal(10000);
        fansList = new ArrayList<>();
        for(int i=1; i<= amount; i++) {
            fansList.add(new Fans(tikDebug.nextString(),tikDebug.nextString(),
                    tikDebug.nextString(),Male.toMale(tikDebug.nextInt(3))));
        }
    }
}
