package br.com.brenoxdmoon.apicltsalarycalculatorkotlin.inbound.facade.impl

import br.com.brenoxdmoon.apicltsalarycalculatorkotlin.core.service.SalaryCalculationService
import br.com.brenoxdmoon.apicltsalarycalculatorkotlin.inbound.dto.CalculationDataDTO
import br.com.brenoxdmoon.apicltsalarycalculatorkotlin.inbound.dto.SalaryCalculatedDTO
import br.com.brenoxdmoon.apicltsalarycalculatorkotlin.inbound.facade.SalaryCalculationFacade
import org.springframework.stereotype.Component

@Component
class SalaryCalculationFacadeImpl(var service: SalaryCalculationService) : SalaryCalculationFacade {
    override fun calculateSalary(calculationDataDTO: CalculationDataDTO) : SalaryCalculatedDTO{
        return service.calculateSalary(calculationDataDTO)
    }

}