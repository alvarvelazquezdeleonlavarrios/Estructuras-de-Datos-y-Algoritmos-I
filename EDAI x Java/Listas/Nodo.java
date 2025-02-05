public class Nodo {

	public int valor, indice;
	public Nodo siguiente, anterior;

	public Nodo(){
		this.siguiente = null;
		this.anterior = null;
	}

	public Nodo(int valor){
		this.valor = valor;
		this.siguiente = null;
		this.anterior = null;
	}

}