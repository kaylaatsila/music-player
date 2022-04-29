package com.example.uts_tam.ui.albums;

import android.content.Context;
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

import java.util.ArrayList;

public class AlbumListAdapter extends RecyclerView.Adapter<AlbumListAdapter.ViewHolder> {

    ArrayList<String> albumTitle;
    ArrayList<String> albumArtist;
    ArrayList<Integer> albumArt;
    Context context;

    public AlbumListAdapter(Context ct, ArrayList<String> albumTitle, ArrayList<String> albumArtist, ArrayList<Integer> albumArt){
        context = ct;
        this.albumTitle = albumTitle;
        this.albumArtist = albumArtist;
        this.albumArt = albumArt;
    }

    @NonNull
    @Override
    public AlbumListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.album_item,parent,false);
        return new AlbumListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.albumTitleText.setText(albumTitle.get(position));
        holder.albumArtistText.setText(albumArtist.get(position));
//        holder.albumArt.setImageResource(R.drawable.ic_album);

//        Glide.with(holder.itemView.getContext())
//                .load(albumArt.get(position))
//                .apply(new RequestOptions().override(600, 600))
//                .into(holder.albumArt);
    }

    @Override
    public int getItemCount() {
        return albumTitle.size();
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