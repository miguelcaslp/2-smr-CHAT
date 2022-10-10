package controller;

import Dao.UsersDao;

public class userUpdateController extends Thread {
	UsersDao us = new UsersDao();
	
	public void run () {
		while(2>1) {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			us.TimeUpdate();
		}
	}
}
