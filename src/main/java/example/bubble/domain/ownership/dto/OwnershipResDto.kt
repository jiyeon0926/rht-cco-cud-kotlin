package example.bubble.domain.ownership.dto

import java.time.LocalDateTime

data class OwnershipResDto(
    val id: Long?,
    val isrc: String?,
    val album: String?,
    val musician: String?,
    val trackName: String?,
    val labelId: String?,
    val trackCodeId: String?,
    val contractorId: String?,
    val shareRatio: Integer?,
    val playlist: Boolean?,
    val copyrights: Boolean?,
    val laeeblyForShorts: Boolean?,
    val legal: Boolean?,
    val melon: Integer?,
    val creatorId: String?,
    val createAt: LocalDateTime,
    val updateAt: LocalDateTime
)