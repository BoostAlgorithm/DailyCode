import java.util.Scanner;

public class TreeTraversal_1991 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int lines = Integer.parseInt(sc.nextLine());
		BinaryNode[] bn = new BinaryNode[lines];
		for( int i=0; i<lines ; i++)
			bn[i]= new BinaryNode((char)(i+'A'));
		
		for(int i=0; i<lines; i++){
			char[] temp=sc.nextLine().toCharArray();
			char parent = temp[0],left=temp[2], right=temp[4];
			if(left!= '.')
				bn[parent-'A'].left = bn[left-'A'];
			if(right!= '.')
				bn[parent-'A'].right = bn[right-'A'];
			/*System.out.println("left "+(left-'A'));
			System.out.println("right "+(right-'A'));*/
			
		}
		System.out.println(preOrder(bn[0],new StringBuffer()).toString());
		System.out.println(inOrder(bn[0],new StringBuffer()).toString());
		System.out.println(postOrder(bn[0],new StringBuffer()).toString());
	}
	private static StringBuffer postOrder(BinaryNode binaryNode,StringBuffer bf) {
		if(binaryNode == null) return bf;
		
		bf =postOrder(binaryNode.left,bf);
		bf = postOrder(binaryNode.right,bf);
		bf.append(binaryNode.data);
		
		return bf;
	}
	private static StringBuffer inOrder(BinaryNode binaryNode,StringBuffer bf) {
		if(binaryNode == null) return bf;
		
		bf =inOrder(binaryNode.left, bf);
		bf.append(binaryNode.data);
		bf = inOrder(binaryNode.right, bf);
		
		return bf;
	}
	private static StringBuffer preOrder(BinaryNode binaryNode,StringBuffer bf) {
		if(binaryNode == null) return bf;

		bf.append(binaryNode.data);
		bf =preOrder(binaryNode.left, bf);
		bf = preOrder(binaryNode.right,bf);
		/* 실수 주의 		if(binaryNode == null) return bf;
		bf =preOrder(binaryNode.left, bf.append(binaryNode.left.data)); 가 아님! */
		return bf;
	}
	static class BinaryNode{
		char data;
		BinaryNode left;
		BinaryNode right;
		
		public BinaryNode(char d) {
			this.data = d;
		}
	}
}
