package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileCategories {

    public List<String> getFiles(String c, String contextPath){
        List<String> file_list = new ArrayList<String>();
        
        try{
            File Filepath = new File(contextPath);
            String finfilename;
            if(Filepath.exists()){
                File path = new File(contextPath);
                File [] filename= path.listFiles();
                for (File folder_file : filename) {
                    if(folder_file.isDirectory ()){
                       for(final File file:folder_file.listFiles()){
                            if(!c.equals("All")){
                                if(file.getName().endsWith(c)){
                                    finfilename = file.getName().toString();
                                    file_list.add(finfilename);
                                }
                            }
                            else{
                                if(!file.getName().endsWith(".txt")){
                                    finfilename = file.getName().toString();
                                    file_list.add(finfilename);
                                }
                            }
                        }
                    }
                }
            }
        }catch(Exception e){
            System.out.print("No Entries");
            System.out.print(e.getMessage());
        }
        return file_list;
    }     

    private Object getServletContext() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
