package com.sachin.pratice.programs.gfg.recursion;

/*
 * Cut the Rope in N parts 
 * Rope Length 5; a=2, b=5, c=1
 * ans: 5 - we can cut in 5 even pieces[1,1,1,1,1]
 * 
 *  Length of every piece(after cut) should be in set(a, b, c)
 *  
 *  
 *  Input: 23 and a=12, b=9, c=11
 *  ans: 2 ; cut in 2 pieces [12, 11]
 */
public class RopeCuttingProblem {

	public static void main(String[] args) {
		System.out.println("Max pieces "+ropeCutting(23, 11, 9, 12));
	}

	
	/*
	 *                 n=23             
	 *               /    \             \
	 *              /      \             \
	 *             /        \             \
	 *            n=12       n=14         n=11  -- {n-a, n-a, n-a}
	 *           /  |  \  
	 *          /   |   \
	 *         n=1  n=3  n=0   [n=3, n=5, n=2]    [0, 2, -1]  ---{n-b, n-b, n-b}
	 * 
	 *        [-ve]            [-ve, -ve, -ve]    [-ve, -ve, -ve] ---{n-c, n-c, n-c}
	 *        
	 *        
	 *        
	 * 
	 */
	private static int ropeCutting(int num, int a, int b, int c) {
		if (num < 0)
			return 0;
		if (num < 0)
			return -1;
		else {
			int res = Math.max(ropeCutting(num - a, a, b, c), Math.max(ropeCutting(num - b, a, b, c), ropeCutting(num-c, a, b, c)));
			if (res == -1)
				return -1;
			return res + 1;
		}
	
	}


	private static int max(int x, int y, int z) {
		// TODO Find the max of 3 numbers
		return Math.max(Math.max(x,y),z);
	}
}
