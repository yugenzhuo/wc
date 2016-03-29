package zyc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomeWork {

	public static void main(String[] args) {
		try {
			InputStream is=new FileInputStream("E://大学学业//1.txt");
			InputStream is2=new FileInputStream("E://大学学业//1.txt");
			Reader wt=new InputStreamReader(is);
			Reader wt2=new InputStreamReader(is2);
			BufferedReader bt=new BufferedReader(wt);
			StringBuffer sb=new StringBuffer();
			int n=0,kh=0,zs=0,len=-1,shu=0;
			String m;
			char[] c=new char[10];
			while((m=bt.readLine())!=null){
				n++;
				if(m.length()==0){
					kh++;
				}
				if(m.matches("[^//]*//[^//]*") || m.matches("[^/\\*]*/\\*[^/\\*]*")){
					zs++;
				}
			}
			while((len=wt2.read(c))!=-1){
				sb.append(new String(c,0,len));
				shu=shu+len;
			}
			String s=sb.toString();
			String s1=s.replaceAll("\\p{Punct}", "");
			System.out.println("行数："+n);
			System.out.println("字符数："+(shu-2*n+2));
			System.out.println("符号数:"+(s.length()-s1.length()));
			System.out.println("空行数："+kh);
			System.out.println("注释行："+zs);
			wt2.close();
			wt.close();
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
}
