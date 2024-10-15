package kotlin_repo.prac.domain.repository

import kotlin_repo.prac.domain.Chat
import org.springframework.data.mongodb.repository.MongoRepository

interface ChatRepository : MongoRepository<Chat, String>