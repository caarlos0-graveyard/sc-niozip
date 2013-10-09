package com.carlosbecker.zip.util

import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path

trait PathChecker {
  def checkPathsExists(paths: List[Path]) = {
    paths.foreach(path => {
      checkPathExists(path)
    })
  }

  def checkPathExists(path: Path) = {
    if (!Files.exists(path))
      throw new IOException("Path " + path.toString()
        + " does not exist.");
  }
}