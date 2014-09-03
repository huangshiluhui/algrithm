题目：实现函数double Power(double base,int exponent),求base的exponent次方。
不得使用库函数，同时不需要考虑大数据问题
方法一：使用最笨的方法：exponent次循环，代码如下所示：
package com.offer.chapter3;

public class IQ_11 {
	public static double pow(double base,int n){
		if(Math.abs(base - 0.0)<=0.0000001){
			try {
				throw new Exception("底数不能为0");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(Math.abs(base - 1.0)<=0.0000001){
			System.out.println("底数为1");
			return base;
		}
		if(n == 0 && Math.abs(base - 0.0)>0.0000001){
			System.out.println("指数为0");
			return 1;
		}
		
		double result = 1.0;
		for( int i =1; i <= n; i ++){
			result *= base;
		}
		return result;
	}
	public static void main(String[] args) {
		double result = pow(1.1,0);
		System.out.println("result:"+result);
	}
}

方法二：跟斐波那契数列一样，保存之前计算的结果，代码如下所示：
package com.offer.chapter3;

public class IQ11_1 {
	public static double pow(double base,int n){
		
		if(Math.abs(base - 0.0)<=0.0000001){
			try {
				throw new Exception("底数不能为0");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(Math.abs(base - 1.0)<=0.0000001){
			System.out.println("底数为1");
			return base;
		}
		if(n == 0 && Math.abs(base - 0.0)>0.0000001){
			System.out.println("指数为0");
			return 1.0;
		}
		double result = pow(base,n>>1);
		result *=result;
		if((n&0x01)==1){
			result*=base;
		}
		return result;
	}
	public static void main(String[] args) {
		double result = pow(1.1,3);
		System.out.println("result:"+result);
	}
}
