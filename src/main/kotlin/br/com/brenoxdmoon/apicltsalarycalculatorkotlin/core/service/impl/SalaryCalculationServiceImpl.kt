package br.com.brenoxdmoon.apicltsalarycalculatorkotlin.core.service.impl

import br.com.brenoxdmoon.apicltsalarycalculatorkotlin.core.service.SalaryCalculationService
import br.com.brenoxdmoon.apicltsalarycalculatorkotlin.inbound.dto.CalculationDataDTO
import br.com.brenoxdmoon.apicltsalarycalculatorkotlin.inbound.dto.SalaryCalculatedDTO
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class SalaryCalculationServiceImpl : SalaryCalculationService {

    @Value("\${inss}")
    private lateinit var inssPercentage: BigDecimal

    @Value("\${ir}")
    private lateinit var irPercentage: BigDecimal

    @Value("\${deduction-by-dependent}")
    private lateinit var dependentDeductionAmount: BigDecimal

    override fun calculateSalary(calculationDataDTO: CalculationDataDTO): SalaryCalculatedDTO {

        // Cálculo do INSS
        val inss = calculationDataDTO.grossSalary * inssPercentage

        // Cálculo da base de cálculo do IR
        val irBase = calculationDataDTO.grossSalary - inss - calculationDataDTO.discounts

        // Cálculo do desconto do IR
        val ir = if (irBase > BigDecimal.ZERO) irBase * irPercentage else BigDecimal.ZERO

        // Cálculo do desconto por dependentes
        val dependentDeductionTotal = dependentDeductionAmount * BigDecimal(calculationDataDTO.numberOfDependents)

        // Salário líquido
        val netSalary = calculationDataDTO.grossSalary - inss - ir + calculationDataDTO.discounts - dependentDeductionTotal

        return SalaryCalculatedDTO(netSalary.setScale(2))
    }
}