package fi.jamk.javaee.ogrecipes.app;

import org.glassfish.jersey.server.ResourceConfig;

public class RecipeApp extends ResourceConfig {

	public RecipeApp() {
		packages("fi.jamk.javaee.ogrecipes.app");
	}
}
