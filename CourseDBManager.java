import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
/**
 * @author Nabil El-Hage
 * Professor Thai - CMSC 204
 * Due: 10/23/23
 * Description: This class will obtain class information, such as the ID, CRN, Credits, Room Number, etc.
 */

public class CourseDBManager implements CourseDBManagerInterface {
	private CourseDBStructure CDS = new CourseDBStructure(15);

	@Override
	public void add(String i, int c, int credits, String room, String instr) {
		CourseDBElement elements = new CourseDBElement(i, c, credits, room, instr);
		CDS.add(elements);
	}

	
	@Override
	public CourseDBElement get(int crn) {
		try {
			return CDS.get(crn);
		} catch (IOException e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public void readFile(File input) throws FileNotFoundException {
		try {
			Scanner scanner = new Scanner(input);
			while(scanner.hasNext()) {
				String id = scanner.next();
				int crn = scanner.nextInt();
				int numCredits = scanner.nextInt();
				String roomNum = scanner.next();
				String instructor = scanner.nextLine();
				add(id, crn, numCredits, roomNum, instructor);
			}
			scanner.close();
		}
		catch(FileNotFoundException e) {
			System.out.print("The file is not found");
			e.getMessage();
		}
	}

	
	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> stoll = new ArrayList<String>();
		for (int i = 0; i<CDS.hashTable.length; i++) { 
			LinkedList<CourseDBElement> list = CDS.hashTable[i];
			if(list != null) {
				for(int j = 0; j < list.size(); j++) { 
					CourseDBElement element = list.get(j);
					stoll.add(element.toString());

				}
			}
		}

		return stoll;
	}

}



































