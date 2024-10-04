package calculatePrices;

public class Product implements Source{
	private String name;
	private Double costValue;
	private Double freight;
	private Double insurance;
	private Double finalPrice;
	private Double profitMargin;
	
	public Product(Taxes tax, Double insurance, Double costValue, Double profitMargin, Double freight, String from, String where) {
		this.freight = freight;
		this.insurance = insurance;
		this.costValue = costValue;
		this.profitMargin = profitMargin;
		
		tax.setIcmsValue(from, where, this);
		tax.setIpiValue(this);
		
		this.finalPrice = tax.getTaxesTotalValues() + this.insurance + this.costValue +  this.freight;
		this.finalPrice += (this.finalPrice *profitMargin);
	}
	
	
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Double getCostValue() {
		return costValue;
	}

	public Double getValorFinal() {
		return finalPrice;
	}

	@Override
	public Double getFinalPrice() {
		return finalPrice;
	}	
	

	@Override
	public String toString() {
		String product = "Nome do Produto: "+ this.name + ", Preço do produto: "+ Double.valueOf(this.finalPrice) + "\n---------------------------------------------------------";
		return product;
	}
}
