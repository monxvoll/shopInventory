package com.uptc.edu.app.store.persistence;

import java.util.List;


import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import com.uptc.edu.app.store.enums.EtypeFile;
import com.uptc.edu.app.store.interfaces.Actions;
import com.uptc.edu.app.store.model.Product;
import com.uptc.edu.app.store.confi.*;
import com.uptc.edu.app.store.constants.CommonConstants;

public class managementPersistenceProduct extends FilePlain implements Actions {
	
	private Product product;
	
	private  Config confValue = Config.getInstance();

	private Map<String, Product> mapCodeProduct;
	
	
	
	public void dumpFile(EtypeFile eTypeFile) {
		
		if(EtypeFile.PLAIN.equals(eTypeFile)) {
			//this.loadFilePlain;
		}
		
		if(EtypeFile.XML.equals(eTypeFile)) {
			this.dumpFileXML();
		}
	}
	
	public void loadProduct (EtypeFile eTypeFile) {
		if(EtypeFile.PLAIN.equals(eTypeFile)) {
			//this.loadFilePlain;
		}
		if(EtypeFile.XML.equals(eTypeFile)) {
			//this.loadFileXML();
		}
	}
	
	
	
	
	public void dumpFileXML() {
		String rutaArchivo = confValue.getRuta().concat(confValue.getNombreArchivoXML());
		StringBuilder lines = new StringBuilder();
		List<Product> products = this.mapCodeProduct.values().stream().collect(Collectors.toList());
		lines.append("<XML version=\"1.0\" encoding=\"UTF-8\"> \n");
		for (Product product : products) {
			lines.append("<product>\n");
			lines.append("<code>"+product.getCode()+"</code>\n");
			lines.append("<name>"+product.getDescription()+"</name>\n");
			lines.append("<price>"+product.getPrice()+"</price>\n");
			lines.append("<amount>"+product.getAmount()+"</amount>\n");
			lines.append("</product>\n");
		}
		lines.append("</XML>");
		this.writeFile(rutaArchivo, lines.toString());
	}
	
	public void loadFilePlain() {
        List<String> contentInLine = this.reader();
        contentInLine.forEach(row -> {
            StringTokenizer tokens = new StringTokenizer(row, CommonConstants.SEMI_COLON);
            while (tokens.hasMoreElements()) {
                String code = tokens.nextToken();
                String description = tokens.nextToken();
                String price = tokens.nextToken();
                String amount = tokens.nextToken();
              
                mapCodeProduct.put(code, new Product(code, description, price, amount));
            }
        });
    }
	
	
	//Setters and Getters
	
	public Map<String, Product> getProducts() {
		return mapCodeProduct;
	}


	public void setProducts(Map<String, Product> mapCodeProduct) {
		this.mapCodeProduct = mapCodeProduct;
	}

	@Override
	public void loadStudent(EtypeFile eTypeFile) {
		// TODO Auto-generated method stub
		
	}

	


	
	
	
	
}
