enum class AttachmentType {
    IMAGE,
    AUDIO,
    VIDEO,
    ;

    companion object {
        fun fromString(type: String): AttachmentType {
            return when (type) {
                "IMAGE", "Image", "image" -> IMAGE
                "AUDIO", "Audio", "audio" -> AUDIO
                "VIDEO", "Video", "video" -> VIDEO
                else -> error("Error attachment type: $type")
            }
        }
    }
}