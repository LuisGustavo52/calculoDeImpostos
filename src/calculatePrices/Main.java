package calculatePrices;

public class Main {

	public static void main(String[] args) {
		CitiesTaxRate alfenas = CitiesTaxRate.ALFENAS;
		
		Taxes taxCleaning = new Taxes();
		Taxes taxSoap = new Taxes();

		Product soap =  new Product(taxSoap, 2.1, 2.0,0.45, 0.5, "SP", "RJ");
		soap.setName("Sabão");
		Service cleaning =  new Service(taxCleaning, 40.5, 0.20, "SP", "RJ", alfenas);
		cleaning.setName("Limpeza");
		
		System.out.println(soap);
		System.out.println(cleaning);
	}

}
