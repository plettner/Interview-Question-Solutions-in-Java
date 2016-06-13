package threads;

public class ThreadUtils {

	/**
	 * Sleep for a bit without throwing any exceptions.
	 *
	 * @param millis
	 *            how long in milliseconds to wait
	 */
	public static void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (final Exception exception) {
			System.err.println(exception.toString());
		}
	}

}
