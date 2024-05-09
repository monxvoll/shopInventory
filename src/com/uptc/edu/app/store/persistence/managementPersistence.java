package com.uptc.edu.app.store.persistence;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.uptc.edu.app.store.enums.EtypeFile;
import com.uptc.edu.app.store.model.Product;

public class managementPersistence {
	private Map<String, Product> mapCodeProduct;
	
	
	public void dumpFile(EtypeFile eTypeFile) {
		if(EtypeFile.PLAIN.equals(eTypeFile)) {
			this.dumpFilePlain();
		}
		if(EtypeFile.XML.equals(eTypeFile)) {
			this.dumpFileXML();
		}
	}
	/*public void loadStudent(EtypeFile eTypeFile) {
		if(EtypeFile.PLAIN.equals(eTypeFile)) {
			this.loadFilePlain();
		}
		if(EtypeFile.XML.equals(eTypeFile)) {
			this.loadFileXML();
		}
	}*/
	public void dumpFileXML() {
		String rutaArchivo = confValue.getRuta().concat(confValue.getNombreArchivoXML());
		StringBuilder lines = new StringBuilder();
		List<Product> products = this.mapCodeProduct.values().stream().collect(Collectors.toList());
		lines.append("<XML version=\"1.0\" encoding=\"UTF-8\"> \n");
		for (Product product : products) {
			lines.append("<student>\n");
			lines.append("<code>"+product.getCode()+"</code>\n");
			lines.append("<name>"+product.getDescription()+"</name>\n");
			lines.append("<price>"+product.getPrice()+"</price>\n");
			lines.append("<amount>"+product.getAmount()+"</amount>\n");
			lines.append("</student>\n");
		}
		lines.append("</XML>");
		this.writeFile(rutaArchivo, lines.toString());
	}
	
}
