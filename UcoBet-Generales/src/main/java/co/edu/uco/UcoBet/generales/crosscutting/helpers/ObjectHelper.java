package co.edu.uco.UcoBet.generales.crosscutting.helpers;

public class ObjectHelper {
	
	private static final ObjectHelper INSTANCE = new ObjectHelper();
	
	private ObjectHelper() {

	}

	public static <O> boolean isNull(final O object) {
		return object == null;
	}

	public static <O> O getDefault(final O object, final O defaultObject) {
		return isNull(object) ? defaultObject : object;
	}
	
	public static final ObjectHelper getObjectHelper() {
		return INSTANCE;
	}

}
