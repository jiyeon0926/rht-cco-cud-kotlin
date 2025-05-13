package example.bubble.domain.channel.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.time.LocalDateTime

data class ChannelCreateReqDto(

    @field:NotBlank(message = "channelId 항목은 필수입니다.")
    val channelId: String?,

    @field:NotBlank(message = "channelTitle 항목은 필수입니다.")
    val channelTitle: String?,

    @field:NotBlank(message = "channelUrl 항목은 필수입니다.")
    val channelUrl: String?,

    val description: String?,

    @field:NotBlank(message = "userId 항목은 필수입니다.")
    val userId: String?,

    @field:NotNull(message = "subscriberCount 항목은 필수입니다.")
    val subscriberCount: Long?,

    @field:NotNull(message = "videoCount 항목은 필수입니다.")
    val videoCount: Long?,

    @field:NotNull(message = "viewCount 항목은 필수입니다.")
    val viewCount: Long?,

    val partnerId: String?,

    @field:NotBlank(message = "status 항목은 필수입니다.")
    val status: String?,

    @field:NotBlank(message = "thumbnails 항목은 필수입니다.")
    val thumbnails: String?,

    @field:NotNull(message = "registerAt 항목은 필수입니다.")
    val registerAt: LocalDateTime?,

    val creatorId: String?
)