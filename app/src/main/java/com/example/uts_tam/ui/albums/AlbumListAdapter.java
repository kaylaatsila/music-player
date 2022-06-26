package com.example.uts_tam.ui.albums;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.uts_tam.R;
import com.example.uts_tam.ui.albums.detail.AlbumDetailActivity;
import com.example.uts_tam.ui.player.MusicPlayerActivity;
import com.example.uts_tam.ui.player.MyMediaPlayer;
import com.example.uts_tam.ui.songs.AudioModel;
import com.example.uts_tam.ui.songs.SongListAdapter;

import java.util.ArrayList;

public class AlbumListAdapter extends RecyclerView.Adapter<AlbumListAdapter.ViewHolder> {

    ArrayList<AlbumModel> albumList;
    Context context;

//    private OnItemClickCallback onItemClickCallback;
//
//    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
//        this.onItemClickCallback = onItemClickCallback;
//    }

    public AlbumListAdapter(ArrayList<AlbumModel> albumList, Context context) {
        this.albumList = albumList;
        this.context = context;
    }

    @NonNull
    @Override
    public AlbumListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.album_item,parent,false);
        return new AlbumListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AlbumModel albumData = albumList.get(position);
        holder.albumTitleText.setText(albumData.getAlbum());
        holder.albumArtistText.setText(albumData.getArtist());
        holder.albumArt.setImageResource(albumData.getAlbum_art());

        holder.itemView.setOnClickListener(v -> {
            Intent i = new Intent(context , AlbumDetailActivity.class);
            i.putExtra("art", albumData.getAlbum_art());
            i.putExtra("album_title", albumData.getAlbum());
            i.putExtra("album_artist", albumData.getArtist());
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView albumTitleText, albumArtistText;
        ImageView albumArt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            albumTitleText = itemView.findViewById(R.id.music_album_text);
            albumArtistText = itemView.findViewById(R.id.music_artist_text);
            albumArt = itemView.findViewById(R.id.music_album_art);
        }
    }
}