/**
 * @author Nabil El-Hage
 * Professor Thai - CMSC 204
 * Due: 10/23/23
 * Description: This class contains all of the class information, and grants the ability to present all working information.
 */

public class CourseDBElement implements Comparable{
	//Objects
        private String ID;
        private int CRN;
        private int numCred;
        private String roomNum;
        private String instructor;
        
        //Provides objects into CourseDBElement
        public CourseDBElement(String i, int c, int n, String room, String instr) {
                ID = i;
                CRN = c;
                numCred = n;
                roomNum = room;
                instructor = instr;
        }

        public CourseDBElement() {
        	 ID = "";
             CRN = 0;
             numCred = 0;
             roomNum = "";
             instructor ="";
              
        }
        
        public int compareTo(CourseDBElement element) {
        	
                return CRN - element.CRN;
        }
        
        public int getCRN() {
                return CRN;
        }
        
        public void setCRN(int crn) {
                CRN = crn;
        }
        
        @Override
        public int hashCode() {
                String str = CRN + "";
                return str.hashCode();
        }
      
        @Override
        public boolean equals(Object eql) {
                if (this ==eql)
                        return true;
                if (eql== null)
                        return false;
                if (getClass() != eql.getClass())
                        return true;
                CourseDBElement keep = (CourseDBElement) eql;
                if (CRN != keep.CRN)
                	return false;
                return true;
        }
      
        @Override
        public String toString() {
               return "\nCourse: " + ID + " CRN: " + CRN + " Credits: " + numCred + " Instructor: " + instructor + " Room: " + roomNum;
               
        }
        
		public Object getRoomNum(){
			return roomNum;
		}
		 
		public Object getID(){
			return ID;
		}
		@Override
		public int compareTo(Object o){
			return 0;
		}
		
}
