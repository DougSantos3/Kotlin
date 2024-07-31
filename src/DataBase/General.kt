package br.com.vraptor.bitBank.banco

class General {
    /*
    sql    == noSql
    tabela == documento
    query  == query



    Linhas são chamada de registros

    id name lastname phone
    1 Douglas Santos 11958674646

    Colunas são chamadas de campos
    Roberto
    Monise
    Douglas


    Conjunto de linhas e colunas são chamadas de tabelas.
    A estrutura da tabela de banco de dados é chamado de schemas.
    Estância de uma determinada entidade(customer) == linhas
    Atributos de cada entidade(customer) = colunas
    O conjunto de coluna é chamado de relação entidade(customer)



    Backfill seria forçar o cache do sistema a ir no mesmo e atualizar todo o cache



    Banco de dados gráficos: Neo4j
    Banco de dados de objeto: relm, objectdb
    Banco de dados de documento: Mongodb
    Banco de dados relacional: mysql, postgrs, sql server, oracle


    BANCO RELACIONAL
    Recebe esse nome devido a maneira que organiza os dados em relações ou tabelas de dados relacionados.
    Em um banco de dados relacional a tabela são compostas por linhas que representam estâncias de uma determinada
    entidade e colunas que representam atributos de cada entidade.
    O conjunto de colunas é chamado de relação


    NOLOCK:
    É para não ficar locado em fila, a proxima consulta não fica esperando ela ser feita para ser executada, ela
    uso esse nolock e enquanto executa a minha eu deixo liberado para que você faça, você não precisa esperar a minha
    terminar.

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

    Se você estiver lidando com transações financeiras, nunca desejará usá-lo nolock. É melhor usado para selecionar
    tabelas grandes com muitas atualizações e você não se importa se o registro obtido pode estar desatualizado.

    Os registros financeiros (e quase todos os outros registros na maioria dos aplicativos) nolock causariam estragos,
    pois você poderia ler os dados de um registro que estava sendo gravado e não obter os dados corretos.




    RELACIONAMENTO
    #1(one to one) - 1 para 1

    #2(one to much/ much to one) - Muitos para 1(1 para muitos)

    #3(much to much) - muitos para muitos

    #4(o zero para 1)

    #5(muitos para 0)

    #6(muitos para muitos)

    Se quizer remover uma com relacionamento, precisa remover as forenkey primeiro, iniciando por ela e por ultimo a
    primary key.

    Em um relacionamento um depende do outro para existir.




    JOIN
    Se eu não coloco o inner apenas join ele faz o inner join.

    Iinner join:
    Traz o que tiver repetido nas duas tabelas

    Left join:
    Traz tudo da tabela da esquerda mais o que for igual no da direita

    left outer join

    Right join:
    Ttraz tudo tabela da direita e o repetido da esquerda

    right outer join

    Full outer join:
    Traz tudo de todas as tabelas

    Full join:

    Semi join:
    O que tem na esquerda e tem na direita porém não traz os dados da direita.

    Anti join:
    O que tem na equerda e não tem na direita, inverso do acima.

    SELECT o.*
    FROM customer."Limit" l
    left JOIN customer.offer o ON l.idt_customer = o.idt_customer
    WHERE l.des_product_type = "LOAN"
    AND l.num_score >= 1080 AND l.des_rating = 'A' AND o.flg_active AND NOT o.flg_whitelist

    o.* é o apelido da tabela offer que eu dei na query. Igual o limit tem o apelido l.
}*/
