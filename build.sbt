import sbt.Keys._

lazy val appName = "test-java-play"
lazy val appVersion = "1.0-SNAPSHOT"

lazy val commonSettings = Seq(
  organization := "com.example",
  name := appName,
  version := appVersion,
  scalaVersion := "2.11.6"
)

lazy val spockTestDependencies = Seq(
  "org.spockframework" % "spock-core" % "1.0-groovy-2.4" % Test,
  "org.codehaus.groovy" % "groovy-all" % "2.1.3" % Test
)
lazy val spec2TestDependencies = Seq(
  "org.specs2" %% "specs2-core" % "3.7" % Test,
  "org.specs2" %% "specs2-junit" % "3.7" % Test,
  "org.specs2" %% "specs2-mock" % "3.7" % Test
//  "org.mockito" % "mockito-core" % "1.10.19" % Test
)

lazy val root = (project in file("."))
  .enablePlugins(PlayJava, PlayEbean)
  .settings(commonSettings: _*)
  .settings(
    libraryDependencies ++= Seq(
      cache,
      javaWs,
      "org.apache.commons" % "commons-lang3" % "3.4",
      "mysql" % "mysql-connector-java" % "5.1.38",
      "org.projectlombok" % "lombok" % "1.16.6"
    ) ++ spockTestDependencies ++ spec2TestDependencies
  )

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
