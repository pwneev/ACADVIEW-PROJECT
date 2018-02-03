/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PEV
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class FileListAp {

	public static void main(String[] args) 
	{
		System.out.println("\t WELCOME TO FILE LISTING APPLICATION ");
		
		FileAp(); // It is for reading and listing.        
	}
	
	
	public static void FileApp() throws IOException
	{
		File file = new File("?D:\\ACADVIEW JAVA LEC\\Project\\abc.txt");
	try {
		Scanner sc = new Scanner(file);
		String path1 = sc.nextLine();               // It Read the line 1 in file.
		
		 File newpath = new File(path1);            // Path is used to fetch from file.
		 
		 File files[] = newpath.listFiles();
                    try (FileWriter writer = new FileWriter("D:\\abc.csv")) {
                        int count = 0;
                        System.out.println();
                        System.out.println(" Files in the Root Folder: ");
                        for (File file1 : files) {
                            if (file1.isFile()) {
                                count++;
                                System.out.println("=> File "+count+" - " + file1.getName() + " | path : " + file1.getAbsolutePath());
                                writer.write(file1.getName() + " | path : " + file1.getAbsolutePath() + System.getProperty("line.separator"));
                            }
                        }
                    }
		 check(files , path1);
		 System.out.println("csv File created Successfully");
		 
	} 
	            catch (FileNotFoundException e) 
	            {		
				System.out.println("File not found!");
			    }
	}
	// Checks if it is a directory , then list all the inside files and folders with their name and absolute path
	// else list all the files in that root folder with their name and path
	
	public static void check(File files1[] , String path1)        //  This Root Folder file are already prints. 
	                                                              
	{
		int count = 0;
            for (File files11 : files1) {
                if (files11.isDirectory()) {
                    File[] files2 = files11.listFiles();
                    System.out.println();
                    System.out.println("Name of the folder - " + files11.getName() + " | Folder Path - " + files11.getAbsolutePath());
                    check(files2 , path1);                 // it runs until all the files.
                } else {
                    if (files11.isFile()) {
                        count++;                    // It is for count number of file of the folder.
                    }
                    if (!(files11.getParent()).equals(path1)) {
                        System.out.println("=> File " +count+ " in this folder - " + files11.getName() + " | Path - " + files11.getAbsolutePath());
                    }
                }
            }
	}

    private static void FileAp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of the generated method, choose Tools OR Templates.
    }
}