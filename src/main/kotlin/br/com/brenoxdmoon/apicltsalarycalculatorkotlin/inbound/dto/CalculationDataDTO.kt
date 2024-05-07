package br.com.brenoxdmoon.apicltsalarycalculatorkotlin.inbound.dto

import lombok.Data
import java.math.BigDecimal

@Data
class CalculationDataDTO(val grossSalary: BigDecimal, val discounts: BigDecimal, val numberOfDependents: Int) {
}
