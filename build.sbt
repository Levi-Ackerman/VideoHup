name := """VidepVideoHup"""
organization := "com.lizheng"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.8"

libraryDependencies += filters

libraryDependencies ++= Seq(
  "org.jsoup" % "jsoup" % "1.10.2",
  "io.reactivex.rxjava2" % "rxjava" % "2.0.8")