package br.com.vraptor.bitBank.begin

interface interface1 {

    //que recebe uma senha do tipo Int e devolve um Boolean.
    fun autentica(senha: Int) : Boolean

    /*
    interface não tem o constructor () depois do nome dele como teria se fosse classe abstrata

    interface ela pode ter seus membros abstratos ou seja os filhos que vão
    implementar que vão ter fazer isso sendo que a interface
    é só um contrato e não estância, mais a propria interface pode implementar os metodos inclusive criar um
    atributo ou property porém como ela não guarda estado então apenas ficara assim
    val senha: Int e não pode ser assim val senha: Int = 7 . Importante avisar que o atributo na interface
    sempre será public e senha não pode ser publico

    Veja que a classe modelo.Diretor/modelo.Gerente que herda o modelo.FuncionarioAdmin que implementa o metodo autentica da
    interface modelo.Autenticavel
    então elas não pedirão para implementar o metodo autentica no modelo.Diretor e modelo.Gerente, porém se na classe modelo.FuncionarioAdmin
    não implememtar autentica, vai precisar implementar o metodo autentica

    ela é boa quando não quer que a classe pegue metodos que vem, da herança

    pode inserir mais de uma herança na classe

    Para usar o polimorfismo em classes que tem o mesmo comportamento, mas não herdam da mesma classe.
    Isso mesmo Podemos implementar interfaces em quaisquer classes sem carregar o legado da herança de
    uma classe que geralmente é implementada para atender um contexto específico e não permite a herança
    múltipla.


    O que aprendemos nessa aula:

    Utilizar polimorfismo para classes com contextos diferentes, no nosso exemplo: cliente e funcionário;
    Situações que valem a pena ou não manter a implementação por meio de interfaces.
    * */


}


package br.com.vraptor.bitBank.begin

import br.com.vraptor.bitBank.begin.modelo.Cliente
import br.com.vraptor.bitBank.exception.SaldoInsuficienteExeption

/*Além das palavras-chave open e final que falamos no para saber mais: herança e superclasse Any, o Kotlin permite
declarar uma classe como abstract. Ao criar uma classe abstrata(abstract), informamos que ela passará a ser abstrata e
não poderá ser instanciada, assim como se declararmos seus membros como abstratos, estes também não poderão ser
implementados.
Este é um recurso muito útil para garantir o funcionamento correto das estruturas de classes que temos e evitar
comportamentos inadequados. Então, como foi o nosso caso no vídeo Conhecendo classes abstratas, quando temos uma classe
herdável que não queremos que seja instanciada, podemos substituir o open pelo abstract e assim manter o comportamento
desejado.
Já as classes seladas, ou sealed classes, permitem um nível a mais de segurança e controle sobre a herança. As classes
seladas são originalmente abstratas e não permitem que existam subclasses fora do pacote ou módulo em que ela foi
criada, limitando as informações que são conhecidas quando ela é compilada.*/

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

    /*
    Desafio - Utilizando interfaces no contexto de contas
    Utilizamos as interfaces no contexto de funcionários, porém, podemos também estender o exemplos para o contexto de contas.
    Por exemplo, na Bytebank pode existir um novo tipo de conta chamada de conta salário.

    Esse tipo de conta costuma ter as mesmas informações e comportamentos que uma conta comum, porém com mais restrições. Por exemplo,
    não é possível usar o serviço de transferência.

    Considerando esse detalhe, aceite o desafio e crie a conta salário que tem tudo que uma conta tem, com exceção do comportamento de
    transferir. Nesta implementação, mantenha a mesma técnica de polimorfismo na transferência para contas que precisam desse comportamento
    (corrente e poupança).

    Para testar o código, tente realizar a transferência com a conta salário e confira se apresenta um problema de compilação.

    Basicamente, foi utilizada a técnica de herança para mais de uma classe, dessa forma, uma conta pode ser uma conta normal
    (modelo.ContaSalario:  modelo.Conta), como também uma conta que permite a transferência (modelo.ContaCorrente: modelo.ContaTransferivel)

    Poderia utilizar uma interface, porém, dado que a implementação de transferir é a mesma entre as classes e o código altera o saldo, não
    seria possível ter uma implementação padrão na interface e iria replicar o mesmo código em ambas as contas que precisam transferir.
    Porém, ao manter a herança esse comportamento não pode ser reutilizado por outras classes que fogem do contexto, ou seja, que não são
    contas.

    Você pode perceber que ambas as abordagens (via herança ou interface) são válidas, o mais importante é saber as vantagens e desvantagens
     e tomar a decisão que atende melhor a regra de negócio.
    * */
}