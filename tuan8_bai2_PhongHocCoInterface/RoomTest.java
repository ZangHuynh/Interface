package tuan8_bai2_PhongHocCoInterface;

import java.util.Scanner;

public class RoomTest {
	static RoomList roomList = new RoomList();
	static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		try {
			int opt;
			do {
				System.out.println("\n");
				opt = mainMenu();
				scn.nextLine();
				switch(opt) {
				case 1:{
					createDefault();
					break;
				}
				case 2:{
					Room newRoom = createARoom();
					roomList.addRoom(newRoom);
					break;
				}
				case 3:{
					findRoom();
					break;
				}
				case 4:{
					removeARoom();
					break;
				}
				case 5:{
					updateRomm();
					break;
				}
				case 6:{
					displayRoomList();
					break;
				}
				case 7:{
					displayStandardRoom();
					break;
				}
				case 8:{
					displayRoomList60();
					break;
				}
				case 9:{
					roomList.sortAscendingHouse();
					break;
				}
				case 10:{
					roomList.sortDescendingArea();
					break;
				}
				case 11:{
					roomList.sortAscendingBulb();
				}
				default :{
					System.out.println("End of the program!");
				}
				}
			}while(opt < 12);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static int inputInt(String s) {
		System.out.print(s);
		return scn.nextInt();
	}

	public static String inputString(String s) {
		System.out.print(s);
		return scn.nextLine();
	}

	public static double inputDouble(String s) {
		System.out.print(s);
		return scn.nextDouble();
	}

	public static void createDefault() throws Exception {
		System.out.println("Input (1) to create Lecture Halls, (2) to create Computer Labs, (another) to create Laboratory!");
		int chos = inputInt("Your choice: ");
		scn.nextLine();
		switch(chos) {
			case 1:{
				Room r1 = new LectureHalls("1111", "A1", 20, 100, true);
				Room r2 = new LectureHalls("1112", "A1", 30, 300, false);
				Room r3 = new LectureHalls("1113", "A2", 50, 200, false);
				Room r4 = new LectureHalls("1114", "A3", 40, 150, true);
				roomList.addRoom(r1);
				roomList.addRoom(r2);
				roomList.addRoom(r3);
				roomList.addRoom(r4);
				break;
			}
			case 2:{
				Room r1 = new ComputerLab("2221", "H2", 20, 300, 40);
				Room r2 = new ComputerLab("2222", "H2", 30, 250, 60);
				Room r3 = new ComputerLab("2223", "H1", 20, 150, 60);
				Room r4 = new ComputerLab("2224", "H3", 30, 100, 30);
				roomList.addRoom(r1);
				roomList.addRoom(r2);
				roomList.addRoom(r3);
				roomList.addRoom(r4);
				break;
			}
			default:{
				Room r1 = new Laboratory("3331", "C1", 20, 300, true);
				Room r2 = new Laboratory("3332", "C2", 50, 600, true);
				Room r3 = new Laboratory("3333", "C3", 15, 200, true);
				Room r4 = new Laboratory("3334", "C3", 10, 100, false);
				roomList.addRoom(r1);
				roomList.addRoom(r2);
				roomList.addRoom(r3);
				roomList.addRoom(r4);
				break;
			}
		}
	}

	public static Room createARoom() {
		System.out.println("Input (1) to create Lecture Halls, (2) to create Computer Labs, (another) to create Laboratory!");
		int chos = inputInt("Your choice: ");

		String roomCode = inputString("Input room code: ");
		while(roomList.findByCode(roomCode)!=null) {
			System.out.println("This room code already exist!");
			roomCode = inputString("Input room code: ");
		}
		String houseEstate = inputString("Input house estate: ");
		int numOfBulb = inputInt("Input number of bulbs: ");
		double area = inputDouble("Input area: ");

		switch(chos) {
		case 1:{
			String choice = inputString("Does this room have a projector? (Y/N): ");
			boolean projector = (choice.equalsIgnoreCase("y")) ? true : false;
			Room newRoom = new LectureHalls(roomCode, houseEstate, numOfBulb, area, projector);
			return newRoom;
		}
		case 2:{
			int numCPU = inputInt("Input number of CPU: ");
			Room newRoom = new ComputerLab(roomCode, houseEstate, numOfBulb, area, numCPU);
			return newRoom;
		}
		default:{
			String choice = inputString("Does this room have a projector? (Y/N): ");
			boolean sink = (choice.equalsIgnoreCase("y")) ? true : false;
			Room newRoom = new Laboratory(roomCode, houseEstate, numOfBulb, area, sink);
			return newRoom;
		}
		}
	}
	
	public static void findRoom() throws Exception {
		String roomCode = inputString("Input ROOM CODE need to find: ");
		Room newRoom = roomList.findByCode(roomCode);
		if(newRoom != null) {
			System.out.println("*** ROOM HAS BEEN FOUND ***");
			displayTitle();
			if(newRoom instanceof LectureHalls) {
				System.out.printf("%-16s", "Lecture Halls");
				System.out.println(newRoom);
			}else if(newRoom instanceof ComputerLab) {
				System.out.printf("%-16s", "Computer Labs");
				System.out.println(newRoom);
			}else {
				System.out.printf("%-16s", "Laboratory");
				System.out.println(newRoom);
			}
		} else 
			throw new Exception("This room hasn't found!");
	}

	public static void removeARoom() throws Exception {
		String roomCode = inputString("Input ROOM CODE need to remove: ");
		Room newRoom = roomList.findByCode(roomCode);
		if(newRoom!=null) {
			String choice;
			do {
	            choice = inputString("Are you sure you want to remove this room? (Y/N): ");
	            if (choice.equalsIgnoreCase("Y")) {
	                roomList.removeRoom(newRoom);
	                System.out.println("Room removed successfully");
	            } else if (choice.equalsIgnoreCase("N")) {
	                System.out.println("Operation canceled");
	            } else {
	                System.out.println("Please enter Y or N");
	            }
	        } while (!choice.equalsIgnoreCase("Y") && !choice.equalsIgnoreCase("N"));
		} else 
			throw new Exception("This room hasn't found!");
	}

	public static void updateRomm() throws Exception {
		String roomCode = inputString("Input ROOM CODE need to update: ");
		Room newRoom = roomList.findByCode(roomCode);
		if(newRoom!=null) {
			if(newRoom instanceof LectureHalls) {
				int choice;
				do {
					choice= menuLHR();
					switch(choice) {
					case 1:{
						String houseEstate = inputString("Update house estate: ");
						newRoom.setHouseEstate(houseEstate);
						break;
					}
					case 2:{
						int numOfBulb = inputInt("Update number of bulbs: ");
						newRoom.setNumOfBulbs(numOfBulb);
						break;
					}
					case 3:{
						double area = inputDouble("Update area: ");
						newRoom.setArea(area);
						break;
					}
					case 4:{
						String chos = inputString("Update projector: ");
						boolean projector = (chos.equalsIgnoreCase("y")) ? true : false;
						((LectureHalls) newRoom).setProjector(projector);
						break;
					}
					}
				}while(choice < 5);
			} if(newRoom instanceof ComputerLab) {
				int choice;
				do {
					choice = menuCLR();
					switch(choice) {
					case 1:{
						String houseEstate = inputString("Update house estate: ");
						newRoom.setHouseEstate(houseEstate);
						break;
					}
					case 2:{
						int numOfBulb = inputInt("Update number of bulbs: ");
						newRoom.setNumOfBulbs(numOfBulb);
						break;
					}
					case 3:{
						double area = inputDouble("Update area: ");
						newRoom.setArea(area);
						break;
					}
					case 4:{
						int numCPU = inputInt("Update number of CPU: ");
						((ComputerLab) newRoom).setNumCPU(numCPU);
						break;
					}
					default:{
						System.out.println("End of the program!");
					}
					}
				}while(choice < 5);
			} else {
				int choice;
				do {
					choice = menuCLR();
					switch(choice) {
					case 1:{
						String houseEstate = inputString("Update house estate: ");
						newRoom.setHouseEstate(houseEstate);
						break;
					}
					case 2:{
						int numOfBulb = inputInt("Update number of bulbs: ");
						newRoom.setNumOfBulbs(numOfBulb);
						break;
					}
					case 3:{
						double area = inputDouble("Update area: ");
						newRoom.setArea(area);
						break;
					}
					case 4:{
						String chos = inputString("Update projector: ");
						boolean sink = (chos.equalsIgnoreCase("y")) ? true : false;
						((Laboratory)newRoom).setSink(sink);
						break;
					}
					default:{
						System.out.println("End of the program!");
					}
					}
				}while(choice < 5);
			}
		} else 
			throw new Exception("This room hasn't found!");
	}

	public static int mainMenu() {
		System.out.println("*** MENU ALL ***\n1.Create Default\n2.Create A Room\n3.Find Room(By Code)\n4.Remove\n5.Update\n6.Display All\n7.Display Meet Standard Room\n8.Display Computer Lab (60 CPU)\n9.Sort House Estate\n10.Sort Area\n11.Sort Bulbs\n12.Exit");
		int choice = inputInt("Your choice: ");
		return choice;
	}

	public static int menuLHR() {
		System.out.println("****MENU****\n1.House Estatte\n2.Number Of Bulbs\n3.Area\n4.Projector\n5.Exit");
		int choice = inputInt("Your choice: ");
		return choice;
	}

	public static int menuCLR() {
		System.out.println("****MENU****\n1.House Estatte\n2.Number Of Bulbs\n3.Area\n4.Number Of CPU\n5.Exit");
		int choice = inputInt("Your choice: ");
		return choice;
	}

	public static int menuLBR() {
		System.out.println("****MENU****\n1.House Estatte\n2.Number Of Bulbs\n3.Area\n4.Sink\n5.Exit");
		int choice = inputInt("Your choice: ");
		return choice;
	}

	public static void displayTitle() {
		String s = String.format("%-15s %-15s %-15s %-20s %-15s %-25s %-20s", "Room Type", "House Estate", "Room Code", "Number Of Bulbs", "Area", "Projector/CPU/Sink", "Standard");
		System.out.println(s);
	}

	public static void displayRoomList() {
		System.out.println("*** ROOM LIST ***");
		displayTitle();
		for(Room room : roomList.getAll()) {
			if(room instanceof LectureHalls) {
				System.out.printf("%-16s", "Lecture Halls");
				System.out.println(room);
			}else if(room instanceof ComputerLab) {
				System.out.printf("%-16s", "Computer Labs");
				System.out.println(room);
			}else {
				System.out.printf("%-16s", "Laboratory");
				System.out.println(room);
			}
		}
	}

	public static void displayRoomList60() {
		System.out.println("*** COMPUTER LABS HAVE 60CPU LIST ***");
		displayTitle();
		for(Room room : roomList.getComputer60()) {
			System.out.printf("%-16s", "Computer Labs");
			System.out.println(room);
		}
	}

	public static void displayStandardRoom() {
		System.out.println("*** STANDARD ROOM LIST ***");
		displayTitle();
		for(Room room : roomList.getStandard()) {
			if(room instanceof LectureHalls) {
				System.out.printf("%-16s", "Lecture Halls");
				System.out.println(room);
			}else if(room instanceof ComputerLab) {
				System.out.printf("%-16s", "Computer Labs");
				System.out.println(room);
			}else {
				System.out.printf("%-16s", "Laboratory");
				System.out.println(room);
			}
		}
	}
}
