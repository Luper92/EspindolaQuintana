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
		this.puedeImprimir = false;
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
		int l = listaRes.size();
		String s = "[";
		for(BigInteger e : this.listaRes){
			int n= e.intValueExact();
			String number = String.valueOf(n);
			s = s.concat(number);
			l--;
			if(!(l == 0))
				s = s.concat(", ");
		}
		s = s.concat("]");
		//return s;
		//System.out.println("buffer lisyta "+ listaRes.size());
		//Printer p = new Printer(listaRes);
		//p.print();
		puedeImprimir = false;
		System.out.println("Numeros Perfectos "+ s);
	}
	
	public void agregar(BigInteger n) {
		puedeImprimir = true;
		listaRes.add(n);
	}

	public LinkedList<BigInteger> getListaRes() {
		return listaRes;
	}

	public void setListaRes(LinkedList<BigInteger> listaRes) {
		this.listaRes = listaRes;
	}
	
	
}