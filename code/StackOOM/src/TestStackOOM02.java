
public class TestStackOOM02 {
	// -Xss1024k
//n=-8670Exception in thread "main" java.lang.StackOverflowError

	// -Xss10240k
	// n=-92915
	// Exception in thread "main" java.lang.StackOverflowError
	public static void main(String[] args) {
		// 计算1+2+3+4+5的和
		int sum = add(5);
		System.out.println(sum);

	}

	public static int add(int n) {
//栈
		System.out.println("n=" + n);
		//不加8621 8699
		//加了变量，运行5777次
		//int n1=0,n2=0,n3=0,n4=0,n5=0,n6=0,n7=0,n8=0,n9=0,n10=0;
		//int n11=0,n12=0,n13=0,n14=0,n15=0,n16=0,n17=0,n18=0,n19=0,n20=0;
		return add(n - 1) + n;

	}

}
