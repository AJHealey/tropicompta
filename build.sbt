ThisBuild / scalaVersion := "2.13.1"
ThisBuild / organization := "eu.healey_core"
ThisBuild / version := "0.0.1-SNAPSHOT"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.1" % "test"

lazy val root = (project in file("."))
  .settings(
    name := "Tropicompta",
  )