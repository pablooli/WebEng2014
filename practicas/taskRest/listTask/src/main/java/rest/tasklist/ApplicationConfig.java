package rest.tasklist;

import org.eclipse.persistence.jaxb.rs.MOXyJsonProvider;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

public class ApplicationConfig extends ResourceConfig {

	/**
     * Default constructor
     */
    public ApplicationConfig() {
    	this(new MenuTareas());
    }


    /**
     * Main constructor
     * @param menuTareas a provided address book
     */
    public ApplicationConfig(final MenuTareas menuTareas) {
    	register(TaskListService.class);
    	register(MOXyJsonProvider.class);
    	register(CrossDomainFilter.class);
    	register(new AbstractBinder() {

			@Override
			protected void configure() {
				bind(menuTareas).to(MenuTareas.class);
			}});
	}	

}
