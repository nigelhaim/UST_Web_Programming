package model;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
/*
*   This is the model for the Categories 
*   If there is a request then this will run
*   as a function to scan the entires folder and to return 
*   filenames with the given file extension or all files 
*/
public class FileCategories {

    public List<String> getFiles(String c, String contextPath)
    {
        List<String> fileList = new ArrayList<String>();
        
        try
        {
            File filePath = new File(contextPath);//Gets the path of the entries folder 
            String finalFilename;
            if(filePath.exists())//If entries exists then it will start the scanning of files 
            {
                File path = new File(contextPath);
                File [] filename= path.listFiles();
                for (File fileFolder : filename) 
                {
                    if(fileFolder.isDirectory ())//If an entry is within a folder then it will scan the folder for the specific file
                    {
                       for(final File file: fileFolder.listFiles())
                       {
                            if(!c.equals("All"))//If the request is not all files then it will scan every file extension and add the filename to the list that is compared to the requested file extension
                            {
                                if(file.getName().endsWith(c))
                                {
                                    finalFilename = file.getName().toString();
                                    fileList.add(finalFilename);
                                }
                            }
                            else//else the request is all files then all of the files will be returned 
                            {
                                if(!file.getName().endsWith(".txt"))
                                {
                                    finalFilename = file.getName().toString();
                                    fileList.add(finalFilename);
                                }
                            }
                        }
                    }
                }
            }
        }
        catch(Exception e)
        {
            System.out.print("No Entries");
            System.out.print(e.getMessage());
        }
        
        return fileList;
    }     

    private Object getServletContext() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
