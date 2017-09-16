package com.example.fernandocisneros.fakeinstagram;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.fernandocisneros.fakeinstagram.controller.DetailActivity;
import com.example.fernandocisneros.fakeinstagram.model.Item;

import java.util.List;

/**
 * Created by fernandocisneros on 16/09/2017.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private List<Item> items;

    private Context context;

    public ItemAdapter(Context applicationContext, List<Item> itemArrayList) {
        this.context = applicationContext;
        this.items = itemArrayList;
    }

    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_image, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemAdapter.ViewHolder viewHolder, int i) {
        Glide.with(context)
                .load(items.get(i).getMedia())
                .placeholder(R.drawable.load3)
                .centerCrop()
                .into(viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        public ViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.image_preview);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION) {
                        Item clickedDataItem = items.get(pos);
                        Intent intent = new Intent(context, DetailActivity.class);
                        intent.putExtra("instagram_image", items.get(pos).getMedia());
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                        Toast.makeText(view.getContext(), "Loading...", Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }
    }


}
