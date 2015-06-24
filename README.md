# bnd_poc
This is a small POC for dynamically wiring OSGi services by configuration properties.
It is related to this StackOverflow question:
http://stackoverflow.com/questions/31004012/dynamically-wire-osgi-services-by-configuration-properties/31006003#31006003

There exists two components:
* MasterComponent: This component has two configurations and therefore two service instances. Every instance binds one instance of a SlaveComponent Service depending on its configuration property "id"
* SlaveComponent: This component also has two instances with different configuration property "id"

An instance of the Slave Component is bind to an instance of a Master Component. This "wiring" is done dynamically during runtime by configuration properties:

For example:
Master Component has the property: slave.target = slave.target = (id=slave_one)
Slave Component has the property: id = slave_one

In this case the instance of the Master Component bind the Slave Component instance with id = slave_one.
