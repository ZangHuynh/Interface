package tuan8_bai2_PhongHocCoInterface;

public class LectureHalls extends Room{
	private boolean projector;

	public LectureHalls(String roomCode, String houseEstate, int numOfBulbs, double area, boolean projector) {
		super(roomCode, houseEstate, numOfBulbs, area);
		this.projector = projector;
	}

	public LectureHalls() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LectureHalls(String roomCode, String houseEstate, int numOfBulbs, double area) {
		super(roomCode, houseEstate, numOfBulbs, area);
		// TODO Auto-generated constructor stub
	}

	public boolean isProjector() {
		return projector;
	}

	public void setProjector(boolean projector) {
		this.projector = projector;
	}

	@Override
	public boolean isStandard() {
		if(isProjector() && brightEnough())
			return true;
		return false;
	}
	
	@Override
	public String toString() {
		String isProjector, standard;
		if(isProjector()) isProjector = "Have a projector";
			else isProjector = "No projector available";
		if(isStandard()) standard = "Meets the standard";
			else standard= "Doesn't meet the standard";
		return super.toString() + String.format(" %-25s %-20s", isProjector, standard);
	}
}
