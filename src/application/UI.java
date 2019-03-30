package application;

import chess.ChessPiece;

public class UI {
	public static void printBoard(ChessPiece[][] piece) {
		for (int i = 0; i < piece.length; i++) {
			System.out.print((8-i));//mostrar o numero das colunas do tabuleiro
			for (int j = 0; j < piece.length; j++) {
				System.out.print(" ");
				printPiece(piece[i][j]); //mostra as peças do tabuleiro
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}
	
	private static void printPiece(ChessPiece piece) { //mostra as peças
		if (piece == null) {
			System.out.print("-");
		} else {
			System.out.print(piece);
		}
	}
}
