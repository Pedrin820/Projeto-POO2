package domain.model;

public class Livro {
    public long idLivro;
    public String titulo;
    public String autor;
    public String status;

    public Livro(Long idLivro, String titulo, String autor, String status) {
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.autor = autor;
        this.status = status;
    }

    public long getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(long idLivro) {
        this.idLivro = idLivro;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("ID: %s | Título: %s | Autor: %s | Disponibilidade: %s", getIdLivro(), getTitulo(), getAutor(), getStatus());
    }
}
