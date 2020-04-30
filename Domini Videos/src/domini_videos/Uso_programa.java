package domini_videos;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Uso_programa {
	static ArrayList <User> userList = new ArrayList <User>();
	static int arrayPosition;

	
	public static void main(String[] args )throws InputMismatchException {
//Inicio el programa con el menú de opciones
		entry();
	}


	private static void entry() throws InputMismatchException {
		Scanner entradaEntry = new Scanner (System.in);
//Users de prueba
		userList.add(new User("Primero", "Primero", "1", 2001,01,01));
		userList.add(new User("Segundo", "Segundo", "2", 2002,02,02));
		userList.add(new User("F","C","1",2020,04,29));
//Empieza la party		
		try {
		System.out.println("Choose an option: 1-New User 2-New Video 3-Watch Videos 4-Watch my Videos");
		int choose=entradaEntry.nextInt();
		switch (choose) {
		case(1):
			addUser();
		case(2):
			checkUser();
			addVideo(arrayPosition);
		case (3):
			watchVideos();
		case (4):
			checkUser();
			watchMyVideos(arrayPosition);
		default:
			System.out.println("Try a correct option, please.");
		}
		}catch(InputMismatchException e) {
			System.out.println("Try a correct option, please.");
		}
		entry();
}



//Ver todos los videos de un usuario
	private static void watchMyVideos(int arrayPosition) {
		User e = userList.get(arrayPosition);
		Iterator <Video> xxx = e.videoList.iterator();
		while (xxx.hasNext()) {
			Video w=xxx.next();
		System.out.println(w.title+" "+e.videoList.indexOf(w));
		}
		for (int j=0;j<e.videoList.size();j++) {
			Video b = e.videoList.get(j);
			System.out.println("You are watching video "+b.title+" tag:"+b.tags+ " url "+b.url);
		}
	entry();
}


//Ver los videos
	private static  void watchVideos() throws InputMismatchException {
	
		for (int i=0;i<userList.size();i++) {
			User e = userList.get(i);
			for (int j=0;j<e.videoList.size();j++) {
				Video b = e.videoList.get(j);
				System.out.println("You are watching video "+b.title+" url "+b.url);
					for(int t=0;t<b.tags.size();t++) {
						String c=b.tags.get(t);
						System.out.println("The coments of this video:"+c);
					}
			try{
			System.out.println("Do you want to insert a TAG? 1-Yes 2-No");
			Scanner entrada = new Scanner (System.in);
			int tagOption=entrada.nextInt();
			if (tagOption==1) {
				System.out.println("Please write your comment.");
				String comment=entrada.next();
				b.tags.add(comment);
			}else{System.out.println("Push return to continue");
				String pause=entrada.nextLine();};
			}catch(InputMismatchException e1) {
				System.out.println("Wrong selection");
			}
		}
	}
	entry();
}


//Funcion check user
	private static  int checkUser() {
		Scanner entrada2 = new Scanner (System.in);
		System.out.println("Please, enter your User name:");
		String name1= entrada2.nextLine();
		System.out.println("Please, enter your User surname:");
		String surname1= entrada2.nextLine();
		System.out.println("Please, enter your User password:");
		String password1= entrada2.nextLine();
		for (int i=0;i<userList.size();i++) {
		User e = userList.get(i);
		if (e.name.contentEquals(name1)) {
			System.out.println("User name OK.");
			if(e.surname.contentEquals(surname1)) {
				System.out.println("User surname OK.");
				if (e.password.contentEquals(password1)) {
					arrayPosition= i;
					return arrayPosition;
				}
			}else {System.out.println("User surname not found.");
			entry();
			}
		}
		}
	 System.out.println("User not found.");
		entry();
		return 0;
		
	}


//Funcion crear video
	private static  void addVideo(int i) {
		Scanner entrada3 = new Scanner (System.in);
		System.out.println("Please, enter the video's title:");
		String title1= entrada3.nextLine();
		System.out.println("Please, enter the video's URL:");
		String url1= entrada3.nextLine();
		User e=userList.get(i);
		Video video1= new Video( title1, url1);
		e.videoList.add(e.videoList.size(), video1);
		entry();
	}

//Funcion añadir user
	private static void addUser() {
		userList.add(newUser());
		entry();
	}

//Funcion crear user
	public  static User newUser() { 
		Scanner entrada = new Scanner (System.in);
		
		//Entrada de datos y comprobación de la contraseña
		System.out.println("Enter User name:");
		String name= entrada.nextLine();
		System.out.println("Enter User surname:");
		String surname= entrada.nextLine();
		String repassword, password;
		do {	System.out.println("Enter User password:");
			password= entrada.nextLine();
			System.out.println("Repeat User password please:");
			repassword= entrada.nextLine();
		}while(!password.equals(repassword));
		System.out.println("Enter actual year:");
		int year=entrada.nextInt();
		System.out.println("Enter actual month:");
		int month=entrada.nextInt();
		System.out.println("Enter actual day:");
		int day=entrada.nextInt();
		
		User user1= new User(name,surname, password, year,month, day);
		return user1;
	}
}




	



