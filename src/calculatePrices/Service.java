package calculatePrices;

public class Service implements Source{
	private String name;
	private Double costValue;
	private Double finalPrice;
	private Double profitMargin;
	
	public Service(Taxes tax, Double costValue, Double profitMargin, String from, String where, CitiesTaxRate city) {

		this.costValue = costValue;
		this.profitMargin = profitMargin;

		
		tax.setIcmsValue(from, where, this);
		tax.setIssValue(city, this);
		
		this.finalPrice = tax.getTaxesTotalValues() + this.costValue +((tax.getTaxesTotalValues() + this.costValue) * this.profitMargin);
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
		String product = "Nome do Serviço: "+ this.name + ", Preço do Serviço: "+ Double.valueOf(this.finalPrice) + "\n---------------------------------------------------------";
		return product;
	}
}
