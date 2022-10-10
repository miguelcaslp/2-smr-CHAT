package controller;

import Dao.UsersDao;

public class UsersRemoveController extends Thread {
	UsersDao us = new UsersDao();
	public void run () {
		while(2>1) {
			try {
				Thread.sleep(60000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			us.rmUsersForTime();
		}
	}

}
