import java.util.*;

public class Ques1 {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter number of integers in list: ");
		int n = scan.nextInt();
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			list.add(scan.nextInt());
		}
		
		Collections.sort(list);
		
		Iterator itr = list.iterator();
		
		System.out.print("Printing sorted list: ");
		while(itr.hasNext()) {
			System.out.print(itr.next()+" ");
		}
		
		return;
	}
}