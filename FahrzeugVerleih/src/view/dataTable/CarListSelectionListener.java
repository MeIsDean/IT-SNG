package view.dataTable;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import view.ViewManager;

public class CarListSelectionListener implements ListSelectionListener {

	private JTable table;

	public CarListSelectionListener(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			String selectedData = null;
			String selectedId = null;

			int[] selectedRow = table.getSelectedRows();
			int[] selectedColumns = table.getSelectedColumns();

			for (int i = 0; i < selectedRow.length; i++) {
				for (int j = 0; j < selectedColumns.length; j++) {
					selectedData = (String) table.getValueAt(selectedRow[i], selectedColumns[j]);
				}
				selectedId = (String) table.getValueAt(selectedRow[i], 0);
			}
			System.out.println("Selected data: " + selectedData+"  id: "+selectedId);
			ViewManager.getInstance().selectCar(selectedId);
		}

	}
}
