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

public class CenterRightFragment extends BaseFragment {

    private BaseActivity activity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.center_right_frag, container, false);
        activity = (BaseActivity) getActivity();

        return view;
    }

    public void initView(Video video) {
        activity.findViewById(R.id.back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.finish();
            }
        });

        ((TextView) activity.findViewById(R.id.video_title)).setText(video.title);
        ((TextView) activity.findViewById(R.id.video_time)).setText(video.time);
        ((TextView) activity.findViewById(R.id.play_num)).setText(video.playNum);
        ((TextView) activity.findViewById(R.id.comment_num)).setText(video.commentNum);
        ((TextView) activity.findViewById(R.id.download_num)).setText(video.downloadNum);
        ((TextView) activity.findViewById(R.id.like_num)).setText(video.likeNum);
        ((TextView) activity.findViewById(R.id.share_num)).setText(video.shareNum);
        ((TextView) activity.findViewById(R.id.transmit_num)).setText(video.transmitNum);
    }
}
