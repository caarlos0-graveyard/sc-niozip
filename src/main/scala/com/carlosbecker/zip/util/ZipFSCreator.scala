package com.carlosbecker.zip.util

import java.nio.file.FileSystem
import java.nio.file.FileSystems
import java.nio.file.Path

import scala.collection.JavaConverters.mapAsJavaMapConverter
import scala.collection.immutable.HashMap

/** Creates Zip FileSystem's with the correct environment. */
trait ZipFSCreator extends URICreator {

  /** Creates a ZipFileSystem and return it. */
  def createZipFS(source: Path, create: Boolean): FileSystem = {
    val uri = createZipURIFor(source)
    val env = HashMap("encoding" -> "UTF-8", "create" -> create.toString)
    FileSystems.newFileSystem(uri, env.toMap.asJava);
  }
}