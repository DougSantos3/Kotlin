package br.com.vraptor.bitBank.begin

import br.com.vraptor.bitBank.begin.modelo.Cliente
import br.com.vraptor.bitBank.exception.FalhaAutenticacaoException
import br.com.vraptor.bitBank.exception.SaldoInsuficienteExeption

    /* Globais(acima da classe) */

    var totalDeContas: Int = 0
        private set
    /* No caso de mutáveis (var), devem ser evitadas, pois podem apresentar inconsistência por permitir a edição em
        vários pontos do código, e vimos esse problema acontecendo no contador. Porém, não temos esse problema com
        properties globais imutáveis (val). */
    const val taxaAdicional = 0.1

    class Produto(
        private val nome: String,
        private val valor: Double
) {

    val preco: Double get() = valor + (valor * taxaAdicional)

    companion object {
        const val taxaAdicional = 0.1
    }

}

   /* Sugere o uso de constantes em tempo de compilação (Compile-Time Constants), que são properties imutáveis que não
    mudam o seu estado, como é o caso de tipos primitivos ou Strings, e que não tenham um getter personalizado: */


    const val taxaAdicional = 0.1

    //Temos o seguinte resultado com a delegação de propriedade:

    abstract class Conta(
    val titular: Cliente,
    val numeroDeConta: Int

    /* Com apenas a syntax Autenticavel by titular, é feita a delegação de implementação, como fizemos. A restrição
    nesse caso é que precisamos operar com properties val, pois não é possível modificar a implementação depois de
    criarmos uma conta. */
) :

abstract class Metodo_Estatico_Companion_Object(
    /* Ajuste o código da conta para que componha uma property do tipo Cliente. Para isso, faça com que o titular seja
    um Cliente. */
    var titular: Cliente,
    val numeroDeConta: Int,
) : interface1 {
    var saldo: Double = 0.0
        protected set

    override fun autentica(senha: Int): Boolean {
        return titular.autentica(senha)
    }

    /* Properties e modificadores de acesso

        Além das properties, ou propriedades das classes, que definimos com var e val dependendo de sua mutabilidade,
        também temos as propriedades que definem o acesso para leitura ou alteração de informações por meio dos getters
        e setters, que são declaradas utilizando a seguinte sintaxe: */

        var nome = "Jeni"
        get
        set

    /* Através da utilização dessas properties, também podemos definir os modificadores de visibilidade dos atributos
        de uma classe sem precisar modificar a visibilidade do atributo diretamente. Isso nos permite especificar quais
        acessos queremos permitir.

        palavra static não existe no Kotlin, nos temos outra abordagem para criar metodos que podemos chamar
        estaticamente isso seria a extension function mais o companion object também ajuda a gente nisso.

        O companion object é um recurso que permite criar elementos estáticos dentro de uma classe. Isso permite que
        seus membros possam ser acessados diretamente sem necessidade de criar uma instância.
        Criamos nossa função criarGamer dentro do companion object. */

    companion object {
            fun criarGamer(leitura: Scanner): Gamer {
                println("Boas vindas ao VRaptor Games! Vamos fazer seu cadastro. Digite seu nome:")
                val nome = leitura.nextLine()
                println("Digite seu e-mail:")
                val email = leitura.nextLine()
                println("Deseja completar seu cadastro com usuário e data de nascimento? (S/N)")
                val opcao = leitura.nextLine()

                if (opcao.equals("s", true)) {
                    println("Digite sua data de nascimento(DD/MM/AAAA):")
                    val nascimento = leitura.nextLine()
                    println("Digite seu nome de usuário:")
                    val usuario = leitura.nextLine()

                    return Gamer(nome, email, nascimento, usuario)
                } else {
                    return Gamer (nome, email)
                }

            }
    }

    /* Para saber mais sobre o companion object e ver outros exemplos de aplicação, você pode acessar a documentação
        sobre o assunto https://kotlinlang.org/docs/object-declarations.html#companion-objects.

        Em seguida, vamos criar um companion object, que é como se fosse o static do Java, para fazermos algumas
        configurações do nosso teste. */
    companion object {
        var total = 0
            private set
    }

    object Contador {
        val total = 0
    }
    /* object declaration ele fica acima da classe ou dentro de uma classe porém não dentro de uma função como a main por
       exemplo, caso precisa usar dentro da função você sera obrigado a usar o object expression, ele faz parte da classe e
       não da estancia então não tem objeto apenas o metodo estatico Conta.contador,
       ja trabalha igual ao metodos estaticos sendo chamado assim Conta. Contador.total, sim o Contador é com maiuscula
       é o singleton que é uma tecnica que cria um unico objeto, que ele vai ser mantido desde o
       começo do programa até o final que é muito parecido com que vimos na property global
       Ele não pode ficar dentro de uma função por ser singleton, então
       ele pode ficar fora da função igual a variavel global, ou dentro de uma classe mais fora de uma função. Porém se
       dentro da object declaration você inserir protected em um membro fora dele que seria na classe não vai conseguir
       enxergar ele, ai uma solução seria criar um metodo que incrementa o contador e fora na classe chama o metodo que
       incrementa, porém um problema com essa maneira seria que as outras contas que estão em outras classes dentro do
       mesmo arquivo, conseguem acessar esse metodo, é ruim todas as classes fazerem o incremento sendo que deve ser apenas
        a
       Conta que deve implementar, mais é melhor remover o metodo de incrementa e usa o companion object que vai fazer que
       o object declaration compartilhe o membro total    para a classe conta, abaixo no fechamento da chave já vai poder
       chamar. As declarações de objeto ou object declarations criam um Singleton de maneira fácil. Como mencionado,
       trata-se de um padrão de projeto com o objetivo de criar uma instância única


       Companion object - objetos companheiros ele faz um objeto declaration compartilhar os seus membros dentro de uma
       classe. Quando coloca o companion object pode remover o nome do objeto declaration, porque o prorio companion vai
       inserir o nome do objeto de companion, ele continua sendo um object declaration porém com o nome Companion, se
       coloca  um nome ele ignora o companion e fica o nome que você inseriu. Companion object é um object declarations.
       Ele também faz virar um metodo estatico pos pode ser chamado pela classe sem estância

       O bacana acima que quem tem o controle é a classe não é o objeto ou classes que herdam dessa classe e sim a propria
       classe,
       quando queremos trabalhar apenas com o membros da classe não do objeto


        seria uma especie de constructor secundario porém não precisa passar parametro, ele já inicializa


        Para saber mais: validações ao construir objetos
        O init é utilizado para inicializar uma classe ou um bloco de código que faz parte do processo de inicialização de
        uma classe. Podemos utilizá-lo para executar alguma lógica de inicialização ou alguma configuração adicional para a
        classe, por exemplo, e ele é sempre executado logo após a execução do construtor primário.

        No vídeo anterior, utilizamos o init para validar dois atributos na criação do Gamer: o nome e o e-mail.
        Dessa forma, conseguimos garantir que o Gamer só seria criado após passar por essas verificações.

        Para conhecer mais sobre o init, sua relação com os construtores e também outros exemplos de utilização, confira a
        documentação.*/

    init {
        println("Criando conta")
        total++
    }

    fun deposita(valor: Double) {
        if (valor > 0) {
            this.saldo += valor
        }
    }

    abstract fun saca(valor: Double)

    /* Caso você tenha experiência com outras linguagens, como o Java, já teve que lidar com exceções checked e
    unchecked. Por mais que o Kotlin opere na JVM, não existem exceções checked no Kotlin */

    fun transfere(valor: Double, destino: Metodo_Estatico_Companion_Object, senha: Int) {
        if(saldo < valor) {
            throw SaldoInsuficienteExeption(mensagem = "O saldo é insuficente, saldo atual: $saldo, valor a ser subtraido $valor")
        }
        if (!autentica(senha)) {
            throw FalhaAutenticacaoException()
        }
        //throw NumberFormatException()
        saldo -= valor
        destino.deposita(valor)
    }

    /* Classe abstrata não pode ser instanciada, apenas herdada por outras classes.
    Para que uma classe tenha um membro(metodo, atributo) abstrato ela precisa ser abstrata.

    private as filhas não podem acessar os atributos do pai
    protected as filhas podem acessar os atributos dos pais,
    a refencia val douglas: modelo.Conta = modelo.ContaCorrente() não consegue acessar o saldo

    public remove o protected set acima e fica publica, e pode se acessada por todos

    Além de public, private ou protected, no Kotlin temos o modificador de acesso conhecido
    como internal, que tem o objetivo de restringir o acesso para o módulo do projeto.
    módulo é um assunto mais avançado, que tem uma melhor discussão quando utilizamos build
    tools(ant, maven, gradle) em nossos projetos. Para mais detalhes, confira a documentação. */
}