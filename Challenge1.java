package com.technoelevate.Challenges;

import java.util.Scanner;

public class Challenge1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter minutes");
		int minutes=sc.nextInt();
		System.out.println("Enter seconds");
		int seconds = sc.nextInt();
		System.out.println("Enter secs");
		int secs=sc.nextInt();
		System.out.println(getDurationString(minutes,seconds));
		getDurationString(secs);
	}

	public static String getDurationString(int min, int sec) {
		if(min>=0 && (sec>=0 && sec<=59)) {
			int hour=0;
			int minutes=0;
			int seconds=sec;
			hour=min/60;
			minutes=min%60;
			return hour+"HH"+" : "+minutes+"MM"+" : "+sec+"SS";
		}else {
			return "Invalid Value";
		}
	}
	
	public static void getDurationString(int sec) {
		if(sec>=0) {
			int minutes;
			int seconds;
			minutes=sec/60;
			seconds=sec%60;
			System.out.println(getDurationString(minutes,seconds));
		}else {
			System.out.println("Invalid Value");
		}
	}
}
