# Calculadora de Desconto: Tradicional × TDD

TDE individual de Engenharia de Software (PUCPR). O projeto implementa o módulo de **Cobrança e Descontos de um e-commerce** duas vezes, com abordagens opostas, para comparar como a ordem de escrita dos testes afeta a Verificação e a Validação:

| Etapa | Classe | Abordagem |
|---|---|---|
| 1 | `CalculadoraDescontoTradicional` | **Code first, test later**: o código é escrito primeiro e os testes depois |
| 2 | `CalculadoraDescontoTDD` | **TDD**: ciclo *Red → Green → Refactor* para cada regra de negócio |

**Aluna:** Isabelle Ribeiro dos Santos

---

## Regras de negócio

| Regra | Descrição | Exemplo |
|---|---|---|
| Desconto de 10% | Compras **acima** de R$ 500,00 | R$ 600 → R$ 540 |
| Desconto de 20% | Compras **acima** de R$ 1.000,00 | R$ 1.500 → R$ 1.200 |
| Cliente VIP | 5% adicional sobre o valor já descontado | R$ 600 (VIP) → R$ 513 |
| Frete | Se o valor final (após descontos) for inferior a R$ 100,00, soma-se R$ 15,00 | R$ 80 → R$ 95 |
| Validação | Valor total zerado ou negativo lança `IllegalArgumentException` | R$ 0 e R$ -10 → exceção |

### Decisões de interpretação

O enunciado deixa alguns pontos em aberto. As duas implementações adotam as mesmas decisões:

- **As faixas de desconto não acumulam.** Acima de R$ 1.000,00 vale somente o desconto de 20%, e não 10% + 20%.
- **"Acima de" é estritamente maior.** R$ 500,00 exatos não têm desconto, e R$ 1.000,00 exatos têm 10%.
- **O desconto VIP incide sobre o valor já descontado** pela faixa.
- **O frete é decidido depois de todos os descontos.** R$ 100,00 exatos não pagam frete.
- **Tipo numérico:** `double` com margem de erro (`delta`) nas comparações. Em um sistema real de cobrança, `BigDecimal` seria mais adequado.

---

## Estrutura do projeto

```
calculadora-desconto/
├── pom.xml
├── README.md
└── src/
    ├── main/java/br/pucpr/tde/
    │   ├── CalculadoraDescontoTradicional.java
    │   └── CalculadoraDescontoTDD.java
    └── test/java/br/pucpr/tde/
        ├── CalculadoraDescontoTradicionalTest.java
        └── CalculadoraDescontoTDDTest.java
```

## Tecnologias

- Java 17 ou superior
- Maven
- JUnit 5 (`junit-jupiter` 5.10.2) e `maven-surefire-plugin` 3.2.5
- IntelliJ IDEA
- Git

## Como usar

```java
CalculadoraDescontoTDD calc = new CalculadoraDescontoTDD();

double valor = calc.calcularValorFinal(600.00, true); // 513.0
```

O método recebe o valor total do pedido e um `boolean` indicando se o cliente é VIP, e devolve o valor final já com descontos e frete.

## Como executar os testes

**Pelo IntelliJ (interface):**

1. Abra o projeto (**File → Open**, escolhendo a pasta `calculadora-desconto`).
2. Aguarde o Maven carregar as dependências.
3. Clique com o botão direito em uma classe de teste, por exemplo `CalculadoraDescontoTDDTest`, e escolha **Run**.

Ou pelo painel **Maven** (lateral direita): `calculadora-desconto` → **Lifecycle** → duplo clique em **test**.

**Pelo terminal (com Maven instalado):**

```bash
mvn test
```

Resultado esperado: **24 testes passando** (12 por etapa).

---

## Histórico de commits

O histórico do Git documenta a diferença entre as abordagens:

- **Etapa 1:** primeiro o commit do código, depois o commit dos testes, mostrando a ordem *code first, test later*.
- **Etapa 2:** a cada ciclo, um commit de cada fase, seguindo o padrão abaixo.

| Prefixo | Fase | Significado |
|---|---|---|
| `test: red - ...` | 🔴 Red | Teste que falha para a regra da vez |
| `feat: green - ...` | 🟢 Green | Código mínimo para o teste passar |
| `refactor: ...` | 🔵 Refactor | Melhoria de código e testes com tudo passando |

Para ver o histórico em ordem cronológica:

```bash
git log --oneline --reverse
```

### Ciclos do TDD

| Ciclo | Regra |
|---|---|
| 1 | Valor inválido lança exceção |
| 2 | Pedido abaixo de R$ 500 não tem desconto |
| 3 | Desconto de 10% acima de R$ 500 |
| 4 | Desconto de 20% acima de R$ 1.000 |
| 5 | Desconto VIP de 5% sobre o valor já descontado |
| 6 | Frete de R$ 15,00 abaixo de R$ 100 |

---

## Documento do trabalho

O relatório completo (artefatos, tempos, dificuldades e as respostas sobre Verificação × Validação e verificação estática × dinâmica) está no documento Word entregue junto com este repositório.
