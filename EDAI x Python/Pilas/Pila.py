from Nodo import Nodo

class Pila:
	
	# Constructor de la Pila
    def __init__(self):
        self.tope = None
        self.tamaño = 0

    # Agregar un elemento a la Pila
    def push(self, nodo):
    	# Se inserta el primer elemento
        if self.tope is None and self.tamaño == 0:
            self.tope = nodo
        # La Pila ya contiene elementos
        else:
            nodo.siguiente = self.tope
            self.tope = nodo
        self.tamaño += 1

    # Remueve el elemento que se encuentra en el tope de la Pila
    def pop(self):
    	# Si no hay elementos en la Pila, no se puede extraer
        if self.tamaño == 0 and self.tope is None:
            print("\nError: no hay elementos en la Pila\n")
        # Si hay un elemento en el tope, se extrae
        else:
            tmp = self.tope
            self.tope = self.tope.siguiente
            self.tamaño -= 1
            return tmp

        return None

    # Muestra el elemento en el tope de la Pila sin removerlo
    def peek(self):
    	# Si no hay elementos en la Pila, no se puede visualizar
        if self.tamaño == 0 and self.tope is None:
            print("\nError: no hay elementos en la Pila\n")
        # Si hay un elemento en el tope, se visualiza
        else:
            return self.tope

        return None

    def main(self):
	    pila = Pila()
	    tmp = None

	    a = Nodo(3)
	    b = Nodo(7)
	    c = Nodo(1)
	    d = Nodo(5)
	    e = Nodo(7)
	    f = Nodo(8)
	    g = Nodo(4)

	    print("Agregando elementos")
	    pila.push(a)
	    tmp = pila.peek()
	    print(tmp.valor)
	    pila.push(b)
	    tmp = pila.peek()
	    print(tmp.valor)
	    pila.push(c)
	    pila.push(d)
	    pila.push(e)
	    tmp = pila.peek()
	    print(tmp.valor)
	    pila.push(f)
	    pila.push(g)
	    tmp = pila.peek()
	    print(tmp.valor)

	    print("Removiendo elementos")
	    tmp = pila.pop()
	    tmp = pila.pop()
	    print(tmp.valor)
	    tmp = pila.pop()
	    tmp = pila.pop()
	    print(tmp.valor)

	    tmp = pila.pop()
	    tmp = pila.pop()
	    print(tmp.valor)
	    tmp = pila.pop()
	    tmp = pila.pop()


# Ejecutando el objeto
programa = Pila()
programa.main()