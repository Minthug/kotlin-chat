package kotlin_repo.prac.domain

import jakarta.persistence.Column
import jakarta.persistence.Id
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document
class Chat (
    @Id
    val id: String? = null,

    @Column(columnDefinition = "TEXT")
    val name: String,

    @Column(columnDefinition = "VARCHAR(255)")
    val message: String,

    @CreatedDate
    val createdAt: LocalDateTime = LocalDateTime.now()
)