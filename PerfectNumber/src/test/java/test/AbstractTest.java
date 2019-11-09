package test;

import java.math.BigInteger;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Buffer.Buffer;
import TPConc.PerfectNumber.ThreadPool;
import printer.Printer;

public class AbstractTest {
	long startTime;
	long endTime;
	long totalTime;
	double totalSeconds;
	
int cantThread;
int capBuffer;

BigInteger numPerfectoBI1 = new BigInteger("6");
BigInteger numPerfectoBI2 = new BigInteger("28");
BigInteger numPerfectoBI3 = new BigInteger("496");
BigInteger numPerfectoBI4 = new BigInteger("8128");
BigInteger numPerfectoBI5 = new BigInteger("33550336");
BigInteger numPerfectoBI6 = new BigInteger("8589869056");
BigInteger numPerfectoBI7 = new BigInteger("137438691328");

Buffer b;
ThreadPool tpool;
LinkedList<BigInteger> lista;
Printer p;
int contador;
@Before
public void setUp(){
	numPerfectoBI1 = new BigInteger("6");
	 numPerfectoBI2 = new BigInteger("28");
	 numPerfectoBI3 = new BigInteger("496");
	 numPerfectoBI4 = new BigInteger("8128");
	 numPerfectoBI5 = new BigInteger("33550336");
	 numPerfectoBI6 = new BigInteger("8589869056");
	 numPerfectoBI7 = new BigInteger("137438691328");
	
	cantThread = 6;
	capBuffer = 10;
	
	
	
	
	b = new Buffer(capBuffer);
	
	lista = new LinkedList<BigInteger>();
	contador = lista.size() + cantThread;
}

public void comenzarEjecucion(int numerosAAnalizar){
	 
	
	
	
	
	startTime = System.nanoTime();
	
	tpool = new ThreadPool(cantThread, b);
	
	//lista.add(new BigInteger("8128"));
	//lista.add(new BigInteger("33550336"));
	//lista.add(new BigInteger("8589869056"));
	//lista.add(new BigInteger("137438691328"));
	
	
	crearLista(lista, numerosAAnalizar);
	
	
	
	crearPoisonsPills(lista, cantThread);
	
	lista.forEach(e -> b.escribir(e));
		
	endTime = System.nanoTime();
	totalTime = endTime-startTime;
	
	totalSeconds = (double)totalTime / 1_000_000_000.0;
	
	//System.out.println("Tiempo de ejecucion: " + totalSeconds + " segundos");
	
	
}


	
	private void crearPoisonsPills(LinkedList<BigInteger> lista, int cantThread) {
		for(int i = 0; i < cantThread; i++) {
			lista.add(new BigInteger("-1"));
		}
	}

	private void crearLista(LinkedList<BigInteger> lista, int size) {
		for(int i = 1; i < size; i++) {
			//lista.add(new BigInteger(i+""));
			lista.add(new BigInteger(i+""));
			
		}
		//i = 8589869056;
		//lista.add(new BigInteger(i+""));
		
		//i = 137438691328;
		//lista.add(new BigInteger(i+""));
	}
}
