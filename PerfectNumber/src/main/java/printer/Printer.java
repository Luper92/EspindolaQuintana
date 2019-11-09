package printer;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;

import Barrier.Barrier;
import Buffer.Buffer;

public class Printer {
	Barrier barrier;
	//LinkedList<BigInteger> lista;
	Buffer buffer;
	
	public Printer(Barrier barrier, Buffer b){
		this.barrier = barrier;
		buffer = b;
	}
	
	public void print(){
		System.out.println("Numeros totales analizados: " + buffer.getAgregados());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		
	 
		
		System.out.println("Cantidad de números perfectos: " + barrier.getListaRes().size() + " números");
		
		System.out.println("Lista de perfectos: " + this.getListaString());
	
	}

	
	public String getListaString(){
		int l = barrier.getListaRes().size();
		String s = "[";
		for(BigInteger e : barrier.getListaRes()){
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