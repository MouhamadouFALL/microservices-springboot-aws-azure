package sn.esmt.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import sn.esmt.entities.Promotion;


@FeignClient("PROMOTION-SERVICE")
public interface ClientPromotion {
	
	@GetMapping("promotionapi/promotions")
	@Transactional(readOnly=true)
	public List<Promotion> getAllPromotions();
	
	@GetMapping("promotionapi/promocode/{code}")
	@Transactional(readOnly=true)
	public Promotion getPromotionByCode(@PathVariable(value = "code") String code);

}
