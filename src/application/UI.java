package application;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

public class UI {
	// variaveis usadas para mudar a cor no terminal
	// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

	public static final String ANSI_RESET = "\u001B[0m";

	public static final String ANSI_GREEN = "\u001B[32m";

	public static final String ANSI_YELLOW = "\u001B[33m";

	public static final String ANSI_PURPLE = "\u001B[35m";

	public static final String ANSI_CYAN = "\u001B[36m";

	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";

	// limpando o terminal
	// https://stackoverflow.com/questions/2979383/java-clear-the-console
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public static ChessPosition readChessPosition(Scanner read) {
		try {
			String s = read.nextLine();
			char colunm = s.charAt(0);
			int row = Integer.parseInt(s.substring(1));
			return new ChessPosition(colunm, row);
		} catch (RuntimeException e) {
			throw new InputMismatchException("Error istantiating ChessPosition. Valid values are from a1 to h8");
		}
	}

	public static void printMatch(ChessMatch chessMatch, List<ChessPiece> captured) {
		printBoard(chessMatch.getPieces());
		System.out.println();
		printCapturedPiece(captured);
		System.out.println("Turn: " + chessMatch.getTurn());

		if (!chessMatch.getCheckMate()) {
			System.out.println("Waiting player: " + chessMatch.getCurrentPlayer());
			if (chessMatch.getCheck()) {
				System.out.println();
				System.out.println("CHECK!");
				System.out.println();
			}
		}else {
			System.out.println("FINISH THE GAME: CHECKMATE!");
			System.out.println("Winner:" + chessMatch.getCurrentPlayer());
		}

	}

	public static void printBoard(ChessPiece[][] piece) {
		for (int i = 0; i < piece.length; i++) {
			
			System.out.print(ANSI_GREEN +(8 - i) + " " + ANSI_RESET);// mostrar o numero das colunas do tabuleiro
			for (int j = 0; j < piece.length; j++) {
				printPiece(piece[i][j], false); // mostra as peças do tabuleiro
			}
			System.out.println();
		}
		System.out.print(ANSI_PURPLE);
		System.out.println("  a b c d e f g h" + ANSI_RESET);
	}

	public static void printBoard(ChessPiece[][] piece, boolean[][] possibleMoves) {
		for (int i = 0; i < piece.length; i++) {
			System.out.print(ANSI_GREEN+(8 - i) + " " + ANSI_RESET);// mostrar o numero das colunas do tabuleiro
			for (int j = 0; j < piece.length; j++) {
				printPiece(piece[i][j], possibleMoves[i][j]); // mostra as peças do tabuleiro
			}
			System.out.println();
		}
		System.out.print(ANSI_PURPLE);
		System.out.println("  a b c d e f g h" + ANSI_RESET);
	}

	private static void printPiece(ChessPiece piece, boolean background) { // mostra as peças
		if (background) {
			System.out.print(ANSI_BLUE_BACKGROUND);
		}
		if (piece == null) {

			System.out.print(ANSI_CYAN +"-" + ANSI_RESET);

		}

		else {
			if (piece.getColor() == Color.WHITE) {
				System.out.print(ANSI_WHITE + piece + ANSI_RESET); // muda a cor das peças para branco
			} else {
				System.out.print(ANSI_YELLOW + piece + ANSI_RESET); // muda a cor das peças para amarelo
			}
		}
		System.out.print(" ");
	}

	public static void printCapturedPiece(List<ChessPiece> captured) {
		List<ChessPiece> white = captured.stream().filter(x -> x.getColor() == Color.WHITE)
				.collect(Collectors.toList());
		List<ChessPiece> black = captured.stream().filter(x -> x.getColor() == Color.BLACK)
				.collect(Collectors.toList());
		System.out.println("Captured pieces: ");
		System.out.print("White: ");
		System.out.print(ANSI_WHITE);
		System.out.println(Arrays.toString(white.toArray()));
		System.out.println(ANSI_RESET);

		System.out.print("Black: ");
		System.out.print(ANSI_YELLOW);
		System.out.println(Arrays.toString(black.toArray()));
		System.out.println(ANSI_RESET);
	}

}
