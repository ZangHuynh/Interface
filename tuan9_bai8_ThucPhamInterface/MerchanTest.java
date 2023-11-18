package tuan9_bai8_ThucPhamInterface;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MerchanTest {
	static MerchanArray merchanList = new MerchanArray();
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/yyyy");
	static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		try {
			int opt;
			do {
				opt = menu();
				switch(opt) {
					case 1:{
						creatDefault();
						break;
					}
					case 2:{
						Merchandise newMer = creatAMerchan();
						merchanList.addMerchan(newMer);
						break;
					}
					case 3:{
						displayFoodsList();
						displayElectricalList();
						displayCeramicList();
						break;
					}
					default:{
						System.out.println("End of the program!");
					}
				}
			} while(opt < 4);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static int menu() {
		System.out.println("*** MENU ***\n1.Create Default\n2.Add merchandise\n3.Display\n4.Exit");
		System.out.print("Your choice: ");
		return scn.nextInt();
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
	
	public static LocalDate inputDate(String s) {
		System.out.print(s);
		return LocalDate.parse(scn.nextLine(),dtf);
	}
	
	public static void creatDefault() throws Exception {
		System.out.println("Input (1) to create Foods, (2) to create Electrical Merchandise, (another) to create Ceramics!");
		int chos = inputInt("Your choice: ");
		scn.nextLine();
		if(chos == 1) {
			Merchandise mer1 = new Foods("1111", "Milk", 50, 6000, LocalDate.parse("18/8/2023",dtf), LocalDate.parse("18/9/2023",dtf), "Thanh Nam");
			Merchandise mer2 = new Foods("1112", "Cake", 100, 6000, LocalDate.parse("10/2/2024",dtf), LocalDate.parse("3/3/2024",dtf), "Thanh Nam");
			Merchandise mer3 = new Foods("1113", "Hamburger", 5, 6000, LocalDate.parse("30/1/2023",dtf), LocalDate.parse("30/2/2023",dtf), "Thanh Nam");
			Merchandise mer4 = new Foods("1114", "Cheese", 80, 6000, LocalDate.parse("1/1/2024",dtf), LocalDate.parse("2/2/2024",dtf), "Thanh Nam");
			merchanList.addMerchan(mer1);
			merchanList.addMerchan(mer2);
			merchanList.addMerchan(mer3);
			merchanList.addMerchan(mer4);
		} else if(chos == 2){
			Merchandise mer1 = new ElectricalMerchan("2221", "Mouse", 10, 100000, 6, 60);
			Merchandise mer2 = new ElectricalMerchan("2222", "USB", 1, 450000, 6, 60);
			Merchandise mer3 = new ElectricalMerchan("2223", "Projector", 2, 500000, 6, 60);
			Merchandise mer4 = new ElectricalMerchan("2224", "Keyboard", 12, 150000, 6, 60);
			merchanList.addMerchan(mer1);
			merchanList.addMerchan(mer2);
			merchanList.addMerchan(mer3);
			merchanList.addMerchan(mer4);
		} else {
			Merchandise mer1 = new Ceramics("3331", "Teapot", 10, 30000, "Manh Long", LocalDate.parse("30/12/2023",dtf));
			Merchandise mer2 = new Ceramics("3332", "Glass", 80, 35000, "Manh Long", LocalDate.parse("30/10/2023",dtf));
			Merchandise mer3 = new Ceramics("3333", "Cup", 20, 20000, "Manh Long", LocalDate.parse("2/2/2024",dtf));
			Merchandise mer4 = new Ceramics("3334", "Bowl", 60, 10000, "Manh Long", LocalDate.parse("30/10/2023",dtf));
			merchanList.addMerchan(mer1);
			merchanList.addMerchan(mer2);
			merchanList.addMerchan(mer3);
			merchanList.addMerchan(mer4);
		}
	}
	
	public static Merchandise creatAMerchan() throws Exception {
		System.out.println("Input (1) to create Foods, (2) to create Electrical Merchandise, (another) to create Ceramics!");
		int chos = inputInt("Your choice: ");
		scn.nextLine();
		String merchanID, merchanName;
		int inStock;
		double unitPrice;
		if(chos == 1) {
			merchanID = inputString("Input merchadise id: ");
			while(merchanList.findByCode(merchanID) != null) {
				System.out.println("This merchandis already exist!");
				merchanID = inputString("Input merchadise id: ");
			}
			merchanName = inputString("Input merchadise name: ");
			inStock = inputInt("Input quanitty in stock: ");
			unitPrice = inputDouble("Input unit price: ");
			
			LocalDate mfg = inputDate("Input manufacture date: ");
			LocalDate expired = inputDate("Input expired date: ");
			String supplier = inputString("Input suppliers: ");
			Merchandise newMer = new Foods(merchanID, merchanName, inStock, unitPrice, mfg, expired, supplier);
			return newMer;
		} else if(chos == 2) {
			merchanID = inputString("Input merchadise id: ");
			while(merchanList.findByCode(merchanID) != null) {
				System.out.println("This merchandis already exist!");
				merchanID = inputString("Input merchadise id: ");
			}
			merchanName = inputString("Input merchadise name: ");
			inStock = inputInt("Input quanitty in stock: ");
			unitPrice = inputDouble("Input unit price: ");
			
			int warrMonth = inputInt("Input warranty months: ");
			double wat = inputDouble("Input wattage: ");
			Merchandise newMer = new ElectricalMerchan(merchanID, merchanName, inStock, unitPrice, warrMonth, wat);
			return newMer;
		} else {
			merchanID = inputString("Input merchadise id: ");
			while(merchanList.findByCode(merchanID) != null) {
				System.out.println("This merchandis already exist!");
				merchanID = inputString("Input merchadise id: ");
			}
			merchanName = inputString("Input merchadise name: ");
			inStock = inputInt("Input quanitty in stock: ");
			unitPrice = inputDouble("Input unit price: ");
			
			String supplier = inputString("Input ceramic suppliers: ");
			LocalDate entryDate = inputDate("Input entry date: ");
			Merchandise newMer = new Ceramics(merchanID, merchanName, inStock, unitPrice, supplier, entryDate);
			return newMer;
		}
	}
	
	public static void  displayTitleFoods() {
		String s = String.format("%-25s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s", "Merchandise Type", "MerchandiseID", "Merchandise Name", "Quantity In Stock", "Unit Price", "MFG", "Expired Date", "Supplier", "VAT", "Rating");
		System.out.println(s);
	}
	
	public static void  displayTitleElectrical() {
		String s = String.format("%-25s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s", "Merchandise Type", "MerchandiseID", "Merchandise Name", "Quantity In Stock", "Unit Price", "Warranty Months", "Wattage", "VAT", "Rating");
		System.out.println(s);
	}
	
	public static void  displayTitleCera() {
		String s = String.format("%-25s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s", "Merchandise Type", "MerchandiseID", "Merchandise Name", "Quantity In Stock", "Unit Price", "Supplier", "Entry Date", "VAT", "Rating");
		System.out.println(s);
	}
	
	public static void displayFoodsList() {
		System.out.println("*** FOOD LIST ***");
		displayTitleFoods();
		for(Merchandise mer : merchanList.getFoods()) {
			System.out.printf("%-26s", "Foods");
			System.out.println(mer);
		}
		System.out.println("\n");
	}
	
	public static void displayElectricalList() {
		System.out.println("*** ELECTRICAL LIST ***");
		displayTitleElectrical();
		for(Merchandise mer : merchanList.getElectrical()) {
			System.out.printf("%-26s", "Electrical Merchandise");
			System.out.println(mer);
		}
		System.out.println("\n");
	}
	
	public static void displayCeramicList() {
		System.out.println("*** CERAMICS LIST ***");
		displayTitleCera();
		for(Merchandise mer : merchanList.getCeramic()) {
			System.out.printf("%-26s", "Ceramics");
			System.out.println(mer);
		}
		System.out.println("\n");
	}
}
