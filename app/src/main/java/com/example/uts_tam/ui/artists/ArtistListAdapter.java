package com.example.uts_tam.ui.artists;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uts_tam.R;
import com.example.uts_tam.ui.albums.AlbumModel;
import com.example.uts_tam.ui.albums.detail.AlbumDetailActivity;
import com.example.uts_tam.ui.artists.detail.ArtistDetailActivity;

import java.util.ArrayList;

public class ArtistListAdapter  extends RecyclerView.Adapter<ArtistListAdapter.ViewHolder>{
    ArrayList<ArtistModel> artistList;
    Context context;

    public ArtistListAdapter(ArrayList<ArtistModel> artistList, Context context) {
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
//        holder.artistTextView.setText(artistList.get(position));
        ArtistModel artistData = artistList.get(position);
        holder.artistTextView.setText(artistData.getArtist());

        holder.itemView.setOnClickListener(v -> {
            Intent i = new Intent(context , ArtistDetailActivity.class);
            i.putExtra("artist_name", artistData.getArtist());
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        });
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