package kotlin_repo.prac.domain


data class ChatMessage (
    val type: MessageType,
    val content: String?,
    val sender: String
)