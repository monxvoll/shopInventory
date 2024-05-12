package com.uptc.edu.app.store.confi;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
	 private static  Config infoFile;

	 private  Properties propiedades;

	 private String ruta;
	 
	 private String nombreArchivoXML;
	 private String nombreArchivoTXT;
	 private String stock;
	 
	

	public  static Config getInstance() {
	    	if(infoFile==null) {
	    		infoFile = new Config();
	    	}
	    	return infoFile;
	    }

	
	public String getNombreArchivoXML() {
			return nombreArchivoXML;
		}

	public void setNombreArchivoXML(String nombreArchivo) {
			this.nombreArchivoXML = nombreArchivo;
		}
	
	
	public String getNombreArchivoTXT() {
		return nombreArchivoTXT;
	}


	public void setNombreArchivoTXT(String nombreArchivoTXT) {
		this.nombreArchivoTXT = nombreArchivoTXT;
	}


	public static Config getInfoFile() {
		return infoFile;
	}

	public static void setInfoFile(Config infoFile) {
		Config.infoFile = infoFile;
	}

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
	
	
	
	public String getStock() {
		return stock;
	}


	public void setStock(String stock) {
		this.stock = stock;
	}


	//El constructor privado evita que se creen instancias con new
    private Config() {
        this.propiedades = new Properties();
        try (FileInputStream entrada = new FileInputStream("resources/conf/app.properties")) {
            propiedades.load(entrada);
            this.ruta = propiedades.getProperty("app.file.path.txt");
            this.nombreArchivoXML = propiedades.getProperty("app.file.name.xml");
            this.nombreArchivoTXT = propiedades.getProperty("app.file.name.txt");
            this.stock= propiedades.getProperty("stock");
        } catch (IOException ex) {
            System.err.println("Error al cargar el archivo properties de configuración: "+ ex.getMessage());
        }
    }
}
