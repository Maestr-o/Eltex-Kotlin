import com.sun.org.apache.xpath.internal.operations.Bool

data class Post(
    val id: Int = 0,
    val authorId: Int = 0,
    val author: String = "",
    val authorJob: String? = null,
    val authorAvatar: String? = null,
    val content: String = "",
    val published: String = "01-01-1970",
    val coords: Coordinates? = null,
    val link: String? = null,
    val mentionedMe: Boolean = false,
    val likedByMe: Boolean = false,
    val attachment: Attachment? = null,
)
