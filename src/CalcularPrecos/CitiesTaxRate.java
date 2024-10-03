package CalcularPrecos;

public enum CitiesTaxRate {
	MACHADO(0.105), ALFENAS(0.122), PIUI(0.113),CALDAS(0.98);
	
	private final Double TAXRATE;
	
	private CitiesTaxRate(Double taxRate) {
		this.TAXRATE = taxRate;
	}
	
	public Double getTaxRate() {
		return this.TAXRATE;
	}
	
	
}
