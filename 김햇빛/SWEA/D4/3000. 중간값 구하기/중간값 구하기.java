import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int i=1; i<=T; i++) {
			int n = sc.nextInt();
			int a = sc.nextInt();
			PriorityQueue<Integer> minHeap = new PriorityQueue(Collections.reverseOrder());
			PriorityQueue<Integer> maxHeap = new PriorityQueue();
			
			PriorityQueue<Integer> temp = new PriorityQueue();
			
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			temp.add(a);
			temp.add(x);
			temp.add(y);
			
			// a를 중앙값 저장용으로 쓰자
			minHeap.add(temp.poll());
			a = temp.poll();
			maxHeap.add(temp.poll());
			
			int ans = a;
			
			for (int j=1; j<n; j++) {
				x = sc.nextInt();
				y = sc.nextInt();
				
				temp.add(a);
				temp.add(x);
				temp.add(y);
				temp.add(minHeap.poll());
				temp.add(maxHeap.poll());
				
				// 중앙값보다 크면 maxHeap
				// 중앙값보다 작으면 minHeap
				minHeap.add(temp.poll());
				minHeap.add(temp.poll());
				a = temp.poll();
				maxHeap.add(temp.poll());
				maxHeap.add(temp.poll());
//				System.out.println(a);

				ans += a;
				ans %= 20171109;
			}
			System.out.println("#" + i + " " + ans);
        }
	}
}