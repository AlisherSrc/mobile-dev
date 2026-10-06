import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

// 10. Suspend function and simple coroutine
suspend fun deepSpaceScan(sectorName: String): CelestialBody {
    println("Initializing deep space scan of sector $sectorName...")
    
    // Simulate long-running operation
    for (i in 1..3) {
        delay(500) // suspend function
        println("Scanning... ($i/3)")
    }
    
    println("Anomaly detected! Parsing data...")
    delay(500)
    
    return Planet(
        id = "P-999",
        name = "Kepler-New",
        mass = 5.4,
        coordinates = Coordinates(99.1, 45.2, -12.3),
        classification = BodyClassification.Terrestrial,
        isHabitable = true,
        hasAtmosphere = true
    )
}

fun main() {
    println("Starting Space Classification System...\n")

    // 1. Variables and data types
    val initialGalaxy = "Milky Way"
    SpaceAgency.addGalaxy(initialGalaxy)
    SpaceAgency.addGalaxy("Andromeda")
    SpaceAgency.addGalaxy("Milky Way") // Set will ignore this duplicate

    val earth = Planet("P-001", "Earth", 1.0, Coordinates(0.0, 0.0, 0.0), BodyClassification.Terrestrial, true, true)
    val mars = Planet("P-002", "Mars", 0.1, Coordinates(1.5, 0.2, -0.1), BodyClassification.Terrestrial, false, true)
    val jupiter = Planet("P-003", "Jupiter", 317.8, Coordinates(5.2, 0.0, 0.0), BodyClassification.GasGiant, false, true)
    val sun = Star("S-001", "Sol", 333000.0, Coordinates(0.0, 0.0, 0.0), BodyClassification.MainSequence, 1.0)
    
    SpaceAgency.addBody(earth)
    SpaceAgency.addBody(mars)
    SpaceAgency.addBody(jupiter)
    SpaceAgency.addBody(sun)

    // Using higher-order function to display all
    println("--- All Discovered Bodies ---")
    SpaceAgency.processBodies { body -> 
        // 7. Polymorphism - displayDetails behaves differently for Planet and Star
        body.displayDetails() 
    }

    // 1. Conditions and loops demonstrated inside SpaceAgency methods
    SpaceAgency.displayAgencyStatus()

    println("--- Habitable Planets ---")
    val habitablePlanets = SpaceAgency.getHabitablePlanets()
    habitablePlanets.forEach { println(it.name) }

    println("\n--- System Mass ---")
    val totalMass = SpaceAgency.calculateTotalMass()
    println("Total Mass of known bodies: $totalMass Earth masses\n")

    // 7. Interfaces - calling generateScanReport on Scannable objects
    println("--- Scan Reports ---")
    println(earth.generateScanReport())
    println(sun.generateScanReport())
    println()

    // 10. Coroutine execution
    runBlocking {
        // Run a suspend function within a coroutine
        val newBody = deepSpaceScan("Sector 7G")
        SpaceAgency.addBody(newBody)
        println("\nScan complete. Added new body: ${newBody.name}")
    }

    SpaceAgency.displayAgencyStatus()
}
