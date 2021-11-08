import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.*;
import java.util.Random;
// import java.sql.*;

public class board extends JFrame implements ActionListener
{  
    int NoP=2;
    Font f=new Font("TimesRoman",Font.BOLD,20);
    JLabel currentStatus =new JLabel("<html><h1>Woohooo....Game Started</h1>");
    int moveNumber=0;
    ImageIcon cities[]=new ImageIcon[32]; 
    static String name[]=new String[4];
    // money of each player
    int m[]=new int[4];
    //to check if house has already been built in the city
    int houseBuilt[]=new int[32];
    //class that implements action listener for displaying info of players and cities
    information in=new information();
    // class that contains names of cities - cities.java
    static cities c=new cities();
    // determines whose turn to play
    int turn=0;
    //current positions of each players
    int p[]=new int[4];
    // to get random numbers for dice
    Random r=new Random();
    Color colour=new Color(190,245,221);
    // numbers on faces of dice
    int face1,face2;
    // icon of the frame
    ImageIcon icon=new ImageIcon("D:/VS_Code/Sumith/Projects/monopoly/images/icon.jpg");
    // buttons for all 32 places
    static JButton btns[]=new JButton[32];
    // buttons for all players
    JButton players[]=new JButton[4];
    // end game and end turn buttons
    JButton game[]=new JButton[2];
    // button to roll dice
    JButton roll=new JButton("roll dice");
    // button for buying 
    JButton buy=new JButton("buy");
    JButton build=new JButton("build");
    Cursor cur = new Cursor(Cursor.HAND_CURSOR);
    // images for corner places
    ImageIcon city1=new ImageIcon("D:/VS_Code/Sumith/Projects/monopoly/images/123.jpg");
    ImageIcon jail=new ImageIcon("D:/VS_Code/Sumith/Projects/monopoly/images/jail2.jpg");                                 
    ImageIcon parking=new ImageIcon("D:/VS_Code/Sumith/Projects/monopoly/images/parking2.jpg");                                 
    ImageIcon goTojail=new ImageIcon("D:/VS_Code/Sumith/Projects/monopoly/images/gotojail2.jpg");                                 
    ImageIcon go=new ImageIcon("D:/VS_Code/Sumith/Projects/monopoly/images/go2.png");
    //images for dice faces 
    ImageIcon dice1,dice2;
    static JTextArea info=new JTextArea();
    // background of the frame   
    ImageIcon background=new ImageIcon("D:/VS_Code/Sumith/Projects/monopoly/images/bgfade.jpg");    
    JLabel back=new JLabel("",background,JLabel.CENTER); 
    // labels where dice faces are shown
    JLabel f1,f2;
    JLabel owns[]=new JLabel[32];
    JLabel house[]=new JLabel[32];
    // pieces
    JTextArea pieces[]=new JTextArea[4];
    // class that contains coordinates for pieces - cities.java
    coordinates xy=new coordinates();
    static owns own=new owns();
    // string x,y are names of 2 players entered in start frame by user - monopoly.java  
    public void communityChest(int task,int turn,int m[],JButton players[],int board)
    {
        switch(task)
        {
            case 100:   m[turn]=m[turn]-(board*100);
                        //connecting to mySQl XAMPP - incomplete
                        // try{  
                        // Class.forName("com.mysql.jdbc.Driver");  
                        
                        // Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/monopoly","root","");  
                        // String query="update players set amount="+m[turn]+" where pid="+turn; 
                        // String query1="update players set amount=amount+100 where pid not in("+turn+")";
                        // con.prepareStatement(query).execute(); 
                        // con.prepareStatement(query1).execute();
                        players[turn].setText(name[turn]+"("+m[turn]+")");
                        for(int i=0;i<NoP;i++)
                        {
                            if(i!=turn)
                            {
                                m[i]=m[i]+100;
                                players[i].setText(name[i]+"("+m[i]+")");
                            }
                        } 
                        // con.close();
                
                        // }catch(Exception ex){ System.out.println(ex);}
                        break; 
            case 101:   m[turn]=m[turn]+(board*50);
                        //connecting to mySQl XAMPP - incomplete
                        // try{  
                        // Class.forName("com.mysql.jdbc.Driver");  
                        
                        // Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/monopoly","root","");  ; 
                        // String query="update players set amount="+m[turn]+" where pid="+turn; 
                        // String query1="update players set amount=amount-50 where pid not in("+turn+")";
                        // con.prepareStatement(query).execute(); 
                        // con.prepareStatement(query1).execute(); 
                        // con.close();
                        players[turn].setText(name[turn]+"("+m[turn]+")");
                        for(int i=0;i<NoP;i++)
                        {
                            if(i!=turn)
                            {
                                m[i]=m[i]-50;
                                players[i].setText(name[i]+"("+m[i]+")");
                            }
                        } 
                
                        // }catch(Exception ex){ System.out.println(ex);} 
                        break;
            case 102:   m[turn]=m[turn]-250;
                        //connecting to mySQl XAMPP - incomplete
                        // try{  
                        // Class.forName("com.mysql.jdbc.Driver");  
                        
                        // Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/monopoly","root",""); 
                        // String query="update players set amount="+m[turn]+" where pid="+turn;
                        // con.prepareStatement(query).execute();  
                        // con.close();
                        players[turn].setText(name[turn]+"("+m[turn]+")");
                
                        // }catch(Exception ex){ System.out.println(ex);} 
                        break;
            case 103:   m[turn]=m[turn]-1000;
                        //connecting to mySQl XAMPP - incomplete
                        // try{  
                        // Class.forName("com.mysql.jdbc.Driver");  
                        
                        // Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/monopoly","root","");
                        // String query="update players set amount="+m[turn]+" where pid="+turn; 
                        // con.prepareStatement(query).execute();  
                        // con.close();
                        players[turn].setText(name[turn]+"("+m[turn]+")");
                
                        // }catch(Exception ex){ System.out.println(ex);}
                        break; 
            case 104:   m[turn]=m[turn]+500;
                        //connecting to mySQl XAMPP - incomplete
                        // try{  
                        // Class.forName("com.mysql.jdbc.Driver");  
                        
                        // Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/monopoly","root",""); 
                        // String query="update players set amount="+m[turn]+" where pid="+turn;
                        // con.prepareStatement(query).execute();  
                        // con.close();
                        players[turn].setText(name[turn]+"("+m[turn]+")");
                
                        // }catch(Exception ex){ System.out.println(ex);} 
                        break;
            case 105:   m[turn]=m[turn]-200;
                        //connecting to mySQl XAMPP - incomplete
                        // try{  
                        // Class.forName("com.mysql.jdbc.Driver");  
                        
                        // Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/monopoly","root",""); 
                        // String query="update players set amount="+m[turn]+" where pid="+turn; 
                        // con.prepareStatement(query).execute(); 
                        // con.close();
                        players[turn].setText(name[turn]+"("+m[turn]+")");
                
                        // }catch(Exception ex){ System.out.println(ex);} 
                        break;
        }
    }                               
    public void chance(int task,int turn,int m[],JButton players[],int board)
    {
        switch(task)
        {
            case 100:   m[turn]=m[turn]-250;
                        //connecting to mySQl XAMPP - incomplete
                    //     try{  
                    //     Class.forName("com.mysql.jdbc.Driver");  
                        
                    //     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/monopoly","root","");  
                    //     String query="update players set amount="+m[turn]+" where pid="+turn; 
                    //     con.prepareStatement(query).execute(); 
                    //     con.close();
                        
                    // }catch(Exception ex){ System.out.println(ex);}
                    players[turn].setText(name[turn]+"("+m[turn]+")"); 
                        break; 
            case 101:   m[turn]=m[turn]+400;
                        //connecting to mySQl XAMPP - incomplete
                    //     try{  
                    //     Class.forName("com.mysql.jdbc.Driver");  
                        
                    //     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/monopoly","root","");  ; 
                    //     String query="update players set amount="+m[turn]+" where pid="+turn; 
                    //     con.prepareStatement(query).execute(); 
                    //     con.close();
                        
                    // }catch(Exception ex){ System.out.println(ex);} 
                    players[turn].setText(name[turn]+"("+m[turn]+")");
                        break;
            case 102:   m[turn]=m[turn]+500;
                        //connecting to mySQl XAMPP - incomplete
                    //     try{  
                    //     Class.forName("com.mysql.jdbc.Driver");  
                        
                    //     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/monopoly","root",""); 
                    //     String query="update players set amount="+m[turn]+" where pid="+turn;
                    //     con.prepareStatement(query).execute();  
                    //     con.close();
                        
                    // }catch(Exception ex){ System.out.println(ex);} 
                    players[turn].setText(name[turn]+"("+m[turn]+")");
                        break;
            case 103:   m[turn]=m[turn]-300;
                        //connecting to mySQl XAMPP - incomplete
                    //     try{  
                    //     Class.forName("com.mysql.jdbc.Driver");  
                        
                    //     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/monopoly","root","");
                    //     String query="update players set amount="+m[turn]+" where pid="+turn; 
                    //     con.prepareStatement(query).execute();  
                    //     con.close();
                        
                    // }catch(Exception ex){ System.out.println(ex);}
                    players[turn].setText(name[turn]+"("+m[turn]+")");
                        break; 
            case 104:   m[turn]=m[turn]+200;
                        //connecting to mySQl XAMPP - incomplete
                    //     try{  
                    //     Class.forName("com.mysql.jdbc.Driver");  
                        
                    //     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/monopoly","root",""); 
                    //     String query="update players set amount="+m[turn]+" where pid="+turn;
                    //     con.prepareStatement(query).execute();  
                    //     con.close();
                        
                    // }catch(Exception ex){ System.out.println(ex);} 
                    players[turn].setText(name[turn]+"("+m[turn]+")");
                        break;
            case 105:   m[turn]=m[turn]-500;
                        //connecting to mySQl XAMPP - incomplete
                    //     try{  
                    //     Class.forName("com.mysql.jdbc.Driver");  
                        
                    //     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/monopoly","root",""); 
                    //     String query="update players set amount="+m[turn]+" where pid="+turn; 
                    //     con.prepareStatement(query).execute(); 
                    //     con.close();
                        
                    // }catch(Exception ex){ System.out.println(ex);} 
                    players[turn].setText(name[turn]+"("+m[turn]+")");
                        break;
        }
    }                               
    board(String x,String y)
    {
        name[0]=x;
        name[1]=y;
        m[0]=10000;
        m[1]=10000;
        setLayout(null);                       
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        set2();
        // back=>labelObject for backgroung image : setting size
        back.setBounds(0,0,1500,850);
        add(back);
        // sets initial position to city0
        p[0]=0;
        p[1]=0;
        // sets turn to play for player 1
        turn=0;
        // mySql connection - incomplete                   
        // try{  
        //     Class.forName("com.mysql.jdbc.Driver");  
        //     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/monopoly","root","");  
             
        //     // Statement stmt=con.createStatement();  
        //     String query = " insert into players (pid, pname, color ,amount)" + " values (?, ?, ?,?)";
        //     // String query = "insert into catallog values(6,6,6)";
        //     String query3 = "delete from moves";
        //     con.prepareStatement(query3).execute();
        //     String query2 = "delete from owns";
        //     con.prepareStatement(query2).execute();
        //     String query1 = "delete from players";
        //     con.prepareStatement(query1).execute();
        //     PreparedStatement x1 = con.prepareStatement(query);
        //     PreparedStatement x2 = con.prepareStatement(query);
        //     x1.setInt(1, 0);
        //     x1.setString(2,x);
        //     x1.setString(3,"green");
        //     x1.setInt(4, 10000);
            
        //     x2.setInt(1, 1);
        //     x2.setString(2,y);
        //     x2.setString(3,"red");
        //     x2.setInt(4, 10000);
        //     x1.execute();
        //     x2.execute(); 
            
        //     con.close();  
        //     }catch(Exception _e){ System.out.println(_e);}
         // assigning initial money to players
        // makes entire frame visible
        this.setVisible(true);
    }
    board(String x,String y,String z,String w)
    {
        NoP=4;
        name[0]=x;
        name[1]=y;
        name[2]=z;
        name[3]=w;
        // assigning initial money to players
        m[0]=10000;
        m[1]=10000;
        m[2]=10000;
        m[3]=10000;
        set2();
        setLayout(null);                       
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // back=>labelObject for backgroung image : setting size
        back.setBounds(0,0,1500,850);
        add(back);
        // sets initial position to city0
        p[0]=0;
        p[1]=0;
        p[2]=0;
        p[3]=0;
        // sets turn to play for player 1
        turn=0;
        // mySql connection - incomplete                    
        // try{  
        //     Class.forName("com.mysql.jdbc.Driver");  
        //     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/monopoly","root","");  
             
        //     // Statement stmt=con.createStatement();  
        //     String query = " insert into players (pid, pname, color ,amount)" + " values (?, ?, ?,?)";
        //     // String query = "insert into catallog values(6,6,6)";
        //     String query3 = "delete from moves";
        //     con.prepareStatement(query3).execute();
        //     String query2 = "delete from owns";
        //     con.prepareStatement(query2).execute();
        //     String query1 = "delete from players";
        //     con.prepareStatement(query1).execute();
        //     PreparedStatement x1 = con.prepareStatement(query);
        //     PreparedStatement x2 = con.prepareStatement(query);
        //     x1.setInt(1, 0);
        //     x1.setString(2,x);
        //     x1.setString(3,"green");
        //     x1.setInt(4, 10000);
            
        //     x2.setInt(1, 1);
        //     x2.setString(2,y);
        //     x2.setString(3,"red");
        //     x2.setInt(4, 10000);
        //     x1.execute();
        //     x2.execute(); 
            
        //     con.close();  
        //     }catch(Exception _e){ System.out.println(_e);}
        // makes entire frame visible
        this.setVisible(true);
    }
    board(String x,String y,String z)
    {
        NoP=3;
        name[0]=x;
        name[1]=y;
        name[2]=z;
        // assigning initial money to players
        m[0]=10000;
        m[1]=10000;
        m[2]=10000;
        setLayout(null);                       
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        set2();
        // back=>labelObject for backgroung image : setting size
        back.setBounds(0,0,1500,850);
        add(back);
        // sets initial position to city0
        p[0]=0;
        p[1]=0;
        p[2]=0;
        // sets turn to play for player 1
        turn=0;
        // mySql connection - incomplete                    
        // try{  
        //     Class.forName("com.mysql.jdbc.Driver");  
        //     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/monopoly","root","");  
             
        //     // Statement stmt=con.createStatement();  
        //     String query = " insert into players (pid, pname, color ,amount)" + " values (?, ?, ?,?)";
        //     // String query = "insert into catallog values(6,6,6)";
        //     String query3 = "delete from moves";
        //     con.prepareStatement(query3).execute();
        //     String query2 = "delete from owns";
        //     con.prepareStatement(query2).execute();
        //     String query1 = "delete from players";
        //     con.prepareStatement(query1).execute();
        //     PreparedStatement x1 = con.prepareStatement(query);
        //     PreparedStatement x2 = con.prepareStatement(query);
        //     x1.setInt(1, 0);
        //     x1.setString(2,x);
        //     x1.setString(3,"green");
        //     x1.setInt(4, 10000);
            
        //     x2.setInt(1, 1);
        //     x2.setString(2,y);
        //     x2.setString(3,"red");
        //     x2.setInt(4, 10000);
        //     x1.execute();
        //     x2.execute(); 
            
        //     con.close();  
        //     }catch(Exception _e){ System.out.println(_e);}
        // makes entire frame visible
        this.setVisible(true);
    }
    //  on click action for roll dice
    public void actionPerformed(ActionEvent e)
    {
        info.setText("Click on any city\nfor details");
        _communityChest cc=new _communityChest();
        _chance ch=new _chance();
        int flag=0;
        buy.setEnabled(true);
        String where="",what="";
        int task=r.nextInt(6)+100;
        String work="";
        moveNumber++;
        int play=-1;
        int amt=0;
        int rent=0;
        int sumDice=0;
        // random numbers chosen
        face1=r.nextInt(6)+1;
        face2=r.nextInt(6)+1;
        sumDice=face1+face2;
        // images corresponding to those random numbers
        dice1=new ImageIcon(getClass().getResource("face"+face1+".png"));
        dice2=new ImageIcon(getClass().getResource("face"+face2+".png"));
        // setting labels to those images for display
        f1.setIcon(dice1);
        f2.setIcon(dice2);
        // setting new position for player with current turn
        if(p[turn]+sumDice>=32)
        {
            flag=1;
        }
        p[turn]=(p[turn]+face1+face2)%32;
        if(own.O[p[turn]]==-1&&p[turn]!=0&&p[turn]!=8&&p[turn]!=16&&p[turn]!=24&&p[turn]!=31&&p[turn]!=23&&p[turn]!=18&&p[turn]!=15&&p[turn]!=7&&p[turn]!=4&&p[turn]!=2&&m[turn]>c.P[p[turn]])
        {
            where="<html>"+name[turn]+" landed on "+c.C[p[turn]]+"<br>you can buy it for Rs"+c.P[p[turn]];
        }
        else
        {
            where="<html>"+name[turn]+" landed on "+c.C[p[turn]];
        }
        if(p[turn]==8)
        {
            where="<html>"+name[turn]+" landed on "+c.C[p[turn]]+"<br> Rs 500 debited from your account";
        }
        if(p[turn]==4)
        {
            where="<html>"+name[turn]+" landed on "+c.C[p[turn]]+"<br> Rs 250 debited from your account";
        }
        if(p[turn]==0||p[turn]==8||p[turn]==16||p[turn]==24||p[turn]==31||p[turn]==23||p[turn]==18||p[turn]==15||p[turn]==7||p[turn]==4||p[turn]==2||m[turn]<c.P[p[turn]])
        {
            buy.setEnabled(false);
        }
        else
        {
            buy.setEnabled(true);
        }
        if(p[turn]==31||p[turn]==18||p[turn]==7)
        {
            // incomplete
            // try{  
            //     Class.forName("com.mysql.jdbc.Driver");  
                
            //     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/monopoly","root","");  
            //     String query = "select task from chance where cid="+task;
            //     Statement stmt=con.createStatement(); 
            //     ResultSet rs=stmt.executeQuery(query);  
            //     while(rs.next())
            //     {
            //         work = rs.getString(1); 
            //     }
            //     con.close();  
           
            // }catch(Exception ex){ System.out.println(ex);} 
            work=ch.CH[task-100];
            chance(task,turn,m,players,1);
        }
        if(p[turn]==23||p[turn]==15||p[turn]==2)
        {
            //connecting to mySQl XAMPP - incomplete
            // try{  
            //     Class.forName("com.mysql.jdbc.Driver");  
                
            //     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/monopoly","root","");  
            //     Statement stmt=con.createStatement(); 
            //     String query = "select work from CommunityChest where Cid="+task;
            //     ResultSet rs=stmt.executeQuery(query);  
            //     while(rs.next())
            //     {
            //         work = rs.getString(1); 
            //     }
            //     con.close();  
           
            // }catch(Exception ex){ System.out.println(ex);}
            work=cc.CC[task-100];
            communityChest(task,turn,m,players,1); 
        }
        // shows info of current city + recent player in it
        // city.setText(c.C[p[turn]]+"\n"+players[turn].getText());
        // sets location of piece of player with current turn
        pieces[turn].setLocation(xy.x[turn][p[turn]],xy.y[turn][p[turn]]);
        //connecting to mySQl XAMPP - incomplete
        // try{  
        //     Class.forName("com.mysql.jdbc.Driver");  
            
        //     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/monopoly","root","");  
        //     Statement stmt=con.createStatement(); 
        //     String query = "select pid,rent from owns,land where owns.lid="+p[turn]+" and owns.lid=land.lid";
        //     String query1 = "insert into moves values("+moveNumber+","+turn+","+sumDice+","+p[turn]+")";
        //     con.prepareStatement(query1).execute();
            
        //     ResultSet rs=stmt.executeQuery(query);  
        //     while(rs.next())
        //     {
        //         rent = rs.getInt(2);
        //         play=rs.getInt(1); 
        //     }
              
        //     con.close();  
       
        // }catch(Exception ex){ System.out.println(ex);} 
        rent=c.R[p[turn]];
        play=own.O[p[turn]];
        if(play==turn&&m[turn]>=500&&houseBuilt[p[turn]]==0)
        {
            amt=m[turn];
            build.setEnabled(true);
            currentStatus.setText("<html><h2>"+"you landed on"+c.C[p[turn]]+"</h2><br>"+"<h2>you can build a house</h2>");
        }
        else if(play>-1)
        {
            buy.setEnabled(false);
            m[turn]=m[turn]-rent;
            amt=m[turn];
            m[play]=m[play]+rent;
            what="<br>you paid Rs"+rent+" to "+name[play]+" as rent";
        }
        else
        {
            if(p[turn]==8)
            {
                m[turn]=m[turn]-500;
            }
            if(p[turn]==4)
            {
                m[turn]=m[turn]-250;
            }
            if(flag==1)
            {
                m[turn]=m[turn]+500;
                flag=0;
            }
            if(p[turn]==24)
            {
                m[turn]=m[turn]-500;
                pieces[turn].setLocation(xy.x[turn][8],xy.y[turn][8]);
                p[turn]=8;
                where="<html><h2>You landed on Go to Jail<br>So you have been arrested<br>Rs 500 has been debited</h2>";
            }
            amt=m[turn];
            //connecting to mySQl XAMPP - incomplete
            // try{  
            //     Class.forName("com.mysql.jdbc.Driver");  
            //     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/monopoly","root","");  
            //     String query = "update players set amount ="+amt+" where pid="+turn;
            //     con.prepareStatement(query).execute();
            //     con.close();  
            //     }catch(Exception ex){ System.out.println(ex);}
                players[turn].setText(name[turn]+"("+amt+")");
        }
           if(play>-1)
           {
                players[turn].setText(name[turn]+"("+amt+")");
                //connecting to mySQl XAMPP - incomplete
                // try{  
                //     Class.forName("com.mysql.jdbc.Driver");  
                //     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/monopoly","root","");  
                //     String query = "update players set amount ="+amt+" where pid="+turn;
                //     con.prepareStatement(query).execute();
                //     con.close();  
                //     }catch(Exception ex){ System.out.println(ex);}  
                players[play].setText(name[play]+"("+m[play]+")");
                //connecting to mySQl XAMPP - incomplete
                // try{  
                //     Class.forName("com.mysql.jdbc.Driver");  
                //     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/monopoly","root","");  
                //     String query = "update players set amount ="+m[play]+" where pid="+play;
                //     con.prepareStatement(query).execute();
                //     con.close();  
                //     }catch(Exception ex){ System.out.println(ex);}  
           }
           if(play!=turn){
            currentStatus.setText("<html><h2>"+where+what+"</h2><br>"+"<h2>"+work+"</h2>");
           }
           for(int j=0;j<NoP;j++)
           {
               if(m[j]<=0)
               {
                    for(int i=0;i<own.O.length;i++)
                    {
                        if(own.O[i]!=-1)
                        {
                            m[own.O[i]]+=c.P[i];
                        }
                    }
                    int max=0;
                    for(int i=0;i<NoP;i++)
                    {
                        if(m[i]>m[max])
                        {
                            max=i;
                        }
                    }
                    JOptionPane P=new JOptionPane(name[j]+"is bankrupt\n"+"game ended\n"+name[max]+" is the winner");
                    JDialog D=P.createDialog(null,"MONOPOLY");
                    D.setLocation(1150,500);
                    D.setFont(f);
                    D.setVisible(true);
                    System.exit(0);
               }
           }
        repaint();
        
    }
    void set2()
    {

        for(int i=0;i<NoP;i++)
        {
            players[i]=new JButton(name[i]+"("+m[i]+")");
            players[i].setVisible(true);
            players[i].setSize(240,40);
            players[i].setCursor(cur);
            players[i].setLocation(50,400+(i*60));
            players[i].setForeground(Color.RED);
            players[i].setForeground(Color.WHITE);                                      
            players[i].setBorder(BorderFactory.createLineBorder(Color.WHITE,3));
            players[i].setBackground(Color.BLACK); 
            players[i].setFont(f);
            add(players[i]);
            pieces[i]=new JTextArea();
            pieces[i].setBounds(xy.x[i][0],xy.y[i][0],15,15);
            add(pieces[i]);
        }
        pieces[0].setBackground(Color.GREEN);
        pieces[1].setBackground(Color.RED);
        switch(NoP)
        {
            case 3: pieces[2].setBackground(Color.YELLOW);
                    break;
            case 4: pieces[2].setBackground(Color.YELLOW);
                    pieces[3].setBackground(Color.BLUE);
                    break;
            default:break;
        }
        for(int i=0;i<houseBuilt.length;i++)
        {
            houseBuilt[i]=0;
        }
        currentStatus.setBounds(550,150,450,300);
        currentStatus.setVisible(true);
        currentStatus.setForeground(Color.BLACK);
        add(currentStatus);
        info.setBounds(1200,150,150,200);
        info.setBackground(colour);
        info.setBorder(new TitledBorder(new LineBorder(Color.black, 5),"info"));
        Font f22=new Font("TimesRoman",Font.BOLD,15);
        info.setFont(f22);
        info.setText("Click on any city\nfor details");
        add(info);
        // images for places
    cities[1]=new ImageIcon("D:/VS_Code/Sumith/Projects/monopoly/images/MEDIRTERRANEAN AVENUE.png");
    cities[2]=new ImageIcon("D:/VS_Code/Sumith/Projects/monopoly/images/COMMUNITY CHEST.png");
     cities[3]=new ImageIcon("D:/VS_Code/Sumith/Projects/monopoly/images/BALTIC AVENUE.png");
     cities[4]=new ImageIcon("D:/VS_Code/Sumith/Projects/monopoly/images/INCOME TAX.png"); 
     cities[5]=new ImageIcon("D:/VS_Code/Sumith/Projects/monopoly/images/READING RAILROAD.png");
     cities[6]=new ImageIcon("D:/VS_Code/Sumith/Projects/monopoly/images/ORIENTAL AVENUE.png");
     cities[7]=new ImageIcon("D:/VS_Code/Sumith/Projects/monopoly/images/CHANCE.png");
     cities[9]=new ImageIcon("D:/VS_Code/Sumith/Projects/monopoly/images/ST. CHARLES PLACE.png");
     cities[10]=new ImageIcon("D:/VS_Code/Sumith/Projects/monopoly/images/ELECTRIC COMPANY.png");
     cities[11]=new ImageIcon("D:/VS_Code/Sumith/Projects/monopoly/images/STATES AVENUE.png");
     cities[12]=new ImageIcon("D:/VS_Code/Sumith/Projects/monopoly/images/VIRGINIA AVENUE.png");
      cities[13]=new ImageIcon("D:/VS_Code/Sumith/Projects/monopoly/images/PENNSYLVANIA RAILROAD.png");
     cities[14]=new ImageIcon("D:/VS_Code/Sumith/Projects/monopoly/images/ST. JAMES PLACE.png");
     cities[15]=new ImageIcon("D:/VS_Code/Sumith/Projects/monopoly/images/COMMUNITY CHEST 4.png");
     cities[17]=new ImageIcon("D:/VS_Code/Sumith/Projects/monopoly/images/KENTUCKY AVENUE.png");
     cities[18]=new ImageIcon("D:/VS_Code/Sumith/Projects/monopoly/images/CHANCE 2.png");
     cities[19]=new ImageIcon("D:/VS_Code/Sumith/Projects/monopoly/images/INDIANA AVENUE.png");
     cities[20]=new ImageIcon("D:/VS_Code/Sumith/Projects/monopoly/images/ILLIONOIS AVENUE.png");
     cities[21]=new ImageIcon("D:/VS_Code/Sumith/Projects/monopoly/images/B & O RAILROAD.png");
     cities[22]=new ImageIcon("D:/VS_Code/Sumith/Projects/monopoly/images/ATLANTIC AVENUE.png");
     cities[23]=new ImageIcon("D:/VS_Code/Sumith/Projects/monopoly/images/COMMUNITY CHEST 3.png");
     cities[25]=new ImageIcon("D:/VS_Code/Sumith/Projects/monopoly/images/PACIFIC AVENUE.png");
     cities[26]=new ImageIcon("D:/VS_Code/Sumith/Projects/monopoly/images/NORTH CAROLINA AVENUE.png");
     cities[27]=new ImageIcon("D:/VS_Code/Sumith/Projects/monopoly/images/VENTNOR AVENUE.png");
     cities[28]=new ImageIcon("D:/VS_Code/Sumith/Projects/monopoly/images/PENNSYLVANIA AVENUE.png");
     cities[29]=new ImageIcon("D:/VS_Code/Sumith/Projects/monopoly/images/SHORT LINE.png");
     cities[30]=new ImageIcon("D:/VS_Code/Sumith/Projects/monopoly/images/PARK PLACE.png");
     cities[31]=new ImageIcon("D:/VS_Code/Sumith/Projects/monopoly/images/CHANCE 3.png");
        //  setting properties for corner squares of board
        btns[0]=new JButton(go);
        btns[0].setVisible(true);
        btns[0].setSize(100,100);
        btns[0].setCursor(cur);
        btns[0].setForeground(Color.RED);
        btns[0].addActionListener(in); 
        add(btns[0]);

        btns[8]=new JButton(jail);
        btns[8].setVisible(true);
        btns[8].setSize(100,100);
        btns[8].setCursor(cur);
        btns[8].setForeground(Color.RED);
        btns[8].addActionListener(in);
        add(btns[8]);

        btns[16]=new JButton(parking);
        btns[16].setVisible(true);
        btns[16].setSize(100,100);
        btns[16].setCursor(cur);
        btns[16].setForeground(Color.RED);
        btns[16].addActionListener(in);
        add(btns[16]);

        btns[24]=new JButton(goTojail);
        btns[24].setVisible(true);
        btns[24].setSize(100,100);
        btns[24].setCursor(cur);
        btns[24].setForeground(Color.RED);
        btns[24].addActionListener(in);
        add(btns[24]);
        // creating non corner places
        for(int i=1;i<8;i++)
        {
            if(i==1)
            {
                btns[i]=new JButton(cities[i]);
                btns[i].setVisible(true);
                btns[i].setSize(70,100);
                btns[i].setCursor(cur);
                btns[i].addActionListener(in);
                btns[i].setForeground(Color.RED);
                add(btns[i]);
            }
            else
            {
                btns[i]=new JButton(cities[i]);
                btns[i].setVisible(true);
                btns[i].setSize(70,100);
                btns[i].setCursor(cur);
                btns[i].addActionListener(in);
                btns[i].setForeground(Color.RED);
                add(btns[i]);
            }
        }
        for(int i=9;i<16;i++)
        {
            btns[i]=new JButton(cities[i]);
            btns[i].setVisible(true);
            btns[i].setSize(100,70);
            btns[i].setCursor(cur);
            btns[i].addActionListener(in);
            btns[i].setForeground(Color.RED);
            add(btns[i]);
        }
        for(int i=17;i<24;i++)
        {
            btns[i]=new JButton(cities[i]);
            btns[i].setVisible(true);
            btns[i].setSize(70,100);
            btns[i].setCursor(cur);
            btns[i].addActionListener(in);
            btns[i].setForeground(Color.RED);
            add(btns[i]);
        }
        for(int i=25;i<32;i++)
        {
            btns[i]=new JButton(cities[i]);
            btns[i].setVisible(true);
            btns[i].setSize(100,70);
            btns[i].setCursor(cur);
            btns[i].addActionListener(in);
            btns[i].setForeground(Color.RED);
            add(btns[i]);
        }
        //  setting locations for all the city buttons
        for(int i=0;i<9;i++)
        {
            if(i==0)
            {
                btns[i].setLocation(400,100);
            }
            else
            {
                btns[i].setLocation(500+(i-1)*70,100);
                if(i<7)
                {
                    house[i]=new JLabel();
                    house[i].setBounds(xy.x[3][i]-10,xy.y[3][i]+5,10,10);
                    add(house[i]);
                    owns[i]=new JLabel();
                    owns[i].setBounds(500+(i-1)*70,200,70,10);
                    add(owns[i]);
                }
            }
        }
        for(int i=9;i<17;i++)
        {
            if(i<16)
            {
                house[i]=new JLabel();
                house[i].setBounds(xy.x[3][i],xy.y[3][i]-10,10,10);
                add(house[i]);
                owns[i]=new JLabel();
                owns[i].setBounds(980,200+(i-9)*70,10,70);
                add(owns[i]);
            }
            if(i==9)
            {
                btns[i].setLocation(990,200);
            }
            else
            {
                btns[i].setLocation(990,200+(i-9)*70);
            }
        }
        for(int i=17;i<24;i++)
        {
            house[i]=new JLabel();
            house[i].setBounds(xy.x[3][i]+10,xy.y[3][i],10,10);
            add(house[i]);
            owns[i]=new JLabel();
            owns[i].setBounds(920-(i-17)*70,680,70,10);
            add(owns[i]);
            if(i==17)
            {
                btns[i].setLocation(920,690);
            }
            else
            {
                btns[i].setLocation(920-(i-17)*70,690);
            }
        }
        for(int i=24;i<32;i++)
        {
            if(i==24)
            {
                btns[i].setLocation(400,690);
            }
            else
            {
                btns[i].setLocation(400,690-(i-24)*70);
                house[i]=new JLabel();
                house[i].setBounds(xy.x[3][i]+5,xy.y[3][i]+10,10,10);
                add(house[i]);
                    owns[i]=new JLabel();
                    owns[i].setBounds(500,690-(i-24)*70,10,70);
                    add(owns[i]);
            }
        }
        buy.setForeground(Color.WHITE);                                      
        buy.setBorder(BorderFactory.createLineBorder(Color.WHITE,3));
        buy.setBackground(Color.BLUE);
        build.setForeground(Color.WHITE);                                      
        build.setBorder(BorderFactory.createLineBorder(Color.WHITE,3));
        build.setBackground(Color.BLUE);
        roll.setForeground(Color.WHITE);                                      
        roll.setBorder(BorderFactory.createLineBorder(Color.WHITE,3));
        roll.setBackground(Color.BLUE);
        // end turn and end game buttons
        game[1]=new JButton("end turn");
        game[1].setVisible(true);
        game[1].setSize(180,30);
        game[1].setCursor(cur);
        game[1].setLocation(1200,700);
        game[1].setForeground(Color.RED);
        game[1].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                turn=(turn+1)%NoP;
                buy.setEnabled(false);
                build.setEnabled(false);
            }
        });
        add(game[1]);
        game[0]=new JButton("end game");
        game[0].setVisible(true);
        game[0].setSize(180,30);
        game[0].setCursor(cur);
        game[0].setLocation(1200,750);
        game[0].setForeground(Color.RED);
        game[0].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                for(int i=0;i<own.O.length;i++)
                {
                    if(own.O[i]!=-1)
                    {
                        m[own.O[i]]+=c.P[i];
                    }
                }
                int max=0;
                for(int i=0;i<NoP;i++)
                {
                    if(m[i]>m[max])
                    {
                        max=i;
                    }
                }
                JOptionPane.showMessageDialog(null,"game ended\n"+name[max]+" is the winner", "MONOPOLY",JOptionPane.PLAIN_MESSAGE);
                System.exit(0);
            }
        });;
        add(game[0]);
        game[0].setForeground(Color.WHITE);                                      
        game[0].setBorder(BorderFactory.createLineBorder(Color.WHITE,3));
        game[0].setBackground(Color.BLUE);
        game[1].setForeground(Color.WHITE);                                      
        game[1].setBorder(BorderFactory.createLineBorder(Color.WHITE,3));
        game[1].setBackground(Color.BLUE);
        // dice rolling button
        roll.setVisible(true);
        roll.setSize(210,30);
        roll.setCursor(cur);
        roll.setLocation(640,650);
        // roll.setForeground(Color.RED);
        roll.addActionListener(this);
        add(roll);
        // buy button
        buy.setVisible(true);
        buy.setSize(80,30);
        buy.setCursor(cur);
        buy.setLocation(1235,360);
        build.setVisible(true);
        build.setSize(80,30);
        build.setCursor(cur);
        build.setLocation(1235,400);
        build.setEnabled(false);
        build.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                house[p[turn]].setOpaque(true);
                house[p[turn]].setBackground(Color.BLACK);
                m[turn]=m[turn]-500;
                c.R[p[turn]]=c.R[p[turn]]*2;
                houseBuilt[p[turn]]=1;
                currentStatus.setText("<html><h2>you built a house at "+c.C[p[turn]]+"<h2>");
                players[turn].setText(name[turn]+"("+m[turn]+")");
                build.setEnabled(false);
            }
        });
        // buy.setForeground(Color.RED);
        buy.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                int cost=0;
                int play=-1;
                //connecting to mySQl XAMPP - incomplete
                // try{  
                //     Class.forName("com.mysql.jdbc.Driver");  
                //     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/monopoly","root","");  
                //     Statement stmt=con.createStatement();
                //     String query = "select landprice from land where lid="+p[turn];
                //     String query1 = "insert into owns values("+turn+","+p[turn]+");";
                //     String query2 = "select pid from owns where lid="+p[turn];
                //     // con.prepareStatement(query).execute();
                //     ResultSet rs=stmt.executeQuery(query);
                //     while(rs.next())
                //     {
                //         cost=rs.getInt(1);
                //     }
                //     ResultSet rs1=stmt.executeQuery(query2);
                //     while(rs1.next())
                //     {
                //         play=rs1.getInt(1);
                //     }
                //     if(play>-1)
                //     {
                //         System.out.println("already sold");
                //     }
                //     else
                //     {
                //         con.prepareStatement(query1).execute();
                //     }
                //     con.close();  
                //     }catch(Exception ex){ System.out.println(ex);}
                //today
                cost=c.P[p[turn]];
                play=own.O[p[turn]];
                    int amt=0;
                    if(play>-1)
                    {
                        amt=m[turn];
                    }
                    else
                    {
                        own.O[p[turn]]=turn;
                        m[turn]=m[turn]-cost;
                        amt=m[turn];
                        currentStatus.setText("<html><h2>You bought "+c.C[p[turn]]+"</h2>");
                        switch(turn)
                        {
                            case 0 : owns[p[turn]].setBackground(Color.GREEN);
                                     owns[p[turn]].setOpaque(true);
                                     break;
                            case 1 : owns[p[turn]].setBackground(Color.RED);
                                     owns[p[turn]].setOpaque(true);
                                     break;
                            case 2 : owns[p[turn]].setBackground(Color.YELLOW);
                                     owns[p[turn]].setOpaque(true);
                                     break;
                            case 3 : owns[p[turn]].setBackground(Color.BLUE);
                                     owns[p[turn]].setOpaque(true);
                                     break;
                        }
                    }
                    players[turn].setText(name[turn]+"("+m[turn]+")");
                    // try{  
                    //     Class.forName("com.mysql.jdbc.Driver");  
                    //     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/monopoly","root","");  
                        // String query = "update players set amount ="+amt+" where pid="+turn;
                    //     con.prepareStatement(query).execute();
                    //     con.close();  
                    //     }catch(Exception ex){ System.out.println(ex);} 
                    players[turn].setText(name[turn]+"("+m[turn]+")");
                    buy.setEnabled(false);
            } 
        });
        buy.setEnabled(false);
        add(buy);
        add(build);
        game[0].setFont(f);
        game[1].setFont(f);
        buy.setFont(f);
        build.setFont(f);
        roll.setFont(f);
        // title and icon for frame
        this.setTitle("monopoly game");                                        
        this.setIconImage(icon.getImage()); 
        setSize(1500, 1500);
        ImageIcon dice1=new ImageIcon(getClass().getResource("face1.png"));
        ImageIcon dice2=new ImageIcon(getClass().getResource("face2.png"));
        f1=new JLabel(dice1);
        f2=new JLabel(dice2);
        //creating labels to display dice faces
        f1.setBounds(675,550,50,50);
        f2.setBounds(765,550,50,50);
        add(f1);
        add(f2);   
    }
}
// class that has action listener for city and player buttons
class information implements ActionListener
{
    // cities c=new cities();
    public void actionPerformed(ActionEvent e)
    {
        String city="";
        String owner="None";
        int rent=-1,price=-1;
        int owns=-1;
        for(int i=0;i<32;i++)
        {
            if((AbstractButton) e.getSource()==board.btns[i])
            {
                price=board.c.P[i];
                rent=board.c.R[i];
                city=board.c.C[i];
                owns=board.own.O[i];
                if(owns!=-1)
                {
                    owner=board.name[owns];
                }
                board.info.setText(city+"\nprice = Rs"+price+"\nrent = Rs"+rent+"\nowner - "+owner);
                break;
                //connecting to mySQl XAMPP - incomplete
                // try{  
                //     Class.forName("com.mysql.jdbc.Driver");  
                //     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/monopoly","root","");  
                //     String query = "select landprice,rent from land where lid="+i;
                //     String query1 = "select pid from owns where lid="+i;
                //     Statement stmt=con.createStatement(); 
                //     ResultSet rs=stmt.executeQuery(query);  
                //     while(rs.next())
                //     {
                //         price = rs.getInt(1); 
                //         rent = rs.getInt(2); 
                //     }
                //     ResultSet rs1=stmt.executeQuery(query1);  
                //     while(rs1.next())
                //     {
                //         owns = rs1.getInt(1);  
                //     }
                //     if(owns!=-1)
                //     {
                //         owner=board.name[owns];
                //     }
                //     con.close();  
                //     }catch(Exception ex){ System.out.println(ex);} 
            }
        }
    }
}
// class boardMain
// {
//     public static void main(String[] args) 
//     {
//         // board b=new board("p1","p2");
//         // board b=new board("p1","p2","p3");
//         board b=new board("p1","p2","p3","p4");
//     }
// }