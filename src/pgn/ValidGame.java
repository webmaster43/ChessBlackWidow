/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgn;

/**
 *
 * @author Tutor
 */
import java.util.List;

public class ValidGame
        extends Game {

    public ValidGame(final PGNGameTags tags,
                     List<String> moves,
                     final String outcome) {
        super(tags, moves, outcome);
    }

    @Override
    public boolean isValid() {
        return true;
    }

}
