package com.carlosbecker.zip.util

trait ARM {
  def using[X <: { def close() }, A](resource: X)(f: X => A) = {
    try {
      f(resource)
    } finally {
      resource.close()
    }
  }
}