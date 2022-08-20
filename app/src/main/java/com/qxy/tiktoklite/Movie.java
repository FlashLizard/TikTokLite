package com.qxy.tiktoklite;

// film, tvplay or variety
public class Movie {

    static public final int FILM = 0, TVPLAY = 1, VARIETY = 2;

    int type = FILM;
    String coverPath, title, time, director/*4*/, actor/*5*/, discussHot, searchHot, themeHot, influenceHot;
    String englishName;

    public Movie(String coverPath, String title, String time, String director, String actor,
                 String discussHot, String searchHot, String themeHot, String influenceHot)
    {
        type = FILM;
        this.coverPath = coverPath;
        this.title = title;
        this.time = time;
        this.director = director;
        this.actor = actor;
        this.discussHot = discussHot;
        this.searchHot = searchHot;
        this.themeHot = themeHot;
        this.influenceHot = influenceHot;
    }

    public Movie(String coverPath, String title, String time, String director, String actor,
                 String discussHot, String searchHot, String themeHot, String influenceHot, String englishName)
    {
        type = TVPLAY;
        this.coverPath = coverPath;
        this.title = title;
        this.time = time;
        this.director = director;
        this.actor = actor;
        this.discussHot = discussHot;
        this.searchHot = searchHot;
        this.themeHot = themeHot;
        this.influenceHot = influenceHot;
        this.englishName = englishName;
    }

    public Movie(String coverPath, String title, String discussHot, String searchHot,
                 String themeHot, String influenceHot, String englishName)
    {
        type = VARIETY;
        this.coverPath = coverPath;
        this.title = title;
        this.discussHot = discussHot;
        this.searchHot = searchHot;
        this.themeHot = themeHot;
        this.influenceHot = influenceHot;
        this.englishName = englishName;
    }
}
