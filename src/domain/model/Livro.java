package domain.model;

public class Livro {
    public String idLivro;
    public String titulo;
    public String autor;
    public LivroStatus status;

    public Livro(String idLivro, String titulo, String autor, LivroStatus status) {
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.autor = autor;
        this.status = status;
    }

    public String getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(String idLivro) {
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

    public LivroStatus getStatus() {
        return status;
    }

    public void setStatus(LivroStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("Título: %s", getTitulo());
    }
}
