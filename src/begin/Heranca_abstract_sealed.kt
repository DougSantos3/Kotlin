
class Herança/abstract/sealed {

    /* Além das palavras-chave open e final, o Kotlin permite declarar uma classe como abstract. Ao criar uma classe
    abstrata, informamos que ela passará a ser abstrata e não poderá ser instânciada, assim como se declararmos seus
    membros como abstratos, estes também não poderão ser implementados.

    Este é um recurso muito útil para garantir o funcionamento correto das estruturas de classes que temos e evitar
    comportamentos inadequados. Quando temos uma classe herdável que não queremos que seja instanciada, podemos
    substituir o open pelo abstract e assim manter o comportamento desejado.

    Já as classes seladas, ou sealed classes, permitem um nível a mais de segurança e controle sobre a herança. As
    classes seladas são originalmente abstratas e não permitem que existam subclasses fora do pacote ou módulo em que
    ela foi criada, limitando as informações que são conhecidas quando ela é compilada. */
}