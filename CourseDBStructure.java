import java.io.IOException;
import java.util.*;
/**
 * @author Nabil El-Hage
 * Professor Thai - CMSC 204
 * Due: 10/23/23
 * Description: This class holds elements
 */

public class CourseDBStructure implements CourseDBStructureInterface {
       
		protected int size;
        protected LinkedList<CourseDBElement> hashTable[];
      
       
        
        //Create the size
        @SuppressWarnings("unchecked")
        public CourseDBStructure(int test) {
                this.size = test;
                hashTable = new LinkedList[size];
        }
        
        //Sets size
        @SuppressWarnings("unchecked")
        public CourseDBStructure(String str, int size) {
                this.size =size;
                hashTable = new LinkedList[size];
        }
        
        
        //If hashtable is null, add a linkedlist from CourseDBElement.
        @Override
        public void add(CourseDBElement element) {
                int index = element.hashCode() % size;
                if(hashTable[index] == null) {
                        hashTable[index] = new LinkedList<CourseDBElement>();
                }
                hashTable[index].add(element);
        }
        
        
        //If CRN doesnt exsist, throw exception. 
        @Override
        public CourseDBElement get(int crn) throws IOException {
        	
        	 toString();
                String str = crn + "";
                int index = str.hashCode() % size;
                if(hashTable[index] == null) {
                        throw new IOException();
                }
                else {
                for(int i = 0; i < size; i++) {
                CourseDBElement temp = hashTable[index].get(i);
                 if(temp.getCRN() == crn) {
                   return temp;
                                }
                        }
               return null;
                }
        }
        
        
        @Override
        public int getTableSize() {
                return size;
        }
	    @Override
		public ArrayList<String> showAll() {
	    
	    ArrayList<String>courseList=new ArrayList<>();
	  	for(int j = 0; j <hashTable.length; j++) {
	  		LinkedList<CourseDBElement>list = hashTable[j];
	  		if(list!=null) {
	  			for(int i = 0; i<list.size(); i++) {
	  				CourseDBElement element = list.get(i);
	  				courseList.add(element.toString());
	  			}
	  		}
	  	}
		return courseList;
	    }
	    
}
