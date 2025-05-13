package example.bubble.domain.contract.controller

import example.bubble.domain.contract.dto.ContractCreateReqDto
import example.bubble.domain.contract.dto.ContractResDto
import example.bubble.domain.contract.dto.ContractUpdateReqDto
import example.bubble.domain.contract.service.ContractService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/contracts")
class ContractController(private val contractService: ContractService) {

    // Contract 생성
    @PostMapping
    fun createContract(@Valid @RequestBody contractCreateReqDto: ContractCreateReqDto): ResponseEntity<ContractResDto> {
        val contract = contractService.createContract(
            contractCreateReqDto.contractFile,
            contractCreateReqDto.contractorId,
            contractCreateReqDto.name,
            contractCreateReqDto.email,
            contractCreateReqDto.phone,
            contractCreateReqDto.partnerId,
            contractCreateReqDto.partnerName,
            contractCreateReqDto.commissionRatio,
            contractCreateReqDto.contractAt,
            contractCreateReqDto.memo,
            contractCreateReqDto.test,
            contractCreateReqDto.testPeriod,
            contractCreateReqDto.creatorId
        )

        return ResponseEntity(contract, HttpStatus.CREATED)
    }

    // Contract 수정
    @PatchMapping("/{id}")
    fun updateContract(@PathVariable("id") id: Long,
                       @RequestBody contractUpdateReqDto: ContractUpdateReqDto): ResponseEntity<ContractResDto> {
        val contract = contractService.updateContract(
            id,
            contractUpdateReqDto.contractFile,
            contractUpdateReqDto.commissionRatio,
            contractUpdateReqDto.contractAt,
            contractUpdateReqDto.memo,
            contractUpdateReqDto.test,
            contractUpdateReqDto.testPeriod
        )

        return ResponseEntity(contract, HttpStatus.OK)
    }

    // Contract 삭제
    @DeleteMapping("/{id}")
    fun deleteContract(@PathVariable("id") id: Long): ResponseEntity<Void> {
        contractService.deleteContract(id)

        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}