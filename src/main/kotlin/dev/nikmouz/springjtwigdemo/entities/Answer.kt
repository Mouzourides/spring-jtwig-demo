package dev.nikmouz.springjtwigdemo.entities

import org.hibernate.annotations.GenericGenerator
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Answer(
        @Id
        @GeneratedValue(generator = "uuid2")
        @GenericGenerator(name = "uuid2", strategy = "uuid2")
        val id: UUID? = null,
        val name: String = "",
        val correct: Boolean = false
)
