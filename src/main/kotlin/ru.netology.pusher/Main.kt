package ru.netology.pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream


fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .build()

    FirebaseApp.initializeApp(options)

    val message = Message.builder()
        .putData("action", "NEW_POST")
        .putData(
            "content", """{
            "postAuthor": "Anton",
            "contentNewPost" : "Напоминаю, что обучение на модуле «Разработка приложений на Kotlin» (KT-44) было завершено. Техническое закрытие модуля будет осуществлено 30.08.2023. Это означает, что сдать решения практических заданий будет невозможно."
        }""".trimMargin()
        )
        .setToken(token)
        .build()



    FirebaseMessaging.getInstance().send(message)
}