package domini_videos;

import java.util.ArrayList;

//Haciendo clase
public class Video {
	  String title;
	  String url;
	  ArrayList <String> tags = new ArrayList <String>();
	
	//Constructor
	public Video(String title, String url) {
		this.title=title;
		this.url=url;
	}
}
/*
//Haciendo subclase 
public class Video extends User {
	public Video(String name,String surname, String password) {
		super (name, surname, password);
		}
	static String title;
	static String url;
	ArrayList <String> tags = new ArrayList <String>();
	
	//Constructor
	public Video(String name, String surname, String password,String title, String url) {
		super(name, surname, password);
		this.title=title;
		this.url=url;
		
	}

}
*/
