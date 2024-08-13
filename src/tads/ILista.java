package tads;

public interface ILista<T> {
    
    public boolean esVacia();
    public void agragarInicio(T dato);
    public void agregarOrdenado (T dato);
    public void agregarFinal(T dato);
    public void borrarInicio();
    public void borrarFinal();
    public void borrarElemento(T dato);
    public void vaciar();
    public String mostrar();
    public String mostrarElementos();
    public int cantElementos();
    public Nodo obtenerElemento(T dato);
    public boolean existeElemento (T dato); 
    
    public void agregar(T dato);
    public int tamaño();
    public T obtener (int indice);
    public String mostrarRecursivo(Nodo<T> nodo);
    
}
