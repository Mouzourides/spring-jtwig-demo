package dev.nikmouz.springjtwigdemo.repositories

import dev.nikmouz.springjtwigdemo.entities.Answer
import dev.nikmouz.springjtwigdemo.entities.Question
import dev.nikmouz.springjtwigdemo.entities.Quiz
import dev.nikmouz.springjtwigdemo.entities.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.Optional
import java.util.UUID

interface QuizRepository : JpaRepository<Quiz, UUID>

interface QuestionRepository : JpaRepository<Question, UUID>

interface AnswerRepository : JpaRepository<Answer, UUID> {
    @Query(nativeQuery = true, value = "select * from answers where correct = 'true'")
    fun findAllCorrectAnswers(): List<Answer>
}

interface UsersRepository : JpaRepository<User, UUID> {
    fun findByUsername(username: String): Optional<User>
}