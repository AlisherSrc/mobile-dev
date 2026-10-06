// 8. Data class
data class Coordinates(val x: Double, val y: Double, val z: Double)

// 9. Sealed class
sealed class BodyClassification {
    object MainSequence : BodyClassification()
    object RedGiant : BodyClassification()
    object WhiteDwarf : BodyClassification()
    object Terrestrial : BodyClassification()
    object GasGiant : BodyClassification()
    data class Unknown(val description: String) : BodyClassification()
}

// 7. Interfaces
interface Scannable {
    fun generateScanReport(): String
}

// 6. Inheritance (Base class)
abstract class CelestialBody(
    val id: String,
    val name: String,
    val mass: Double,
    val coordinates: Coordinates,
    val classification: BodyClassification
) : Scannable {
    
    // 7. Polymorphism (abstract method implemented differently by subclasses)
    abstract fun displayDetails()
}

// 6. Inheritance (Derived class)
class Planet(
    id: String,
    name: String,
    mass: Double,
    coordinates: Coordinates,
    classification: BodyClassification,
    val isHabitable: Boolean,
    val hasAtmosphere: Boolean
) : CelestialBody(id, name, mass, coordinates, classification) {

    override fun displayDetails() {
        println("Planet [$name] - Mass: $mass, Habitable: $isHabitable, Class: ${classification::class.simpleName}")
    }

    override fun generateScanReport(): String {
        return "Planet Scan: $name at ${coordinates}. Atmosphere detected: $hasAtmosphere"
    }
}

// 6. Inheritance (Derived class)
class Star(
    id: String,
    name: String,
    mass: Double,
    coordinates: Coordinates,
    classification: BodyClassification,
    val luminosity: Double
) : CelestialBody(id, name, mass, coordinates, classification) {

    override fun displayDetails() {
        println("Star [$name] - Mass: $mass, Luminosity: $luminosity, Class: ${classification::class.simpleName}")
    }

    override fun generateScanReport(): String {
        return "Star Scan: $name at ${coordinates}. Extreme heat signatures detected."
    }
}
