from Nodo import Nodo

class ListaLigadaSimple:

    # Constructor de la Lista
    def __init__(self):
        self.inicio = None
        self.fin = None
        self.tamaño = 0

    # Agregar un elemento al final de la Lista
    def addNodo(self, nodo):
        # Se inserta el primer elemento
        if self.inicio is None and self.fin is None and self.tamaño == 0:
            self.inicio = nodo
            self.fin = nodo
        else:  # La Lista ya contiene elementos
            self.fin.siguiente = nodo
            self.fin = nodo

        nodo.indice = self.tamaño
        self.tamaño += 1

    # Agregar un elemento en una posición específica de la Lista
    def add(self, nodo, indice):
        # Verificar el valor del índice máximo
        if indice >= self.tamaño:
            print("\nError: indice fuera de rango\n")
        else:
            # Si se inserta al inicio de la Lista
            if indice == 0:
                nodo.siguiente = self.inicio
                self.inicio = nodo

                tmp = self.inicio
                count = 0

                # Modificando valores de índices
                while tmp is not None:
                    tmp.indice = count
                    tmp = tmp.siguiente
                    count += 1

            else:
                tmp = self.inicio
                count = 0

                # Busca al elemento anterior al indice actual
                while count < indice - 1:
                    tmp = tmp.siguiente
                    count += 1
                nodo.siguiente = tmp.siguiente
                tmp.siguiente = nodo

                # Modificando valores de índices
                while tmp is not None:
                    tmp.indice = count
                    tmp = tmp.siguiente
                    count += 1

            self.tamaño += 1

    # Agregar un elemento al inicio de la Lista
    def addInicio(self, nodo):
        # Se inserta el primer elemento
        if self.inicio is None and self.fin is None and self.tamaño == 0:
            self.inicio = nodo
            self.fin = nodo
        else:  # La Lista ya contiene elementos
            nodo.siguiente = self.inicio
            self.inicio = nodo

        tmp = self.inicio
        count = 0

        # Modificando valores de índices
        while tmp is not None:
            tmp.indice = count
            tmp = tmp.siguiente
            count += 1

        self.tamaño += 1

    # Agregar un elemento al final de la Lista
    def addFin(self, nodo):
        # Se inserta el primer elemento
        if self.inicio is None and self.fin is None and self.tamaño == 0:
            self.inicio = nodo
            self.fin = nodo
        else:  # La Lista ya contiene elementos
            self.fin.siguiente = nodo
            self.fin = nodo

        nodo.indice = self.tamaño
        self.tamaño += 1

    # Agregar un elemento al final de la Lista
    def push(self, nodo):
        # Se inserta el primer elemento
        if self.inicio is None and self.fin is None and self.tamaño == 0:
            self.inicio = nodo
            self.fin = nodo
        else:  # La Lista ya contiene elementos
            self.fin.siguiente = nodo
            self.fin = nodo

        nodo.indice = self.tamaño
        self.tamaño += 1

    # Remueve el elemento que se encuentra al inicio de la Lista
    def remove(self):
        # Si no hay elementos en la Lista, no se puede extraer
        if self.tamaño == 0 and self.inicio is None and self.fin is None:
            print("\nError: no hay elementos en la Lista Ligada Simple\n")
        else:  # Si hay un elemento al inicio, se extrae
            tmp = self.inicio
            self.inicio = self.inicio.siguiente
            tmp.siguiente = None

            # Si se remueve el último elemento, la cola queda vacía
            if self.tamaño == 1:
                self.fin = None
            else:
                tmp2 = self.inicio
                count = 0

                # Modificando valores de índices
                while tmp2 is not None:
                    tmp2.indice = count
                    tmp2 = tmp2.siguiente
                    count += 1

            self.tamaño -= 1

    # Remueve un elemento específico de la Lista, si es que se encuentra en esta
    def removeNodo(self, nodo):
        # Si no hay elementos en la Lista, no se puede extraer
        if self.tamaño == 0 and self.inicio is None and self.fin is None:
            print("\nError: no hay elementos en la Lista Ligada Simple\n")
        else:
            # Verificar si existe el nodo en la Lista
            tmp = self.inicio
            encontrado = False

            while tmp is not None:
                if tmp == nodo:
                    encontrado = True
                    break
                tmp = tmp.siguiente

            if not encontrado:
                print("Nodo no encontrado en la Lista Ligada Simple")
            else:  # Si el nodo está en la Lista, se extrae (analizar los casos)
                indice = tmp.indice
                self.remove(indice)

    # Remueve un elemento en una posición específica de la Lista
    def remove(self, indice):
        # Verificar el valor del índice máximo
        if indice >= self.tamaño:
            print("\nError: indice fuera de rango\n")
        else:
            # Si se remueve el último elemento, la cola queda vacía
            if self.tamaño == 1:
                self.inicio = None
                self.fin = None
            else:
                # Si se remueve al inicio de la Lista
                if indice == 0:
                    tmp = self.inicio
                    self.inicio = self.inicio.siguiente
                    tmp.siguiente = None

                    count = 0

                    tmp = self.inicio
                    # Modificando valores de índices
                    while tmp is not None:
                        tmp.indice = count
                        tmp = tmp.siguiente
                        count += 1

                elif indice == self.tamaño - 1:  # Si se remueve al final de la Lista
                    tmp = self.inicio
                    count = 0

                    # Busca al elemento anterior al indice actual
                    while count < indice - 1:
                        tmp = tmp.siguiente
                        count += 1
                    tmp.siguiente = self.fin.siguiente
                    self.fin = tmp

                else:  # Si se remueve dentro de la Lista
                    tmp = self.inicio
                    count = 0

                    # Busca al elemento anterior al indice actual
                    while count < indice - 1:
                        tmp = tmp.siguiente
                        count += 1
                    tmp2 = tmp.siguiente
                    tmp.siguiente = tmp2.siguiente
                    tmp2.siguiente = None
                    tmp2 = None

                    # Modificando valores de índices
                    while tmp is not None:
                        tmp.indice = count
                        tmp = tmp.siguiente
                        count += 1

            self.tamaño -= 1

    # Remueve el elemento que se encuentra al inicio de la Lista
    def removeInicio(self):
        # Si no hay elementos en la Lista, no se puede extraer
        if self.tamaño == 0 and self.inicio is None and self.fin is None:
            print("\nError: no hay elementos en la Lista Ligada Simple\n")
        else:  # Si hay un elemento al inicio, se extrae
            tmp = self.inicio
            self.inicio = self.inicio.siguiente
            tmp.siguiente = None

            # Si se remueve el último elemento, la cola queda vacía
            if self.tamaño == 1:
                self.fin = None
            else:
                tmp2 = self.inicio
                count = 0

                # Modificando valores de índices
                while tmp2 is not None:
                    tmp2.indice = count
                    tmp2 = tmp2.siguiente
                    count += 1

            self.tamaño -= 1

    # Remueve el elemento que se encuentra al fin de la Lista
    def removeFin(self):
        # Si no hay elementos en la Lista, no se puede extraer
        if self.tamaño == 0 and self.inicio is None and self.fin is None:
            print("\nError: no hay elementos en la Lista Ligada Simple\n")
        else:  # Si hay un elemento al final, se extrae

            # Si se remueve el último elemento, la cola queda vacía
            if self.tamaño == 1:
                self.inicio = None
                self.fin = None
            else:
                tmp = self.inicio
                count = 0

                # Busca al elemento anterior al indice actual
                while count < self.tamaño - 2:
                    tmp = tmp.siguiente
                    count += 1
                tmp.siguiente = self.fin.siguiente
                self.fin = tmp

            self.tamaño -= 1

    # Remueve el elemento que se encuentra al inicio de la Lista
    def pop(self):
        # Si no hay elementos en la Lista, no se puede extraer
        if self.tamaño == 0 and self.inicio is None and self.fin is None:
            print("\nError: no hay elementos en la Lista Ligada Simple\n")
        else:  # Si hay un elemento al inicio, se extrae
            tmp = self.inicio
            self.inicio = self.inicio.siguiente
            tmp.siguiente = None

            # Si se remueve el último elemento, la cola queda vacía
            if self.tamaño == 1:
                self.fin = None
            else:
                tmp2 = self.inicio
                cont = 0

                # Modificando valores de índices
                while tmp2 is not None:
                    tmp2.indice = cont
                    tmp2 = tmp2.siguiente
                    cont += 1

            self.tamaño -= 1

            return tmp

        return None

    # Remueve todos los elementos de la Lista
    def clear(self):
        length = self.tamaño
        for i in range(length):
            self.remove_start()
        print("Lista vaciada")

    # Muestra el elemento al inicio de la Lista sin removerlo
    def peek(self):
        # Si no hay elementos en la Lista, no se puede visualizar
        if self.tamaño == 0 and self.inicio is None and self.fin is None:
            print("\nError: no hay elementos en la Lista Ligada Simple\n")
        else:  # Si hay un elemento al inicio, se visualiza
            tmp = self.inicio

            return tmp

        return None

    # Muestra el elemento al inicio de la Lista sin removerlo
    def peekInicio(self):
        # Si no hay elementos en la Lista, no se puede visualizar
        if self.tamaño == 0 and self.inicio is None and self.fin is None:
            print("\nError: no hay elementos en la Lista Ligada Simple\n")
        else:  # Si hay un elemento al inicio, se visualiza
            tmp = self.inicio

            return tmp

        return None

    # Muestra el elemento al final de la Lista sin removerlo
    def peekFin(self):
        # Si no hay elementos en la Lista, no se puede visualizar
        if self.tamaño == 0 and self.inicio is None and self.fin is None:
            print("\nError: no hay elementos en la Lista Ligada Simple\n")
        else:  # Si hay un elemento al inicio, se visualiza
            tmp = self.fin

            return tmp

        return None

    # Busca el elemento que se encuentra en determinado índice
    def getNodo(self, indice):
        # Si no hay elementos en la Lista, no se puede extraer
        if self.tamaño == 0 and self.inicio is None and self.fin is None:
            print("\nError: no hay elementos en la Lista Ligada Simple\n")
        elif indice >= self.tamaño:  # Verificar el valor del índice máximo
            print("\nError: indice fuera de rango\n")
        else:
            tmp = self.inicio
            cont = 0

            # Busca el elemento en la Lista desde la izquierda
            while cont < indice:
                tmp = tmp.siguiente
                cont += 1
            print("Nodo: " + str(tmp.valor) + " [" + str(tmp.indice) + "]")

            return tmp

        return None

    # Busca el índice en donde se encuentra un nodo en específico
    def getIndex(self, nodo):
        # Si no hay elementos en la Lista, no se puede extraer
        if self.tamaño == 0 and self.inicio is None and self.fin is None:
            print("\nError: no hay elementos en la Lista Ligada Simple\n")
        else:
            tmp = self.inicio
            encontrado = False
            cont = 0

            # Busca al elemento
            while tmp is not None:
                if tmp == nodo:
                    encontrado = True
                    break
                else:
                    tmp = tmp.siguiente
                    cont += 1

            if encontrado:
                print("Nodo: " + str(tmp.valor) + " [" + str(tmp.indice) + "]")
                return cont
            else:
                print("Nodo not encontrado [-1]")

        return -1

    # Busca el índice en donde se encuentra un nodo con determinado valor
    def getIndex(self, valor):
        # If there are no elements in the list, it cannot be extracted
        if self.tamaño == 0 and self.inicio is None and self.fin is None:
            print("\nError: no hay elementos en la Lista Ligada Simple\n")
        else:
            tmp = self.inicio
            encontrado = False
            cont = 0

            # Busca al elemento
            while tmp is not None:
                if tmp.valor == valor:
                    encontrado = True
                    break
                else:
                    tmp = tmp.siguiente
                    cont += 1

            if encontrado:
                print("Nodo: " + str(tmp.valor) + " [" + str(tmp.indice) + "]")
                return cont
            else:
                print("Nodo no encontrado [-1]")

        return -1

    # Muestra el contenido de la Lista
    def imprimirLista(self):
        # Si no hay elementos en la Cola, no se imprime
        if self.tamaño == 0 and self.inicio is None and self.fin is None:
            print("\nLista Ligada Simple sin elementos")
        else:  # Si hay elementos en la Cola, se muestran en pantalla
            print("\nLista Ligada Simple")
            print("Inicio: " + str(self.inicio.valor))
            print("Fin: " + str(self.fin.valor))
            print("Tamaño: " + str(self.tamaño))
            print("Contenido: ", end="")

            tmp = self.inicio

            while tmp is not None:
                print(str(tmp.valor) + " [" + str(tmp.indice) + "], ", end="")
                tmp = tmp.siguiente
            print("\n")

    # Muestra el contenido de los nodos y sus relaciones en la Lista
    def imprimirNodos(self):
        if self.tamaño == 0 and self.inicio is None and self.fin is None:
            print("\nista Ligada Simple sin elementos")
        else:  # Si hay elementos en la Cola, se muestran en pantalla
            print("\nNodos de la Lista Ligada Simple")
            print("Inicio: " + str(self.inicio.valor))
            print("Fin: " + str(self.fin.valor))
            print("Tamaño: " + str(self.tamaño))
            print("Correspondencias: ", end="")

            tmp = self.inicio

            while tmp.siguiente is not None:
                print(str(tmp.valor) + " -> " + str(tmp.siguiente.valor) + ", ", end="")
                tmp = tmp.siguiente
            print("\n")

    def main(self):
        lista = ListaLigadaSimple()
        tmp = None
        index = None

        a = Nodo(3)
        b = Nodo(7)
        c = Nodo(1)
        d = Nodo(5)
        e = Nodo(7)
        f = Nodo(8)
        g = Nodo(4)  # No se agrega

        print("Agregando elementos")
        lista.push(a)
        tmp = lista.peek()
        print(tmp.valor)

        lista.addFin(b)
        tmp = lista.peek()
        print(tmp.valor)

        lista.addInicio(c)
        lista.imprimirLista()

        lista.add(d, 1)
        lista.imprimirLista()

        lista.addNodo(e)
        tmp = lista.peek()
        print(tmp.valor)

        lista.add(f, 3)
        lista.imprimirLista()

        lista.imprimirNodos()
        tmp = lista.getNodo(5)
        tmp = lista.getNodo(1)

        index = lista.getIndex(c)
        index = lista.getIndex(g)
        index = lista.getIndex(8)
        index = lista.getIndex(7)

        tmp = lista.peekInicio()
        print("Inicio Peek: " + str(tmp.valor))
        tmp = lista.peekFin()
        print("Fin Peek: " + str(tmp.valor))

        # lista.clear()

        print("Removiendo elementos")
        lista.remove(2)
        tmp = lista.pop()
        print(tmp.valor)

        lista.imprimirLista()

        lista.removeNodo(b)
        lista.removeFin()

        lista.imprimirLista()

        lista.removeInicio()
        lista.imprimirLista()

        tmp = lista.pop()
        print(tmp.valor)
        lista.imprimirLista()

        tmp = lista.pop()
        lista.remove(6)


# Ejecutando el objeto
programa = ListaLigadaSimple()
programa.main()