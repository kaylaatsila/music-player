package com.example.uts_tam.ui.albums;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.uts_tam.R;
import com.example.uts_tam.databinding.FragmentAlbumsBinding;
import com.example.uts_tam.ui.albums.detail.AlbumDetailActivity;
import com.example.uts_tam.ui.songs.AudioModel;

import java.util.ArrayList;

public class AlbumsFragment extends Fragment {
    private ArrayList<AlbumModel> albumDatas = new ArrayList<>();
    private FragmentAlbumsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAlbumsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Uri collection = MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI;

        String[] projection = {
                MediaStore.Audio.Albums.ALBUM_ART,
                MediaStore.Audio.Albums.ALBUM,
                MediaStore.Audio.Albums.ARTIST
        };

        String selection = MediaStore.Audio.Albums.ARTIST + " != ?";
        String[] selectionArgs = new String[] { "<unknown>"
        };

        @SuppressLint("Recycle") Cursor cursor = requireContext().getContentResolver().query(
                collection,
                projection,
                selection,
                selectionArgs,
                MediaStore.Audio.Albums.ALBUM);

        int _album_art = cursor.getColumnIndexOrThrow(MediaStore.Audio.Albums.ALBUM_ART);
        int _album = cursor.getColumnIndexOrThrow(MediaStore.Audio.Albums.ALBUM);
        int _artist = cursor.getColumnIndexOrThrow(MediaStore.Audio.Albums.ARTIST);

        while(cursor.moveToNext()){
            String artist = cursor.getString(_artist);
            String album = cursor.getString(_album);
            int album_art = cursor.getInt(_album_art);

            AlbumModel albumData = new AlbumModel(album_art, album, artist);

            if(!albumDatas.contains(albumData)){
                albumDatas.add(albumData);
            }
        }

        AlbumListAdapter adapter = new AlbumListAdapter(albumDatas, requireContext().getApplicationContext());

        binding.recyclerViewAlbum.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerViewAlbum.setAdapter(adapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.action_settings).setVisible(false);
        super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onResume() {
        super.onResume();
        binding.recyclerViewAlbum.setAdapter(new AlbumListAdapter(albumDatas, requireContext().getApplicationContext()));
    }
}