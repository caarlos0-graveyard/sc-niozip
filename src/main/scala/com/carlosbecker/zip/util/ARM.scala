package com.carlosbecker.zip.util

/** Provides some Automatic Resource Management */
trait ARM {
  /** try-finally with closing the given resource. */
  def using[X <: { def close() }, A](resource: X)(f: X => A) = {
    try {
      f(resource)
    } finally {
      resource.close()
    }
  }
}