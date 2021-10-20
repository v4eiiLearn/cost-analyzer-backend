package ru.vevteev.costanalyzerbackend.exception

import java.lang.RuntimeException

class ClientNotFoundException(clientId: Long): RuntimeException("client with clientId: $clientId not found")

class NotValidRequestBodyException : RuntimeException()

class JwtNullException : RuntimeException("jwt is null")