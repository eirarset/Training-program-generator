
public class Test {

	public static void main(String[] args) {
		Program p = new Program(8);
		
		p.leggTilOevelse("Markløft", 270.0);
		p.leggTilOevelse("Benkpress", 120);
		
		p.leggTilUker();
		
		System.out.println(p.uker[0].dager.get(0).toString());
		
	}

}
