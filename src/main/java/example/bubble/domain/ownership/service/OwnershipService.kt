package example.bubble.domain.ownership.service

import example.bubble.domain.ownership.dto.OwnershipResDto
import example.bubble.domain.ownership.entity.Ownership
import example.bubble.domain.ownership.repository.OwnershipRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException

@Service
class OwnershipService(private val ownershipRepository: OwnershipRepository) {

    @Transactional
    fun createOwnership(
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
    ): OwnershipResDto {
        val ownership = Ownership(
            isrc = isrc,
            album = album,
            musician = musician,
            trackName = trackName,
            labelId = labelId,
            trackCodeId = trackCodeId,
            contractorId = contractorId,
            shareRatio = shareRatio,
            playlist = playlist,
            copyrights = copyrights,
            laeeblyForShorts = laeeblyForShorts,
            legal = legal,
            melon = melon,
            creatorId = creatorId
        )

        val savedOwnership = ownershipRepository.save(ownership)

        return OwnershipResDto(
            savedOwnership.id,
            savedOwnership.isrc,
            savedOwnership.album,
            savedOwnership.musician,
            savedOwnership.trackName,
            savedOwnership.labelId,
            savedOwnership.trackCodeId,
            savedOwnership.contractorId,
            savedOwnership.shareRatio,
            savedOwnership.playlist,
            savedOwnership.copyrights,
            savedOwnership.laeeblyForShorts,
            savedOwnership.legal,
            savedOwnership.melon,
            savedOwnership.creatorId,
            savedOwnership.createAt,
            savedOwnership.updateAt
        )
    }

    @Transactional
    fun updateOwnership(
        id: Long,
        isrc: String?,
        album: String?,
        musician: String?,
        shareRatio: Integer?,
        melon: Integer?
    ): OwnershipResDto {
        val ownership = ownershipRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 id 입니다: $id") }

        ownership.updateOwnership(
            isrc = isrc,
            album = album,
            musician = musician,
            shareRatio = shareRatio,
            melon = melon
        )

        return OwnershipResDto(
            ownership.id,
            ownership.isrc,
            ownership.album,
            ownership.musician,
            ownership.trackName,
            ownership.labelId,
            ownership.trackCodeId,
            ownership.contractorId,
            ownership.shareRatio,
            ownership.playlist,
            ownership.copyrights,
            ownership.laeeblyForShorts,
            ownership.legal,
            ownership.melon,
            ownership.creatorId,
            ownership.createAt,
            ownership.updateAt
        )
    }

    @Transactional
    fun deleteOwnership(id: Long) {
        val ownership = ownershipRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 id 입니다: $id") }

        ownershipRepository.delete(ownership)
    }
}