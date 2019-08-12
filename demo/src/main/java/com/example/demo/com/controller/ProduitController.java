package com.example.demo.com.controller;


import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.com.dao.ProduitRepository;
import com.example.demo.com.entities.Produit;



@RestController
@CrossOrigin("*")
public class ProduitController {
	
	@Autowired
	private ProduitRepository produitRepository;
	
	
    @RequestMapping("/list")
	public List<Produit> getProduits(){
		return produitRepository.findAll();
		
	}
    
    @RequestMapping(value="/produits/delete/{id}", method=RequestMethod.DELETE)
   	public void delete(@PathVariable Long id){
		 produitRepository.delete(id);
   		
   	}
    
    @RequestMapping(value="/photoProduit/{id}", produces=MediaType.IMAGE_PNG_VALUE, method=RequestMethod.GET) 
    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{
     Produit p = produitRepository.findOne(id);
     
       return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/Documents/angular/images/"+p.getPhotoName()+".PNG"));
       // en angular on utilise <img src="{this.service.hot+'/photoProduct/'+p.id}"/>
    }
    
    
    

}
