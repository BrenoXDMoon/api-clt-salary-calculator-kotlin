package br.com.brenoxdmoon.apicltsalarycalculatorkotlin.inbound.facade

import br.com.brenoxdmoon.apicltsalarycalculatorkotlin.inbound.dto.CalculationDataDTO
import br.com.brenoxdmoon.apicltsalarycalculatorkotlin.inbound.dto.SalaryCalculatedDTO

interface SalaryCalculationFacade {

    fun calculateSalary(calculationDataDTO: CalculationDataDTO) : SalaryCalculatedDTO
}
