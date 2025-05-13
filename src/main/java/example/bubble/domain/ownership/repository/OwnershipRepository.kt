package example.bubble.domain.ownership.repository

import example.bubble.domain.ownership.entity.Ownership
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OwnershipRepository : JpaRepository<Ownership, Long> {
}