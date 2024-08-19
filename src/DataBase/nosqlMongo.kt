package br.com.vraptor.bitBank.banco

class Mongo {
    /*
    * Mongodb



    sql == nosql

    Tabela == coleções(collection)

    select == find

    insert into ==  insertOne

    update == updateOne

    delete == deleteOne

    1 registro == documento



    buscar, inserir, atualizar e remover podem ser feitos pelo terminal ou pela ide mongo compass



    Para que um banco de dados seja de fato criado no MongoDB, ele precisa conter dados/coleções. As coleções são
    * análogas às tabelas em bancos de dados relacionais. Então, vamos inserir uma coleção no MongoDB Compass.

    O MongoDB fornece um método de criação de coleções pela linha de comando. Vamos acessar o navegador e buscar por
    * esse método, o "mongodb create collection". Em seguida, podemos abrir a documentação: db.createCollection() — MongoDB Manual.

    A documentação do MongoDB está escrita em inglês, mas, caso você não domine o idioma, pode usar o tradutor do
    *  próprio navegador. Essa opção fica na parte superior da tela . Se ela não aparecer automaticamente, basta apertar com o botão direito do mouse e selecionar "Traduzir para o português".

    O db.createCollection() é o método que utilizaremos na criação de coleções, informando o nome dessa coleção. Também
    *  temos a opção de passar algumas configurações, mas, no nosso caso, não será necessário. Vamos apenas criar a
    * coleção com o nome e deixar que o MongoDB configure por padrão. Mais abaixo, temos um exemplo de como criar a
    * coleção, fazendo db.createCollection() e passando o nome nos parênteses.

    Vamos voltar para a linha de comando e informar o método db.createCollection("series"). Nos parênteses, passaremos
    * o nome da coleção que é "series". Vamos apertar "Enter" e, automaticamente, a nossa coleção será criada. Ela tem,
    * como retorno, apenas { ok: 1 }, para sinalizar que o comando foi executado corretamente.

    Agora, vamos voltar ao MongoDB Compass e verificar se o nosso banco de dados aparecerá. No topo do menu lateral, à
    * esquerda da tela, encontramos algumas informações: a quantidade de bancos de dados criados; o número de coleções;
    * e o botão de "atualizar". Vamos pressionar esse botão e, com a atualização da página, visualizaremos o nosso
    * banco de dados, "Alura_Serie" e a nossa coleção, "series".

    Também podemos criar, tanto o banco de dados, quanto coleções. Por exemplo, nós temos uma coleção criada no
    * "Alura_Serie", mas também podemos criar outras coleções em bancos de dados que já existem.

    Vamos dar um clique em cima do banco de dados "series", todas as coleções existentes estão disponíveis.
    * Agora podemos apertar o botão "Create collection". Feito isso, aparecerá uma janela, onde informaremos o nome da
    * coleção que desejamos criar. Então, preencheremos o campo "Collection Name" com "series_02" e apertaremos
    *  "Create Collection". Pronto! Temos mais uma coleção criada.

    Para criar um banco de dados no MongoDB Compass, também no menu lateral, à esquerda, selecionaremos a opção
    * "Databases". Depois, no canto esquerdo da área central da tela, apertaremos o botão "Create database". Uma nova
    * janela será disponibilizada, e nela aparecem dois campos que vamos preencher: o nome do banco de dados,
    * "Database Name"; e o campo para criarmos a coleção, "Collection Name".

    O nome do banco de dados será "Alura_Series_02" e a coleção será "Alura". Um erro foi retornando, avisando que o
    *  nome do banco de dados não pode conter o caractere vazio/espaço. É sempre importante termos o cuidado de não
    *  deixarmos um espaço na parte final do nome, porque ele vai considerar esse espaço como parte do nome e isso não
    * é permitido.

    Após corrigirmos esse erro, basta apertar o botão "Create Database" e teremos criado mais um banco de dados pelo
    * MongoDB Compass. Vamos verificar, pela linha de comando, se esses dois bancos de dados realmente estão
    * disponíveis?

    Então, precisamos retornar ao prompt de comando e executar mais uma vez o comando show databases. Agora, além dos
    * três bancos de dados padrão, também temos o Alura_Serie e o Alura_Series_02. Mas, nós não precisamos de todos
    * esses bancos de dados. Como removemos bancos de dados e coleções no MongoDB? Estudaremos isso no próximo conteúdo





    A possibilidade de aplicar a linguagem SQL. Utilizada pelos bancos de dados relacionais, nos permite a realização
    de consultas e a manipulação de seus dados. O MongoDB é um banco de dados NoSQL. Embora possua a sua própria
    linguagem de consulta, que é bem semelhante a um JSON,  apresenta como podemos executar consultas no MongoDB
    * utilizando a linguagem SQL no NosqlBooster.



    A extensão Cosmos DB permite a escrita de MongoDB dentro do Visual Studio Code. Essa extensão permite utilizar
    bancos de dados, inclusive o Mongo DB, que estão na Azure. Além de conectar com bancos de dados na nuvem podemos
    * nos conectar a bancos de dados locais.



    O MongoDB é Open source e tem distribuição gratuita para Linux, Mac e Windows. Existem duas versões do seu servidor,
    a Community, versão que utilizaremos e que é gratuita, e a Enterprise, versão para assinantes. Também podemos
    utilizar o MongoDB na nuvem, pela versão Atlas.



    Studio3t e MongoDB Compass



    inserir

    db.users.insertOne(                  ← collection
       {
         name: "sue",                    ← field: value ↘
         age: 26,                        ← field: value →  document
         status: "pending"               ← field: value ↗

        }
      )



    Após executarmos o comando use Alura_Series para nos conectarmos ao banco de dados, podemos inserir nosso primeiro
    documento pela linha de comando. Para isso, usaremos o método insertOne.

    db.series.insertOne({
    "Série": "Fleabag",
            "Ano de lançamento": 2016,
            "Temporadas disponíveis": 2,
            "Linguagem": "Inglês",
            "IMDb Avaliação": 8.7})



    Além do insertOne, podemos usar o insertMany na inserção de mais de um documento por vez.



    db.series.insertMany([
    {        "Série": "Made in Heaven",
            "Temporadas disponíveis": 1,
            "Linguagem": "Hindi",
            "Genero": ["Drama"],
            "IMDb Avaliação": 8.3,
            "Classificação": "18+"
        },{
            "Série": "Homecoming",
            "Temporadas disponíveis": 2,
            "Linguagem": "Inglês",
            "Genero": ["Drama"],
            "IMDb Avaliação": 7.5,
            "Classificação": "16+"
        }])





    É possivel inserir dados pelo documento json ou csv importando também.



    Consultas de dados

    Filter {"Ano de lançamento": 2020}

    Project {"Série": 1, "Classificação": 1} // 1 traz o registro

    Project {"Série": 1, "Classificação": 1, _id:0}

    Sort {Série: 1} //crescente. a … z

    Sort {Série: -1}  //descrente z…a



    Find com operadores realcionais



    Filter {{"Ano de lançamento": 2018}}

    Filter {$or: {"Ano de lançamento": 2018}}

    Filter {$or: [{"Ano de lançamento": 2018}, {"Classificação": "18+"}]}

    Filter {$and: [{"Ano de lançamento": 2018}, {"Classificação": "18+"}]}

    Filter {$nor: [{"Ano de lançamento": 2018}, {"Classificação": "18+"}]}

    Filter {"Ano de lançamento": {$in: [2019, 2020]}}

    Filter {"Temporadas disponíveis": {$gt: 2}}

    Filter {"Temporadas disponíveis": {$lt: 5}}

    Project {"Série":1, "Linguagem":1, _id: 0}

    Sort {"Série": 1}



    db.users.find(                          ← collection
       { age: { $gt: 18  } },               ← query criteria
         { name: 1, address: 1 }            ← projection
    ).limit(5)                              ← cursor modifier

    db.series.find()

    db.series.find({"Ano de lançamento": 2018})

    db.series.find({},{"Série":1, "Ano de lançamento": 1, "_id":0})

    db.series.find({"Ano de lançamento": {$in: [2019,2020]}})

    db.series.find().limit(5)

    db.series.find().sort({"Série":1})

    //ordenar de forma crescente

    db.series.find({"Temporadas disponíveis": {$gte: 4}})

    //maior que 4 temporadas

    db.series.find({"Ano de lançamento": {$ne: 2020}})

    //diferente de 2020

    db.series.find({"Genero": {$all:["Ação", "Comédia"]}})

    //todos que tem ação e comédia podem ser retornados





    Atualizando

    db.users.updateMany(                 ← collection
      { age:  { $lt: 18 } },             ← update filter
        { $set:  { status: "reject" } }  ← update action
    )





    db.series.find({"Série": "Grimm"})



    test> use Alura_Series
    switched to db Alura_Series
    Alura_Series> db.series.find({"Série": "Grimm"})
    [
     {
      _id: ObjectId("62f19a1daf663aad19e5e751"),
      'Série': 'Grimm',
      'Ano de lançamento': 2012,
      'Temporadas disponíveis': 5,
       Linguagem: 'Inglês',
       Genero: ['Drama', 'Ação', 'Aventura']
     }
    ]



    db.series.updateOne({"Série": "Grimm"},{$set: {"Temporadas disponíveis": 6}})

    db.series.updateOne({"Série": "Grimm"},{$set: {"Classificação": "16+"}})

    test> use Alura_Series
    switched to db Alura_Series
    Alura_Series> db.series.find({"Série": "Grimm"})
    [
     {
      _id: ObjectId("62f19a1daf663aad19e5e751"),
      'Série': 'Grimm',
      'Ano de lançamento': 2012,
      'Temporadas disponíveis': 5,
       Linguagem: 'Inglês',
       Genero: ['Drama', 'Ação', 'Aventura']
         'Classificação':'16+'
     }
    ]

    db.series.find({"Série": {$in: ["Four More Shots Please", "Fleabag"]}})

    db.series.updateMany({"Série":{$in:["Four More Shots Please", "Fleabag"]}},{$set: {"Classificação": "18+"}})



    Removendo dados

    db.users.deleteMany(     ← collection
       { status: "reject" }  ← delete filter
    )

    Alura_Series> db.series.find({"Série": "The Boys"})

    db.series.deleteOne({"Série": "The Boys"})

    db.series.deleteMany({"Temporadas disponíveis": 1})

    Se passarmos o deleteMany() vazio, removeremos todos os documentos da coleção

    db.series.deleteMany({})*/
}