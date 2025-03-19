package br.com.brenoxdmoon.apicltsalarycalculatorkotlin.core.service.impl

import br.com.brenoxdmoon.apicltsalarycalculatorkotlin.core.service.SalaryCalculationService
import br.com.brenoxdmoon.apicltsalarycalculatorkotlin.inbound.dto.CalculationDataDTO
import br.com.brenoxdmoon.apicltsalarycalculatorkotlin.inbound.dto.SalaryCalculatedDTO
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.math.MathContext

@Service
class SalaryCalculationServiceImpl : SalaryCalculationService {


    @Value("\${deduction-by-dependent}")
    private lateinit var dependentDeductionAmount: BigDecimal

    override fun calculateSalary(calculationDataDTO: CalculationDataDTO): SalaryCalculatedDTO {

        val inss = when {
            calculationDataDTO.grossSalary <= BigDecimal("1212.00") -> calculationDataDTO.grossSalary * BigDecimal("0.075")
            calculationDataDTO.grossSalary <= BigDecimal("2427.35") -> calculationDataDTO.grossSalary * BigDecimal("0.09")
            calculationDataDTO.grossSalary <= BigDecimal("3641.03") -> calculationDataDTO.grossSalary * BigDecimal("0.12")
            calculationDataDTO.grossSalary <= BigDecimal("7087.22") -> calculationDataDTO.grossSalary * BigDecimal("0.14")
            else -> BigDecimal("828.39")
        }

        val irBase = calculationDataDTO.grossSalary - inss - calculationDataDTO.discounts

        val ir = when {
            irBase <= BigDecimal("1903.98") -> BigDecimal.ZERO
            irBase <= BigDecimal("2826.65") -> irBase * BigDecimal("0.075") - BigDecimal("142.80")
            irBase <= BigDecimal("3751.05") -> irBase * BigDecimal("0.15") - BigDecimal("354.80")
            irBase <= BigDecimal("4664.68") -> irBase * BigDecimal("0.225") - BigDecimal("636.13")
            else -> irBase * BigDecimal("0.275") - BigDecimal("869.36")
        }

        val dependentDeductionTotal = dependentDeductionAmount * BigDecimal(calculationDataDTO.numberOfDependents)

        val netSalary = calculationDataDTO.grossSalary - (ir + inss + calculationDataDTO.discounts + dependentDeductionTotal)

        return SalaryCalculatedDTO(netSalary.setScale(2, BigDecimal.ROUND_HALF_UP))
    }
}