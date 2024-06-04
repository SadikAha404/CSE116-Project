package tests;

import org.junit.Test;
import ratings.Playlist;
import ratings.Rating;
import ratings.Song;
import ratings.datastructures.BinaryTreeNode;
import ratings.datastructures.LinkedListNode;
import ratings.datastructures.SongBayesianRatingComparator;
import ratings.datastructures.SongTitleComparator;

import static org.junit.Assert.*;

public class TestDataStructures2 {

    TestClasses1 TestClass1 = new TestClasses1();
    TestDataStructures1 TestDataStructure1 = new TestDataStructures1();
    public boolean compareSongTrees(BinaryTreeNode<Song> one, BinaryTreeNode<Song> two){
        if (one == null && two == null){
            return true;
        } else if (one == null || two == null) {
            return false;
        }
        boolean checkSongs = TestClass1.compareSongs(one.getValue(),two.getValue());
        boolean checkRatings = TestDataStructure1.compareListsOfRatings(one.getValue().getRatings(), two.getValue().getRatings());
        boolean leftNode = false;
        boolean rightNode = false;

        try{
            leftNode = compareSongTrees(one.getLeft(),two.getLeft());
            rightNode = compareSongTrees(one.getRight(), two.getRight());
        }catch(NullPointerException e){

        }
        return checkSongs&&checkRatings&&leftNode&&rightNode;
    }

    @Test
    public void testAddSong(){
        Playlist playlist1 = new Playlist(new SongTitleComparator());
        Song song1 = new Song("Smart", "Chae", "1");
        Song song2 = new Song("Easy", "Chae", "2");
        Song song3 = new Song("Popular", "Week", "3");

        playlist1.addSong(song1);
        playlist1.addSong(song2);
        playlist1.addSong(song3);

        Playlist playlist2 = new Playlist(new SongTitleComparator());

        playlist2.addSong(song1);
        playlist2.addSong(song2);
        playlist2.addSong(song3);

        assertTrue(compareSongTrees(playlist1.getSongTree(), playlist2.getSongTree()));

        Song song4 = new Song("Low", "SZA", "4");
        Song song5 = new Song("Baby", "Beiber", "5");
        Song song6 = new Song("Stir Fry", "Mogos", "6");
        Song song7 = new Song("Twenty Two", "Swift", "7");
        Song song8 = new Song("Stiches", "Mendes", "8");
        Song song9 = new Song("2U", "Justin", "9");

        playlist1.addSong(song4);
        playlist1.addSong(song5);
        playlist1.addSong(song6);
        playlist1.addSong(song7);
        playlist1.addSong(song8);
        playlist1.addSong(song9);

        playlist2.addSong(song4);
        playlist2.addSong(song5);
        playlist2.addSong(song6);
        playlist2.addSong(song7);
        playlist2.addSong(song8);
        playlist2.addSong(song9);

        assertTrue(compareSongTrees(playlist1.getSongTree(), playlist2.getSongTree()));
        LinkedListNode<Song> songList1 = playlist1.getSongList();
        assertNotNull(songList1);

    }
    @Test
    public void testMultipleSongs() {
        Playlist playlist1 = new Playlist(new SongTitleComparator());
        Song song1 = new Song("Song1", "artist1", "1");
        Song song2 = new Song("Song2", "artist2", "2");
        Song song3 = new Song("Song3", "artist3", "3");
        playlist1.addSong(song1);
        playlist1.addSong(song2);
        playlist1.addSong(song3);


        assertNotNull(playlist1.getSongList());
        assertEquals(song1, playlist1.getSongList().getValue());

        LinkedListNode<Song> second = playlist1.getSongList().getNext();
        assertNotNull(second);
        assertEquals(song2, second.getValue());

        LinkedListNode<Song> third = second.getNext();
        assertNotNull(third);
        assertEquals(song3, third.getValue());
    }

    @Test
    public void testGetSongLists(){
        Playlist playlist = new Playlist(new SongTitleComparator());

// Add 10 songs to the playlist
        Song track1 = new Song("Track1", "Singer1", "1");
        Song track2 = new Song("Track2", "Singer2", "2");
        Song track3 = new Song("Track3", "Singer3", "3");
        Song track4 = new Song("Track4", "Singer4", "4");
        Song track5 = new Song("Track5", "Singer5", "5");
        Song track6 = new Song("Track6", "Singer6", "6");
        Song track7 = new Song("Track7", "Singer7", "7");
        Song track8 = new Song("Track8", "Singer8", "8");
        Song track9 = new Song("Track9", "Singer9", "9");
        Song track10 = new Song("Track10", "Singer10", "10");

        playlist.addSong(track1);
        playlist.addSong(track2);
        playlist.addSong(track3);
        playlist.addSong(track4);
        playlist.addSong(track5);
        playlist.addSong(track6);
        playlist.addSong(track7);
        playlist.addSong(track8);
        playlist.addSong(track9);
        playlist.addSong(track10);

        LinkedListNode<Song> songList = playlist.getSongList();
        assertNotNull(songList);

        assertEquals("Track1", songList.getValue().getTitle());
        songList = songList.getNext();

        assertNotNull(songList);
        assertEquals("Track10", songList.getValue().getTitle());
        songList = songList.getNext();

        assertNotNull(songList);
        assertEquals("Track2", songList.getValue().getTitle());
        songList = songList.getNext();

        assertNotNull(songList);
        assertEquals("Track3", songList.getValue().getTitle());
        songList = songList.getNext();

        assertNotNull(songList);
        assertEquals("Track4", songList.getValue().getTitle());
        songList = songList.getNext();

        assertNotNull(songList);
        assertEquals("Track5", songList.getValue().getTitle());
        songList = songList.getNext();

        assertNotNull(songList);
        assertEquals("Track6", songList.getValue().getTitle());
        songList = songList.getNext();

        assertNotNull(songList);
        assertEquals("Track7", songList.getValue().getTitle());
        songList = songList.getNext();

        assertNotNull(songList);
        assertEquals("Track8", songList.getValue().getTitle());
        songList = songList.getNext();

        assertNotNull(songList);
        assertEquals("Track9", songList.getValue().getTitle());
        songList = songList.getNext();
        assertNull(songList);

    }

}
