package example.bubble.domain.channel.dto

import java.time.LocalDateTime

class ChannelUpdateReqDto(
    val channelId: String?,
    val channelTitle: String?,
    val channelUrl: String?,
    val description: String?,
    val subscriberCount: Long?,
    val videoCount: Long?,
    val viewCount: Long?,
    val status: String?,
    var thumbnails: String?,
    val registerAt: LocalDateTime?
)