package school.sptech;

import school.sptech.exception.ArgumentoInvalidoException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Livro {

    private String titulo;
    private String autor;
    private LocalDate dataPublicacao;
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    public Livro() {
    }

    public Livro(String titulo, String autor, LocalDate dataPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.dataPublicacao = dataPublicacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public void adicionarAvaliacao(String descricao, Double qtdEstrelas){
        if ((descricao == null) || (descricao == "") || (descricao.trim().isEmpty()) || (qtdEstrelas == null) || (qtdEstrelas < 0) || (qtdEstrelas > 5)){
            throw new ArgumentoInvalidoException();
        }
        avaliacoes.add(new Avaliacao(descricao, qtdEstrelas));
    }

    public Double calcularMediaAvaliacoes(){
        Double contador = 0.0;
        if (avaliacoes.isEmpty()){
            return 0.0;
        }else {
            for (int i = 0; i < avaliacoes.size(); i++) {
                Double avaliacaoAtual = this.avaliacoes.get(i).getQtdEstrelas();
                contador += avaliacaoAtual;

            }
            return contador / avaliacoes.size();
        }
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", dataPublicacao=" + dataPublicacao +
                ", avaliacoes=" + avaliacoes +
                '}';
    }
}
