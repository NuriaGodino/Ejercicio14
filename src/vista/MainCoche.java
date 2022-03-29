package vista;
import java.util.Scanner;

import modelo.entidad.Coche;
import modelo.negocio.GestorCoche;

public class MainCoche {

	public static void main(String[] args) {	
		
		System.out.println("Bienvenidos a nuestra CRUD de coches");
		Scanner sc = new Scanner(System.in);
		boolean fin = false;
		GestorCoche gc = new GestorCoche();
		
		do {
			menu();
			int opcion = sc.nextInt();
			switch(opcion) {
			case 1: 
				System.out.println("Introduce los datos del coche (matricula/marca/modelo/kilometros)");
				String matricula = sc.next();
				String marca = sc.next();
				String modelo = sc.next();
				int km = sc.nextInt();
				Coche c = new Coche();
				c.setMatricula(matricula);
				c.setMarca(marca);
				c.setModelo(modelo);
				c.setKilometros(km);
				
				int alta = gc.alta(c);
				if(alta == 0) {
					System.out.println("Coche dado de alta");
				}else if(alta == 1) {
					System.out.println("Error de conexion con la BBDD");
				}else if(alta == 2) {
					System.out.println("La matricula tiene menos de 7 caracteres");
				}else if(alta == 3) {
					System.out.println("Los kilometros no pueden ser negativos");
				}else if(alta == 4) {
					System.out.println("La matricula introducida ya esta en la BBDD");
				}
				
				break;
			
			case 0:
				fin = true;
				break;
			}
		}while(!fin);
		
		System.out.println("Fin del programa");
		
		sc.close();
	}
	
	private static void menu() {
		System.out.println("Elija una opción: ");
		System.out.println("1- Alta de coche");
		System.out.println("0- Salir");
	}

}
