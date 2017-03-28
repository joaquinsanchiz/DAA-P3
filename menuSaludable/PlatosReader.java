package menuSaludable;

import java.util.ArrayList;
import java.io.*;

/**
 * Clase que implementa un objeto para la lectura de un menu desde fichero
 * @author joaquinsanchiz
 *
 */
public class PlatosReader {
	
	@SuppressWarnings("finally")
	/**
	 * Metodo que convierte el archivo de entrada en un menu
	 * @param file Archivo de entrada
	 * @return Menu de salida
	 */
	public static Menu readPlatosFromFile(String file){
		
		File archivo = null;
	    FileReader fr = null;
	    BufferedReader br = null;
	    Menu conjuntoPlatos = new Menu();

	    try {
	       archivo = new File (file);
           fr = new FileReader (archivo);
	       br = new BufferedReader(fr);

	       // Lectura del fichero
           String linea;
           br.readLine();
           conjuntoPlatos.setPunctuation_(Short.parseShort(br.readLine()));
	       while((linea=br.readLine())!=null){
	    	   String [] token = linea.split("\\s");
	    	   Plato temp = new Plato(token[0], Short.parseShort(token[1]), Short.parseShort(token[2]));
	    	   conjuntoPlatos.setPlatos_(temp);
	       }
	           
	    }
	      catch(Exception e){
	         e.printStackTrace();
	      }finally{
	         try{                    
	            if( null != fr ){   
	               fr.close();     
	            }                  
	         }catch (final Exception e2){ 
	            e2.printStackTrace();
	         }
		       return conjuntoPlatos;
	      }
	}

}
