import java.util.*;

class Song {
    String title;
    String artist;

    Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Song))
            return false;

        Song other = (Song) obj;
        return title.equals(other.title) && artist.equals(other.artist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, artist);
    }

    @Override
    public String toString() {
        return title + " - " + artist;
    }
}

public class MediaPlayerQueue {

    static LinkedList<Song> playlist = new LinkedList<>();
    static LinkedList<Song> history = new LinkedList<>();

    static void addSong(Song song) {
        playlist.add(song);
    }

    static void addPrioritySong(Song song) {
        playlist.addFirst(song);
    }

    static void removeDuplicates() {
        HashSet<Song> uniqueSongs = new HashSet<>();
        ListIterator<Song> iterator = playlist.listIterator();

        while (iterator.hasNext()) {
            Song song = iterator.next();

            if (!uniqueSongs.add(song)) {
                iterator.remove();
            }
        }
    }

    static void playNext() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }

        Song song = playlist.removeFirst();
        history.add(song);

        System.out.println("Now Playing: " + song);
    }

    static void displayForward() {
        System.out.println("\nPlaylist Forward:");

        ListIterator<Song> iterator = playlist.listIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    static void displayBackward() {
        System.out.println("\nPlaylist Backward:");

        ListIterator<Song> iterator = playlist.listIterator(playlist.size());

        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }

    static void displayHistory() {
        System.out.println("\nRecently Played:");

        ListIterator<Song> iterator = history.listIterator(history.size());

        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }

    public static void main(String[] args) {

        Song s1 = new Song("Believer", "Imagine Dragons");
        Song s2 = new Song("Perfect", "Ed Sheeran");
        Song s3 = new Song("Blinding Lights", "The Weeknd");

        addSong(s1);
        addSong(s2);
        addSong(s3);
        addSong(s2);

        addPrioritySong(new Song("Enemy", "Imagine Dragons"));

        System.out.println("Before Removing Duplicates:");
        displayForward();

        removeDuplicates();

        System.out.println("\nAfter Removing Duplicates:");
        displayForward();

        displayBackward();

        playNext();
        playNext();

        displayHistory();
    }
}