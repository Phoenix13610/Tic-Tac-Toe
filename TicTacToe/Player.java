package TicTacToe;

public abstract class Player {
	public enum Symbol{x,o}
	public enum PlayerType{Comp,Pc}
	protected Symbol sym;
	protected PlayerType pl;
	public Player(Symbol c) {
		sym=c;
	}
	public char getSymbol() {
		if(sym==Symbol.x) {
			return 'x';
		}
		else {
			return 'o';
		}
	}
	public PlayerType getType() {
		return pl;
	}
	public Point giveCoor(Board b) {
		return null;
	}
}
