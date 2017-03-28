package menuSaludable;

public class Main {
	public static void main (String args[]){
		
		ProgramacionDinamica p1 = new ProgramacionDinamica();
		
		Menu conjuntoPlatos = PlatosReader.readPlatosFromFile(args[0]); //Conjunto total de platos, siendo W la punctuation del menú.
		
		int [][] matriz = new int[conjuntoPlatos.getPlatos_().size()+1][conjuntoPlatos.getPunctuation_()];
		int [] vValores = new int[conjuntoPlatos.getPlatos_().size()];
		int [] vPuntuaciones = new int[conjuntoPlatos.getPlatos_().size()];
		
		for (int i = 0; i < vValores.length; i++){
			vValores[i] = conjuntoPlatos.getPlato(i).getNutritionalValue();
		}
		for(int i = 0; i < vPuntuaciones.length; i++){
			vPuntuaciones[i] = conjuntoPlatos.getPlato(i).getPunctuation_();
		}
		//p1.BottomUp(conjuntoPlatos, 0, conjuntoPlatos.getPlatos_().size(), conjuntoPlatos.getPunctuation_());
		p1.algoritmo_bottomup(matriz, vValores, vPuntuaciones, vValores.length, conjuntoPlatos.getPunctuation_());
		int solucion = p1.recursiva(vValores, vPuntuaciones, vValores.length, conjuntoPlatos.getPunctuation_());
		int solucion2 = p1.algoritmo_topdown(matriz, vValores, vPuntuaciones, vValores.length, conjuntoPlatos.getPunctuation_());
		
		
		System.out.println("Solucion Recursivo: " + solucion);
		System.out.println("Solucion TopDown: " + solucion2);

		//p1.BottomUp(conjuntoPlatos, 0, conjuntoPlatos.getPlatos_().size(), conjuntoPlatos.getPunctuation_());
		
	}
}
