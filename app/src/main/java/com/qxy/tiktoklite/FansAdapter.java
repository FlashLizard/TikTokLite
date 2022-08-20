package com.qxy.tiktoklite;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FansAdapter extends RecyclerView.Adapter<FansAdapter.ViewHolder> {

    private List<Fans> mFansList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView avatar, male;
        TextView name, address;

        public ViewHolder(View view) {
            super(view);
            avatar = (ImageView) view.findViewById(R.id.fans_avatar);
            male = (ImageView) view.findViewById(R.id.fans_male);
            name = (TextView) view.findViewById(R.id.fans_name);
            address = (TextView) view.findViewById(R.id.fans_address);

        }

    }

    public FansAdapter(List<Fans> fansList) {
        mFansList = fansList;
    }

    @NonNull
    @Override
    public FansAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fans_item, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull FansAdapter.ViewHolder holder, int position) {
        Fans fans = mFansList.get(position);
        holder.name.setText(fans.name);
        holder.address.setText(fans.address);

        switch (fans.male) {
            case MALE:
                holder.male.setImageResource(R.drawable.male);
                break;
            case FEMALE:
                holder.male.setImageResource(R.drawable.female);
                break;
            default:
                holder.male.setImageResource(R.drawable.unknown);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mFansList.size();
    }
}
