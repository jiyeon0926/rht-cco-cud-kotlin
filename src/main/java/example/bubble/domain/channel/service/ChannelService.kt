package example.bubble.domain.channel.service

import example.bubble.domain.channel.dto.ChannelResDto
import example.bubble.domain.channel.entity.Channel
import example.bubble.domain.channel.repository.ChannelRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException
import java.time.LocalDateTime

@Service
class ChannelService(private val channelRepository: ChannelRepository) {

    @Transactional
    fun createChannel(
        channelId: String?,
        channelTitle: String?,
        channelUrl: String?,
        description: String?,
        userId: String?,
        subscriberCount: Long?,
        videoCount: Long?,
        viewCount: Long?,
        partnerId: String?,
        status: String?,
        thumbnails: String?,
        registerAt: LocalDateTime?,
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

    @Transactional
    fun updateChannel(
        id: Long,
        channelId: String?,
        channelTitle: String?,
        channelUrl: String?,
        description: String?,
        subscriberCount: Long?,
        videoCount: Long?,
        viewCount: Long?,
        status: String?,
        thumbnails: String?,
        registerAt: LocalDateTime?
    ): ChannelResDto {
        val channel = channelRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 id 입니다: $id") }

        channel.updateChannel(
            channelId = channelId,
            channelTitle = channelTitle,
            channelUrl = channelUrl,
            description = description,
            subscriberCount = subscriberCount,
            videoCount = videoCount,
            viewCount = viewCount,
            status = status,
            thumbnails = thumbnails,
            registerAt = registerAt
        )

        return ChannelResDto(
            channel.id,
            channel.channelId,
            channel.channelTitle,
            channel.channelUrl,
            channel.description,
            channel.userId,
            channel.subscriberCount,
            channel.videoCount,
            channel.viewCount,
            channel.partnerId,
            channel.status,
            channel.thumbnails,
            channel.registerAt,
            channel.creatorId,
            channel.createAt,
            channel.updateAt
        )
    }

    @Transactional
    fun deleteChannel(id: Long) {
        val channel = channelRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 id 입니다: $id") }

        channelRepository.delete(channel)
    }
}