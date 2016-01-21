import play.ebean.sbt.PlayEbean
import play.ebean.sbt.PlayEbean.autoImport._
import play.sbt.PlayJava
import sbt.Keys._
import sbt._

trait PlayTestCommon extends Build {
  // リリースする場合はバージョンを変えること
  lazy val _version = "1.0.0"

  // published dependency version
  lazy val _scalaVersion = "2.11.6"

  // internal only
  lazy val _specs2Version = "3.7"

  // common settings
  lazy val commonSettings = Seq(
    version := _version,
    scalaVersion := _scalaVersion,
    resolvers ++= _resolvers
  )

  lazy val core = (project in file("modules/core"))
    .enablePlugins(PlayEbean)
    .settings(commonSettings: _*)
    .settings(
      libraryDependencies ++= Seq(
        "mysql" % "mysql-connector-java" % "5.1.38"
      ) ++ commonLibraryDependencies ++ libraryDependenciesInTestScope
    )
    .settings(
      javaOptions in Test += "-Dconfig.file=application.conf"
    )
    .settings(
      playEbeanModels in Compile := Seq("yamaza520.models.*")
    )

  val commonLibraryDependencies = Seq(
    "org.apache.commons" % "commons-lang3" % "3.4",
    "org.projectlombok" % "lombok" % "1.16.6"
  )

  val apiLibraryDependencies = Seq(
  )

  val batchLibraryDependencies = Seq(
  )

  // test scope library
  val libraryDependenciesInTestScope = Seq(
    "org.specs2" %% "specs2-core"  % _specs2Version % Test,
    "org.specs2" %% "specs2-junit" % _specs2Version % Test,
    "org.specs2" %% "specs2-mock"  % _specs2Version % Test
  )

  // other settings
  val _resolvers = Seq(
    "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"
  )
}

object PlayTestProject extends PlayTestCommon {
  // project settings
  lazy val root = (project in file("."))
    .dependsOn(api, core)
    .aggregate(api, core)
    .settings(commonSettings: _*)

  lazy val api = (project in file("modules/api"))
    .enablePlugins(PlayJava)
    .dependsOn(core % "test->test;compile->compile")
    .settings(commonSettings: _*)
    .settings(
      libraryDependencies ++= libraryDependenciesInTestScope ++ apiLibraryDependencies
    )
}
