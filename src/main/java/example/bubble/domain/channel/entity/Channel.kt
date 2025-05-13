package example.bubble.domain.channel.entity

import example.bubble.global.common.entity.BaseEntity
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity(name = "channels")
class Channel(
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
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false)
    var channelId: String? = channelId

    @Column(nullable = false)
    var channelTitle: String? = channelTitle

    @Column(nullable = false)
    var channelUrl: String? = channelUrl

    @Column(nullable = false)
    var description: String? = description ?: ""

    @Column(nullable = false)
    var userId: String? = userId

    @Column(nullable = false)
    var subscriberCount: Long? = subscriberCount

    @Column(nullable = false)
    var videoCount: Long? = videoCount

    @Column(nullable = false)
    var viewCount: Long? = viewCount

    var partnerId: String? = partnerId

    @Column(nullable = false)
    var status: String? = status

    @Column(nullable = false)
    var thumbnails: String? = thumbnails

    @Column(nullable = false)
    var registerAt: LocalDateTime? = registerAt

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