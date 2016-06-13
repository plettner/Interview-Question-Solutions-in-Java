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

	public void execute(int vehicleId) {
		synchronized (this) {
			System.out.println("#" + vehicleId + " GREEN!");
			ThreadUtils.sleep(1);
			System.out.println("#" + vehicleId + " RED!");
		}
	}

}
