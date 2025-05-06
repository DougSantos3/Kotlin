package br.com.vraptor.bitBank.begin

class Begin {

    /* var ou val significa que vai ser criada uma nova variável e sem ele, significa que está usando os atributos de
    outro e não está criando.

    Heranças
    Vimos também que para tornar uma classe herdável é preciso marcá-la com a palavra-chave open porque por padrão,
    todas as classes criadas no Kotlin são automaticamente final, não podendo assim ser herdadas. A marcação final nas
    classes fica implícita e não precisa ser escrita. Para sobrescrever o metodo precisa inserir o open nele.

    Data class
    Traz umas facilidades para a gente, porém ele precisa ter no seu constructor os atributos criados ali, e o tipo
    está sendo usado que foi criado lá na super classe Plano. Então precisa transforma em uma classe para ele aceitar
    essa herança.

    Data class ele automaticamente tem o método toString que imprime os atributos da classe.

    Tipos primitivos
    Long: 64-92233720368547758089223372036854775807
    Int: 32-21474836482147483647
    Short: 16-3276832767
    Byte: 8-128127
    Double: 6416-17 significant digits (same as float in Python)
    Float: 326-7 significant digits
    Char16: UTF-16 code unit (see the section on strings - in most cases, this is one Unicode character, but it might
      be just one half of a Unicode character)
    Boolean: true or false
    string

    Tipos primitivos quando um é atribuido a outro ele passa uma cópia e não a referencia */

    val numeroX = 10
    val numeroY = numeroX
    numeroY++

    println(numeroX)  // 10
    println(numeroY)  // 11

    // Agora passar por referência

    val contaJoao = Conta()
    contaJoao.titular = “João“
    var contaMaria = contaJoao
    contaMaria.titular = “Maria“

    println(“Titular conta Joao: ${contaJoao.titular}“)
    println(“Titular conta Maria: ${contaMaria.titular}“)

    /* Ambos imprimem  Maria
    ele aponta para o mesmo, primeiro foi escrito Joao depois mudou para Maria
    acima sempre é uma estancia se você realmente quizer um novo objeto precisar estanciar */

    val contaJoao = Conta()
    val contaMaria = Conta()
}