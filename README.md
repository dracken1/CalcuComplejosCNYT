# CalcuComplejosCNYT
  CalcuComplejosCNYT fue desarrollado como laboratorio de la clase CNYT de la Escuela Colombiana de Ingenieria Julio Garavito.

- Se creo una calculadora de numeros complejos que pudiera completar las siguientes operaciones:
  1. Suma
  2. Resta
  3. Multiplicacion
  4. Division
  5. Modulo
  6. Fase
  7. Conjugado
  8. Conversion de coordenadas cartesianas a polares
  
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
Si usted desea probar este sencillo programa, lo unico que debe hacer es clonar el repositorio en una carpeta de su eleccion y abrir dicha carpeta en eclipse, posteriormente solo use la opcion de correr/ejecutar que da eclipse.
Adicionalmente esto se puede realizar usando la consola.

# Build with
El proyecto se desarrollo usando el lenguaje Java y la herramienta Eclipse.

# Author
Nicolás Cárdenas Chaparro

# License
Free license

# Acknowlegdments
- Practicing java
- Inspiration
