package TicTacToe;

import java.util.Scanner;

public class TicTacToe3 {
	static Player[]players=new Player[2];
	static Board b=new Board();
	static Scanner sc=new Scanner(System.in);

	public static void main(String[]args) {
		char win=' ';
		
		enterNumPlayers();
		
		System.out.println("Do you wan't to start?");
		String line=sc.nextLine();
		if(line.equals("no")) {
			Player temp=players[0];
			players[0]=players[1];
			players[1]=temp;
		}
		int turn=0;
		do {
			
			turn(b,turn);
			
			turn++;
			if(turn==players.length){
				turn=0;
			}
			win=b.checkWin();
			System.out.println(win);
		}while(win==' ');
		b.print();
		if(win!='t') {
			System.out.println("The "+win+" wins");
		}else {
			System.out.println("Tie");
		}
		sc.close();
	}
	public static void turn(Board b,int turn) {
		boolean placed=false;
		do {
			b.print();
			if(players[turn].getType()==Player.PlayerType.Pc) {
				placed=b.placePlayer(players[turn].giveCoor(b), players[turn].getSymbol());
			}else if(players[turn].getType()==Player.PlayerType.Comp){
				if(players[turn].giveCoor(b)!=null) {
					placed=b.placePlayer(players[turn].giveCoor(b), players[turn].getSymbol());
				}else {
					placed=true;
				}
			}
			if(!placed) {
				System.out.println("Enter a unused spot.");
			}
		}while(!placed);
	}
	public static Point enterCoor() {
		System.out.println("Enter the coordinates of the placement. Left coordinate first, then top");
		int x=sc.nextInt();
		int y=sc.nextInt();
		return new Point(x-1,y-1);
	}
	public static void enterNumPlayers() {
		System.out.println("Enter the number of players");
		boolean nbPlayer=false;
		int player=1;
		do {
			player=sc.nextInt();
			sc.nextLine();
			if(player==0) {
				players[0]=new Comp(Player.Symbol.x);
				players[1]=new Comp(Player.Symbol.o);
			}
			else if(player==1) {
				players[0]=new PC(Player.Symbol.x,sc);
				players[1]=new Comp(Player.Symbol.o);
			}else if(player==2) {
				players[0]=new PC(Player.Symbol.x,sc);
				players[1]=new PC(Player.Symbol.o,sc);
			}else {
				nbPlayer=true;
				System.err.println("enter a number between 1 and 2");
			}
		}while(nbPlayer);
	}
}
