package test;

import java.math.BigInteger;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Buffer.Buffer;

public class Test3 extends AbstractTest{

/*
	Chequear casos de numeros perfectos donde:
 		a) numeros analizados sea mayor a 400
 		b) numeros perfectos encontrados sean 7 minimo
 		c) variar la cantidad de Threads y tamaño de buffer entre
 		los distintos casos
 
 TEST1: Todos estos test tienen tamaño de buffer 1000 y 6 threads
 
 */
	
	
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
		capBuffer = 1000;
		
		
		
		
		b = new Buffer(capBuffer);
		
		lista = new LinkedList<BigInteger>();
		contador = lista.size() + cantThread;
	}
	
	//Caso0 (minimo): 500 numeros analizados, 7 numeros perfectos
	@Test
	public void testCase0() {
		lista.add(new BigInteger("496"));
		lista.add(new BigInteger("8128"));
		lista.add(new BigInteger("8128"));
		lista.add(new BigInteger("33550336"));
		//lista.add(new BigInteger("8589869056"));
		//lista.add(new BigInteger("137438691328"));
		
		this.comenzarEjecucion(497);
		
		while(tpool.getContador().getCantThreads() > tpool.getContador().getThreadsTerminados()){
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		Assert.assertEquals(tpool.barrierT.getListaRes().size(),7);
	}
	
	
	
	//Caso1: 50000 numeros analizados, 7 numeros perfectos
	@Test
	public void testCase1() {
		
		lista.add(new BigInteger("8128"));
		lista.add(new BigInteger("33550336"));
		lista.add(new BigInteger("33550336"));
		//lista.add(new BigInteger("8589869056"));
		//lista.add(new BigInteger("137438691328"));
		
		this.comenzarEjecucion(49998);
		
		while(tpool.getContador().getCantThreads() > tpool.getContador().getThreadsTerminados()){
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		Assert.assertEquals(tpool.barrierT.getListaRes().size(),7);
	}
	
	//Caso2: 100000 numeros analizados, 10 numeros perfectos
	@Test
	public void testCase2() {
		lista.add(new BigInteger("496"));
		lista.add(new BigInteger("496"));
		lista.add(new BigInteger("8128"));
		lista.add(new BigInteger("8128"));
		lista.add(new BigInteger("33550336"));
		lista.add(new BigInteger("33550336"));
		
		
//		this.setUp();
		this.comenzarEjecucion(99995);
		
		while(tpool.getContador().getCantThreads() > tpool.getContador().getThreadsTerminados()){
			//System.out.println("Threads: " + tpool.getContador().getCantThreads());
			//System.out.println("Terminados: " + tpool.getContador().getThreadsTerminados());
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Assert.assertEquals(tpool.barrierT.getListaRes().size(),10);
		}
}
