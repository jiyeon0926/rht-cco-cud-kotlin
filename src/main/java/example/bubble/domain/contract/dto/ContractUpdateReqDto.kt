package example.bubble.domain.contract.dto

import java.time.LocalDateTime

data class ContractUpdateReqDto(
    val contractFile: String,
    val commissionRatio: Integer?,
    val contractAt: LocalDateTime?,
    val memo: String?,
    val test: Boolean?,
    val testPeriod: LocalDateTime?,
)