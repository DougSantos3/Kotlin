package br.com.vraptor.bitBank.banco

class General {
    /* sql    == noSql
       tabela == documento
       query  == query

    Nolock: é para não ficar locado em fila, a proxima consulta não fica esperando ela ser feita para ser executada, ela
    uso esse nolock e enquanto executa a minha eu deixo liberado para que você faça a sua também, você não precisa
    esperar a minha terminar.

    O que se pretende com a consulta, o SGBD em questão e tipo de leitura que você pretende.

    Vamos definir dois conceitos antes:

    Leitura não confirmada ou suja "dirty read": ler dados de uma tabela que não foram confirmados por meio de commit.
    Ou seja, dados que estão temporariamente ali e podem sumir.

    leitura confirmada "committed read": ler os dados que foram confirmados e que não sumirão no meio de uma transação
    naquele instante, por exemplo.

    Quando utilizamos NOLOCK e o SGBD permite isso, serão devolvidos dados de leitura suja misturados com dados
    confirmados. Já, se você evitar o uso, serão apresentados somente os dados que foram confirmados com commit.

    Portanto, um dado que não está "commitado" deve ser tratado como um dado que não existe para certas situações.
    São raros casos que você precisa de uma leitura de "dados não confirmados", temporários na tabela em questão, pois
    eles poderiam "sumir" dada alguma situação e você ficar com resultados inconsistentes no retorno.

    Em resumo: Se o seu SGBD permitir, utilize NOLOCK quando deseja visualizar dados não confirmados e não quando
    deseja trabalhar somente com os dados que estão confirmados de fato.

    Se você estiver lidando com transações financeiras, nunca desejará usá-lo nolock. nolocké melhor usado para
    selecionar tabelas grandes com muitas atualizações e você não se importa se o registro obtido pode estar
    desatualizado.

    Os registros financeiros (e quase todos os outros registros na maioria dos aplicativos) nolock causariam estragos,
    pois você poderia ler os dados de um registro que estava sendo gravado e não obter os dados corretos.



    Se eu não coloco o inner apenas join ele faz o inner join.

    --inner join traz o que tiver repetido nas duas tabelas

    --left join traz tudo da tabela da esquerda mais o que for igual no da direita
    left outer join

    --right join traz tudo tabela da direita e o repetido da esquerda
    right outer join

    --full outer join traz tudo de todas as tabelas
    full join

    semi join seria um inner join mais ele só pega dados da tabela left

    anti join
    o que vem da tabela left mais não o que vem do inner join que tem a esquerda.

    """
    SELECT
    o.*
    FROM
    offer_manager."Limit" l
    INNER JOIN offer_manager.offer o ON l.idt_customer = o.idt_customer
    WHERE l.des_product_type = "LOAN"
    AND l.num_score >= 1080 AND l.des_rating = 'A' AND o.flg_active AND NOT o.flg_whitelist
    """

    o.* é o apelido da tabela offer que eu dei na query. Igual o limit tem o apelido l , a offer tem um. Talvez tenha
    ficado estranho porque o FROM é na limit, mas a offer está no join então ela também é pesquisável

    select o.* from offer o inner join limit l on l.idt_customer = o.idt_customer

    assim seria equivalente também



    Proposal tem um forenkey na proposal document.

    Proposal document tem uma forenkey na pendency.

    Se quizer remover uma proposta e ele tem document e pendência, precisa remover as forenkey primeiro, iniciando com a
    pendency, e proposal document por ultimo a proposal.



    Pendency depende de proposal document para existir assim como proposal document para existir depende de proposal.



    #1(one to one)

    1 para 1 - Pendency para proposal document é um para um porque é uma pendência para um documento



    #2(one to much/ much to one)

    Muitos para 1(1 para muitos) - Proposal document para proposal é muitos para um que é muitos documentos para uma
    proposta.



    #3(much to much)

    muitos para muitos



    #4

    o zero para 1



    #5

    muitos para 0

    Relacionamentos

    1 para 1 - Pendency para proposal document é um para um porque é uma pendência para um documento



    Muitos para 1(1 para muitos) - Proposal document para proposal é muitos para um que é muitos documentos para uma
    proposta.



    muitos para muitos



    o zero para 1



    muitos para 0



    entender o desenho da tabela



    Linhas são chamada de registros

    id name lastname phone

    1 Douglas Santos 11977654654



    Colunas são chamadas de campos

    Roberto

    Monise

    Douglas

    José Maria



    Conjunto de linhas e colunas são chamadas de tabelas.



    A estrutura da tabela de banco de dados é chamado de schemas



    estância de uma determinada entidade(customer) == linhas

    atributos de cada entidade(customer) = colunas

    o conjunto de coluna é chamado de relação

    entidade(customer)



    33 - Banco de Dados

    Backfill seria forçar o cache do função a ir no função e atualizar todo o cache?
    Isso Miranda



    Banco de dados gráficos: Neo4j

    Banco de dados de objeto: relm, objectdb

    Banco de dados de documento: Mongodb

    Banco de dados relacional: mysql, postgrs, sql server, oracle



    Recebe esse nome devido a maneira que organiza os dados em relações ou tabelas de dados relacionados.

    Em um banco de dados relacional a tabela são compostas por linhas que representam estâncias de uma determinada
    entidade e colunas que representam atributos de cada entidade.

    O conjunto de colunas é chamado de relação*/
}