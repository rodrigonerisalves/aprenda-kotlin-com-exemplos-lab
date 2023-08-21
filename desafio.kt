// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario

data class ConteudoEducacional(var nome: String, val duracao: Int = 220)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("O usuário ${inscritos.indexOf(usuario) + 1} está matriculado na formação $nome e ${conteudos[0].nome} no curso ${conteudos[1].nome} com carga horária de ${conteudos[1].duracao} horas.")
    }
}

fun main() {
    val inscritos = mutableListOf<Usuario>()
    
    val conteudo1 = ConteudoEducacional("Kotlin")
    val conteudo2 = ConteudoEducacional("Java", 220)
    val conteudos = listOf(conteudo1, conteudo2)
    
    val formacao = Formacao("Backend", conteudos)
    
    val usuario = Usuario()
    formacao.matricular(usuario)
}
