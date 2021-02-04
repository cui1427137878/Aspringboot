
public class TestStackOOM01 {
	
	public static void main(String[] args) {
		// 计算1+2+3+4+5的和
		int sum = add(5);
		System.out.println(sum);
	}

	public static int add(int n) {
		if (n == 1) {
			return 1;
		} else {
			return add(n - 1) + n;
		}
	}

}
