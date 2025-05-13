package example.bubble.domain.contract.entity

import example.bubble.global.common.entity.BaseEntity
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity(name = "contracts")
class Contract(
    contractFile: String?,
    contractorId: String?,
    name: String?,
    email: String?,
    phone: String?,
    partnerId: String?,
    partnerName: String?,
    commissionRatio: Integer?,
    contractAt: LocalDateTime?,
    memo: String?,
    test: Boolean?,
    testPeriod: LocalDateTime?,
    creatorId: String?
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var contractFile: String? = contractFile

    @Column(nullable = false)
    var contractorId: String? = contractorId

    @Column(nullable = false)
    var name: String? = name

    @Column(nullable = false)
    var email: String? = email

    var phone: String? = phone

    var partnerId: String? = partnerId

    var partnerName: String? = partnerName

    @Column(nullable = false)
    var commissionRatio: Integer? = commissionRatio

    @Column(nullable = false)
    var contractAt: LocalDateTime? = contractAt

    var memo: String? = memo

    var test: Boolean? = test

    var testPeriod: LocalDateTime? = testPeriod

    var creatorId: String? = creatorId

    fun updateContract(
        contractFile: String?,
        commissionRatio: Integer?,
        contractAt: LocalDateTime?,
        memo: String?,
        test: Boolean?,
        testPeriod: LocalDateTime?
    ) {
        contractFile?.let { this.contractFile = it }
        commissionRatio?.let { this.commissionRatio = it }
        contractAt?.let { this.contractAt = it }
        memo?.let { this.memo = it }
        test?.let { this.test = it }
        testPeriod?.let { this.testPeriod = it }
    }
}