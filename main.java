import java.lang.*;
import java.io.*;
import java.util.*;
public class main{
	public static void main(String args[]){
		try{
			ProcessBuilder[] apple = {
				new ProcessBuilder(new String[]{"echo","a"}),
				new ProcessBuilder(new String[]{"./script"})
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
			// }
		}
		catch(Exception e){}
		
		
	}
}