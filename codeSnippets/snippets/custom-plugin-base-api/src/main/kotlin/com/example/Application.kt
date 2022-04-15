package com.example

import com.example.plugins.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.main() {
    install(CustomHeader) {
        headerName = "X-Custom-Header"
        headerValue = "Hello, world!"
    }
    install(RequestLogging)

    routing {
        get("/") {
            call.respondText("Root page")
        }
        get("/index") {
            call.respondText("Index page")
        }
        post("/transform-data") {
            val data = call.receive<Int>()
            call.respond(data)
        }
    }
}
