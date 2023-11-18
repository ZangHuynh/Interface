package tuan9_bai8_ThucPhamInterface;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Ceramics extends Merchandise{
	private String supplierCera;
	private LocalDate entryDate;
	private final double vat = 0.1;
	
	public Ceramics(String merchanID, String merchanName, int quantityInStock, double unitPrice, String mfgCera,
			LocalDate entryDate) {
		super(merchanID, merchanName, quantityInStock, unitPrice);
		this.supplierCera = mfgCera;
		this.entryDate = entryDate;
	}

	public Ceramics() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ceramics(String merchanID, String merchanName, int quantityInStock, double unitPrice) {
		super(merchanID, merchanName, quantityInStock, unitPrice);
		// TODO Auto-generated constructor stub
	}

	public String getMfgCera() {
		return supplierCera;
	}

	public void setMfgCera(String mfgCera) {
		this.supplierCera = mfgCera;
	}

	public LocalDate getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(LocalDate entryDate) {
		this.entryDate = entryDate;
	}

	@Override
	public boolean rating() {
		return (quantityInStock > 50 && entryDate.isBefore(LocalDate.now().minusDays(10)));
	}

	@Override
	public double vatAmount() {
		return vat * unitPrice;
	}
	
	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/yyyy");
		DecimalFormat df = new DecimalFormat("#,##0.00 VND");
		String rating;
		if(rating()) rating = "Slow-selling"; 
		else rating ="No rating";
		return super.toString() + String.format(" %-20s %-20s %-20s %-20s", supplierCera, dtf.format(entryDate), df.format(vatAmount()), rating);
	}
}
