package tuan8_bai2_PhongHocCoInterface;

public class ComputerLab extends Room{
	private int numCPU;

	public ComputerLab(String roomCode, String houseEstate, int numOfBulbs, double area, int numCPU) {
		super(roomCode, houseEstate, numOfBulbs, area);
		this.numCPU = numCPU;
	}

	public ComputerLab() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComputerLab(String roomCode, String houseEstate, int numOfBulbs, double area) {
		super(roomCode, houseEstate, numOfBulbs, area);
		// TODO Auto-generated constructor stub
	}

	public int getNumCPU() {
		return numCPU;
	}

	public void setNumCPU(int numCPU) {
		this.numCPU = numCPU;
	}
	
	public boolean computerEnough() {
		if((getArea() / getNumCPU()) <= 1.5)
			return true;
		return false;
	}

	@Override
	public boolean isStandard() {
		if(computerEnough() && brightEnough()) 
			return true;
		return false;
	}
	
	@Override
	public String toString() {
		String standard;
		if(isStandard()) standard = "Meets the standard";
		else standard= "Doesn't meet the standard";
		return super.toString() + String.format(" %-25d %-20s", getNumCPU(), standard);
	}
}
