package com.carlosbecker.zip

import java.io.File
import java.nio.file.Path
import java.nio.file.Paths

/** Defines the methods of the NioZip implementation. */
abstract class AbstractNioZip {
  /**
   * Creates a zip file from a file or folder.
   *
   * @param source: path to the where the zip is stored
   * @param target: file or folder where the zip file should be extracted
   */
  def zip(source: Path, target: Path): Any

  /**
   * Decompress a zip file to a folder.
   *
   * @param source: file or folder to be compressed
   * @param targte: path to the where the zip should be stored (the zip file itself)
   */
  def unzip(source: Path, target: Path): Any

  /**
   * Creates a zip file from a file or folder.
   *
   * @param source: path to the where the zip is stored
   * @param target: file or folder where the zip file should be extracted
   */
  def zip(source: String, target: String): Any = zip(Paths.get(source), Paths.get(target))

  /**
   * Decompress a zip file to a folder.
   *
   * @param source: file or folder to be compressed
   * @param targte: path to the where the zip should be stored (the zip file itself)
   */
  def unzip(source: String, target: String): Any = unzip(Paths.get(source), Paths.get(target))

  /**
   * Creates a zip file from a file or folder.
   *
   * @param source: path to the where the zip is stored
   * @param target: file or folder where the zip file should be extracted
   */
  def zip(source: File, target: File): Any = zip(source.toPath(), target.toPath())

  /**
   * Decompress a zip file to a folder.
   *
   * @param source: file or folder to be compressed
   * @param targte: path to the where the zip should be stored (the zip file itself)
   */
  def unzip(source: File, target: File): Any = unzip(source.toPath(), target.toPath())
}