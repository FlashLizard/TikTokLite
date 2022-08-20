package com.qxy.tiktoklite;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {

    private List<Video> mVideoList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View view;
        ImageView cover;
        TextView title, time;
        TextView playNum, commentNum;

        public ViewHolder(View view) {
            super(view);
            this.view =view;
            cover = (ImageView) view.findViewById(R.id.cover_img);
            title = (TextView) view.findViewById(R.id.video_title);
            time = (TextView) view.findViewById(R.id.video_time);
            playNum = (TextView) view.findViewById(R.id.play_num);
            commentNum = (TextView) view.findViewById(R.id.comment_num);

        }

    }

    public VideoAdapter(List<Video> videoList) {
        mVideoList = videoList;
    }

    @NonNull
    @Override
    public VideoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_item, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull VideoAdapter.ViewHolder holder, int position) {
        Video video = mVideoList.get(position);
        holder.title.setText(video.title);
        holder.time.setText(video.time);
        holder.playNum.setText(video.playNum);
        holder.commentNum.setText(video.commentNum);

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VideoActivity.actionStart(view.getContext(), video);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mVideoList.size();
    }
}
