import java.util.Date;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		return students;
	}

	@Override
	public void setStudents(Student[] students) throws IllegalArgumentException{
		if(students==null)
			throw new IllegalArgumentException();
		this.students=students;
		return;
	}

	@Override
	public Student getStudent(int index)throws IllegalArgumentException {
		if(index<0 || index >= students.length)
			throw new IllegalArgumentException();
		return students[index];
	}

	@Override
	public void setStudent(Student student, int index)throws IllegalArgumentException {
		if(student==null || index < 0 || index>=students.length)
			throw new IllegalArgumentException();
		students[index]=student;
		return;
	}

	@Override
	public void addFirst(Student student)throws IllegalArgumentException {
		if(student==null)
			throw new IllegalArgumentException();
		add(student,0);
		return;
	}

	@Override
	public void addLast(Student student)throws IllegalArgumentException {
		if(student==null)
			throw new IllegalArgumentException();
		add(student,students.length);
	}

	@Override
	public void add(Student student, int index)throws IllegalArgumentException {
		if(student==null || index < 0 || index>=students.length)
			throw new IllegalArgumentException();
		Student[] new_students=new Student[students.length+1];
		for(int i=0;i<index;++i)
			new_students[i]=students[i];
		new_students[index]=student;
		for(int i=index+1;i<students.length;++i)
			new_students[i]=students[i-1];
		students=new_students;
		return;
	}

	@Override
	public void remove(int index)throws IllegalArgumentException {
		if(index<0 || index >= students.length)
			throw new IllegalArgumentException();
		Student[] new_students=new Student[students.length-1];
		for(int i=0;i<index;++i)
			new_students[i]=students[i];
		for(int i=index+1;i<students.length;++i)
			new_students[i-1]=students[i];
		students=new_students;
		return;
	}

	@Override
	public void remove(Student student) throws IllegalArgumentException{
		int count=0;
		if(student==null)
			throw new IllegalArgumentException();
		for (int i=0;i<students.length;++i) {
			if(students[i].equals(student))
			{
				count++;
				remove(i);
				break;
			}
		}
		if(count==0)
			throw new IllegalArgumentException("Student not exist");
		return;
	}

	@Override
	public void removeFromIndex(int index)throws IllegalArgumentException {
		if(index<0 || index >= students.length)
			throw new IllegalArgumentException();
		Student[] new_students=new Student[index+1];
		for (int i=0;i<=index; ++i)
			new_students[i]=students[i];
		students=new_students;
		return;
	}

	@Override
	public void removeFromElement(Student student)throws IllegalArgumentException {
		if(student==null)
			throw new IllegalArgumentException();
		for (int i=0;i<students.length;++i)
			if(students[i]==student)
			{
				removeFromIndex(i);
				break;
			}
		return;
	}

	@Override
	public void removeToIndex(int index) throws IllegalArgumentException{
		if(index<0 || index >= students.length)
			throw new IllegalArgumentException();
		Student[] new_students=new Student[students.length-index];
		int j=0;
		for (int i=index;i<students.length; ++i)
			new_students[j++]=students[i];
		students=new_students;
		return;
	}

	@Override
	public void removeToElement(Student student)throws IllegalArgumentException {
		if(student==null)
			throw new IllegalArgumentException();
		for (int i=0;i<students.length;++i)
			if(students[i]==student)
			{
				removeToIndex(i);
				break;
			}
		return;
	}

	@Override
	public void bubbleSort() {
		for (int i=1; i<students.length; ++i)
	        for(int j=0; j<students.length -i; ++j)
	            if (students[j].compareTo(students[j+1]) > 0)
	     		{
	                Student temp = students[j];
		            students[j] = students[j+1];
		            students[j+1] = temp;
		        }
		return;
    }

	@Override
	public Student[] getByBirthDate(Date date) {
		
		return null;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		
		return null;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		
		return 0;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		return null;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		return null;
	}
}
