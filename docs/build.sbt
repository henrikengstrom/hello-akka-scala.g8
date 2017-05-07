// Uses the out of the box generic theme.
paradoxTheme := Some(builtinParadoxTheme("generic"))

scalaVersion := "2.11.8"

paradoxProperties in Compile ++= Map(
  "snip.g8src.base_dir" -> "../../../../src/main/g8/src/main/",
  "snip.g8srctest.base_dir" -> "../../../../src/main/g8/src/test/",
  "snip.raw.base_dir" -> "../snip/"
)
