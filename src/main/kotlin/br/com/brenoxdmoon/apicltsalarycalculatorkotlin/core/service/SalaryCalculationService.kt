package br.com.brenoxdmoon.apicltsalarycalculatorkotlin.core.service

import br.com.brenoxdmoon.apicltsalarycalculatorkotlin.inbound.dto.CalculationDataDTO
import br.com.brenoxdmoon.apicltsalarycalculatorkotlin.inbound.dto.SalaryCalculatedDTO

interface SalaryCalculationService {

    fun calculateSalary(calculationDataDTO: CalculationDataDTO): SalaryCalculatedDTO
}
