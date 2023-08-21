# Desafio  Kotlin Com Exemplos: Desafio de Projeto (Lab)

Desafio de Projeto criado para avaliação do conteúdo técnico explorado no repositório

**A [DIO](https://web.dio.me) possui `Formacoes` incríveis que têm como objetivo oferecer um conjunto de `ConteudosEducacionais` voltados para uma stack tecnológica específica, preparando profissionais de TI para o mercado de trabalho. `Formacoes` possuem algumas características importantes, como `nome`, `nivel` e seus respectivos `conteudosEducacionais`. Além disso, tais experiências educacionais têm um comportamento relevante ao nosso domínio, definido pela capacidade de `matricular` um ou mais `Alunos`.**

## 🚀 Desafio

```
Criar uma solução em Kotlin abstraindo esse domínio. O arquivo [desafiomodelo.kt] te ajudará 😉"
```

# 🔧 Apresentação do código

Declaração de classes e enumerações

Parte 1: Declaração de classes e enumerações

```
import kotlin.random.Random

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario {
    var nome: String = ""
}
```
Nesta parte do código, temos a declaração da enumeração Nivel com os possíveis valores "BASICO", "INTERMEDIARIO" e "DIFICIL". Em seguida, temos a declaração da classe Usuario com uma propriedade nome do tipo String.

Parte 2: Declaração e utilização das classes ConteudoEducacional e Formacao

kotlin
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

Nesta parte do código, temos a declaração da classe ConteudoEducacional com as propriedades nome, duracao e nivel. A classe é declarada como data class, o que significa que ela já possui funcionalidades padrão, como o toString(), equals(), entre outros.

Em seguida, temos a declaração da classe Formacao. Ela possui uma propriedade nome do tipo String e uma propriedade conteudos do tipo List<ConteudoEducacional>, que representa os conteúdos educacionais da formação.

A classe Formacao também possui outras propriedades e funções. A propriedade inscritos é uma lista mutável de usuários que se matricularam na formação. A propriedade conteudosRestantes é uma lista mutável de conteúdos educacionais que ainda não foram selecionados para matrícula.

A função matricular(usuario: Usuario) é responsável por adicionar um usuário à lista de inscritos na formação e selecionar um conteúdo educacional para ser matriculado. A função selecionarConteudo() é uma função privada que seleciona um conteúdo educacional aleatório da lista conteudosRestantes e o remove dessa lista. Caso a lista esteja vazia, a função reabastece a lista conteudosRestantes com os conteúdos iniciais.

Parte 3: Função main() e função auxiliar gerarNomesAleatorios()
```
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
Na função main()
```
São criados quatro objetos ConteudoEducacional com diferentes parâmetros. Esses objetos são adicionados à lista conteudos. Em seguida, é criado um objeto Formacao chamado formacao, que recebe o nome "Backend" e a lista de conteúdos conteudos.

A função gerarNomesAleatorios(quantidade: Int) é utilizada para criar uma lista de nomes aleatórios. Ela recebe como parâmetro a quantidade de nomes desejada e retorna uma lista de nomes embaralhados. Esses nomes são então utilizados no loop repeat dentro da função main() para criar objetos Usuario, atribuir um nome aleatório a cada um deles e matriculá-los na formacao.

Por fim, é impresso no console a mensagem com o nome da formação e a quantidade de alunos matriculados.

## 📦 Implantação

Completar todo o código

## 🛠️ Construído com

Mencione as ferramentas que você usou para criar seu projeto

* [kotlin playground](https://play.kotlinlang.org/) - Editor


## ✒️ Autores


* **Rodrigo Neris** -  [*Trabalho Inicial*](https://github.com/rodrigonerisalves)
---
⌨️ com ❤️ por [Rodrigo Neris](www.linkedin.com/in/rodrigo-neris) 😊