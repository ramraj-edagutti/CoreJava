package serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectSerializtions {

	/**
	 * Serialize an object into a byte array, which can be stored in a database
	 * as a blob
	 */
	public static byte[] objectToByteArray(Object obj) throws Exception {
		try {
			ByteArrayOutputStream byteArrayStream = new ByteArrayOutputStream();
			ObjectOutputStream objectStream = new ObjectOutputStream(byteArrayStream);
			objectStream.writeObject(obj);
			objectStream.flush();
			return byteArrayStream.toByteArray();
		} catch (NotSerializableException exception) {
			throw new Exception("Class, " + obj.getClass() + " is not serializable.", exception);
		} catch (IOException ioe) {
			throw new Exception("Could not serialize class: " + obj.getClass() + ".", ioe);
		}
	}

	/**
	 * Turn a byteArray (from database) back into an Object
	 */
	public static Object byteArrayToObject(byte[] byteArray) throws Exception {
		try {
			ByteArrayInputStream inputStream = new ByteArrayInputStream(byteArray);
			ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
			return objectInputStream.readObject();
		} catch (ClassNotFoundException cex) {
			cex.printStackTrace();
			throw new Exception("Could not find the class to deserialize to.", cex);
		} catch (IOException ioe) {
			System.out.println("ioe exception...");
			ioe.printStackTrace();
			throw new Exception("Could not deserialize byte array.", ioe);
		}
	}

}
