package com.bookstore.book.helper;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.bookstore.book.configuration.PromotionConfigProperties;

public class BookHelper {

	/**
	 * build the promo code as map for easily handling Key is technology_promocode
	 * (TECHNOLOGY_OFFERFIC10) value is discount.(10%)
	 * 
	 * 
	 * @param promotionConfigProperties
	 * @return map
	 * @author Muthukumar Chellappa
	 * 
	 */
	public static Map<String, BigDecimal> buildPromoCodeMap(PromotionConfigProperties promotionConfigProperties) {

		Map<String, BigDecimal> promoMap = new HashMap(); 
		
		promotionConfigProperties.getPromos().stream().forEach(promo -> {
			promoMap.put(promo.getPromocode(), promo.getDiscount());
		});
		
		
		return promoMap;

	}

}
