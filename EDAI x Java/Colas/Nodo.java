public class Nodo {

	public int valor, prioridad;
	public Nodo siguiente;

	public Nodo(){
		this.siguiente = null;
	}

	public Nodo(int valor){
		this.valor = valor;
		this.siguiente = null;
	}

	public Nodo(int valor, int prioridad){
		this.valor = valor;
		this.prioridad = prioridad;
		this.siguiente = null;
	}

}