import java.util.ArrayList;

public class Dag {
	ArrayList<Oekt> oekter;
	int dag;
	
	Dag(Oekt o){
		oekter = new ArrayList<>();
		dag = o.dag;
		oekter.add(o);
	}
	
	void leggTil(Oekt o){
		oekter.add(o);
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		
		sb.append(dag);
		sb.append(System.getProperty("line.separator"));
		for(Oekt o: oekter){
			sb.append(o.toString());
			sb.append(System.getProperty("line.separator"));
		}
		return sb.toString();
	}

}
