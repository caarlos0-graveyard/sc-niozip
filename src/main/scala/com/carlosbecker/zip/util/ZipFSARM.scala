package com.carlosbecker.zip.util

import java.nio.file.FileSystem
import java.nio.file.Path

/** ZipFS Automatic Resource Management. */
trait ZipFSARM extends ARM with ZipFSCreator {

  /** Creates a zip with the given path and env and ran the given block with it. */
  def withZipFS(zip: Path, create: Boolean)(f: FileSystem => Any) = {
    using(createZipFS(zip, create)) { fs =>
      f(fs)
    }
  }
}