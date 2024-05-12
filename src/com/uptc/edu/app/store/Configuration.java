package com.uptc.edu.app.store;

import java.io.FileInputStream;


import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class Configuration {
private static Configuration infoFile;
	
	/* Atributo que determina la instancia que contiene la información del archivo properties */
	private Properties propiedades;
	
	/* Atributo que determina la ruta donde se cuentra ubicado el archivo W*/
	private String ruta;
	
	/* Atributo que determina el nombre del archivo TXT */
	private String nombreArchivoTXT;
	
	/* Atributo que determina el nombre del archivo XML */
	private String nombreArchivoXML;
	
	/* 2. Se usa el modificador de acceso privado para evitar que se creen instancias con new */
	/** Constructor de la clase */
	private Configuration() {
		this.propiedades= new Properties();
		try (FileInputStream entrada = new FileInputStream("resources/conf/app.properties")) {
            propiedades.load(entrada);
            this.ruta = propiedades.getProperty("ruta.archivo.txt");
            this.nombreArchivoTXT = propiedades.getProperty("sale.txt");
            this.nombreArchivoXML = propiedades.getProperty("contact.xml");;
        } catch (IOException ex) {
            System.err.println("Error al cargar el archivo properties de configuración: " + ex.getMessage());
        }
	}
	
	/* 3. Se crea el método que retorna la instancia creada */
	
	

	public Properties getPropiedades() {
		return propiedades;
	}

	public void setPropiedades(Properties propiedades) {
		this.propiedades = propiedades;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public String getNombreArchivoTXT() {
		return nombreArchivoTXT;
	}

	public void setNombreArchivoTXT(String nombreArchivoTXT) {
		this.nombreArchivoTXT = nombreArchivoTXT;
	}

	public String getNombreArchivoXML() {
		return nombreArchivoXML;
	}

	public void setNombreArchivoXML(String nombreArchivoXML) {
		this.nombreArchivoXML = nombreArchivoXML;
	}

	public static Configuration getInstance() {
		
		if(Objects.isNull(infoFile)) {
			infoFile = new Configuration();
		}
		return infoFile;
	}



	
}