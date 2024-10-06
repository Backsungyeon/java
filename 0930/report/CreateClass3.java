package java2024;

class Song{
	private String title;	
	private String artist;	
	private int year;		
	private String country;	

	public Song(String title, String artist, int year, String country) {
		this.title = title;
		this.artist = artist;
		this.year = year;
		this.country = country;
	}
	public void show() {	
		System.out.println(year + "년 " + country + "의 " + artist + "가 부른 " + title);
	}
}

public class CreateClass3 {
   public static void main(String[] args) {
	   Song song = new Song("가로수 그늘 아래 서면", "이문세", 1988, "한국" );
	   song.show();
   }
}
