package com.sachin.pratice.program.codility;

/**
 * A binary gap within a positive integer N is any maximal sequence of
 * consecutive zeros that is surrounded by ones at both ends in the binary
 * representation of N.
 * 
 * For example, number 9 has binary representation 1001 and contains a binary
 * gap of length 2. The number 529 has binary representation 1000010001 and
 * contains two binary gaps: one of length 4 and one of length 3. The number 20
 * has binary representation 10100 and contains one binary gap of length 1. The
 * number 15 has binary representation 1111 and has no binary gaps. The number
 * 32 has binary representation 100000 and has no binary gaps.
 * 
 * @author Sachin
 *
 */
public class BInaryGap {
	public static void main(String[] args) {
		BInaryGap bg = new BInaryGap();
		bg.binaryGap(1073741825);
	}
	
	private int binaryGap(int n) {
		String binary = calcBinary(n);
		
		int count=0;
		int gap=0;
		for(char ch: binary.toCharArray()) {
			if(ch == '0')
				count++;
			if(ch == '1') {
				if(count > gap)
					gap = count;
				count=0;
			}
		}
		System.out.println("\n highest gap: "+gap);
		return gap;
		
	}
	
	private String calcBinary(int n) {
		StringBuffer sb = new StringBuffer();
		while(n > 0) {
			int res = n%2;
			sb.append(res);
			n = n/2;
			//System.out.println("n: "+n+" s: "+sb.toString());
		}
		//System.out.printf("Binary of %d in %s", n, sb.reverse().toString());
		//return Integer.parseInt(sb.toString());
		return sb.reverse().toString();
	}
}
