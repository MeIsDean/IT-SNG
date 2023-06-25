package view.dataTable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

import view.dataTable.*;


public class PopupMenueListener extends MouseAdapter {

	private int type;

	public PopupMenueListener(int t) {
		type = t;
	}

	private class PopUpNewDialog extends JPopupMenu {
		JMenuItem anItem;

		public PopUpNewDialog() {
			anItem = new JMenuItem("+ Insert a new Item");
			anItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					try {
						NewItemDialogFrame dialog = new NewItemDialogFrame(type);
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			add(anItem);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Mouse pressed");
		if (SwingUtilities.isRightMouseButton(e) == true) {
			PopUpNewDialog menu = new PopUpNewDialog();
			menu.show(e.getComponent(), e.getX(), e.getY());
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Mouse pressed");
		if (e.isPopupTrigger()) {
			PopUpNewDialog menu = new PopUpNewDialog();
			menu.show(e.getComponent(), e.getX(), e.getY());
		}
	}

}
