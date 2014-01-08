import java.util.*;
import java.lang.Long;

public class Zipfsong {

	public List<Song> songList;
	private long select;

	private class Song implements Comparable<Song> {

		public long zi;
		public String title;

		private Song(long zi, String title) {
			this.zi = zi;
			this.title = title;
		}

		public int compareTo(Song a) {
			if(zi < a.zi)
				return 1;
			else if (zi == a.zi)
				return 0;
			else
				return -1;
		}
	}

	// Add a song to the linked list
	public void addSong(int position, long plays, String title) {

		long zi = plays*position;
		Song song = new Song(zi, title);

		if(songList.size() == 0)
			songList.add(song);
		else {
			for(int i = 0; i < songList.size(); i++) {
				if(songList.get(i).zi < song.zi) {
					songList.add(i, song);
					break;
				}
				else if(songList.size() < select && i == (songList.size() - 1)) {
					songList.add(song);
					break;
				}
			}
		}
		
		while(songList.size() > select)
			songList.remove(songList.size() - 1);
		
	}

	public void displaySongs() {
		for (int i = 0; i < songList.size(); i++) {
			System.out.println(songList.get(i).title);
		}
	}

	public static void main(String[] args) {

		Kattio in = new Kattio(System.in);

		// Get initial variables
		long n = in.getLong();
		long select = in.getLong();
		
		Zipfsong zipf = new Zipfsong();
		zipf.songList = new ArrayList<Song>();
		zipf.select = select;
		
		for(int i = 1; i <= n; i++) {

			// Get the pair of values
			long plays = in.getLong();
			String title = in.getWord();

			zipf.addSong(i, plays, title); 
		
		}

		zipf.displaySongs();
		
	}
}