package br.unisal

data class Pessoa (
    val name: String,
    val email: String ? = null
) {
    companion object {
        fun joinNameAndEmail(name: String, email: String?) =
            "Pessoa: $name - $email"
    }
}