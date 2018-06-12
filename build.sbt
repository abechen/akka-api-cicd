name := "akka-api"

version := "0.1.0"

scalaVersion := "2.11.8"

target in assembly := file(s"target/${sys.env.get("APP_NAME").getOrElse("target")}")
assemblyJarName in assembly := "akka-api-cicd.jar"


libraryDependencies ++= {
  Seq(
    "org.apache.logging.log4j" % "log4j-core" % "2.11.0",
    "org.apache.logging.log4j" % "log4j-api" % "2.11.0",
    "com.typesafe.akka" %% "akka-actor" % "2.5.11",
    "com.typesafe.akka" %% "akka-stream" % "2.5.11",
    "com.typesafe.akka" %% "akka-http" % "10.1.1",
    "com.typesafe.akka" %% "akka-http-spray-json" % "10.1.1"
  )
}

enablePlugins(JavaAppPackaging)