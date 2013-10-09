package com.carlosbecker.zip.util

import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path

/** Checks if paths really exist in the FileSystem. */
trait PathChecker {
  /** Checks for a list of paths. */
  def checkPathsExists(paths: List[Path]) = {
    paths.foreach(path => checkPathExists(path))
  }

  /** Checks for a path. */
  def checkPathExists(path: Path) = {
    if (!Files.exists(path))
      throw new IOException("Path " + path.toString()
        + " does not exist.");
  }
}