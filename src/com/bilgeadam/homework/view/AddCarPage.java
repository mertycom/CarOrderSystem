package com.bilgeadam.homework.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import com.bilgeadam.homework.dao.CarDAO;
import com.bilgeadam.homework.model.Body;
import com.bilgeadam.homework.model.Brand;
import com.bilgeadam.homework.model.Car;
import com.bilgeadam.homework.model.Door;
import com.bilgeadam.homework.model.Model;
import com.bilgeadam.homework.model.Window;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddCarPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textBrand;
	private JLabel lblBrand;
	private JTextField textModel;
	private JTextField textDoor;
	private JLabel lblWindow;
	private JTextField textWindow;
	private JLabel lblWindow_1;
	private JLabel lblPrice;
	private JTextField textPrice;
	@SuppressWarnings("rawtypes")
	private JComboBox cboxBody;
	private Brand brand;
	private Door door;
	private Window window;
	private Model model;
	private Body body;
	private Car car;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCarPage frame = new AddCarPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddCarPage() {
		initComponents();
	}
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textBrand = new JTextField();
		
		textBrand.setColumns(10);
		textBrand.setBounds(135, 20, 96, 20);
		contentPane.add(textBrand);
		
		lblBrand = new JLabel("Brand :");
		lblBrand.setBounds(30, 24, 66, 14);
		contentPane.add(lblBrand);
		
		JLabel lblModel = new JLabel("Model :");
		lblModel.setBounds(30, 64, 66, 14);
		contentPane.add(lblModel);
		
		textModel = new JTextField();
		textModel.setColumns(10);
		textModel.setBounds(135, 60, 96, 20);
		contentPane.add(textModel);
		
		JLabel lblDoor = new JLabel("Door :");
		lblDoor.setBounds(30, 104, 66, 14);
		contentPane.add(lblDoor);
		
		textDoor = new JTextField();
		textDoor.setColumns(10);
		textDoor.setBounds(135, 100, 96, 20);
		contentPane.add(textDoor);
		
		lblWindow = new JLabel("Window :");
		lblWindow.setBounds(30, 144, 66, 14);
		contentPane.add(lblWindow);
		
		textWindow = new JTextField();
		textWindow.setColumns(10);
		textWindow.setBounds(135, 140, 96, 20);
		contentPane.add(textWindow);
		
		
		lblPrice = new JLabel("Price :");
		lblPrice.setBounds(30, 224, 66, 14);
		contentPane.add(lblPrice);
		
		textPrice = new JTextField();
		textPrice.setColumns(10);
		textPrice.setBounds(135, 220, 96, 20);
		contentPane.add(textPrice);
		
		lblWindow_1 = new JLabel("Body :");
		lblWindow_1.setBounds(30, 184, 66, 14);
		contentPane.add(lblWindow_1);
		
		cboxBody = new JComboBox();
		cboxBody.setModel(new DefaultComboBoxModel(new String[] {"Choose", "Sedan", "Station", "Hatchback"}));
		cboxBody.setBounds(135, 180, 96, 18);
		contentPane.add(cboxBody);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarDAO carDao = new CarDAO();
				car = new Car();
				
				brand = new Brand();
				brand.setBrandName(textBrand.getText());
				car.setBrand(brand);
				
				door = new Door();
				door.setPiece(Integer.valueOf(textDoor.getText()));
				
				body = new Body();
				body.setType(cboxBody.getSelectedItem().toString());
				body.setDoor(door);
				
				window = new Window();
				window.setNumber(Integer.valueOf(textWindow.getText()));
				body.setWindow(window);
				car.setBody(body);
				
				model = new Model();
				model.setModelName(textModel.getText());
				car.setModel(model);
				car.setPrice(Integer.valueOf(textPrice.getText()));
				
				carDao.insert(car);
				
			}
		});
		btnNewButton.setBounds(48, 260, 116, 50);
		contentPane.add(btnNewButton);
		
		JButton btnCnacel = new JButton("CANCEL");
		btnCnacel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MainPage carPage = new MainPage();
				carPage.setVisible(true);
			}
		});
		btnCnacel.setBounds(208, 260, 116, 50);
		contentPane.add(btnCnacel);
	}
	
}
