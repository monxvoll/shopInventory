package com.uptc.edu.app.store.persistence;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.uptc.edu.app.store.Configuration;
import com.uptc.edu.app.store.confi.Config;
import com.uptc.edu.app.store.constants.CommonConstants;

public class FilePlain {

	 private   Config confValue = Config.getInstance();

	//Metodo encargado de leer el archivo  que a su vez agrega el salto de linea
	 private String readFile() {

	     StringBuilder contenido = new StringBuilder();
	     try {
	         FileReader fr = new FileReader(confValue.getRuta().concat(confValue.getNombreArchivoTXT()));
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
	 
	 
	 protected void writeFile(String rutaNombre, String string){
		    try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaNombre, true))) {
		        writer.write(string);
		    } catch (IOException e) {
		        System.out.println("Error al escribir en el archivo:" + e.getMessage());
		    }
		}


	    protected List<String> reader(){
	        List<String> output = new ArrayList<>();
	        StringTokenizer tokens = new StringTokenizer(this.readFile(), CommonConstants.LINE_BREAK);
	        while (tokens.hasMoreElements()) {
	            output.add(tokens.nextToken());
	        }
	        return output;
	    }

	    protected void writer(List<String> file) {
	        StringBuilder strContent = new StringBuilder();
	        file.forEach(record -> strContent.append(record).append(CommonConstants.LINE_BREAK));
	        writeFile(strContent.toString(), null);
	    }
	    protected void writer(String rutaNombre, List<String> file){
    		StringBuilder strContent = new StringBuilder();
    		file.forEach(record -> strContent.append(record).append(CommonConstants.LINE_BREAK));
    		writeFile(rutaNombre, strContent.toString());
    	}
	}


