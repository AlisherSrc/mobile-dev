// 5. Classes and objects (Object/Singleton)
object SpaceAgency {
    // 2. List, Set, and Map
    private val celestialBodies = mutableListOf<CelestialBody>()
    private val discoveredGalaxies = mutableSetOf<String>()
    
    // Maps a classification type name to a list of bodies of that type
    private val bodiesByClass = mutableMapOf<String, MutableList<CelestialBody>>()

    fun addBody(body: CelestialBody) {
        celestialBodies.add(body)
        val className = body.classification::class.simpleName ?: "Unknown"
        bodiesByClass.computeIfAbsent(className) { mutableListOf() }.add(body)
    }

    fun addGalaxy(name: String) {
        discoveredGalaxies.add(name)
    }

    // 4. Higher-order functions and lambdas
    fun processBodies(action: (CelestialBody) -> Unit) {
        for (body in celestialBodies) {
            action(body)
        }
    }

    fun getHabitablePlanets(): List<Planet> {
        // 3. Collection operations (filter, map)
        return celestialBodies
            .filterIsInstance<Planet>() // filter
            .filter { it.isHabitable }
    }

    fun calculateTotalMass(): Double {
        // 3. Collection operations (reduce or sumOf)
        // Here we use map and reduce to explicitly demonstrate both
        if (celestialBodies.isEmpty()) return 0.0
        return celestialBodies
            .map { it.mass }
            .reduce { acc, mass -> acc + mass }
    }

    fun displayAgencyStatus() {
        println("\n--- Space Agency Status ---")
        println("Discovered Galaxies: $discoveredGalaxies")
        println("Total Bodies Tracked: ${celestialBodies.size}")
        
        // 1. Loops and Map iteration
        for ((className, bodies) in bodiesByClass) {
            println(" - $className: ${bodies.size} bodies")
        }
        println("---------------------------\n")
    }
}
