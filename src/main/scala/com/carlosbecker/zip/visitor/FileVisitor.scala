package com.carlosbecker.zip.visitor

import java.nio.file.Path
import java.nio.file.SimpleFileVisitor
import java.nio.file.StandardCopyOption

import com.carlosbecker.zip.util.RootPathRemover

/** The FileVisitor base. */
abstract class FileVisitor(rootPath: String) extends SimpleFileVisitor[Path] with RootPathRemover {
  /** Our defalt copy_option, which is replace existing. */
  val COPY_OPTION = StandardCopyOption.REPLACE_EXISTING

  def getRootPath(): String = rootPath
  
  /** Removes the rootPath from the given path */
  def removeRootPath(path: String): String = removeRootPath(rootPath, path)
  
  /** Removes the rootPath from the given path*/
  def removeRootPath(path: Path): String = removeRootPath(path.toString())
}