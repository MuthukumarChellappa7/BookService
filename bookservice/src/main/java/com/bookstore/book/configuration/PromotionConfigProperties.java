package com.bookstore.book.configuration;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)

@Component
@ConfigurationProperties(prefix="app")
public class PromotionConfigProperties {
	
	private List<Promo> promos = new ArrayList();
	
	public static class Promo {

		private String promocode;
		private String bookType;
		private BigDecimal discount;
		private String expiredate;
		
		public String getPromocode() {
			return promocode;
		}
		public void setPromocode(String promocode) {
			this.promocode = promocode;
		}
		public String getBookType() {
			return bookType;
		}
		public void setBookType(String bookType) {
			this.bookType = bookType;
		}
		public BigDecimal getDiscount() {
			return discount;
		}
		public void setDiscount(BigDecimal discount) {
			this.discount = discount;
		}
		public String getExpiredate() {
			return expiredate;
		}
		public void setExpiredate(String expiredate) {
			this.expiredate = expiredate;
		}
		
		

	}

}
