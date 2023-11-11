package tuan8_bai2_PhongHocCoInterface;

import java.util.ArrayList;

public interface MethodOfArray {
	public void addRoom(Room room) throws Exception;
	
	public Room findByCode(String roomCode);
	
	public void removeRoom(Room room) throws Exception;
	
	public ArrayList<Room> getAll();
	
	public ArrayList<Room> getStandard();
	
	public ArrayList<Room> getComputer60();
	
	public void sortAscendingHouse();
	
	public void sortDescendingArea();
	
	public void sortAscendingBulb();
	
	public int sumQuantityRoom();
}
