import java.util.*;
public class Progresjon {
	
	double startVekt;
	int uker;
	ArrayList<Oekt> oekter;
	String oevelsesNavn;
	
	Progresjon(double start, int u, String n){
		oekter = new ArrayList<>();
		uker = u;
		startVekt = start;
		oevelsesNavn = n;
		double tempVekt = startVekt/100*65;
		int startSett = 3;
		int startReps = 8;
		for(int j = 0; j < uker; j++){
			for(int i = 1; i <= 7; i+= 4, tempVekt += tempVekt/100*2){
				oekter.add(new Oekt(j*7+i, startSett, startReps, tempVekt, oevelsesNavn));
			}
			startReps--;
			if(j > 0 &&j%3 == 0){
				startSett++;;
			}
		}
		
	}
	
	

}
