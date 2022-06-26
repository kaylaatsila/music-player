package com.example.uts_tam.ui.albums.detail;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.uts_tam.R;
import com.example.uts_tam.databinding.FragmentAlbumsBinding;

import java.util.Objects;

public class AlbumDetailActivity extends AppCompatActivity {
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