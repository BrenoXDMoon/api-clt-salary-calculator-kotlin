package br.com.brenoxdmoon.apicltsalarycalculatorkotlin.inbound.controller

import br.com.brenoxdmoon.apicltsalarycalculatorkotlin.inbound.dto.CalculationDataDTO
import br.com.brenoxdmoon.apicltsalarycalculatorkotlin.inbound.dto.SalaryCalculatedDTO
import br.com.brenoxdmoon.apicltsalarycalculatorkotlin.inbound.facade.SalaryCalculationFacade
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController



@RestController
@RequestMapping("clt")
class CalculationController(@Autowired val facade: SalaryCalculationFacade) {

    @RequestMapping("calculate")
    fun calculate(@RequestBody calculationDataDTO: CalculationDataDTO): ResponseEntity<SalaryCalculatedDTO> {

        return ResponseEntity.ok().body(facade.calculateSalary(calculationDataDTO))
    }

}