package com.bilgeadam.homework;

import com.bilgeadam.homework.util.CommonData;
import com.bilgeadam.homework.view.AddCarPage;

public class CarManagment {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Wrong number of arguments. Expected <<<1>>> actual <<<" + args.length + ">>>");
			System.exit(100);
		}
		CommonData.getInstance().setPropertiesFile(args[0]);
		CommonData.getInstance().info("Car Managment System");
		
		AddCarPage.main(args);
	}
}