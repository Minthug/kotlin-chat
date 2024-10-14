package kotlin_repo.prac.domain.service

import kotlin_repo.prac.common.ChatResponse
import kotlin_repo.prac.domain.repository.ChatRepository
import org.springframework.stereotype.Service

@Service
class ChatServiceImpl(
    private val chatRepository: ChatRepository
) : ChatService {
    override fun getChats(): List<ChatResponse> =
        chatRepository.findAll()
            .map { chat ->
                ChatResponse(
                    name = chat.name,
                    message = chat.message,
                    cratedAt = chat.createdAt
                )
            }
            .sortedBy { it.cratedAt }
}