package com.uptc.edu.app.store.persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.uptc.edu.app.store.conf.Configuration;
import com.uptc.edu.app.store.constants.CommonConstants;

public class FilePlain {

		protected Configuration confValue;
		
		public FilePlain() {
			confValue = Configuration.getInstance();
		}
		
		/**
		 * <b>Descripción: </b> Método encargado de leer el archivo agregando el carácter de salto de línea
		 * @author jcharris
		*/
		private String readFile(String rutaNombre) {
			StringBuilder contenido = new StringBuilder();
	        try {
	            FileReader fr = new FileReader(rutaNombre);
	            BufferedReader br = new BufferedReader(fr);
	            String linea;
	            while ((linea = br.readLine()) != null) {
	                contenido.append(linea).append(CommonConstants.LINE_BREAK);
	            }
	            br.close();
	            fr.close();
	        } catch (IOException e) {
	          System.out.println("Se presentó un error al leer el archivo específicado");
	        }
	        return contenido.toString();
		}
		
		/**
		 * <b>Descripción: </b> Método encargado de escribir en el archivo sobreescribiendo el contennido
		 * @author jcharris
		*/
		public void writeFile(String rutaNombre, String content) {
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaNombre))) {
				writer.write(content);
	        } catch (IOException e) {
	        	e.printStackTrace();
	        }
		}
		
		/**
		 * <b>Descripción:</b> Método encargado de la lectura y organización de las líneas encontradas en el fichero<br>
		 * @author jcharris
		 */
		protected List<String> reader(String rutaNombre){
			List<String> output = new ArrayList<>();
			StringTokenizer tokens = new StringTokenizer(this.readFile(rutaNombre), CommonConstants.SEMI_COLON);
			while (tokens.hasMoreElements()) { 
			}
			return output;
		}
		
		/**
		 * <b>Descripción:</b> Método encargado de la escritura en el fichero<br>
		 * @author jcharris
		 */
		protected void writer(String rutaNombre, List<String> file){
			StringBuilder strContent = new StringBuilder();
			file.forEach(record -> strContent.append(record).append(CommonConstants.LINE_BREAK));
			writeFile(rutaNombre, strContent.toString());
		}
		
		
		
		
	}


