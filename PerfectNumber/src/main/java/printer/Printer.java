package printer;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;

import Barrier.Barrier;
import Buffer.Buffer;

public class Printer {
	LinkedList<BigInteger> lista;
	int cantidadInicial;
	
	public Printer(){
		lista = new LinkedList<BigInteger>();
	}
	
	public Printer(Barrier barrier, Buffer buffer){
		lista = barrier.getListaRes();
		cantidadInicial = buffer.getAgregados();
	}
	
	public void print(){
		System.out.println("Numeros totales analizados: " + cantidadInicial);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		
	 
		
		System.out.println("Cantidad de números perfectos: " + lista.size() + " números");
		
		System.out.println("Lista de perfectos: " + this.getListaString());
	
	}

	public int getCantidadInicial() {
		return cantidadInicial;
	}

	public void setCantidadInicial(int i) {
		this.cantidadInicial = cantidadInicial;
	}

	public LinkedList<BigInteger> getLista() {
		return lista;
	}

	public void setLista(LinkedList<BigInteger> lista) {
		this.lista = lista;
	}
	
	public String getListaString(){
		int l = lista.size();
		String s = "[";
		for(BigInteger e : this.lista){
			int n= e.intValueExact();
			String number = String.valueOf(n);
			s = s.concat(number);
			l--;
			if(!(l == 0))
				s = s.concat(", ");
		}
		s = s.concat("]");
		return s;
}
	
}