package example.bubble.domain.channel.controller

import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import example.bubble.domain.channel.dto.ChannelCreateReqDto
import example.bubble.domain.channel.dto.ChannelResDto
import example.bubble.domain.channel.service.ChannelService

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
}