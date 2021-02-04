package com.example.observer;

import java.util.ArrayList;



public class AppMain  {
	public static void main(String[] args) {
		TangSeng tangSeng = new TangSeng();

		WuKong wuKong = new WuKong();
		tangSeng.register(wuKong);

		BaJie baJie = new BaJie();
		tangSeng.register(baJie);

		ShaSeng shaSeng = new ShaSeng();
		tangSeng.register(shaSeng);
		

		ArrayList<String> list = tangSeng.help();
		System.out.println(list.toString());
	}

	

}
