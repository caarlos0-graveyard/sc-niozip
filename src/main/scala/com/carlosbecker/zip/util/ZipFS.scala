package com.carlosbecker.zip.util

import java.nio.file.FileSystem
import java.nio.file.Path

trait ZipFS extends ARM with ZipFSCreator {
  def withZipFS(zip: Path, create: Boolean)(f: FileSystem => Any) = {
    using(createZipFS(zip, create)) { fs =>
      f(fs)
    }
  }
}