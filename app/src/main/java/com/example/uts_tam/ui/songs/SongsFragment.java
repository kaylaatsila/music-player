package com.example.uts_tam.ui.songs;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.uts_tam.R;
import com.example.uts_tam.databinding.FragmentSongsBinding;

import java.util.ArrayList;

public class SongsFragment extends Fragment {
    private ArrayList<AudioModel> songsList = new ArrayList<>();
    private ArrayList<AudioModel> songsSearchList = new ArrayList<>();
    private FragmentSongsBinding binding;
    private MenuItem menuItem;
    private SearchView searchView;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSongsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Uri collection = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;

        String[] projection = {
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.ARTIST,
                MediaStore.Audio.Media.DURATION
        };

        String selection = MediaStore.Audio.Media.ARTIST + " != ?";
        String[] selectionArgs = new String[] { "<unknown>" };

        @SuppressLint("Recycle") Cursor cursor = requireContext().getContentResolver().query(
                collection,
                projection,
                selection,
                selectionArgs,
                MediaStore.Audio.Media.TITLE);

        int _path = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA);
        int _title = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE);
        int _artist = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST);
        int _duration = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION);

        while(cursor.moveToNext()){
            String path = cursor.getString(_path);
            String name = cursor.getString(_title);
            String artist = cursor.getString(_artist);
            String duration = cursor.getString(_duration);

            AudioModel songData = new AudioModel(path, name, artist, duration);

            if(!songsList.contains(songData)){
                songsList.add(songData);
            }
        }

        if(songsList.size()==0){
            binding.noSongsText.setVisibility(View.VISIBLE);
        }else{
            binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            binding.recyclerView.setAdapter(new SongListAdapter(songsList, requireContext().getApplicationContext()));
        }

        return root;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.option_menu, menu);
        menuItem = menu.findItem(R.id.action_search);
        searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setIconified(true);

        SearchManager searchManager = (SearchManager) requireActivity().getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(requireActivity().getComponentName()));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                mysearch(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                mysearch(query);
                return true;
            }
        });
    }

    private void mysearch(String query) {
        Uri collection = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;

        String[] projection = {
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.ARTIST,
                MediaStore.Audio.Media.DURATION
        };

        String[] selectionArgs = new String[] { "<unknown>" };

        @SuppressLint("Recycle") Cursor cursor = requireContext().getContentResolver().query(
                collection,
                projection,
                query,
                selectionArgs,
                MediaStore.Audio.Media.TITLE);

        int _path = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA);
        int _title = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE);
        int _artist = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST);
        int _duration = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION);

        while(cursor.moveToNext()){
            String path = cursor.getString(_path);
            String name = cursor.getString(_title);
            String artist = cursor.getString(_artist);
            String duration = cursor.getString(_duration);

            AudioModel songData = new AudioModel(path, name, artist, duration);

            if(!songsSearchList.contains(songData)){
                songsSearchList.add(songData);
            }
        }

        if(songsSearchList.size()==0){
            binding.noSongsText.setVisibility(View.VISIBLE);
        }else{
            binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            binding.recyclerView.setAdapter(new SongListAdapter(songsSearchList, requireContext().getApplicationContext()));
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onResume() {
        super.onResume();
        binding.recyclerView.setAdapter(new SongListAdapter(songsList, requireContext().getApplicationContext()));
    }
}