package br.com.vraptor.bitBank.begin

class Tipagem {
    /* Collection: Covariantes, contravariant e invariant

    interface VarianceExample<T> {
    fun producer(): T //comportamento de Covariance
    fun consumer(t: T) //comportamento de Contravariance
    fun both(t: T): T //comportamento de Invariance


    =================================  Covariance =========================================================
    Covariance implica que uma relação de subtipagem de tipos simples é preservada para os tipos complexos.

    open class Ave
    open class Passaro: Ave()
    open class Arara: Ave()

    var ave: Ave = Passaro()
    var ave2: Ave = Arara()
    ave2 = ave


    Passaro e Arara são subclasses de Ave, então nós podemos atribuir uma Arara ou um Passaro para uma Ave, isso é
    covariance.


    Contravariance
    Contravariance é o exato oposto de Covariance. Contravariance implica que uma relação de subtipagem de tipos
    simples é invertida.

    Vamos entender melhor usando o exemplo anterior:


    open class Ave
    open class Passaro: Ave()
    open class Arara: Ave()
    var arara: Arara = Ave()
    var passaro: Passaro = Ave()


    A atribuição acima apenas é permitida usando contravariance, onde a subtipagem é invertida. Nesse caso. agora Ave é
    um subtipo de Arara e Passaro.

    Invariance
    Por último, o mais simples, mas não menos importante. Invariance ignora subtipo e supertipo, o que significa que
    dado um tipo, apenas aquele tipo poderá ser consumido ou produzido, vamos a um exemplo:


    interface Invariance <T> {
    fun consumer(t: T)
    fun producer(): T
    fun both(t: T): T
    }

    Dado um tipo T, tanto o input quanto o output apenas poderá ser T. Usando esse conceito, nós podemos ter o método
    acima both(t: T): T que é tanto um consumer quanto um producer.


    ============  Covariance/out/produza/leia uma lista/Não adiciona nada na lista ==========
    ============  As variaveis vão poder ser chamada com o tipos da sub class =========
    ============  Em Java Se usa os wildcats curinga para fazer o mesmo  ===============
    ============  Sem isso nao e possivel fazer o polimorfismo =========================


    wildcard bellow

    List<? extends Number> foo1 = new Arraylist<Number>():  // Number
    List<? extends Number> foo2 = new Arraylist<Integer>():  // Integer subtipo de Number
    List<? extends Number> foo3 = new Arraylist<Double>():  // Double subtipo de Number
    List<Integer> foo4 = new Arraylist<>():  // Lista de Integer
    List<? extends Number> foo3 = new Arraylist<Double>():  // Lista de Double

    foo1 = foo4 // como Integer é subtipo de Number isso é possivel de ser feito
    foo1 = foo5 // como Double é subtipo de Number isso é possivel de ser feito

    A linguagem nos oferece uma anotação a nível de declaração para trabalhar com variance (in e out). Vamos novamente
    a um exemplo:

    interface Source<out T> { //Java: ...Source<? extends T>...
        fun nextT(): T
    }

    fun demo(strs: Source<String>) {
        val objects: Source<Any> = strs // Isso é possível já que T está
        // anotado com out, então é covariante
    }

    Podemos anotar o parâmetro de tipo T de Source para garantir que ele seja retornado (produzido) somente de membros
    de Source <T> e nunca consumido. Para fazer isso usamos o modificador de saída out. A variance é definida a nível
    declaração da classe, por isso o nome declaration-site.


     Producer Extends —Se você precisa de uma lista que produza valores do tipo T (você quer ler T’s da lista), você
     precisa declará-la com <out T> (em java: <? extends T>). Mas não é possível adicionar nada a lista.


    ============== Contravariance/in/Consuma/escrever nessa lista ===================================
    =============  Mas não há garantia de qual tipo de objeto você leia da Lista  ===================
    

    interface Comparable<in T> { //Java: ...Comparable<? super T>...
    operator fun compareTo(other: T): Int
    }

    fun demo(x: Comparable<Number>) {
        x.compareTo(1.0) // 1.0 tem tipo Double, que é um subtipo de
    // Number
        val y: Comparable<Double> = x
    // Porém, nós podemos atribuir x a uma variável do tipo Comparable<Double> e funciona
    }

    Além de out, Kotlin fornece uma anotação de variance complementar: in. Ela faz um parâmetro de tipo contravariante:
    ele só pode ser consumido e nunca produzido.

    Em java
    List<Integer> foo1 = new Arraylist<Integer>():  // Integer é uma "superclass" de Integer
    List<? super Integer> foo2 = new Arraylist<Number>():  // Number é uma superclasse de Integer
    List<? super Integer> foo3 = new Arraylist<Object>():  // Object é uma superclasse de Integer

    Perceba que com o uso do wildcard “? super Integer” nossa lista se torna contravariant, em outras palavras: sua
    subtipagem é invertida. O que nos permite atribuir qualquer supertipo de Integer a uma lista de Integer.


    Consumer Super — Se você precisa de uma lista que consuma valores do tipo T (você quer escrever T’s nessa lista),
    você precisa declará-la com <in T> (em java: <? super T>). Mas não há garantida qual tipo de objeto você leia dessa
    lista.


    Consumer Super — Se você precisa de uma lista que consuma valores do tipo T (você quer escrever T’s nessa lista),
    você precisa declará-la com <in T> (em java: <? super T>). Mas não há garantida qual tipo de objeto você leia
    dessa lista.}

    Pode sim  haver in e on no mesmo metodo, o invariance foi criado para proteger externamente não para proteger
    você de quebrar a código.

    Se colocar private na variant o que não compila vai começar a compilar. Podemos perceber que field1 agora é
    compilado sem erro. Porque? Como dito anteriormente, o conceito de variance é para te proteger de usuários
    externos, dado que agora seu field1 é private, é como se você estivesse dizendo ao compilador “eu sei o que estou
    fazendo aqui”.


    contains, containsAll e indexOf?
    Originalmente esse comportamento de consumer não deveria ser permitido por definição, mas dada a necessidade do
    comportamento, a solução é usar a anotação @UnsafeVariance. O comportamento dessa anotação é bem simples, ela
    simplesmente suprime qualquer erro de conflito de variance.

    contains = ele olha se em uma lista contem a variavel e retorna um boolean true ou false
    containsAll = Olha em duas lista se a lista b os itens contém na lista a voltando um boolean true ou false
    indexOf? = dentro de uma lista com textos ele procura se contém um texto passado como parametro retornando o indice
    de onde o texto está.
    Metodos acima por estarem dentro de uma lista passam a ser consumidores, porque precisam olhar dentro da collection



    ======================== Invariant ==========================

    public interface MutableList<E> : List<E>, MutableCollection<E> {
    override fun add(element: E): Boolean

    override fun remove(element: E): Boolean

    override fun addAll(elements: Collection<E>): Boolean
    public fun addAll(index: Int, elements: Collection<E>): Boolean

    override fun removeAll(elements: Collection<E>): Boolean
    override fun retainAll(elements: Collection<E>): Boolean
    override fun clear(): Unit



    Como podemos ver, MutableList é invariant em E. O motivo pra isso é que essa lista precisa ser tanto consumer
    quanto producer em E. Se MutableList fosse covariant(on, produtora, só leitura) em E, por exemplo, os métodos add,
    remove, addAll não seriam possíveis.

    https://medium.com/android-dev-br/generics-e-variance-em-kotlin-in-out-t-ca5ca07c9fc5 */
}