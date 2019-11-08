package TPConc.PerfectNumber;

import java.math.BigInteger;
import java.util.LinkedList;

import Buffer.Buffer;
import printer.Printer;

public class Main {
	
	public static void main( String[] args ) {
		
		
		int cantThread = 9;
		int capBuffer = 6;
		BigInteger numPerfectoBI3 = new BigInteger("496");
		BigInteger numPerfectoBI4 = new BigInteger("8128");
		BigInteger numPerfectoBI5 = new BigInteger("33550336");
		BigInteger numPerfectoBI6 = new BigInteger("8589869056");
		BigInteger numPerfectoBI7 = new BigInteger("137438691328");
		
		Buffer b = new Buffer(capBuffer);
		
		ThreadPool tpool = new ThreadPool(cantThread, b);

		LinkedList<BigInteger> lista = new LinkedList<BigInteger>();
		
		crearLista(lista, 195);
		
		lista.add(numPerfectoBI5);
		lista.add(numPerfectoBI3);
		lista.add(numPerfectoBI4);
		lista.add(numPerfectoBI5);
		//lista.add(numPerfectoBI6);
		//lista.add(numPerfectoBI7);
		
		crearPoisonsPills(lista, cantThread);
		
		lista.forEach(e -> b.escribir(e));
		
		//System.out.println("agregados reales: " + b.getAgregados());
		//tpool.print();
		//Printer p = new Printer(tpool.barrierT, b);
		//p.print();
		
	}
	
	private static void crearPoisonsPills(LinkedList<BigInteger> lista, int cantThread) {
		for(int i = 0; i < cantThread; i++) {
			lista.add(new BigInteger("-1"));
		}
	}

	private static void crearLista(LinkedList<BigInteger> lista, int size) {
		for(int i = 1; i < size; i++) {
			lista.add(new BigInteger(i+""));
			
		}
	}
}