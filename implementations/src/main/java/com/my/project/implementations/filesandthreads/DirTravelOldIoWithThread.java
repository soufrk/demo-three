package com.my.project.implementations.filesandthreads;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Traversing all paths under a directory using I/O and thread for each directory.
 * Let's see if multi-threaded program really enhances I/O operation time. 
 * 
 * @author soufrk
 *
 */
public class DirTravelOldIoWithThread implements Runnable {

    private String path, outputFile;
    private static final String OUTPUT_FILE = "DirTravelOldIoWithThread.txt";
    // private static final String ROOT_PATH_TO_SCAN = "D:/";
    private static final String ROOT_PATH_TO_SCAN = "D:/Workspace";

    public DirTravelOldIoWithThread(String path, String outputFile) {
	super();
	this.path = path;
	this.outputFile = outputFile;
    }

    public static void main(String[] args) {
	try {
	    PrintWriter p = new PrintWriter(OUTPUT_FILE);
	    p.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	new Thread(new DirTravelOldIoWithThread(ROOT_PATH_TO_SCAN, OUTPUT_FILE)).start();
    }

    @Override
    public void run() {
	File rootPath = new File(path);
	File[] contents = rootPath.listFiles();
	for (File singleFile : contents) {
	    if (singleFile.isDirectory()) {
		new Thread(new DirTravelOldIoWithThread(singleFile.getAbsolutePath(), outputFile)).start();
	    } else {
		try {
		    FileWriter writer = new FileWriter(outputFile, true);
		    writer.write(System.currentTimeMillis() + "-" + singleFile.getAbsolutePath() + "\n");
		    writer.close();
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	}
    }

}
