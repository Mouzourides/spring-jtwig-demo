package dev.nikmouz.springjtwigdemo.entities

import org.hibernate.annotations.GenericGenerator
import java.time.ZonedDateTime
import java.util.UUID
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToMany

@Entity
data class User(
        @Id
        @GeneratedValue(generator = "uuid2")
        @GenericGenerator(name = "uuid2", strategy = "uuid2")
        val id: UUID? = null,
        val username: String = "",
        val email: String = "",
        val password: String = "",
        val createdTimestamp: ZonedDateTime,

        @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
        @JoinColumn(name = "user_id")
        val quiz: List<Quiz>? = null
)