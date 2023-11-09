fun main() {
    val service = NoteServiceImpl()
    for (i in 1..8) {
        service.save(Note(text = "Note N$i"))
    }
    service.save(Note(text = "Note N1"))
    println(service.getAllUniqueTexts())

    print("Enter text: ")
    val newText = readln()
    print("Enter id: ")
    val newId = readln().toLong()
    service.save(Note(id = newId, text = newText))

    println(service.getBefore(3, 5))
    println(service.getAfter(3, 5))
}