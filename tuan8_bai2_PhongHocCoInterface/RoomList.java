package tuan8_bai2_PhongHocCoInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RoomList implements MethodOfArray{
	private ArrayList<Room> roomList;

	public RoomList() {
		super();
		this.roomList = new ArrayList<Room>();
	}
	
	public Room findByCode(String roomCode) {
		for(Room room : roomList) {
			if(room.getRoomCode().equalsIgnoreCase(roomCode))
				return room;
		}
		return null;
			
	}
	
	public void addRoom(Room room) throws Exception {
		if(!roomList.contains(room))
			roomList.add(room);
		else
			throw new Exception("This room already exist!");
	}
	
	public void removeRoom(Room room) throws Exception {
		if(roomList.contains(room))
			roomList.remove(room);
		else
			throw new Exception("This room not found!");
	}
	
	public ArrayList<Room> getAll(){
		return roomList;
	}
	
	public ArrayList<Room> getStandard(){
		ArrayList<Room> standardList = new ArrayList<Room>();
		for(Room room : roomList) {
			if(room.isStandard())
				standardList.add(room);
		}
		return standardList;
	}
	
	public ArrayList<Room> getComputer60(){
		ArrayList<Room> labList = new ArrayList<Room>();
		for(Room room : roomList) {
			if(room instanceof ComputerLab && ((ComputerLab)room).getNumCPU() == 60)
				labList.add(room);
		}
		return labList;
	}
	
	public void sortAscendingHouse(){
		Collections.sort(roomList, new Comparator<Room>() {

			@Override
			public int compare(Room o1, Room o2) {
				return o1.getHouseEstate().compareToIgnoreCase(o2.getHouseEstate());
			}
		});
	}
	
	public void sortDescendingArea() {
		Collections.sort(roomList, new Comparator<Room>() {

			@Override
			public int compare(Room o1, Room o2) {
				return Double.compare(o2.getArea(), o1.getArea());
			}
		});
	}
	
	public void sortAscendingBulb() {
	    Collections.sort(roomList, new Comparator<Room>() {
	    	
	        @Override
	        public int compare(Room o1, Room o2) {
	            return Integer.compare(o1.getNumOfBulbs(), o2.getNumOfBulbs());
	        }
	    });
	}
	
	public int sumQuantityRoom() {
		return roomList.size();
	}
}
