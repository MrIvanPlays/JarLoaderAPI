package com.github.mrivanplays.jarloader.api;

/**
 * Simple runtime exception, showing that a file cannot be loaded
 */
public class FileCannotBeLoadedException extends RuntimeException {

  public FileCannotBeLoadedException(String message) {
    super(message);
  }
}
