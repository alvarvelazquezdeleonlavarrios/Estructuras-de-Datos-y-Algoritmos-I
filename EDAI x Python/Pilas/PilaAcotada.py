from Nodo import Nodo

class PilaAcotada:
	
	# Constructor de la Pila
    def __init__(self, tamMax):
        self.tope = None
        self.tamaño = 0
        self.tamMax = tamMax

    # Agregar un elemento a la Pila
    def push(self, nodo):
    	# Verificar si hay espacio en la Pila
        if self.tamaño == self.tamMax:
            print("\nError: no hay más espacio en la Pila Acotada\n")
        else:
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
            print("\nError: no hay elementos en la Pila Acotada\n")
        # Si hay un elemento en el tope, se extrae
        else:
            tmp = self.tope
            self.tope = self.tope.siguiente
            self.tamaño -= 1
            return tmp

    # Muestra el elemento en el tope de la Pila sin removerlo
    def peek(self):
    	# Si no hay elementos en la Pila, no se puede visualizar
        if self.tamaño == 0 and self.tope is None:
            print("\nError: no hay elementos en la Pila Acotada\n")
        # Si hay un elemento en el tope, se visualiza
        else:
            return self.tope

    def main(self):
	    pila = PilaAcotada(4)
	    tmp = None

	    a = Nodo(3)
	    b = Nodo(7)
	    c = Nodo(1)
	    d = Nodo(5)
	    e = Nodo(7)

	    print("Agregando elementos")
	    pila.push(a)
	    tmp = pila.peek()
	    print(tmp.valor)
	    pila.push(b)
	    tmp = pila.peek()
	    print(tmp.valor)
	    pila.push(c)
	    pila.push(d)
	    tmp = pila.peek()
	    print(tmp.valor)
	    pila.push(e)  # Error: no hay espacio
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


# Ejecutando el objeto
programa = PilaAcotada(4)
programa.main()