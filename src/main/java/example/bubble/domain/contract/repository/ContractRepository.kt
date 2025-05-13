package example.bubble.domain.contract.repository

import example.bubble.domain.contract.entity.Contract
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ContractRepository : JpaRepository<Contract, Long> {
}