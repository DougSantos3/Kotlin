package br.com.vraptor.bitBank.begin

interface interface1 {

    /*  Recebe uma senha do tipo Int e devolve um Boolean. */
    fun autentica(senha: Int) : Boolean

    /* Interface não tem o constructor () depois do nome dele, só teria se fosse classe abstrata.

    Interface ela pode ter seus membros abstratos(metodos e atributos) ou seja os filhos que vão implementar, sendo que
    a interface é só um contrato e não estância, mais a propria interface pode implementar os metodos inclusive criar
    um atributo ou property porém como ela não guarda estado então apenas ficara assim val senha: Int e não pode ser
    assim val senha: Int = 7 . Importante avisar que o atributo na interface sempre será public e senha não pode ser
    publico.

    Interface é boa quando não quer que a classe pegue metodos que vem da herança.

    É possivel inserir mais de uma herança na classe.

    Podemos implementar interfaces em quaisquer classes sem carregar o legado da herança de uma classe que geralmente é
    implementada para atender um contexto específico e não permite a herança múltipla.

    Para usar o polimorfismo em classes que tem o mesmo comportamento, mas não herdam da mesma classe.
    Utilizar polimorfismo para classes com contextos diferentes, no nosso exemplo: cliente e funcionário. */
}

