import java.util.Random;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);


		//variable para saber si quiere seguir jugando
		int opcion = 0; 

		do {

			int juego = 0;
			System.out.println("¿A que juego quiere jugar? 1-BUSCAMINAS || 2-TRES EN RAYA");
			juego = teclado.nextInt();


			while(juego < 1 || juego > 2) {
				System.out.println("Numero incorrecto. ¿A que juego quiere jugar? 1-BUSCAMINAS || 2-TRES EN RAYA");
				juego = teclado.nextInt();

			}


			if (juego == 1) {
				System.out.println("Bienvenido/a al juego del buscaminas");

				//Declaramos variables
				int fila= 10;
				int columna = 10;
				int filausuario = 0;
				int columnausuario =0;

				//Declaramos matrices
				int [][] matriz = new int [fila][columna];
				int [][] matriznovisible = new int [fila][columna];

				//Declaramos un bucle Random
				Random random = new Random();
				//Recorremos el array con un bucle for y que se rellene con numeros aleatorios entre 1 y 0
				for(int i=0;i<matriznovisible.length;i++) {
					for(int j=0; j<matriznovisible[i].length;j++) {
						matriznovisible[i][j] = (int)Math.floor(Math.random()*(1-0+1)+0);
					}
				}
				for(int i=0;i<matriznovisible.length;i++) {
					for(int j=0; j<matriznovisible[i].length;j++) {
						//System.out.print(matriznovisible[i][j] + "\t");

					}
					//System.out.println();
				}
				//Con este bucle do while hacemos que nos repita las filas y columnas hasta que perdamos
				do {
					//Con este bucle do while hacemos que nos siga pidiendo filas y columnas que esten dentro del rango 10*10
					do {
						System.out.println("Introduce la fila del 0 al 9");
						filausuario=teclado.nextInt();

					}while(filausuario > 9   || filausuario < 0  );

					do {
						System.out.println("Introduce la columna del 0 al 9");
						columnausuario=teclado.nextInt();

					}while(columnausuario > 9   || columnausuario < 0  );

					//Con este bucle do while miramos que haya bomba o no
					if(matriznovisible[filausuario][columnausuario]==0 ) {
						System.out.println("No hay bomba!!");
					}else {
						System.out.println("Has perdido");
					}

					System.out.println();		
					//Con un bucle if hacemos que nos cambie un cero de la matriz por un 2 y con el else if hacemos que nos cambie un cero de la matriz por un 3 
					if(matriznovisible[filausuario][columnausuario]==0) {
						matriz[filausuario][columnausuario] = 2;
						//Con este bucle for recorremos la matriz otra vez
						for(int i=0;i<matriz.length;i++) {
							for(int j=0; j<matriz[i].length;j++) {

							}
						}
						//Con este bucle for hacemos que aparezca modificada con el 2
						for(int i=0;i<matriz.length;i++) {
							for(int j=0; j<matriz[i].length;j++) {
								System.out.print(matriz[i][j] + "\t");

							}
							System.out.println();
						}
					}else if(matriznovisible[filausuario][columnausuario]==1) {
						matriz[filausuario][columnausuario] = 3;
						//Recorremos la matriz
						for(int i=0;i<matriz.length;i++) {
							for(int j=0; j<matriz[i].length;j++) {

							}
						}
						//Con este bucle for hacemos que aparezca modificada con el 3
						for(int i=0;i<matriz.length;i++) {
							for(int j=0; j<matriz[i].length;j++) {
								System.out.print(matriz[i][j] + "\t");

							}
							System.out.println();
						}
					}

				}while(matriznovisible[filausuario][columnausuario]==0);
				//Imprimimos por consola
				System.out.println("FIN DEL JUEGO");
			}


			if(juego == 2) {

				//Generamos una matriz de 3x3 llena de 0
				int[][] matrizcero = new int[3][3];
				int cero =  0;
				int filaj1 = 0;
				int filaj2 = 0;
				int columnaj1 = 0;
				int columnaj2 = 0;
				int contador = 0;
				boolean empate = false;



				//declaramos booleanos para evaluar si ganan y si no ganan que se repita el codigo
				boolean jugador1gana = false; 
				boolean jugador2gana = false; 
				boolean cpugana = false;

				//jugando contra la CPU
				int filacpu = 0;
				int columnacpu = 0;
				boolean empatecpu = false;
				int contadorcpu = 0;


				//selecciones
				int opciones = 0;



				System.out.println("¡Bienvenido al juego de 3 en raya!");

				System.out.println("¿Qué modo quieres jugar?");
				System.out.println("1-Dos jugadores || 2-Contra la CPU");
				opciones = teclado.nextInt();
				//hacemos este control para que si introduce una de las opciones que no es 
				while(opciones <= 0 || opciones >=3){
					System.out.println("Numero incorrecto, 1-Dos jugadores || 2-Contra la CPU");
					opciones = teclado.nextInt(); 

				}


				//utilizamos estos for anidados para rellenar los valores de la matriz

				for (int i = 0; i < matrizcero.length; i++) {

					for (int j = 0; j < matrizcero [i].length; j++) {

						//rellenamos la matriz con 0
						//introducimos los datos en la matriz
						matrizcero[i][j] = cero;
					}
				}


				//hacemos un if para que si introduce un 1 entre en la opcion
				if(opciones == 1) {

					do {

						do {
							//le pedimos al usuario que introduzca una fila y columna 
							System.out.println("Jugador 1, introduzca una fila");
							filaj1 = teclado.nextInt();

							//estructura de control para que el usuario introdduzca un numero valido
							while(filaj1 > 2 || filaj1 < 0) {
								System.out.println("¡Numero erroneo! Jugador 1, introduzca una fila");
								filaj1 = teclado.nextInt();
							}

							//pedimos al usuario que introduzca valores
							System.out.println("Jugador 1, introduzca una columna");
							columnaj1 = teclado.nextInt();

							//estructura de control para que el usuario introduzca un numero valido
							while(columnaj1 > 2  || columnaj1 < 0) {
								System.out.println("¡Numero erroneo! Jugador 1, introduzca una columna");
								columnaj1 = teclado.nextInt();
							}	
							//hacemos un condicion para que si la posicion esta ocupada repita el codigo
							if(matrizcero[filaj1][columnaj1] == 1 || matrizcero[filaj1][columnaj1] == 2) {

								System.out.println("¡La posicion está opcupada!");
							}

							//si se cumple la condicion, se buclea el codigo
						}while(matrizcero[filaj1][columnaj1] == 1 || matrizcero[filaj1][columnaj1] == 2);

						//si los valores son correctos, rellenamos la posicion de la matriz con un 1
						matrizcero[filaj1][columnaj1] = 1;
						contador++;


						//hacemos un for para mostrar la matriz
						for (int i = 0; i < matrizcero.length; i++) {

							for (int j = 0; j < matrizcero [i].length; j++) {

								//rellenamos la matriz con 0
								//introducimos los datos en la matriz
								System.out.print(matrizcero[i][j] + "\t");

							}
							//este syso es para que nos ponga en filas y columnas
							System.out.println();
						}

						//condicional para ver si hay empate
						if(contador == 9 && jugador1gana == false && jugador2gana == false) {
							System.out.println("¡Habeis empatado!");	
							empate = true;
						}

						//en este if se evaluan todas las condiciones para saber si el jugador 1 ha conseguido ganar
						if(matrizcero[0][0] == 1 && matrizcero[0][1] == 1 && matrizcero[0][2] == 1 ||
								matrizcero[1][0] == 1 && matrizcero[1][1] == 1 && matrizcero[1][2] == 1 || 
								matrizcero[2][0] == 1 && matrizcero[2][1] == 1 && matrizcero[2][2] == 1 || 
								matrizcero[0][0] == 1 && matrizcero[1][0] == 1 && matrizcero[2][0] == 1 ||
								matrizcero[0][1] == 1 && matrizcero[1][1] == 1 && matrizcero[2][1] == 1 ||
								matrizcero[0][2] == 1 && matrizcero[1][2] == 1 && matrizcero[2][2] == 1 ||
								matrizcero[0][0] == 1 && matrizcero[1][1] == 1 && matrizcero[2][2] == 1 ||
								matrizcero[0][2] == 1 && matrizcero[1][1] == 1 && matrizcero[2][0] == 1){

							//Hacemos saber al jugador que ha ganado
							System.out.println("¡Jugador 1 ha conseguido hacer tres en raya! Ganador");
							jugador1gana = true;

						}
						//controlamos que mientras no gane y no haya empate se ejecute el codigo
						if(jugador1gana == false && empate == false) {

							do {	
								//pedimos al usuario que introduzca valores
								System.out.println("Jugador 2, introduzca una fila");
								filaj2 = teclado.nextInt();

								//estructura de control para que el usuario introduzca un numero valido
								while(filaj2 > 2 || filaj2 < 0) {
									System.out.println("¡Numero erroneo! Jugador 2, introduzca una fila");
									filaj2 = teclado.nextInt();

								}

								//pedimos al usuario que introduzca valores
								System.out.println("Jugador 2, introduzca una columna");
								columnaj2 = teclado.nextInt();

								//estructura de control para que el usuario introdduzca un numero valido
								while(columnaj2 > 2 || columnaj2 < 0) {
									System.out.println("¡Numero erroneo! Jugador 2, introduzca una columna");
									columnaj2 = teclado.nextInt();
								}

								//hacemos un condicion para que si la posicion esta ocupada repita el codigo
								if(matrizcero[filaj2][columnaj2] == 1 || matrizcero[filaj2][columnaj2] == 2) {

									System.out.println("¡La posicion está opcupada!");
								}

								//si se cumple la condicion, se buclea el codigo
							}while(matrizcero[filaj2][columnaj2] == 1 || matrizcero[filaj2][columnaj2] == 2);

							//si los valores son correctos, rellenamos la posicion de la matriz con un 2
							matrizcero[filaj2][columnaj2] = 2;
							contador++;

							//hacemos un for para mostrar la matriz
							for (int i = 0; i < matrizcero.length; i++) {

								for (int j = 0; j < matrizcero [i].length; j++) {

									//rellenamos la matriz con 0
									//introducimos los datos en la matriz
									System.out.print(matrizcero[i][j] + "\t");

								}
								//este syso es para que nos ponga en filas y columnas
								System.out.println();
							}


							//en este if se evaluan todas las condiciones para saber si el jugador 2 ha conseguido ganar
							if(matrizcero[0][0] == 2 && matrizcero[0][1] == 2 && matrizcero[0][2] == 2 ||
									matrizcero[1][0] == 2 && matrizcero[1][1] == 2 && matrizcero[1][2] == 2 || 
									matrizcero[2][0] == 2 && matrizcero[2][1] == 2 && matrizcero[2][2] == 2 || 
									matrizcero[0][0] == 2 && matrizcero[1][0] == 2 && matrizcero[2][0] == 2 ||
									matrizcero[0][1] == 2 && matrizcero[1][1] == 2 && matrizcero[2][1] == 2 ||
									matrizcero[0][2] == 2 && matrizcero[1][2] == 2 && matrizcero[2][2] == 2 ||
									matrizcero[0][0] == 2 && matrizcero[1][1] == 2 && matrizcero[2][2] == 2 ||
									matrizcero[0][2] == 2 && matrizcero[1][1] == 2 && matrizcero[2][0] == 2){

								//Hacemos saber al jugador que ha ganado
								System.out.println("¡Jugador 2 ha conseguido hacer tres en raya! Ganador");
								jugador2gana = true;
							}


						}


					}while(jugador1gana == false && jugador2gana == false && empate == false);


					/*------------------------------------------------------------------------------------------------------*/

				}else if(opciones == 2) {
					do {
						do {
							//le pedimos al usuario que introduzca una fila y columna 
							System.out.println("Jugador 1, introduzca una fila");
							filaj1 = teclado.nextInt();

							//estructura de control para que el usuario introdduzca un numero valido
							while(filaj1 > 2 || filaj1 < 0) {
								System.out.println("¡Numero erroneo! Jugador 1, introduzca una fila");
								filaj1 = teclado.nextInt();
							}

							//pedimos al usuario que introduzca valores
							System.out.println("Jugador 1, introduzca una columna");
							columnaj1 = teclado.nextInt();

							//estructura de control para que el usuario introduzca un numero valido
							while(columnaj1 > 2  || columnaj1 < 0) {
								System.out.println("¡Numero erroneo! Jugador 1, introduzca una columna");
								columnaj1 = teclado.nextInt();
							}	
							//hacemos un condicion para que si la posicion esta ocupada repita el codigo
							if(matrizcero[filaj1][columnaj1] == 1 || matrizcero[filaj1][columnaj1] == 2) {

								System.out.println("¡La posicion está opcupada!");
							}

							//si se cumple la condicion, se buclea el codigo
						}while(matrizcero[filaj1][columnaj1] == 1 || matrizcero[filaj1][columnaj1] == 2);

						//si los valores son correctos, rellenamos la posicion de la matriz con un 1
						matrizcero[filaj1][columnaj1] = 1;
						contadorcpu++;


						//hacemos un for para mostrar la matriz
						for (int i = 0; i < matrizcero.length; i++) {

							for (int j = 0; j < matrizcero [i].length; j++) {

								//rellenamos la matriz con 0
								//introducimos los datos en la matriz
								System.out.print(matrizcero[i][j] + "\t");

							}
							//este syso es para que nos ponga en filas y columnas
							System.out.println();
						}

						//condicional para ver si hay empate
						if(contadorcpu == 9 && jugador1gana == false && cpugana == false) {
							System.out.println("¡Habeis empatado!");	
							empatecpu = true;
						}
						//en este if se evaluan todas las condiciones para saber si el jugador 1 ha conseguido ganar
						if(matrizcero[0][0] == 1 && matrizcero[0][1] == 1 && matrizcero[0][2] == 1 ||
								matrizcero[1][0] == 1 && matrizcero[1][1] == 1 && matrizcero[1][2] == 1 || 
								matrizcero[2][0] == 1 && matrizcero[2][1] == 1 && matrizcero[2][2] == 1 || 
								matrizcero[0][0] == 1 && matrizcero[1][0] == 1 && matrizcero[2][0] == 1 ||
								matrizcero[0][1] == 1 && matrizcero[1][1] == 1 && matrizcero[2][1] == 1 ||
								matrizcero[0][2] == 1 && matrizcero[1][2] == 1 && matrizcero[2][2] == 1 ||
								matrizcero[0][0] == 1 && matrizcero[1][1] == 1 && matrizcero[2][2] == 1 ||
								matrizcero[0][2] == 1 && matrizcero[1][1] == 1 && matrizcero[2][0] == 1){

							//Hacemos saber al jugador que ha ganado
							System.out.println("¡Jugador 1 ha conseguido hacer tres en raya! Ganador");
							jugador1gana = true;

						}

						//controlamos que mientras no gane y no haya empate se ejecute el codigo
						if(jugador1gana == false && empatecpu == false) {

							//Haremos el codigo para la CPU
							do {	
								//La cpu escoge una fila
								filacpu = (int) Math.floor(Math.random()*(2-0+1)+0);

								//La cpu escoge una columna
								columnacpu = (int) Math.floor(Math.random()*(2-0+1)+0);


								//hacemos un condicion para que si la posicion esta ocupada repita el codigo
								if(matrizcero[filacpu][columnacpu] == 1 || matrizcero[filacpu][columnacpu] == 2) {

									System.out.println("¡La posicion está opcupada!");
								}

								//si se cumple la condicion, se buclea el codigo
							}while(matrizcero[filacpu][columnacpu] == 1 || matrizcero[filacpu][columnacpu] == 2);

							//si los valores son correctos, rellenamos la posicion de la matriz con un 2
							matrizcero[filacpu][columnacpu] = 2;
							contadorcpu++;

							System.out.println("Ha jugado la CPU");

							//hacemos un for para mostrar la matriz
							for (int i = 0; i < matrizcero.length; i++) {

								for (int j = 0; j < matrizcero [i].length; j++) {

									//rellenamos la matriz con 0
									//introducimos los datos en la matriz
									System.out.print(matrizcero[i][j] + "\t");

								}
								//este syso es para que nos ponga en filas y columnas
								System.out.println();
							}

							//en este if se evaluan todas las condiciones para saber si la CPU ha conseguido ganar
							if(matrizcero[0][0] == 2 && matrizcero[0][1] == 2 && matrizcero[0][2] == 2 ||
									matrizcero[1][0] == 2 && matrizcero[1][1] == 2 && matrizcero[1][2] == 2 || 
									matrizcero[2][0] == 2 && matrizcero[2][1] == 2 && matrizcero[2][2] == 2 || 
									matrizcero[0][0] == 2 && matrizcero[1][0] == 2 && matrizcero[2][0] == 2 ||
									matrizcero[0][1] == 2 && matrizcero[1][1] == 2 && matrizcero[2][1] == 2 ||
									matrizcero[0][2] == 2 && matrizcero[1][2] == 2 && matrizcero[2][2] == 2 ||
									matrizcero[0][0] == 2 && matrizcero[1][1] == 2 && matrizcero[2][2] == 2 ||
									matrizcero[0][2] == 2 && matrizcero[1][1] == 2 && matrizcero[2][0] == 2){

								//Hacemos saber al jugador que ha ganado
								System.out.println("¡La CPU ha conseguido hacer tres en raya! Ganador");
								cpugana = true;
							}
						}


					}while(jugador1gana == false && cpugana == false && empatecpu == false);

				}



			}


			//le pedimos al usuario para ver si quiere volver a jugar
			System.out.println("¿Desea volver a jugar? 1-NO || 2-SI");
			opcion = teclado.nextInt();

			//en caso de que se equivoque de numero se le pedira otra vez

			while(opcion < 1 || opcion > 2) {
				System.out.println("Numero erroneo. ¿Desea volver a jugar? 1-NO || 2-SI");
				opcion = teclado.nextInt();
			}	

			//condicion para salir
			if(opcion == 1) {
				System.out.println("Has salido");
			}


			//se repetira el codigo si escoge 2
		}while(opcion == 2);


	}


}
