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
import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

public class PGNGameTags {

    private final Map<String,String> gameTags;

    private PGNGameTags(final TagsBuilder builder) {
        this.gameTags = ImmutableMap.copyOf(builder.gameTags);
    }

    @Override
    public String toString() {
        return this.gameTags.toString();
    }

    public static class TagsBuilder {

        final Map<String,String> gameTags;

        public TagsBuilder() {
            this.gameTags = new HashMap<>();
        }

        public TagsBuilder addTag(final String tagKey,
                                  final String tagValue) {
            this.gameTags.put(tagKey, tagValue);
            return this;
        }

        public PGNGameTags build() {
            return new PGNGameTags(this);
        }

    }

}
