import java.util.ArrayList;

public class Program {
	
	double minsteInkrement = 2.5;
	int nUker;
	int numOevelser;
	ArrayList<Oevelse> oevelser;
	Uke[] uker;
	
	
	public Program(int u){
		nUker = u;
		oevelser = new ArrayList<>();
		uker = new Uke[nUker];
	}
	
	void leggTilOevelse(String navn, double vekt){
		oevelser.add(new Oevelse(navn, vekt));
	}
	
	void leggTilUker(){
		for(int i = 0; i < uker.length; i++){
			uker[i] = new Uke(); //TODO: Sjekke om nødvendig
		}
		
		for(Oevelse ov: oevelser){
			for(Oekt oekt : ov.prog.oekter){
				uker[oekt.dag/7].leggTilOekt(oekt);
			}
		}
	}
	
	public String toString(){
		return "toString i Program.java er ikke implementert enda";
	}

}
