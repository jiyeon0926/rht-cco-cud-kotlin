package example.bubble.domain.contract.dto

import java.time.LocalDateTime

data class ContractResDto(
    val id: Long?,
    val contractFile: String?,
    val contractorId: String?,
    val name: String?,
    val email: String?,
    val phone: String?,
    val partnerId: String?,
    val partnerName: String?,
    val commissionRatio: Integer?,
    val contractAt: LocalDateTime?,
    val memo: String?,
    val test: Boolean?,
    val testPeriod: LocalDateTime?,
    val creatorId: String?,
    val createAt: LocalDateTime,
    val updateAt: LocalDateTime
)