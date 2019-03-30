package chess;

import boardGame.Board;
import boardGame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	private Board board;
	
	public ChessMatch() {
		board = new Board(8, 8); //define o tamanho de um tabuleiro em um jogo
		initialSetup(); // quando o jogo iniciar vai ser definido as peças existentes
	}
	
	public ChessPiece[][] getPieces(){ //passa para o objeto 'mat' as peças existentes no tabuleiro
		ChessPiece[][] mat= new ChessPiece[board.getRows()][board.getColunms()];
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColunms(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i,j);
			}
		}
		return mat;
	}
	private void initialSetup() { // define a posição inicial das peças no tabuleiro
		board.placePiece(new Rook(board, Color.WHITE), new Position(0, 0));
		board.placePiece(new King(board, Color.WHITE), new Position(0, 4));

	}
}
