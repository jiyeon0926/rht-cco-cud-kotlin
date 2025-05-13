package example.bubble.domain.ownership.controller

import example.bubble.domain.ownership.dto.OwnershipCreateReqDto
import example.bubble.domain.ownership.dto.OwnershipResDto
import example.bubble.domain.ownership.dto.OwnershipUpdateReqDto
import example.bubble.domain.ownership.service.OwnershipService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/ownerships")
class OwnershipController(private val ownershipService: OwnershipService) {

    // Ownership 생성
    @PostMapping
    fun createOwnership(@Valid @RequestBody ownershipCreateReqDto: OwnershipCreateReqDto): ResponseEntity<OwnershipResDto> {
        val ownership = ownershipService.createOwnership(
            ownershipCreateReqDto.isrc,
            ownershipCreateReqDto.album,
            ownershipCreateReqDto.musician,
            ownershipCreateReqDto.trackName,
            ownershipCreateReqDto.labelId,
            ownershipCreateReqDto.trackCodeId,
            ownershipCreateReqDto.contractorId,
            ownershipCreateReqDto.shareRatio,
            ownershipCreateReqDto.playlist,
            ownershipCreateReqDto.copyrights,
            ownershipCreateReqDto.laeeblyForShorts,
            ownershipCreateReqDto.legal,
            ownershipCreateReqDto.melon,
            ownershipCreateReqDto.creatorId
        )

        return ResponseEntity(ownership, HttpStatus.CREATED)
    }

    // Ownership 수정
    @PatchMapping("/{id}")
    fun updateOwnership(
        @PathVariable("id") id: Long,
        @RequestBody ownershipUpdateReqDto: OwnershipUpdateReqDto
    ): ResponseEntity<OwnershipResDto> {
        val ownership = ownershipService.updateOwnership(
            id,
            ownershipUpdateReqDto.isrc,
            ownershipUpdateReqDto.album,
            ownershipUpdateReqDto.musician,
            ownershipUpdateReqDto.shareRatio,
            ownershipUpdateReqDto.melon
        )

        return ResponseEntity(ownership, HttpStatus.OK)
    }

    // Ownership 삭제
    @DeleteMapping("/{id}")
    fun deleteOwnership(@PathVariable("id") id: Long): ResponseEntity<OwnershipResDto> {
        ownershipService.deleteOwnership(id)

        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}