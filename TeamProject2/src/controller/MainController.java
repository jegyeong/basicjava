package controller;

import service.MainService;
import database.Database;

public class MainController {

	public static void main(String[] args) {
		Database db = Database.getInstance();
		MainService ms = MainService.getInstance();
		db.settingStart();
		ms.showMenus();
	}

	
	
	
	

}
