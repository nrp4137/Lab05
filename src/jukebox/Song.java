package jukebox;


/** Nolan Porter
 * Class that represents songs to be put in the jukebox
 */
public class Song implements Comparable <Song> {

    private String artist;
    private String song;


    /**
     * Constructor for Song initializes fields
     * @param artist artist of song as a string
     * @param song song title as string
     */
    public Song(String artist, String song) {
        this.artist = artist;
        this.song = song;
    }

    /**
     * gets the artist name from the field
     * @return String
     */
    public String getArtist() {
        return this.artist;
    }

    /**
     * gets the song name from field
     * @return String
     */
    public String getSong() {
        return this.song;
    }

    /**
     * overrides the equals method to show whether two songs are the same
     * @param o object
     * @return a boolean
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Song)) {
            return false;
        }
        Song other = (Song)o;
        if (this.artist.equals(other.artist)) {
            return this.song.equals(other.song);
        }
        return false;
    }

    /**
     * creates a unique number for different instances of songs, overriding hashCode default method
     * @return int
     */
    @Override
    public int hashCode() {
        return song.hashCode() + artist.hashCode();
    }

    /**
     * Compares two songs and orders them in alphabetical by artist
     * @param other Song
     * @return int
     */
    public int compareTo(Song other) {
        int artistC = this.artist.compareTo(other.artist);

        if (artistC == 0) {
            return this.song.compareTo(other.song);
        }
        return artistC;
    }
}
