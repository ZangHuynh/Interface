package tuan9_bai8_ThucPhamInterface;

import java.util.ArrayList;

public class MerchanArray implements MethodOfArray{
	private ArrayList<Merchandise> merchanList;
	
	public MerchanArray() {
		super();
		this.merchanList = new ArrayList<Merchandise>();
	}

	@Override
	public void addMerchan(Merchandise merchan) throws Exception {
		if(!merchanList.contains(merchan))
			merchanList.add(merchan);
		else 
			throw new Exception("This merchandise already exist!");
	}

	@Override
	public Merchandise findByCode(String merchanID) throws Exception {
		for(Merchandise merchan : merchanList)
			if(merchanID.equalsIgnoreCase(merchan.getMerchanID()))
				return merchan;
		return null;
	}

	@Override
	public void removeMerchan(Merchandise merchan) throws Exception {
		if(merchanList.contains(merchan))
			merchanList.remove(merchan);
		else
			throw new Exception("This merchandise not found!");
	}

	@Override
	public ArrayList<Merchandise> getFoods() {
		ArrayList<Merchandise> foodList = new ArrayList<Merchandise>();
		for(Merchandise mer : merchanList) {
			if(mer instanceof Foods)
				foodList.add(mer);
		}
		return foodList;
	}

	@Override
	public ArrayList<Merchandise> getElectrical() {
		ArrayList<Merchandise> electricList = new ArrayList<Merchandise>();
		for(Merchandise mer : merchanList) {
			if(mer instanceof ElectricalMerchan)
				electricList.add(mer);
		}
		return electricList;
	}

	@Override
	public ArrayList<Merchandise> getCeramic() {
		ArrayList<Merchandise> ceraList = new ArrayList<Merchandise>();
		for(Merchandise mer : merchanList) {
			if(mer instanceof Ceramics)
				ceraList.add(mer);
		}
		return ceraList;
	}
	
	
}
