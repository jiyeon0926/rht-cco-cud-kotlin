package example.bubble.domain.channel.dto

import java.time.LocalDateTime

data class ChannelResDto(
    val id: Long?,
    val channelId: String,
    val channelTitle: String,
    val channelUrl: String,
    val description: String,
    val userId: String,
    val subscriberCount: Long,
    val videoCount: Long,
    val viewCount: Long,
    val partnerId: String?,
    val status: String,
    val thumbnails: String,
    val registerAt: LocalDateTime,
    val creatorId: String?,
    val createAt: LocalDateTime,
    val updateAt: LocalDateTime
)