import java.sql.*;
import java.util.*;
import java.sql.DriverManager;
public class MulesoftTask{
    public static void main(String[] args)
    {
                 Scanner sc = new Scanner(System.in);
                 try 
                 {
                       Class.forName("org.sqlite.JDBC");
                       Connection con = DriverManager.getConnection("jdbc:sqlite:movie.db");
                       if(con!=null)
                        {
                             Statement stmt = con.createStatement();
                           //Inserting Statements
                           stmt.executeUpdate("create table Movies(name text primary key,actor text,actress text,director text,year int)");
                           System.out.println("table created");
                           PreparedStatement pstmt = con.prepareStatement("insert into Movies values(?,?,?,?,?)");
                           System.out.println("Enter number of Insertions");
                           int count=sc.nextInt();
                           for(int i=0;i<count;i++) 
                           {
                           System.out.println("Enter the Movie Name");
                           String name = sc.next();
                           System.out.println("Enter the Movie Actor");
                           String actor = sc.next();
                           System.out.println("Enter the Movie Actress");
                           String actress = sc.next();
                           System.out.println("Enter the Movie Director");
                           String director = sc.next();
                           System.out.println("Enter the Year of Release");
                           int year = sc.nextInt();  
                           pstmt.setString(1,name);
                           pstmt.setString(2,actor);
                           pstmt.setString(3,actress);
                           pstmt.setString(4,director);
                           pstmt.setInt(5,year);
                           }
//                           Update record
                           String sql = "update Movies set actor='' where name='CaptainMarvel'";
                           stmt.executeUpdate(sql);
//                           Delete record
                           String sql1 = "delete from Movies where name='IronMan2'";
                           stmt.executeUpdate(sql1);
//                           retrieving table
                           PreparedStatement pstmt1 = con.prepareStatement("select * from Movies");
                           ResultSet result = pstmt1.executeQuery();
                           System.out.println("name \t\t actor \t\t actress \t\t director\tyear");
                           System.out.println("----------------------------------------------------------------------------------");
                            while(result.next())
                            {
                               System.out.println(result.getString(1)+"\t\t"+result.getString(2)+"\t\t"+result.getString(3)+"\t"+result.getString(4)+"\t"+result.getInt(5));
                            }
                           con.close();
                        }
      }
      
      catch(Exception e) {
        System.out.println(e);
      }
    }
  }