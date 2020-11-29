package com.carlos.me.SeccionCritica;

public class Bandeja {
	private int hamburguesas = 0;
	
	public Bandeja() {
		
	}
	
	public synchronized void comer(Integer id) throws InterruptedException {
		System.out.println("Hamburguesas: " + hamburguesas);
		while(hamburguesas == 0) {
			System.out.println("Cliente "+id+ ": Ha intentado comer una hamburguesa, pero no hay.");
			System.out.println("");
				wait();
		} 
		--hamburguesas;
		System.out.println("Cliente "+id+ ": ha comido una hamburguesa.");
		System.out.println("Hamburguesas: " + hamburguesas);
		System.out.println();
		notify();

	}
	public synchronized void cocinar(Integer id) {
		++hamburguesas;
		System.out.println("Cocinero " + id + ": Ha cocinado 1 hamburguesa.");
		System.out.println("Hamburguesas: " + hamburguesas);
		System.out.println();
		notify();
	}

}
