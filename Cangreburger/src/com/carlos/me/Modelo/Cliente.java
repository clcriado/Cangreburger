package com.carlos.me.Modelo;

import java.util.Random;
import com.carlos.me.SeccionCritica.Bandeja;

public class Cliente extends Thread{
	
	private int hamburguesasComidas = 0;
	private int numeroCliente;
	private Bandeja bandeja;
	
	public Cliente(int numeroCliente, Bandeja bandeja) {
        this.bandeja = bandeja;
        this.numeroCliente = numeroCliente;
    }
    public void run() {
    	Random random = new Random();
    	while(true) {
    		try {
    			sleep(random.nextInt(2000 - 1000 + 1000) + 0);
    			bandeja.comer(numeroCliente);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
    	}
    }
    
    
    
	public int getNumeroCliente() {
		return numeroCliente;
	}
	public void setNumeroCliente(int numeroCliente) {
		this.numeroCliente = numeroCliente;
	}
	public int getHamburguesasComidas() {
		return hamburguesasComidas;
	}
	public void setHamburguesasComidas(int hamburguesasComidas) {
		this.hamburguesasComidas = hamburguesasComidas;
	}
    
}
