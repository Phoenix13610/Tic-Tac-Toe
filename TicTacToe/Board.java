package TicTacToe;

public class Board {
	private char[][] board;

	public Board() {
		board = new char[3][3];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = ' ';
			}
		}
	}

	public boolean placePlayer(Point p, char player) throws ArrayIndexOutOfBoundsException {
		if (board[p.x()][p.y()] == ' ') {
			board[p.x()][p.y()] = player;
			return true;
		} else {
			return false;
		}
	}
	public void print() {
		System.out.println("    1   2   3 ");
		System.out.println("1   " + board[0][0] + "   " + board[0][1] + "   " + board[0][2]);
		System.out.println("   ___|___|___");
		System.out.println("2   " + board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
		System.out.println("   ___|___|___");
		System.out.println("3   " + board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
		System.out.println();
	}
	public char[][] getBoard(){
		return board;
	}
	public char checkWin() {
		char win = ' ';
		char temp='x';
		for(int l=0;l<2;l++) {
			for (int i = 0; i < board.length; i++) {
				if ((board[i][0] == board[i][1]) && (board[i][1] == board[i][2]) && (board[i][0] != ' ')&&(board[i][0]==temp)) {
					win = temp;
				} else if ((board[0][i] == board[1][i]) && (board[1][i] == board[2][i]) && (board[0][i] != ' ')&&(board[0][i]==temp)) {
					win = temp;
				}
			}
			if ((board[0][0] == board[1][1]) && (board[1][1] == board[2][2]) && (board[0][0] != ' ')&&(board[0][0]==temp)) {
				win = temp;
			} else if ((board[0][2] == board[1][1]) && (board[1][1] == board[2][0]) && (board[0][2] != ' ')&&(board[0][2]==temp)) {
				win = temp;
			}
			if((win==' ')&&(checkTie())) {
				win='t';
			}
			temp='o';
		}
		return win;
	}
	public boolean posOccupied(Point p) {
		if(board[p.x()][p.y()]==' ') {
			return false;
		}else {
			return true;
		}
	}
	protected boolean checkTie() {
		boolean result=true;
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				if(board[i][j]==' ') {
					result=false;
				}
			}
		}
		return result;
	}
}
