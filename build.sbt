ThisBuild / scalaVersion := "2.13.1"
ThisBuild / organization := "eu.healey_core"
ThisBuild / version := "0.0.1"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.1" % "test"

artifactName := { (sv: ScalaVersion, module: ModuleID, artifact: Artifact) =>
  artifact.name + "-" + module.revision + "." + artifact.extension
}

lazy val root = (project in file("."))
  .settings(
    name := "Tropicompta",
  )