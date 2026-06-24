package SongJukeboxTwo;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class JukeboxTwo {
    public static void main(String[] args) {
        new JukeboxTwo().go();
    }

    public void go(){
        List<Song> songList = MockSongs.getSongs();
        System.out.println(songList);

        Collections.sort(songList);
        System.out.println(songList);

        ArtistCompare artistCompare = new ArtistCompare();
        songList.sort(artistCompare);
        System.out.println(songList);
    }
}

class ArtistCompare implements Comparator<Song>{
    public int compare(Song one, Song two){
        return one.getArtist().compareTo(two.getArtist());
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