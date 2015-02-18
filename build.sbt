enablePlugins(JavaAppPackaging)

name := "places-manageer"

version := "1.0.0"

scalaVersion := "2.11.5"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= {
  val akkaV       = "2.3.9"
  val akkaStreamV = "1.0-M3"
  val scalaTestV  = "2.2.1"
  val slickPgV = "0.8.1"
  Seq(
    "com.typesafe.akka" %% "akka-actor"                        % akkaV,
    "com.typesafe.akka" %% "akka-stream-experimental"          % akkaStreamV,
    "com.typesafe.akka" %% "akka-http-core-experimental"       % akkaStreamV,
    "com.typesafe.akka" %% "akka-http-experimental"            % akkaStreamV,
    "com.typesafe.akka" %% "akka-http-spray-json-experimental" % akkaStreamV,
    "com.typesafe.akka" %% "akka-http-testkit-experimental"    % akkaStreamV,
    "org.postgresql" % "postgresql" % "9.3-1100-jdbc41",
    "com.github.tminglei" %% "slick-pg" % slickPgV,
    "com.github.tminglei" %% "slick-pg_joda-time" % "0.6.5.3",
    "com.github.tminglei" %% "slick-pg_jts" % "0.6.5.3",
    "joda-time" % "joda-time" % "2.3",
    "org.joda" % "joda-convert" % "1.5",
    "com.vividsolutions" % "jts" % "1.13"
  )
}

Revolver.settings

