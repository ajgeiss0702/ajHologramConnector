rootProject.name = "ajHologramConnector"
include("api")
include("implementations:bukkit")
include("implementations:DecentHolograms")
findProject(":implementations:DecentHolograms")?.name = "DecentHolograms"
