package br.com.vraptor.bitBank.begin;

public class Csrf {
    /* csrf(Cross-Site Request Forgery/Falsificação de solicitação entre sites)

    Você loga no site do seu banco usando o seu navegador preferido.
    A credencial do usuário é validada, um cookie é enviado na resposta da requisição HTTP. A partir desse momento, o
    navegador tem salvo no disco o cookie que te mantém autenticado.

    Você recebe um e-mail (engenharia social) que te convence a clicar em um link que abre um site arbitrário.
    Ao entrar nesse site, no corpo dele, tem um formulário.

    Esse formulário no site do atacante emula exatamente como o seu banco faz para realizar uma transferência de
    dinheiro.
    Em seguida, em algum momento, esse site arbitrário submete o formulário usando JavaScript:

    É daí que vem o nome “Cross-Site Request Forgery”. Foi forjada uma requisição Cross-Site, de um site para outro.

    O problema real é que essa requisição enviou o cookie da autenticação e o site do seu banco achará que foi você
    quem solicitou a transferência.

    O envio do cookie é feito automaticamente pelo navegador. Quando um cookie é criado, ele possui alguns atributos e
    um deles é o domain que fala ao navegador o domínio onde esse cookie pode ser transacionado. Uma vez que o site do
    atacante fez uma requisição ao domínio do seu banco através do seu navegador, o cookie disponível para esse domínio
    é enviado.

    Além disso, o Spring Security permite a proteção contra falsificação de solicitação entre sites (CSRF) por padrão.
    CSRF é um ataque que engana a vítima para que envie uma solicitação maliciosa e usa a identidade da vítima para
    executar uma função indesejada em seu nome. Se o token CSRF, usado para proteção contra esse tipo de ataque,
    estiver ausente ou incorreto, o servidor também poderá responder com o erro 403. */
}
