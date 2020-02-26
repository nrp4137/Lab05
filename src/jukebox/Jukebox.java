package jukebox;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/** Nolan Porter
 * Class that represents a jukebox with songs in it
 */
public class Jukebox {

    private HashMap<Song, Integer> song_list;
    private int total;
    private int size;
    private int average;
    private long time;


    public static void main(String[] args) throws FileNotFoundException {
        Jukebox juke = new Jukebox(args[0]);
        String param1 = args[1];
        int param = Integer.parseInt(param1);
        juke.run_simulation(param);
        juke.generate_stats();
        juke.print_stats();


    }

    /**
     * Constructor for jukebox. It loads in a list of songs from a given file into a hash map
     * @param filename the file given of the command line
     * @throws FileNotFoundException
     */
    public Jukebox(String filename) throws FileNotFoundException {
        Scanner in = new Scanner(new File(filename));
        HashMap<Song, Integer> map = new HashMap<>();
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] split_line = line.split("<SEP>", 4);
            String artist = split_line[2];
            String song = split_line[3];
            Song next_song = new Song(artist, song);

            map.put(next_song, 0);


        }
        in.close();
        this.song_list = map;
    }

    /**
     * Runs the simulation 50000 times and each simulation stops when the same song is played
     * @param seed1 the seed from the param line
     */
    public void run_simulation(int seed1) {
        Random rnd = new Random(seed1);
        int i;
        int counter = 0;

        Set<Song> new_set = song_list.keySet();

        long start_time = System.currentTimeMillis();
        for (i = 0; i < 50000; i++) {
            HashSet<Song> already_played = new HashSet<>();
            Song[] new_list = new_set.toArray(new Song[0]);
            int indexer = rnd.nextInt(new_set.size());
            while(! already_played.contains(new_list[indexer])) {
                counter += 1;
                already_played.add(new_list[indexer]);
                int value = song_list.get(new_list[indexer]) + 1;
                song_list.put(new_list[indexer], value);
                indexer = rnd.nextInt(new_set.size());
            }
        }
        long end_time = System.currentTimeMillis();
        this.total = counter;
        this.time = (end_time - start_time)/ 1000;


    }

    /**
     * generates stats and sets them equal to fields
     */
    public void generate_stats() {
        this.average = total / 50000;
        this.size = song_list.size();

    }

    /**
     * Prints out the fields in a nice format
     */
    public void print_stats() {
        System.out.println("Jukebox of " + size + " songs");
        System.out.println("Simulation took " + time + " seconds");
        System.out.println("Total number of songs played " + total);
        System.out.println("Average number of songs played " + average);

    }
}
