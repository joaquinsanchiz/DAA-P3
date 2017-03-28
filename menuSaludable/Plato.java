package menuSaludable;

/**
 * Clase que referencia a un plato de comida, con su nombre, su puntuacion y su valor nutricional.
 * @author joaquinsanchiz
 *
 */
public class Plato {
	
	private String name_;
	private int punctuation_;
	private int nutritionalValue_;
	
	public String getName_() {
		return name_;
	}
	
	public void setName_(String name_) {
		this.name_ = name_;
	}
	
	public int getPunctuation_() {
		return punctuation_;
	}
	
	public void setPunctuation_(int punctuation_) {
		this.punctuation_ = punctuation_;
	}
	
	public void setNutritionalValue_(int nutritionalValue){
		this.nutritionalValue_ = nutritionalValue;
	}
	
	public int getNutritionalValue(){
		return this.nutritionalValue_;
	}
	
	Plato(String name, int nutritionalValue, int punctuation){
		this.setName_(name);
		this.setNutritionalValue_(nutritionalValue);
		this.setPunctuation_(punctuation);
	}
	Plato(){
		this.setName_("null");
	}

	@Override
	public String toString() {
		return "Plato [name_=" + name_ + ", punctuation_=" + punctuation_ + ", nutritionalValue_=" + nutritionalValue_
				+ "]";
	}
	
}
