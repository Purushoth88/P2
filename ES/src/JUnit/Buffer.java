package JUnit;

import java.util.ArrayList;

import javax.naming.directory.InvalidAttributesException;
import javax.swing.text.html.InlineView;

public class Buffer {
	
	private ArrayList<Integer> list;
	private final int MAX_SIZE;
	private static int index;
	
	public Buffer(int size) throws InvalidAttributesException{
		if(size<0){
			throw new InvalidAttributesException("Tamano no es valido");
		}else{
			MAX_SIZE = size;
			list = new ArrayList<Integer>();
		}
		
	}
	
	public void put(int element) {
		if(list.size()<MAX_SIZE) list.add(element); 
		else throw new IndexOutOfBoundsException("Buffer llenado");
	}
	
	public int get(int element) throws InvalidAttributesException{
		
			if(list.remove(new Integer(element))) return element;
			else throw new InvalidAttributesException();
		
		
		
	}
	
	public boolean isEmpty(){
		return list.isEmpty();
	}
	
	public boolean isFull(){
		return MAX_SIZE==list.size();
	}
	
	public static void main(String[] args) throws InvalidAttributesException {
		Buffer b = new Buffer(2);
		b.put(2);
		b.put(3);

		b.get(2323);
	}
	
	
}
