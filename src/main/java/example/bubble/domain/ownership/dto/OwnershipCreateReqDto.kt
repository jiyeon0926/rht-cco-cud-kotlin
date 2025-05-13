package example.bubble.domain.ownership.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class OwnershipCreateReqDto(
    val isrc: String?,

    @field:NotBlank(message = "album 항목은 필수입니다.")
    val album: String?,

    val musician: String?,
    val trackName: String?,
    val labelId: String?,
    val trackCodeId: String?,
    val contractorId: String?,

    @field:NotNull(message = "shareRatio 항목은 필수입니다.")
    val shareRatio: Integer?,

    @field:NotNull(message = "playlist 항목에 동의하셔야 합니다.")
    val playlist: Boolean?,

    @field:NotNull(message = "copyrights 항목에 동의하셔야 합니다.")
    val copyrights: Boolean?,

    @field:NotNull(message = "laeeblyForShorts 항목에 동의하셔야 합니다.")
    val laeeblyForShorts: Boolean?,

    @field:NotNull(message = "legal 항목에 동의하셔야 합니다.")
    val legal: Boolean?,

    @field:NotNull(message = "melon 항목은 필수입니다.")
    val melon: Integer?,

    val creatorId: String?
)