package boardGame;

public class Board {
	private int rows;
	private int colunms;
	private Piece[][] pieces;

	public Board(int rows, int colunms) {
		if (rows < 1 || colunms < 1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 colunm");
		}
		this.rows = rows;
		this.colunms = colunms;
		pieces = new Piece[rows][colunms];
	}

	public int getRows() {
		return rows;
	}

	public int getColunms() {
		return colunms;
	}

	public Piece piece(int row, int colunm) {
		if (!positionExists(row,colunm)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[row][colunm];
	}

	public Piece piece(Position position) { // uma pe�a no tabuleiro
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}

	public void placePiece(Piece piece, Position position) { // define o espe�o que uma pe�a vai ocupar no tabuleiro
		if (thereIsAPiece(position)) {
			throw new BoardException("There is  already a piece on position "+ position);
		}
		pieces[position.getRow()][position.getColumn()] = piece; //define a linha e a coluna que a pe�a est�
		piece.position = position; // passa a posi��o para o atributo position
	}
	
	public Piece removePiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		if (piece(position) == null) {
			return null;
		}
		
		Piece aux = piece(position);
		aux.position = null; //deixa nulo o atributo position
		pieces[position.getRow()][position.getColumn()] = null; // deixa nulo a pe�a na posi��o que for passada como parametro
		return aux;
	}
	
	public boolean positionExists(int row, int colunm) { // verifica se uma posi��o existe em um tabuleiro de xadrez
		return row >=0 && row <= rows && colunm >= 0 && colunm <= colunms; 
	}

	public boolean positionExists(Position position) { // verifica a posi��o existe usando o metodo de cima
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPiece(Position position) { //verifica se h� uma pe�a na posi��o
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return piece(position) != null; //se a pe�a na posi��o passada for diferente de nulo h� uma pe�a
	}
}
