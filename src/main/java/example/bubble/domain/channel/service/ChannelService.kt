package example.bubble.domain.channel.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import example.bubble.domain.channel.dto.ChannelResDto
import example.bubble.domain.channel.entity.Channel
import example.bubble.domain.channel.repository.ChannelRepository

@Service
class ChannelService(private val channelRepository: ChannelRepository) {

    @Transactional
    fun createChannel(
        channelId: String,
        channelTitle: String,
        channelUrl: String,
        description: String?,
        userId: String,
        subscriberCount: Long,
        videoCount: Long,
        viewCount: Long,
        partnerId: String?,
        status: String,
        thumbnails: String,
        registerAt: LocalDateTime,
        creatorId: String?
    ): ChannelResDto {
        val channel = Channel(
            channelId = channelId,
            channelTitle = channelTitle,
            channelUrl = channelUrl,
            description = description,
            userId = userId,
            subscriberCount = subscriberCount,
            videoCount = videoCount,
            viewCount = viewCount,
            partnerId = partnerId,
            status = status,
            thumbnails = thumbnails,
            registerAt = registerAt,
            creatorId = creatorId
        )

        val savedChannel = channelRepository.save(channel)

        return ChannelResDto(
            savedChannel.id,
            savedChannel.channelId,
            savedChannel.channelTitle,
            savedChannel.channelUrl,
            savedChannel.description,
            savedChannel.userId,
            savedChannel.subscriberCount,
            savedChannel.videoCount,
            savedChannel.viewCount,
            savedChannel.partnerId,
            savedChannel.status,
            savedChannel.thumbnails,
            savedChannel.registerAt,
            savedChannel.creatorId,
            savedChannel.createAt,
            savedChannel.updateAt
        )
    }
}