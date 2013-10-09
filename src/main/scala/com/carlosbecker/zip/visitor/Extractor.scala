package com.carlosbecker.zip.visitor

import java.nio.file.FileVisitResult
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.attribute.BasicFileAttributes

class Extractor(target: String, rootPath: String) extends FileVisitor(rootPath) {
  def this(target: Path, rootPath: Path) = this(target.toString(), rootPath.toString())

  def getFSPathFor(path: Path) = Paths.get(target, removeRootPath(path))

  override def visitFile(file: Path, attrs: BasicFileAttributes) = {
    Files.copy(file, getFSPathFor(file), COPY_OPTION)
    FileVisitResult.CONTINUE
  }

  override def preVisitDirectory(dir: Path, attrs: BasicFileAttributes) = {
    Files.createDirectories(getFSPathFor(dir))
    FileVisitResult.CONTINUE
  }
}