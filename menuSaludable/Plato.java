package menuSaludable;

/**
 * Clase que referencia a un plato de comida, con su nombre, su puntuacion y su valor nutricional.
 * @author joaquinsanchiz
 *
 */
public class Plato {
	
	private String name_;
	private short punctuation_;
	private short nutritionalValue_;
	
	public String getName_() {
		return name_;
	}
	
	public void setName_(String name_) {
		this.name_ = name_;
	}
	
	public short getPunctuation_() {
		return punctuation_;
	}
	
	public void setPunctuation_(short punctuation_) {
		this.punctuation_ = punctuation_;
	}
	
	public void setNutritionalValue_(short nutritionalValue){
		this.nutritionalValue_ = nutritionalValue;
	}
	
	public short getNutritionalValue(){
		return this.nutritionalValue_;
	}
	
	Plato(String name, short nutritionalValue, short punctuation){
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
