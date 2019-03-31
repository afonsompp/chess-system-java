package chess;

import boardGame.Position;

public class ChessPosition {
	
	private char colunm;
	private int row;
	public ChessPosition(char colunm, int row) {
		if (colunm < 'a' && colunm > 'h' && row < 1 && row > 8) {
			throw new ChessException("Error istantiating ChessPosition. Valid values are from a1 to h8.");
		}
		this.colunm = colunm;
		this.row = row;
	}
	public char getColunm() {
		return colunm;
	}
	
	public int getRow() {
		return row;
	}
	
	protected Position toPosition() { // passa as posições no formato padrado letra linha para o position
		return new Position(8- row, colunm - 'a');
	}
	
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition ((char)('a' - position.getColumn()), 8 - position.getRow());
	}
	
	@Override
	public String toString() {
		return "" + colunm + row;
	}
}
