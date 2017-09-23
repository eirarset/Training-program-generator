
public class Oekt {
	int dag;
	int sett;
	int reps;
	double vekt;
	String navn;
	
	Oekt(int d, int s, int r, double v, String n){
		dag = d;
		sett = s;
		reps = r;
		vekt = rundAv(v);
		navn = n;
	}
	
	public String toString(){
		return navn + ": " +Integer.toString(sett) + " x " + Integer.toString(reps) + " @ " + Double.toString(vekt) + "kg     "; 
	}
	
	private double rundAv(double n){
		return Math.round(n/2.5) * 2.5;
	}
}
