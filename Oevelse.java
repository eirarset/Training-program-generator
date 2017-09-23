
public class Oevelse {
	String navn;
	double startVekt;
	Progresjon prog;
	
	Oevelse(String n, double s){
		navn = n;
		startVekt = s;
		prog = new Progresjon(startVekt, 6, navn);; //TODO: Endre uker til et ikke "magisk" tall
	}
	
}
