import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc=1; tc<=10; tc++) {
			LinkedList<Integer> lst = new LinkedList<>();
			
			int n = sc.nextInt(); // 암호문의 갯수 
			
			// 원본 암호문 뭉치 
			for (int i=0; i<n; i++) {
				lst.add(sc.nextInt());
			}
			
			int m = sc.nextInt(); // 명령어의 갯수 
			
			// 명령어 
			for (int i=0; i<m; i++) {
				char cmd = sc.next().charAt(0);
				
				if (cmd == 'I') {
					int x = sc.nextInt();
					int y = sc.nextInt();
					
					for (int j=0; j<y; j++) {
						lst.add(x++, sc.nextInt());
					}
				} else if (cmd == 'D') {
					int x = sc.nextInt();
					int y = sc.nextInt();
					
					for (int j=0; j<y; j++) {
						lst.remove(x);
					}
				} else {
					int y = sc.nextInt();
					for (int j=0; j<y; j++) {
						lst.add(sc.nextInt());
					}
				}
			}
			
			System.out.print("#" + tc + " ");
			for (int i=0; i<10; i++) {
				System.out.print(lst.get(i) + " ");
			}
            System.out.println();
		}

	}

}
