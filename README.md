# api-clt-salary-calculator-kotlin

API REST para cálculo de salário CLT.

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
    "netSalary": 3268.30
}
```
