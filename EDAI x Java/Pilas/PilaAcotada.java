public class PilaAcotada {

	public Nodo tope;
	public int tamaño, tamMax;

	// Constructor de la Pila
	public PilaAcotada(int tamMax){
		this.tope = null;
		this.tamaño = 0;
		this.tamMax = tamMax;
	}

	public static void main(String[] args){
		PilaAcotada pila = new PilaAcotada(4);
		Nodo tmp;

		Nodo a = new Nodo(3);
		Nodo b = new Nodo(7);
		Nodo c = new Nodo(1);
		Nodo d = new Nodo(5);
		Nodo e = new Nodo(7);

		System.out.println("Agregando elementos");
		pila.push(a);
		tmp = pila.peek(); System.out.println(tmp.valor);
		pila.push(b);
		tmp = pila.peek(); System.out.println(tmp.valor);
		pila.push(c);
		pila.push(d);
		tmp = pila.peek(); System.out.println(tmp.valor);
		pila.push(e); // Error: no hay espacio
		tmp = pila.peek(); System.out.println(tmp.valor);

		System.out.println("Removiendo elementos");
		tmp = pila.pop();
		tmp = pila.pop(); System.out.println(tmp.valor);
		tmp = pila.pop();
		tmp = pila.pop(); System.out.println(tmp.valor);
		tmp = pila.pop();
	}

	// Agregar un elemento a la Pila
	public void push(Nodo nodo){
		// Verificar si hay espacio en la Pila
		if (tamaño==tamMax){
			System.out.println("\nError: no hay más espacio en la Pila Acotada\n");
		} else {
			// Se inserta el primer elemento
			if (tope==null && tamaño==0){
				tope = nodo;
			} else { // La Pila ya contiene elementos
				nodo.siguiente = tope;
				tope = nodo;
			}

			tamaño++;
		}
		
	}

	// Remueve el elemento que se encuentra en el tope de la Pila
	public Nodo pop(){
		// Si no hay elementos en la Pila, no se puede extraer
		if (tamaño==0 && tope==null){
			System.out.println("\nError: no hay elementos en la Pila Acotada\n");
		} else { // Si hay un elemento en el tope, se extrae
			Nodo tmp = tope;
			tope = tope.siguiente;
			tamaño--;

			return tmp;
		}

		return null;
	}

	// Muestra el elemento en el tope de la Pila sin removerlo
	public Nodo peek(){
		// Si no hay elementos en la Pila, no se puede visualizar
		if (tamaño==0 && tope==null){
			System.out.println("\nError: no hay elementos en la Pila Acotada\n");
		} else { // Si hay un elemento en el tope, se visualiza
			Nodo tmp = tope;

			return tmp;
		}

		return null;
	}

}