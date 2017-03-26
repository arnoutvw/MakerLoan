package storage;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DataSerializer<T> {
	
	private List<T> objectList;
	private File file;
	
	private static List<DataSerializer<Object>> dataSerializers = new ArrayList<>();
	
	@SuppressWarnings("unchecked")
	private DataSerializer(List<T> objectList, File file) throws FileNotFoundException{
		this.objectList = objectList;
		this.file = file;
		dataSerializers.add((DataSerializer<Object>)this);
	}
	
	private DataSerializer(List<T> objectList, String filepath) throws FileNotFoundException {
		this(objectList, new File(filepath));
	}
	
	public static <T> void add(List<T> objectList, File file) {
		try {
			file.createNewFile();
			new DataSerializer<T>(objectList, file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static <T> void add(List<T> objectList, String filepath) {
		add(objectList, new File(filepath));
	}
	
	public static void deserializeAll() {
		for (DataSerializer<Object> datSer : dataSerializers) {
			datSer.deserialize();
		}
	}
	
	public static void serializeAll() {
		for (DataSerializer<Object> datSer : dataSerializers) {
			datSer.serialize();
		}
	}
	
	@SuppressWarnings("unchecked")
	private void deserialize() {
		try {
			FileInputStream inStream = new FileInputStream(file);
			BufferedInputStream bufInStream = new BufferedInputStream(inStream);
			ObjectInputStream objIn = new ObjectInputStream(bufInStream);
			
			T obj;
			while ((obj = (T)objIn.readObject()) != null) {
				objectList.add(obj);
			}
			
			objIn.close();
			bufInStream.close();
			inStream.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			if ( !(e instanceof EOFException) ) {
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void serialize() {
		try {
			FileOutputStream outStream = new FileOutputStream(file);
			BufferedOutputStream bufOutStream = new BufferedOutputStream(outStream);
			ObjectOutputStream objOut = new ObjectOutputStream(bufOutStream);
			
			for (T obj : objectList) {
				objOut.writeObject(obj);
			}
			
			objOut.flush();
			objOut.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
