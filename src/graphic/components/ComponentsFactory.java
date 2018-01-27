package graphic.components;

public class ComponentsFactory {

	public static IComponents getComponents(String componentsType) {
		if (componentsType.equalsIgnoreCase("BACKGROUND")) {
			return new Background();
		} else if (componentsType.equalsIgnoreCase("DECOR")) {
			return new Decor();
		} else if (componentsType.equalsIgnoreCase("MESSAGES")) {
			return new Messages();
		} else if (componentsType.equalsIgnoreCase("LIFE")) {
			return new LifeView();

		}
		return null;
	}
}