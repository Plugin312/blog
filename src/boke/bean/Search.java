package boke.bean;

public class Search {
	public static Boolean search_title(String str1,String str2){
		String s1,s2;
		int k=0;
		s1 = UpToDown(str1);
		s2 = UpToDown(str2);
		if(s1.contains(s2)){
			return true;
		}
		char[] arr = s2.toCharArray();
		for(int i=0;i<s2.length();i++){
			if(s1.contains(arr[i]+"")){
				k++;
			}
		}
		if(k==s2.length()) return true;
		return false;
	}
	
	//大写字母转小写字母
	public static String UpToDown(String str1){
		String s1="";
		char[] arr = str1.toCharArray();
		for(int i=0;i<arr.length;i++){
			if(arr[i]>='A'&&arr[i]<='Z'){
				arr[i] = (char) (arr[i] + 32);
			}
			s1 += arr[i];
		}
		return s1;
	}
	
	
	public static void main(String[] args) {
		String s1 = "sdhjGHJ都快死了hkjbnk";
		String s2="sjk都";
		int k = 0;
		char[] arr = s2.toCharArray();
		for(int i=0;i<s2.length();i++){
			if(s1.contains(arr[i]+"")){
				k++;
			}
		}
		if(k==s2.length())
		System.out.println(s1);
	}
}
