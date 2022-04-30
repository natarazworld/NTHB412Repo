package com.nt.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class CompanyDAOImpl implements ICompanyDAO {

	@Override
	public void saveData() {
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try(ses){
              //read image file content to byte[]			  
			File file1=new File("G:\\Worskpaces\\Hibernate\\NTHB412\\HBProj61Anno-WorkingWithLOBS\\src\\main\\java\\LOBS\\deepu.jpeg");
			InputStream is=new FileInputStream(file1);
			byte[] imageContent=new byte[(int) file1.length()];
			 is.read(imageContent);
			
			 //read text file content to char[]
			File file2=new File("G:\\Worskpaces\\Hibernate\\NTHB412\\HBProj61Anno-WorkingWithLOBS\\src\\main\\java\\LOBS\\resume.txt");
			Reader reader=new FileReader(file2);
			char resumeContent[]=new char[(int) file2.length()];
		    reader.read(resumeContent);
		    //prepare Entity class obj
		    Employee emp=new Employee();
		    emp.setEmpName("raja"); emp.setEmpSalary(9000.0f);
		    emp.setEmpPhoto(imageContent); emp.setEmpResume(resumeContent);
		    
			tx=ses.beginTransaction();
			 int idVal=(int) ses.save(emp);
			tx.commit();
			System.out.println("Object is saved with the idValue::"+idVal);
		}
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("Object is not saved");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void loadData() {
		Session ses=HibernateUtil.getSession();
		try(ses){
			Employee  e=ses.get(Employee.class, 161);
			if(e==null) {
				System.out.println("Employee not found");
				return ;
			}
			else {
				System.out.println(e.getEmpNo()+"  "+e.getEmpName()+"  "+e.getEmpSalary());
				byte[] photoContent=e.getEmpPhoto();
				char[]  resumeContent=e.getEmpResume();
				//create output stream pointing to  dest file
				OutputStream os=new FileOutputStream("new_pict.jpg");
				os.write(photoContent);
				os.flush();
				os.close();
				//create Writer stream pointing to  dest file
				Writer writer=new FileWriter("new_resume.txt");
				writer.write(resumeContent);
				writer.flush();
				writer.close();
				System.out.println("LOBs are retrieved  successfully");
			}
			
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}//method

	
	
}//class
