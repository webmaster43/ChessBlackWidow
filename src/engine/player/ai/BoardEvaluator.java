/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine.player.ai;

import engine.board.Board;

/**
 *
 * @author Tutor
 */

public interface BoardEvaluator {

    int evaluate(Board board, int depth);

}