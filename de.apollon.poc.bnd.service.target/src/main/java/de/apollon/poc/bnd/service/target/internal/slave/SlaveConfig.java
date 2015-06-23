/**
 *
 */
package de.apollon.poc.bnd.service.target.internal.slave;

import aQute.bnd.annotation.metatype.Meta;

/**
 * @author SHomeier
 */
@Meta.OCD(name = "apollon BND POC Service Target Slave")
public interface SlaveConfig
{
	@Meta.AD(id = "id")
	String id();
}
