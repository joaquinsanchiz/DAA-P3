package menuSaludable;

import java.util.ArrayList;

/**
 * Clase que implementa un conjunto de platos, con su valor nutricional total y su puntuacion total
 * @author joaquinsanchiz
 *
 */
public class Menu {
	
	private ArrayList<Plato> platos_ = new ArrayList<Plato>();
	private short nutritionalValue_;
	private int punctuation_;
	
	public ArrayList<Plato> getPlatos_() {
		return platos_;
	}
	public Plato getPlato(int index){
		return this.getPlatos_().get(index);
	}
	public void setPlatos_(Plato plato) {
		if(!this.isInMenu(plato)){
			this.platos_.add(plato);
		}
	}
	public short getNutritionalValue_() {
		return nutritionalValue_;
	}
	public void setNutritionalValue_(short nutritionalValue_) {
		this.nutritionalValue_ = nutritionalValue_;
	}
	public int getPunctuation_() {
		return punctuation_;
	}
	public void setPunctuation_(int punctuation_) {
		this.punctuation_ = punctuation_;
	}
	/**
	 * Busca un plato segun puntuacion
	 * @param punctuation
	 * @return Plato encontrado
	 */
	public Plato findPlato(int punctuation){
		for(int i = 0; i < this.getPlatos_().size(); i++){
			if(this.getPlato(i).getNutritionalValue() == punctuation){
				return this.getPlato(i);
			}
		}
		return new Plato();
	}
	/**
	 * Comprueba si el plato está en el menu
	 * @param plato
	 * @return True si esta y si no falso
	 */
	boolean isInMenu(Plato plato){
		if(!plato.getName_().equals("null")){
			for(int i = 0; i < this.getPlatos_().size(); i++){
				if(this.getPlato(i).getName_().equals(plato.getName_())){
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * Elimina un plato del menu
	 * @param plato
	 */
	public void deletePlato(Plato plato){
		this.getPlatos_().remove(plato);
	}
	@Override
	public String toString() {
		return "Menu [platos_=" + platos_ + ", nutritionalValue_=" + nutritionalValue_ + ", punctuation_="
				+ punctuation_ + "]";
	}
	
	
	
	
}
