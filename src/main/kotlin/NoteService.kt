import java.time.Instant

class NoteService {
    private var note: Note = Note()

    fun getNote(): Note = note

    fun updateText(newText: String) {
        note = note.copy(text = newText, updatedAt = Instant.now())
    }
}