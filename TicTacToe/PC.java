package TicTacToe;

import java.util.Scanner;

public class PC extends Player {
	protected Scanner sc;
	public PC(Symbol c,Scanner sc) {
		super(c);
		pl=PlayerType.Pc;
		this.sc=sc;
	}
	@Override
	public Point giveCoor(Board b) {
		int x=sc.nextInt();
		int y=sc.nextInt();
		return new Point(x-1,y-1);
	}
	
}
