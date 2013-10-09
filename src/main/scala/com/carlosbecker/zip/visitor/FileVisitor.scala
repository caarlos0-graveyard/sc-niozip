package com.carlosbecker.zip.visitor

import java.nio.file.Path
import java.nio.file.SimpleFileVisitor
import java.nio.file.StandardCopyOption

import com.carlosbecker.zip.util.RootPathRemover

abstract class FileVisitor(rootPath: String) extends SimpleFileVisitor[Path] with RootPathRemover {
  val COPY_OPTION = StandardCopyOption.REPLACE_EXISTING

  def getRootPath(): String = rootPath
  def removeRootPath(path: String): String = removeRootPath(rootPath, path)
  def removeRootPath(path: Path): String = removeRootPath(path.toString())
}