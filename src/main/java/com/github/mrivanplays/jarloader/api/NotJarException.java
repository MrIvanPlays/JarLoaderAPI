package com.github.mrivanplays.jarloader.api;

/**
 * Simple runtime exception, showing that a file is not a jar
 */
public class NotJarException extends RuntimeException {

  public NotJarException(String message) {
    super(message);
  }
}
