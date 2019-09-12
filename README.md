# CalcuComplejosCNYT
  CalcuComplejosCNYT fue desarrollado como laboratorio de la clase CNYT de la Escuela Colombiana de Ingenieria Julio Garavito.

- Se creo una calculadora de numeros complejos que pudiera completar las siguientes operaciones:
````
	1. Suma
  	2. Resta
  	3. Multiplicacion
  	4. Division
  	5. Modulo
  	6. Fase
  	7. Conjugado
  	8. Conversion de coordenadas cartesianas a polares
  	9. Adición de vectores complejos.
  	10. Inversa de vectores complejos.
	11. Multiplicación escalar de vectores complejos.
	12. Adición de matrices complejos.
	13. Inversa de matrices complejos.
	14. Multiplicación escalar de matrices complejas.
	15. Matriz transpuesta
	16. Matriz conjugada
	17. Matriz adjunta
	18. Función para calcular la "acción" de una matriz sobre un vector.
	19. Norma de matrices
	20. Distancia entrematrices
	22. Revisar si es unitaria
	24. Revisar si es Hermitian
	25. Producto tensor.
````

# Example
  ```
  public Complejo sumaQC(Complejo n1, Complejo n2) {
		double sPtReal = n1.parteReal + n2.parteReal;
		double sPtIma = n1.parteImag + n2.parteImag;		
		System.out.println("( " + sPtReal + " " + sPtIma +" )");
		Complejo resultado = new Complejo(sPtReal, sPtIma);
		return resultado;
	}
  ```
  
- Adicionalmente se creo una prueba para cada operacion en una clase tipo Junit.
  ```
  @Test
	void deberiaSumarComplejos() {
		Complejo c1 = m.sumaQC(new Complejo(2, 4), new Complejo(3, 5));
		Complejo c2 = new Complejo(5, 9);		
		assertTrue(c1.equals(c2));
	}
  ```
  
# Getting Started
## Install with

```
git clone https://github.com/dracken1/CalcuComplejosCNYT.git
```

## Compile and run with

Dentro de la carpeta CalcuComplejosCNYT, inice cmd e intrduzca los siguientes comandos:

```
mvn clean

mvn compile

mvn test
```

# Build with
El proyecto se desarrollo usando el lenguaje Java y la herramienta Eclipse.

# Author
Nicolás Cárdenas Chaparro

# License
````
Copyright (C) 2007 Free Software Foundation, Inc. <https://fsf.org/>
 Everyone is permitted to copy and distribute verbatim copies
 of this license document, but changing it is not allowed.
````

# Acknowlegdments
- Practicing java
- Inspiration
