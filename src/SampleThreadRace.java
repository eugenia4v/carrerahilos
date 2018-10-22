
public class SampleThreadRace {

	/**
	 * Puntodeentradadelaaplicación.
	 *
	 * @paramargs
	 */
	public static void main(String[] args) {
//Creación de los hilos
		Clicker max = new Clicker(Thread.MAX_PRIORITY);
		Clicker min = new Clicker(Thread.MIN_PRIORITY);

//Se arrancan los hilos
		min.start();
		max.start();

//Se les deja en ejecución durante 5 segundos. Se duerme
// el proceso relativo al programa Java. Los 2 hilos creados
// anteriormente siguen ejecutándose.
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("Main thread interrupted.");
		}

//Detención de los hilos
		min.stop();
		max.stop();

//Se imprime el valor del contador de ambos
		System.out.println("Max - priority thread: " + max.click);
		System.out.println("Min - priority thread: " + min.click);
	}
}
