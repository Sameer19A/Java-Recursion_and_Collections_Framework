import java.util.*;

public class CompulsoryTask2 {
	public static void main(String[] args) {
		// Create two priority queues
		PriorityQueue<String> queue1 = new PriorityQueue<>(Arrays.asList(
			"George", "Jim", "John", "Blake", "Kevin", "Michael"));

		PriorityQueue<String> queue2 = new PriorityQueue<>(Arrays.asList(
			"George", "Katie", "Kevin", "Michelle", "Ryan"));

		// Display the two sets and union, difference, and intersection
		System.out.println("Queue1: " + queue1);
		System.out.println("Queue2: " + queue2);
		System.out.println("Union: of sets: " + union(queue1, queue2));
		System.out.println("Difference of sets: " + difference(queue1, queue2));
		System.out.println("Intersection of sets: " + intersection(queue1, queue2));
	
	}//end of method main

	/** Method returns the union of two sets */
	public static <String> PriorityQueue<String> union(PriorityQueue<String> set1, PriorityQueue<String> set2) {
		PriorityQueue<String> union = new PriorityQueue<>(set1);
		union.addAll(set2); 
		return union;
	} //end of method union

	/** Method returns the difference of two sets */
	public static <String> PriorityQueue<String> difference(PriorityQueue<String> set1, PriorityQueue<String> set2) {
		PriorityQueue<String> difference = new PriorityQueue<>(set1);
		difference.removeAll(set2);
		return difference;
	}//end of method difference	

	/** Method returns the intersection of two sets */
	public static <String> PriorityQueue<String> intersection(PriorityQueue<String> set1, PriorityQueue<String> set2) {
		PriorityQueue<String> intersection = new PriorityQueue<>(set1);
		intersection.retainAll(set2);
		return intersection;
	}//end of method intersection	
	
	
}//end of class CompulsoryTask2

