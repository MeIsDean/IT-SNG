package de.hws.app;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import de.hws.data.Customer;
import de.hws.data.Location;
import de.hws.data.Motocar;
import view.ViewManager;

public class AppManager implements Serializable {

	private static AppManager instance;
	private List<Motocar> allCars = new ArrayList<Motocar>();
	private List<Customer> allCustomers = new ArrayList<Customer>();

	private AppManager() {

	}

	public static AppManager getInstance() {

		if (instance == null) {
			instance = new AppManager();
		}
		return null;

	}

	public long createId(String license, String name, String type, int km, Timestamp nextCheck, Location loc) {
		return 0;

	}

	public void createMotorcar() {

	}

	public void deleteCar(String license) {

	}

	private void writeCarsToFile(String filePath) {
		try {
			FileOutputStream fos = new FileOutputStream(filepath);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(allCars);
			oos.close();
		} catch (IOException ex) {
			ViewManager.getInstance().showMessage(ex.getLocalizedMessage());
		}
	}

	private void readCarsFromFile(String filePath) {
		try {
		FileInputStream fis = new FileInputStream(String filePath);
		ObjectInputStream ois = new ObjectInputStream(fis);
		allCars = (ArrayList<Motocar>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
		e.printStackTrace();
		}
		}

	private void exportCarsToFile(String filePath) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try {
			gson.toJson(allCars, new FileWriter(filePath));
		} catch (JsonIOException | IOException ex) {
			e.printStackTrace();
		}
	}

	private List<Motocar> importCarsFromFile(String filepath) {
		return null;

	}

	private void writeCustomersToFile(String filepath, List<Motocar> cars) {
		try {
			FileOutputStream fos = new FileOutputStream(filepath);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(allCustomers);
			oos.close();
		} catch (IOException e) {
			ViewManager.getInstance().showMessage(e.getLocalizedMessage());
		}
	}

	private void readCustomersFromFile(String filepath) {
		try {
			FileInputStream fis = new FileInputStream(filepath);
			ObjectInputStream ois = new ObjectInputStream(fis);
			allCustomers = (ArrayList<Customer>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void exportCustomersToFile(String filepath) {

	}

	private List<Customer> importCustomersFromFile(String filePath) {
		allCustomers = new ArrayList<Customer>();
		try {
			String resJSon = "";
			InputStreamReader reader = new InputStreamReader(new FileInputStream(filePath), "UTF-8");
			int data = reader.read();
			while (data != -1) {
				resJSon += (char) data;
				data = reader.read();
			}
			reader.close();
			JsonParser parser = new JsonParser();
			JsonElement tree = parser.parse(resJSon);
			JsonObject dataSet = tree.getAsJsonObject();
			JsonElement elem = dataSet.get("customers");
			if (elem.isJsonArray()) {
				JsonArray datArr = elem.getAsJsonArray();
				for (int i = 0; i < datArr.size(); i++) {
					JsonObject obj = datArr.get(i).getAsJsonObject();
					// mit obj.get("item").toString() erhält man den Wert des Attributs als String
					// mit Long.parseLong(String) kann kann den String in einen long-Wert umwandeln
					// analog mit Double.parseDouble oder Integer.parseInt
					/*
					 * Mit SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd",
					 * Locale.GERMAN); String checkStr = obj.get("dateItem").toString(); checkStr =
					 * checkStr.substring(1, checkStr.length()-1); Date nextcheck =
					 * formatter.parse(checkStr);
					 */
					// neues Objekt erzeugen und initialisieren, jeweils Customer bzw. Motorcar
					allCustomers.add(temp);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return allCustomers;
	}

	public void readData() {

	}

	public void saveData() {

	}

	public void importData() {

	}

	public void exportData() {
		exportCarsToFile("./CarsDump.json");
		exportCustomersToFile("./CustomersDump.json");
	}

	public List<Motocar> getCars() {
		return null;
	}

	public List<Customer> getCustomers() {
		return null;
	}

	public Motocar getSpecificCar(long id) {
		return null;

	}

	public void resetSelections() {

	}

	public void createCustomer(String name, String vorname, String adresse) {

	}

	public void deleteCustomer(int cld) {

	}

	public List<Customer> getCustomer() {
		return null;

	}

	public Customer getSpecificCustomer(long id) {
		return null;

	}

}
