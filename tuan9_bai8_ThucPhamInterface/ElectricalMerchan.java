package tuan9_bai8_ThucPhamInterface;

import java.text.DecimalFormat;

public class ElectricalMerchan extends Merchandise{
	private int warrantyMonths;
	private double wattage;
	private final double vat = 0.1;
	
	public ElectricalMerchan(String merchanID, String merchanName, int quantityInStock, double unitPrice,
			int warrantyMonths, double wattage) {
		super(merchanID, merchanName, quantityInStock, unitPrice);
		this.warrantyMonths = warrantyMonths;
		this.wattage = wattage;
	}

	public ElectricalMerchan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ElectricalMerchan(String merchanID, String merchanName, int quantityInStock, double unitPrice) {
		super(merchanID, merchanName, quantityInStock, unitPrice);
		// TODO Auto-generated constructor stub
	}
	
	public int getWarrantyMonths() {
		return warrantyMonths;
	}

	public void setWarrantyMonths(int warrantyMonths) throws Exception {
		if(warrantyMonths >= 0) {
			this.warrantyMonths = warrantyMonths;
		}else
			throw new Exception("Warranty Months must be greater than or equal to 0!");
	}

	public double getWattage() {
		return wattage;
	}

	public void setWattage(double wattage) throws Exception {
		if(wattage > 0) {
			this.wattage=wattage;
		}else 
			throw new Exception("Wattage must be greater than 0!");
	}

	@Override
	public double vatAmount() {
		return vat * unitPrice;
	}

	@Override
	public boolean rating() {
		return (quantityInStock < 3);
	}
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.00 VND");
		String rating;
		if(rating()) rating = "Sellable";
		else rating = "No rating";
		return super.toString() + String.format(" %-20s %-20s %-20s %-20s", warrantyMonths, wattage, df.format(vatAmount()), rating);
	}
}
