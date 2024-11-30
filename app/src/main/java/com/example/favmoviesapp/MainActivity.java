package com.example.favmoviesapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText movieNameInput;
    private SeekBar ratingBar;
    private TextView movieList;
    private Button submitButton;
    private ArrayList<String> movies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        movieNameInput = findViewById(R.id.movieNameInput);
        ratingBar = findViewById(R.id.ratingBar);
        movieList = findViewById(R.id.movieList);
        submitButton = findViewById(R.id.submitButton);

        // Set button click listener
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMovie();
            }
        });
    }

    private void addMovie() {
        // Get movie name and rating
        String movieName = movieNameInput.getText().toString().trim();
        int rating = ratingBar.getProgress();

        // Check if the input is valid
        if (!movieName.isEmpty()) {
            // Add movie to list
            movies.add(movieName + " - Rating: " + rating);
            updateMovieList();
            movieNameInput.setText(""); // Clear input field
        }
    }

    private void updateMovieList() {
        // Update the movie list TextView
        StringBuilder list = new StringBuilder();
        for (String movie : movies) {
            list.append(movie).append("\n");
        }
        movieList.setText(list.toString());
    }
}
