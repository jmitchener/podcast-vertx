package com.github.jmitchener.podcast.directory;

/**
 * Object representing a Podcast entry in a {@link PodcastDirectory}
 */
public class Podcast {
    public String name;
    public String feedUrl;
    public byte[] image;

    public Podcast(final String name, final String feedUrl, final byte[] image) {
        this.name = name;
        this.feedUrl = feedUrl;
        this.image = image;
    }
}
