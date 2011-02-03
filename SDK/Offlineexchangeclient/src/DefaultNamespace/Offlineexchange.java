package DefaultNamespace;
import java.io.*;

import javax.swing.JFileChooser;
public class Offlineexchange {
	public static void main(String[] args) throws Exception
	{
		boolean check;
		AuthenticateServiceLocator loc = new AuthenticateServiceLocator();
		Authenticate authen = loc.getAuthenticate();
		//Scanner in = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter the Username  ");
		String user = br.readLine();
		System.out.println("Enter the Password  ");
		String pwd = br.readLine();
		check = authen.authentication(user, pwd);
		if(check == true)
		{
			System.out.println("login successfull ");
			System.out.println(" 1) Request Patient Data");
			System.out.println(" 2) Send Patient Data");
			System.out.println(" 3) Exit");
			boolean quit = false;
			do
			{
				
			  System.out.println("Enter the choice ");
			  String option = br.readLine();
			  int choice = Integer.parseInt(option.trim());
			  switch(choice)
			  {
			  case 1:
				    System.out.println("Enter the Partner Name");
				    String partner = br.readLine();
				    System.out.println("Patient Details");
				    System.out.println("Enter the FirstName");
				    String firstname = br.readLine();
				    System.out.println("Enter the LastName");
				    String lastname = br.readLine();
				    System.out.println("Enter the Age");
				    String age = br.readLine();
				    System.out.println("Enter the Sex");
				    String sex = br.readLine();
				    AuthenticateServiceLocator loc2 = new AuthenticateServiceLocator();
				    Authenticate db1 = loc2.getAuthenticate();
				    db1.sendemail(partner, firstname, lastname, age, sex);
				   // Requestpatientdata req = new Requestpatientdata();
				   // req.requestpatient(partner, firstname, lastname, age, sex);
				    
				    break;
			  case 2:
				    
				    
				    System.out.println("Enter the partner name");
				    String partner_ = br.readLine();
				   // System.out.println("");
				    final JFileChooser choose = new JFileChooser();
					  choose.showOpenDialog(null);
					    File selFile = choose.getSelectedFile();
					    String filename = selFile.getName();
				        	  
				      FileInputStream fis = new FileInputStream(selFile);
				      //System.out.println(file.exists() + "!!");
				      //InputStream in = resource.openStream();
				      //int size = fis.read(b)
				      ByteArrayOutputStream bos = new ByteArrayOutputStream();
				      byte[] buf = new byte[1024];
				      
				          for (int readNum; (readNum = fis.read(buf)) != -1;) {
				              bos.write(buf, 0, readNum); //no doubt here is 0
				              //Writes len bytes from the specified byte array starting at offset off to this byte array output stream.
				              //System.out.println("read " + readNum + " bytes,");
				          }
				      
				      byte[] bytes = bos.toByteArray();
				      AuthenticateServiceLocator loc1 = new AuthenticateServiceLocator();
				      Authenticate ch = loc1.getAuthenticate();
				      ch.uplaod(bytes, filename, partner_);
				    break;
			  case 3: 
				  quit = true;
				  break;
			  default:
				   System.out.println("please select the correct choice");
				  
			  }
			   
			  
			}while(!quit);
			
		    	
			
		}
		else
		{
			System.out.println("unsuccessfull ");
		}
	}


}
