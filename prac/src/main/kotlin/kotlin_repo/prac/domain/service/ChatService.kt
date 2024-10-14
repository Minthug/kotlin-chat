package kotlin_repo.prac.domain.service

import kotlin_repo.prac.common.ChatResponse

interface ChatService {
    fun getChats(): List<ChatResponse>
}