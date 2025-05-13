package example.bubble.domain.channel.controller

import example.bubble.domain.channel.dto.ChannelCreateReqDto
import example.bubble.domain.channel.dto.ChannelResDto
import example.bubble.domain.channel.dto.ChannelUpdateReqDto
import example.bubble.domain.channel.service.ChannelService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/channels")
class ChannelController(private val channelService: ChannelService) {

    // Channel 생성
    @PostMapping
    fun createChannel(@Valid @RequestBody channelCreateReqDto: ChannelCreateReqDto): ResponseEntity<ChannelResDto> {
        val channel = channelService.createChannel(
            channelCreateReqDto.channelId,
            channelCreateReqDto.channelTitle,
            channelCreateReqDto.channelUrl,
            channelCreateReqDto.description,
            channelCreateReqDto.userId,
            channelCreateReqDto.subscriberCount,
            channelCreateReqDto.videoCount,
            channelCreateReqDto.viewCount,
            channelCreateReqDto.partnerId,
            channelCreateReqDto.status,
            channelCreateReqDto.thumbnails,
            channelCreateReqDto.registerAt,
            channelCreateReqDto.creatorId
        )

        return ResponseEntity(channel, HttpStatus.CREATED)
    }

    // Channel 수정
    @PatchMapping("/{id}")
    fun updateChannel(
        @PathVariable("id") id: Long,
        @RequestBody channelUpdateReqDto: ChannelUpdateReqDto
    ): ResponseEntity<ChannelResDto> {
        val channel = channelService.updateChannel(
            id,
            channelUpdateReqDto.channelId,
            channelUpdateReqDto.channelTitle,
            channelUpdateReqDto.channelUrl,
            channelUpdateReqDto.description,
            channelUpdateReqDto.subscriberCount,
            channelUpdateReqDto.videoCount,
            channelUpdateReqDto.viewCount,
            channelUpdateReqDto.status,
            channelUpdateReqDto.thumbnails,
            channelUpdateReqDto.registerAt
        )

        return ResponseEntity(channel, HttpStatus.OK)
    }

    // Channel 삭제
    @DeleteMapping("/{id}")
    fun deleteChannel(@PathVariable("id") id: Long): ResponseEntity<Void> {
        channelService.deleteChannel(id)

        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}