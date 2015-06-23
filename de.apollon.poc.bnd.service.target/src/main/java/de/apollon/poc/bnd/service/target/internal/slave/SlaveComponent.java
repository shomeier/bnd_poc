/**
 *
 */
package de.apollon.poc.bnd.service.target.internal.slave;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import aQute.bnd.annotation.ProviderType;
import aQute.bnd.annotation.component.Activate;
import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.ConfigurationPolicy;
import aQute.bnd.annotation.component.Deactivate;
import aQute.bnd.annotation.component.Modified;
import aQute.bnd.annotation.metatype.Configurable;
import de.apollon.poc.bnd.service.target.internal.master.MasterComponent;
import de.apollon.poc.bnd.service.target.slave.Slave;

/**
 * @author SHomeier
 */
@ProviderType
@Component(name = SlaveComponent.COMPONENT_NAME, provide = Slave.class, designateFactory = SlaveConfig.class, configurationPolicy = ConfigurationPolicy.require, enabled = true)
public class SlaveComponent implements Slave
{
	/**
	 * <p>
	 * Represents the {@link Logger} of this class.
	 * </p>
	 */
	private static final Logger LOG = LoggerFactory.getLogger(MasterComponent.class.getName());

	static final String COMPONENT_NAME = "de.apollon.poc.bnd.service.target.slave";

	private SlaveConfig config;

	@Activate
	public void activate(Map<String, String> properties)
	{
		config = Configurable.createConfigurable(SlaveConfig.class, properties);
		LOG.info("Activating '{}' with slave id '{}'...", COMPONENT_NAME, config.id());
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

	@Override
	public String getId()
	{
		return config.id();
	}
}
