package com.carlosbecker.zip.util

import java.io.File
import java.net.URI
import java.nio.file.Path

trait URICreator {
  def createZipURIFor(path: Path): URI = {
    val sb = new StringBuilder()
    sb.append("jar:file:/")
    if (File.separator.equals("/")) sb.append("/")
    sb.append(path.toString().replaceAll("\\\\", "/"))
    URI.create(sb.toString())
  }
}