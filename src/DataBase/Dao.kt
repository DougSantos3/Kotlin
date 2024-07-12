package br.com.vraptor.bitBank.banco

class dao {

    /*O DAO (Data Access Object) é um padrão de projeto que é frequentemente usado para abstrair e encapsular o acesso
    a um banco de dados ou a uma fonte de dados similar em uma aplicação. O principal objetivo do DAO é separar a
    lógica de acesso a dados(repository) da lógica de negócios(services), proporcionando uma camada de abstração que
    facilite a manutenção e a evolução da aplicação.

    Além disso, o padrão DAO oferece várias vantagens, como a separação de responsabilidades, facilidade para a
    aplicação de testes, simplificação da manutenção e promoção de boas práticas, tornando a aplicação mais limpa e
    segura.




    Java EE (Enterprise Edition) e suas outras especificações
    Sim, além do Java Persistence API (JPA), existem várias outras especificações Java EE (Enterprise Edition) que
    abordam diferentes aspectos do desenvolvimento de aplicativos empresariais. Algumas das principais especificações
    incluem:

    Servlets: A especificação Servlet define uma API para desenvolver aplicativos web em Java. Ela permite a criação de
    componentes Java que respondem a solicitações HTTP, como páginas da web dinâmicas, serviços da web e aplicativos
    web completos.

    JSP (JavaServer Pages): JSP é uma tecnologia que permite a criação de páginas da web dinâmicas usando Java. Ele é
    baseado em HTML e permite a inclusão de código Java embutido, facilitando a criação de interfaces de usuário
    dinâmicas e interativas.

    JSF (JavaServer Faces): JSF é uma estrutura de desenvolvimento de interface de usuário baseada em componentes para
    a criação de aplicativos web em Java. Ele simplifica o desenvolvimento de interfaces de usuário ricas e interativas,
    oferecendo componentes reutilizáveis e um modelo de programação baseado em eventos.

    JMS (Java Message Service): JMS é uma API que permite a troca de mensagens assíncronas entre aplicativos Java. Ele
    define um modelo de mensagens baseado em produtores, consumidores e filas, facilitando a integração entre sistemas
    distribuídos.

    JTA (Java Transaction API): JTA é uma especificação que define uma API para o gerenciamento de transações em
    aplicativos Java. Ele permite o controle de transações distribuídas em ambientes empresariais, garantindo a
    consistência e a atomicidade das operações.

    JAX-RS (Java API for RESTful Web Services): JAX-RS é uma API para desenvolver serviços da web RESTful em Java. Ele
    facilita a criação de serviços da web que seguem os princípios REST, permitindo a comunicação entre aplicativos
    distribuídos de forma eficiente e escalável.

    JAXB (Java Architecture for XML Binding): JAXB é uma API que permite a vinculação de objetos Java a documentos XML
    e vice-versa. Ele simplifica o processamento de dados XML em aplicativos Java, facilitando a interoperabilidade com
    sistemas externos.

    Essas são apenas algumas das muitas especificações Java EE disponíveis, cada uma abordando diferentes aspectos do
    desenvolvimento de aplicativos empresariais. O uso dessas especificações pode ajudar os desenvolvedores a criar
    aplicativos robustos, escaláveis e interoperáveis em Java.




    Especificação JPA e implementação Hibernate

    O Java Persistence API (JPA) é uma especificação do Java EE que fornece um conjunto de interfaces e anotações para
    mapeamento objeto-relacional em aplicações Java. Embora o JPA seja uma especificação, há várias implementações
    disponíveis que seguem essa especificação e oferecem funcionalidades adicionais.

    Algumas das implementações mais populares do JPA incluem:

    O JPA (Java Persistence API) e o Hibernate são tecnologias relacionadas que têm como objetivo facilitar o
    Mapeamento Objeto-Relacional (ORM) em aplicações Java, permitindo que as pessoas desenvolvedoras trabalhem com
    dados de bancos de dados relacionais usando objetos Java, em vez de escrever consultas SQL manualmente.

    O JPA é uma especificação de API Java para gerenciamento de persistência de dados. Ela define um conjunto de
    interfaces e anotações que descrevem como as entidades Java (objetos) devem ser mapeadas para tabelas de banco de
    dados e como realizar operações de CRUD (Create, Read, Update, Delete) nessas entidades.

    Já o Hibernate é uma implementação popular da especificação JPA. Ele é uma estrutura ORM completa e
    robusta que implementa os conceitos definidos pelo JPA. Além de fornecer funcionalidades de mapeamento
    objeto-relacional, o Hibernate também oferece recursos avançados, como otimização de consultas, cache de segundo
    nível e suporte a herança de entidades.

    No mundo orientado a objetos tem herança no mundo relacional não tem. Preciamos entender como essa herança vai ser
    traduzida ou mapaeada para o mundo relacional, ai temos 3 estrategias para fazer isso:
    A primeira estrategia, temos 3 classes que representam as entidades e podem ter 3 tabelas, podemos colocar tudo lá,
    a segunda, é so ter tabelas para as classes concretas, então teria uma tabela para plano avulso, e outro para plano
    assinatura, a terceira que vamos adotar é uma tabela unica onde achatamos toda a hierarquia de planos aqui, então
    vamos ter uma tabela unica que vai conter todas as colunas que estão representados nos atributos



    Anotations Hibernates

    @Entity identifcar a entidade

    @Table (name = "planos")   nomear a tabela que eles vão representar

    @Inheritance (strategy = InheritanceType.SINGLE_TABLE) ele vai receber outros dados como a herança

    @DiscriminatorColumn(name = "tipoPlano", discriminatorType = DiscriminatorTypers.String) coluna que vai trabalhar

    @DiscriminatorValue()

    @ManyToOne
    Muitos para um, varios games podem possuir o mesmo plano
    val plano: PlanoEntity = PlanoAvulsoEntity()) {}

    Muitos alugueis para um game
    @ManyToOne
    val gamer: GamerEntity = GamerEntity()) {}

    Um aluguel para muitos jogos
    @ManyToOne
    val jogo: JogoEntity = JogoEntity()


    @Entity
    class Receita (
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,

        @ManyToMany
        val ingredientes: List<Ingredientes> = ArrayList<Ingredientes>()
    )

    A anotação @ManyToMany no val ingredientes estabelece a relação de “muitos para muitos”.



    Anotações de relacionamento no JPA


    As anotações de relacionamento no JPA são usadas para mapear as relações entre entidades Java e as tabelas do banco
    de dados. Essas anotações ajudam a definir como as tabelas se relacionam umas com as outras, seja através de
    associações simples ou complexas.

    Existem várias anotações de relacionamento disponíveis no JPA para facilitar o mapeamento correto das relações,
    entre elas: @OneToOne, @OneToMany, @ManyToOne, @ManyToMany, entre outras.

    Algumas das implementações mais populares do JPA incluem:

    Hibernate: Hibernate é uma das implementações JPA mais conhecidas e amplamente usadas. Ele fornece recursos
    avançados de mapeamento objeto-relacional, consultas HQL (Hibernate Query Language) e suporte a transações. Além de
    implementar a especificação JPA, o Hibernate oferece funcionalidades exclusivas e recursos adicionais.

    EclipseLink: EclipseLink é outra implementação JPA de código aberto. Ela é desenvolvida como parte do projeto
    Eclipse e oferece recursos avançados de mapeamento objeto-relacional, como mapeamento de herança, consultas nativas
    e cache de segundo nível. O EclipseLink é usado em muitos aplicativos empresariais Java EE.

    OpenJPA: Apache OpenJPA é uma implementação do JPA desenvolvida como um projeto de código aberto pela Apache
    Software Foundation. Ele fornece suporte para mapeamento objeto-relacional, consultas JPA e transações. O OpenJPA é
    conhecido por sua facilidade de configuração e integração com outros componentes da Apache.

    DataNucleus: DataNucleus é uma implementação JPA e JDO (Java Data Objects) que oferece suporte a uma variedade de
    bancos de dados relacionais e não relacionais. Ele fornece recursos avançados de mapeamento objeto-relacional,
    consultas JPA, herança e suporte a JDO. O DataNucleus é usado em aplicativos que exigem flexibilidade e
    escalabilidade.
    Essas são algumas das principais implementações do JPA disponíveis atualmente, cada uma com suas próprias
    características e vantagens. A escolha da implementação depende dos requisitos específicos do projeto, das
    preferências da equipe de desenvolvimento e do ecossistema tecnológico em que o aplicativo está sendo desenvolvido.
    */
}