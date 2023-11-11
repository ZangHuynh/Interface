package tuan8_bai2_PhongHocCoInterface;

import java.text.DecimalFormat;
import java.util.Objects;

public abstract class Room {
	protected String roomCode;
	protected String houseEstate;
	protected int numOfBulbs;
	protected double area;

	public abstract boolean isStandard();
	
	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Room(String roomCode, String houseEstate, int numOfBulbs, double area) {
		super();
		this.roomCode = roomCode;
		this.houseEstate = houseEstate;
		this.numOfBulbs = numOfBulbs;
		this.area = area;
	}
	
	public String getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}

	public String getHouseEstate() {
		return houseEstate;
	}

	public void setHouseEstate(String houseEstate) {
		this.houseEstate = houseEstate;
	}

	public int getNumOfBulbs() {
		return numOfBulbs;
	}

	public void setNumOfBulbs(int numOfBulbs) {
		this.numOfBulbs = numOfBulbs;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	@Override
	public int hashCode() {
		return Objects.hash(roomCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		return Objects.equals(roomCode, other.roomCode);
	}

	protected boolean brightEnough() {
		if(getArea() / getNumOfBulbs() <= 10)
			return true;
		return false;

	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.00 m^2");
		return String.format("%-15s %-15s %-20d %-15s",getHouseEstate(),getRoomCode(),getNumOfBulbs(),df.format(getArea()));
	}
}