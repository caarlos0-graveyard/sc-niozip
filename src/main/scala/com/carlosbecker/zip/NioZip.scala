package com.carlosbecker.zip

import java.nio.file.Files
import java.nio.file.Path

import com.carlosbecker.zip.util.PathChecker
import com.carlosbecker.zip.util.ZipFS
import com.carlosbecker.zip.visitor.Compressor
import com.carlosbecker.zip.visitor.Extractor

object NioZip extends AbstractNioZip with ZipFS with PathChecker {
  override def zip(source: Path, target: Path) = {
    checkPathExists(source)
    withZipFS(target, true) { fs =>
      Files.walkFileTree(source, new Compressor(fs, source))
    }
  }

  override def unzip(source: Path, target: Path) = {
    checkPathExists(source)
    Files.createDirectories(target)
    withZipFS(source, false) { fs =>
      val visitor = new Extractor(target, source.getParent())
      Files.walkFileTree(fs.getPath("/"), visitor)
    }
  }
}