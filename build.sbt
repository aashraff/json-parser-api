
name := """json-parser-api"""
organization := "org.au.fin"

version := "1.0"

lazy val root = (project in file(".")).enablePlugins(PlayScala, SwaggerPlugin)

scalaVersion := "2.13.5"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test
libraryDependencies += "org.julienrf" %% "play-json-derived-codecs" % "10.0.1"

libraryDependencies ++= Seq(
  "com.pauldijou" %% "jwt-play" % "5.0.0",
  "com.pauldijou" %% "jwt-core" % "5.0.0",
  "com.auth0" % "jwks-rsa" % "0.18.0"
)
libraryDependencies += "org.webjars" % "swagger-ui" % "3.49.0"


enablePlugins(JavaAppPackaging)
enablePlugins(DockerPlugin)
enablePlugins(AshScriptPlugin)
swaggerDomainNameSpaces := Seq("models")
// mainClass in Compile := Some("App")
dockerBaseImage      := "openjdk:jre-alpine"
