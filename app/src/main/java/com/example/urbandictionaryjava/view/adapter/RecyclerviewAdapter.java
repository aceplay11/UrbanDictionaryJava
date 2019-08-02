package com.example.urbandictionaryjava.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.urbandictionaryjava.R;
import com.example.urbandictionaryjava.model.datasource.urbanDictionary.UrbanDictionaryResponse;

import java.util.List;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder> {

    UrbanDictionaryResponse response;
    List<com.example.urbandictionaryjava.model.datasource.urbanDictionary.List> responseList;

    public RecyclerviewAdapter(UrbanDictionaryResponse response) {
        this.response = response;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_view_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String definition = response.getList().get(position).getDefinition();
        String thumbsUp = response.getList().get(position).getThumbsUp().toString();
        String thumbsDown = response.getList().get(position).getThumbsDown().toString();

        holder.tvDefinition.setText(definition);
        holder.tvThumbsUp.setText(thumbsUp);
        holder.tvThumbsDown.setText(thumbsDown);

    }

    @Override
    public int getItemCount() {
        return response.getList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvDefinition, tvThumbsUp, tvThumbsDown;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDefinition = itemView.findViewById(R.id.rvTVDefinition);
            tvThumbsUp = itemView.findViewById(R.id.rvTVThumbsUp);
            tvThumbsDown = itemView.findViewById(R.id.rvTVThumbsDown);
        }
    }
}
