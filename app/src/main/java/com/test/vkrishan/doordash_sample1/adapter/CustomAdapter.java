package com.test.vkrishan.doordash_sample1.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.jakewharton.picasso.OkHttp3Downloader;

import com.test.vkrishan.doordash_sample1.R;
import com.test.vkrishan.doordash_sample1.model.RestaurantList;

import org.w3c.dom.Text;

import java.util.List;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private List<RestaurantList> restaurantList;
    private Context context;

    public CustomAdapter(Context context, List<RestaurantList> restaurantList){
        this.context = context;
        this.restaurantList = restaurantList;
    }

    // New class
    class CustomViewHolder extends RecyclerView.ViewHolder{

        public final View mView;

        private ImageView restaurantLogoImg;
        TextView restaurantTitle;
        TextView restaurantDesc;
        TextView restaurantStatus;

        CustomViewHolder(View itemView){
            super(itemView);
            mView = itemView;

            restaurantLogoImg = mView.findViewById(R.id.restaurantLogo);
            restaurantTitle = mView.findViewById(R.id.restaurantName);
            restaurantDesc = mView.findViewById(R.id.restaurantCuisine);
            restaurantStatus = mView.findViewById(R.id.restaurantStatus);
        }

    }


    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_row, parent, false);
        return new CustomViewHolder(view);

    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position){
        holder.restaurantTitle.setText(restaurantList.get(position).getName());
        holder.restaurantDesc.setText(restaurantList.get(position).getDescription());
        holder.restaurantStatus.setText(restaurantList.get(position).getStatus());

        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(restaurantList.get(position).getCoverImgUrl())
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(holder.restaurantLogoImg);

    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }


}
