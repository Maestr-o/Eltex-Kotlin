class WallServiceImpl : WallService {
    private var nextId: Long = 0
    private val posts: MutableList<Post> = ArrayList()

    override fun addPost(content: String): Post {
        val post = Post(id = nextId++, content = content)
        posts.add(post)
        return post
    }

    override fun getById(postId: Long): Post? = posts.find {
        it.id == postId
    }

    override fun getAll(): List<Post> = posts.toList()

    override fun updatePost(updated: Post): Post? {
        val index = posts.indexOfFirst {
            it.id == updated.id
        }
        if (index < 0) {
            return null
        }
        posts[index] = updated
        return posts[index]
    }

    override fun getLatestPosts(count: Int): List<Post> = posts.sortedByDescending { it.id }
        .take(count)

    override fun getBeforePosts(count: Int, offset: Int): List<Post> = posts.sortedByDescending { it.id }
        .drop(offset)
        .take(count)

    override fun getAllLikes(): Int = posts.sumOf { it.likeOwnerIds.size }

    override fun getPostTexts(): List<String> = posts.map { it.content }
        .distinct()
        .toList()

    override fun getLikesPost(): Post? = posts.maxByOrNull { it.likeOwnerIds.size }

    override fun getAllAuthors(): List<String> = posts.map { it.author }
        .distinct()
        .toList()

    override fun getAuthorsCount(): Int = getAllAuthors().size

    override fun setAuthor(author: String, postId: Long): Post? {
        val post = getById(postId)?.copy(author = author) ?: return null
        updatePost(post)
        return post
    }

    override fun setAuthorId(authorId: Long, postId: Long): Post? {
        val post = getById(postId)?.copy(authorId = authorId) ?: return null
        return updatePost(post)
    }

    override fun setAuthorJob(authorJob: String?, postId: Long): Post? {
        val post = getById(postId)?.copy(authorJob = authorJob) ?: return null
        return updatePost(post)
    }

    override fun setAuthorAvatar(authorAvatar: String?, postId: Long): Post? {
        val post = getById(postId)?.copy(authorAvatar = authorAvatar) ?: return null
        return updatePost(post)
    }

    override fun setContent(content: String, postId: Long): Post? {
        val post = getById(postId)?.copy(content = content) ?: return null
        return updatePost(post)
    }

    override fun setPublished(published: String, postId: Long): Post? {
        val post = getById(postId)?.copy(published = published) ?: return null
        return updatePost(post)
    }

    override fun setLink(link: String, postId: Long): Post? {
        val post = getById(postId)?.copy(link = link) ?: return null
        return updatePost(post)
    }

    override fun setMentionedMe(mentionedMe: Boolean, postId: Long): Post? {
        val post = getById(postId)?.copy(mentionedMe = mentionedMe) ?: return null
        return updatePost(post)
    }

    override fun setLikedByMe(likedByMe: Boolean, postId: Long): Post? {
        val post = getById(postId)?.copy(likedByMe = likedByMe) ?: return null
        return updatePost(post)
    }

    override fun setCoords(coords: Coordinates, postId: Long): Post? {
        val post = getById(postId)?.copy(coords = coords) ?: return null
        return updatePost(post)
    }

    override fun setAttachment(attachment: Attachment?, postId: Long): Post? {
        val post = getById(postId)?.copy(attachment = attachment) ?: return null
        return updatePost(post)
    }

    override fun setUsers(users: Map<Long, UserPreview>, postId: Long): Post? {
        val post = getById(postId)?.copy(users = users) ?: return null
        return updatePost(post)
    }

    override fun setMentionIds(mentionIds: List<Long>, postId: Long): Post? {
        val post = getById(postId)?.copy(mentionIds = mentionIds) ?: return null
        return updatePost(post)
    }

    override fun like(postId: Long, userId: Long): Post? {
        val post = getById(postId) ?: return null

        val mutableLikeOwnerIds = post.likeOwnerIds.toMutableSet()
        if (mutableLikeOwnerIds.contains(userId)) {
            mutableLikeOwnerIds.remove(userId)
        } else {
            mutableLikeOwnerIds.add(userId)
        }

        val allUserIds = (post.mentionIds + mutableLikeOwnerIds).toSet()
        val users = allUserIds.associateWith {
            UserPreview(it, null)
        }

        val res = post.copy(users = users, likeOwnerIds = mutableLikeOwnerIds.toList())
        updatePost(res)
        return res
    }
}