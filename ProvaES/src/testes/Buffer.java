package testes;

import java.util.ArrayList;
import java.util.List;

public class Buffer {
	
	private int size;
	private List<Integer> buffer;

	
	public Buffer(int size) throws BufferExpection{
		if(size>=0){
			this.size = size;
			buffer = new ArrayList<Integer>();
			
		}else{
			throw new BufferExpection("size ilegal");
		}
	}
	
	public void put(int val) throws BufferExpection{
		if(buffer.size()<size){
			buffer.add(val);
		}else{
			throw new BufferExpection("cheio");
		}
	}
	
	public int get(int e) throws BufferExpection{
		try{
			
				return buffer.get(buffer.indexOf(e));
		}catch (Exception ex) {
			throw new BufferExpection("nao achou");
		}
		
	}
	
	public boolean isEmpty(){
		return buffer.isEmpty();
	}
	
	public boolean isFull(){
		return buffer.size()==size;
	}
	
	
	
	
}
