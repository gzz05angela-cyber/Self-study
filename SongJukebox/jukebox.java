package SongJukebox;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class jukebox {
    public static void main (String[] args){
        new jukebox().go();
    }

    public void go(){
        List<Song> songList = MockSongs.getSongs();
        System.out.println("songList");

        Collections.sort(songList);
        System.out.println(songList);
    }
}

class Song implements Comparable<Song>{
    private String title;
    private String artist;
    private int bpm;

    Song(String title, String artist, int bpm){
        this.title = title;
        this.artist = artist;
        this.bpm = bpm;
    }

    public String getTitle(){
        return title;
    }

    public String getArtist(){
        return artist;
    }

    public int getBpm(){
        return bpm;
    }

    @Override
    public int compareTo(Song other){
        return title.compareToIgnoreCase(other.title);
    }

    @Override
    public String toString(){
        return title;
    }
}

class MockSongs{
    public static List<Song> getSongs(){
        List<Song> songs = new ArrayList<>();
        songs.add(new Song("somersault","zero 7",147));
        songs.add(new Song("pineapple","finegod",60));
        songs.add(new Song("happy life","goodbye",59));
        songs.add(new Song("Happy life","summer",150));
        return songs;
    }
}
