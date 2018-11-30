// The simplest possible sbt build file is just one line:

scalaVersion := "2.12.7"
// That is, to create a valid sbt build, all you've got to do is define the
// version of Scala you'd like your project to use.

// ============================================================================


name := "goos-sniper"
organization := "ch.epfl.scala"
version := "1.0"


libraryDependencies += "org.typelevel" %% "cats-core" % "1.4.0"
libraryDependencies += "junit" % "junit" % "4.12" % "test"
libraryDependencies += "org.hamcrest" % "hamcrest-all" % "1.3"
libraryDependencies += "com.googlecode.windowlicker" % "windowlicker-swing" % "r268"
