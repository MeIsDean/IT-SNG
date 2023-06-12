package de.hws.app;

//::TODO:: wird erst auskommentiert, wenn wir das Package view implementieren
//import view.ViewManager;

//import view.dataTable.DataPanel;
//import view.mapView.MapPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import view.MapPanel;
import view.ViewManager;

public class DemoProjekt {

	private JFrame frmDemoProject;
//	::TODO:: siehe oben
	private MapPanel mapPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Runnable start = () -> {
			try {
				DemoProjekt window = new DemoProjekt();
				window.frmDemoProject.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
		EventQueue.invokeLater(start);
	}

	/**
	 * Create the application.
	 */
	public DemoProjekt() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDemoProject = new JFrame();
		frmDemoProject.setFont(new Font("Verdana", Font.BOLD, 14));
		frmDemoProject.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 14));
		frmDemoProject.setTitle("Autovermietung (HWS Project)");
		frmDemoProject.setBounds(100, 100, 1050, 600);
		frmDemoProject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		BufferedImage image = null;
		try {
			image = ImageIO.read(this.getClass().getResource("/hws.png"));
			Image tmp = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
			BufferedImage dimg = new BufferedImage(20, 20, BufferedImage.TYPE_INT_ARGB);

			Graphics2D g2d = dimg.createGraphics();
			g2d.drawImage(tmp, 0, 0, null);
			g2d.dispose();

			frmDemoProject.setIconImage(dimg);

//			::TODO:: siehe oben
			ViewManager.getInstance().setRootPane(frmDemoProject.getContentPane());

			JMenuBar menuBar = new JMenuBar();
			menuBar.setFont(new Font("Verdana", Font.BOLD, 14));
			frmDemoProject.getContentPane().add(menuBar, BorderLayout.NORTH);

			JMenu mnFile = new JMenu("File");
			mnFile.setFont(new Font("Verdana", Font.BOLD, 14));
			mnFile.setPreferredSize(new Dimension(80, 24));
			menuBar.add(mnFile);

			JMenuItem mntmExit = new JMenuItem("Exit");
			mntmExit.addActionListener(e -> System.exit(0));
			mntmExit.setFont(new Font("Verdana", Font.BOLD, 14));
			mnFile.add(mntmExit);

			JMenu mnEdit = new JMenu("Edit");
			mnEdit.setFont(new Font("Verdana", Font.BOLD, 14));
			mnEdit.setPreferredSize(new Dimension(80, 24));
			menuBar.add(mnEdit);

			JMenuItem mntmInsert = new JMenuItem("Insert");
			mntmInsert.setFont(new Font("Verdana", Font.BOLD, 14));
			mnEdit.add(mntmInsert);

			JMenuItem mntmDelete = new JMenuItem("Delete");
			mntmDelete.setFont(new Font("Verdana", Font.BOLD, 14));
			mnEdit.add(mntmDelete);

			JMenu mnAbout = new JMenu("?");
			mnAbout.setFont(new Font("Verdana", Font.BOLD, 14));
			mnAbout.setPreferredSize(new Dimension(80, 24));
			menuBar.add(mnAbout);

			JMenuItem mntmAbout = new JMenuItem("About");
			mntmAbout.setFont(new Font("Verdana", Font.BOLD, 14));
			mnAbout.add(mntmAbout);

			JSplitPane splitPane = new JSplitPane();
			splitPane.setResizeWeight(0.5);
			frmDemoProject.getContentPane().add(splitPane, BorderLayout.CENTER);

//			::TODO:: siehe oben
     		mapPanel = new MapPanel();
			splitPane.setLeftComponent(mapPanel);

			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBackground(Color.GRAY);
			splitPane.setRightComponent(tabbedPane);

//			::TODO:: siehe oben
			ViewManager.getInstance().setPanel(mapPanel, tabbedPane);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
