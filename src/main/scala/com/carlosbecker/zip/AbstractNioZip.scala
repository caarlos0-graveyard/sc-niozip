package com.carlosbecker.zip

import java.io.File
import java.nio.file.Path
import java.nio.file.Paths

abstract class AbstractNioZip {
  def zip(source: Path, target: Path): Any
  def unzip(source: Path, target: Path): Any

  def zip(source: String, target: String): Any = zip(Paths.get(source), Paths.get(target))
  def unzip(source: String, target: String): Any = unzip(Paths.get(source), Paths.get(target))

  def zip(source: File, target: File): Any = zip(source.toPath(), target.toPath())
  def unzip(source: File, target: File): Any = unzip(source.toPath(), target.toPath())
}