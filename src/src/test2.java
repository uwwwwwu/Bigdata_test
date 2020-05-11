package src;


//import com.sun.org.apache.bcel.internal.generic.NEW;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class test2 {
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATER = "\n";

	public static void main(String args[]) throws IOException {

		// TODO: TO CREATE BufferedWriter FOR WRITTING TO NEW CSV FILE

		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("test_data4.csv")));


		
		
		for (int year = 2010; year <= 2011; year++) { //약 8200년치
			FileReader fr = new FileReader("D:/workspace/java/Bigdata_test/merge1.csv");
			BufferedReader br_f = new BufferedReader(fr);
			String line = "";
			
			System.out.println(year);

			for (int month = 1; month <= 12; month++) {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(new Date(year + "/" + month + "/00"));
			
				for (int day = 0; day < calendar.getActualMaximum(Calendar.DAY_OF_MONTH); day++) {
					calendar.add(Calendar.DATE, 1);
						
					for(int hour = 0; hour <= 24; hour++){
						calendar.add(Calendar.HOUR, 1);
							
						for(int minute = 0; minute <=60; minute++){
							for(int i = 1;(line =br_f.readLine())!= null ; i++){
								calendar.add(Calendar.MINUTE, 1);
								String date = sdf.format(calendar.getTime());
								bufferedWriter.append(date);
								bufferedWriter.append(COMMA_DELIMITER);
								bufferedWriter.append(line);
								bufferedWriter.append(NEW_LINE_SEPARATER);	
							}
						}
	
					}
					
				}
				System.out.println(month);
			}
			
		}
		// TODO: TO SAVE
		bufferedWriter.flush();
		bufferedWriter.close();
		System.out.println("끝");
		
	}
}
