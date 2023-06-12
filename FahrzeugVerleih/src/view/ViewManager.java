package view;

import java.awt.Container;
import java.sql.Timestamp;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import de.hws.data.*;

public class ViewManager {
	
    public static final int CAR = 1;
    public static final int CUSTOMER = 2;
	private static ViewManager instance;
	private Container rootPane;
	private MapPanel mapPanel;
	private JTabbedPane dataTabs;
	//private DataPanel carPanel;
	//private DataPanel customerPanel;
	private JPanel jPanelCars;
	private JPanel jPanelCustomers;
	private JTable tableCars;
	private JTable tableCust;
	
	
	private ViewManager() {
		
	}
	
	public static ViewManager getInstance() {
		if(instance == null) {
			instance = new ViewManager();
		}
		return instance;
	}
	
	public void setRootPane(Container root) {
		rootPane = root;
	}
	
	public void setPanel(MapPanel map, JTabbedPane dataTabs) {
		mapPanel = map;
		this.dataTabs = dataTabs;
	}
	
	public void showStatusOverview() {
		
	}
	
	public void createMotorcar(String license, String name, String type, int km, Timestamp nextCheck) {
		
	}
	
	public void updateCarDataPanel(List<Motocar> cars) {
		
	}
	
	public void updateMap() {
		
	}
	
	public void selectCarFromMap(String id) {
		
	}
	
	public void selectCustomer(String id) {
		
	}
	
	public void createCustomer(String name, String vorname, String adresse) {
		
	}
	
	public void updateCustomerDataPanel(List<Customer> customers) {
		
	}
	
	public void showMessage(String message) {
		
	}
 }



