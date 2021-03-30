public class ColaPrioridad {

	public Nodo inicio, fin;
	public int tamaño;

	// Constructor de la Cola
	public ColaPrioridad(){
		this.inicio = null;
		this.fin = null;
		this.tamaño = 0;
	}

	public static void main(String[] args){
		ColaPrioridad cola = new ColaPrioridad();
		Nodo tmp;

		Nodo a = new Nodo(3,5);
		Nodo b = new Nodo(7,2);
		Nodo c = new Nodo(1,8);
		Nodo d = new Nodo(5,1);
		Nodo e = new Nodo(7,1);
		Nodo f = new Nodo(4,9);

		System.out.println("Agregando elementos");
		cola.push(a);
		tmp = cola.peek(); System.out.println(tmp.valor);

		cola.push(b);
		tmp = cola.peek(); System.out.println(tmp.valor);
		cola.imprimirCola();

		cola.push(c);
		cola.imprimirCola();

		cola.push(d);
		cola.imprimirCola();

		cola.push(e);
		tmp = cola.peek(); System.out.println(tmp.valor);
		cola.imprimirCola();

		cola.push(f);
		cola.imprimirCola();

		System.out.println("Removiendo elementos");
		tmp = cola.pop();
		tmp = cola.pop(); System.out.println(tmp.valor);
		tmp = cola.pop();
		tmp = cola.pop(); System.out.println(tmp.valor);

		cola.imprimirCola();

		tmp = cola.pop();
		tmp = cola.pop(); System.out.println(tmp.valor);

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

		// Si hay más de un elemento en la Cola, hay que ordenarlos
		if (tamaño > 1){
			ordenarPrioridad(); // Verificamos que los elementos estén ordenados por prioridad
		}
		
	}

	// Remueve el elemento que se encuentra al inicio de la Cola
	public Nodo pop(){
		// Si no hay elementos en la Cola, no se puede extraer
		if (tamaño==0 && inicio==null && fin==null){
			System.out.println("\nError: no hay elementos en la Cola de Prioridad\n");
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
			System.out.println("\nError: no hay elementos en la Cola de Prioridad\n");
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
			System.out.println("\nCola de Prioridad sin elementos");
		} else { // Si hay elementos en la Cola, se muestran en pantalla
			System.out.println("\nCola de Prioridad");
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

	// Ordena los elementos de la Cola a partir de la prioridad (mayor a menor)
	public void ordenarPrioridad(){
		Nodo[] nodos = new Nodo[tamaño];
		Nodo tmp;
		boolean ordendo;

		// Llena un arreglo temporal en donde se ordenarán los elementos
		for (int i=0; i<nodos.length; i++){
			tmp = pop();
			nodos[i] = tmp;
		}

		// Ordena el arreglo temporal por prioridad
		for (int i=nodos.length-1; i>=0; i--){
			ordendo = true;

			for (int j=0; j<=i-1; j++){
				if (nodos[j].prioridad < nodos[j+1].prioridad){
					Nodo tmp2 = nodos[j+1];
					nodos[j+1] = nodos[j];
					nodos[j] = tmp2;

					ordendo = false;
				}
			}

			// La Cola ya está ordenada en la pasada actual
			if (ordendo==true){
				break;
			}
		}

		// Vuelve a llenar la Cola con los elementos ordenados
		for (int i=0; i<nodos.length; i++){
			pushOrdenado(nodos[i]);
		}
	}

	// Función auxiliar para insertar elementos ordenados por prioridad
	private void pushOrdenado(Nodo nodo){
		// Se inserta el primer elemento
		if (inicio==null && fin==null && tamaño==0){
			inicio = nodo;
			fin = nodo;
		} else { // La Cola ya contiene elementos
			fin.siguiente = nodo;
			fin = nodo;
			fin.siguiente = null;
		}

		tamaño++;
	}

}