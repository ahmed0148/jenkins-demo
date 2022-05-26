package com.penetration.testing;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.InetAddress;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class Tests {


public static void main(String[] args) throws IOException, InterruptedException {

//niktoScan();
//    HttpURLConnection connection = null;
//    try {
//        URL u = new URL("http://www.google.com/");
//        connection = (HttpURLConnection) u.openConnection();
//        connection.setRequestMethod("HEAD");
//        int code = connection.getResponseCode();
//        System.out.println("" + code);
//         You can determine on HTTP return code received. 200 is success.
//    } catch (MalformedURLException e) {
//         TODO Auto-generated catch block
//        e.printStackTrace();
//    } catch (IOException e) {
//         TODO Auto-generated catch block
//        e.printStackTrace();
//    } finally {
//        if (connection != null) {
//            connection.disconnect();
//        }
//    }
//    System.out.println(/
//    InetAddress.getByName("local-tt.dev-machinestalk.com").isReachable(10));
//    String top = top();
//    String end = end();
//    String body=dosReport();
//    String path="index.html";
//    PrintWriter writer = new PrintWriter(path, "UTF-8");
//    writer.println(top+body+end);
//    writer.flush();
//    writer.close();
//    System.out.println(Dos("local-tt.dev-machinestalk.com").toString(2));


}
public static String dosReport() throws IOException, InterruptedException {
JSONObject dosReportObj=Dos("local-tt.dev-machinestalk.com");
String top="            <div class=\"report\" >\n" +
        "\n" +
        "                <div class=\"reportName\">\n" +
        "                    Dos attack\n" +
        "                </div>\n" +
        "                <div class=\"subReportName\">\n" +
        "                    Dos attack report\n" +
        "                </div>\n" +
        "                <div class=\"attackDetails\">\n" +
        "                    <span class=\"details\">Attack details:</span>\n" +
        "                    <span>- <span class=\"big\">Used tool</span> : hping3</span>\n" +
        "                    <span>- <span class=\"big\">Packets number</span> : 10000 </span>\n" +
        "                    <span>- <span class=\"big\">number of seconds between sending each packet</span> : 10 packets peer\n" +
        "                        second</span>\n" +
        "                    <span>- <span class=\"big\">packet body size </span> : 120 bytes</span>\n" +
        "                    <span>- <span class=\"big\">Target hostname</span> : local-tt.dev-machinestalk.com</span>\n" +
        "                </div>\n" +
        "\n" +
        "                <span  class=\"details\">Result:</span>";
String body="";
if (dosReportObj.get("result").toString().contains("true")){
    body+="                <div class=\"failAlert myAlert\" >\n" +
            "                    Dos attack succeeded\n" +
            "                </div>";
}
if (dosReportObj.get("result").toString().contains("false")){
        body+="                <div class=\"successAlert myAlert\">\n" +
                "                    Dos attack failed\n" +
                "                </div>";
    }
String end="\n" +
    "            </div>\n" +
    "            <div id=\"SQLInjection\" class=\"hide\">.</div>";
    return top+body+end;
}

public static String zapScanReport() throws IOException, InterruptedException {
JSONObject zapScanReportObj=zapScan();
JSONObject OWASPZAPReport=(JSONObject) zapScanReportObj.get("OWASPZAPReport");
JSONObject site=(JSONObject) OWASPZAPReport.get("site");
JSONObject alerts=(JSONObject) site.get("alerts");
JSONArray jArray=alerts.getJSONArray("alertitem");
int high=0;
int medium=0;
int low=0;
int info=0;
for (Object obj:
        jArray) {
    JSONObject alert=(JSONObject) obj;
    System.out.println(alert.get("confidencedesc").toString());
    if (alert.get("confidencedesc").toString().startsWith("Low"))
        low++;
    if (alert.get("confidencedesc").toString().startsWith("High"))
        high++;
    if (alert.get("confidencedesc").toString().startsWith("Medium"))
        medium++;
    if (alert.get("confidencedesc").toString().startsWith("Information"))
        info++;
}
System.out.println("medium"+medium);
System.out.println("low"+low);
System.out.println("high"+high);
System.out.println("info"+info);
String top="            <div class=\"report\" >\n" +
    "                <div class=\"reportName\">\n" +
    "                    Owasp Zap scan\n" +
    "                </div>\n" +
    "                <div class=\"subReportName\">\n" +
    "                    Owasp Zap scan report\n" +
    "                </div>\n" +
    "                <div class=\"attackDetails\">\n" +
    "                    <span class=\"details\">Attack details:</span>\n" +
    "                    <span>- <span class=\"big\">Used tool </span> : hydra</span>\n" +
    "                    <span>- <span class=\"big\">Target hostname </span> : local-tt.dev-machinestalk.com </span>\n" +
    "                    <span>- <span class=\"big\">Target IP </span> : 10.0.0.127</span>\n" +
    "                    <span>- <span class=\"big\">Target Port </span> : 80 </span>\n" +
    "                </div>\n" +
    "                <span class=\"details\" >Summary of alerts:</span>\n" +
    "                <table class=\"zapTable\">\n" +
    "                    <tr class=\"zapTr headTr\">\n" +
    "                        <th class=\"zapTh\">Risk Level</th>\n" +
    "                        <th class=\"zapTh\">Number of alerts</th>\n" +
    "                    </tr>\n" +
    "                    <tr class=\"zapTr\">\n" +
    "                        <td class=\"zapTd\">High</td>\n" +
    "                        <td class=\"zapTd\">"+high+"</td>\n" +
    "                    </tr>\n" +
    "                    <tr class=\"zapTr\">\n" +
    "                        <td class=\"zapTd\">Medium</td>\n" +
    "                        <td class=\"zapTd\">"+medium+"</td>\n" +
    "                    </tr>\n" +
    "                    <tr class=\"zapTr\">\n" +
    "                        <td class=\"zapTd\">Low</td>\n" +
    "                        <td class=\"zapTd\">"+low+"</td>\n" +
    "                    </tr>\n" +
    "                    <tr class=\"zapTr\">\n" +
    "                        <td class=\"zapTd\">Information</td>\n" +
    "                        <td class=\"zapTd\">"+info+"</td>\n" +
    "                    </tr>\n" +
    "\n" +
    "                </table>";

String body="                <span class=\"details\">Alert details:</span>\n" +
    "                <table class=\"alertTable\">";

String Low="";
String High="";
String Medium="";
String Info="";
for (Object obj:
        jArray) {
    String content="";
    JSONObject alert = (JSONObject) obj;
    JSONObject instance = (JSONObject) alert.get("instances");
    JSONArray arr = (JSONArray) instance.getJSONArray("instance");
    JSONObject inst = (JSONObject) arr.get(0);
    content+="                    <th class=\"alertHead "+alert.get("confidencedesc").toString()+"\">\n" +
    "                        <div class=\"alertLevel\">\n" +
    alert.get("confidencedesc")+
    "                        </div>\n" +
    "                        <div class=\"alertName\">\n" +
    alert.get("name")+
    "                        </div>\n" +
    "\n" +
    "                    </th>";
    content+="                    <tbody>\n" +
    "                        <tr class=\"alertTr\">\n" +
    "                            <td class=\"alertTd\">\n" +
    "                                <div class=\"alertFiled big\">Description</div>\n" +
    "                                <div class=\"value\">"+ alert.get("desc")+"</div>\n" +
    "                            </td>\n" +
    "                            <td class=\"alertTd\">\n" +
    "                                <div class=\"alertFiled big\">URL</div>\n" +
    "                                <div class=\"alertValue\"> "+inst.get("uri")+"</div>\n" +
    "                            </td>\n" +
    "                            <td class=\"alertTd\">\n" +
    "                                <div class=\"alertFiled big\">Method</div>\n" +
    "                                <div class=\"alertValue\"> "+inst.get("method")+"</div>\n" +
    "                            </td>\n" +
    "                            <td class=\"alertTd\">\n" +
    "                                <div class=\"alertFiled big\">Reference</div>\n" +
    "                                <div class=\"alertValue\"> "+alert.get("reference")+"</div>\n" +
    "                            </td>\n" +
    "                            <td class=\"alertTd\">\n" +
    "                                <div class=\"alertFiled big\">Quick Solution</div>\n" +
    "                                <div class=\"alertValue\"> "+alert.get("solution")+"</div>\n" +
    "                            </td>\n" +

    "                        </tr>\n" +
    "                    </tbody>";
    if (alert.get("confidencedesc").toString().startsWith("Low"))
        Low+=content;
    if (alert.get("confidencedesc").toString().startsWith("High"))
        High+=content;
    if (alert.get("confidencedesc").toString().startsWith("Medium"))
        Medium+=content;
    if (alert.get("confidencedesc").toString().startsWith("Information"))
        Info+=content;


}
body+=High+Medium+Low+Info;
body+="                </table>\n";
String end="            </div>";
return top+body;
}

public static String niktoReport() throws IOException, InterruptedException {
JSONObject niktoReport=niktoScan();
String elapsedTime= (String) niktoReport.get("Elapsed Time");
String top="  <div id=\"niktoScan\" class=\"hide\">.</div>\n" +
        "\n" +
        "            <div class=\"report\" >\n" +
        "                <div class=\"reportName\">\n" +
        "                    Nikto scan\n" +
        "                </div>\n" +
        "                \n" +
        "                <div class=\"subReportName\">\n" +
        "                    Nikto scan report\n" +
        "                </div>\n" +
        "                <div class=\"attackDetails\">\n" +
        "                    <span class=\"details\">Attack details:</span>\n" +
        "                    <span>- <span class=\"big\">Used tool </span> : Nikto</span>\n" +
        "                    <span>- <span class=\"big\">Target hostname </span> : local-tt.dev-machinestalk.com </span>\n" +
        "                    <span>- <span class=\"big\">Target IP </span> : 10.0.0.127</span>\n" +
        "                    <span>- <span class=\"big\">Target Port </span> : 80 </span>\n" +
        "                    <span>- <span class=\"big\">Elapsed Time </span> : "+elapsedTime+" seconds</span>\n" +
        "                </div>\n" +
        "                <span class=\"details\">Vulnerabilities list :</span>\n" +
        "                <table class=\"niktoTabale\">";
String body="";
JSONArray arr=niktoReport.getJSONArray("vunerabilities");
for (Object el:arr
     ) {
    JSONObject on=(JSONObject) el;
    body+="                    <tr>\n" +
            "                        <td>\n" +
            "                            <div class=\"filed big\">HTTP Method</div>\n" +
            "                            <div class=\"value\"> GET</div>\n" +
            "                        </td>\n" +
            "                        <td>\n" +
            "                            <div class=\"filed big\">Description</div>\n" +
            "                            <div class=\"value\"> "+on.get("Description")+"</div>\n" +
            "                        </td>\n" +
            "                        <td>\n" +
            "                            <div class=\"filed big\">Test Links</div>\n" +
            "                            <div class=\"value\"> "+on.get("Test link")+"</div>\n" +
            "                        </td>\n" +
            "                        <td>\n" +
            "                            <div class=\"filed big\">OSVDB Entries</div>\n" +
            "                            <div class=\"value\">"+on.get("Vulnerability name")+"</div>\n" +
            "                        </td>\n" +
            "                    </tr>";

}
String end="\n" +
        "                </table>\n" +
        "            </div>";
return top+body+end;
}
public static String SQLScanReport() throws IOException, InterruptedException {
JSONObject SQLReport=SQLMapScan("local-iam.dev-machinestalk.com/auth/","username=hello&password=hello%3A%29",1);
String top ="\n" +
"            <div class=\"report\" >\n" +
"\n" +
"                <div class=\"reportName\">\n" +
"                    SQL Injection attack\n" +
"                </div>\n" +
"                <div class=\"subReportName\">\n" +
"                    SQL Injection attack report\n" +
"                </div>\n" +
"                <div class=\"attackDetails\">\n" +
"                    <span class=\"details\">Attack details:</span>\n" +
"                    <span>- <span class=\"big\">Used tool</span> : sqlmap</span>\n" +
"                    <span>- <span class=\"big\">Target hostname</span> : local-tt.dev-machinestalk.com/auth </span>\n" +
"\n" +
"                </div>\n" +
"                <span class=\"details\">Information:</span>\n";
String body="";
JSONArray infoArray=SQLReport.getJSONArray("info");
for (Object el:infoArray
     ) {
    String info=(String) el;
    body+="                <div class=\"infoAlert myAlert\">\n" +
             info+
            "                </div>";

}
body+="                <span class=\"details\">result:</span>\n";
JSONArray resultArray=SQLReport.getJSONArray("critical");
for (Object el:resultArray
) {
    String rst=(String) el;
    body+="                <div class=\"successAlert myAlert\">\n" + rst+"                </div>";

}
String endd="                <br>\n" +
        "      \n" +
        "            </div>";
return top+body+endd;
}
public  static String bruteForceReport() throws IOException, InterruptedException {
JSONObject hydraReportSSH = hydraScanSSH();
JSONObject hydraReportLogin = hydraScanLogin();
String numberOfTriesSSH=""+hydraReportSSH.get("Number of tries");
String numberOfTriesLogin=""+hydraReportLogin.get("Number of tries");
String loginResult="";
String SSHResults="";

if (hydraReportLogin.get("success").toString().equals("false")){
loginResult="                <div class=\"successAlert myAlert\">\n" +
    "                    0 valide credantials\n" +
    "                </div>";
}
else {
loginResult="                <div class=\"failAlert myAlert\">\n" +
    "                    <span class=\"cred\"> Credantials: </span>\n" ;

JSONArray arr= (JSONArray) hydraReportLogin.get("results");
for (int i = 0; i < arr.length(); i++) {
JSONObject o= (JSONObject) arr.get(i);
loginResult+= "                    <span class=\"cred\"><span class=\"big\"> - Username : </span>"+o.get("username")+" <span class=\"big\"> Password :"+o.get("username")+" </span>\n";



}
loginResult+="  </div>\n";

}

if (hydraReportSSH.get("success").toString().equals("false")){
SSHResults="<div class=\"successAlert myAlert\">\n" +
    "                    0 valide credantials\n" +
    "                </div>";
}
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
"                    <span>- <span class=\"big\"> Login Usernames list </span> :<a href=\"Login_Usernames.txt\">Login\n" +
"                            usernames</a></span>\n" +
"                    <span>- <span class=\"big\">Login Passwords list </span> :<a href=\"Login_Passwords.txt\">Login passwords</a></span>\n" +
"                    <span>- <span class=\"big\"> SSH Usernames list </span> : <a href=\"SSH_Usernames.txt\">SSH usernames</a></span>\n" +
"                    <span>- <span class=\"big\">SSH Passwords list </span> :<a href=\"SSH_Usernames.txt\">SSH passwords</a></span>\n" +
"\n" +
"                </div>\n" +
"                <span class=\"details\">Login page Result:</span>\n" +
"\n" +
loginResult+
"                <br>\n" +
"                <span class=\"details\">SSH Result:</span>\n" +
SSHResults+
"            </div>";


//            String s="[ATTEMPT] target local-iam.dev-machinestalk.com - login \"test\" - pass \"PublishThisListPlease\" - 1 of 300 [child 0] (0/0)\n";

return bruteForceReport;
}

@Test
public void testZero() throws IOException, InterruptedException {
    String SQLInjectionReport=SQLScanReport();
    String bruteForceReport=bruteForceReport();
    String niktoScanReport=niktoReport();
    String owaspZapReport=zapScanReport();
    String dosReport=dosReport();
    String top = top();
    String end = end();
    String body=dosReport+SQLInjectionReport+bruteForceReport+niktoScanReport+owaspZapReport;
    String path="index.html";
    PrintWriter writer = new PrintWriter(path, "UTF-8");
    writer.println(top+body+end);
    writer.flush();
    writer.close();

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

if (s.startsWith("[80][http-post-form]")) {
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


    numberOfTries = Integer.parseInt(s.substring(s.indexOf("tasks, ") + ("tasks, ").length(), s.indexOf(" login")));
}
if (s.startsWith("1 of 1 target")) {
    success = !(Integer.parseInt(s.substring(s.indexOf("completed, ") + ("completed, ").length(), s.indexOf(" valid"))) == 0);
}

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
p.destroy();
System.out.println("//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
System.out.println(json.toString(2));
return json;
}

public static JSONObject SQLMapScan(String url, String data, int level) throws IOException, InterruptedException {
System.out.println("sqlmap is running");

String prefix = "/bin/bash";
String c = "-c";
String terminalCommand = "sqlmap -u '" + url + "' --data '" + data + "' --level " + level + " --risk " + level + " --ignore-stdin";
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
    if (s.contains("Microsoft")||s.contains("Oracle"))
        continue;
    info.put(s.substring(s.indexOf("[INFO]") + "[INFO] ".length()));
}
if (s.contains("WARNING")) {
    if (s.contains("heuristic"))
        continue;
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
obj.put("info", info);
obj.put("critical", critical);
obj.put("warning", warning);
obj.put("injectable", injectable);
System.out.println(obj.toString(2));
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
List<String> vulNames = new ArrayList<>();
List<String> desc = new ArrayList<>();
while ((s = br.readLine()) != null) {
    System.out.println(s);
    String str = s.substring(s.indexOf(":") + 2);

    if (s.startsWith("+ OSVDB")) {
    JSONObject vulJson = new JSONObject();
     if (cont(vulNames,s.substring(s.indexOf("+ ")+2,s.indexOf(":")))||cont(desc,str.substring(str.indexOf(":") + 2).substring(0,4)))
         continue;
    vulNames.add(s.substring(s.indexOf("+ ")+2,s.indexOf(":")));
    desc.add(str.substring(str.indexOf(":") + 2));
    vulJson.put("Vulnerability name", s.substring(s.indexOf("OSVDB"), s.indexOf(":")));
    vulJson.put("Description", str.substring(str.indexOf(":") + 2));
    vulJson.put("Test link", "http://local-tt.dev-machinestalk.com:80" + str.substring(str.indexOf("/"), str.indexOf(":")));
    vulsArray.put(vulJson);
        System.out.println(desc.toString());
}
if (s.startsWith("+ /")) {
 continue;
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
public static boolean cont(List<String> list,String str){
for (String st:
     list) {
    if (st.contains(str))
        return true;
}
return false;
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
public static String top(){
String top="<!DOCTYPE html>\n" +
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
return top;
}
public static String end(){
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
return end;

}
}