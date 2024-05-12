package com.uptc.edu.app.store.persistence;

import java.io.File;

import java.util.ArrayList;
import java.util.List;


import java.util.Map;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.uptc.edu.app.store.enums.EtypeFile;
import com.uptc.edu.app.store.interfaces.Actions;
import com.uptc.edu.app.store.model.Product;
import com.uptc.edu.app.store.model.Sale;
import com.uptc.edu.app.store.confi.*;
import com.uptc.edu.app.store.constants.CommonConstants;

public class managementPersistenceProduct extends FilePlain implements Actions {
	
	 private StringBuilder contentSales = new StringBuilder();
	
	private static final String NAME_TAG_PRODUCT= "product";

	private List<String> records = new ArrayList<>();
	
	private  Config confValue = Config.getInstance();

	private Map<String, Product> mapCodeProduct;
	
	private List<Sale> arrayListSales;
	
	
	
	public void dumpFile(EtypeFile eTypeFile) {
		
		if(EtypeFile.PLAIN.equals(eTypeFile)) {
			this.dumpFilePlain();
		}
		
		if(EtypeFile.XML.equals(eTypeFile)) {
			this.dumpFileXML();
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
	
	/*public void loadFilePlain() {
        List<String> contentInLine = this.reader();
        contentInLine.forEach(row -> {
            StringTokenizer tokens = new StringTokenizer(row, CommonConstants.SEMI_COLON);
            while (tokens.hasMoreElements()) {
                String code = tokens.nextToken();
                String description = tokens.nextToken();
                String price = tokens.nextToken();
                //String amount = tokens.nextToken();
                
                
              
                arrayListSales.add(new Sale(code,price,LocalDate.now(), LocalTime.now()));
            }
        });
    }*/
	
	
	//Setters and Getters
	
	public Map<String, Product> getProducts() {
		return mapCodeProduct;
	}


	public void setProducts(Map<String, Product> mapCodeProduct) {
		this.mapCodeProduct = mapCodeProduct;
	}
	public void setSales(List<Sale> arraylistSales) {
		this.arrayListSales = arraylistSales;
	}
	@Override
	public void loadStudent(EtypeFile eTypeFile) {
		// TODO Auto-generated method stub
		
	}

	
	private void dumpFilePlain() {
		String rutaArchivo = confValue.getRuta().concat(confValue.getNombreArchivoTXT());
		
		 for(Sale sale : arrayListSales){
			
			 contentSales.append(sale.getProductCode()).append(CommonConstants.SEMI_COLON);
			 contentSales.append(sale.getTotal()).append(CommonConstants.SEMI_COLON);
			 contentSales.append(sale.getFechaActual()).append(CommonConstants.SEMI_COLON);
			 contentSales.append(sale.getHora()).append(CommonConstants.SEMI_COLON);
			 records.add(contentSales.toString());
		 }
		 this.writer(rutaArchivo, records);
	}

	public void loadFileXML() {
		try {
			File file = new File(confValue.getRuta().concat(confValue.getNombreArchivoXML()));
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(file);
			NodeList list = document.getElementsByTagName(NAME_TAG_PRODUCT);
			for (int i = 0; i < list.getLength(); i++) {
				String code = document.getElementsByTagName("code").item(i).getTextContent();
				String description = document.getElementsByTagName("name").item(i).getTextContent();
				String price = document.getElementsByTagName("nacionality").item(i).getTextContent();
				String amount = document.getElementsByTagName("codeTypeID").item(i).getTextContent();
				mapCodeProduct.put(code, new Product(code, description,price,amount));
			}
		}catch(Exception e) {
			System.out.println("Se presentó un error en el cargue del archivo XML");
		}
		
	}
	
	
	
}
