name := "api"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator

// dist into appspec
mappings in Universal ++= {
  Seq(
    baseDirectory(_ / "appspec.yml").value -> "appspec.yml"
  )
}
