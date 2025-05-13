package example.bubble.domain.channel.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import example.bubble.domain.channel.entity.Channel

@Repository
interface ChannelRepository : JpaRepository<Channel, Long> {
}