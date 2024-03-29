package sn.esmt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.esmt.clients.ClientPromotion;
import sn.esmt.entities.Produit;
import sn.esmt.entities.Promotion;
import sn.esmt.repository.ProduitRepository;

@RestController
@RequestMapping("/produitapi")
public class ProduitController {
	
	@Autowired
	private ProduitRepository repo;
	
	@Autowired
	private ClientPromotion client;
	
	@GetMapping("/produits")
	@Transactional(readOnly = true)
	public List<Produit> findAllProduits(){
		
		return repo.findAll();
	}
	
	@GetMapping("/produit/{id}")
	@Transactional(readOnly = true)
	public Produit getProduit(@PathVariable(value = "id") Long id) {
		
		Optional<Produit> optional = repo.findById(id);
		if(optional.isPresent()) {
			Produit produit = optional.get();
			return produit;
		}
		else
			return null;
	}
	
	
	@PostMapping("/saveproduit")
	@Transactional
	public Produit saveProduit(@RequestBody Produit produit) {
		
		Promotion promo = client.getPromotionByCode(produit.getCodePromo());
		float res1 = promo.getTauxr()/100;
		float res2 = produit.getPrix() - res1*produit.getPrix();
		int prixF = (int)res2;
		produit.setPrix(prixF);
		return repo.save(produit);
	}
	
	@GetMapping("/show")
	public List<Promotion> showAllPromotions(){
		return client.getAllPromotions();
	}
}
