package java8.dilips;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

import java8.dilips.data.Student;
import java8.dilips.data.StudentDataBase;

public class PredicateAndConsumer {
	
	Predicate<Student> p1=s->s.getGradeLevel()>=3;
	Predicate<Student> p2=s->s.getGpa()>=3.9;
	
	BiPredicate<Integer, Double> biPredicate=(gradeLevel,gpa)->gradeLevel>=3 && gpa>=3.9;
	
	BiConsumer<String, List<String>> studentBiConsumer=(name,activities)->System.out.println(name+" : "+activities);
	Consumer<Student> studentConsumer=student->{
		if(biPredicate.test(student.getGradeLevel(), student.getGpa())) {
			studentBiConsumer.accept(student.getName(), student.getActivities());
		}
	};
	public void printNameAndActivities(List<Student> students) {
		students.forEach(studentConsumer);
	}
public static void main(String[] args) {
	List<Student> studentList = StudentDataBase.getAllStudents();
	new PredicateAndConsumer().printNameAndActivities(studentList);
}
}