/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgn;

import pgn.Game;

/**
 *
 * @author Tutor
 */
public class GameFactory {

    public static Game createGame(final PGNGameTags tags,
                                  final String gameText,
                                  final String outcome) {
        try {
            return new ValidGame(tags, PGNUtilities.processMoveText(gameText), outcome);
        } catch(final ParsePGNException e) {
            return new InvalidGame(tags, gameText, outcome);
        }
    }
}