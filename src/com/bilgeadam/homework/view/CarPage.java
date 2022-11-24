package com.bilgeadam.homework.view;


import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;


public class CarPage extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	DefaultTableModel model;

	public CarPage() {
		initComponents();
		model = (DefaultTableModel) tbl_car.getModel();
		getCars();
	}

	public void getCars() {
		model.setRowCount(0);
		List<Car> carList = RepoManager.carList;
		if (carList != null) {
			for (Car car : carList) {
				Object[] array = { car.getId(), car.getBrand(), car.getModel(), car.getModelYear(),
						car.getDealershipId() };
				model.addRow(array);
			}
		}
	}


	@SuppressWarnings({ "unchecked", "serial" })
	private void initComponents() {

		jScrollPane1 = new JScrollPane();
		tbl_car = new JTable();
		btn_addcar = new JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		tbl_car.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Id", "Brand", "Model", "Year", "Dealership Id" }) {
			Class[] types = new Class[] { java.lang.Long.class, java.lang.String.class, java.lang.String.class,
					java.lang.String.class, java.lang.Long.class };
			boolean[] canEdit = new boolean[] { false, false, false, false, false };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		tbl_car.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tbl_carMouseClicked(evt);
			}
		});
		jScrollPane1.setViewportView(tbl_car);
		if (tbl_car.getColumnModel().getColumnCount() > 0) {
			tbl_car.getColumnModel().getColumn(0).setResizable(false);
			tbl_car.getColumnModel().getColumn(1).setResizable(false);
			tbl_car.getColumnModel().getColumn(2).setResizable(false);
			tbl_car.getColumnModel().getColumn(3).setResizable(false);
			tbl_car.getColumnModel().getColumn(4).setResizable(false);
		}

		btn_addcar.setText("Cancel");
		btn_addcar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_addcarActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup()
					.addGap(45)
					.addComponent(btn_addcar, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(61, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btn_addcar, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
		);
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void tbl_carMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tbl_carMouseClicked
		// TODO add your handling code here:
		int selectedRow = tbl_car.getSelectedRow();

	}// GEN-LAST:event_tbl_carMouseClicked

	private void btn_addcarActionPerformed(java.awt.event.ActionEvent evt) {
		setVisible(false);
		//AddCarPage();
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(CarPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(CarPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(CarPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(CarPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new CarPage().setVisible(true);
			}
		});
	}

	private JButton btn_addcar;
	private JScrollPane jScrollPane1;
	private JTable tbl_car;
}
