package de.apollon.poc.bnd.service.target.internal.master;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import aQute.bnd.annotation.ProviderType;
import aQute.bnd.annotation.component.Activate;
import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.ConfigurationPolicy;
import aQute.bnd.annotation.component.Deactivate;
import aQute.bnd.annotation.component.Modified;
import aQute.bnd.annotation.component.Reference;
import aQute.bnd.annotation.metatype.Configurable;
import de.apollon.poc.bnd.service.target.slave.Slave;

@ProviderType
@Component(name = MasterComponent.COMPONENT_NAME, designateFactory = MasterConfig.class, configurationPolicy = ConfigurationPolicy.require, enabled = true, immediate = true)
public class MasterComponent
{

	/**
	 * <p>
	 * Represents the {@link Logger} of this class.
	 * </p>
	 */
	private static final Logger LOG = LoggerFactory.getLogger(MasterComponent.class.getName());

	static final String COMPONENT_NAME = "de.apollon.poc.bnd.service.target.master";

	private MasterConfig config;

	private Slave slave;

	@Activate
	public void activate(Map<String, String> properties)
	{
		LOG.info("Activating '{}' ...", COMPONENT_NAME);
		config = Configurable.createConfigurable(MasterConfig.class, properties);

		LOG.info("Master '{}' -> Slave: '{}'", config.id(), slave.getId());
	}

	@Modified
	public void modified(Map<String, String> properties)
	{
		LOG.info("Modifying '{}' ...", COMPONENT_NAME);
		activate(properties);
	}

	@Deactivate
	public void deactivate()
	{
		LOG.info("Deactivating '{}' ...", COMPONENT_NAME);
	}

	@Reference
	public void setSlave(Slave slave)
	{
		this.slave = slave;
	}
}
