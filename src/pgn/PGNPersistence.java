/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgn;

import engine.board.Board;
import engine.board.Move;
import engine.player.Player;



/**
 *
 * @author Tutor
 */
//import com.chess..classic.board.Board;
//import com.chess..classic.board.Move;
//import com.chess..classic.player.Player;

public interface PGNPersistence {

    void persistGame(Game game);

    Move getNextBestMove(Board board, Player player, String gameText);

}
