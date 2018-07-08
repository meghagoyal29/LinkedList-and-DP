package LeetCode.dp;

public class Stairs {
	public static void main(String[] args) {
		System.out.println(climbStairs(2,new int[3]));
	}
	public static int climbStairs(int n, int[]ways) {
		if(n<=1)
			return 1;
		if(ways[n]==0) {
			ways[n]=climbStairs(n-1,ways)+climbStairs(n-2, ways);
		}
		return ways[n];
	}
}
