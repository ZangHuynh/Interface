package tuan9_bai8_ThucPhamInterface;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Foods extends Merchandise{
	private LocalDate mfg;
	private LocalDate expiredDate;
	private String supplier;
	private final double vat = 0.1;
	
	public Foods(String merchanID, String merchanName, int quantityInStock, double unitPrice, LocalDate mfg,
			LocalDate expiredDate, String supplier) {
		super(merchanID, merchanName, quantityInStock, unitPrice);
		this.mfg = mfg;
		this.expiredDate = expiredDate;
		this.supplier = supplier;
	}
	
	public Foods() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Foods(String merchanID, String merchanName, int quantityInStock, double unitPrice) {
		super(merchanID, merchanName, quantityInStock, unitPrice);
		// TODO Auto-generated constructor stub
	}
	
	public LocalDate getMfg() {
		return mfg;
	}

	public void setMfg(LocalDate mfg) {
		this.mfg = mfg;
	}

	public LocalDate getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(LocalDate expiredDate) throws Exception {
		if(expiredDate.isAfter(mfg)) {
			this.expiredDate = expiredDate;
		} else 
			throw new Exception("Expired Date must be after Manufacture Date!");
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	@Override
	public double vatAmount() {
		return vat * unitPrice;
	}

	@Override
	public boolean rating() {
		return (quantityInStock > 0 && expiredDate.isAfter(LocalDate.now()));
	}
	
	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/yyyy");
		DecimalFormat df = new DecimalFormat("#,##0.00 VND");
		String rating; 
		if(rating() == true) rating = "Hard to sell";
		else rating = "No rating";
		return super.toString() + String.format(" %-20s %-20s %-20s %-20s %-20s", dtf.format(mfg), dtf.format(expiredDate), supplier, df.format(vatAmount()), rating);
	}
}
