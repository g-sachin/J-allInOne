package com.sachin.pratice.randomstuff;

/**
 * How JVM invoke this specific behavior
ObjectOutputStream and ObjectInputStream will check your class whether or not it implementes Serializable, Externalizable. If yes it will continue or else will thrown NonSerializableException.

How to write our own marker interface
Create an interface without any method and that is your marker interface.

Sample

public interface IMarkerEntity {


}
If any class which implement this interface will be taken as database entity by your application.

Sample Code:

public boolean save(Object object) throws InvalidEntityException {
if(!(object instanceof IMarkerEntity)) {
throw new InvalidEntityException("Invalid Entity Found, cannot proceed);
} 
database.save(object);
}
Is this possible to have methods in marker interface?
The whole idea of Marker Interface Pattern is to provide a mean to say "yes I am something" and then system will proceed with the default process, like when you mark your class as Serialzable it just tells that this class can be converted to bytes.

Read more: http://javarevisited.blogspot.com/2012/01/what-is-marker-interfaces-in-java-and.html#ixzz514TdUBMu
 * @author GUR40832
 *
 */

interface IMarkerInf{
	
}
public class MarkerInterface implements IMarkerInf{

}

