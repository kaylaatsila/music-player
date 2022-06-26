package com.example.uts_tam.ui.artists;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uts_tam.R;

import java.util.ArrayList;

public class ArtistListAdapter  extends RecyclerView.Adapter<ArtistListAdapter.ViewHolder>{
    ArrayList<String> artistList;
    Context context;

    public ArtistListAdapter(ArrayList<String> artistList, Context context) {
        this.artistList = artistList;
        this.context = context;
    }

    @NonNull
    @Override
    public ArtistListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.artist_item,parent,false);
        return new ArtistListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ArtistListAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.artistTextView.setText(artistList.get(position));
    }

    @Override
    public int getItemCount() {
        return artistList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView artistTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            artistTextView = itemView.findViewById(R.id.music_artist_text);
        }
    }
}