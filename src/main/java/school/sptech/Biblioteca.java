package school.sptech;

import school.sptech.exception.ArgumentoInvalidoException;
import school.sptech.exception.LivroNaoEncontradoException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Biblioteca {
    private String nome;
    private List<Livro> livros = new ArrayList<>();

    public Biblioteca() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void adicionarLivro(Livro livro){
        if ((livro == null) || (livro.getTitulo() == null) || (livro.getTitulo().trim().isEmpty()) || (livro.getAutor() == null) || (livro.getAutor().trim().isEmpty()) || (livro.getDataPublicacao() == null)){
            throw new ArgumentoInvalidoException();
        }
        livros.add(livro);
    }

    public void removerLivroPorTitulo(String titulo){
        this.livros.remove(buscarLivroPorTitulo(titulo));
    }

    public Livro buscarLivroPorTitulo(String titulo){
        if ((titulo != null) && (!titulo.trim().isEmpty())){
            for (int i = 0; i < livros.size(); i++) {
                String tituloAtual = this.livros.get(i).getTitulo();
                if (titulo.equalsIgnoreCase(tituloAtual)){
                   return this.livros.get(i);
                }
            }
            throw new LivroNaoEncontradoException();
        }
        throw new ArgumentoInvalidoException();
    }

    public Integer contarLivros(){
        return livros.size();
    }

    public List<Livro> obterLivrosAteAno(Integer ano){
        List<Livro> anos = new ArrayList<>();
        for (int i = 0; i < livros.size(); i++) {
            Livro livroDaVez = this.livros.get(i);
            Integer anoAtual = this.livros.get(i).getDataPublicacao().getYear();
            if (anoAtual <= ano){
                anos.add(livroDaVez);
            }
        }
        return anos;
    }

    public List<Livro> retornarTopCincoLivros() {
        List<Livro> topCincoLivros = new ArrayList<>();
        livros.sort(Comparator.comparingDouble(Livro::calcularMediaAvaliacoes).reversed());

        for (int i = 0; i < Math.min(5, livros.size()); i++) {
            topCincoLivros.add(livros.get(i));
        }
        return topCincoLivros;
    }
}
