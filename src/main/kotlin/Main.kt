fun main() {
    val noteService = NoteService()
    println("${noteService.getNote()}\nPress any key")
    readln()
    noteService.updateText("1243")
    println(noteService.getNote())

    val wallService = WallService()
    println(wallService.getPost())
    wallService.changeLikedByMe()
    wallService.setContent("1234")
    val coordinates = Coordinates(lat = 55.50, long = 85.04)
    wallService.setCoords(coordinates)
    print("Enter attachment type: ")
    val type = readln()
    val attachment = Attachment(url = "org.com", type = AttachmentType.fromString(type))
    wallService.setAttachment(attachment)
    println(wallService.getPost())
}