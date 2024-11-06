package br.com.vraptor.bitBank.begin

class NullableOperadorElvis {
    /*Nullable pode colocar o ? que aceita o null, exemplo endereco?

    operador safe-call, ?.
    string? é do tipo string ou null

    !! variavel não pode ser null, tem que vir algo. Faz um cast de nulable para non nulable ou seja operador not-null
    assertion “!!” converte o tipo para um tipo not-null. Se o valor for nulo, resulta em NullPointerException.


    Operator Elvis ?: ele substitui o if else onde o antes do Elvis seria o if e depois dele o else, é sugar
    syntax.

    algo.metodo?.let {} //metodo pode ter um retorno null porém só entra no let se ele for diferente de null. Dentro do
    let você pode inserir um metodo!! que faz um cast para o  tipo not null(no nullable) obrigando que venha um valor
    diferente de null.

    Douglas ask:
    No kotlin quando temos 1 ponto de exclamação significa o que?

    Celso answer:
    aqui tá subentendido que ele não é nullable. Dependendo do que for feito, dá pra imprimir o tipo e pode ser que ele
    seja representado como "String!"
    mas eu não posso fazer
    val text: String! = ""
    isso o compilador não aceita
    pensa que o ! é o oposto do ?
    então se você declarar um tipo nullable, tem que ter a interrogação
    val text: String? = null

    Douglas ask:
    então
    eu sei que 2 pontos de exclamação seria non null, então seria o mesmo com 1 ou2
    ?

    Celso answer:
    aí são conceitos um pouquinho diferentes. ! e ? determinam a nulidade do tipo. O !! na verdade é um cast de um tipo
    nullable para um tipo não-nullable.

    O !! é checado em tempo de compilação mas pode dar problema em tempo de execução
    se você usa-lo em uma variável que tem valor nulo, não vai dar certo, vai ser lançada uma NullPointerException

    val texto: String? = ""
    println(texto!!) // ok

    val textoNulo: String? = null
    println(textoNulo!!) // aqui lança NullPointer*/
}