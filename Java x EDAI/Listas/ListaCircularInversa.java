public class ListaCircularInversa {

	public Nodo inicio, fin;
	public int tamaño;

	// Constructor de la Lista
	public ListaCircularInversa(){
		this.inicio = null;
		this.fin = null;
		this.tamaño = 0;
	}

	public static void main(String[] args){
		ListaCircularInversa lista = new ListaCircularInversa();
		Nodo tmp;
		int ind;

		Nodo a = new Nodo(3);
		Nodo b = new Nodo(7);
		Nodo c = new Nodo(1);
		Nodo d = new Nodo(5);
		Nodo e = new Nodo(7);
		Nodo f = new Nodo(8);
		Nodo g = new Nodo(4); // No se agrega

		System.out.println("Agregando elementos");
		lista.push(a);
		tmp = lista.peek(); System.out.println(tmp.valor);

		lista.addFin(b);
		tmp = lista.peek(); System.out.println(tmp.valor);
		
		lista.addInicio(c);
		lista.imprimirLista();

		lista.add(d,1);
		lista.imprimirLista();

		lista.add(e);
		tmp = lista.peek(); System.out.println(tmp.valor);

		lista.add(f,3);
		lista.imprimirLista();

		lista.imprimirNodos();
		tmp = lista.getNodo(5);
		tmp = lista.getNodo(1);

		ind = lista.getIndex(c);
		ind = lista.getIndex(g);
		ind = lista.getIndex(8);
		ind = lista.getIndex(7);

		tmp = lista.peekInicio(); System.out.println("Inicio Peek: " + tmp.valor);
		tmp = lista.peekFin(); System.out.println("Fin Peek: " + tmp.valor);

		//lista.clear();

		System.out.println("Removiendo elementos");
		lista.remove(2);
		tmp = lista.pop(); System.out.println(tmp.valor);

		lista.imprimirLista();

		lista.remove(b);
		lista.removeFin();

		lista.imprimirLista();

		lista.removeInicio();
		lista.imprimirLista();

		tmp = lista.pop(); System.out.println(tmp.valor);
		lista.imprimirLista();

		tmp = lista.pop();
		lista.remove(6);
	}

	// Agregar un elemento al final de la Lista
	public void add(Nodo nodo){
		// Se inserta el primer elemento
		if (inicio==null && fin==null && tamaño==0){
			inicio = nodo;
			fin = nodo;
		} else { // La Lista ya contiene elementos
			nodo.anterior = fin;
			fin = nodo;
		}

		inicio.anterior = fin;
		nodo.indice = tamaño;
		tamaño++;
	}

	// Agregar un elemento en una posición específica de la Lista
	public void add(Nodo nodo, int indice){
		// Verificar el valor del índice máximo
		if (indice >= tamaño){
			System.out.println("\nError: indice fuera de rango\n");
		} else {
			// Si se inserta al inicio de la Lista
			if (indice == 0){
				Nodo tmp = fin;
				int i;

				// Busca al elemento en el indice actual
				for (i=tamaño-1; i>=0; i--){
					tmp.indice++; // Modifica el valor de los índices
					tmp = tmp.anterior;
				}

				tmp.indice++;
				nodo.anterior = tmp.anterior;
				tmp.anterior = nodo;
				nodo.indice = i;
				inicio = nodo;

			} else {
				Nodo tmp = fin;
				int cont = tamaño-1;

				// Busca al elemento en el indice actual
				while (cont > indice){
					tmp.indice++; // Modifica el valor de los índices
					tmp = tmp.anterior;
					cont--;
				}
				tmp.indice++;
				nodo.anterior = tmp.anterior;
				tmp.anterior = nodo;
				nodo.indice = cont;

			}

			inicio.anterior = fin;
			tamaño++;
		}
		
	}

	// Agregar un elemento al inicio de la Lista
	public void addInicio(Nodo nodo){
		// Se inserta el primer elemento
		if (inicio==null && fin==null && tamaño==0){
			inicio = nodo;
			fin = nodo;
		} else { // La Lista ya contiene elementos
			inicio.anterior = nodo;
			inicio = nodo;
			inicio.anterior = null;
		}

		Nodo tmp = fin;
		int i;

		// Reasigna los índices
		for (i=tamaño; i>=0; i--){
			tmp.indice = i; // Modifica el valor de los índices
			tmp = tmp.anterior;
		}

		inicio.anterior = fin;
		tamaño++;
	}

	// Agregar un elemento al final de la Lista
	public void addFin(Nodo nodo){
		// Se inserta el primer elemento
		if (inicio==null && fin==null && tamaño==0){
			inicio = nodo;
			fin = nodo;
		} else { // La Lista ya contiene elementos
			nodo.anterior = fin;
			fin = nodo;
		}

		inicio.anterior = fin;
		nodo.indice = tamaño;
		tamaño++;
	}

	// Agregar un elemento al final de la Lista
	public void push(Nodo nodo){
		// Se inserta el primer elemento
		if (inicio==null && fin==null && tamaño==0){
			inicio = nodo;
			fin = nodo;
		} else { // La Lista ya contiene elementos
			nodo.anterior = fin;
			fin = nodo;
		}

		inicio.anterior = fin;
		nodo.indice = tamaño;
		tamaño++;
	}

	// Remueve el elemento que se encuentra al inicio de la Lista
	public void remove(){
		// Si no hay elementos en la Lista, no se puede extraer
		if (tamaño==0 && inicio==null && fin==null){
			System.out.println("\nError: no hay elementos en la Lista Circular Inversa\n");
		} else { // Si hay un elemento al inicio, se extrae

			// Si se remueve el último elemento, la cola queda vacía
			if (tamaño==1){
				inicio = null;
				fin = null;
			} else {
				Nodo tmp2 = fin;
				int cont = tamaño-1;

				// Busca al elemento anterior al indice actual
				while (cont > 1){
					tmp2.indice--;
					tmp2 = tmp2.anterior;
					cont--;
				}
				tmp2.anterior = inicio.anterior;
				tmp2.indice = cont-1;
				inicio = tmp2;

				inicio.anterior = fin;
			}

			tamaño--;
		}
	}

	// Remueve un elemento específico de la Lista, si es que se encuentra en esta
	public void remove(Nodo nodo){
		// Si no hay elementos en la Lista, no se puede extraer
		if (tamaño==0 && inicio==null && fin==null){
			System.out.println("\nError: no hay elementos en la Lista Circular Inversa\n");
		} else {
			// Verificar si existe el nodo en la Lista
			Nodo tmp = fin;
			boolean encontrado = false;

			for (int i=tamaño-1; i>=0; i--){
				if (tmp == nodo){
					encontrado = true;
					break;
				}
				tmp = tmp.anterior;
			}

			if (encontrado == false){
				System.out.println("Nodo no encontrado en la Lista Circular Inversa");
			} else { // Si el nodo está en la Lista, se extrae (analizar los casos)
				int indice = tmp.indice;
				remove(indice);
			}
		}
	}

	// Remueve un elemento en una posición específica de la Lista
	public void remove(int indice){
		// Verificar el valor del índice máximo
		if (indice >= tamaño){
			System.out.println("\nError: indice fuera de rango\n");
		} else {
			// Si se remueve el último elemento, la cola queda vacía
			if (tamaño==1){
				inicio = null;
				fin = null;
			} else {
				// Si se remueve al inicio de la Lista
				if (indice == 0){
					Nodo tmp2 = fin;
					int cont = tamaño-1;

					// Busca al elemento anterior al indice actual
					while (cont > 1){
						tmp2.indice--;
						tmp2 = tmp2.anterior;
						cont--;
					}
					tmp2.anterior = inicio.anterior;
					tmp2.indice = cont-1;
					inicio = tmp2;

				} else if (indice == tamaño-1){ // Si se remueve al final de la Lista
					Nodo tmp = fin;

					fin = tmp.anterior;
					tmp.anterior = null;

				} else { // Si se remueve dentro de la Lista
					Nodo tmp = fin;
					int cont = tamaño-1;

					// Busca al elemento siguiente al indice actual
					while (cont > indice+1){
						tmp.indice--;
						tmp = tmp.anterior;
						cont--;
					}
					tmp.indice--;
					Nodo tmp2 = tmp.anterior;
					tmp.anterior = tmp2.anterior;
					tmp2.anterior = null;
					tmp2 = null;

				}
				inicio.anterior = fin;
			}

			tamaño--;
		}
	}

	// Remueve el elemento que se encuentra al inicio de la Lista
	public void removeInicio(){
		// Si no hay elementos en la Lista, no se puede extraer
		if (tamaño==0 && inicio==null && fin==null){
			System.out.println("\nError: no hay elementos en la Lista Circular Inversa\n");
		} else { // Si hay un elemento al inicio, se extrae

			// Si se remueve el último elemento, la cola queda vacía
			if (tamaño==1){
				inicio = null;
				fin = null;
			} else {
				Nodo tmp2 = fin;
				int cont = tamaño-1;

				// Busca al elemento anterior al indice actual
				while (cont > 1){
					tmp2.indice--;
					tmp2 = tmp2.anterior;
					cont--;
				}
				tmp2.anterior = inicio.anterior;
				tmp2.indice = cont-1;
				inicio = tmp2;

				inicio.anterior = fin;
			}

			tamaño--;
		}
	}

	// Remueve el elemento que se encuentra al fin de la Lista
	public void removeFin(){
		// Si no hay elementos en la Lista, no se puede extraer
		if (tamaño==0 && inicio==null && fin==null){
			System.out.println("\nError: no hay elementos en la Lista Circular Inversa\n");
		} else { // Si hay un elemento al final, se extrae

			// Si se remueve el último elemento, la cola queda vacía
			if (tamaño==1){
				inicio = null;
				fin = null;
			} else {
				Nodo tmp = fin;

				fin = tmp.anterior;
				tmp.anterior = null;

				inicio.anterior = fin;
			}

			tamaño--;
		}
	}

	// Remueve el elemento que se encuentra al inicio de la Lista
	public Nodo pop(){
		// Si no hay elementos en la Lista, no se puede extraer
		if (tamaño==0 && inicio==null && fin==null){
			System.out.println("\nError: no hay elementos en la Lista Circular Inversa\n");
		} else { // Si hay un elemento al inicio, se extrae
			Nodo tmp = inicio;

			// Si se remueve el último elemento, la cola queda vacía
			if (tamaño==1){
				inicio = null;
				fin = null;
			} else {
				Nodo tmp2 = fin;
				int cont = tamaño-1;

				// Busca al elemento anterior al indice actual
				while (cont > 1){
					tmp2.indice--;
					tmp2 = tmp2.anterior;
					cont--;
				}
				tmp = tmp2.anterior;
				tmp2.indice = cont-1;
				tmp2.anterior = inicio.anterior;
				inicio = tmp2;

				inicio.anterior = fin;
			}

			tamaño--;

			return tmp;
		}

		return null;
	}

	// Remueve todos los elementos de la Lista
	public void clear(){
		int tam = tamaño;
		for (int i=0; i<tam; i++){
			removeInicio();
		}
		System.out.println("Lista vaciada");
	}

	// Muestra el elemento al inicio de la Lista sin removerlo
	public Nodo peek(){
		// Si no hay elementos en la Lista, no se puede visualizar
		if (tamaño==0 && inicio==null && fin==null){
			System.out.println("\nError: no hay elementos en la Lista Circular Inversa\n");
		} else { // Si hay un elemento al inicio, se visualiza
			Nodo tmp = inicio;

			return tmp;
		}

		return null;
	}

	// Muestra el elemento al inicio de la Lista sin removerlo
	public Nodo peekInicio(){
		// Si no hay elementos en la Lista, no se puede visualizar
		if (tamaño==0 && inicio==null && fin==null){
			System.out.println("\nError: no hay elementos en la Lista Circular Inversa\n");
		} else { // Si hay un elemento al inicio, se visualiza
			Nodo tmp = inicio;

			return tmp;
		}

		return null;
	}

	// Muestra el elemento al final de la Lista sin removerlo
	public Nodo peekFin(){
		// Si no hay elementos en la Lista, no se puede visualizar
		if (tamaño==0 && inicio==null && fin==null){
			System.out.println("\nError: no hay elementos en la Lista Circular Inversa\n");
		} else { // Si hay un elemento al inicio, se visualiza
			Nodo tmp = fin;

			return tmp;
		}

		return null;
	}

	// Busca el elemento que se encuentra en determinado índice
	public Nodo getNodo(int indice){
		// Si no hay elementos en la Lista, no se puede extraer
		if (tamaño==0 && inicio==null && fin==null){
			System.out.println("\nError: no hay elementos en la Lista Circular Inversa\n");
		} else if (indice >= tamaño){ // Verificar el valor del índice máximo
			System.out.println("\nError: indice fuera de rango\n");
		} else {
			Nodo tmp = fin;
			int cont = tamaño-1;

			// Busca el elemento en la Lista desde la izquierda
			while (cont > indice){
				tmp = tmp.anterior;
				cont--;
			}
			System.out.println("Nodo: " + tmp.valor + " [" + tmp.indice + "]");

			return tmp;
		}

		return null;
	}

	// Busca el índice en donde se encuentra un nodo en específico
	public int getIndex(Nodo nodo){
		// Si no hay elementos en la Lista, no se puede extraer
		if (tamaño==0 && inicio==null && fin==null){
			System.out.println("\nError: no hay elementos en la Lista Circular Inversa\n");
		} else {
			Nodo tmp = fin;
			boolean encontrado = false;
			int i;

			// Busca al elemento
			for (i=tamaño-1; i>=0; i--){
				if (tmp == nodo){
					encontrado = true;
					break;
				} else {
					tmp = tmp.anterior;
				}
			}

			if (encontrado == true){
				System.out.println("Nodo: " + tmp.valor + " [" + tmp.indice + "]");
				return i;
			} else {
				System.out.println("Nodo no encontrado [-1]");
			}

		}
		return -1;
	}

	// Busca el índice en donde se encuentra un nodo con determinado valor
	public int getIndex(int valor){
		// Si no hay elementos en la Lista, no se puede extraer
		if (tamaño==0 && inicio==null && fin==null){
			System.out.println("\nError: no hay elementos en la Lista Circular Inversa\n");
		} else {
			Nodo tmp = fin;
			boolean encontrado = false;
			int i;

			// Busca al elemento
			for (i=tamaño-1; i>=0; i--){
				if (tmp.valor == valor){
					encontrado = true;
					break;
				} else {
					tmp = tmp.anterior;
				}
			}

			if (encontrado == true){
				System.out.println("Nodo: " + tmp.valor + " [" + tmp.indice + "]");
				return i;
			} else {
				System.out.println("Nodo no encontrado [-1]");
			}

		}
		return -1;
	}

	// Muestra el contenido de la Lista
	public void imprimirLista(){
		// Si no hay elementos en la Cola, no se imprime
		if (tamaño==0 && inicio==null && fin==null){
			System.out.println("\nLista Circular Inversa sin elementos");
		} else { // Si hay elementos en la Cola, se muestran en pantalla
			System.out.println("\nLista Circular Inversa");
			System.out.println("Inicio: " + this.inicio.valor);
			System.out.println("Fin: " + this.fin.valor);
			System.out.println("Tamaño: " + this.tamaño);
			System.out.print("Contenido: ");

			Nodo tmp = fin;

			for (int i=tamaño-1; i>=0; i--){
				System.out.print(tmp.valor + " [" + tmp.indice + "], ");
				tmp = tmp.anterior;
			}
			System.out.println("\n");
		}
	}

	// Muestra el contenido de los nodos y sus relaciones en la Lista
	public void imprimirNodos(){
		if (tamaño==0 && inicio==null && fin==null){
			System.out.println("\nLista Circular Inversa sin elementos");
		} else { // Si hay elementos en la Cola, se muestran en pantalla
			System.out.println("\nNodos de la Lista Circular Inversa");
			System.out.println("Inicio: " + this.inicio.valor);
			System.out.println("Fin: " + this.fin.valor);
			System.out.println("Tamaño: " + this.tamaño);
			System.out.print("Correspondencias: ");

			Nodo tmp = fin;

			for (int i=tamaño-1; i>=0; i--){
				System.out.print(tmp.anterior.valor + " <- " +  tmp.valor +  ", ");
				tmp = tmp.anterior;
			}
			System.out.println("\n");
		}
	}

}