from Nodo import Nodo

class ColaPrioridadAcotada:

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
            print("\nError: no hay más espacio en la Cola de Prioridad Acotada\n")
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

            # Si hay más de un elemento en la Cola, hay que ordenarlos
            if self.tamaño > 1:
                self.ordenar_prioridad()  # Verificamos que los elementos estén ordenados por prioridad

    # Remueve el elemento que se encuentra al inicio de la Cola
    def pop(self):
        # Si no hay elementos en la Cola, no se puede extraer
        if self.tamaño == 0 and self.inicio is None and self.fin is None:
            print("\nError: no hay elementos en la Cola de Prioridad\n")
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
            print("\nError: no hay elementos en la Cola de Prioridad\n")
        # Si hay un elemento al inicio, se visualiza
        else:
            return self.inicio

        return None

    # Muestra el contenido de la Cola
    def imprimir_cola(self):
        # Si no hay elementos en la Cola, no se imprime
        if self.tamaño == 0 and self.inicio is None and self.fin is None:
            print("\nCola de Prioridad sin elementos")
        # Si hay elementos en la Cola, se muestran en pantalla
        else:
            print("\nCola de Prioridad")
            print("Inicio:", self.inicio.valor)
            print("Fin:", self.fin.valor)
            print("Tamaño:", self.tamaño)
            print("Contenido:", end=" ")

            tmp = self.inicio

            while tmp is not None:
                print(tmp.valor, end=", ")
                tmp = tmp.siguiente
            print("\n")

    def push_ordenado(self, nodo):
        # Se inserta el primer elemento
        if self.inicio is None and self.fin is None and self.tamaño == 0:
            self.inicio = nodo
            self.fin = nodo
        else:  # La Cola ya contiene elementos
            self.fin.siguiente = nodo
            self.fin = nodo
            self.fin.siguiente = None

        self.tamaño += 1

    # Ordena los elementos de la Cola a partir de la prioridad (mayor a menor)
    def ordenar_prioridad(self):
        nodos = [None] * self.tamaño
        tmp = None
        ordendo = False

        # Llena un arreglo temporal en donde se ordenarán los elementos
        for i in range(len(nodos)):
            tmp = self.pop()
            nodos[i] = tmp

        # Ordena el arreglo temporal por prioridad
        for i in range(len(nodos) - 1, -1, -1):
            ordendo = True

            for j in range(i - 1):
                if nodos[j].prioridad < nodos[j + 1].prioridad:
                    nodos[j], nodos[j + 1] = nodos[j + 1], nodos[j]
                    ordendo = False

            # La Cola ya está ordenada en la pasada actual
            if ordendo:
                break

        # Vuelve a llenar la Cola con los elementos ordenados
        for i in range(len(nodos)):
            self.push_ordenado(nodos[i])

    def main(self):
	    cola = ColaPrioridadAcotada(4)
	    tmp = None

	    nodo_a = Nodo(3, 5)
	    nodo_b = Nodo(7, 2)
	    nodo_c = Nodo(1, 8)
	    nodo_d = Nodo(5, 1)
	    nodo_e = Nodo(7, 1)

	    print("Agregando elementos")
	    cola.push(nodo_a)
	    tmp = cola.peek()
	    print(tmp.valor)

	    cola.push(nodo_b)
	    tmp = cola.peek()
	    print(tmp.valor)
	    cola.imprimir_cola()

	    cola.push(nodo_c)
	    cola.imprimir_cola()

	    cola.push(nodo_d)
	    cola.imprimir_cola()

	    cola.push(nodo_e)
	    tmp = cola.peek()
	    print(tmp.valor)
	    cola.imprimir_cola()

	    print("Removiendo elementos")
	    tmp = cola.pop()
	    tmp = cola.pop()
	    print(tmp.valor)
	    tmp = cola.pop()
	    tmp = cola.pop()
	    print(tmp.valor)

	    cola.imprimir_cola()

	    tmp = cola.pop()


# Ejecutando el objeto
programa = ColaPrioridadAcotada(4)
programa.main()