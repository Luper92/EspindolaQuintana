package Barrier;

import java.math.BigInteger;
import java.util.LinkedList;

public class Barrier {
	
	private int tope;

	private LinkedList<BigInteger> listaRes;
	private boolean puedeImprimir;

	public Barrier(int cantThreads) {
		this.tope = cantThreads;
		this.listaRes = new LinkedList<BigInteger>();
		this.puedeImprimir = true;
	}

	public synchronized void esperar() {
		tope--;
		while (tope != 0){
			try 
			{
				wait();
			} catch (InterruptedException e) {
			}
		}
		
		if(puedeImprimir) {
			imprimir();
		}
		
		notifyAll();
	}

	//imprime la lista con todos los numeros Perfectos
	private void imprimir() {
		System.out.println("buffer lisyta "+ listaRes.size());
		puedeImprimir = false;
	}
	
	public void agregar(BigInteger n) {
		listaRes.add(n);
	}
}