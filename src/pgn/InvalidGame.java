package pgn;

import pgn.Game;
import pgn.PGNGameTags;
import java.util.Collections;

public class InvalidGame extends Game {

    final String malformedGameText;

    public InvalidGame(final PGNGameTags tags,
                       final String malformedGameText,
                       final String outcome) {
        super(tags, Collections.<String>emptyList(), outcome);
        this.malformedGameText = malformedGameText;
    }

    @Override
    public String toString() {
        return "Invalid Game " + this.tags;
    }

    @Override
    public boolean isValid() {
        return false;
    }
}