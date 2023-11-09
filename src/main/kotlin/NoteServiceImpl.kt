class NoteServiceImpl : NoteService {
    private var nextId: Long = 0
    private val notes: MutableList<Note> = ArrayList()

    override fun save(note: Note): Note {
        if (note.id == 0L) {
            val newNote = note.copy(id = nextId++)
            notes.add(newNote)
            return newNote
        }
        val index = notes.indexOfFirst { it.id == note.id }
        if (index < 0) {
            throw IllegalArgumentException("Invalid note id")
        }
        notes[index] = note.copy(createdAt = notes[index].createdAt)
        return notes[index]
    }

    override fun getAll(): List<Note> = notes.toList()

    override fun getAllUniqueTexts(): List<String> = notes.map { it.text }
        .distinct()
        .toList()

    override fun getBefore(count: Int, id: Long): List<Note> = notes.sortedByDescending { it.id }
        .dropWhile { it.id >= id }
        .take(count)

    override fun getAfter(count: Int, id: Long): List<Note> = notes.sortedBy { it.id }
        .dropWhile { it.id <= id }
        .take(count)
}