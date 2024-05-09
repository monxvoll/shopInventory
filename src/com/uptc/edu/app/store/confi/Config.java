package com.uptc.edu.app.store.confi;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
	 private static  Config infoFile;

	 private  Properties propiedades;

	 private String ruta;
	 
	 private String nombreArchivo;
	 
	

	public  static Config getInstance() {
	    	if(infoFile==null) {
	    		infoFile = new Config();
	    	}
	    	return infoFile;
	    }

	
	public String getNombreArchivoXML() {
			return nombreArchivo;
		}

	public void setNombreArchivo(String nombreArchivo) {
			this.nombreArchivo = nombreArchivo;
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
	//El constructor privado evita que se creen instancias con new
    private Config() {
        this.propiedades = new Properties();
        try (FileInputStream entrada = new FileInputStream("resources/conf/appconf.properties")) {
            propiedades.load(entrada);
            this.ruta = propiedades.getProperty("ruta.archivo.txt");
            this.nombreArchivo = propiedades.getProperty("nombre.archivo.txt");
        } catch (IOException ex) {
            System.err.println("Error al cargar el archivo properties de configuración: "+ ex.getMessage());
        }
    }
}
