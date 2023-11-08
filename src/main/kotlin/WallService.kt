class WallService {
    private var post: Post = Post()

    fun getPost(): Post = post

    fun setId(newId: Int) {
        post = post.copy(id = newId)
    }

    fun authorId(newAuthorId: Int) {
        post = post.copy(authorId = newAuthorId)
    }

    fun setAuthor(newAuthor: String) {
        post = post.copy(author = newAuthor)
    }

    fun setAuthorJob(newAuthorJob: String) {
        post = post.copy(authorJob = newAuthorJob)
    }

    fun setAuthorAvatar(newAuthorAvatar: String) {
        post = post.copy(authorAvatar = newAuthorAvatar)
    }

    fun setContent(newContent: String) {
        post = post.copy(content = newContent)
    }

    fun setPublished(newPublished: String) {
        post = post.copy(published = newPublished)
    }

    fun setCoords(newCoords: Coordinates) {
        post = post.copy(coords = newCoords)
    }

    fun setLink(newLink: String) {
        post = post.copy(link = newLink)
    }

    fun changeMentionedMe() {
        post = if (post.mentionedMe)
            post.copy(mentionedMe = false)
        else
            post.copy(mentionedMe = true)
    }

    fun changeLikedByMe() {
        post = if (post.likedByMe)
            post.copy(likedByMe = false)
        else
            post.copy(likedByMe = true)
    }

    fun setAttachment(newAttachment: Attachment) {
        post = post.copy(attachment = newAttachment)
    }

}