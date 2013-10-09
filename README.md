# sc-niozip

A very simple API that I wrote to study some Scala.

## What is this?

This is a simple project that aims to provide a simple way to zip and unzip
files and folders using the Java NIO API.

## Usage

The API itself is pretty simple and have basically two methods that you need
to know:

```scala
NioZip.zip("/origin", "/destiny.zip")
NioZip.unzip("/origin.zip", "/destiny")
```

The parameters could be `String`s, `java.nio.files.Path`s or `java.ioFile`s.
