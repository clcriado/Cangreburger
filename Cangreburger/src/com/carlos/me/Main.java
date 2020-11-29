package com.carlos.me;

import java.util.ArrayList;

import com.carlos.me.Modelo.Cliente;
import com.carlos.me.Modelo.Cocinero;
import com.carlos.me.SeccionCritica.Bandeja;

public class Main {
	
	public static void main(String args[]) {
		//Declaramos la bandeja.
		Bandeja bandeja = new Bandeja();
		
		//Declaramos las Listas.
		ArrayList<Cocinero> listaCocineros = new ArrayList<>();
		ArrayList<Cliente> listaCliente = new ArrayList<>();
		
		//Rellenamos las Listas.
		for(int i = 1; i<=120000;i++) {
			Cocinero cocinero = new Cocinero(i,bandeja);
			listaCocineros.add(cocinero);
		}
		for(int i = 1; i<=120000;i++) {
			Cliente cliente = new Cliente(i,bandeja);
			listaCliente.add(cliente);
		}
		
		for(Cocinero c: listaCocineros) {
			c.start();
		}
		
		for(Cliente c: listaCliente) {
			c.start();
		}
	}

}
