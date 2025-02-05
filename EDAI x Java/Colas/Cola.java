public class Cola {

	public Nodo inicio, fin;
	public int tamaño;

	// Constructor de la Cola
	public Cola(){
		this.inicio = null;
		this.fin = null;
		this.tamaño = 0;
	}

	public static void main(String[] args){
		Cola cola = new Cola();
		Nodo tmp;

		Nodo a = new Nodo(3);
		Nodo b = new Nodo(7);
		Nodo c = new Nodo(1);
		Nodo d = new Nodo(5);
		Nodo e = new Nodo(7);
		Nodo f = new Nodo(8);
		Nodo g = new Nodo(4);

		System.out.println("Agregando elementos");
		cola.push(a);
		tmp = cola.peek(); System.out.println(tmp.valor);
		cola.push(b);
		tmp = cola.peek(); System.out.println(tmp.valor);
		cola.push(c);
		cola.push(d);
		cola.push(e);
		tmp = cola.peek(); System.out.println(tmp.valor);
		cola.push(f);
		cola.push(g);
		tmp = cola.peek(); System.out.println(tmp.valor);

		cola.imprimirCola();

		System.out.println("Removiendo elementos");
		tmp = cola.pop();
		tmp = cola.pop(); System.out.println(tmp.valor);
		tmp = cola.pop();
		tmp = cola.pop(); System.out.println(tmp.valor);

		cola.imprimirCola();

		tmp = cola.pop();
		tmp = cola.pop(); System.out.println(tmp.valor);
		tmp = cola.pop();

		cola.imprimirCola();

		tmp = cola.pop();
	}

	// Agregar un elemento a la Cola
	public void push(Nodo nodo){
		// Se inserta el primer elemento
		if (inicio==null && fin==null && tamaño==0){
			inicio = nodo;
			fin = nodo;
		} else { // La Cola ya contiene elementos
			fin.siguiente = nodo;
			fin = nodo;
		}

		tamaño++;
	}

	// Remueve el elemento que se encuentra al inicio de la Cola
	public Nodo pop(){
		// Si no hay elementos en la Cola, no se puede extraer
		if (tamaño==0 && inicio==null && fin==null){
			System.out.println("\nError: no hay elementos en la Cola\n");
		} else { // Si hay un elemento al inicio, se extrae
			Nodo tmp = inicio;
			inicio = inicio.siguiente;

			// Si se remueve el último elemento, la cola queda vacía
			if (tamaño==1){
				fin = null;
			}

			tamaño--;

			return tmp;
		}

		return null;
	}

	// Muestra el elemento al inicio de la Cola sin removerlo
	public Nodo peek(){
		// Si no hay elementos en la Cola, no se puede visualizar
		if (tamaño==0 && inicio==null && fin==null){
			System.out.println("\nError: no hay elementos en la Cola\n");
		} else { // Si hay un elemento al inicio, se visualiza
			Nodo tmp = inicio;

			return tmp;
		}

		return null;
	}

	// Muestra el contenido de la Cola
	public void imprimirCola(){
		// Si no hay elementos en la Cola, no se imprime
		if (tamaño==0 && inicio==null && fin==null){
			System.out.println("\nCola sin elementos");
		} else { // Si hay elementos en la Cola, se muestran en pantalla
			System.out.println("\nCola");
			System.out.println("Inicio: " + this.inicio.valor);
			System.out.println("Fin: " + this.fin.valor);
			System.out.println("Tamaño: " + this.tamaño);
			System.out.print("Contenido: ");

			Nodo tmp = inicio;

			while (tmp != null){
				System.out.print(tmp.valor + ", ");
				tmp = tmp.siguiente;
			}
			System.out.println("\n");
		}
	}

}