package Barrier;

import java.math.BigInteger;
import java.util.LinkedList;

import printer.Printer;

public class Barrier {
	int tope;

	LinkedList<BigInteger> listaRes;
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
		//System.out.println("buffer lisyta "+ listaRes.size());
		//Printer p = new Printer(listaRes);
		//p.print();
		puedeImprimir = false;
	}
	
	public void agregar(BigInteger n) {
		listaRes.add(n);
	}

	public LinkedList<BigInteger> getListaRes() {
		return listaRes;
	}

	public void setListaRes(LinkedList<BigInteger> listaRes) {
		this.listaRes = listaRes;
	}
	
	
}