# api-clt-salary-calculator-kotlin

API REST para cálculo de salário CLT. Os valores apresentados neste sistema são apenas para exemplo. É possível configurar a porcentagem dos impostos de INSS e IR, assim como a dedução por dependêntes.

## Entradas:

- ```grossSalary```: Salário bruto em formato Number
- ```discounts```: Valor da soma dos descontos que deverão ser aplicados em folha de pagamento. Exemplo: pensão, benefícios, etc.
- ```numberOfDependents```: Número de dependentes do colaborador.

JSON:
```
  {
    "grossSalary": 7000.00,
    "discounts": 0,
    "numberOfDependents": 0
  }
```

## Saídas:

- ```netSalary```: Salário líquido

JSON:
```
{
    "netSalary": 0000
}
```

## Valores configuráveis:
Os valores abaixo encontram-se no arquivo  ```src/main/resources/aplication.properties```.
- ```ir```: 0.275
- ```inss```: 0.08
- ```deduction-by-dependent```: 189.59
