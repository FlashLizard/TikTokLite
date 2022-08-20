package com.qxy.tiktoklite;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private List<Movie> mMovieList;
    int type, layoutId;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView cover;
        TextView title, time, actor, director;
        TextView discussHot, searchHot, themeHot, influenceHot, englishName;

        public ViewHolder(View view, final int type) {
            super(view);
            cover= (ImageView) view.findViewById(R.id.cover_img);
            title = (TextView) view.findViewById(R.id.title);
            discussHot = (TextView) view.findViewById(R.id.discuss_hot);
            themeHot = (TextView) view.findViewById(R.id.theme_hot);
            searchHot = (TextView) view.findViewById(R.id.search_hot);
            influenceHot = (TextView) view.findViewById(R.id.influence_hot);

            switch (type) {
                case Movie.FILM:
                    time = (TextView) view.findViewById(R.id.time);
                    director = (TextView) view.findViewById(R.id.director);
                    actor = (TextView) view.findViewById(R.id.actor);
                    break;
                case Movie.TVPLAY:
                    time = (TextView) view.findViewById(R.id.time);
                    director = (TextView) view.findViewById(R.id.director);
                    actor = (TextView) view.findViewById(R.id.actor);
                    englishName = (TextView) view.findViewById(R.id.english_name);
                    break;
                default:
                    englishName = (TextView) view.findViewById(R.id.english_name);
                    break;
            }
        }

    }

    public MovieAdapter(List<Movie> movieList, int type) {
        mMovieList = movieList;
        this.type = type;
        switch (type) {
            case Movie.FILM:
                layoutId = R.layout.film_item;
                break;
            case Movie.TVPLAY:
                layoutId = R.layout.tvplay_item;
                break;
            default:
                layoutId = R.layout.variety_item;
                break;
        }
    }

    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        ViewHolder holder = new ViewHolder(view, type);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ViewHolder holder, int position) {
        Movie movie = mMovieList.get(position);
        holder.title.setText(movie.title);
        holder.title.setText(movie.title);
        holder.discussHot.setText("讨论热度: " + movie.discussHot);
        holder.themeHot.setText("主题热度: " + movie.themeHot);
        holder.searchHot.setText("搜索热度: " + movie.searchHot);
        holder.influenceHot.setText("影响力热度: " + movie.influenceHot);

        switch (type) {
            case Movie.FILM:
                holder.time.setText(movie.time + " 上映");
                holder.director.setText("导演: " + movie.director);
                holder.actor.setText("演员: " + movie.actor);
                break;
            case Movie.TVPLAY:
                holder.time.setText(movie.time + " 上映");
                holder.director.setText("导演: " + movie.director);
                holder.actor.setText("演员: " + movie.actor);
                holder.englishName.setText(movie.englishName);
                break;
            default:
                holder.englishName.setText(movie.englishName);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mMovieList.size();
    }
}
