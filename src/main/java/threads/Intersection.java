package threads;

/**
 * Simple little class that takes 100ms to execute its main method. This will
 * provide a simple test for proving that we are ensuring that our threads
 * aren't stepping on top of each other as they try to use this resource.
 * <p>
 * Note that you can only get one instance of this class, the singleton. This
 * means that all of the data owned by the class is in one place, and that
 * multiple threads will have to compete to use it.
 * </p>
 */
public class Intersection {

	private static final Intersection SINGLETON = new Intersection();

	private Intersection() {
	}

	public static Intersection getInstance() {
		return Intersection.SINGLETON;
	}

	public synchronized void execute(int vehicleId) {
		synchronized (this) {
			System.out.println("#" + vehicleId + " GREEN!");
			this.sleep(100);
			System.out.println("#" + vehicleId + " RED!");
		}
	}

	private void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (final Exception exception) {
			System.err.println(exception.toString());
		}
	}

}
