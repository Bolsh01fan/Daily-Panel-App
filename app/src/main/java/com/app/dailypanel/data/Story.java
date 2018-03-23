package com.app.dailypanel.data;

public class Story {
    private int description;
    private int imageResource;
    private String storyUrl;

    public Story(int newDescription, int newImageResource, String newStoryUrl) {
        description = newDescription;
        imageResource = newImageResource;
        storyUrl = newStoryUrl;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int newDescription) {
        description = newDescription;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int newImageResource) {
        imageResource = newImageResource;
    }

    public String getStoryUrl() {
        return storyUrl;
    }

    public void setStoryUrl(String newImageUrl) {
        storyUrl = newImageUrl;
    }
}