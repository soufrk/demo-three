package com.my.project.implementations.filesandthreads;

import java.io.File;
import java.io.PrintWriter;

/**
 * Traversing all paths under a directory using old school I/O.
 * 
 * @author soufrk
 *
 */
public class DirTravelOldIo {

    private static final String OUTPUT_FILE = "DirTravelOldIo.txt";
    //private static final String ROOT_PATH_TO_SCAN = "D:/";
    private static final String ROOT_PATH_TO_SCAN = "D:/Workspace";
    private static PrintWriter WRITER = null;

    public static void main(String args[]) {
	try {
	    WRITER = new PrintWriter(OUTPUT_FILE);
	    printFilesInDir(ROOT_PATH_TO_SCAN);
	    WRITER.close();
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	}
    }
    
    private static void printFilesInDir(String path){
	File rootPath = new File(path);
	//System.out.println("Path:" + rootPath.getAbsolutePath());
	File[] contents = rootPath.listFiles();
	for(File singleFile:contents){
	    if(singleFile.isDirectory()){
		//System.out.println(singleFile + " is Dir.");
		printFilesInDir(singleFile.getAbsolutePath());
	    }
	    else{
		//System.out.println(singleFile + " is File.");
		WRITER.println(System.currentTimeMillis() + "-" + singleFile.getAbsolutePath());
	    }
	}
    }
}
