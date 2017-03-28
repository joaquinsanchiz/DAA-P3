package menuSaludable;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que implementa los problemas de programación dinamica, donde se podrán encontrar los algoritmos.
 * @author joaquinsanchiz
 *
 */
public class ProgramacionDinamica {
	
	private Menu solucion = new Menu();
	
	
	
	public Menu getSolucion() {
		return solucion;
	}
	public void setSolucion(Menu solucion) {
		this.solucion = solucion;
	}
	
	/**
	 * Funcion recursiva para la resolucion del problema
	 * @param conjunto Conjunto de platos
	 * @param wi Parametro de puntuacion
	 * @param W Umbral maximo
	 * @param n Numero de platos
	 * @return Valor del sub-problema
	 */
	public int recursiva(Menu conjunto, int wi, int W, int n){
		
		if (n == 0 && W >= 0){
			return 0;
		}
		if (W < 0){
			return Integer.MIN_VALUE;
		}
		
		int maxA = recursiva(conjunto, conjunto.getPlato(n).getPunctuation_(), W, n - 1);
		int maxB = recursiva(conjunto, conjunto.getPlato(n).getPunctuation_(), W - conjunto.getPlato(n).getPunctuation_(), n - 1) + conjunto.getPlato(n).getNutritionalValue();

		return Integer.max(maxA, maxB);
		
	}
	
	/**
	 * Funcion que implementa el algoritmo bottomUp
	 * @param v Menu de platos
	 * @param wi Puntuacion del plato actual
	 * @param n Numero de platos
	 * @param W Umbral
	 */
	public void BottomUp(Menu v, int wi, int n, int W){
		ArrayList<ArrayList<Integer>> V = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		
		//Inicializando la tabla
		for(int w = 0; w <= W; w++){
			temp.add(0);
		}
		V.add(temp);
		temp = new ArrayList<Integer>();
		temp.add(0);
		
		for(int w = 1; w <= W; w++){
			temp.add(0);
		}
		for(int i = 1; i <= n; i++){
			V.add(temp);
		}
		
		for (int i = 1; i < n; i++){
			for (int w = 0; w <= W; w++){
				if(v.getPlato(i-1).getPunctuation_() <= w){ //si w[i] <= w
					//V[i, w] = max(V[i-1, w], V[i-1, w - w[i]] + v[i]
					V.get(i).set(w, Integer.max(V.get(i-1).get(w), V.get(i-1).get(w - v.getPlato(i-1).getPunctuation_()) + v.getPlato(i-1).getNutritionalValue() ));
				}
				else V.get(i).set(w, V.get(i-1).get(w)); //V[i, j] = V[i - 1, j];
			}
		}
		for(int i = 0; i < V.size(); i++){
			System.out.println(V.get(i));
		}
		System.out.println("Solucion BottomUp: " + V.get(n).get(W));
		/*int j = W;
		for (int i = n-1; i >0; i--){
			if(v.getPlato(i).getPunctuation_() <= j && (V.get(i-1).get(j - v.getPlato(i).getPunctuation_()) + v.getPlato(i).getNutritionalValue() == V.get(i).get(j))){
				System.out.println("El plato " + v.getPlato(i).getName_() + " está en el menu");
			}
			j = j - v.getPlato(i).getPunctuation_();
		}*/
		
	}
	/**
	 * Algoritmo bottomUp
	 * @param matriz Matriz de valores
	 * @param vValores Valor nutricional de los platos
	 * @param vPuntuaciones Puntuaciones de los platos
	 * @param numero_platos
	 * @param umbral
	 */
	public void algoritmo_bottomup(int [][] matriz, int [] vValores, int []vPuntuaciones, int numero_platos, int umbral){ 
		System.out.println(numero_platos + ", " + umbral);
		for (int j = 0; j < umbral; j++){
			matriz[0][j] = 0;
		}
		for(int i = 1; i <= numero_platos; i++){
			for(int j = 0; j < umbral; j++){
				if(vPuntuaciones[i-1] <= j){
					matriz[i][j] = Integer.max(matriz[i-1][j], matriz[i-1][j - vPuntuaciones[i-1]] + vValores[i-1]);
				}
				else{
					matriz[i][j] = matriz[i-1][j];
				}
			}
		}
		for(int i = 0; i < matriz.length; i++){
			for(int j = 0; j < matriz[i].length; j++){
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println("");
		}
		int j = umbral-1;
		for (int i = matriz.length-2; i > 1; i--){
			if(vPuntuaciones[i] <= j && matriz[i-1][j-vPuntuaciones[i]] + vValores[i] == matriz[i][j]) {
				System.out.println("El objeto" + i + " esta en la mochila");
				j = j - vPuntuaciones[i];
			}
		}
		
	}
	public static void main (String args[]){
		ProgramacionDinamica p1 = new ProgramacionDinamica();
		Menu conjuntoPlatos = PlatosReader.readPlatosFromFile(args[0]); //Conjunto total de platos, siendo W la punctuation del menú.
		//int solucion = p1.recursiva(conjuntoPlatos, 0, conjuntoPlatos.getPunctuation_(), conjuntoPlatos.getPlatos_().size()-1);
		int [][] matriz = new int[conjuntoPlatos.getPlatos_().size()+1][conjuntoPlatos.getPunctuation_()];
		int [] vValores = new int[conjuntoPlatos.getPlatos_().size()];
		int [] vPuntuaciones = new int[conjuntoPlatos.getPlatos_().size()];
		for (int i = 0; i < vValores.length; i++){
			vValores[i] = conjuntoPlatos.getPlato(i).getNutritionalValue();
		}
		for(int i = 0; i < vPuntuaciones.length; i++){
			vPuntuaciones[i] = conjuntoPlatos.getPlato(i).getPunctuation_();
		}
		p1.algoritmo_bottomup(matriz, vValores, vPuntuaciones, vValores.length, conjuntoPlatos.getPunctuation_());
		
		
		
		//System.out.println("Solucion Recursivo: " + solucion);
		//p1.BottomUp(conjuntoPlatos, 0, conjuntoPlatos.getPlatos_().size(), conjuntoPlatos.getPunctuation_());
		
	}
}
