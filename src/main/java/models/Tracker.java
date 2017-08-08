package models;

import java.util.ArrayList;

/**
 * Created by Guest on 8/8/17.
 */
public class Tracker {
    private String albumName;
//    private String artistName;
//    private int yearReleased;
//    private String genre;
//    private Boolean favoriteList;
    private static ArrayList<Tracker> instances= new ArrayList<Tracker>();



    public Tracker(String albumName) {
        this.albumName = albumName;
        instances.add(this);

    }

    public String getAlbumName() {
        return albumName;
    }

    public static ArrayList<Tracker> getAll(){
        return instances;
    }

    public static void clearAllAlbums() {
        instances.clear();
    }

}
