enablePlugins(JmhPlugin)

scalaVersion := "2.12-SNAPSHOT"
scalaHome := Some(file("../build/pack"))
scalacOptions += "-opt:inline-global"

unmanagedBase := file("../build/pack/lib")
