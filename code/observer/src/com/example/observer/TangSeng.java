package com.example.observer;

import java.util.ArrayList;

//目标
public class TangSeng {
	ArrayList<Observer> list = new ArrayList<Observer>();

	public void register(Observer observer) {
		list.add(observer);
	}

	public ArrayList<String> help() {
		ArrayList<String> listString = new ArrayList<String>();
		for (Observer observer : list) {
			String str = observer.save();
			listString.add(str);
		}
		return listString;
	}
}
