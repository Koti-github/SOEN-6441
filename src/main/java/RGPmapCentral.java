import java.io.File;

public class RGPmapCentral {

	public File mapOption(int value) {
		File file = new File("/Users/Guest1/SOEN-6441/src/main/java/world.map");
		// TODO Auto-generated method stub
		int option = value;
		if (option == 1)
		{
			file = new File("/Users/Guest1/SOEN-6441/src/main/java/cmap.map");
		}
		if (option == 2)
		{
	         file = new File("/Users/Guest1/SOEN-6441/src/main/java/world.map");

		}
		if (option == 3)
		{
	         file = new File("/Users/Guest1/SOEN-6441/src/main/java/newworld.map");

		}
		
		return file;
	}
}
