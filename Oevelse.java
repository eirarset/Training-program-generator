
public class Oevelse {
	String navn;
	double startVekt;
	Progresjon progresjon;
	
	Oevelse(String n, double s, int uker){
		navn = n;
		startVekt = s;
		progresjon = new Progresjon(startVekt, uker, navn);; //TODO: Endre uker til et ikke "magisk" tall
	}
	
}
