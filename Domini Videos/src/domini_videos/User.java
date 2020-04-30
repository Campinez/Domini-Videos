package domini_videos;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public   class User{
	
	//Declaración de variables
	String name;
	 String surname;
	 String password;
	  ArrayList <Video> videoList= new ArrayList <Video>();
	 int year;
	 int month;
	 int day;
	 Date dateRegistration ;
	
	// Constructor de objetos User
	public User (String name, String surname, String password, int year, int month, int day) {

		this.name=name;
		this.surname=surname;
		this.password=password;
		GregorianCalendar calendario=new GregorianCalendar(year, month-1, day);
		this.dateRegistration = calendario.getTime();
	}
	//Constructor datos objetos user para objeto video
	public User(String name, String surname, String password) {
		this.name=name;
		this.surname=surname;
		this.password=password;
	}
	
}

