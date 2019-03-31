package chess;

import boardGame.Board;
import boardGame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	private Board board;
	
	public ChessMatch() {
		board = new Board(8, 8); //define o tamanho de um tabuleiro em um jogo
		initialSetup(); // quando o jogo iniciar vai ser definido as pe�as existentes
	}
	
	public ChessPiece[][] getPieces(){ //passa para o objeto 'mat' as pe�as existentes no tabuleiro
		ChessPiece[][] mat= new ChessPiece[board.getRows()][board.getColunms()];
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColunms(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i,j);
			}
		}
		return mat;
	}
	
	private void placeNewPiece(char colunm, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(colunm, row).toPosition());
	}
	
	private void initialSetup() { // define a posi��o inicial das pe�as no tabuleiro
		placeNewPiece('a', 8, new Rook(board, Color.WHITE));
		placeNewPiece('e', 8, new King(board, Color.WHITE));

	}
}
