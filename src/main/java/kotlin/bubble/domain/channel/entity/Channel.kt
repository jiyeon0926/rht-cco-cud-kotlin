package kotlin.bubble.domain.channel.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime
import kotlin.bubble.global.common.entity.BaseEntity

@Entity(name = "channels")
class Channel(
    channelId: String,
    channelTitle: String,
    channelUrl: String,
    description: String,
    userId: String,
    subscriberCount: Long,
    videoCount: Long,
    viewCount: Long,
    partnerId: String?
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
    var description: String = description
    var userId: String = userId
    var subscriberCount: Long = subscriberCount
    var videoCount: Long = videoCount
    var viewCount: Long = viewCount
    var partnerId: String? = partnerId
    var status: String = status
    var thumbnails: String = thumbnails
    var registerAt: LocalDateTime = registerAt
    var creatorId: String? = creatorId
}