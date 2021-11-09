
sealed class Target(
    val id: String,
    val websiteBaseUrl: String
) {
    companion object {
        fun byId(arg: String): Target = when (arg) {
            LocalTarget.id -> LocalTarget
            RemoteTarget.id -> RemoteTarget
            else -> throw IllegalArgumentException("Unknown target: '$arg'!")
        }
    }
}

object LocalTarget : Target(
    id = "local",
    websiteBaseUrl = "http://localhost",
) {
    @Suppress("MayBeConstant") // used in build.gradle.kts
    const val localWebRoot = "/Users/cpickl/Sites/psywiki"

    //    val localWebRoot = "/Library/WebServer/Documents/"
    override fun toString(): String = javaClass.simpleName
}

object RemoteTarget : Target(
    id = "remote",
    websiteBaseUrl = "http://psywiki.scienceontheweb.net",
)
