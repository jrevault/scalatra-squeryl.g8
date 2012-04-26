name := "$name$"

organization := "$com.example.app$"

version := "$version$"

scalaVersion := "$scala_version$"

libraryDependencies ++= Seq(
  "ch.qos.logback" % "logback-classic" % "1.0.0" % "runtime",
  "com.codahale" %% "jerkson" % "$jerkson_version$",
  "commons-dbcp" % "commons-dbcp" % "1.4",
  "javax.servlet" % "servlet-api" % "2.5" % "provided",
  "joda-time" % "joda-time" % "1.6.2",
  "org.eclipse.jetty" % "jetty-webapp" % "7.6.0.v20120127" % "container",
  "org.scalatra" %% "scalatra" % "$scalatra_version$",
  "org.scalatra" %% "scalatra-scalate" % "$scalatra_version$",
  "org.scalatra" %% "scalatra-specs2" % "$scalatra_version$" % "test",
  "org.specs2" %% "specs2" % "$specs2_version$" % "test",
  "org.squeryl" %% "squeryl" % "$squeryl_version$",
  // ***************************************
  // **** SQL Drivers
  "com.h2database" % "h2" % "1.3.165",
  "mysql" % "mysql-connector-java" % "5.1.18",
  "postgresql" % "postgresql" % "9.1-901.jdbc4",
  "net.sourceforge.jtds" % "jtds" % "1.2.4",
  "org.apache.derby" % "derby" % "10.8.2.2"
  // ***************************************
)

resolvers ++= Seq(
  "Sonatype OSS" at "http://oss.sonatype.org/content/repositories/releases/",
  "Sonatype OSS Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/",
  "Download Java.NET" at "http://download.java.net/maven/2/",
  "Web plugin repo" at "http://siasia.github.com/maven2",
  "repo.novus rels" at "http://repo.novus.com/releases/",
  "repo.novus snaps" at "http://repo.novus.com/snapshots/",
  "Coda Hale's Repository" at "http://repo.codahale.com/",
  "sbt-idea-repo" at "http://mpeltonen.github.com/maven/"
)

seq(com.github.siasia.WebPlugin.webSettings :_*)

seq(ProguardPlugin.proguardSettings :_*)
