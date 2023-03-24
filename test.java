import java.lang.*;
import java.io.*;
import java.util.*;
public class main{
	public static void test(String args[]){
               String s = "abcdefghijklmnopqrstuvwxyz";
               String word = "";
               boolean text = false;
             for(int i = 0; i < s.length(); i ++)
              {
               for(int c = 0; c < s.length(); c++)
               {
                if(text==true)
                {
                 break;
                }
		try{
                        word = s.substring(i,i+1)+s.substring(c,c+1);
			ProcessBuilder[] apple = {
				new ProcessBuilder(new String[]{"echo",word}),
				new ProcessBuilder(new String[]{"./script"})
			};
			List<Process> processes = ProcessBuilder.startPipeline(Arrays.asList(apple));
			BufferedReader read = new BufferedReader(new InputStreamReader(processes.get(processes.size()-1).getInputStream()));
			String hi ="";
			while((hi = read.readLine())!=null){
				if(hi.contains("login correct")
                                {
                                  System.out.println(word);
                                  text = true;
                                }
	                }
		}
		catch(Exception e){}
               }		
	     }
	}
}