package br.unisal

fun main() {
    val name = "Vinnicius Gomes";
    val email = "vinniciusgomes@outlook.com.br";

    val pessoa = Pessoa(name, email);

    println(
        pessoa
    );

    println(
        pessoa
            .copy(name = "Vinnicius")
    );

    println(
        Pessoa(name)
    )

    println(
        Pessoa.joinNameAndEmail(
            pessoa.name,
            pessoa?.email
        )
    )
}