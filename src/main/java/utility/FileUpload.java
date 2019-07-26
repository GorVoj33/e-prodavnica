/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;


/**
 *
 * @author Asus
 */
public class FileUpload {
    private static final String ABS_PATH = 
            "C:\\Users\\Asus\\Documents\\NetBeansProjects\\NJTshop\\NJTshop\\src\\main\\webapp\\WEB-INF\\resources\\img\\";
    private static String REAL_PATH = "";
    
    public static void uploadImage(HttpServletRequest request, MultipartFile image, int artikalId) {
        REAL_PATH = request.getSession().getServletContext().getRealPath("/resources/img/");
        System.out.println("REAL PATH: "+REAL_PATH);
        if(!new File(ABS_PATH).exists()){
            new File(ABS_PATH).mkdirs();
        }
        
        if(!new File(REAL_PATH).exists()){
            new File(REAL_PATH).mkdirs();
        }
        
        try {
            // upload u direktorijum
            image.transferTo(new File(ABS_PATH+artikalId+".png"));
            // upload na server
            image.transferTo(new File(REAL_PATH+artikalId+".png"));
            System.out.println("Uspesan upload slike");
        } catch (Exception e) {
            System.out.println("Greska prilikom uploadovanja slike artikla!");
        }
    }
    
    public static void deleteImage(HttpServletRequest request, MultipartFile image, int artikalId){
        String root = request.getSession().getServletContext().getRealPath("/");
        Path path = Paths.get(root +"WEB-INF/resources/img/"+artikalId+".png");

        if (Files.exists(path)) {
            try {
                Files.delete(path);
                
            } catch (IOException e) {
                e.printStackTrace();
                
            }
        }
       
    }

    
}
