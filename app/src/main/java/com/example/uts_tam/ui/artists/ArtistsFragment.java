package com.example.uts_tam.ui.artists;

import android.annotation.SuppressLint;
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
import com.example.uts_tam.databinding.FragmentArtistsBinding;
import com.example.uts_tam.ui.artists.ArtistModel;
import com.google.android.material.appbar.AppBarLayout;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ArtistsFragment extends Fragment {
    private ArrayList<String> artistList = new ArrayList<>();
    private FragmentArtistsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ArtistsViewModel artistsViewModel = new ViewModelProvider(this).get(ArtistsViewModel.class);

        binding = FragmentArtistsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        Uri collection = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;

        String[] projection = {
                MediaStore.Audio.Artists.ARTIST
        };

        String selection = MediaStore.Audio.Artists.ARTIST + " != ?";
        String[] selectionArgs = new String[] { "<unknown>"
        };

        @SuppressLint("Recycle") Cursor cursor = requireContext().getContentResolver().query(
                collection,
                projection,
                selection,
                selectionArgs,
                MediaStore.Audio.Media.ARTIST);

        int _artist = cursor.getColumnIndexOrThrow(MediaStore.Audio.Artists.ARTIST);

        while(cursor.moveToNext()){
            String artist = cursor.getString(_artist);

            if(!artistList.contains(artist)){
                artistList.add(artist);
            }
        }

        if (artistList.size() != 0) {
            binding.recyclerViewArtist.setLayoutManager(new LinearLayoutManager(getContext()));
            binding.recyclerViewArtist.setAdapter(new ArtistListAdapter(artistList, requireContext().getApplicationContext()));
        }

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
        binding.recyclerViewArtist.setAdapter(new ArtistListAdapter(artistList, requireContext().getApplicationContext()));
    }
}