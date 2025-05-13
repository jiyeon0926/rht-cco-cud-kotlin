package example.bubble.domain.ownership.dto

data class OwnershipUpdateReqDto(
    val isrc: String?,
    val album: String?,
    val musician: String?,
    val shareRatio: Integer,
    val melon: Integer?
)