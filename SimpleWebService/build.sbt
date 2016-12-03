val akkaHttp = "com.typesafe.akka" %% "akka-http-spray-json-experimental" % "2.4.8"

lazy val commonSettings = Seq(
  organization := "com.example",
  version := "0.1.0",
  scalaVersion := "2.11.7"
)

lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    name := "SimpleWebService",
    libraryDependencies += akkaHttp
  )
