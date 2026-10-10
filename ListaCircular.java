public class ListaCircular {
    private Nodo inicio;
    private Nodo fin;
    private Nodo actual;
    private int size;

    public ListaCircular() {
        inicio = null;
        fin = null;
        actual = null;
        size = 0;
    }

    // O(1)
    public void agregarInicio(Cancion c) {
        Nodo nuevo = new Nodo(c);
        if (size == 0) {
            nuevo.next = nuevo;
            nuevo.prev = nuevo;
            inicio = nuevo;
            fin = nuevo;
            actual = nuevo;
        } else {
            nuevo.next = inicio;
            nuevo.prev = fin;
            inicio.prev = nuevo;
            fin.next = nuevo;
            inicio = nuevo;
        }
        size++;
    }

    // O(1)
    public void agregarFinal(Cancion c) {
        Nodo nuevo = new Nodo(c);
        if (size == 0) {
            nuevo.next = nuevo;
            nuevo.prev = nuevo;
            inicio = nuevo;
            fin = nuevo;
            actual = nuevo;
        } else {
            nuevo.prev = fin;
            nuevo.next = inicio;
            fin.next = nuevo;
            inicio.prev = nuevo;
            fin = nuevo;
        }
        size++;
    }

    // O(n): metodo auxiliar que devuelve el nodo con ese id (o null)
    private Nodo buscarNodoPorId(int id) {
        if (size == 0) {
            return null;
        }
        Nodo temp = inicio;
        do {
            if (temp.cancion.getId() == id) {
                return temp;
            }
            temp = temp.next;
        } while (temp != inicio);
        return null;
    }

    // O(n)
    public Cancion buscarPorId(int id) {
        Nodo n = buscarNodoPorId(id);
        return (n == null) ? null : n.cancion;
    }

    // O(n)
    public boolean seleccionarActualPorId(int id) {
        Nodo n = buscarNodoPorId(id);
        if (n == null) {
            return false;
        }
        actual = n;
        return true;
    }

    // O(n): busca el nodo y lo aisla. Si era el actual, actual pasa al siguiente.
    public boolean eliminarPorId(int id) {
        Nodo n = buscarNodoPorId(id);
        if (n == null) {
            return false;
        }
        desenlazar(n);
        return true;
    }

    // O(1)
    public boolean eliminarActual() {
        if (size == 0 || actual == null) {
            return false;
        }
        desenlazar(actual);
        return true;
    }

    // O(1): aisla un nodo ya conocido manteniendo la circularidad.
    private void desenlazar(Nodo n) {
        if (size == 1) {
            inicio = null;
            fin = null;
            actual = null;
            size = 0;
            return;
        }

        n.prev.next = n.next;
        n.next.prev = n.prev;

        if (n == inicio) {
            inicio = n.next;
        }
        if (n == fin) {
            fin = n.prev;
        }
        if (n == actual) {
            actual = n.next;
        }

        n.next = null;
        n.prev = null;
        size--;
    }

    // O(1)
    public Cancion consultarActual() {
        return (actual == null) ? null : actual.cancion;
    }

    // O(1)
    public boolean avanzar() {
        if (actual == null) {
            return false;
        }
        actual = actual.next;
        return true;
    }

    // O(1)
    public boolean retroceder() {
        if (actual == null) {
            return false;
        }
        actual = actual.prev;
        return true;
    }

    // O(n)
    public void mostrarTodos() {
        if (size == 0) {
            System.out.println("La lista esta vacia.");
            return;
        }
        Nodo temp = inicio;
        do {
            String marca = (temp == actual) ? " <-- ACTUAL" : "";
            System.out.println(temp.cancion + marca);
            temp = temp.next;
        } while (temp != inicio);
    }

    // O(1)
    public int getCantidad() {
        return size;
    }

    // O(k): reproduce k canciones desde la actual dando vueltas por la lista
    // circular. Usa un puntero local, por lo que no modifica la cancion actual.
    public void simularReproduccion(int k) {
        if (size == 0 || actual == null) {
            System.out.println("La lista esta vacia, no hay nada que reproducir.");
            return;
        }
        Nodo temp = actual;
        for (int i = 1; i <= k; i++) {
            System.out.println(i + ". Reproduciendo: " + temp.cancion);
            temp = temp.next;
        }
    }
}
