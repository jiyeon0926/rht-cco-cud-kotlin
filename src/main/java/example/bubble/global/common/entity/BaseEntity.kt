package example.bubble.global.common.entity

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

@MappedSuperclass
abstract class BaseEntity {

    @CreatedDate
    @Column(updatable = false)
    var createAt: LocalDateTime = LocalDateTime.now()

    @LastModifiedDate
    var updateAt: LocalDateTime = LocalDateTime.now()
}