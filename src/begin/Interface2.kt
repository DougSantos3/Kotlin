package br.com.vraptor.bitBank.begin

import br.com.vraptor.bitBank.begin.modelo.Cliente
import br.com.vraptor.bitBank.exception.SaldoInsuficienteExeption

abstract class Interface2(
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
    de contas. Por exemplo, na Bytebank pode existir um novo tipo de conta chamada de conta salário.

    Esse tipo de conta costuma ter as mesmas informações e comportamentos que uma conta comum, porém com mais
    restrições. Por exemplo, não é possível usar o serviço de transferência.

    Considerando esse detalhe, aceite o desafio e crie a conta salário que tem tudo que uma conta tem, com exceção do
    comportamento de transferir. Nesta implementação, mantenha a mesma técnica de polimorfismo na transferência para
    contas que precisam desse comportamento (corrente e poupança).

    Para testar o código, tente realizar a transferência com a conta salário e confira se apresenta um problema de
    compilação.

    Basicamente, foi utilizada a técnica de herança para mais de uma classe, dessa forma, uma conta pode ser uma conta
    normal (modelo.ContaSalario:  modelo.Conta), como também uma conta que permite a transferência
    (modelo.ContaCorrente: modelo.ContaTransferivel)

    Poderia utilizar uma interface, porém, dado que a implementação de transferir é a mesma entre as classes e o código
    altera o saldo, não seria possível ter uma implementação padrão na interface e iria replicar o mesmo código em
    ambas as contas que precisam transferir. Porém, ao manter a herança esse comportamento não pode ser reutilizado
    por outras classes que fogem do contexto, ou seja, que não são contas.

    Você pode perceber que ambas as abordagens (via herança ou interface) são válidas, o mais importante é saber as
    vantagens e desvantagens e tomar a decisão que atende melhor a regra de negócio. */
}