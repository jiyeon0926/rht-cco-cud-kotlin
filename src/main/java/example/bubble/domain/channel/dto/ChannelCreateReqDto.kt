package example.bubble.domain.channel.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.time.LocalDateTime

class ChannelCreateReqDto(

    @NotBlank(message = "channelId 항목은 필수입니다.")
    val channelId: String,

    @NotBlank(message = "channelTitle 항목은 필수입니다.")
    val channelTitle: String,

    @NotBlank(message = "channelUrl 항목은 필수입니다.")
    val channelUrl: String,

    val description: String?,

    @NotBlank(message = "userId 항목은 필수입니다.")
    val userId: String,

    @NotNull(message = "subscriberCount 항목은 필수입니다.")
    val subscriberCount: Long,

    @NotNull(message = "videoCount 항목은 필수입니다.")
    val videoCount: Long,

    @NotNull(message = "viewCount 항목은 필수입니다.")
    val viewCount: Long,

    val partnerId: String?,

    @NotBlank(message = "status 항목은 필수입니다.")
    val status: String,

    @NotBlank(message = "thumbnails 항목은 필수입니다.")
    val thumbnails: String,

    @NotNull(message = "registerAt 항목은 필수입니다.")
    val registerAt: LocalDateTime,

    val creatorId: String?
)