package com.app.dailypanel.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.dailypanel.R;
import com.app.dailypanel.data.Story;

public class StoriesAdapter extends BaseAdapter {
    private Context mContext;
    private Story[] stories;

    public StoriesAdapter(Context newContext, Story[] newStories) {
        mContext = newContext;
        stories = newStories;
    }

    @Override
    public int getCount() {
        return stories.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Story story = stories[position];

        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.story_thumbnail, null);
        }

        ImageView ivStoryThumbnail = (ImageView) convertView.findViewById(R.id.image_view_story_thumbnail);
        TextView tvStoryDescription = (TextView) convertView.findViewById(R.id.text_view_story_description);

        ivStoryThumbnail.setImageResource(story.getImageResource());
        tvStoryDescription.setText(mContext.getString(story.getDescription()));

        return convertView;
    }
}