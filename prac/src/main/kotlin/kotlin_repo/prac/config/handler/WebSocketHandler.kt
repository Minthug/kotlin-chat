package kotlin_repo.prac.config.handler

import com.fasterxml.jackson.databind.ObjectMapper
import kotlin_repo.prac.common.ChatRequest
import kotlin_repo.prac.common.ChatResponse
import kotlin_repo.prac.domain.Chat
import kotlin_repo.prac.domain.repository.ChatRepository
import org.springframework.stereotype.Component
import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler
import java.time.LocalDateTime

@Component
class WebSocketHandler(

    private val objectMapper: ObjectMapper,
    private val sessions: MutableSet<WebSocketSession> = HashSet(),
    private val chatRepository: ChatRepository,
) : TextWebSocketHandler() {

    override fun afterConnectionEstablished(session: WebSocketSession) {
        sessions.add(session)
    }

    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        sessions.remove(session)
    }

    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        val chatRequest = objectMapper.readValue(message.payload, ChatRequest::class.java)

        sessions.map { unit -> unit.sendMessage(chatRequest) }
        chatRequest.save()
    }

    private fun WebSocketSession.sendMessage(chatRequest: ChatRequest) {
        val chatResponse = chatRequest.run {
            ChatResponse(
                message = message,
                name = name,
                cratedAt = LocalDateTime.now()
            )
        }

        TextMessage(objectMapper.writeValueAsString(chatResponse))
            .run(this::sendMessage)
    }

    private fun ChatRequest.save() {
        chatRepository.save(
            Chat(
                name = name,
                message = message
            )
        )
    }
}