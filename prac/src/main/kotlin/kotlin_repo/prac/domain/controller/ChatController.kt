package kotlin_repo.prac.domain.controller

import kotlin_repo.prac.common.ChatResponse
import kotlin_repo.prac.domain.Chat
import kotlin_repo.prac.domain.ChatMessage
import kotlin_repo.prac.domain.service.ChatService
import org.springframework.http.ResponseEntity
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.messaging.simp.SimpMessageHeaderAccessor
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ChatController {

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    fun sendMessage(@Payload chatMessage: ChatMessage?): ChatMessage? {
        return chatMessage
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    fun addUser(@Payload chatMessage: ChatMessage, headerAccessor: SimpMessageHeaderAccessor): ChatMessage? {
        headerAccessor.sessionAttributes!!["username"]= chatMessage.sender
        return chatMessage
    }
}

//@RestController
//@RequestMapping("/chat")
//class ChatController(
//    private val chatService: ChatService
//) {
//    @GetMapping
//    fun getChats(): ResponseEntity<List<ChatResponse>> =
//        chatService.getChats()
//            .let { ResponseEntity.ok(it) }
//}