public class Cancion {
    private static int contadorId = 1;

    private int id;
    private String titulo;
    private String artista;
    private int duracion; // en segundos

    public Cancion(String titulo, String artista, int duracion) {
        if (duracion <= 0) {
            // Se valida antes de tocar el contador para no "gastar" IDs.
            throw new IllegalArgumentException("La duracion debe ser mayor que 0.");
        }
        this.id = contadorId++;
        this.titulo = titulo;
        this.artista = artista;
        this.duracion = duracion;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public int getDuracion() {
        return duracion;
    }

    @Override
    public String toString() {
        return "[ID " + id + "] " + titulo + " - " + artista + " (" + duracion + " s)";
    }
}
