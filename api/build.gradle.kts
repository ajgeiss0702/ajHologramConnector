plugins {
    id("java")
}

group = "us.ajg0702.hologram"
version = parent!!.version

repositories {
    mavenCentral()
    maven { url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots/") }
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")

    compileOnly("org.spigotmc:spigot-api:1.19-R0.1-SNAPSHOT")


    compileOnly("net.kyori:adventure-api:4.11.0")
    compileOnly("net.kyori:adventure-platform-bukkit:4.1.1")
    compileOnly("net.kyori:adventure-text-serializer-plain:4.11.0")

}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}