package com.example.uts_tam.ui.albums.detail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uts_tam.R;
import com.example.uts_tam.ui.songs.AudioModel;

import java.util.ArrayList;

public class AlbumDetailListAdapter extends RecyclerView.Adapter<AlbumDetailListAdapter.ViewHolder>{
    ArrayList<AudioModel> songsList;
    Context context;

    public AlbumDetailListAdapter(ArrayList<AudioModel> songsList, Context context) {
        this.songsList = songsList;
        this.context = context;
    }

    @NonNull
    @Override
    public AlbumDetailListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.song_item, parent,false);
        return new AlbumDetailListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumDetailListAdapter.ViewHolder holder, int position) {
        AudioModel songData = songsList.get(position);
        holder.titleTextView.setText(songData.getTitle());
        holder.artistTextView.setText(songData.getArtist());
        holder.counterTextView.setText(String.format("%d song(s) found", songsList.size()));
    }

    @Override
    public int getItemCount() {
        return songsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView titleTextView, artistTextView, counterTextView;
        ImageView iconImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.music_title_text);
            artistTextView = itemView.findViewById(R.id.music_artist_text);
            iconImageView = itemView.findViewById(R.id.music_icon_big);
            counterTextView = itemView.findViewById(R.id.songs_counter);
        }
    }{
    }
}
