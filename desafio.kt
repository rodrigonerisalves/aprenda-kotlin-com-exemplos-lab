import kotlin.random.Random

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario {
    var nome: String = ""
}

data class ConteudoEducacional(var nome: String, val duracao: Int, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    var conteudosRestantes = conteudos.toMutableList()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        val conteudoCurso = selecionarConteudo()
        println(
            "O usuário ${usuario.nome} está matriculado na formação $nome " +
                    "no curso ${conteudoCurso.nome} com carga horária de ${conteudoCurso.duracao} horas " +
                    "e nível ${conteudoCurso.nivel}."
        )
    }

    private fun selecionarConteudo(): ConteudoEducacional {
        val conteudo = conteudosRestantes.random()
        conteudosRestantes.remove(conteudo)
        if (conteudosRestantes.isEmpty()) {
            conteudosRestantes = conteudos.toMutableList()
        }
        return conteudo
    }
}

fun main() {
    val conteudo1 = ConteudoEducacional("Kotlin", 220, Nivel.DIFICIL)
    val conteudo2 = ConteudoEducacional("Java", 220, Nivel.DIFICIL)
    val conteudo3 = ConteudoEducacional("Python", 180, Nivel.BASICO)
    val conteudo4 = ConteudoEducacional("C#", 200, Nivel.INTERMEDIARIO)
    val conteudos = listOf(conteudo1, conteudo2, conteudo3, conteudo4)

    val formacao = Formacao("Backend", conteudos)

    val nomesAleatorios = gerarNomesAleatorios(formacao.conteudos.size)
    repeat(nomesAleatorios.size) { index ->
        val usuario = Usuario()
        usuario.nome = nomesAleatorios[index]
        formacao.matricular(usuario)
    }

    val quantidadeAlunos = formacao.inscritos.size
    println("${formacao.nome} está com $quantidadeAlunos alunos devidamente matriculados com sucesso!")
}

fun gerarNomesAleatorios(quantidade: Int): List<String> {
    val nomes = listOf("João", "Maria", "Pedro", "Ana", "Carlos", "Laura").shuffled()
    return nomes.take(quantidade)
}