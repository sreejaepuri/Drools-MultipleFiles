package com.ns.DroolsMultipleFiles.Controller;

import com.ns.DroolsMultipleFiles.Models.Product;
import org.drools.compiler.compiler.DroolsParserException;
import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.WorkingMemory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.*;
import java.io.*;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api")
public class Controller {

    @GetMapping("/files")
    public void MultipleFiles() throws IOException, DroolsParserException {

//        PackageBuilder packageBuilder = new PackageBuilder();
//
//        String ruleFile = "E:\\Drools Demo\\Rules.drl";
//        InputStream resourceAsStream = new FileInputStream(ruleFile);
//
//        Reader reader = new InputStreamReader(resourceAsStream);
//        packageBuilder.addPackageFromDrl(reader);
//        org.drools.core.rule.Package rulesPackage = packageBuilder.getPackage();
//        RuleBase ruleBase = RuleBaseFactory.newRuleBase();
//        ruleBase.addPackage(rulesPackage);
//
//        WorkingMemory workingMemory = ruleBase.newStatefulSession();
//
//        Product product = new Product();
//        product.setType("gold");
//
//        workingMemory.insert(product);
//        workingMemory.fireAllRules();
//
//        System.out.println("The discount for the product " + product.getType()
//                + " is " + product.getDiscount());



         File folder =new File("E:\\Drools Demo\\drools Folder");
         Controller listFiles = new Controller();
         listFiles.listAllFiles(folder);


//
//
        String[] files = folder.list(new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {
                if((name.toLowerCase().endsWith(".drl"))||name.toLowerCase().endsWith(".csv")){
//                    Controller listFiles = new Controller();
//                    listFiles.listAllFiles(folder); // reads all file content from Folder
                    return true;
                } else {
                    return false;
                }
            }
        });
        for(String f:files){
            System.out.println(f);

        }


    }

                public void listAllFiles(String path){
                    System.out.println("In listAllfiles(String path) method");
                    try(Stream<Path> paths = Files.walk(Paths.get(path))) {
                        paths.forEach(filePath -> {
                            if (Files.isRegularFile(filePath)) {
                                try {
                                    readContent(filePath);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


            private void listAllFiles(File folder) {

                System.out.println("In listAllfiles(File) method");
                File[] fileNames = folder.listFiles();
                for (File file : fileNames) {
                    // if directory call the same method again
                    if (file.isDirectory()) {
                        listAllFiles(file);
                    } else {
                        try {
                            readContent(file);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }

             public void readContent(File file) throws IOException{
                System.out.println("read file " + file.getCanonicalPath() );
                try(BufferedReader br  = new BufferedReader(new FileReader(file))){
                    String strLine;
                    // Read lines from the file, returns null when end of stream
                    // is reached
                    while((strLine = br.readLine()) != null){
                        System.out.println("Line is --> " + strLine);
                    }
                }
            }

             public void readContent(Path filePath) throws IOException{
            System.out.println("read file " + filePath);
            List<String> fileList = Files.readAllLines(filePath);
            System.out.println("" + fileList);
        }

            @GetMapping("/folder")
            public String GettingFolder()
            {
                return "Success";
            }
}
