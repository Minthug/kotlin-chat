package kotlin_repo.prac.domain.repository

import org.springframework.data.mongodb.repository.MongoRepository

interface ChatRepository : MongoRepository<Chat, String>