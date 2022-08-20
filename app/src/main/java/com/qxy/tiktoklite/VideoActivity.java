package com.qxy.tiktoklite;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class VideoActivity extends BaseActivity{

    public static void actionStart(Context context, Video video) {
        Intent intent = new Intent(context, VideoActivity.class);
        intent.putExtra("video", video);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        Intent intent = getIntent();
        Video video = (Video) intent.getParcelableExtra("video");

        CenterRightFragment rightFragment = (CenterRightFragment) getSupportFragmentManager().findFragmentById(R.id.center_right_frag);
        rightFragment.initView(video);

    }
}
