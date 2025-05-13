package example.bubble.domain.ownership.entity

import example.bubble.global.common.entity.BaseEntity
import jakarta.persistence.*

@Entity(name = "ownerships")
class Ownership(
    isrc: String?,
    album: String?,
    musician: String?,
    trackName: String?,
    labelId: String?,
    trackCodeId: String?,
    contractorId: String?,
    shareRatio: Integer?,
    playlist: Boolean?,
    copyrights: Boolean?,
    laeeblyForShorts: Boolean?,
    legal: Boolean?,
    melon: Integer?,
    creatorId: String?
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var isrc: String? = isrc

    @Column(nullable = false)
    var album: String? = album

    var musician: String? = musician

    var trackName: String? = trackName

    var labelId: String? = labelId

    var trackCodeId: String? = trackCodeId

    var contractorId: String? = contractorId

    @Column(nullable = false)
    var shareRatio: Integer? = shareRatio

    @Column(nullable = false)
    var playlist: Boolean? = playlist

    @Column(nullable = false)
    var copyrights: Boolean? = copyrights

    @Column(nullable = false)
    var laeeblyForShorts: Boolean? = laeeblyForShorts

    @Column(nullable = false)
    var legal: Boolean? = legal

    @Column(nullable = false)
    var melon: Integer? = melon

    var creatorId: String? = creatorId

    fun updateOwnership(
        isrc: String?,
        album: String?,
        musician: String?,
        shareRatio: Integer?,
        melon: Integer?
    ) {
        isrc?.let { this.isrc = it }
        album?.let { this.album = it }
        musician?.let { this.musician = it }
        shareRatio?.let { this.shareRatio = it }
        melon?.let { this.melon = it }
    }
}