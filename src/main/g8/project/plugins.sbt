resolvers ++= Seq(
  "sbt-idea-repo" at "http://mpeltonen.github.com/maven/",
  "Web plugin repo" at "http://siasia.github.com/maven2"
)

resolvers += Resolver.url("Typesafe repository", url("http://typesafe.artifactoryonline.com/typesafe/ivy-releases/"))(Resolver.defaultIvyPatterns)

libraryDependencies <+= sbtVersion(v => "com.github.siasia" %% "xsbt-web-plugin" % (v+"-$xsbt_web_version$"))

libraryDependencies <+= sbtVersion(v => "com.github.siasia" %% "xsbt-proguard-plugin" % (v+"-$xsbt_proguard_version$"))

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "$sbt_assembly_version$")

addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "$sbteclipse_version$")

addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "$sbtidea_version$")

