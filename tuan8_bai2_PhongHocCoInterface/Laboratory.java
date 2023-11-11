package tuan8_bai2_PhongHocCoInterface;

public class Laboratory extends Room{
	private boolean sink;

	public Laboratory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Laboratory(String roomCode, String houseEstate, int numOfBulbs, double area) {
		super(roomCode, houseEstate, numOfBulbs, area);
		// TODO Auto-generated constructor stub
	}

	public Laboratory(String roomCode, String houseEstate, int numOfBulbs, double area, boolean sink) {
		super(roomCode, houseEstate, numOfBulbs, area);
		this.sink = sink;
	}

	public boolean isSink() {
		return sink;
	}

	public void setSink(boolean sink) {
		this.sink = sink;
	}

	@Override
	public boolean isStandard() {
		if(isSink() && brightEnough())
			return true;
		return false;
	}
	
	@Override
	public String toString() {
		String isSink, standard;
		if(isSink()) isSink = "Have a sink";
			else isSink = "No sink available";
		if(isStandard()) standard = "Meets the standard";
			else standard= "Doesn't meet the standard";
		return super.toString() + String.format(" %-25s %-20s", isSink, standard);
	}
}
