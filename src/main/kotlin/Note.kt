import java.time.Instant

data class Note(
    val id: Long = 0,
    val text: String = "",
    val createdAt: Instant = Instant.now(),
    val updatedAt: Instant = Instant.now(),
)