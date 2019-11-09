package printer;

public class Contador {
	//total es la cantidadDeThreads
	
	int cantThreads;
	int threadsTerminados;
	


	public Contador(int total){
		this.cantThreads = total;
		threadsTerminados = 0;
	}
	
	public void termino(){
		threadsTerminados+= 1;
		System.out.println("un thread finalizó");
		if(cantThreads == threadsTerminados){
			System.out.println("Todos los threads finalizaron");
		}
	}

	
	public int getCantThreads() {
		return cantThreads;
	}

	public void setCantThreads(int cantThreads) {
		this.cantThreads = cantThreads;
	}

	public int getThreadsTerminados() {
		return threadsTerminados;
	}

	public void setThreadsTerminados(int threadsTerminados) {
		this.threadsTerminados = threadsTerminados;
	}
	
}
