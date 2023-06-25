package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import de.hws.data.*;
import de.hws.app.AppManager;
import view.MapPanel;
import view.dataTable.CarListSelectionListener;
import view.dataTable.CustomerCellEditListener;
import view.dataTable.CustomerListSelectionListener;
import view.dataTable.DataPanel;
import view.dataTable.PopupMenueListener;

public class ViewManager {
	
	public static int CAR = 1;
	public static int CUSTOMER = 2;
	private static ViewManager instance;
	private Container rootPane;
	private MapPanel mapPanel;
	private JTabbedPane dataTabs;
	private DataPanel carPanel, customerPanel;
	private JPanel jPanelCars, jPanelCustomers;
	private JTable tableCars,tableCus;
	
	
	
	private ViewManager() {
		
	}
	
	public static ViewManager getInstance() {			
			if(instance == null) {
				instance = new ViewManager();
			}
			return instance;
	}
	
	public void setRootPane(Container root) {
		this.rootPane = root;
	}
	
	public void setPanel(MapPanel map, JTabbedPane dataTabs) {
		this.mapPanel = map;
		this.dataTabs = dataTabs;
	}
	
	public void showStatusOverview() {
		List<Motocar> results = AppManager.getInstance().getCars();
		mapPanel.updateCarPosition(results);
		updateCarDataPanel(results);
		List<Customer> resultsCust = AppManager.getInstance().getCustomers();
		updateCustomerDataPanel(resultsCust);
	}
	
	public void createMotorcar(String license, String name, String type, int km, Timestamp nextCheck) {
		long locId = AppManager.getInstance().createId(type, type, type, km, nextCheck, null);
		Location loc = new Location(locId, 0, new Timestamp(System.currentTimeMillis()), "");
		AppManager.getInstance().createMotorcar();
	}
	
	public void updateCarDataPanel(List<Motocar> cars) {
		Object[][] data = new Object[cars.size()][];
		for (int i = 0; i < cars.size(); i++) {
			Motocar car = cars.get(i);
			data[i] = car.getCarData();
		}
		if (cars.isEmpty()) {
			showMessage("keine Fahrzeugdaten vorhanden!");
			return;
		}
		Object[] columnNames = cars.get(0).getCarColumns();
		tableCars = new JTable(data, columnNames) {
			@Override
			public Dimension getPreferredScrollableViewportSize() {
				Dimension d = getPreferredSize();
				int n = getRowHeight();
				return new Dimension(d.width, (n * 7));
			}
		};
		tableCars.setFont(new java.awt.Font("Dialog", Font.BOLD, 12));
		tableCars.setRowHeight(25);

		tableCars.setCellSelectionEnabled(true);
		tableCars.setRowSelectionAllowed(true);
        tableCars.setCellSelectionEnabled(false);
		tableCars.setColumnSelectionAllowed(false);

		ListSelectionModel cellSelectionModel = tableCars.getSelectionModel();
		cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		cellSelectionModel.addListSelectionListener(new CarListSelectionListener(tableCars));

		if (jPanelCars == null) {
			jPanelCars = new JPanel();
			jPanelCars.setLayout(new GridLayout());
			JScrollPane sp = new JScrollPane(tableCars);
			sp.addMouseListener(new PopupMenueListener(CAR));
			sp.getViewport().setBackground(Color.DARK_GRAY);
			jPanelCars.add(sp);

			dataTabs.addTab("Fahrzeuge", jPanelCars);
		} else {
			jPanelCars.removeAll();
			JScrollPane sp = new JScrollPane(tableCars);
			sp.addMouseListener(new PopupMenueListener(CAR));
			sp.getViewport().setBackground(Color.DARK_GRAY);
			jPanelCars.add(sp);
		}

	}
	
	public void updateMap() {
		mapPanel.repaint();
	}
	
	public void selectCarFromMap(String id) {
		for (int i = 0; i < tableCars.getRowCount(); i++) {
			String currId = (String) tableCars.getValueAt(i, 0);
			if (currId.equalsIgnoreCase(id)) {
				tableCars.setRowSelectionInterval(i, i);
			}
		}
	}
	
	public void selectCar(String id) {
		long fzid = Long.parseLong(id);
		AppManager.getInstance().resetSelections();
		Motocar car = AppManager.getInstance().getSpecificCar(fzid);
		if (car != null && car.getMyPoint() != null) {
			car.getMyPoint().setSelected(true);
			updateMap();
		}
	}
	
	public void selectCustomer(String id) {
		long cid = Long.parseLong(id);
		AppManager.getInstance().resetSelections();
		Customer cust = AppManager.getInstance().getSpecificCustomer(cid);
		if (cust != null) {
			updateMap();
		}
	}
	
	public void createCustomer(String name, String vorname, String adresse) {
		AppManager.getInstance().createCustomer(name, vorname, adresse);
	}
	
	public void updateCustomerDataPanel(List<Customer> customers) {
		Object[][] data = new Object[customers.size()][];
		for (int i = 0; i < customers.size(); i++) {
			Customer customer = customers.get(i);
			data[i] = customer.getCustomerData();
		}
		if (!customers.isEmpty()) {
			Object[] columnNames = customers.get(0).getCustomerColumns();
			JTable tableCust = new JTable(data, columnNames) {
				@Override
				public Dimension getPreferredScrollableViewportSize() {
					Dimension d = getPreferredSize();
					int n = getRowHeight();
					return new Dimension(d.width, (n * 7));
				}
			};
			tableCust.setFont(new java.awt.Font("Dialog", Font.BOLD, 12));
			tableCust.setRowHeight(25);

			tableCust.setCellSelectionEnabled(true);
			tableCust.setRowSelectionAllowed(true);
			tableCust.setColumnSelectionAllowed(false);
			tableCust.addMouseListener(new CustomerCellEditListener());

			ListSelectionModel cellSelectionModel = tableCust.getSelectionModel();
			cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			CustomerListSelectionListener listener = new CustomerListSelectionListener(tableCust);
			cellSelectionModel.addListSelectionListener(listener);

			if (jPanelCustomers == null) {
				jPanelCustomers = new JPanel();
				jPanelCustomers.setLayout(new GridLayout());
				JScrollPane sp = new JScrollPane(tableCust);
				sp.addMouseListener(new PopupMenueListener(CUSTOMER));
				sp.getViewport().setBackground(Color.DARK_GRAY);
				jPanelCustomers.add(sp);

				dataTabs.addTab("Kunden", jPanelCustomers);
			} else {
				jPanelCustomers.removeAll();
				JScrollPane sp = new JScrollPane(tableCust);
				sp.addMouseListener(new PopupMenueListener(CUSTOMER));
				sp.getViewport().setBackground(Color.DARK_GRAY);
				jPanelCustomers.add(sp);
			}
		}
	}
	
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	
	
	
}


