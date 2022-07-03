package com.example.uts_tam.ui.albums.detail;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContentProviderCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.uts_tam.R;
import com.example.uts_tam.databinding.FragmentAlbumsBinding;
import com.example.uts_tam.databinding.FragmentSongsBinding;
import com.example.uts_tam.ui.songs.AudioModel;
import com.example.uts_tam.ui.songs.SongListAdapter;

import java.security.AccessController;
import java.util.ArrayList;
import java.util.Objects;

public class AlbumDetailActivity extends AppCompatActivity {
    private ArrayList<AudioModel> songsList = new ArrayList<>();
    private FragmentSongsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_detail);

        Bundle covers;
        String n, d;
        int p;

        ImageView photo = findViewById(R.id.detail_album_art);
        TextView albumTitle = findViewById(R.id.detail_album_title);
        TextView albumArtist = findViewById(R.id.detail_album_artist);

        covers = getIntent().getExtras();
        p = covers.getInt("art");
        n = getIntent().getStringExtra("album_title");
        d = getIntent().getStringExtra("album_artist");

        photo.setImageResource(p);
        albumTitle.setText(n);
        albumArtist.setText(d);

        Objects.requireNonNull(getSupportActionBar()).setTitle(n);
    }
}