package com.app.dailypanel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.app.dailypanel.adapter.StoriesAdapter;
import com.app.dailypanel.data.Story;

public class MainActivity extends AppCompatActivity {
    private Story[] stories = {
            new Story(R.string.sample_university_text,
            R.drawable.sample_university_thumbnail,
            "http://dailypanel.org/article/20150310sae"),
    new Story(R.string.sample_rob_menedez_text,
            R.drawable.sample_rob_menenedez_thumbnail,
            "http://dailypanel.org/article/20150307menendez"),
    new Story(R.string.sample_food_stamp_text,
            R.drawable.sample_food_stamp,
            "http://dailypanel.org/article/20150314snap"),
    new Story(R.string.sample_ban_bullets_text,
            R.drawable.sample_ban_bullets,
            "http://dailypanel.org/article/20150227bullet")};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView ivHeadline = (ImageView) findViewById(R.id.image_view_headline_image);
        ivHeadline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("url", "http://dailypanel.org/article/20150302lashooting");

                Intent intent = new Intent(getApplicationContext(), ReadStoryActivity.class);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });

        GridView gvStory = (GridView) findViewById(R.id.grid_view_stories);
        final StoriesAdapter storiesAdapter = new StoriesAdapter(this, stories);
        gvStory.setAdapter(storiesAdapter);

        gvStory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Story story = stories[position];

                Bundle bundle = new Bundle();
                bundle.putString("url", story.getStoryUrl());

                Intent intent = new Intent(getApplicationContext(), ReadStoryActivity.class);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });
    }
}