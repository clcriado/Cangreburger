package com.carlos.me.Modelo;

import java.util.Random;

import com.carlos.me.SeccionCritica.Bandeja;

public class Cocinero extends Thread{
	
	private int numeroCocinero;
	private Bandeja bandeja;
	
	public Cocinero(int numeroCocinero, Bandeja bandeja) {
        this.bandeja = bandeja;
        this.numeroCocinero = numeroCocinero;
	}
    public void run() {
    	Random random = new Random();
    	
    	while(true) {
    		try {
    			sleep(random.nextInt(2000 - 1000 + 1000) + 0);
    			bandeja.cocinar(numeroCocinero);

    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
    	}
    }
	public int getNumeroCocinero() {
		return numeroCocinero;
	}
	public void setNumeroCocinero(int numeroCocinero) {
		this.numeroCocinero = numeroCocinero;
	}
    

    
}
