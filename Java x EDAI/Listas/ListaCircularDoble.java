public class ListaCircularDoble {

	public Nodo inicio, fin;
	public int tamaño;

	// Constructor de la Lista
	public ListaCircularDoble(){
		this.inicio = null;
		this.fin = null;
		this.tamaño = 0;
	}

	public static void main(String[] args){
		ListaCircularDoble lista = new ListaCircularDoble();
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
			fin.siguiente = nodo;
			nodo.anterior = fin;
			fin = nodo;
		}

		fin.siguiente = inicio;
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
				nodo.siguiente = inicio;
				inicio.anterior = nodo;
				inicio = nodo;

				Nodo tmp = inicio;
				
				// Modificando valores de índices
				for (int i=0; i<tamaño+1; i++){
					tmp.indice = i;
					tmp = tmp.siguiente;
				}

			} else {
				Nodo tmp;
				int cont;

				// Se agrega desde la izquierda
				if (indice <= tamaño/2){
					tmp = inicio;
					cont = 0;

					// Busca al elemento anterior al indice actual
					while (cont < indice-1){
						tmp = tmp.siguiente;
						cont++;
					}
					nodo.siguiente = tmp.siguiente;
					nodo.anterior = tmp;
					tmp.siguiente.anterior = nodo;
					tmp.siguiente = nodo;

					// Modificando valores de índices
					for (int i=cont; i<tamaño+1; i++){
						tmp.indice = i;
						tmp = tmp.siguiente;
					}

				} else { // Se agrega desde la derecha
					tmp = fin;
					cont = tamaño-1;

					// Busca al elemento anterior al indice actual
					while (cont > indice-1){
						tmp.indice++; // Modifica el valor de los índices
						tmp = tmp.anterior;
						cont--;
					}
					nodo.siguiente = tmp.siguiente;
					nodo.anterior = tmp;
					nodo.indice = cont + 1;
					tmp.siguiente.anterior = nodo;
					tmp.siguiente = nodo;
				}

			}

			fin.siguiente = inicio;
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
			nodo.siguiente = inicio;
			inicio = nodo;
		}

		Nodo tmp = inicio;
		
		// Modificando valores de índices
		for (int i=0; i<tamaño+1; i++){
			tmp.indice = i;
			tmp = tmp.siguiente;
		}

		fin.siguiente = inicio;
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
			fin.siguiente = nodo;
			nodo.anterior = fin;
			fin = nodo;
		}

		fin.siguiente = inicio;
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
			fin.siguiente = nodo;
			nodo.anterior = fin;
			fin = nodo;
		}

		fin.siguiente = inicio;
		inicio.anterior = fin;
		nodo.indice = tamaño;
		tamaño++;
	}

	// Remueve el elemento que se encuentra al inicio de la Lista
	public void remove(){
		// Si no hay elementos en la Lista, no se puede extraer
		if (tamaño==0 && inicio==null && fin==null){
			System.out.println("\nError: no hay elementos en la Lista Ligada Doble\n");
		} else { // Si hay un elemento al inicio, se extrae
			Nodo tmp = inicio;
			inicio = inicio.siguiente;
			inicio.anterior = null;
			tmp.siguiente = null;

			// Si se remueve el último elemento, la cola queda vacía
			if (tamaño==1){
				inicio = null;
				fin = null;
			} else {
				Nodo tmp2 = inicio;
				
				// Modificando valores de índices
				for (int i=0; i<tamaño-1; i++){
					tmp2.indice = i;
					tmp2 = tmp2.siguiente;
				}

				fin.siguiente = inicio;
				inicio.anterior = fin;
			}

			tamaño--;
		}
	}

	// Remueve un elemento específico de la Lista, si es que se encuentra en esta
	public void remove(Nodo nodo){
		// Si no hay elementos en la Lista, no se puede extraer
		if (tamaño==0 && inicio==null && fin==null){
			System.out.println("\nError: no hay elementos en la Lista Ligada Doble\n");
		} else {
			// Verificar si existe el nodo en la Lista
			Nodo tmp = inicio;
			boolean encontrado = false;

			for (int i=0; i<tamaño-1; i++){
				if (tmp == nodo){
					encontrado = true;
					break;
				}
				tmp = tmp.siguiente;
			}

			if (encontrado == false){
				System.out.println("Nodo no encontrado en la Lista Ligada Doble");
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
					Nodo tmp = inicio;
					inicio = inicio.siguiente;
					inicio.anterior = null;
					tmp.siguiente = null;

					tmp = inicio;
					// Modificando valores de índices
					for (int i=0; i<tamaño-1; i++){
						tmp.indice = i;
						tmp = tmp.siguiente;
					}

				} else if (indice == tamaño-1){ // Si se remueve al final de la Lista
					Nodo tmp = fin;
					fin = fin.anterior;
					fin.siguiente = null;
					tmp.anterior = null;

				} else { // Si se remueve dentro de la Lista
					Nodo tmp = inicio;
					int cont = 0;

					// Busca al elemento anterior al indice actual
					while (cont < indice){
						tmp = tmp.siguiente;
						cont++;
					}
					tmp.anterior.siguiente = tmp.siguiente;
					tmp.siguiente.anterior = tmp.anterior;
					tmp = tmp.siguiente;

					// Modificando valores de índices
					for (int i=cont; i<tamaño-1; i++){
						tmp.indice = i;
						tmp = tmp.siguiente;
					}

				}
				fin.siguiente = inicio;
				inicio.anterior = fin;
			}

			tamaño--;
		}
	}

	// Remueve el elemento que se encuentra al inicio de la Lista
	public void removeInicio(){
		// Si no hay elementos en la Lista, no se puede extraer
		if (tamaño==0 && inicio==null && fin==null){
			System.out.println("\nError: no hay elementos en la Lista Ligada Doble\n");
		} else { // Si hay un elemento al inicio, se extrae
			Nodo tmp = inicio;
			inicio = inicio.siguiente;
			tmp.siguiente = null;

			// Si se remueve el último elemento, la cola queda vacía
			if (tamaño==1){
				inicio = null;
				fin = null;
			} else {
				inicio.anterior = null;
				Nodo tmp2 = inicio;
				
				// Modificando valores de índices
				for (int i=0; i<tamaño-1; i++){
					tmp2.indice = i;
					tmp2 = tmp2.siguiente;
				}

				fin.siguiente = inicio;
				inicio.anterior = fin;
			}

			tamaño--;
		}
	}

	// Remueve el elemento que se encuentra al fin de la Lista
	public void removeFin(){
		// Si no hay elementos en la Lista, no se puede extraer
		if (tamaño==0 && inicio==null && fin==null){
			System.out.println("\nError: no hay elementos en la Lista Ligada Doble\n");
		} else { // Si hay un elemento al final, se extrae
			Nodo tmp = fin;
			fin = fin.anterior;
			tmp.anterior = null;

			// Si se remueve el último elemento, la cola queda vacía
			if (tamaño==1){
				inicio = null;
				fin = null;
			} else {
				fin.siguiente = inicio;
				inicio.anterior = fin;
			}

			tamaño--;
		}
	}

	// Remueve el elemento que se encuentra al inicio de la Lista
	public Nodo pop(){
		// Si no hay elementos en la Lista, no se puede extraer
		if (tamaño==0 && inicio==null && fin==null){
			System.out.println("\nError: no hay elementos en la Lista Ligada Doble\n");
		} else { // Si hay un elemento al inicio, se extrae
			Nodo tmp = inicio;
			inicio = inicio.siguiente;
			tmp.siguiente = null;

			// Si se remueve el último elemento, la cola queda vacía
			if (tamaño==1){
				inicio = null;
				fin = null;
			} else {
				inicio.anterior = null;
				Nodo tmp2 = inicio;
				
				// Modificando valores de índices
				for (int i=0; i<tamaño-1; i++){
					tmp2.indice = i;
					tmp2 = tmp2.siguiente;
				}

				fin.siguiente = inicio;
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
			System.out.println("\nError: no hay elementos en la Lista Ligada Doble\n");
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
			System.out.println("\nError: no hay elementos en la Lista Ligada Doble\n");
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
			System.out.println("\nError: no hay elementos en la Lista Ligada Doble\n");
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
			System.out.println("\nError: no hay elementos en la Lista Ligada Simple\n");
		} else if (indice >= tamaño){ // Verificar el valor del índice máximo
			System.out.println("\nError: indice fuera de rango\n");
		} else {
			Nodo tmp;
			int cont;
			if (indice <= tamaño/2){ // Buscar desde la izquierda
				tmp = inicio;
				cont = 0;

				// Busca el elemento en la Lista desde la izquierda
				while (cont < indice){
					tmp = tmp.siguiente;
					cont++;
				}
				System.out.println("Nodo: " + tmp.valor + " [" + tmp.indice + "] (desde inicio)");
			} else { // Buscar desde la derecha
				tmp = fin;
				cont = tamaño-1;

				// Busca el elemento en la Lista desde la derecha
				while (cont > indice){
					tmp = tmp.anterior;
					cont--;
				}
				System.out.println("Nodo: " + tmp.valor + " [" + tmp.indice + "] (desde fin)");
			}

			return tmp;
		}

		return null;
	}

	// Busca el índice en donde se encuentra un nodo en específico
	public int getIndex(Nodo nodo){
		// Si no hay elementos en la Lista, no se puede extraer
		if (tamaño==0 && inicio==null && fin==null){
			System.out.println("\nError: no hay elementos en la Lista Ligada Doble\n");
		} else {
			Nodo tmp = inicio;
			boolean encontrado = false;
			int i;

			// Busca al elemento
			for (i=0; i<tamaño; i++){
				if (tmp == nodo){
					encontrado = true;
					break;
				} else {
					tmp = tmp.siguiente;
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
			System.out.println("\nError: no hay elementos en la Lista Ligada Doble\n");
		} else {
			Nodo tmp = inicio;
			boolean encontrado = false;
			int i;

			// Busca al elemento
			for (i=0; i<tamaño; i++){
				if (tmp.valor == valor){
					encontrado = true;
					break;
				} else {
					tmp = tmp.siguiente;
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
			System.out.println("\nLista Ligada Simple sin elementos");
		} else { // Si hay elementos en la Cola, se muestran en pantalla
			System.out.println("\nLista Ligada Simple");
			System.out.println("Inicio: " + this.inicio.valor);
			System.out.println("Fin: " + this.fin.valor);
			System.out.println("Tamaño: " + this.tamaño);
			System.out.print("Contenido: ");

			Nodo tmp = inicio;

			for (int i=0; i<tamaño; i++){
				System.out.print(tmp.valor + " [" + tmp.indice + "], ");
				tmp = tmp.siguiente;
			}
			System.out.println("\n");
		}
	}

	// Muestra el contenido de los nodos y sus relaciones en la Lista
	public void imprimirNodos(){
		if (tamaño==0 && inicio==null && fin==null){
			System.out.println("\nLista Ligada Simple sin elementos");
		} else { // Si hay elementos en la Cola, se muestran en pantalla
			System.out.println("\nNodos de la Lista Ligada Simple");
			System.out.println("Inicio: " + this.inicio.valor);
			System.out.println("Fin: " + this.fin.valor);
			System.out.println("Tamaño: " + this.tamaño);
			System.out.print("Correspondencias: ");

			Nodo tmp = inicio;

			for (int i=0; i<tamaño; i++){
				System.out.print(tmp.anterior.valor + " <- " + tmp.valor + " -> " + tmp.siguiente.valor + ", ");
				tmp = tmp.siguiente;
			}
			System.out.println("\n");
		}
	}

}