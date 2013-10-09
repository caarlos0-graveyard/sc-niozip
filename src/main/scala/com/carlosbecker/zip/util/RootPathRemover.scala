package com.carlosbecker.zip.util

import java.nio.file.Files
import java.nio.file.Paths

/** Full of responsabilities: Knows wether or not to remove the root path and removes it. */
trait RootPathRemover {

  /** Removes the rootPath when needed. */
  def removeRootPath(root: String, path: String): String = {
    val rootIsFile: Boolean = !Files.isDirectory(Paths.get(root))
    if (rootIsFile && path.equals(root))
      path.replace(Paths.get(path).getParent().toString(), "")
    else
      path.replace(root, "")
  }
}