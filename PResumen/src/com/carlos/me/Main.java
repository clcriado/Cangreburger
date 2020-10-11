package com.carlos.me;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	
	static final ProcessBuilder pb = new ProcessBuilder();
	static Boolean funcionando = true;
	static Scanner scanner = new Scanner(System.in);
	static String so = System.getProperty("os.name");
	static final String barra = "\\";
	
	public static void main(String args[]) {
		menuSeleccion();

	}
	
	/**
	 * Este mï¿½todo crea en consola la interfaz y la eleccion del mï¿½todo a usar.
	 */
	
	public static void menuSeleccion() {
		//Hacemos un do-while para que la interfaz está en bucle hasta que elijan la opciï¿½n salir.
		do {
		System.out.println("Sistema operativo actual: " + so);
		System.out.println("Elige cual opcion deseas utilizar: \n");
		System.out.println("1. Crear una carpeta dada una ruta y el nombre.");
		System.out.println("2. Crear un fichero dada la ruta y el nombre.");
		System.out.println("3. Listar todas las interfaces de red de nuestro ordenador.");
		System.out.println("4. Mostrar la IP del ordenador dado el nombre de la interfaz de red.");
		System.out.println("5. Mostrar la dirección MAC dado el nombre de la interfaz de red.");
		System.out.println("6. Comprobar conectividad con internet.");
		System.out.println("7. Salir. \n");
		
		int eleccion = Integer.parseInt(scanner.nextLine());
		
		
		//Hacemos un switch para la elecciï¿½n del menï¿½ a travï¿½s de un Scanner con System.in.
		switch(eleccion) {
		case 1:
			crearDirectorio();
			break;
		case 2:
			crearFichero();
			break;
		case 3:
			mostrarInterfaces();
			break;
		case 4:
			mostrarIP();
			break;
		case 5:
			mostrarMAC();
			break;
		case 6:
			comprobarConexion();
			break;
		case 7:
			System.out.println("DESCONECTADO.");
			funcionando = false;
			break;
		}
		} while(funcionando);
		scanner.close();

	}
	
	/**
	 * Este mï¿½todo crea un directorio especificandole una ruta y un nombre.
	 */

	private static void crearDirectorio() {
		//Detectamos si el SO es Windows.
		if(so.contains("Windows")) {
			String ruta;
			String carpeta;
			System.out.println("\n Introduce la ruta donde deseas crear la carpeta.");
			//Cogemos la ruta que se introduce a través del Scanner
			ruta = scanner.nextLine();
			//Añadimos una barra si no tiene una al final.
			if(!ruta.endsWith("\\")) {
				ruta.concat(barra);
			}
			
			System.out.println("\n Introduce donde deseas crear la carpeta.");
			try {
				//Cogemos el directorio que se introduce a través del Scanner
				carpeta = scanner.nextLine();
				File directorio = new File(ruta + "\\" + carpeta);
			if(!directorio.exists()) {
				//Añadimos el comando que añadirá la carpeta.
				pb.command("cmd.exe","/c","mkdir " + ruta + "\\" + carpeta);
				try {
					//Ejecutamos el comando que añadirá la carpeta.
					pb.start();
					System.out.println("El directorio se ha creado con exito.");
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("ERROR: No se ha podido crear, este diretorio ya existe.");
				}
			} catch(NoSuchElementException e) {
				System.out.println("La ruta que se ha introducido no existe.");
				}
			
			//El SO no es Windows (osea es Ubuntu o otro).
		} else {
			String ruta;
			String carpeta;
			System.out.println("\n Introduce la ruta donde deseas crear la carpeta.");
			//Cogemos la ruta que se introduce a través del Scanner
			ruta = scanner.nextLine();
			//Añadimos una barra si no tiene una al final.
			if(!ruta.endsWith("\\")) {
				ruta.concat(barra);
			}
			
			System.out.println("\n Introduce donde deseas crear la carpeta.");
			try {
				//Cogemos el directorio que se introduce a través del Scanner
				carpeta = scanner.nextLine();
				File directorio = new File(ruta + "\\" + carpeta);
			if(!directorio.exists()) {
				//Ejecutamos el comando que añadiria la carpeta.
				pb.command("bash","-c","mkdir " + ruta + "//" + carpeta);
				try {
					//Ejecutamos el comando que añadirá la carpeta.
					pb.start();
					System.out.println("El directorio se ha creado con exito.");
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("ERROR: No se ha podido crear, este diretorio ya existe.");
				}
			} catch(NoSuchElementException e) {
				System.out.println("La ruta que se ha introducido no existe.");
				}
		}
	}
	
	/**
	 * Este mï¿½todo crea un fichero especificandole una ruta, un nombre y una extensiï¿½n.
	 */
	
	private static void crearFichero() {
		//Detectamos si el SO es Windows.
		if(so.contains("Windows")) {
			String ruta;
			String fichero;
			System.out.println("\n Introduce la ruta donde deseas crear el fichero.");
			//Cogemos la ruta que se introduce a través del Scanner
			ruta = scanner.nextLine();
			//Añadimos una barra si no tiene una al final.
			if(!ruta.endsWith("\\")) {
				ruta.concat(barra);
			}
			
			System.out.println("\n Introduce el nombre del fichero y formato.");
			//Cogemos el directorio que se introduce a través del Scanner
			fichero = scanner.nextLine();
			File directorio = new File(ruta + "\\" + fichero);
			if(!directorio.exists()) {
				//Ejecutamos el comando que añadiria la carpeta.
				pb.command("cmd.exe","/c","type nul > " + ruta + "\\" + fichero);
				try {
					//Ejecutamos el comando que añadirá la carpeta.
					pb.start();
					System.out.println("El fichero se ha creado con exito.");
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("ERROR: No se ha podido crear, este fichero ya existe.");
			}
			
		//El SO no es Windows (osea es Ubuntu o otro).	
		} else {
			String ruta;
			String fichero;
			System.out.println("\n Introduce la ruta donde deseas crear el fichero.");
			//Cogemos la ruta que se introduce a través del Scanner
			ruta = scanner.nextLine();
			//Añadimos una barra si no tiene una al final.
			if(!ruta.endsWith("\\")) {
				ruta.concat(barra);
			}
			
			System.out.println("\n Introduce el nombre del fichero y formato.");
			//Cogemos el directorio que se introduce a través del Scanner
			fichero = scanner.nextLine();
			File directorio = new File(ruta + "\\" + fichero);
			if(!directorio.exists()) {
				//Ejecutamos el comando que añadiria la carpeta.
				pb.command("bash","-c","touch " + ruta + "//" + fichero);
				try {
					//Ejecutamos el comando que añadirá la carpeta.
					pb.start();
					System.out.println("El fichero se ha creado con exito.");
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("ERROR: No se ha podido crear, este fichero ya existe.");
			}
		}
		}
		
	
	/**
	 * Este mï¿½todo lista todas las Interfaces de red del equipo.
	 */
	
	private static void mostrarInterfaces() {
		//Detectamos si el SO es Windows.
		if(so.contains("Windows")) {
			try {
				// ProcessBuilder que ejecuta un proceso listando la configuraciï¿½n de red.
				
				pb.command("cmd.exe", "/c", "ipconfig /all");

				Process process = pb.start();
				
				BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
				String linea;
				
				while((linea = br.readLine()) != null) {
					// Filtramos por la palabra "Adaptador de red para saber si es una interfaz
					if(linea.contains("Adaptador de")) {
						// Si tiene dichas palabras, escribirï¿½a por pantalla dicho Adaptador recortando lo no necesario.
						String nuevaLinea= linea.substring(13).replace(":", "");
						System.out.println(nuevaLinea);
						
					}
				}
				System.out.println("\n");
				br.close();
				
			} catch (IOException e) {
				e.printStackTrace();
				}
			
		//El SO no es Windows (osea es Ubuntu o otro).		
		} else {
			try {
				// ProcessBuilder que ejecuta un proceso listando la configuraciï¿½n de red.
				
				pb.command("bash","-c", "arp -a");

				Process process = pb.start();
				
				BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
				String linea;
				
				while((linea = br.readLine()) != null) {
					// Filtramos por la palabra "Adaptador de red para saber si es una interfaz
					if(linea.contains("Adaptador de")) {
						// Si tiene dichas palabras, escribirï¿½a por pantalla dicho Adaptador recortando lo no necesario.
						String nuevaLinea= linea.substring(13).replace(":", "");
						System.out.println(nuevaLinea);
						
					}
				}
				System.out.println("\n");
				br.close();
				
			} catch (IOException e) {
				e.printStackTrace();
				}
		}
		}
		
	
	/**
	 * Este mï¿½todo permite introducir el nombre de una interfaz de red y si existe devolverï¿½ 
	 * su IPv4 si es que tiene una.
	 */
	
	private static void mostrarIP() {
		//Detectamos si el SO es Windows.
		if(so.contains("Windows")) {
			pb.command("cmd.exe", "/c", "ipconfig /all");
			
			System.out.println("¿Cuál es el nombre de la interfaz que desea mostrar su IP?");
			// Permitimos al usuario escribir el nombre de la interfaz con Scanner.
			String interfaz = scanner.nextLine();
			
			// Permiten controlar si existe la interfaz, o si no contiene una IPv4.
			Boolean interfazExiste = false;
			Boolean tieneIPv4 = false;
			
			
			try {
				// Proceso que ejecuta un proceso listando la configuraciï¿½n de red.
				Process process = pb.start();
				BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
				
				String linea;
				while((linea = br.readLine()) != null) {
					// Si la linea contiene el nombre de la interfaz que le hemos dado, entramos y interfazExiste serï¿½ true.
					if(linea.contains(interfaz)) {
						interfazExiste = true;
						for(int i=0; i<=12;i++) {
							// Si la linea contiene IPv4, tieneIPv4 serï¿½ true y modificaremos el String para que solo muestre la IP.
							if(linea.contains("IPv4")) {
								tieneIPv4 = true;
								String[] ip = linea.substring(47).split("\\(");
								System.out.println(ip[0]);
								break;
							} else {
								linea = br.readLine();
							}
						}
					}
				}
				if(interfazExiste == false && !tieneIPv4) {
					System.out.println("Esta interfaz no existe.");
				}
				
				if(interfazExiste == true && !tieneIPv4) {
					System.out.println("Esta interfaz no tiene una IPv4.");
				}
				br.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NullPointerException e) {
				
			} catch (NoSuchElementException e) {
				System.out.println("hola");
			}
			
		//El SO no es Windows (osea es Ubuntu o otro).		
		} else {
			pb.command("bash","-c", "arp -a ip");
			
			System.out.println("¿Cuál es el nombre de la interfaz que desea mostrar su IP?");
			// Permitimos al usuario escribir el nombre de la interfaz con Scanner.
			String interfaz = scanner.nextLine();
			
			// Permiten controlar si existe la interfaz, o si no contiene una IPv4.
			Boolean interfazExiste = false;
			Boolean tieneIPv4 = false;
			
			
			try {
				// Proceso que ejecuta un proceso listando la configuraciï¿½n de red.
				Process process = pb.start();
				BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
				
				String linea;
				while((linea = br.readLine()) != null) {
					// Si la linea contiene el nombre de la interfaz que le hemos dado, entramos y interfazExiste serï¿½ true.
					if(linea.contains(interfaz)) {
						interfazExiste = true;
						for(int i=0; i<=12;i++) {
							// Si la linea contiene IPv4, tieneIPv4 serï¿½ true y modificaremos el String para que solo muestre la IP.
							if(linea.contains("IPv4")) {
								tieneIPv4 = true;
								String[] ip = linea.substring(47).split("\\(");
								System.out.println(ip[0]);
								break;
							} else {
								linea = br.readLine();
							}
						}
					}
				}
				if(interfazExiste == false && !tieneIPv4) {
					System.out.println("Esta interfaz no existe.");
				}
				
				if(interfazExiste == true && !tieneIPv4) {
					System.out.println("Esta interfaz no tiene una IPv4.");
				}
				br.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NullPointerException e) {
				
			} catch (NoSuchElementException e) {
				System.out.println("hola");
			}
		}
		
	}
	/**
	 * Este mï¿½todo permite introducir el nombre de una interfaz de red y si existe devolverï¿½ 
	 * su MAC si tiene una.
	 */
	
	private static void mostrarMAC() {
		if(so.contains("Windows")) {
			pb.command("cmd.exe", "/c", "ipconfig /all");
			
			System.out.println("¿Cuál es el nombre de la interfaz que desea mostrar su MAC?");
			// Permitimos al usuario escribir el nombre de la interfaz con Scanner.
			String interfaz = scanner.nextLine();
			
			// Permiten controlar si existe la interfaz, o si no contiene una IPv4.
			Boolean interfazExiste = false;
			Boolean tieneMAC = false;
			
			try {
				// Proceso que ejecuta un proceso listando la configuraciï¿½n de red.
				Process process = pb.start();
				BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
				
				String linea;
				while((linea = br.readLine()) != null) {
					// Si la linea contiene el nombre de la interfaz que le hemos dado, entramos y interfazExiste serï¿½ true.
					if(linea.contains(interfaz)) {
						interfazExiste = true;
						for(int i=0; i<=20;i++) {
							// Si la linea contiene IPv4, tieneIPv4 serï¿½ true y modificaremos el String para que solo muestre la IP.
							if(linea.contains("sica")) {
								tieneMAC = true;
								String[] mac = linea.split(": ");
								System.out.println(mac[1]);
								break;
							} else {
								linea = br.readLine();
							}
						}
					}
				}
				if(interfazExiste == false && !tieneMAC) {
					System.out.println("Esta interfaz no existe.");
				}
				
				if(interfazExiste == true && !tieneMAC) {
					System.out.println("Esta interfaz no tiene una MAC.");
				}
				br.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NullPointerException e) {
			}
			
		//El SO no es Windows (osea es Ubuntu o otro).
		} else {
			pb.command("bash", "-c", "arp -a mac");
			
			System.out.println("¿Cuál es el nombre de la interfaz que desea mostrar su MAC?");
			// Permitimos al usuario escribir el nombre de la interfaz con Scanner.
			String interfaz = scanner.nextLine();
			
			// Permiten controlar si existe la interfaz, o si no contiene una IPv4.
			Boolean interfazExiste = false;
			Boolean tieneMAC = false;
			
			try {
				// Proceso que ejecuta un proceso listando la configuraciï¿½n de red.
				Process process = pb.start();
				BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
				
				String linea;
				while((linea = br.readLine()) != null) {
					// Si la linea contiene el nombre de la interfaz que le hemos dado, entramos y interfazExiste serï¿½ true.
					if(linea.contains(interfaz)) {
						interfazExiste = true;
						for(int i=0; i<=20;i++) {
							// Si la linea contiene IPv4, tieneIPv4 serï¿½ true y modificaremos el String para que solo muestre la IP.
							if(linea.contains("sica")) {
								tieneMAC = true;
								String[] mac = linea.split(": ");
								System.out.println(mac[1]);
								break;
							} else {
								linea = br.readLine();
							}
						}
					}
				}
				if(interfazExiste == false && !tieneMAC) {
					System.out.println("Esta interfaz no existe.");
				}
				
				if(interfazExiste == true && !tieneMAC) {
					System.out.println("Esta interfaz no tiene una MAC.");
				}
				br.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NullPointerException e) {
			}
		}

		
	}
	
	private static void comprobarConexion() {
		//Detectamos si el SO es Windows.
		if(so.contains("Windows")) {
			pb.command("cmd.exe", "/c", "ping www.google.es");
			ArrayList<String> listaLineas = new ArrayList<>();
			Process process;
			String linea;
			try {
				process = pb.start();
				
				System.out.println("Espera, se está realizando la comprobación de internet.");
				
				BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
				while((linea = br.readLine()) != null) {
					listaLineas.add(linea);
				}
				for(String s : listaLineas) {
					if(s.contains("no pudo encontrar el host")) {
					System.out.println("No tienes conexión a internet o la dirección ingresada no existe.");
					} else if(s.contains("Haciendo ping a")) {
						System.out.println("Tienes conexión a internet.");
				}
				}
				
				System.out.println("\n");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			pb.command("bash","-c 5", "ping 8.8.8.8");
			ArrayList<String> listaLineas = new ArrayList<>();
			Process process;
			String linea;
			try {
				process = pb.start();
				
				System.out.println("Espera, se está realizando la comprobación de internet.");
				
				BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
				while((linea = br.readLine()) != null) {
					listaLineas.add(linea);
				}
				for(String s : listaLineas) {
					if(s.contains("connect: Network is unreachable")) {
					System.out.println("No tienes conexión a internet o la dirección ingresada no existe.");
					} else if(s.contains("bytes of data")) {
						System.out.println("Tienes conexión a internet.");
				}
				}
				
				System.out.println("\n");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
