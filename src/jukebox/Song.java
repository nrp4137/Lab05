package jukebox;

public class Song implements Comparable <Song> {

    private String artist;
    private String song;

    public Song(String artist, String song) {
        this.artist = artist;
        this.song = song;
    }

    public String getArtist() {
        return this.artist;
    }

    public String getSong() {
        return this.song;
    }

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

    @Override
    public int hashCode() {
        return song.hashCode() + artist.hashCode();
    }

    public int compareTo(Song other) {
        int artistC = this.artist.compareTo(other.artist);

        if (artistC == 0) {
            return this.song.compareTo(other.song);
        }
        return artistC;
    }
}
