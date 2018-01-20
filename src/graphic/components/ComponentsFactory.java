package graphic.components;

public class ComponentsFactory {

	public static IComponents getComponents(String componentsType) {
		if (componentsType == null) {
			return null;
		}
		if (componentsType.equalsIgnoreCase("BACKGROUND")) {
			return new Background();
		} else if (componentsType.equalsIgnoreCase("BIRD")) {
			return new BirdView();
		} else if (componentsType.equalsIgnoreCase("DECOR")) {
			return new Decor();
		} else if (componentsType.equalsIgnoreCase("MESSAGES")) {
			return new Messages();
		} else if (componentsType.equalsIgnoreCase("PIG")) {
			return new PigView();
		} else if (componentsType.equalsIgnoreCase("OVEN")) {
			return new OvenView();
		}

		return null;
	}
}