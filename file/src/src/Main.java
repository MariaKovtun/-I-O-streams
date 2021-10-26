package src;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	static StringBuilder log = new StringBuilder();

    public static void main(String[] args) {
		createDir("D:\\Games\\savegames");

		createDir("D:\\Games\\src");

		createDir("D:\\Games\\src\\main");
		createDir("D:\\Games\\src\\test");

		createFile("D:\\Games\\src\\main\\Main.java");
		createFile("D:\\Games\\src\\main\\Utils.java");

		createDir("D:\\Games\\res");

		createDir("D:\\Games\\res\\drawables");
		createDir("D:\\Games\\res\\vectors");
		createDir("D:\\Games\\res\\icons");

		createDir("D:\\Games\\temp");
		createFile("D:\\Games\\temp\\temp.txt");

		getLog();
	}

    static void createDir(String pathname) {
		File newDir = new File(pathname);
		if (newDir.mkdir())  log.append("Каталог "+pathname+" создан\n");
		else log.append("Каталог"+pathname+" не создан\n");
	}

	static void createFile(String filepath){
		File file = new File(filepath);
		try {
			if (file.createNewFile())
				log.append("Файл "+filepath+" создан\n");
		} catch (IOException ex) {
			log.append(ex.getMessage());
		}
	}

	static void getLog() {
		String text = log.toString();
		try (FileWriter writer = new FileWriter("D:\\Games\\temp\\temp.txt", true)) {
			writer.write(text);
			writer.flush();
		}
		catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
