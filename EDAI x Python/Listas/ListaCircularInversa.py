from Nodo import Nodo

class ListaCircularInversa:

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
            nodo.anterior = self.fin
            self.fin = nodo

        self.inicio.anterior = self.fin
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
                temp = self.fin
                for i in range(self.tamaño - 1, -1, -1):
                    temp.indice += 1  # Modifica el valor de los índices
                    temp = temp.anterior

                temp.indice += 1
                nodo.anterior = temp.anterior
                temp.anterior = nodo
                nodo.indice = i
                self.inicio = nodo

            else:
                temp = self.fin
                count = self.tamaño - 1

                # Busca al elemento en el indice actual
                while count > indice:
                    temp.indice += 1  # Modifica el valor de los índices
                    temp = temp.anterior
                    count -= 1
                temp.indice += 1
                nodo.anterior = temp.anterior
                temp.anterior = nodo
                nodo.indice = count

            self.inicio.anterior = self.fin
            self.tamaño += 1

    # Agregar un elemento al inicio de la Lista
    def addInicio(self, nodo):
        # Se inserta el primer elemento
        if self.inicio is None and self.fin is None and self.tamaño == 0:
            self.inicio = nodo
            self.fin = nodo
        else:  # La Lista ya contiene elementos
            self.inicio.anterior = nodo
            self.inicio = nodo
            self.inicio.anterior = None

        temp = self.fin
        for i in range(self.tamaño, -1, -1):
            temp.indice = i  # Modifica el valor de los índices
            temp = temp.anterior

        self.inicio.anterior = self.fin
        self.tamaño += 1

    # Agregar un elemento al final de la Lista
    def addFin(self, nodo):
        # Se inserta el primer elemento
        if self.inicio is None and self.fin is None and self.tamaño == 0:
            self.inicio = nodo
            self.fin = nodo
        else:  # La Lista ya contiene elementos
            nodo.anterior = self.fin
            self.fin = nodo

        self.inicio.anterior = self.fin
        nodo.indice = self.tamaño
        self.tamaño += 1

    # Agregar un elemento al final de la Lista
    def push(self, nodo):
        # Se inserta el primer elemento
        if self.inicio is None and self.fin is None and self.tamaño == 0:
            self.inicio = nodo
            self.fin = nodo
        else:  # La Lista ya contiene elementos
            nodo.anterior = self.fin
            self.fin = nodo

        self.inicio.anterior = self.fin
        nodo.indice = self.tamaño
        self.tamaño += 1

    # Remueve el elemento que se encuentra al inicio de la Lista
    def remove(self):
        # Si no hay elementos en la Lista, no se puede extraer
        if self.tamaño == 0 and self.inicio is None and self.fin is None:
            print("\nError: no hay elementos en la Lista Circular Inversa\n")
        else:  # Si hay un elemento al inicio, se extrae

            # Si se remueve el último elemento, la lista queda vacía
            if self.tamaño == 1:
                self.inicio = None
                self.fin = None
            else:
                tmp = self.fin
                count = self.tamaño - 1

                # Busca al elemento anterior al indice actual
                while count > 1:
                    tmp.indice -= 1
                    tmp = tmp.anterior
                    count -= 1
                tmp.anterior = self.inicio.anterior
                tmp.indice = count - 1
                self.inicio = tmp

                self.inicio.anterior = self.fin

            self.tamaño -= 1

    # Remueve un elemento específico de la Lista, si es que se encuentra en esta
    def removeNodo(self, nodo):
        # Si no hay elementos en la Lista, no se puede extraer
        if self.tamaño == 0 and self.inicio is None and self.fin is None:
            print("\nError: no hay elementos en la Lista Circular Inversa\n")
        else:
            # Verificar si existe el nodo en la Lista
            tmp = self.fin
            encontrado = False

            for indice in range(self.tamaño - 1, -1, -1):
                if tmp == nodo:
                    encontrado = True
                    break
                tmp = tmp.anterior

            if not encontrado:
                print("Nodo no encontrado en la Lista Circular Inversa")
            else:  # Si el nodo está en la Lista, se extrae (analizar los casos)
                indice = tmp.indice
                self.remove(indice)

    # Remueve un elemento en una posición específica de la Lista
    def remove(self, indice):
        # Verificar el valor del índice máximo
        if indice >= self.tamaño:
            print("\nError: indice fuera de rango\n")
        else:
            # Si se remueve el último elemento, la lista queda vacía
            if self.tamaño == 1:
                self.inicio = None
                self.fin = None
            else:
                # Si se remueve al inicio de la Lista
                if indice == 0:
                    tmp = self.fin
                    count = self.tamaño - 1

                    # Busca al elemento anterior al indice actual
                    while count > 1:
                        tmp.indice -= 1
                        tmp = tmp.anterior
                        count -= 1
                    tmp.anterior = self.inicio.anterior
                    tmp.indice = count - 1
                    self.inicio = tmp

                elif indice == self.tamaño - 1:  # Si se remueve al final de la Lista
                    tmp = self.fin

                    self.fin = tmp.anterior
                    tmp.anterior = None

                else:  # Si se remueve dentro de la Lista
                    tmp = self.fin
                    count = self.tamaño - 1

                    # Busca al elemento siguiente al indice actual
                    while count > indice + 1:
                        tmp.indice -= 1
                        tmp = tmp.anterior
                        count -= 1
                    tmp.indice -= 1
                    tmp2 = tmp.anterior
                    tmp.anterior = tmp2.anterior
                    tmp2.anterior = None
                    tmp2 = None

                self.inicio.anterior = self.fin

            self.tamaño -= 1

    # Remueve el elemento que se encuentra al inicio de la Lista
    def removeInicio(self):
        # Si no hay elementos en la Lista, no se puede extraer
        if self.tamaño == 0 and self.inicio is None and self.fin is None:
            print("\nError: no hay elementos en la Lista Circular Inversa\n")
        else:  # Si hay un elemento al inicio, se extrae

            # Si se remueve el último elemento, la lista queda vacía
            if self.tamaño == 1:
                self.inicio = None
                self.fin = None
            else:
                tmp = self.fin
                count = self.tamaño - 1

                # Busca al elemento anterior al indice actual
                while count > 1:
                    tmp.indice -= 1
                    tmp = tmp.anterior
                    count -= 1
                tmp.anterior = self.inicio.anterior
                tmp.indice = count - 1
                self.inicio = tmp

                self.inicio.anterior = self.fin

            self.tamaño -= 1

    # Remueve el elemento que se encuentra al fin de la Lista
    def removeFin(self):
        # Si no hay elementos en la Lista, no se puede extraer
        if self.tamaño == 0 and self.inicio is None and self.fin is None:
            print("\nError: no hay elementos en la Lista Circular Inversa\n")
        else:  # Si hay un elemento al final, se extrae

            # Si se remueve el último elemento, la lista queda vacía
            if self.tamaño == 1:
                self.inicio = None
                self.fin = None
            else:
                tmp = self.fin

                self.fin = tmp.anterior
                tmp.anterior = None

                self.inicio.anterior = self.fin

            self.tamaño -= 1

    # Remueve el elemento que se encuentra al inicio de la Lista
    def pop(self):
        # Si no hay elementos en la Lista, no se puede extraer
        if self.tamaño == 0 and self.inicio is None and self.fin is None:
            print("\nError: no hay elementos en la Lista Circular Inversa\n")
        else:  # Si hay un elemento al inicio, se extrae
            tmp = self.inicio

            # Si se remueve el último elemento, la lista queda vacía
            if self.tamaño == 1:
                self.inicio = None
                self.fin = None
            else:
                tmp2 = self.fin
                count = self.tamaño - 1

                # Busca al elemento anterior al indice actual
                while count > 1:
                    tmp2.indice -= 1
                    tmp2 = tmp2.anterior
                    count -= 1
                tmp = tmp2.anterior
                tmp2.indice = count - 1
                tmp2.anterior = self.inicio.anterior
                self.inicio = tmp2

                self.inicio.anterior = self.fin

            self.tamaño -= 1

            return tmp

        return None

    # Remueve todos los elementos de la Lista
    def clear(self):
        tam = self.tamaño
        for i in range(tam):
            self.remove_inicio()
        print("Lista vaciada")

    # Muestra el elemento al inicio de la Lista sin removerlo
    def peek(self):
        # Si no hay elementos en la Lista, no se puede visualizar
        if self.tamaño == 0 and self.inicio is None and self.fin is None:
            print("\nError: no hay elementos en la Lista Circular Inversa\n")
        else:  # Si hay un elemento al inicio, se visualiza
            tmp = self.inicio

            return tmp

        return None

    # Muestra el elemento al inicio de la Lista sin removerlo
    def peekInicio(self):
        # Si no hay elementos en la Lista, no se puede visualizar
        if self.tamaño == 0 and self.inicio is None and self.fin is None:
            print("\nError: no hay elementos en la Lista Circular Inversa\n")
        else:  # Si hay un elemento al inicio, se visualiza
            tmp = self.inicio

            return tmp

        return None

    # Muestra el elemento al final de la Lista sin removerlo
    def peekFin(self):
        # Si no hay elementos en la Lista, no se puede visualizar
        if self.tamaño == 0 and self.inicio is None and self.fin is None:
            print("\nError: no hay elementos en la Lista Circular Inversa\n")
        else:  # Si hay un elemento al inicio, se visualiza
            tmp = self.fin

            return tmp

        return None

    # Busca el elemento que se encuentra en determinado índice
    def getNodo(self, indice):
        # Si no hay elementos en la Lista, no se puede extraer
        if self.tamaño == 0 and self.inicio is None and self.fin is None:
            print("\nError: no hay elementos en la Lista Circular Inversa\n")
        elif indice >= self.tamaño:  # Verificar el valor del índice máximo
            print("\nError: indice fuera de rango\n")
        else:
            tmp = self.fin
            count = self.tamaño - 1

            # Busca el elemento en la Lista desde la izquierda
            while count > indice:
                tmp = tmp.anterior
                count -= 1
            print("Nodo: " + str(tmp.valor) + " [" + str(tmp.indice) + "]")

            return tmp

        return None

    # Busca el índice en donde se encuentra un nodo en específico
    def getIndex(self, node):
        # Si no hay elementos en la Lista, no se puede extraer
        if self.tamaño == 0 and self.inicio is None and self.fin is None:
            print("\nError: no hay elementos en la Lista Circular Inversa\n")
        else:
            tmp = self.fin
            encontrado = False
            indice = 0

            # Busca al elemento
            for indice in range(self.tamaño - 1, -1, -1):
                if tmp == node:
                    encontrado = True
                    break
                else:
                    tmp = tmp.anterior

            if encontrado:
                print("Nodo: " + str(tmp.valor) + " [" + str(tmp.indice) + "]")
                return indice
            else:
                print("Nodo no encontrado [-1]")

        return -1

    # Busca el índice en donde se encuentra un nodo con determinado valor
    def getIndex(self, valor):
        # Si no hay elementos en la Lista, no se puede extraer
        if self.tamaño == 0 and self.inicio is None and self.fin is None:
            print("\nError: no hay elementos en la Lista Circular Inversa\n")
        else:
            tmp = self.fin
            encontrado = False
            indice = None

            # Busca al elemento
            for indice in range(self.tamaño - 1, -1, -1):
                if tmp.valor == valor:
                    encontrado = True
                    break
                else:
                    tmp = tmp.anterior

            if encontrado:
                print(f"Nodo: {tmp.valor} [{tmp.indice}]")
                return indice
            else:
                print("Nodo no encontrado [-1]")

        return -1

    # Muestra el contenido de la Lista
    def imprimirLista(self):
        # Si no hay elementos en la lista, no se imprime
        if self.tamaño == 0 and self.inicio is None and self.fin is None:
            print("\nLista Circular Inversa sin elementos")
        else:  # Si hay elementos en la lista, se muestran en pantalla
            print("\nLista Circular Inversa")
            print(f"Inicio: {self.inicio.valor}")
            print(f"Fin: {self.fin.valor}")
            print(f"Tamaño: {self.tamaño}")
            print("Contenido: ", end='')

            tmp = self.fin

            for i in range(self.tamaño - 1, -1, -1):
                print(f"{tmp.valor} [{tmp.indice}], ", end='')
                tmp = tmp.anterior
            print("\n")

    # Muestra el contenido de los nodos y sus relaciones en la Lista
    def imprimirNodos(self):
        if self.tamaño == 0 and self.inicio is None and self.fin is None:
            print("\nLista Circular Inversa sin elementos")
        else:  # Si hay elementos en la lista, se muestran en pantalla
            print("\nNodos de la Lista Circular Inversa")
            print(f"Inicio: {self.inicio.valor}")
            print(f"Fin: {self.fin.valor}")
            print(f"Tamaño: {self.tamaño}")
            print("Correspondencias: ", end='')

            tmp = self.fin

            for i in range(self.tamaño - 1, -1, -1):
                print(f"{tmp.anterior.valor} <- {tmp.valor}, ", end='')
                tmp = tmp.anterior
            print("\n")

    def main(self):
        lista = ListaCircularInversa()
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
programa = ListaCircularInversa()
programa.main()