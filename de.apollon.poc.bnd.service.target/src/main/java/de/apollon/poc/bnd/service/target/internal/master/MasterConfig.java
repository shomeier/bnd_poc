/**
 *
 */
package de.apollon.poc.bnd.service.target.internal.master;

import aQute.bnd.annotation.metatype.Meta;

/**
 * @author SHomeier
 */
@Meta.OCD(name = "apollon BND POC Service Target Master")
public interface MasterConfig
{
	@Meta.AD(id = "slave.target")
	String slaveTarget();

	@Meta.AD(id = "id")
	String id();
}
