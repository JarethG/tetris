// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.tetris.moves;

import swen221.tetris.logic.Board;
import swen221.tetris.logic.Rectangle;
import swen221.tetris.tetromino.Tetromino;

/**
 * Provides some mechanisms which are common across all moves.
 *
 * @author David J. Pearce
 * @author Marco Servetto
 *
 */
public abstract class AbstractMove implements Move {

	@Override
	public boolean isValid(Board board) {
		if(board.getActiveTetromino()==null)return false;
		
		Board testBoard = this.apply(board);
		if (testBoard.getActiveTetromino().getBoundingBox().getMinX()<0
				||testBoard.getActiveTetromino().getBoundingBox().getMaxX()>=board.getWidth())
			return false;
		if ( testBoard.canPlaceTetromino(testBoard.getActiveTetromino()))return true;
		
		
		// NOTE: to check whether move is valid or not, you can employ Move.apply() to
		// compute the new board and then check whether the active tetromino is in a
		// valid position.
		return false;
	}
	

}
