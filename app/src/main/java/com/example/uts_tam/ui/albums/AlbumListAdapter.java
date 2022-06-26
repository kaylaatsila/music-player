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

    ArrayList<String> albumTitle;
    ArrayList<String> albumArtist;
    ArrayList<Integer> albumArt;
    ArrayList<AlbumModel> albumList;
    Context context;

//    private OnItemClickCallback onItemClickCallback;
//
//    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
//        this.onItemClickCallback = onItemClickCallback;
//    }

//    public AlbumListAdapter(Context ct, ArrayList<String> albumTitle, ArrayList<String> albumArtist, ArrayList<Integer> albumArt){
//        this.context = ct;
//        this.albumTitle = albumTitle;
//        this.albumArtist = albumArtist;
//        this.albumArt = albumArt;
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
//        holder.albumTitleText.setText(albumTitle.get(position));
//        holder.albumArtistText.setText(albumArtist.get(position));
//
//        Glide.with(holder.itemView.getContext())
//                .load(albumArt.get(position))
//                .apply(new RequestOptions().override(600, 600))
//                .into(holder.albumArt);

        AlbumModel albumData = albumList.get(position);
        holder.albumTitleText.setText(albumData.getAlbum());
        holder.albumArtistText.setText(albumData.getArtist());

        holder.itemView.setOnClickListener(v -> {
//            MyMediaPlayer.getInstance().reset();
//            MyMediaPlayer.currentIndex = position;
            Intent intent = new Intent(context , AlbumDetailActivity.class);
            intent.putExtra("LIST", albumList);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        });

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onItemClickCallback.onItemClicked(albumTitle.get(holder.getAdapterPosition()));
//            }
//        });
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

//    public interface OnItemClickCallback {
//        void onItemClicked(String album);
//    }
}