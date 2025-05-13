package example.bubble.domain.contract.service

import example.bubble.domain.contract.dto.ContractResDto
import example.bubble.domain.contract.entity.Contract
import example.bubble.domain.contract.repository.ContractRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException
import java.time.LocalDateTime

@Service
class ContractService(private val contractRepository: ContractRepository) {

    @Transactional
    fun createContract(
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
    ): ContractResDto {
        val contract = Contract(
            contractFile = contractFile,
            contractorId = contractorId,
            name = name,
            email = email,
            phone = phone,
            partnerId = partnerId,
            partnerName = partnerName,
            commissionRatio = commissionRatio,
            contractAt = contractAt,
            memo = memo,
            test = test,
            testPeriod = testPeriod,
            creatorId = creatorId
        )

        val savedContract = contractRepository.save(contract)

        return ContractResDto(
            savedContract.id,
            savedContract.contractFile,
            savedContract.contractorId,
            savedContract.name,
            savedContract.email,
            savedContract.phone,
            savedContract.partnerId,
            savedContract.partnerName,
            savedContract.commissionRatio,
            savedContract.contractAt,
            savedContract.memo,
            savedContract.test,
            savedContract.testPeriod,
            savedContract.creatorId,
            savedContract.createAt,
            savedContract.updateAt
        )
    }

    @Transactional
    fun updateContract(
        id: Long,
        contractFile: String?,
        commissionRatio: Integer?,
        contractAt: LocalDateTime?,
        memo: String?,
        test: Boolean?,
        testPeriod: LocalDateTime?
    ): ContractResDto {
        val contract = contractRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 id 입니다: $id") }

        contract.updateContract(
            contractFile = contractFile,
            commissionRatio = commissionRatio,
            contractAt = contractAt,
            memo = memo,
            test = test,
            testPeriod = testPeriod
        )

        return ContractResDto(
            contract.id,
            contract.contractFile,
            contract.contractorId,
            contract.name,
            contract.email,
            contract.phone,
            contract.partnerId,
            contract.partnerName,
            contract.commissionRatio,
            contract.contractAt,
            contract.memo,
            contract.test,
            contract.testPeriod,
            contract.creatorId,
            contract.createAt,
            contract.updateAt
        )
    }

    @Transactional
    fun deleteContract(id: Long) {
        val contract = contractRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 id 입니다: $id") }

        contractRepository.delete(contract)
    }
}