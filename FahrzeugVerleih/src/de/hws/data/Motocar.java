package de.hws.data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Motocar implements Serializable {
	private long fzid;
	private String license;
	private String name;
	private String type;
	private int km;
	private Timestamp nextCheck;
	private List<Location> locations;
	private SwingWaypoint swPoint;
	
	public Motocar(long fzId, String lic, String name, String type, int km, Timestamp nextCheck) {
		super();
		this.fzid =(long) fzId;
		this.license = lic;
		this.name = name;
		this.type = type;
		this.km = km;
		this.nextCheck = nextCheck;
	}
	
	public long getFzId() {
		return fzid;
	}
	
	public String getLicense() {
		return license;
	}
	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public int getKm() {
		return km;
	}
	
	public void setKm(int km) {
		this.km = km;
	}
	
	public Timestamp getNextCheck() {
		return nextCheck;
	}
	
	public void setNextCheck (Timestamp nextCheck) {
		this.nextCheck = nextCheck;
	}
	
	public Location getLastPos() {
		if(locations != null && locations.size()>0) {
			return locations.get(locations.size()-1);
		}
		return null;
	}
		
   
	public List<Location> getLocationList(){
		
		return locations;
	}
	
	public void addLocation(Location loc) {
		if(locations == null ) {
			locations = new ArrayList<Location>();
		}
		locations.add(loc);
	}
	
	 public SwingWaypoint getMyPoint () {
		return null;
	 }
	
     public void setMyPoint (SwingWaypoint Swing) {
		
      }
	
	public String toString() {
		return null;
	}
	
	public String[] getCarData() {
		return null;
	}
	
	public String[] getCarColumns() {
		return null;
	}

	public Object getMyPoint() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
