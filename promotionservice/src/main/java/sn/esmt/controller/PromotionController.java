/**
 * 
 */
package sn.esmt.controller;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.esmt.entities.Promotion;
import sn.esmt.repository.PromotionRepository;

/**
 * @author nabyFall
 *
 */

@RestController
@RequestMapping("/promotionapi")
public class PromotionController {
	
	@Autowired
	private PromotionRepository repo;
	
	
	@GetMapping("/promotions")
	@Transactional(readOnly=true)
	public List<Promotion> afficherPromotions(){
		
		return repo.findAll();
	}
	
	
	@GetMapping("/promotions/{id}")
	@Transactional(readOnly=true)
	public Promotion getPromotionById(@PathVariable(value = "id") Long id) {
		
		Optional<Promotion> optional = repo.findById(id);
		if(optional.isPresent()) {
			Promotion promotion = optional.get();
			return promotion;
		}
		else {
			return null;
		}
	}
	
	@PostMapping("/promotions")
	@Transactional
	public Promotion savePromotion(@RequestBody Promotion promo) {
		
		return repo.save(promo);
	}

	@PutMapping("/promotions/{id}")
	@Transactional
	public Promotion updatePromotion(@PathVariable(value = "id") Long id, @RequestBody Promotion newPromo) {
		
		Optional<Promotion> optional = repo.findById(id);
		if(optional.isPresent()) {
			Promotion promo = optional.get();
			promo.setCode(newPromo.getCode());
			promo.setTauxr(newPromo.getTauxr());
			repo.save(promo);
			return promo;
		}
		else {
			return null;
		}
	}
	
	@DeleteMapping("/promotions/{id}")
	@Transactional
	public void deletePromotion(@PathVariable(value = "id") Long id) {
		
		// on puet faire repo.deleteById(id) sans la méthode get()
		// ou faire un get() et ensuite delete(object)
		
		Optional<Promotion> optional = repo.findById(id);
		if(optional.isPresent()) {
			Promotion promo = optional.get();
			repo.delete(promo);
		}
	}
	
	
	@GetMapping("/promocode/{code}")
	@Transactional(readOnly=true)
	public Promotion getPromotionByCode(@PathVariable(value = "code") String code) {
		
		Promotion promo = null;
		promo = repo.findByCode(code);
		
		return promo;
		
	}
}
