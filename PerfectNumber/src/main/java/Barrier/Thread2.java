package Barrier;

public class Thread2 implements Runnable {

	private Barrier barrier2;
	
	public Thread2(Barrier b) {
		barrier2 = b;
	}
	
	@Override
	public void run() {
		 System.out.println('b');
		 barrier2.esperar();
		 System.out.println(2);
	}

}
