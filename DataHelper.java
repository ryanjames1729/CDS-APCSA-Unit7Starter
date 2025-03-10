import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class DataHelper {
	private Entry[] data;

	public DataHelper(int size) {
		data = new Entry[size];
		int k = 0;
		try{
			FileReader fr = new FileReader("data.txt");
			BufferedReader br = new BufferedReader(fr);

			String line = br.readLine();
			while(line != null){
				double x = Double.parseDouble(line.substring(0, line.indexOf(",")));
				line = line.substring(line.indexOf(",")+1);
				double y = Double.parseDouble(line.substring(0, line.indexOf(",")));
				line = line.substring(line.indexOf(",")+1);
				double thickness = Double.parseDouble(line);

				data[k] = new Entry(k+1, x, y, thickness);
				k++;
				line = br.readLine();
			}

			br.close();
			fr.close();
		}catch(IOException e2){}
	}

	public Entry[] getData() {
		return data;
	}
}