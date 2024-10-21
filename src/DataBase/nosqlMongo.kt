package br.com.vraptor.bitBank.banco

class Mongo {
    /* sql == nosql

       Tabela == Coleções(collection)

       select == find

       insert into ==  insertOne

       update == updateOne

       delete == deleteOne

       1 registro == documento



    Buscar, inserir, atualizar e remover podem ser feitos pelo terminal ou pela IDE mongo compass





                                           Studio3t ou MongoDB Compass






                                                                Inserir

    db.users.insertOne(                  ← collection
       {
         name: "sue",                    ← field: value ↘
         age: 26,                        ← field: value →  document
         status: "pending"               ← field: value ↗

        }
      )



    Após executarmos o comando use para nos conectarmos ao banco de dados, podemos inserir nosso primeiro
    documento pela linha de comando. Para isso, usaremos o método insertOne.

    db.series.insertOne({
    "Série": "Fleabag",
            "Ano de lançamento": 2016,
            "Temporadas disponíveis": 2,
            "Linguagem": "Inglês",
            "IMDb Avaliação": 8.7})



                             Além do insertOne, podemos usar o insertMany na inserção de mais de um documento por vez.



    db.series.insertMany([
    {       "Série": "Made in Heaven",
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



                                                       Find com operadores relacionais



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



    use Series
    switched to db Series
    series> db.series.find({"Série": "Grimm"})
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

    use Series
    switched to db Series
    Series> db.series.find({"Série": "Grimm"})
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

    Series> db.series.find({"Série": "The Boys"})

    db.series.deleteOne({"Série": "The Boys"})

    db.series.deleteMany({"Temporadas disponíveis": 1})



    Se passarmos o deleteMany() vazio, removeremos todos os documentos da coleção

    db.series.deleteMany({}) */
}