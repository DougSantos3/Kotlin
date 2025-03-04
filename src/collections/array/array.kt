package br.com.vraptor.bitBank.collections.Array

import java.math.BigDecimal
import java.math.RoundingMode

fun generateArray() {
    /* First example:
    Construindo arrays/ Iterando por um array/ Alterando um elemento

    Funções de agregação
      Ranges
      operações agregadores
      Array de objetos
      Processando coleções

    Array junta um grupo de objeto do mesmo tipo em um objeto só

    Criar um algoritmo para mostrar quem é o funcionario mais velho em idade

    Sem array. Aprendemos a criar variáveis do tipo inteiro e como compará-las utilizando uma estrutura de ifs aninhados: */
    val idade1 = 25
    val idade2 = 19
    val idade3 = 34
    val idade4 = 20

    val maiorIdade = if (idade1 > idade2 && idade1 > idade3 && idade1 > idade4) {
        idade1
    } else if (idade2 > idade3 && idade2 > idade4) {
        idade2
    } else if (idade3 > idade4) {
        idade3
    } else {
        idade4
    }

    println(maiorIdade)


    /* Second Example: Agora usamos array
    Em seguida vimos que utilizar variáveis comuns não é o ideal para fazer esse tipo de comparação. Um estrutura
    mais própria para essa tarefa seria a utilização de arrays. Então modificamos o código anterior para a nova
    versão: */
    val idades = IntArray(4)
    idades[0] = 25
    idades[1] = 19
    idades[2] = 34
    idades[3] = 30

    val maiorIdade = if (idades[0] > idades[1] && idades[0] > idades[2] && idades[0] > idades[3]) {
        idades[0]
    } else if (idades[1] > idades[2] && idades[1] > idades[3]) {
        idades[1]
    } else if (idades[2] > idades[3]) {
        idades[2]
    } else {
        idades[3]
    }
    println(maiorIdade)

    /* Thirth example:
    Essa é uma forma funcional de declarar um array de idades, mas existe uma forma mais simples e mais concisa de
    fazer a mesma coisa.

    If aninhado: Um if dentro de outro if.
    If encadeado: Vários if, else if e else usados de forma sequencial, sem que um if esteja diretamente dentro de
    outro.

    Apesar de deixarmos o código um pouco mais dinâmico dessa forma, ainda não resolvemos o problema dos ifs
    encadeado. Vimos então que, para resolver o problema, precisamos utilizar uma estrutura de
    repetição para iterar por todos os elementos do array sem precisarmos descrever um por um, como exemplo de
    estrutura de repetição, utilizamos o laço for: */
    val idades: IntArray = intArrayOf(25, 19, 34, 20)

    var maiorIdade = Int.MIN_VALUE
    println("Min Value: ${maiorIdade}") /* -Min Value: -2147483648 */

    for (idade in idades) {
        if(maiorIdade < idade) {
            maiorIdade = idade
            println("Dentro do if a maior idade: ${maiorIdade}")
            /* Dentro do if a maior idade: 34 */
        }
    }

    /* Dessa forma conseguimos reduzir muito a complexidade do nosso sistema, de forma que, caso a gente precise
    adicionar mais uma idade no nosso array, não seria necessário alterar o algoritmo que identifica qual é a maior
    idade:
    Usando um algoritmo bem parecido, a gente conseguiu identificar também qual é a menor idade do array: */
    val idades: IntArray = intArrayOf(25, 19, 34, 20, 55, 40)

    var menorIdade = Int.MAX_VALUE
    println("Max Value: ${menorIdade}") /* Max Value: 2147483647 */

    idades.forEach { idade ->
        if(idade < menorIdade) {
            menorIdade = idade
            println("Dentro do if a menor idade: ${menorIdade}")
        }
    }

    /* Fouth example:
    Calcular um aumento de 10% no salário de um funcionário da empresa.
    O patrão decidiu que os funcionários devem receber um aumento de 10% sobre seus salários. No entanto, caso o
    funcionário receba menos de R$5.000, e os 10% resultem em um valor inferior a R$500,00, o aumento será ajustado
    para R$500,00.
    Por exemplo, se um funcionário ganha R$2.000, um aumento de 10% resultaria em R$200,00, o que não atende ao mínimo
    estabelecido. Nesse caso, o aumento será de R$500,00. Já para funcionários com salário superior a R$5.000, o
    aumento será de 10% normalmente.
    O cálculo deve ser feito utilizando BigDecimal (do Java) para evitar problemas de precisão, sem o uso de double.
    Além disso, exploramos como modificar arrays para aplicar um aumento de 10% nos salários dos funcionários de uma
    empresa. */
    val salarios: DoubleArray = doubleArrayOf(1500.50, 2300.0, 500.0, 8000.0, 10000.0)

    val aumento = 1.1

    for(indice in salarios.indices) {
        salarios[indice] = salarios[indice] * aumento
        println(salarios[indice])
        /* 1650.5500000000002
        2530.0
        550.0
        8800.0
        11000.0 */
    }

    /* acima salvou no array valor + 10% e abaixo vai pegar o valor do array e vai somar + 10%, por isso o valor é
    maior */
    salarios.forEachIndexed { indice, salario ->
        salarios[indice] = salario * aumento
        println("Salario no forEachIndexed: ${salarios[indice]}")
        /* Salario no forEachIndexed: 1815.6050000000002
           Salario no forEachIndexed: 2783.0
           Salario no forEachIndexed: 605.0
           Salario no forEachIndexed: 9680.0
           Salario no forEachIndexed: 12100.000000000002 */
    }


    /* Fifty example:
    Nesta lição, nós aprendemos que podemos utilizar ranges para simplificar condições que visam identificar
    intervalos: */
    val salarios: DoubleArray = doubleArrayOf(1500.50, 2300.0, 500.0, 8000.0, 10000.0, 4000.1, 3000.0)

    val base = 1500.0
    val topo = 4000.0
    var contador = 0

    for (salario in salarios) {
        if(salario in base..topo) {
            contador++
            println(salario)
            /* 1500.5
            2300.0
            3000.0 */
        }
    }

    /* Sixty example:
    Utilizando funções agregadoras em conjunto com ranges, podemos simplificar esse código para: */
    val salarios: DoubleArray = doubleArrayOf(1500.50, 2300.0, 500.0, 8000.0, 10000.0, 4000.1, 3000.0)

    val base = 1500.0
    val topo = 4000.0

    /* código simplificado */
    val contador = salarios.count { it in base..topo}
    println("Quantidade de salarios que estão entre a base e o topo: ${contador}") /* Quantidade de salarios que estão entre a base e o topo: 3 */


    /* Seventh
    Aprendemos, então, a utilizar outras funções agregadoras e
    de processamento de coleções, como uma forma mais concisa de encontrar o maior valor dentro de um array:
    val maiorIdade: Int = idades.max()
    E também o menor e a média: */
    val idades: IntArray = intArrayOf(25, 19, 33, 20, 55, 40)

    val maiorIdade : Int = idades.max() /* Maior idade: 55 */

    val menorIdade: Int = idades.min() /* Menor idade: 19 */

    val media: Double = idades.average() /* Media: 32.0 */


    /* Eighth:
    Para identificar se todos ou qualquer um dos elementos de uma lista se adequam a determinada condição, utilizamos
    respectivamente as funções all e any: */
    val idades: IntArray = intArrayOf(25, 19, 33, 20, 55, 40)

    val todosMaiores: Boolean = idades.all { it >= 18 } /* all == seria o && - Todos Maiores: true. Se existir um menor volta false */
    val existeMenor: Boolean = idades.any { it < 18 } /* any == seria || - Existe Menor: false. Se existir um menor apenas volta true */


    /* Ninith
    Vimos como filtrar valores utilizando a função filter: */
    val idades: IntArray = intArrayOf(17, 7,25, 19, 33, 20, 55, 40)

    val maiores: List<Int> = idades.filter { it >= 18 } /* Maiores: [25, 19, 33, 20, 55, 40] */
    val menores: List<Int> = idades.filter { it < 18 } /* Menores: [17, 7] */
    println("maiores: ${maiores}")
    println("menores: ${menores}")

    /* Essa função, no entanto, retorna uma lista. Caso queira continuar trabalhando com IntArray, utilize a função
     toIntArray(): Que vai retornar o hash ao invez do valor */
    val outrosMenores: IntArray = idades.filter { it < 18}.toIntArray() /* Menores: [I@7ef20235 */
    println("Menores: ${outrosMenores}")


    /* Tenth
    Para verificar se um valor específico está contido no array, ou fazer uma busca por esse valor, vimos como usar,
    respectivamente, as funções contains e find: */
    val idades: IntArray = intArrayOf(17, 7,25, 19, 33, 20, 55, 40)

    val contemDez: Boolean = idades.contains(10) /* false */
    val idade: Int? = idades.find { it == 10 } /* null */
    println("Contem Dez: ${contemDez}")
    println("Idade: ${idade}")


    /* Eleventh:
    Para fazer o cálculo dos salários do tipo BigDecimal, primeiro criamos uma função para criar o array de BigDecimal:

    vararg podemos inserir varios parametros
    indice vai navegar nos arrays de valores(no caso parametros), que podem ser inseridos quando quiserem
    e vai converter cada valor para bigdecimal e criar o array de bigdecimal */
    fun bigDecimalArrayOf(vararg valores: String): Array<BigDecimal> {
        return Array<BigDecimal>(valores.size) { indice ->
            valores[indice].toBigDecimal()
        }
    }

    /* Com essa função pronta, nós fomos capazes de criar nosso array de salários */
    val salarios = bigDecimalArrayOf("1500.55", "2000.00", "5000.00", "10000.00")


    /* Depois, vimos como calcular um aumento relativo a cada salário, em que salários maiores que R$ 5000,00 recebem um
    aumento de 10% e salários menores recebem um aumento fixo de R$ 500,00: */
    fun calculaAumentoRelativo(salario: BigDecimal, aumento: BigDecimal) : BigDecimal {
        return if (salario < "5000".toBigDecimal()) {
            salario + "500".toBigDecimal()
        } else {
            (salario * aumento).setScale(2, RoundingMode.UP) /* 2 números após a virgula e up é arredonda para cima */
        }
    }

    /* Utilizamos, então, a função map do Kotlin para realizar uma transformação do nosso array de salários atual para
     um novo array de salários com aumento:
    o map retorna uma outra Lista não um array mais sim uma Lista
    toTypeArray é para converter de Lista para Array */
    val aumento = "1.1".toBigDecimal()
    val salariosComAumento: Array<BigDecimal> = salarios.map { salario -> calculaAumentoRelativo(salario, aumento) }.toTypedArray()

    /* contentToString é para imprimir o número no terminal se não ele imprimi apenas o hash
    [Ljava.math.BigDecimal;@87aac27 ou abaixo [Ljava.math.BigDecimal;@6ce253f1 */
    println("salarios: ${salarios.contentToString()}") /* salarios: [1500.55, 2000.00, 5000.00, 10000.00] */
    println("Aumento ${aumento}") /* Aumento 1.1 */
    println("Salarios com aumento: ${salariosComAumento.contentToString()}") /* Salarios com aumento: [2000.55, 2500.00, 5500.00, 11000.00] */


    /* Twelveth:
    Numa competição de saltos ornamentais, cada competidor recebe 4 notas dos jurados. A menor nota é descartada e
    depois é tirada a média simples das 3 notas restantes.
    Considerando o seguinte array com as notas de um competidor: */
    val notas = intArrayOf(7, 5, 8, 9)

    /* Essas funções, exatamente nessa ordem, vão produzir o resultado desejado. */
    val media = notas.sorted().takeLast(3).average()


    /* Thirth:
    Operações compostas
           Somatoria com Reduce
           Gasto total com Fold
           Compondo operações

    Função para saber quanto que o Patrão vai gastar com os funcionarios nesse mês e quanto ele vai gastar nos próximos
    6 mesês, depois do aumento dos valores que o funcionario vão receber

    Ele quer saber qual a média dos 3 maiores salarios dos funcionarios dele depois do aumento

    Antes de tudo precisa identificar quais são os 3 maiores salarios e depois tirar uma média deles umas das formas para
    fazer: Pegar todos os array de salario ordenar do menor para o maior e pegar os 3 ultimos valores e sabemos que os
    3 são os ultimos maiores

    Nesta aula, para calcular a soma do array de salários, criamos uma extension function para os arrays do tipo
    BigDecimal, utilizando a função reduce: */
    fun Array<BigDecimal>.somatoria(): BigDecimal {
        return this.reduce { acumulador, valor ->
            /* acumulador + valor
            Acumulador: 2000.55
            Valor: 2500.00
             2000.55 + 2500.00 == 4500.55
            Acumulador: 4500.55
            Valor: 5500.00
             4500.55 + 5500.00 = 10000.55
            Acumulador: 10000.55
            Valor: 11000.00
            1000055 + 1100000 = 21000.55
            Gasto Inicial: 21000.55
            second
            Acumulador: 2000.55
            Valor: 2500.00
             2000.55 + 2500.00 == 4500.55
            Acumulador: 4500.55
            Valor: 5500.00
             4500.55 + 5500.00 = 10000.55
            Acumulador: 10000.55
            retornar o 10000.55 */
        }
    }

    /* vararg podemos inserir varios parametros
    indice vai navegar nos arrays de valores(no caso parametros), que podem ser inseridos quando quiserem
    e vai converter cada valor para bigdecimal e criar o array de bigdecimal */
    fun bigDecimalArrayOf(vararg valores: String): Array<BigDecimal> {
        return Array<BigDecimal>(valores.size) { indice ->
            valores[indice].toBigDecimal()
        }
    }

    val salarios = bigDecimalArrayOf("1500.55", "2000.00", "5000.00", "10000.00")
    val aumento = "1.1".toBigDecimal()

    println("Salarios: ${salarios.contentToString()}") /* Salarios: [1500.55, 2000.00, 5000.00, 10000.00] */
    println("Aumento: ${aumento}") /* Aumento: 1.1 */


    fun calculaAumentoRelativo(salario: BigDecimal, aumento: BigDecimal) : BigDecimal {
        return if (salario < "5000".toBigDecimal()) {
            salario + "500".toBigDecimal()
        } else {
            (salario * aumento).setScale(2, RoundingMode.UP) /* 2 números após a virgula e up é arredonda para cima */
        }
    }

    val salariosComAumento: Array<BigDecimal> = salarios.map { salario -> calculaAumentoRelativo(salario, aumento) }.toTypedArray()

    println("salarios Com Aumento: ${salariosComAumento.contentToString()}") /* salarios Com Aumento: [2000.55, 2500.00, 5500.00, 11000.00] */

    val gastoInicial = salariosComAumento.somatoria()
    /* Acumulador: 2000.55
    Valor: 2500.00
    2000.55 + 2500.00 == 4500.55
    Acumulador: 4500.55
    Valor: 5500.00
    4500.55 + 5500.00 = 10000.55
    Acumulador: 10000.55
    Valor: 11000.00
    1000055 + 1100000 = 21000.55
    Gasto Inicial: 21000.55 */
    val meses = 6.toBigDecimal()  /* Meses: 6 */

    /* Depois utilizamos a função fold() para calcular a soma dos salários com aumento pelos próximos 6 meses,
      utilizando o retorno da função somatória como gasto inicial:

      fold() e reduce() executam operações de dobra e redução em cada grupo como uma coleção separada e retornam os
      resultados.

      fold é relativamente parecido com o reduce para fazer a somatoria, a diferença que o Fold recebe um valor inicial,
      , no fold pode colocar o gastoInicial que é o gasto com o primeiro mês */
    val gastoTotal = salariosComAumento.fold(gastoInicial) { acumulador, salario ->
        acumulador + (salario * meses).setScale(2, RoundingMode.UP)
    }

    println("Gasto Inicial: ${gastoInicial}") /* Gasto Inicial: 21000.55 */
    println("Meses: ${meses}") /* Meses: 6 */
    println("Gasto Total: ${gastoTotal}") /* Gasto Total: 147003.85 */

    /* Criamos, ainda, uma última extension function para os arrays do tipo BigDecimal para calcular a média simples
    entre os valores do array: */
    fun Array<BigDecimal>.media(): BigDecimal {
        return if(this.isEmpty()) {
            BigDecimal.ZERO
        } else {
            this.somatoria() / this.size.toBigDecimal()
        }
    }

    /* E compondo algumas funções diferentes, nós calculamos a média dos 3 maiores e dos 3 menores salários: */
    val media = salariosComAumento.sorted().take(3).toTypedArray().media()
    println("Media: ${media}") /* Media: 3333.52 */
    /* Acumulador: 2000.55
    Valor: 2500.00
    2000.55 + 2500.00 == 4500.55
    Acumulador: 4500.55
    Valor: 5500.00
    4500.55 + 5500.00 = 10000.55
    Media
    10000.55 / 3(size) */
}
