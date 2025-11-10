package br.com.vraptor.bitBank.begin

interface interface1 {

    /*  Recebe uma senha do tipo Int e devolve um Boolean. */
    fun autentica(senha: Int) : Boolean
    /*
        🔹 Interface

        É um contrato: define o que deve ser feito, mas não como.
        Não tem implementação de métodos (exceto default e static, mas isso é exceção).
        Uma classe pode implementar várias interfaces tanto em Java como em Kotlin.
        Serve para padronizar comportamento entre classes diferentes.

        Exemplo Java:
        public interface Animal {
            void emitirSom();
        }

        Exemplo Kotlin:
        interface Animal {
            fun emitirSom()
        }

        🔹 Classe abstrata

        Pode ter métodos abstratos (sem implementação) e também métodos concretos (com implementação).
        Pode ter atributos e construtores.
        Uma classe só pode herdar de uma única classe abstrata (limitação do Java).
        Serve para definir regras e também comportamentos comuns que as subclasses vão herdar.

        Exemplo:

        public abstract class Animal {
            // regra: quem herdar precisa implementar
            public abstract void emitirSom();

            // comportamento comum
            public void dormir() {
                System.out.println("Zzzz...");
            }
        }

        🔹 Comparando

        Interface = só contrato (regras).

        Classe abstrata = contrato + implementação parcial (regras + comportamentos comuns).
        No Spring, geralmente usamos interface + implementação concreta (@Service) porque isso facilita:
        Substituir a implementação (ex: SearchFacadeImpl hoje pode ser trocado por SearchFacadeV2Impl amanhã).
        Facilita testes unitários (mockamos a interface).

        ⚖️ Analogia simples:

        Interface = "regra do jogo" (o que pode ou não fazer).

        Classe abstrata = "regra do jogo + algumas jogadas prontas" que todos os jogadores podem reutilizar.

        Quer que eu te mostre esse mesmo exemplo (interface vs classe abstrata) aplicado ao seu caso do SearchFacade,
        para ficar bem prático dentro do Spring Boot?



        🚀 Interface vs Classe Abstrata em Java e Kotlin, aplicado ao mesmo cenário para ficar
        bem claro.

        🔹 Em Java
        Interface
        public interface SearchFacade {
            SearchResponseDTO searchByTerm(String term, String from, String to, String postalCode, String clientIp);
        }

        //Classe Abstrata
        public abstract class AbstractSearchFacade {

            // método abstrato → deve ser implementado
            public abstract SearchResponseDTO searchByTerm(String term, String from, String to, String postalCode, String clientIp);

            // método concreto → já tem comportamento
            public void logSearch(String term) {
                System.out.println("Buscando pelo termo: " + term);
            }
        }

        Implementação

        @Service
        public class SearchFacadeImpl extends AbstractSearchFacade implements SearchFacade {

            @Override
            public SearchResponseDTO searchByTerm(String term, String from, String to, String postalCode, String clientIp) {
                logSearch(term); // herdado da classe abstrata
                return new SearchResponseDTO(); // implementação real
            }
        }

        🔹 Em Kotlin
        // Interface
        interface SearchFacade {
            fun searchByTerm(term: String, from: String?, to: String?, postalCode: String?, clientIp: String?): SearchResponseDTO
        }

        // Classe Abstrata
        abstract class AbstractSearchFacade {

            abstract fun searchByTerm(term: String, from: String?, to: String?, postalCode: String?, clientIp: String?): SearchResponseDTO

            fun logSearch(term: String) {
                println("Buscando pelo termo: $term")
            }
        }

        // Implementação
        import org.springframework.stereotype.Service

        @Service
        class SearchFacadeImpl : AbstractSearchFacade(), SearchFacade {

            override fun searchByTerm(term: String, from: String?, to: String?, postalCode: String?, clientIp: String?): SearchResponseDTO {
                logSearch(term) // herdado da classe abstrata
                return SearchResponseDTO() // implementação real
            }
        }

    ⚖️ Diferença clara (Java e Kotlin)

    Característica	       Interface	                           Classe Abstrata
    Métodos abstratos	   ✅ Sempre	                                ✅ Pode ter
    Métodos concretos	   ⚠️ Apenas default e static (Java 8+)	    ✅ Pode ter normalmente
    Atributos	           ⚠️ Constantes (static final)	            ✅ Pode ter atributos normais
    Construtores	       ❌ Não	                                ✅ Pode ter
    Herança	               ✅ Múltiplas interfaces	                ❌ Só pode herdar de uma classe abstrata

    Uso no Spring Boot	Geralmente para contratos + flexibilidade	Para compartilhar regras + comportamentos comuns

    Interface: contrato puro → "o que deve ser feito".

    Classe abstrata: contrato + implementação parcial → "o que deve ser feito + algumas coisas já prontas".


    Interface não tem o constructor () depois do nome dele, só teria se fosse classe abstrata.

    Interface ela pode ter seus membros abstratos(metodos e atributos) ou seja os filhos que vão implementar, sendo que
    a interface é só um contrato e não estância, mais a propria interface pode implementar os metodos inclusive criar
    um atributo ou property porém como ela não guarda estado então apenas ficara assim val senha: Int e não pode ser
    assim val senha: Int = 7 . Importante avisar que o atributo na interface sempre será public e senha não pode ser
    publico.

    Interface é boa quando não quer que a classe pegue metodos que vem da herança.

    É possivel inserir mais de uma herança na classe.

    Podemos implementar interfaces em quaisquer classes sem carregar o legado da herança de uma classe que geralmente é
    implementada para atender um contexto específico e não permite a herança múltipla.

    Para usar o polimorfismo em classes que tem o mesmo comportamento, mas não herdam da mesma classe.
    Utilizar polimorfismo para classes com contextos diferentes, no nosso exemplo: cliente e funcionário. */
}

