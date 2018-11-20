import java.sql.*;
import java.awt.Color;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends javax.swing.JFrame {
    
    String Cities[]=new String[5];
    long sunsetTime;
    long sunriseTime;
    String MainCity="NA";
    String City1="NA";
    String City2="NA";
    String City3="NA";
    String City4="NA";

    /**
     * Creates new form Main
     */
    public Main() throws IOException, ParseException {
        initComponents();
        runDB();
        System.out.println(MainCity+" "+City1+" "+City2+" "+City3+" "+City4);
        intializeCities();
        //Get the name of the city  
        if(MainCity.equals("NA"))
        {
            MainCity=JOptionPane.showInputDialog("Enter the name of your Current/Home City");
            mainCityDisp.setText(MainCity); 
            displayMain(MainCity);
        }
        else
        {
            displayMain(MainCity);
        }
    }
    public void intializeCities()
    {
        if(City1.equals("NA"))
        {}
        else
        { displayC1(City1);}
        if(City2.equals("NA"))
        {}
        else
        { displayC2(City2);}
        if(City3.equals("NA"))
        {}
        else
        { displayC3(City3);}
        if(City4.equals("NA"))
        {}
        else
        { displayC4(City4);}       
    }
    public void calDLNL()
    {
        
    }
    
    public void runDB()
    {
        Connection c = null;
      Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:Cities.db");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM CityList;" );
      
      int i=0;
      while ( rs.next() ) {  
         int id = rs.getInt("ID");
         Cities[i] = rs.getString("Name");         
         i++;
      }
      rs.close();
      stmt.close();
      c.close();
         
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      
        MainCity=Cities[0];
        City1=Cities[1];
        City2=Cities[2];
        City3=Cities[3];
        City4=Cities[4]; 
      
    }
    public void displayMain(String MainCity) throws ParseException
    {
        //Get the system time
        DateFormat dateFormat = new SimpleDateFormat("dd, MMMM k:mm a");
        Date date = new Date();
        timeDisp.setText(dateFormat.format(date)); 
        
        CityTemp c= new CityTemp();
        try 
        {
            c=c.data(MainCity);
            tempDisp.setText(""+c.currTemp+"°C");
            maxDisp.setText("Max: "+c.maxTemp+"°C ↑");
            minDisp.setText("Min: "+c.minTemp+"°C ↓");
            humDisp.setText("Humidity: "+c.humidity+"%");
            presDisp.setText("Pressure: "+c.pressure+"mBr");
            visDisp.setText("Visibility: "+c.visibility+"m");
            mainCityDisp.setText(c.cityName);
            wSpeedDisp.setText("Wind: "+c.wSpeed+"km/h");
            descDisp.setText(c.desc);
            midPanel.setBackground(panelColours(c.currTemp));
            sunriseDisp.setText("Sunrise: "+new SimpleDateFormat("k:mm a").format(new Date(c.sunrise * 1000L)));
            sunsetDisp.setText("Sunset: "+new SimpleDateFormat("k:mm a").format(new Date(c.sunset * 1000L)));
            mainCityIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource(IconSelection(c.icon))));
            sunsetTime=c.sunset;
            sunriseTime=c.sunrise;
            sunsetSunrise(sunsetTime,sunriseTime);
        } 
        catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error");
            //System.exit(0);;
        }
    }
    
    public String IconSelection(String i)
    {
        String res=null;
        switch(i)
        {
            case "01n": res="/Icons/clearnightl.png";
            break;
            case "01d": res="/Icons/sunyl.png";
            break;
            case "02d":
            case "02n":
            case "03d":
            case "03n":
            case "04d":
            case "04n": res="/Icons/cloudl.png";
            break;
            case "13d":
            case "13n": res="/Icons/snowl.png";
            break;
            case "50d":
            case "50n": res="/Icons/fogl.png";
            break;
            case "09d":
            case "09n":
            case "10d":
            case "10n":
            case "11d":
            case "11n": res="/Icons/rainl.png";
            break;
            default :
            res="/Icons/cloudl.png";      
        }
        return res;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topPanel = new javax.swing.JPanel();
        mainCityDisp = new javax.swing.JLabel();
        timeDisp = new javax.swing.JLabel();
        Refresh = new javax.swing.JButton();
        Exit = new javax.swing.JButton();
        midPanel = new javax.swing.JPanel();
        maxDisp = new javax.swing.JLabel();
        minDisp = new javax.swing.JLabel();
        tempDisp = new javax.swing.JLabel();
        mainCityIcon = new javax.swing.JLabel();
        descDisp = new javax.swing.JLabel();
        humDisp = new javax.swing.JLabel();
        presDisp = new javax.swing.JLabel();
        visDisp = new javax.swing.JLabel();
        wSpeedDisp = new javax.swing.JLabel();
        sunriseDisp = new javax.swing.JLabel();
        sunsetDisp = new javax.swing.JLabel();
        DLDisp = new javax.swing.JLabel();
        NLDisp = new javax.swing.JLabel();
        city4Panel = new javax.swing.JPanel();
        c4Name = new javax.swing.JLabel();
        c4Disp = new javax.swing.JLabel();
        c4Temp = new javax.swing.JLabel();
        c4Hum = new javax.swing.JLabel();
        c4Con = new javax.swing.JLabel();
        tb4 = new javax.swing.JToggleButton();
        city2Panel = new javax.swing.JPanel();
        c2Name = new javax.swing.JLabel();
        c2Disp = new javax.swing.JLabel();
        c2Temp = new javax.swing.JLabel();
        c2Hum = new javax.swing.JLabel();
        c2Con = new javax.swing.JLabel();
        tb2 = new javax.swing.JToggleButton();
        city3Panel = new javax.swing.JPanel();
        c3Name = new javax.swing.JLabel();
        c3Disp = new javax.swing.JLabel();
        c3Temp = new javax.swing.JLabel();
        c3Hum = new javax.swing.JLabel();
        c3Con = new javax.swing.JLabel();
        tb3 = new javax.swing.JToggleButton();
        city1Panel = new javax.swing.JPanel();
        c1Name = new javax.swing.JLabel();
        c1Disp = new javax.swing.JLabel();
        c1Temp = new javax.swing.JLabel();
        c1Hum = new javax.swing.JLabel();
        tb1 = new javax.swing.JToggleButton();
        c1Con = new javax.swing.JLabel();
        bottomPanel = new javax.swing.JPanel();
        remTimeDisp = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Mausam 2.0");
        setMaximumSize(new java.awt.Dimension(800, 680));
        setMinimumSize(new java.awt.Dimension(800, 680));
        setPreferredSize(new java.awt.Dimension(800, 680));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 680));
        getContentPane().setLayout(null);

        topPanel.setBackground(new java.awt.Color(0, 204, 204));
        topPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        topPanel.setLayout(null);

        mainCityDisp.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        mainCityDisp.setText("Name of the City");
        topPanel.add(mainCityDisp);
        mainCityDisp.setBounds(20, 20, 400, 101);

        timeDisp.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        timeDisp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeDisp.setText("00:00");
        topPanel.add(timeDisp);
        timeDisp.setBounds(450, 30, 340, 79);

        Refresh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Refresh.setText("Refresh");
        Refresh.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Refresh.setOpaque(false);
        Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshActionPerformed(evt);
            }
        });
        topPanel.add(Refresh);
        Refresh.setBounds(700, 110, 83, 30);

        Exit.setBackground(new java.awt.Color(255, 0, 0));
        Exit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Exit.setText("Exit");
        Exit.setOpaque(false);
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        topPanel.add(Exit);
        Exit.setBounds(728, 2, 70, 30);

        getContentPane().add(topPanel);
        topPanel.setBounds(0, 0, 800, 150);

        midPanel.setBackground(new java.awt.Color(153, 153, 153));
        midPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        maxDisp.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        maxDisp.setText("Max: 0");

        minDisp.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        minDisp.setText("Min: 0");

        tempDisp.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        tempDisp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tempDisp.setText("0");

        mainCityIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        descDisp.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        descDisp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        descDisp.setText("Description");

        humDisp.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        humDisp.setText("Humidity");

        presDisp.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        presDisp.setText("Pressure");

        visDisp.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        visDisp.setText("Visibility");

        wSpeedDisp.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        wSpeedDisp.setText("Wind Speed:");

        sunriseDisp.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        sunriseDisp.setText("Sunrise");

        sunsetDisp.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        sunsetDisp.setText("Sunset");

        DLDisp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        DLDisp.setText("Day Length");

        NLDisp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        NLDisp.setText("Night Length");

        javax.swing.GroupLayout midPanelLayout = new javax.swing.GroupLayout(midPanel);
        midPanel.setLayout(midPanelLayout);
        midPanelLayout.setHorizontalGroup(
            midPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(midPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(midPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(midPanelLayout.createSequentialGroup()
                        .addGroup(midPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tempDisp, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maxDisp, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(mainCityIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(minDisp, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(midPanelLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(descDisp, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(midPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NLDisp, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                    .addComponent(humDisp, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(presDisp, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DLDisp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addGroup(midPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sunriseDisp, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, midPanelLayout.createSequentialGroup()
                        .addComponent(sunsetDisp, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(midPanelLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(midPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(wSpeedDisp, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(visDisp, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        midPanelLayout.setVerticalGroup(
            midPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(midPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(midPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainCityIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(midPanelLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(midPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(midPanelLayout.createSequentialGroup()
                                .addComponent(tempDisp, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(maxDisp))
                            .addComponent(humDisp)
                            .addGroup(midPanelLayout.createSequentialGroup()
                                .addComponent(sunriseDisp)
                                .addGap(24, 24, 24)
                                .addGroup(midPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(sunsetDisp)
                                    .addComponent(presDisp))
                                .addGap(28, 28, 28)
                                .addGroup(midPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(visDisp)
                                    .addComponent(DLDisp, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGroup(midPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(midPanelLayout.createSequentialGroup()
                        .addComponent(minDisp, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(descDisp))
                    .addGroup(midPanelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(midPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(wSpeedDisp)
                            .addComponent(NLDisp, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        getContentPane().add(midPanel);
        midPanel.setBounds(-2, 150, 800, 220);

        city4Panel.setBackground(new java.awt.Color(153, 153, 153));
        city4Panel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        c4Name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        c4Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c4Name.setText("City4");

        c4Temp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        c4Temp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        c4Hum.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        c4Hum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        c4Con.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        c4Con.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        tb4.setBackground(java.awt.Color.lightGray);
        tb4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tb4.setText("Add");
        tb4.setToolTipText("Cick to add a new City");
        tb4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tb4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tb4.setOpaque(true);
        tb4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tb4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout city4PanelLayout = new javax.swing.GroupLayout(city4Panel);
        city4Panel.setLayout(city4PanelLayout);
        city4PanelLayout.setHorizontalGroup(
            city4PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c4Name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(city4PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(city4PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, city4PanelLayout.createSequentialGroup()
                        .addGap(0, 15, Short.MAX_VALUE)
                        .addGroup(city4PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, city4PanelLayout.createSequentialGroup()
                                .addComponent(c4Temp, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, city4PanelLayout.createSequentialGroup()
                                .addComponent(c4Disp, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, city4PanelLayout.createSequentialGroup()
                                .addComponent(tb4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33))))
                    .addGroup(city4PanelLayout.createSequentialGroup()
                        .addGroup(city4PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(c4Con, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(c4Hum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        city4PanelLayout.setVerticalGroup(
            city4PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(city4PanelLayout.createSequentialGroup()
                .addComponent(c4Name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(c4Disp, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c4Temp, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c4Con, javax.swing.GroupLayout.DEFAULT_SIZE, 12, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c4Hum, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(tb4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(city4Panel);
        city4Panel.setBounds(600, 370, 200, 230);

        city2Panel.setBackground(new java.awt.Color(153, 153, 153));
        city2Panel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        c2Name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        c2Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c2Name.setText("City2");

        c2Temp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        c2Temp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        c2Hum.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        c2Hum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        c2Con.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        c2Con.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        tb2.setBackground(java.awt.Color.lightGray);
        tb2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tb2.setMnemonic('2');
        tb2.setText("Add");
        tb2.setToolTipText("Cick to add a new City");
        tb2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tb2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tb2.setOpaque(true);
        tb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tb2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout city2PanelLayout = new javax.swing.GroupLayout(city2Panel);
        city2Panel.setLayout(city2PanelLayout);
        city2PanelLayout.setHorizontalGroup(
            city2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c2Name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(city2PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(city2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(city2PanelLayout.createSequentialGroup()
                        .addGroup(city2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(c2Temp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(c2Hum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(c2Con, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, city2PanelLayout.createSequentialGroup()
                        .addGap(0, 37, Short.MAX_VALUE)
                        .addGroup(city2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, city2PanelLayout.createSequentialGroup()
                                .addComponent(c2Disp, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, city2PanelLayout.createSequentialGroup()
                                .addComponent(tb2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42))))))
        );
        city2PanelLayout.setVerticalGroup(
            city2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(city2PanelLayout.createSequentialGroup()
                .addComponent(c2Name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(c2Disp, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c2Temp, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c2Con, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c2Hum, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(tb2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(city2Panel);
        city2Panel.setBounds(200, 370, 200, 225);

        city3Panel.setBackground(new java.awt.Color(153, 153, 153));
        city3Panel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        c3Name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        c3Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c3Name.setText("City3");

        c3Temp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        c3Temp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        c3Hum.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        c3Hum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        c3Con.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        c3Con.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        tb3.setBackground(java.awt.Color.lightGray);
        tb3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tb3.setText("Add");
        tb3.setToolTipText("Cick to add a new City");
        tb3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tb3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tb3.setOpaque(true);
        tb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tb3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout city3PanelLayout = new javax.swing.GroupLayout(city3Panel);
        city3Panel.setLayout(city3PanelLayout);
        city3PanelLayout.setHorizontalGroup(
            city3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c3Name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(city3PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(city3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(city3PanelLayout.createSequentialGroup()
                        .addGroup(city3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(c3Temp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(c3Hum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(c3Con, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, city3PanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(c3Disp, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, city3PanelLayout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(tb3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        city3PanelLayout.setVerticalGroup(
            city3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(city3PanelLayout.createSequentialGroup()
                .addComponent(c3Name)
                .addGap(13, 13, 13)
                .addComponent(c3Disp, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c3Temp, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c3Con, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c3Hum, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(tb3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(city3Panel);
        city3Panel.setBounds(400, 370, 200, 227);

        city1Panel.setBackground(new java.awt.Color(153, 153, 153));
        city1Panel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        c1Name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        c1Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c1Name.setText("City1");

        c1Disp.setBackground(new java.awt.Color(0, 0, 0));

        c1Temp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        c1Temp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        c1Hum.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        c1Hum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        tb1.setBackground(java.awt.Color.lightGray);
        tb1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tb1.setMnemonic('1');
        tb1.setText("Add");
        tb1.setToolTipText("Cick to add a new City");
        tb1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tb1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tb1.setName(""); // NOI18N
        tb1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tb1MouseEntered(evt);
            }
        });
        tb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tb1ActionPerformed(evt);
            }
        });

        c1Con.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        c1Con.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout city1PanelLayout = new javax.swing.GroupLayout(city1Panel);
        city1Panel.setLayout(city1PanelLayout);
        city1PanelLayout.setHorizontalGroup(
            city1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c1Name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(city1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(city1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(c1Temp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(c1Hum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(c1Con, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, city1PanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(c1Disp, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
            .addGroup(city1PanelLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(tb1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        city1PanelLayout.setVerticalGroup(
            city1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(city1PanelLayout.createSequentialGroup()
                .addComponent(c1Name, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c1Disp, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(c1Temp, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c1Con, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c1Hum, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tb1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(city1Panel);
        city1Panel.setBounds(0, 370, 200, 230);

        bottomPanel.setBackground(new java.awt.Color(153, 153, 153));
        bottomPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        remTimeDisp.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        remTimeDisp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        remTimeDisp.setText("Time Remaining in Sunset/Sunrise");

        javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanelLayout.setHorizontalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(remTimeDisp, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
        );
        bottomPanelLayout.setVerticalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(remTimeDisp, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        getContentPane().add(bottomPanel);
        bottomPanel.setBounds(0, 600, 800, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void displayC1(String City)
    {
        //if(tb1.isSelected()==true)
        //{
            tb1.setText("Remove");
            CityTemp c1=new CityTemp();
        try 
            {
                c1=c1.data(City);
                c1Name.setText(c1.cityName);
                c1Temp.setText(""+c1.currTemp+"°C");
                c1Hum.setText("Humidity: "+c1.humidity+"%");
                c1Con.setText(c1.desc);
                city1Panel.setBackground(panelColours(c1.currTemp));
                tb1.setBackground(java.awt.Color.GRAY);
                c1Disp.setIcon(new javax.swing.ImageIcon(getClass().getResource(IconSelection(c1.icon))));
                c1Disp.setVisible(true);    
            } 
        catch (IOException ex) 
            {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error");
                //System.exit(0);
            }   
        //}
    }
    private void tb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tb1ActionPerformed
        // TODO add your handling code here:
         if(tb1.isSelected()==true)
        {
            if(City1.equals("NA"))
            {
                String C1=JOptionPane.showInputDialog("Enter the name of the city");
                displayC1(C1);
                City1=C1;
            }
            else
            {
                displayC1(City1);
            }
        }
        else
        {
            City1="NA";
            tb1.setBackground(java.awt.Color.DARK_GRAY);
            tb1.setText("Add");
            c1Temp.setText("");
            c1Hum.setText("");
            c1Con.setText(""); 
            c1Name.setText("");
            c1Disp.setVisible(false);
            city1Panel.setBackground(Color.gray);   
        }
    }//GEN-LAST:event_tb1ActionPerformed

    public void displayC2(String City)
    {
        //if(tb2.isSelected()==true)
        {
            tb2.setText("Remove");
            CityTemp c2=new CityTemp();
        try 
            {
                c2=c2.data(City);
                c2Name.setText(c2.cityName);
                c2Temp.setText(""+c2.currTemp+"°C");
                c2Hum.setText("Humidity: "+c2.humidity+"%");
                c2Con.setText(c2.desc);
                city2Panel.setBackground(panelColours(c2.currTemp));
                tb2.setBackground(java.awt.Color.GRAY);
                c2Disp.setIcon(new javax.swing.ImageIcon(getClass().getResource(IconSelection(c2.icon))));
                c2Disp.setVisible(true);    
            } 
        catch (IOException ex) 
            {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error");
                //System.exit(0);
            }   
        }
    }
    private void tb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tb2ActionPerformed
        // TODO add your handling code here:
        if(tb2.isSelected()==true)
        {
            if(City2.equals("NA"))
            {
                String C2=JOptionPane.showInputDialog("Enter the name of the city");
                displayC2(C2);
                City2=C2;
            }
            else
            {
                displayC2(City2);
            }
        }
        else
        {
            City2="NA";
            tb2.setBackground(java.awt.Color.DARK_GRAY);
            tb2.setText("Add");
            c2Temp.setText("");
            c2Hum.setText("");
            c2Con.setText(""); 
            c2Name.setText("");
            c2Disp.setVisible(false);
            city2Panel.setBackground(Color.gray);   
        }
    }//GEN-LAST:event_tb2ActionPerformed

    public void displayC3(String City)
    {
        //if(tb3.isSelected()==true)
        {
            tb3.setText("Remove");
            CityTemp c3=new CityTemp();
        try 
            {
                c3=c3.data(City);
                c3Name.setText(c3.cityName);
                c3Temp.setText(""+c3.currTemp+"°C");
                c3Hum.setText("Humidity: "+c3.humidity+"%");
                c3Con.setText(c3.desc);
                city3Panel.setBackground(panelColours(c3.currTemp));
                tb3.setBackground(java.awt.Color.GRAY);
                c3Disp.setIcon(new javax.swing.ImageIcon(getClass().getResource(IconSelection(c3.icon))));
                c3Disp.setVisible(true);    
            } 
        catch (IOException ex) 
            {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error");
                //System.exit(0);
            }   
        }
    }
    private void tb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tb3ActionPerformed
        // TODO add your handling code here:
        if(tb3.isSelected()==true)
        {
            if(City3.equals("NA"))
            {
                String C3=JOptionPane.showInputDialog("Enter the name of the city");
                displayC3(C3);
                City3=C3;
            }
            else
            {
                displayC3(City3);
            }
        }
        else
        {
            City3="NA";
            tb3.setBackground(java.awt.Color.DARK_GRAY);
            tb3.setText("Add");
            c3Temp.setText("");
            c3Hum.setText("");
            c3Con.setText(""); 
            c3Name.setText("");
            c3Disp.setVisible(false);
            city3Panel.setBackground(Color.gray);   
        }
       
    }//GEN-LAST:event_tb3ActionPerformed

    public void displayC4(String City)
    {
        //if(tb4.isSelected()==true)
        {
            tb4.setText("Remove");
            CityTemp c4=new CityTemp();
        try 
            {
                c4=c4.data(City);
                c4Name.setText(c4.cityName);
                c4Temp.setText(""+c4.currTemp+"°C");
                c4Hum.setText("Humidity: "+c4.humidity+"%");
                c4Con.setText(c4.desc);
                city4Panel.setBackground(panelColours(c4.currTemp));
                tb4.setBackground(java.awt.Color.GRAY);
                c4Disp.setIcon(new javax.swing.ImageIcon(getClass().getResource(IconSelection(c4.icon))));
                c4Disp.setVisible(true);    
            } 
        catch (IOException ex) 
            {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error");
                System.exit(0);
            }   
        }
    }
    
    private void tb4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tb4ActionPerformed
        // TODO add your handling code here:
        if(tb4.isSelected()==true)
        {
            if(City4.equals("NA"))
            {
                String C4=JOptionPane.showInputDialog("Enter the name of the city");
                displayC4(C4);
                City4=C4;
            }
            else
            {
                displayC4(City4);
            }
        }
        else
        {
            City4="NA";
            tb4.setBackground(java.awt.Color.DARK_GRAY);
            tb4.setText("Add");
            c4Temp.setText("");
            c4Hum.setText("");
            c4Con.setText(""); 
            c4Name.setText("");
            c4Disp.setVisible(false);
            city4Panel.setBackground(Color.gray);   
        }
    }//GEN-LAST:event_tb4ActionPerformed

    private void tb1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb1MouseEntered
     
    }//GEN-LAST:event_tb1MouseEntered

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
        // TODO add your handling code here:
        DateFormat dateFormat = new SimpleDateFormat("dd, MMMM k:mm a");
        Date date = new Date();
        timeDisp.setText(dateFormat.format(date));
        
        try {
            sunsetSunrise(sunsetTime,sunriseTime);
        } catch (ParseException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_RefreshActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        // TODO add your handling code here:
   Connection c = null;
   Statement stmt = null;
   System.out.println("Test2");
   try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:Cities.db");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");

      
      System.out.println("City1: "+City1);
      stmt = c.createStatement();
      String sql2 = "UPDATE CityList SET Name='"+ City1 +"' where ID=2;";
      stmt.executeUpdate(sql2);
      c.commit();
      System.out.println("State saved");
      
      System.out.println("City1: "+MainCity);
      stmt = c.createStatement();
      String sql1 = "UPDATE CityList SET Name='"+ MainCity +"' where ID=1;";
      stmt.executeUpdate(sql1);
      c.commit();
      System.out.println("State saved");
      
      System.out.println("City1: "+City2);
      stmt = c.createStatement();
      String sql3 = "UPDATE CityList SET Name='"+ City2 +"' where ID=3;";
      stmt.executeUpdate(sql3);
      c.commit();
      System.out.println("State saved");
      
      System.out.println("City1: "+City3);
      stmt = c.createStatement();
      String sql4 = "UPDATE CityList SET Name='"+ City3 +"' where ID=4;";
      stmt.executeUpdate(sql4);
      c.commit();
      System.out.println("State saved");
      
      System.out.println("City1: "+City4);
      stmt = c.createStatement();
      String sql5 = "UPDATE CityList SET Name='"+ City4 +"' where ID=5;";
      stmt.executeUpdate(sql5);
      c.commit();
      System.out.println("State saved");

      stmt.close();
      c.close();
   } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
   }
        System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed

    public Color panelColours (int temp)
    {
        if(temp<6)
        {
            return Color.BLUE;
        }
        else if(temp<23)
        {
            return Color.green;
        }
        else if(temp<30)
        {
            return Color.YELLOW;
        }
        else if(temp<36)
        {
            return Color.ORANGE;
        }
        else if(temp>=36)
        {
            return Color.RED;
        }
        return Color.lightGray;
    }
    
    public void sunsetSunrise(long sunset, long sunrise) throws ParseException
    {
       SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        //Date date1 = format.parse(time1);
        
        
        Date d2=new Date();
        long t1;
        t1=d2.getTime();
        //System.out.println(t1);
        long t2=sunset*1000;
        long t3=sunrise*1000;
        
        long DL=t2-t3;
        int hr1=(int) (DL/3600000);
        int min1= (int) (((DL)-(hr1*3600000))/60000);
        DLDisp.setText("Day Length: "+hr1+" hr" + min1+" min");
        int NLhr=23-hr1;
        int NLmin=60-min1;
        NLDisp.setText("Night Length: "+NLhr+" hr "+NLmin+" min");
        if(t1>t2)
        {
            t3=t3+24*60*60*1000;
            
            //System.out.println(t3+" "+t1);
            int hr=(int) ((t3-t1)/3600000);
            int min= (int) (((t3-t1)-(hr*3600000))/60000);
            //System.out.println("Time in Sunrise: "+hr+" hr "+min+" min");
            bottomPanel.setBackground(Color.GRAY);
            remTimeDisp.setText("Time in Sunrise: "+hr+" hr "+min+" min");
            
            
        }
        else
        {
            int hr=(int) ((t2-t1)/3600000);
            int min= (int) (((t2-t1)-(hr*3600000))/60000);
            //System.out.println("Time in Sunset: "+hr+" hr "+min+" min");  
            bottomPanel.setBackground(Color.ORANGE);
            remTimeDisp.setText("Time in Sunset: "+hr+" hr "+min+" min");
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    try {
                        new Main().setVisible(true);
                    } catch (ParseException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DLDisp;
    private javax.swing.JButton Exit;
    private javax.swing.JLabel NLDisp;
    private javax.swing.JButton Refresh;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JLabel c1Con;
    private javax.swing.JLabel c1Disp;
    private javax.swing.JLabel c1Hum;
    private javax.swing.JLabel c1Name;
    private javax.swing.JLabel c1Temp;
    private javax.swing.JLabel c2Con;
    private javax.swing.JLabel c2Disp;
    private javax.swing.JLabel c2Hum;
    private javax.swing.JLabel c2Name;
    private javax.swing.JLabel c2Temp;
    private javax.swing.JLabel c3Con;
    private javax.swing.JLabel c3Disp;
    private javax.swing.JLabel c3Hum;
    private javax.swing.JLabel c3Name;
    private javax.swing.JLabel c3Temp;
    private javax.swing.JLabel c4Con;
    private javax.swing.JLabel c4Disp;
    private javax.swing.JLabel c4Hum;
    private javax.swing.JLabel c4Name;
    private javax.swing.JLabel c4Temp;
    private javax.swing.JPanel city1Panel;
    private javax.swing.JPanel city2Panel;
    private javax.swing.JPanel city3Panel;
    private javax.swing.JPanel city4Panel;
    private javax.swing.JLabel descDisp;
    private javax.swing.JLabel humDisp;
    private javax.swing.JLabel mainCityDisp;
    private javax.swing.JLabel mainCityIcon;
    private javax.swing.JLabel maxDisp;
    private javax.swing.JPanel midPanel;
    private javax.swing.JLabel minDisp;
    private javax.swing.JLabel presDisp;
    private javax.swing.JLabel remTimeDisp;
    private javax.swing.JLabel sunriseDisp;
    private javax.swing.JLabel sunsetDisp;
    private javax.swing.JToggleButton tb1;
    private javax.swing.JToggleButton tb2;
    private javax.swing.JToggleButton tb3;
    private javax.swing.JToggleButton tb4;
    private javax.swing.JLabel tempDisp;
    private javax.swing.JLabel timeDisp;
    private javax.swing.JPanel topPanel;
    private javax.swing.JLabel visDisp;
    private javax.swing.JLabel wSpeedDisp;
    // End of variables declaration//GEN-END:variables
}
