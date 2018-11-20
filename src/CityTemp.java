import java.net.*;
import java.io.*;
import org.json.JSONObject;
import org.json.XML;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

public class CityTemp
{
    int currTemp;
    int maxTemp;
    int minTemp;
    float pressure;
    int humidity;
    int visibility;
    float wSpeed;
    long sunrise;
    long sunset;
    String cityName;
    String desc;
    String icon;


public CityTemp()
{
    currTemp=0;
    maxTemp=0;
    minTemp=0;
    pressure=0;
    humidity=0;
    visibility=0;
    wSpeed=0;
    sunrise=0;
    sunset=0;
    cityName="";
    desc="";
    icon="";
}

public CityTemp data(String city) throws MalformedURLException, IOException
{
    CityTemp c =new CityTemp();
    
    URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q="+city+"&APPID=477ef69395fe01ed439173bab7c316ed");
    BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
     
    String inputLine=in.readLine();
    //System.out.println(inputLine);
     
    JSONObject json = new JSONObject(inputLine);
    String xml = XML.toString(json);
     
    Document xmlDoc = Jsoup.parse(xml, "", Parser.xmlParser());
    
    //Data
    Elements p1= xmlDoc.select("temp_max");
    int temp1=kelvinConverter(p1.text());
    c.maxTemp=temp1;
    
    Elements p2= xmlDoc.select("temp_min");
    int temp2=kelvinConverter(p2.text());
    c.minTemp=temp2;
    
    Elements p3= xmlDoc.select("name");
    String text3 = p3.text();
    Elements p4= xmlDoc.select("country");
    String text4 = p4.text();
    c.cityName=text3+", "+text4;
    
    Elements p5= xmlDoc.select("temp");
    int temp=kelvinConverter(p5.text());
    c.currTemp=temp;
    
    Elements p6= xmlDoc.select("visibility");
    if(p6.text().isEmpty())
    {
           c.visibility=0; 
    }
    else
    {
        int text6 = Integer.parseInt(p6.text());
        c.visibility=text6;
    }
    
    Elements p7= xmlDoc.select("pressure");
    float text7 = Float.parseFloat(p7.text());
    c.pressure=text7;
    
    Elements p8= xmlDoc.select("humidity");
    int text8 = Integer.parseInt(p8.text());
    c.humidity=text8;
    
    Elements p9= xmlDoc.select("speed");
    float text9 = Float.parseFloat(p9.text());
    c.wSpeed=text9;
    
    Elements p11= xmlDoc.select("sunrise");
    long text11 = Long.parseLong(p11.text());
    c.sunrise=text11;
    
    Elements p12= xmlDoc.select("sunset");
    long text12 = Long.parseLong(p12.text());
    c.sunset=text12;
    
    Elements p10= xmlDoc.select("description");
    String text10 = p10.text();
    c.desc=text10;
    
    Elements p13= xmlDoc.select("icon");
    String text13 = p13.text();
    c.icon=text13;
    
    return c;
}
public void display(CityTemp c)
{
    System.out.println("Name: "+c.cityName);
    System.out.println("Current Temp: "+c.currTemp);
    System.out.println("Max: "+c.maxTemp);
    System.out.println("Min: "+c.minTemp);
    System.out.println("Humidity: "+c.humidity+"%");
    System.out.println("Pressure: "+c.pressure+"");
    System.out.println("Visibility: "+c.visibility+"m");   
}
static int kelvinConverter(String t)
    {
       float temp=Float.parseFloat(t);
       float imm=temp-273;
       int res=(int)imm;
       
       return res;
    }
}