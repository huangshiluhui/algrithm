题目：在字符串中找出第一个只出现一次的字符，如输入“abaccdeff”，则输出b

代码如下所示：
package com.offer.chapter5;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;



public class IQ_35 {
	public char findOneFromStr(String str){
		char c = '0';
		LinkedHashMap<Character,Integer> map = new LinkedHashMap<Character,Integer>();
		char[] ss = str.toCharArray();
		int len = ss.length;
		System.out.println("len:"+len);
		for(int i = 0; i < len; i ++){
			if(!map.containsKey(ss[i])){
				map.put(ss[i], 1);
			}
			else{
				int count =map.get(ss[i]);
				map.put(ss[i], count+1);
			}
		}
		System.out.println(map.toString());
		Iterator it = map.keySet().iterator();
		while(it.hasNext()){
			Object key = it.next();
//			int val = map.get(key);
//			System.out.println(key+":"+val);
			int count = map.get(key);
			if (count == 1){
				c = (Character)key;
				break;
			}
		}
		return c;
	}
	public static void main(String[] args) {
		String str = "abaccdeff";
		IQ_35 test = new IQ_35();
		char c = test.findOneFromStr(str);
		System.out.println("第一次出现的字符："+c);
	}
}
