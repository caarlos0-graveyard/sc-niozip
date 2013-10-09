package com.carlosbecker.zip.visitor

import java.nio.file.FileSystem
import java.nio.file.FileVisitResult
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.attribute.BasicFileAttributes

class Compressor(fileSystem: FileSystem, rootPath: String) extends FileVisitor(rootPath) {
  def this(fileSystem: FileSystem, rootPath: Path) = this(fileSystem, rootPath.toString())

  def getFSPathFor(path: Path) = fileSystem.getPath(removeRootPath(path))

  override def visitFile(file: Path, attrs: BasicFileAttributes) = {
    Files.copy(file, getFSPathFor(file), COPY_OPTION)
    FileVisitResult.CONTINUE
  }

  override def preVisitDirectory(dir: Path, attrs: BasicFileAttributes) = {
    val fsPath = getFSPathFor(dir)
    if (!fsPath.toString().trim().isEmpty()) Files.createDirectories(fsPath)
    FileVisitResult.CONTINUE
  }
}