package Projet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class MemberDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	String user = "C##FIRSTPROJ";
	String password = "FIRSTPROJ";

	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	
	
	
	
	
	
	
	
	
	
	
	

	public ArrayList<MemberVo> list(String id) {
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();

		try {
			connDB();

			String query = "SELECT * FROM ZOOLOGIN ";
			if (id != null) {
				query += " where id =TRIM('" + id + "')";
			}

			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());

			if (rs.getRow() == 0) {
				System.out.println("0 row selected...");
			} else {
				System.out.println(rs.getRow() + " rows selected...");
				rs.previous();
//				rs.first();
				while (rs.next()) {
					String sh = rs.getString("id");
					String Password = rs.getString("Password");

					MemberVo data = new MemberVo(sh, Password);
					list.add(data);
					
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public void connDB() {
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.");
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			System.out.println("statement create success.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<MemberVo> listname(String image_id) {
		ArrayList<MemberVo> listname = new ArrayList<MemberVo>();

		try {
			connDB2();

			String query = "SELECT * FROM IMAGES ";
			System.out.print(query);
			if (image_id != null) {
				query += " where image_id =TRIM('" + image_id + "')";
			}

			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());

			if (rs.getRow() == 0) {
				System.out.println("0 row selected...");
			} else {
				System.out.println(rs.getRow() + " rows selected...");
				rs.previous();
//				rs.first();
				while (rs.next()) {
					String sh = rs.getString("image_id");
					String idata = rs.getString("image_data");
					String kind = rs.getString("image_kind");
					String line = rs.getString("image_line");

					MemberVo data = new MemberVo(sh,idata ,kind ,line);
					
					listname.add(data);
			
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listname;
	}

	public void connDB2() {
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.");
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			System.out.println("statement create success.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	public ArrayList<MemberVo> listcalc(String calc_y,String calc_m,String calc_d,String time) {
		ArrayList<MemberVo> listcalc = new ArrayList<MemberVo>();
		try {
			connDB3();

			String query = "SELECT * FROM ZooCale ";
			System.out.print(query);
			if (calc_d != null) {
				query += " where   dd =TRIM('" + calc_d + "') AND mm=TRIM('"+ calc_m + "')AND TIME=TRIM('"+ time + "')";
			}

			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());

			if (rs.getRow() == 0) {
				System.out.println("0 row selected...");
			} else {
				System.out.println(rs.getRow() + " rows selected...");
//				rs.previous();
				rs.beforeFirst();
				while (rs.next()) {
					String yy = rs.getString("yy");
					String mm = rs.getString("mm");
					String dd = rs.getString("dd");
					String timeget1=rs.getString("TIME");
					
					String titel = rs.getString("titel");
					String contents = rs.getString("contents");
					

					MemberVo data = new MemberVo(yy,mm ,dd,titel,timeget1,contents);
					
					listcalc.add(data);
			
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listcalc;
	}
	

	public void connDB3() {
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.");
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			System.out.println("statement create success.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	

	
	
	
	
	

	
	

	
	
	

	




	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public  void insertForStatement(String ID,String PASSWORD) {
		 try {
	         Class.forName(driver);
	         System.out.println("jdbc driver loading success.");
	         Connection conn = DriverManager.getConnection(url, user, password);
	         System.out.println("oracle connection success.\n");
	         Statement stmt = conn.createStatement();
	         
		         
		         String sql2 = "INSERT INTO ZOOLOGIN VALUES ('" +ID + "','" + PASSWORD + "')";
	         System.out.println(sql2);
	         
	        
	         
	        boolean b =stmt.execute(sql2);
	        if (!b) {
	            System.out.println("Insert success.\n");
	         } else {
	            System.out.println("Insert fail.\n");
	         }

	     


	      } catch (ClassNotFoundException e) {
	         System.out.println(e);
	      } catch (SQLException e) {
	         System.out.println(e);
	      }

	   }
	
	public  void correction(String line) {
		 try {
	         Class.forName(driver);
	         System.out.println("jdbc driver loading success.");
	         Connection conn = DriverManager.getConnection(url, user, password);
	         System.out.println("oracle connection success.\n");
	         Statement stmt = conn.createStatement();
	         
	         
	         String sql2 = "UPDATE  images SET image_line = '" +line + "'";
	         System.out.println(sql2);
	         
	        
	         
	        boolean b =stmt.execute(sql2);
	        if (!b) {
	            System.out.println("Insert success.\n");
	         } else {
	            System.out.println("Insert fail.\n");
	         }

	     


	      } catch (ClassNotFoundException e) {
	         System.out.println(e);
	      } catch (SQLException e) {
	         System.out.println(e);
	      }

	   }
	
	
	
	public  void del(String delt) {
		 try {
	         Class.forName(driver);
	         System.out.println("jdbc driver loading success.");
	         Connection conn = DriverManager.getConnection(url, user, password);
	         System.out.println("oracle connection success.\n");
	         Statement stmt = conn.createStatement();
	         
	         
	         String sql2 = "DELETE FROM  images WHERE image_ID = '" +delt + "'";
	         System.out.println(sql2);
	         
	        
	         
	        boolean b =stmt.execute(sql2);
	        if (!b) {
	            System.out.println("Insert success.\n");
	         } else {
	            System.out.println("Insert fail.\n");
	         }

	     


	      } catch (ClassNotFoundException e) {
	         System.out.println(e);
	      } catch (SQLException e) {
	         System.out.println(e);
	      }

	   }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void Filein(String image_id,String image_data,String image_kind,String image_line)  {
			 try {
		         Class.forName(driver);
		         System.out.println("jdbc driver loading success.");
		         Connection conn = DriverManager.getConnection(url, user, password);
		         System.out.println("oracle connection success.\n");
		         Statement stmt = conn.createStatement();
		         
		         
		         String sql2 = "INSERT INTO images VALUES ('" +image_id + "','" + image_data + "','"+image_kind+"','"+image_line+"')";
		         
		         System.out.println(sql2);
		         
		        
		         
		        boolean b =stmt.execute(sql2);
		        if (!b) {
		            System.out.println("Insert success.\n");
		         } else {
		            System.out.println("Insert fail.\n");
		         }

		     


		      } catch (ClassNotFoundException e) {
		         System.out.println(e);
		      } catch (SQLException e) {
		         System.out.println(e);
		      }

		   }
		
		
	




public  void timein(String yy,String mm,String dd, String time,String inday,String conin) {
	 try {
        Class.forName(driver);
        System.out.println("jdbc driver loading success.");
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println("oracle connection success.\n");
        Statement stmt = conn.createStatement();
        
        
        String sql2 = "UPDATE  zoocale SET YY='" +yy + "',MM='" +mm + "',DD='" +dd + "',TIME='" +time + "',TITEL='" +inday + "',contents='" +conin+ "'";
        System.out.println(sql2);
        
       
        
       boolean b =stmt.execute(sql2);
       if (!b) {
           System.out.println("Insert success.\n");
        } else {
           System.out.println("Insert fail.\n");
        }

    


     } catch (ClassNotFoundException e) {
        System.out.println(e);
     } catch (SQLException e) {
        System.out.println(e);
     }

  }



public  void deltcal(String delt) {
	 try {
        Class.forName(driver);
        System.out.println("jdbc driver loading success.");
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println("oracle connection success.\n");
        Statement stmt = conn.createStatement();
        
        
        String sql2 = "DELETE FROM  zoocale WHERE titel = '" +delt + "'";
        System.out.println(sql2);
        
       
        
       boolean b =stmt.execute(sql2);
       if (!b) {
           System.out.println("Insert success.\n");
        } else {
           System.out.println("Insert fail.\n");
        }

    


     } catch (ClassNotFoundException e) {
        System.out.println(e);
     } catch (SQLException e) {
        System.out.println(e);
     }

  }





public  void insult(String yy,String mm,String dd, String time,String inday,String conin) {
	 try {
       Class.forName(driver);
       System.out.println("jdbc driver loading success.");
       Connection conn = DriverManager.getConnection(url, user, password);
       System.out.println("oracle connection success.\n");
       Statement stmt = conn.createStatement();
       
       
       String sql2 = " INSERT INTO zoocale VALUES ('" +yy + "','" + mm + "','"+dd+"','"+time+"','"+inday+"','"+conin+"')";
       System.out.println(sql2);
       
      
       
      boolean b =stmt.execute(sql2);
      if (!b) {
          System.out.println("Insert success.\n");
       } else {
          System.out.println("Insert fail.\n");
       }

   


    } catch (ClassNotFoundException e) {
       System.out.println(e);
    } catch (SQLException e) {
       System.out.println(e);
    }

 }

}












