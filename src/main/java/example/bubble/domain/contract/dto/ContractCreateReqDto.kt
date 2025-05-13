package example.bubble.domain.contract.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.time.LocalDateTime

data class ContractCreateReqDto(
    val contractFile: String?,

    @field:NotBlank(message = "contractorId 항목은 필수입니다.")
    val contractorId: String?,

    @field:NotBlank(message = "name 항목은 필수입니다.")
    val name: String?,

    @field:NotBlank(message = "email 항목은 필수입니다.")
    @field:Email(message = "이메일 형식이 아닙니다.")
    val email: String?,

    val phone: String?,

    val partnerId: String?,

    val partnerName: String?,

    @field:NotNull(message = "commissionRatio 항목은 필수입니다.")
    val commissionRatio: Integer?,

    @field:NotNull(message = "contractAt 항목은 필수입니다.")
    val contractAt: LocalDateTime?,

    val memo: String?,

    val test: Boolean?,

    val testPeriod: LocalDateTime?,

    val creatorId: String?
)