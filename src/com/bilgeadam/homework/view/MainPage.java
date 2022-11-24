package com.bilgeadam.homework.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;

public class MainPage extends JFrame {
	private JButton btnNewCar;
	private JButton btnCarList;
	private static final long serialVersionUID = 1L;

	public MainPage() {
		initComponents();
	}
	
	private void initComponents() {

		btnCarList = new JButton();
		btnNewCar = new JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		btnCarList.setText("Car List");
		btnCarList.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_dealershipmngActionPerformed(evt);
			}
		});

		btnNewCar.setBackground(new java.awt.Color(255, 255, 102));
		btnNewCar.setText("Add New Car");
		btnNewCar.setToolTipText("");
		btnNewCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btn_carmngActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addContainerGap(84, Short.MAX_VALUE)
								.addComponent(btnCarList, javax.swing.GroupLayout.PREFERRED_SIZE, 239,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(77, 77, 77))
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addContainerGap(83, Short.MAX_VALUE).addComponent(btnNewCar,
								javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(78, 78, 78))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addContainerGap(156, Short.MAX_VALUE)
								.addComponent(btnCarList, javax.swing.GroupLayout.PREFERRED_SIZE, 84,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(60, 60, 60))
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(54, 54, 54)
								.addComponent(btnNewCar, javax.swing.GroupLayout.PREFERRED_SIZE, 84,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(162, Short.MAX_VALUE))));

		pack();
	}

	private void btn_carmngActionPerformed(java.awt.event.ActionEvent evt) {
		setVisible(false);
		AddCarPage carPage = new AddCarPage();
		carPage.setVisible(true);

	}

	private void btn_dealershipmngActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {

		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainPage().setVisible(true);
			}
		});
	}


	

}
