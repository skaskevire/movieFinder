package com.epam.movieFinder;

public class Main {
	public static void main(String[] args) {
		if(args.length == 0)
		{
			System.out.println("You must specify path to file with movies");
			return;
		}
		new Launcher().run(args[0]);
	}	
}
