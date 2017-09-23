import java.util.ArrayList;

public class Uke {
	
	ArrayList<Dag> dager;
	
	Uke(){
		dager = new ArrayList<>();
	}
	
	void leggTilOekt(Oekt o){
		for(Dag d: dager){
			if(d.dag == o.dag){
				d.leggTil(o);
				return;
			}
		}
		dager.add(new Dag(o));
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(Dag d: dager){
			sb.append(d.toString());
			sb.append(System.getProperty("line.separator"));
		}
		return sb.toString();
	}

}
