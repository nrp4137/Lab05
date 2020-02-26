package jukebox;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Jukebox {

    private HashMap<Song, Integer> song_list;
    private Random seed;

    public static void main(String[] args) throws FileNotFoundException {

    }

    public Jukebox(String filename) throws FileNotFoundException {
        Scanner in = new Scanner(new File(filename));
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] split_line = line.split("<SEP>", 4);
            String artist = split_line[2];
            String song = split_line[3];
            Song next_song = new Song(artist, song);
            if (!(this.song_list.containsKey(next_song))) {
                this.song_list.put(next_song, 0);
            }
        }
        in.close();
    }

    public void run_simulation(long seed1) {
        this.seed = new Random(seed1);
        int i;
        int counter = 0;

        Set<Song> new_list = song_list.keySet();
        HashSet<Song> already_played = new HashSet<>();
        for (i = 0; i < 50000; i++) {
            while()


        }

    }
}
