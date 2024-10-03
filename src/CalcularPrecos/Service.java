package CalcularPrecos;

public class Service implements Source{
	private String name;
	private Double costValue;
	private Double finalPrice;
	
	public Service(Taxes tax, Double costValue, String from, String where, CitiesTaxRate city) {

		this.costValue = costValue;
		
		tax.setIcmsValue(from, where, this);
		tax.setIssValue(city, this);
		
		this.finalPrice = tax.getTaxesTotalValues() + this.costValue;
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
