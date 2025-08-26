package br.com.vraptor.bitBank.begin

import br.com.vraptor.bitBank.begin.modelo.Cliente
import br.com.vraptor.bitBank.exception.SaldoInsuficienteExeption

    /* Abstrato - Classe que serve como base para outras classes, fornecendo tanto:
     🔹 propriedades(atributos)
     🔹 métodos abstratos
    que devem ser implementados pelas subclasses, como também
    🔹 atributos
    🔹 métodos concretos(com comportamento padrão)

    Eles podem ser utilizados diretamente ou sobrescritos, caso deseja. Um atributo abstrato ou
    metodo é como uma "promessa" feita em uma classe abstrata ou interface de que uma propriedade/campo ou metodo vai
    existir, mas quem vai realmente definir seu valor ou implementação é a subclasse concreta.

    Quando você define um método ou atributo abstrato em uma classe abstrata, você está dizendo:
    “Qualquer classe que herdar de mim deve implementar isso.”

    🔹 Método abstrato
         É uma função sem corpo, ou seja, sem implementação.
         A subclasse concreta é obrigada a fornecer o corpo do método.

    🔹 Atributo abstrato
         É uma propriedade ou campo sem valor ou implementação definida.
         A subclasse também é obrigada a definir esse valor(ou implementá-lo como get/set, dependendo da linguagem).

         Abaixo um exemplo real */
    abstract class Animal {

        /* atributo abstrato */
        abstract val nome: String

        /* método abstrato */
        abstract fun emitirSom()

        /* método concreto */
        fun respirar() {
            println("Respirando...")
        }
    }

    class Cachorro : Animal() {

        override val nome: String = "Rex"

        override fun emitirSom() {
            println("Latindo")
        }
    }

    respirar() /* Metodo respirar já vem pronto e emitirSom() precisa ser implementado pela subclasse. */

    /* Quando temos uma classe que deve ser herdada, mas não deve ser instânciada diretamente, podemos substituí-la de
    open para abstract, assegurando que o comportamento seja mantido conforme o esperado. */
abstract class Conta(
    titular: Cliente,
    numeroDeConta: Int
) : Metodo_Estatico_Companion_Object(
    titular = titular,
    numeroDeConta = numeroDeConta
) {
    fun transfere(valor: Double, destino: Metodo_Estatico_Companion_Object) {
        if (saldo < valor) {
            throw SaldoInsuficienteExeption()
        }
        saldo -= valor
        destino.deposita(valor)
    }

    /* Utilizamos as interfaces no contexto de funcionários, porém, podemos também estender o exemplos para o contexto
    de contas salario.

    Esse tipo de conta costuma ter as mesmas informações e comportamentos que uma conta comum, porém com mais
    restrições. Não é possível usar o serviço de transferência.

    Nesta  implementação, mantenha a mesma técnica de polimorfismo na transferência para contas que precisam desse
    comportamento(corrente e poupança).
    Para testar o código, tente realizar a transferência com a conta salário e confira se apresenta um problema de
    compilação.

    Foi utilizada a técnica de herança para mais de uma classe, dessa forma, uma conta pode ser uma conta
    normal(modelo.ContaSalario:  modelo.Conta), como também uma conta que permite a transferência
    (modelo.ContaCorrente: modelo.ContaTransferivel).

    Poderia utilizar uma interface, porém, dado que a implementação de transferir é a mesma entre as classes e o
    código altera o saldo, não seria possível ter uma implementação padrão na interface e iria replicar o mesmo código
    em ambas as contas que precisam transferir.
    Porém, ao manter a herança esse comportamento não pode ser reutilizado por outras classes que fogem do contexto,
    ou seja, que não são contas.

    Você pode perceber que ambas as abordagens (via herança ou interface) são válidas, o mais importante é saber as
    vantagens e desvantagens e decidir qual a melhor para a regra de negócio. */
}