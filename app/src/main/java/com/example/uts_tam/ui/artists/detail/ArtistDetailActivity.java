                        package com.example.uts_tam.ui.artists.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.uts_tam.R;

import java.util.Objects;

                        public class ArtistDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_detail);

        String d;

        TextView artistName = findViewById(R.id.detail_artist_name);

        d = getIntent().getStringExtra("artist_name");

        artistName.setText(d);

        Objects.requireNonNull(getSupportActionBar()).setTitle(d);
    }
}