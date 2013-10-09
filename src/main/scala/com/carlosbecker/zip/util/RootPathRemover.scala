package com.carlosbecker.zip.util

import java.nio.file.Files
import java.nio.file.Paths

trait RootPathRemover {
  def removeRootPath(root: String, path: String): String = {
    val rootIsFile = !Files.isDirectory(Paths.get(root))
    return if (rootIsFile && path.equals(root))
      path.replace(Paths.get(path).getParent().toString(), "")
    else
      path.replace(root, "")
  }
}