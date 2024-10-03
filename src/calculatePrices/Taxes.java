package calculatePrices;

public class Taxes {
	private Double icms = 0.00;
	private Double ipi = 0.00;
	private Double iss = 0.00;
	

	
	public void  setIcmsValue(String ufFrom, String ufDestiny, Source source) {
		switch (ufFrom) {
		case "SP": {
			if(ufDestiny.equals("MG"))
				icms = source.getCostValue() * 0.10;
			else if(ufDestiny.equals("RJ")) {
				icms = source.getCostValue() * 0.12;
			}else
				throw new IllegalArgumentException("Unexpected value: " + ufFrom);
			
			break;
		}case "MG": {
			if(ufDestiny.equals("SP")){
				icms = source.getCostValue() * 0.11;
			}else if(ufDestiny.equals("RJ")) {
				icms = source.getCostValue() * 0.9;
			}else
				throw new IllegalArgumentException("Unexpected value: " + ufFrom);
			
			break;
		}case "RJ": {
			if(ufDestiny.equals("MG")){
				icms = source.getCostValue() * 0.15;
			}else if(ufDestiny.equals("SP")) {
				icms = source.getCostValue() * 0.13;
			}
			else
				throw new IllegalArgumentException("Unexpected value: " + ufFrom);
			
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + ufFrom);
		}
	}
	
	public void setIpiValue(Source source) {
		ipi = source.getCostValue() * (source.getCostValue() * 0.15);
	}
	
	public void setIssValue(CitiesTaxRate city, Source source) {
		iss = city.getTaxRate() * source.getCostValue();
	}
	
	public Double getTaxesTotalValues() {
		return icms + ipi + iss;
	}
}
