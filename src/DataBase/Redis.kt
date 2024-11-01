package br.com.vraptor.bitBank.banco

class Redis {
    /* Conhecemos o porquê do cache em memória não ser uma boa opção para ambientes produtivos. Sempre que fizer o
    deploy da aplicação, o cache será apagado, além de não ser escalável.

    Entendemos que para ambiente produtivo, utilizar cache distribuído é uma opção melhor, e para isso utilizamos o
    Redis.

    Para configurar o Redis devemos configurar a dependência no projeto e subir um contêiner com docker.

    Vimos como utilizar o bash do Redis para conseguir monitorar a atividade no contêiner. */
}