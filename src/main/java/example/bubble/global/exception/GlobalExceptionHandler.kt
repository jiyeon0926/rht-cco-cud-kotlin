package example.bubble.global.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.method.annotation.HandlerMethodValidationException
import org.springframework.web.server.ResponseStatusException

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(HandlerMethodValidationException::class)
    fun handleMethodValidationExceptions(e: HandlerMethodValidationException): ResponseEntity<String> {
        val message = e.parameterValidationResults
            .first()
            .resolvableErrors
            .first()
            .defaultMessage

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(message)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationExceptions(e: MethodArgumentNotValidException): ResponseEntity<String> {
        val message = e.bindingResult
            .allErrors
            .first()
            .defaultMessage

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(message)
    }

    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun handleInvalidDateFormat(e: HttpMessageNotReadableException): ResponseEntity<String> {
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(e.message)
    }

    @ExceptionHandler(Exception::class)
    fun handleOtherExceptions(e: Exception): ResponseEntity<String> {
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(e.message)
    }

    @ExceptionHandler(ResponseStatusException::class)
    fun handleResponseStatusExceptions(e: ResponseStatusException): ResponseEntity<String> {
        return ResponseEntity
            .status(e.statusCode)
            .body(e.reason)
    }
}