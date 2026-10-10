public class Nodo {
    Cancion cancion;
    Nodo prev;
    Nodo next;

    public Nodo(Cancion cancion) {
        this.cancion = cancion;
        this.prev = null;
        this.next = null;
    }
}
