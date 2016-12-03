AKKA APP
========

This helps in kickstart the development with Akka-http/Scala. This includes various sample apps which can be read to understand the various implementations.

BUILD
======

Akka apps can be built very easily using *Build Tool for Scala (SBT)* which is similar to ANT, MAVEN or GRADLE.

Create a new file build.sbt in your project directory. The following is the minimal script that can be put in to build.sbt.

val akkaHttp = "com.typesafe.akka" %% "akka-http-spray-json-experimental" % "2.4.8"

```scala
lazy val commonSettings = Seq(
  organization := "com.example",
  version := "0.1.0",
  scalaVersion := "2.11.7"
)

lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    name := "SimpleWebService",     // Name of the project directory
    libraryDependencies += akkaHttp // External lib dependency
  )
```
