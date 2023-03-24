import java.lang.*;
import java.io.*;
import java.util.*;
public class pleez{
	public static void main(String args[]){
                String s = "abcdefghijklmnopqrstuvwxyz";
                String guess = "";
                boolean tester = false;
               for(int i = 0;  i < s.length(); i ++)
               {
                for(int c = 0;  c < s.length(); c ++)
                {
                 if(tester==true)
                 {
                  break;
                 }
		try{
                        guess = s.substring(i,i+1)+s.substring(c,c+1);
			ProcessBuilder[] apple = {
				new ProcessBuilder(new String[]{"cmd","/c","echo",guess}),
				new ProcessBuilder(new String[]{"cmd","/c","java","pass"})
			};
			//like ProcessBuilder.start(), but instead takes an array of processbuilders and runs them back-to-back, using the output of one ProcessBuilder as input for the next one
			List<Process> processes = ProcessBuilder.startPipeline(Arrays.asList(apple));
			//only the output of the last command matters, so I just read that
			BufferedReader read = new BufferedReader(new InputStreamReader(processes.get(processes.size()-1).getInputStream()));
			String hi ="";
			while((hi = read.readLine())!=null){
				System.out.println(hi);
			}
			// ProcessBuilder apple = new ProcessBuilder(new String[]{"cmd","/c","echo","a"});
			// BufferedReader read = new BufferedReader(new InputStreamReader(apple.start().getInputStream()));
			// String hi = "";
			// while((hi = read.readLine())!=null){
				// System.out.println(hi);
                                if(hi.contains("login correct"))
                                {
                                 System.out.println("Password is " + guess);
                                 tester = true;
                                }
			// }
		}
		catch(Exception e){}
	       }
              } 		
	}
}