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
	 * @param vPuntuaciones Umbral maximo
	 * @param n Numero de platos
	 * @return Valor del sub-problema
	 */
	public int recursiva(int[] v, int[] w, int n, int W){
		
		if (n == 0 && W >= 0){
			return 0;
		}
		if (W < 0){
			return Integer.MIN_VALUE;
		}
		
		int maxA = recursiva(v, w, n - 1, W);
		int maxB = recursiva(v, w, n - 1, W - w[n-1]) + v[n-1];

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
		/*for(int i = 0; i < V.size(); i++){
			System.out.println(V.get(i));
		}*/
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
	public void algoritmo_bottomup(int [][] V, int [] v, int []w, int n, int W){ 
		System.out.println(n + ", " + W);
		for (int j = 0; j < W; j++){
			V[0][j] = 0;
		}
		for(int i = 1; i <= n; i++){
			for(int j = 0; j < W; j++){
				if(w[i-1] <= j){
					V[i][j] = Integer.max(V[i-1][j], V[i-1][j+1 - w[i-1]] + v[i-1]);
				}
				else{
					V[i][j] = V[i-1][j];
				}
			}
		}
		/*for(int i = 0; i < V.length; i++){
			for(int j = 0; j < V[i].length; j++){
				System.out.print(V[i][j] + " ");
			}
			System.out.println("");
		}*/
		System.out.println("Solucion: " + V[n-1][W-1]);
		int j = W-1;
		for (int i = n; i > 1; i--){
			if(w[i-1] <= j && V[i-1][j-w[i-1]] + v[i-1] == V[i][j]) {
				System.out.println("El objeto " + (i) + " esta en la mochila");
				j = j - w[i-1];
			}
		}	
	}
	int algoritmo_topdown(int [][] V, int [] v, int [] w, int n, int W){ 
	    if (n == 0 && W >= 0)
	        return 0;
	    
	    if(W < 0)
	        return Integer.MIN_VALUE;
	    
	    if( V[n][W-1] != -1)
	        return V[n][W-1];


	    int v1 = algoritmo_topdown(V, v, w, n -1, W);
	    int v2 = algoritmo_topdown(V, v, w, n -1, W - w[n]) + v[n];
	    V[n][W] = Integer.max(v1, v2);
	    return V[n][W];
	}
}
