interface WallService {
    fun addPost(content: String): Post
    fun getById(postId: Long): Post?
    fun getAll(): List<Post>
    fun updatePost(updated: Post): Post?
    fun getLatestPosts(count: Int): List<Post>
    fun getBeforePosts(count: Int, offset: Int): List<Post>
    fun getAllLikes(): Int
    fun getPostTexts(): List<String>
    fun getLikesPost(): Post?
    fun getAllAuthors(): List<String>
    fun getAuthorsCount(): Int
    fun setAuthor(author: String, postId: Long): Post?
    fun setAuthorId(authorId: Long, postId: Long): Post?
    fun setAuthorJob(authorJob: String?, postId: Long): Post?
    fun setAuthorAvatar(authorAvatar: String?, postId: Long): Post?
    fun setContent(content: String, postId: Long): Post?
    fun setPublished(published: String, postId: Long): Post?
    fun setLink(link: String, postId: Long): Post?
    fun setMentionedMe(mentionedMe: Boolean, postId: Long): Post?
    fun setLikedByMe(likedByMe: Boolean, postId: Long): Post?
    fun setCoords(coords: Coordinates, postId: Long): Post?
    fun setAttachment(attachment: Attachment?, postId: Long): Post?
    fun setUsers(users: Map<Long, UserPreview>, postId: Long): Post?
    fun setMentionIds(mentionIds: List<Long>, postId: Long): Post?
    fun like(postId: Long, userId: Long): Post?
}