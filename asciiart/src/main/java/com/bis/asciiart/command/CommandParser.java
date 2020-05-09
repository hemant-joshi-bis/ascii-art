package com.bis.asciiart.command;

import java.util.Optional;

/**
 * Generic Command parser and validation interface
 *
 * @param <T> Line, Rect or Canvas commands
 */
public interface CommandParser<T> {

    Optional<T> fetchCommandArguments(final String data);

    Boolean validate(final String data);
}
