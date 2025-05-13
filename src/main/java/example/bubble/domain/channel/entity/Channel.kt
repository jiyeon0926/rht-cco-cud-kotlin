package example.bubble.domain.channel.entity

import example.bubble.global.common.entity.BaseEntity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity(name = "channels")
class Channel(
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
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var channelId: String = channelId
    var channelTitle: String = channelTitle
    var channelUrl: String = channelUrl
    var description: String = description ?: ""
    var userId: String = userId
    var subscriberCount: Long = subscriberCount
    var videoCount: Long = videoCount
    var viewCount: Long = viewCount
    var partnerId: String? = partnerId
    var status: String = status
    var thumbnails: String = thumbnails
    var registerAt: LocalDateTime = registerAt
    var creatorId: String? = creatorId

    fun updateChannel(
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
    ) {
        channelId?.let { this.channelId = it }
        channelTitle?.let { this.channelTitle = it }
        channelUrl?.let { this.channelUrl = it }
        description?.let { this.description = it }
        subscriberCount?.let { this.subscriberCount = it }
        videoCount?.let { this.videoCount = it }
        viewCount?.let { this.viewCount = it }
        status?.let { this.status = it }
        thumbnails?.let { this.thumbnails = it }
        registerAt?.let { this.registerAt = it }
    }
}