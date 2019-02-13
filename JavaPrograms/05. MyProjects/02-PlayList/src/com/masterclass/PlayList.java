package com.masterclass;

import java.util.*;

public class PlayList {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean suppressSuccess = false;
    private static ArrayList<Album> collection = new ArrayList<>();
    private static LinkedList<Song> playlist   = new LinkedList<>();
    private static Album album;
    private static Song song;


    public static void main(String[] args) {
        // write your code here
        Result result = new Result();
        result.setSuppress(false);
        initPlayList();
        playList();

    }
    private static void playList() {
        Result result = new Result();
        result.setSuppress(false);
        int choice;
        while (true) {
            choice = playListMenu();
            if (choice == 9) {
                oln("Player exited", "");
                break;
            }
            switch (choice) {
                case 1:
                    showPlaylist();
                    break;
                case 2:
                    addSong2Playlist();
                    break;
                case 3:
                    removeSongFromPlaylist();
                    break;
                case 4:
                    showCollection();
                    break;
                case 5:
                    startPlayer();
                    break;
            }
        }
    }
    private static int playListMenu() {
        int choice;
        oln("----------", "");
        oln("Playlist menu : "
                        + "\n\t1. Show playList   (" + playlist.size() + " songs)"
                        + "\n\t2. Add song to playlist"
                        + "\n\t3. Remove song from playlist"
                        + "\n\t4. Show collection (" + collection.size() + " albums)"
                        + "\n\t5. Play Music"
                        + "\n\t9. Exit"
                , "");
        choice = getInt("Enter your choice ");
        return choice;
    }

    private static void showPlaylist() {
        oln("----------", "");
        oln("Playlist", "");
        if (playlist.size() == 0) {
            oln("Playlist is empty", "");
            return;
        }
        for (int i = 0; i < playlist.size(); i++) {
            oln((i + 1) + ". " + playlist.get(i).toString(), "\t");
        }
    }
    private static void showCollection() {
        oln("----------", "");
        oln("Collection", "");
        if (collection.size() == 0) {
            oln("Collection is empty", "");
            return;
        }
        for (int i = 0; i < collection.size(); i++) {
            oln((i + 1) + ". " + collection.get(i).toString(), "");
        }
    }
    private static void addSong2Playlist() {
        oln("----------", "");
        oln("Add song to playlist", "");
        if (collection.size() == 0) {
            oln("You have not albums in your collection", "");
            return;
        }
        chooseAlbum();
    }
    private static void chooseAlbum() {
        Album album;
        Song  song = null;
        int choice, minValue = 1, maxValue = 0;

        oln("----------", "");
        oln("Choose an album", "");
        if (collection.size() == 0) {
            oln("You have not albums in your collection", "");
            return;
        }
        for (int i = 0; i < collection.size(); i++) {
            maxValue++;
            album = collection.get(i);
            oln(maxValue + ". Album " + album.getTitle()
                            + " (" + album.getSongsCount() + " songs)"
                    , "\t");
        }
        oln("0. Exit", "\t");
        while (true) {
            choice = getInt("Enter your choice");
            if (choice == 0) {
                return;
            }
            if (choice < 0 || choice > maxValue) {
                oln("Invalid choice. Try again ...", "");
            } else {
                chooseSong(collection.get(choice - 1));
                return;
            }
        }
    }
    private static void chooseSong(Album album) {
        Song song = null;
        int choice, minValue = 1, maxValue = 0;

        oln("----------", "");
        oln("Choose a song from " + album.getTitle(), "");
        if (album.getSongsCount() == 0) {
            oln("There are no songs on this album", "");
            return;
        }
        for (int i = 0; i < album.songs.size(); i++) {
            maxValue++;
            song = album.songs.get(i);
            oln(maxValue + ". " + song.getTitle(), "\t");
        }
        oln("0. Exit", "\t");
        while (true) {
            choice = getInt("Enter your choice");
            if (choice == 0) {
                return;
            }
            if (choice < 0 || choice > maxValue) {
                oln("Invalid choice. Try again ...", "");
            } else if (isSongOnPlayList(album.songs.get(choice - 1) ) ) {
                oln("Song is already on playlist. Try again", "");
            } else {
                playlist.add(album.songs.get(choice - 1));
                return;
            }
        }
    }
    private static boolean isSongOnPlayList(Song song) {
        for (int i = 0; i < playlist.size(); i++) {
            if (playlist.get(i).equals(song)) {
                return true;
            }
        }
        return false;
    }

    private static void removeSongFromPlaylist() {
        Song song = null;
        int choice, minValue = 1, maxValue = 0;

        oln("----------", "");
        oln("Choose a song to remove playlist", "");
        if (playlist.isEmpty()) {
            oln("There are no songs on the playlist", "");
            return;
        }
        for (int i = 0; i < playlist.size(); i++) {
            maxValue++;
            song = playlist.get(i);
            oln(maxValue + ". " + song.getTitle(), "\t");
        }
        oln("0. Exit", "\t");
        while (true) {
            choice = getInt("Enter your choice");
            if (choice == 0) {
                return;
            }
            if (choice < 0 || choice > maxValue) {
                oln("Invalid choice. Try again ...", "");
            } else {
                playlist.remove(choice - 1);
                return;
            }
        }
    }
    private static void startPlayer() {
        Song song = null;
        int choice = 0, minValue = 1, maxValue = 0;
        boolean quit = false, goingForward = true;
        ListIterator<Song> listIterator = playlist.listIterator();

        oln("----------", "");
        oln("Start player", "");
        if (playlist.isEmpty()) {
            oln("There are no songs on the playlist", "");
            return;
        }
        oln("Now playing " + listIterator.next().getTitle(), "\t");

        choice = 3;
        while (!quit) {
            if (choice == 3) {
                oln("Options :"
                                + "\n\t1 - Next song"
                                + "\n\t2 - Previous song"
                                + "\n\t3 - Print menu options"
                                + "\n\t9 - Exit"
                        , "");
            }
            choice = getInt("Enter your choice");

            switch (choice) {
                case 1:
                    // next
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        oln("Now playing "
                                + listIterator.next().getTitle(), "");
                    } else {
                        oln("Reached end of playlist", "");
                        goingForward = false;
                    }
                    break;
                case 2:
                    // previous
                    oln("previous", "");
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        oln("Now playing "
                                + listIterator.previous().getTitle(), "");
                    } else {
                        oln("Reached beginning of playlist", "");
                        goingForward = true;
                    }
                    break;
                case 9:
                    // exit
                    oln("Exit player", "");
                    quit = true;
                    break;
                default:
                    oln("Invalid choice. Try again ...");
                    break;
            }
        }
    }
    private static void initPlayList() {
        Result result = new Result();
        result.setSuppress(false);

        addAlbum2Collection(collection, "First album", result);
        addAlbum2Collection(collection, "Second album", result);
        for (int i = 0; i < collection.size(); i++) {
            for (int j = 1; j < 6; j++) {
                album = collection.get(i);
                addSong2Album( album, "Song " + (i + 1) + "-" + j, j*9, j*9, result );
            }
        }
        for (int i = 0; i < collection.size(); i++) {
            album = collection.get(i);
            oln(album.toString());
        }

    }

    private static void addAlbum2Collection(ArrayList<Album> collection, String title, Result result) {
        if (title == "") {
            result.setFail("Album title is empty");
        } else {
            Album album = new Album(title);
            collection.add(album);
            result.setSucceed("Album added to collection");
        }
        printResult(result);
    }

    private static void addSong2Album(Album album, String title, int durationMinutes, int durationSeconds) {
        Result result = new Result();
        result.setSuppress(false);
        addSong2Album(album, title, durationMinutes, durationSeconds, result);
    }
    private static void addSong2Album(Album album, String title, int durationMinutes, int durationSeconds, Result result) {
        if (title == "") {
            result.setFail("Song title is empty");
        } else {
            Song song = new Song(title, durationMinutes, durationMinutes);
            album.addSong(song, result);
            result.setSucceed("Song added to album " + album.getTitle());
        }
        printResult(result);
    }



    // - Helpers -
    private static void printResult(Result result) {
        if ( ( !result.isSuccess() || !result.isSuppress() ) ) oln(result.toString());
        result.reset();
    }


    // System.out.print**() short hand
    private static void o(String text) {
        o(text, true);
    }
    private static void o(String text, boolean prefix) {
        o(text, (prefix ? "- " : ""), "");
    }
    private static void o(String text, String prefix) {
        o(text, prefix, "");
    }
    private static void o(String text, boolean prefix, String suffix) {
        o(text, (prefix ? "- " : ""), suffix);
    }
    private static void o(String text, String prefix, String suffix) {
        System.out.print(prefix + text + suffix);
    }

    private static void oln(String text) {
        oln(text, true);
    }
    private static void oln(String text, boolean prefix) {
        oln(text, (prefix ? "= " : ""), "");
    }
    private static void oln(String text, String prefix) {
        oln(text, prefix, "");
    }
    private static void oln(String text, String prefix, String suffix) {
        System.out.println(prefix + text + suffix);
    }


    // Print int[] array  -> [0, 1, 2, 3, ...]
    private static void printArray(int[] array) {
        oln(Arrays.toString(array));
    }

    // ArrayList
    // Print ArrayList<Integer>
    private static void printALInteger(ArrayList<Integer> array) {
        oln("------------", "");
        for (int i = 0; i < array.size(); i++) {
            oln(i + " : " + array.get(i), ">");
        }
        oln("============", "");
    }
    // Print ArrayList<String>
    private static void printALString( ArrayList<String> array ) {
        oln("------------", "");
        for (int i = 0; i < array.size(); i++) {
            oln(i + " : " + array.get(i), ">");
        }
        oln("============", "");
    }

    // LinkedList
    // Print LinkedList<String>
    private static void printLLString(
            LinkedList<String> linkedList, String prefix ) {
        Iterator<String> iterator = linkedList.iterator();
        oln("------------", "");
        while (iterator.hasNext()) {
            oln(prefix + iterator.next(), ">");
        }
        oln("============", "");
    }
    // Insert String in LinkedList<String> in alphabetical order.
    private static boolean addInOrderLLString(
            LinkedList<String> linkedList, String newString, boolean allowDoubles ) {
        // Add string in alphabetical order in LinkedList<String>
        ListIterator<String> listIterator = linkedList.listIterator();
        while ( listIterator.hasNext() ) {
            int comparison = listIterator.next().compareTo(newString);
            if ( comparison == 0) {
                // Already exists
                if ( !allowDoubles ) {
                    // Not doubles allowed
                    oln(newString + " is already in our list");
                    return false;
                }
                // Double, add here
                listIterator.add(newString);
                return true;
            } else if ( comparison > 0 ){
                // Should be inserted before this one,
                //  hasNext already has us on this element,
                //  so we have to go back one before adding it.
                listIterator.previous();
                listIterator.add(newString);
                return true;
            }
        }
        // Not inserted yet, insert at end
        listIterator.add(newString);
        return true;
    }


    // User input
// public class Main {
//    private static Scanner scanner = new Scanner(System.in);
//    public static void main(String[] args) {
//        int[] myIntArray = getIntegers(5);
//    }

    private static int[] getIntegers(int number) {
        oln("Enter " + number + " integer values.\r");
        int[] values = new int[number];
        int i = 0;
        while (i < values.length) {
            o("Enter number " + (i + 1) + " : ");
            if (scanner.hasNextInt()) {
                values[i] = scanner.nextInt();
                i++;
            }
            scanner.nextLine();
            o("", false, "");
        }
        return values;
    }
    private static int getInt() {
        return getInt("Enter your choice ");
    }
    private static int getInt(String prompt) {
        int i = 0;
        o(prompt + " : ");
        if (scanner.hasNextInt()) {
            i = scanner.nextInt();;
        }
        scanner.nextLine();
        return i;
    }

}
