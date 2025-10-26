package Exer_15;
import java.util.HashMap;
import java.util.Random;

class Song {
    private String title, artist, duration, genre, trackID;
    private int year;

    Song(String title, String artist, String duration, String genre, int year, String trackID) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.genre = genre;
        this.year = year;
        this.trackID = trackID;
    }

    public void displaySongInfo() {
        System.out.println("Title: " + title);
        System.out.println("Artist: " + artist);
        System.out.println("Duration: " + duration);
        System.out.println("Genre: " + genre);
        System.out.println("Year: " + year);
        System.out.println("Track ID: " + trackID);
    }

    public String getTitle() {
        return title;
    }
    public String getArtist() {
        return artist;
    }
    public String getDuration() {
        return duration;
    }
    public String getGenre() {
        return genre;
    }
    public int getYear() {
        return year;
    }
    public String getTrackID() {
        return trackID;
    }
}

public class MusicLibraryMain {

    private HashMap<String, Song> musicLibrary;
    private Random random = new Random();

    MusicLibraryMain() {
        musicLibrary = new HashMap<>();
    }

    public void addSong(Song song) {
        boolean exists = trackIdChecker(song.getTrackID());

        if(!exists) {
            musicLibrary.put(song.getTrackID(), song);
            System.out.println("Song with Track ID " + song.getTrackID() + " added to the library.");
        } else {
            System.out.println("Song with Track ID " + song.getTrackID() + " already exists in the library.");
        }
    }

    public void removeSong(Song song) {
        boolean exists = trackIdChecker(song.getTrackID());

        if(exists) {
            musicLibrary.remove(song.getTrackID());
            System.out.println("Song with Track ID " + song.getTrackID() + " removed from the library.");
        } else {
            System.out.println("Song with Track ID " + song.getTrackID() + " does not exist in the library.");
        }
    }

    public boolean trackIdChecker(String trackID) {
        return musicLibrary.containsKey(trackID);
    }

    public void displayAllSongs() {
        for(Song song : musicLibrary.values()) {
            song.displaySongInfo();
            System.out.println("-------------------");
        }
    }

    public void playRandomSong() {
        if (musicLibrary.isEmpty()) {
            System.out.println("The music library is empty.");
            return;
        }

        Song[] songs = musicLibrary.values().toArray(new Song[0]);
        Song randomSong = songs[random.nextInt(songs.length)];
        

        System.out.println("Now playing: " + randomSong.getTitle() + " by " + randomSong.getArtist());
    }

    public static void main (String[] args) {

        Song song1 = new Song("Blinding Lights", "The Weeknd", "3:20", "Pop", 2019, "TL001");
        Song song2 = new Song("Shape of You", "Ed Sheeran", "4:24", "Pop", 2017, "TL002");
        Song song3 = new Song("Bohemian Rhapsody", "Queen", "5:55", "Rock", 1975, "TL003");

        MusicLibraryMain myMusicLibrary = new MusicLibraryMain();

        myMusicLibrary.addSong(song1);
        myMusicLibrary.addSong(song2);
        myMusicLibrary.addSong(song3);

        myMusicLibrary.displayAllSongs();
        myMusicLibrary.playRandomSong();
    }
}
