/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine.player.ai;

import engine.board.Board;
import engine.board.Move;


/**
 *
 * @author Tutor
 */
public interface MoveStrategy {

    long getNumBoardsEvaluated();

    Move execute(Board board);

}
