package TicTacToe;

import java.util.Random;

public class Comp extends Player {
	Random r=new Random();
	public Comp(Symbol c) {
		super(c);
		pl = PlayerType.Comp;
	}

	@Override
	public Point giveCoor(Board b) {
		Point p=null;
		int move=1;
		for(int i=0;i<b.getBoard().length;i++) {
			for(int j=0;j<b.getBoard()[i].length;j++) {
				if(b.getBoard()[i][j]!=' ') {
					move++;
				}
			}
		}
		if(checkNextMoveWin(b)) {
			p=getMoveWin(b);
		}else {
			if(move==1) {
				p=new Point(0,0);
			}else if(move==2) {
				if(b.posOccupied(new Point(0,0))||b.posOccupied(new Point(2,2))||b.posOccupied(new Point(0,2))||b.posOccupied(new Point(2,0))) {
					p=new Point(1,1);
				}else {
					p=new Point(0,0);
				}
			}else if(move==3) {
				if(b.posOccupied(new Point(1,1))) {
					p=new Point(2,2);
				}else {
					if(b.posOccupied(new Point(0,1))||b.posOccupied(new Point(0,2))||b.posOccupied(new Point(1,2))||b.posOccupied(new Point(2,2))) {
						p=new Point(2,0);
					}else if(b.posOccupied(new Point(1,0))||b.posOccupied(new Point(2,0))||b.posOccupied(new Point(2,1))) {
						p=new Point(0,2);
					}
				}
			}else if(move==4) {
				if(b.posOccupied(new Point(2,2))||b.posOccupied(new Point(2,1))) {
					p=new Point(1,0);
				}else if(b.posOccupied(new Point(1,0))) {
					p=new Point(1,0);
				}else {
					p=new Point(2,2);
				}
			}else {
				boolean loop=true;
				do {
					loop=b.placePlayer(new Point(r.nextInt(2),r.nextInt(2)), getSymbol());
				}while(loop);
			}
		}
		return p;
	}
	protected Point getMoveWin(Board b) {
		char[][] board = b.getBoard();
		Point p = null;
		boolean alrPlaced = false;
		if (checkNextMoveWin(b)) {
			char sym=getSymbol();
			if(sym=='o') {
				sym='x';
			}else if(sym=='x') {
				sym='o';
			}
			for(int l=0;l<2;l++) {
				for (int i = 0; i < board.length; i++) {
					if ((board[i][0] == board[i][1]) && (board[i][0] == sym) && (board[i][2] == ' ')) {
						alrPlaced = true;
						p = new Point(i, 2);
					} else if ((board[i][1] == board[i][2]) && (board[i][1] == sym) && (board[i][0] == ' ')) {
						alrPlaced = true;
						p = new Point(i, 0);
					} else if ((board[i][0] == board[i][2]) && (board[i][0] == sym) && (board[i][1] == ' ')) {
						alrPlaced = true;
						p = new Point(i, 1);
					} 
					else if ((board[0][i] == board[1][i]) && (board[0][i] == sym) && (board[2][i] == ' ')) {
						alrPlaced = true;
						p = new Point(2, i);
					} else if ((board[2][i] == board[1][i]) && (board[2][i] == sym) && (board[0][i] == ' ')) {
						alrPlaced = true;
						p = new Point(0, i);
					}else if((board[0][i] == board[2][i]) && (board[0][i] == sym) && (board[1][i] == ' ')) {
						alrPlaced = true;
						p=new Point(1,i);
					}
				}
				if(!alrPlaced){
					if((board[0][0] == board[1][1]) && (board[0][0] == sym) && (board[2][2] == ' ')) {
						p=new Point(2,2);
					}else if((board[0][0] == board[2][2]) && (board[0][0] == sym) && (board[1][1] == ' ')) {
						p=new Point(1,1);
					}else if((board[1][1] == board[2][2]) && (board[1][1] == sym) && (board[0][0] == ' ')) {
						p=new Point(0,0);
					}else if((board[0][2] == board[2][0]) && (board[0][2] == sym) && (board[1][1] == ' ')) {
						p=new Point(1,1);
					}else if((board[0][2] == board[1][1]) && (board[0][2] == sym) && (board[2][0] == ' ')) {
						p=new Point(2,0);
					}else if((board[1][1] == board[2][0]) && (board[1][1] == sym) && (board[0][2] == ' ')) {
						p=new Point(0,2);
					}
				}
				if(sym=='o') {
					sym='x';
				}else if(sym=='x') {
					sym='o';
				}
			}
		}

		return p;
	}
	public boolean checkNextMoveWin(Board b) {
		char[][] board = b.getBoard();
		boolean toMove = false;
		for (int i = 0; i < board.length; i++) {
			if (((board[i][0] == board[i][1]) && (board[i][0] != ' ') && (board[i][2] == ' '))
					|| ((board[i][0] == board[i][2]) && (board[i][0] != ' ') && (board[i][1] == ' '))
					|| ((board[i][1] == board[i][2]) && (board[i][1] != ' ') && (board[i][0] == ' '))) {
				toMove = true;
			} else if (((board[0][i] == board[1][i]) && (board[0][i] != ' ') && (board[2][i] == ' '))
					|| ((board[2][i] == board[1][i]) && (board[2][i] != ' ') && (board[0][i] == ' '))
					|| ((board[0][i] == board[2][i]) && (board[0][i] != ' ') && (board[1][i] == ' '))) {
				toMove = true;
			}
		}
		if ((((board[0][0] == board[1][1]) && (board[0][0] != ' ') && (board[2][2] == ' '))
					|| ((board[0][0] == board[2][2]) && (board[0][0] != ' ') && (board[1][1] == ' '))
					|| ((board[1][1] == board[2][2]) && (board[1][1] != ' ') && (board[0][0] == ' ')))
				|| (((board[0][2] == board[1][1]) && (board[0][2] != ' ') && (board[2][0] == ' '))
						|| ((board[0][2] == board[2][0]) && (board[0][2] != ' ') && (board[1][1] == ' '))
						|| ((board[1][1] == board[2][0]) && (board[1][1] != ' ') && (board[0][2] == ' ')))) {
			toMove = true;
		}
		return toMove;
	}
}
