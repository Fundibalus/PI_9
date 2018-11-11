/*
Namen: Marlon Prantner und Daniel Hoffmann
Matrikelnummern: 1634875 und 1634900
Tutor: Jannis Knof
Aufgabe: 3
Uebungsblatt: 09
Datum: 06.11.2018
*/
package ma.uni.pi1.snakearena.snakes;

import java.awt.Color;
import java.rmi.server.ServerNotActiveException;
import java.util.ArrayList;

import ma.uni.pi1.snakearena.BoardDTO;
import ma.uni.pi1.snakearena.Field;
import ma.uni.pi1.snakearena.Snake;
import ma.uni.pi1.snakearena.Snake2Arena;
import ma.uni.pi1.snakearena.SnakeDTO;

/**
 * Class representing your intelligent snake.
 * 
 * Change ClassName to your favorite.
 * 
 * @author <your Names>
 *
 */
public class MySnake extends Snake {
	
	public MySnake(Snake2Arena game) {
		super(game);
		// Aufgabe c) Change name and color.		
		this.name = "NoPainHarold";
		this.color= new Color(163, 48, 75); // RGB colors are available, e.g. ..= new Color(123,56,222); etc.
	}

	// ------------------------------------------------------------------
	
	/**
	 * Main function for every intelligence.
	 * Gets a cop of the whole board with every information necessary.
	 * Returns a direction in which the snake should move.
	 */
	@Override
	public int think(BoardDTO board) {

		// Aufgabe c


		return getDirection(board,getNearestApple(board),getHead()); // or Snake.Down, or Snake.Right or Snake.Left.
	}

	
	// Aufgabe a)
	private Field getNearestApple(BoardDTO board) {
		int ownX = this.getHead().posX;
		int ownY = this.getHead().posY;
		board.getApples();
		int schritte = 400;
		int derIndex = 0;

		for (int index = 0; index < board.getApples().size(); index++) {
			int jetzigeSchritte = 0;
			int appleX = board.getApples().get(index).posX;
			int appleY = board.getApples().get(index).posY;
			if (ownX > appleX) {
				jetzigeSchritte += (ownX - appleX);
			} else {
				jetzigeSchritte += (appleX - ownX);
			}
			if (ownY > appleY) {
				jetzigeSchritte += (ownY - appleY);
			} else {
				jetzigeSchritte += (appleY - ownY);
			}
			if (jetzigeSchritte < schritte) {
				schritte = jetzigeSchritte;
				derIndex = index;

			}


		}

		Field nearestApple = board.getApples().get(derIndex);
		return nearestApple;


	}


	// Aufgabe b)
	private int getDirection(BoardDTO board, Field apple, Field head) {
		int ownX = head.posX;
		int ownY = head.posY;
		int appleX = apple.posX;
		int appleY = apple.posY;
		if (ownY > appleY && board.fields[ownX][ownY-1].isEmpty()) {
			return Snake.UP;
		} else if(appleY > ownY && board.fields[ownX][ownY+1].isEmpty()) {
			return Snake.DOWN;
		}
		if (ownX > appleX && board.fields[ownX-1][ownY].isEmpty()) {
return Snake.LEFT;
		} else if(appleX > ownX && board.fields[ownX+1][ownY].isEmpty()){
return Snake.RIGHT;
		}




		return 0;
	}
	
}
