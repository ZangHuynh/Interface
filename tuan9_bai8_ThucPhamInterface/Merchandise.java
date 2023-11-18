package tuan9_bai8_ThucPhamInterface;

public abstract class Merchandise {
	protected String merchanID;
	protected String merchanName;
	protected int quantityInStock;
	protected double unitPrice;
	
	protected Merchandise(String merchanID, String merchanName, int quantityInStock, double unitPrice) {
		super();
		this.merchanID = merchanID;
		this.merchanName = merchanName;
		this.quantityInStock = quantityInStock;
		this.unitPrice = unitPrice;
	}

	protected Merchandise() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected String getMerchanID() {
		return merchanID;
	}

	protected void setMerchanID(String merchanID) throws Exception {
		if(merchanID != null) {
			this.merchanID = merchanID;
		}else
			throw new Exception("Merchandise mustn't be null!");
	}

	protected String getMerchanName() {
		return merchanName;
	}

	protected void setMerchanName(String merchanName) {
		this.merchanName = merchanName;
	}

	protected int getQuantityInStock() {
		return quantityInStock;
	}

	protected void setQuantityInStock(int quantityInStock) throws Exception {
		if(quantityInStock >= 0) {
			this.quantityInStock = quantityInStock;
		}else 
			throw new Exception("Quantity In stock must be greater than or equal to 0!");
	}

	protected double getUnitPrice() {
		return unitPrice;
	}

	protected void setUnitPrice(double unitPrice) throws Exception {
		if(unitPrice > 0) {
			this.unitPrice = unitPrice;
		} else 
			throw new Exception("Unit Price must be greater than 0!");
	}
	
	public abstract double vatAmount();
	
	public abstract boolean rating();
	
	@Override
	public String toString() {
		return String.format("%-20s %-20s %-20s %-20s", merchanID, merchanName, quantityInStock, unitPrice);
	}
}
