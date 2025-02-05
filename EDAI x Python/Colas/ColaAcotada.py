from Nodo import Nodo

class ColaAcotada:

    # Constructor de la Cola
    def __init__(self, tamMax):
        self.inicio = None
        self.fin = None
        self.tamaño = 0
        self.tamMax = tamMax

    # Agregar un elemento a la Cola
    def push(self, nodo):
        # Verificar si hay espacio en la Cola
        if self.tamaño == self.tamMax:
            print("\nError: no hay más espacio en la Cola\n")
        else:
            # Se inserta el primer elemento
            if self.inicio is None and self.fin is None and self.tamaño == 0:
                self.inicio = nodo
                self.fin = nodo
            # La Cola ya contiene elementos
            else:
                self.fin.siguiente = nodo
                self.fin = nodo
            self.tamaño += 1

    # Remueve el elemento que se encuentra al inicio de la Cola
    def pop(self):
        # Si no hay elementos en la Cola, no se puede extraer
        if self.tamaño == 0 and self.inicio is None and self.fin is None:
            print("\nError: no hay elementos en la Cola Acotada\n")
        # Si hay un elemento al inicio, se extrae
        else:
            tmp = self.inicio
            self.inicio = self.inicio.siguiente

            # Si se remueve el último elemento, la cola queda vacía
            if self.tamaño == 1:
                self.fin = None

            self.tamaño -= 1
            return tmp

        return None

    # Muestra el elemento al inicio de la Cola sin removerlo
    def peek(self):
        # Si no hay elementos en la Cola, no se puede visualizar
        if self.tamaño == 0 and self.inicio is None and self.fin is None:
            print("\nError: no hay elementos en la Cola Acotada\n")
        # Si hay un elemento al inicio, se visualiza
        else:
            return self.inicio
        return None

    # Muestra el contenido de la Cola
    def imprimirCola(self):
        # Si no hay elementos en la Cola, no se imprime
        if self.tamaño == 0 and self.inicio is None and self.fin is None:
            print("\nCola Acotada sin elementos")
        # Si hay elementos en la Cola, se muestran en pantalla
        else:
            print("\nCola Acotada")
            print("Inicio:", self.inicio.valor)
            print("Fin:", self.fin.valor)
            print("Tamaño:", self.tamaño)
            print("Contenido:", end=" ")
            tmp = self.inicio
            while tmp is not None:
                print(tmp.valor, end=", ")
                tmp = tmp.siguiente
            print("\n")

    def main(self):
	    cola = ColaAcotada(4)
	    tmp = None

	    a = Nodo(3)
	    b = Nodo(7)
	    c = Nodo(1)
	    d = Nodo(5)
	    e = Nodo(7)

	    print("Agregando elementos")
	    cola.push(a)
	    tmp = cola.peek()
	    print(tmp.valor)
	    cola.push(b)
	    tmp = cola.peek()
	    print(tmp.valor)
	    cola.push(c)
	    cola.push(d)
	    cola.push(e)
	    tmp = cola.peek()
	    print(tmp.valor)

	    cola.imprimirCola()

	    print("Removiendo elementos")
	    tmp = cola.pop()
	    tmp = cola.pop()
	    print(tmp.valor)
	    tmp = cola.pop()
	    tmp = cola.pop()
	    print(tmp.valor)

	    cola.imprimirCola()

	    tmp = cola.pop()


# Ejecutando el objeto
programa = ColaAcotada(4)
programa.main()