import java.util.*;
class Coursework{
	//clear console
	public final static void clearConsole(){
		try{
			final String os = System.getProperty("os.name");
			if(os.contains("Windows")){
					new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			}else{
					System.out.print("\033[H\033[2J");
					System.out.flush();
			}
		}catch(final Exception e){
		e.printStackTrace();
		//Handle any exceptions.	
		}
	}
	
	//student exists
	public static boolean studentExists(String[] students,String sID){
		for(int i=0;i<students.length;i++){
			if(sID.equals(students[i])){
				return true;
			}
		}
		return false;
	}
	
	//find student
	public static int findStudents(String[] students,String sID){
		int find=0;
		for(int i=0;i<students.length;i++){
			if(sID.equals(students[i])){
				find=i;
			}
		}
		return find;	
	}
	
	//sort programming fundamental marks
	public static String[][] sortStudentsPF(String[][] studentMarks){
		String[][] sortPF=new String[4][studentMarks[0].length];
		for(int i=0;i<sortPF.length;i++){
			for(int j=0;j<sortPF[i].length;j++){
				sortPF[i][j]=studentMarks[i][j];
			}
		}
		for(int i=sortPF[0].length;i>0;i--){
			int min=Integer.valueOf(sortPF[2][0]);
			int index=0;
			for(int j=1;j<i;j++){
				if(Integer.valueOf(sortPF[2][j])<min){
					min=Integer.valueOf(sortPF[2][j]);
					index=j;
				}
			}
			String[] temp=new String[4];
			for(int j=0;j<temp.length;j++){
				temp[j]=sortPF[j][i-1];
				sortPF[j][i-1]=sortPF[j][index];
				sortPF[j][index]=temp[j];
			}
		}
		return sortPF;
	}
	
	//sort DBMS marks
	public static String[][] sortStudentsDBMS(String[][] studentMarks){
		String[][] sortDBMS=new String[4][studentMarks[0].length];
		for(int i=0;i<sortDBMS.length;i++){
			for(int j=0;j<sortDBMS[i].length;j++){
				sortDBMS[i][j]=studentMarks[i][j];
			}
		}
		for(int i=sortDBMS[0].length;i>0;i--){ 
			int min=Integer.valueOf(sortDBMS[3][0]);
			int find=0;
			for(int j=1;j<i;j++){
				if(Integer.valueOf(sortDBMS[3][j])<min){
					min=Integer.valueOf(sortDBMS[3][j]);
					find=j;
				}
			}
			String[] temp=new String[4];
			for(int j=0;j<temp.length;j++){
				temp[j]=sortDBMS[j][i-1];
				sortDBMS[j][i-1]=sortDBMS[j][find];
				sortDBMS[j][find]=temp[j];
			}
		}
		return sortDBMS;
	}
	
	//right align
	public static String rightAlign(String str,String spaces){
		int length=str.length();
		String aligned=spaces;
		for(int i=0;i<length;i++){
			aligned+="\b";
		}
		aligned+=str;
		return aligned;
	}
	
	//left align
	public static String leftAlign(String str,String spaces){
		int length=str.length();
		String aligned=str+spaces;
		for(int i=0;i<length;i++){
			aligned+="\b";
		}
		return aligned;
	}
	
	//sort student rank
	public static String[][] sortStudents(String[][] studentMarks){
		String[][] temp=new String[4][studentMarks[0].length];
		for(int i=0;i<temp.length-2;i++){
			for(int j=0;j<temp[i].length;j++){
				temp[i][j]=studentMarks[i][j];
			}
		}
		for(int i=0;i<temp[0].length;i++){
			int total=Integer.valueOf(studentMarks[2][i])+Integer.valueOf(studentMarks[3][i]);
			temp[2][i]=Integer.toString(total);
			double avg=(double)total/2;
			temp[3][i]=String.format("%.2f",avg);
		}
		for(int i=temp[0].length;i>0;i--){ 
			int min=Integer.valueOf(temp[2][0]);
			int index=0;
			for(int j=1;j<i;j++){
				if(Integer.valueOf(temp[2][j])<min){
					min=Integer.valueOf(temp[2][j]);
					index=j;
				}
			}
			String[] x=new String[4];
			for(int j=0;j<x.length;j++){
				x[j]=temp[j][i-1];
				temp[j][i-1]=temp[j][index];
				temp[j][index]=x[j];
			}
		}
		String[][] sortMarks=new String[5][temp[0].length];
		for(int i=0;i<sortMarks[0].length;i++){	
			sortMarks[0][i]=Integer.toString(i+1);
			for(int j=1;j<sortMarks.length;j++){
				sortMarks[j][i]=temp[j-1][i];
			}
		}
		for(int i=0;i<sortMarks[0].length-1;i++){	
			if(sortMarks[3][i].equals(sortMarks[3][i+1])){
				sortMarks[0][i+1]=sortMarks[0][i];
			}
		}
		return sortMarks;
	}
	
	//ordinal
	public static String ordinal(String rank,int length){
		String ordinal="(";
		int r=Integer.valueOf(rank);
		if(r==length && r!=1){
			ordinal+="Last";
		}else{
			if(r>9 && r<13){
				switch(r){
					case 10 : ordinal+="Tenth";break;
					case 11 : ordinal+="Eleventh";break;
					case 12 : ordinal+="Twelfth";break;
				}
			}else{
				int d1=r%10;
				int d2=(r/10)%10;
				String str1="",str2="";
				switch(d1){
					case 1 : str1+="First";break;
					case 2 : str1+="Second";break;
					case 3 : str1+="Third";break;
					case 4 : str1+="Fourth";break;
					case 5 : str1+="Fifth";break;
					case 6 : str1+="Sixth";break;
					case 7 : str1+="Seventh";break;
					case 8 : str1+="Eighth";break;
					case 9 : str1+="Ninth";break;
					case 0 : str1+="\b\bieth";break;
				}
				switch(d2){
					case 1 : str2+="\b\bteenth";break;
					case 2 : str2+="Twenty ";break;
					case 3 : str2+="Thirty ";break;
					case 4 : str2+="Forty ";break;
					case 5 : str2+="Fifty ";break;
					case 6 : str2+="Sixty ";break;
					case 7 : str2+="Seventy ";break;
					case 8 : str2+="Eighty ";break;
					case 9 : str2+="Ninty ";break;
					case 0 : str2+="";break;
				}
				if(r>10 && r<20){
					ordinal+=str1+str2;
				}else{
					ordinal+=str2+str1;
				}
			}
		}
		ordinal+=")";
		return ordinal;
	}
	
	
	//homepage method
	public static int homePage(){
		Scanner input=new Scanner(System.in);
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("|                   WELCOME TO GDSE MARKS MANAGEMENT SYSTEM                      |");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("[1] Add New Student\t\t\t[2]  Add New Student With Marks");
		System.out.println("[3] Add Marks\t\t\t\t[4]  Update Student Details");
		System.out.println("[5] Update Marks\t\t\t[6]  Delete Student");
		System.out.println("[7] Print Student Details\t\t[8]  Print Student Ranks");
		System.out.println("[9] Best in Programming Fundamentals\t[10] Best in Database Management System");
		System.out.println();
		System.out.print("Enter an option to continue > ");
		int option=input.nextInt();
		clearConsole();
		return option;
	}
	
	//add new student
	public static void addNewStudent(String[][] students,String[][] studentMarks){
		Scanner input=new Scanner(System.in);
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("|                               ADD NEW STUDENT                                  |");
		System.out.println("----------------------------------------------------------------------------------");
		int count=students[0].length;
		String[][] tempStudent=students;
		System.out.print("Enter Student ID : ");
		String sID=input.nextLine(); 
		boolean exists=studentExists(students[0],sID);//pass arguments to student exists method parameters
		while(exists){
			System.out.println("The Student ID already exists");
			System.out.print("\nEnter Student ID   : ");
			sID=input.nextLine();
			exists=studentExists(students[0],sID);//execute exists method again
		}
		students=new String[2][count];
		System.out.print("Enter Student Name : ");
		String sName=input.nextLine();
		count++;
		students=new String[2][count]; 
		students[0][count-1]=sID;
		students[1][count-1]=sName;
		for(int i=0;i<tempStudent.length;i++){
			for(int j=0;j<tempStudent[i].length;j++){
				students[i][j]=tempStudent[i][j];
			}
		}
		System.out.println();
		System.out.print("Student has been added successfully. Do you want to add a new student (y/n): ");
		String option=input.nextLine();
		switch(option){
			case "Y" :
			case "y" :	clearConsole();
						addNewStudent(students,studentMarks);
						break;
			case "N" :
			case "n" :	clearConsole();
						options(students,studentMarks);
						break;
		}
	}
	
	//add new student with marks
	public static void addNewStudentWithMarks(String[][] students,String[][] studentMarks){
		Scanner input = new Scanner(System.in);
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("|                          ADD NEW STUDENT WITH MARKS                            |");
		System.out.println("----------------------------------------------------------------------------------");
		int count=students[0].length;
		int countMarks=studentMarks[0].length;
		String[][] tempStudent=students;
		System.out.print("Enter Student ID : ");
		String sID=input.nextLine(); 
		boolean exists=studentExists(students[0],sID);//pass arguments to student exists method parameters
		while(exists){
			System.out.println("The Student ID already exists");
			System.out.print("\nEnter Student ID   : ");
			sID=input.nextLine();
			exists=studentExists(students[0],sID);//execute exists method again
		}
		count++;
		students=new String[2][count];
		System.out.print("Enter Student Name : ");
		String sName=input.nextLine();
		System.out.println();
		System.out.print("Enter Programming Fundamental Marks : ");
		String proFunMarks=input.nextLine();//pf marks string
		int pfMarks=Integer.valueOf(proFunMarks);//pf marks convert to int
		while(pfMarks<0 || pfMarks>100){
			System.out.println();
			System.out.print("Invalid marks, please enter correct marks.");
			System.out.print("Enter Programming Fundamental Marks : ");
			proFunMarks=input.nextLine();
			pfMarks=Integer.valueOf(proFunMarks);
		}
		System.out.println();
		System.out.print("Enter Database Management System Marks : ");
		String dbmsMarks=input.nextLine();//dbms marks string
		int dbmsMarks2=Integer.valueOf(dbmsMarks);//dbms marks convert to int
		while(dbmsMarks2<0 || dbmsMarks2>100){
			System.out.println();
			System.out.print("Invalid marks, please enter correct marks.");
			System.out.print("Enter Database Management System Marks : ");
			dbmsMarks=input.nextLine();
			dbmsMarks2=Integer.valueOf(dbmsMarks);
		}
		students[0][count-1]=sID;
		students[1][count-1]=sName;
		for(int i=0;i<tempStudent.length;i++){
			for(int j=0;j<tempStudent[i].length;j++){
				students[i][j]=tempStudent[i][j];
			}
		}
		++countMarks;
		String[][] tempMarks=studentMarks;
		studentMarks=new String[4][countMarks];
		studentMarks[0][countMarks-1]=sID;
		studentMarks[1][countMarks-1]=sName;
		studentMarks[2][countMarks-1]=proFunMarks;
		studentMarks[3][countMarks-1]=dbmsMarks;
		for(int i=0;i<tempMarks.length;i++){
			for(int j=0;j<tempMarks[i].length;j++){
				studentMarks[i][j]=tempMarks[i][j];
			}
		}
		tempMarks=studentMarks;
		System.out.println();
		System.out.print("Student has been added successfully. Do you want to add a new student (Y/N)? ");
		String option=input.nextLine();
		switch(option){
			case "Y" :
			case "y" :  clearConsole();
						addNewStudentWithMarks(students,studentMarks);
						break;
			case "N" :
			case "n" :  clearConsole();
						options(students,studentMarks);
						break;
		}	
	}
	
	//add marks
	public static void addMarks(String[][] students,String[][] studentMarks){
		Scanner input = new Scanner(System.in);
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("|                                   ADD MARKS                                    |");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println();
		System.out.print("Enter Student ID : ");
		String sID=input.nextLine(); 
		boolean exists=studentExists(students[0],sID);
		boolean existMarks=studentExists(studentMarks[0],sID);
		while(!exists){
			System.out.print("Invalid Student ID. Do you want to search again (Y/N)? ");
			String option=input.nextLine();
			switch(option){
				case "Y" :
				case "y" :  break;
				case "N" :
				case "n" :  clearConsole();
							options(students,studentMarks);
							break;
			}
			System.out.print("\nEnter Student ID : ");
			sID=input.nextLine();
			exists=studentExists(students[0],sID);
			existMarks=studentExists(studentMarks[0],sID);
		}
		if(existMarks){
			int find=findStudents(studentMarks[0],sID);
			System.out.println("Student Name : "+studentMarks[1][find]);
			System.out.println("This student's marks have been already added.");
			System.out.println("If you want to update the marks, please use [5] Update Marks option.");
			System.out.println();
			System.out.print("Do you want to add marks for another student (Y/N)? ");
			String option=input.nextLine();
			switch(option){
				case "Y" :
				case "y" :  clearConsole();
							addMarks(students,studentMarks);
							break;
				case "N" :
				case "n" :  clearConsole();
							options(students,studentMarks);
							break;
			}
		}else{
			int find=findStudents(students[0],sID);
			System.out.println("Student Name     : "+students[1][find]);
			System.out.println();
			System.out.print("Programming Fundamentals Marks    : ");
			String proFunMarks=input.nextLine();
			int pfMarks=Integer.valueOf(proFunMarks);
			while(pfMarks>100 || pfMarks<0){
				System.out.println("Invalid marks, please enter correct marks.");
				System.out.print("\nProgramming Fundamentals Marks    : ");
				proFunMarks=input.nextLine();
				pfMarks=Integer.valueOf(proFunMarks);
			}
			System.out.print("\nDatabase Management Systems Marks : ");
			String dbmsMarks=input.nextLine();
			int dbms=Integer.valueOf(dbmsMarks);
			while(dbms>100 || dbms<0){
				System.out.println("Invalid marks, please enter correct marks.");
				System.out.print("\nDatabase Management Systems Marks : ");
				dbmsMarks=input.nextLine();
				dbms=Integer.valueOf(dbmsMarks);
			}
			int countMarks=studentMarks[0].length;
			++countMarks;
			String[][] tempMarks=studentMarks;
			studentMarks=new String[4][countMarks];
			studentMarks[0][countMarks-1]=sID;
			studentMarks[1][countMarks-1]=students[1][find];
			studentMarks[2][countMarks-1]=proFunMarks;
			studentMarks[3][countMarks-1]=dbmsMarks;
			for(int i=0;i<tempMarks.length;i++){
				for(int j=0;j<tempMarks[i].length;j++){
					studentMarks[i][j]=tempMarks[i][j];
				}
			}
			tempMarks=studentMarks;
			System.out.print("\nMarks have been added. Do you want to add marks for another student (Y/N)? ");
			String option=input.nextLine();
			switch(option){
				case "Y" :
				case "y" :  clearConsole();
							addMarks(students,studentMarks);
							break;
				case "N" :
				case "n" :  clearConsole();
							options(students,studentMarks);
							break;
			}	
		}
	}
	
	//update details
	public static void updateStudentDetails(String[][] students,String[][] studentMarks){
		Scanner input = new Scanner(System.in);
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("|                             UPDATE STUDENT DETAILS                             |");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println();
		System.out.print("\nEnter Student ID : ");
		String sID=input.nextLine();
		boolean exist=studentExists(students[0],sID);
		boolean existMarks=studentExists(studentMarks[0],sID);
		while(!exist){
			System.out.print("Invalid Student ID. Do you want to search again (Y/N)? ");
			String option=input.nextLine();
			switch(option){
				case "Y" :
				case "y" :  break;
				case "N" :
				case "n" :  clearConsole();
							options(students,studentMarks);
							break;
			}
			System.out.print("\nEnter Student ID : ");
			sID=input.nextLine();
			exist=studentExists(students[0],sID);
			existMarks=studentExists(studentMarks[0],sID);
		}
		int find=findStudents(students[0],sID);
		System.out.println("Student Name     : "+students[1][find]);
		System.out.print("\nEnter the new student name : ");
		String sName=input.nextLine();
		students[1][find]=sName;
		if(existMarks){
			find=findStudents(studentMarks[0],sID);
			studentMarks[1][find]=sName;
		}	
		System.out.println("\nStudent details has been updated successfully.");
		System.out.print("Do you want to update another student detail (Y/N)? ");
		String option=input.nextLine();
		switch(option){
			case "Y" :
			case "y" :  clearConsole();
						updateStudentDetails(students,studentMarks);
						break;
			case "N" :
			case "n" :  clearConsole();
						options(students,studentMarks);
						break;
		}
	}
	
	//update marks
	public static void updateMarks(String[][] students,String[][] studentMarks){
		Scanner input=new Scanner(System.in);
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("|                                   UPDATE MARKS                                  |");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println();
		System.out.print("Enter Student ID : ");
		String sID=input.nextLine();
		boolean exist=studentExists(students[0],sID);
		boolean existMarks=studentExists(studentMarks[0],sID);
		while(!exist){
			System.out.print("Invalid Student ID. Do you want to search again (Y/N)? ");
			String option=input.nextLine();
			switch(option){
				case "Y" :
				case "y" :  break;
				case "N" :
				case "n" :  clearConsole();
							options(students,studentMarks);
							break;
			}
			System.out.print("\nEnter Student ID : ");
			sID=input.nextLine();
			exist=studentExists(students[0],sID);
			existMarks=studentExists(studentMarks[0],sID);
		}
		if(!existMarks){
			int find=findStudents(students[0],sID);
			System.out.println("Student Name     : "+students[1][find]);
			System.out.println("\nThis student's marks yet to be added.");
			System.out.print("Do you want to update the marks of another student (Y/N)? ");
			String option=input.nextLine();
			switch(option){
				case "Y" :
				case "y" :  clearConsole();
							updateMarks(students,studentMarks);
							break;
				case "N" :
				case "n" :  clearConsole();
							options(students,studentMarks);
							break;
			}
		}
		int find=findStudents(studentMarks[0],sID);
		System.out.println("Student Name     : "+studentMarks[1][find]);
		System.out.println("\nProgramming Fundamentals Marks    : "+studentMarks[2][find]);
		System.out.println("Database Management Systems Marks : "+studentMarks[3][find]);
		System.out.print("\nEnter new Programming Fundamentals Marks    : ");
		String proFunMarks=input.nextLine();
		int pfMarks=Integer.valueOf(proFunMarks);
		while(pfMarks>100 || pfMarks<0){
			System.out.println("Invalid marks, please enter correct marks.");
			System.out.print("\nProgramming Fundamentals Marks    : ");
			proFunMarks=input.nextLine();
			pfMarks=Integer.valueOf(proFunMarks);
		}
		System.out.print("Enter new Database Management Systems Marks : ");
		String dbmsMarks=input.nextLine();
		int dbms=Integer.valueOf(dbmsMarks);
		while(dbms>100 || dbms<0){
			System.out.println("Invalid marks, please enter correct marks.");
			System.out.print("\nDatabase Management Systems Marks : ");
			dbmsMarks=input.nextLine();
			dbms=Integer.valueOf(dbmsMarks);
		}
		studentMarks[2][find]=proFunMarks;
		studentMarks[3][find]=dbmsMarks;
		System.out.println("\nMarks have been updated successfully.");
		System.out.print("Do you want to update marks for another student (Y/N)? ");
		String option=input.nextLine();
		switch(option){
			case "Y" :
			case "y" :  clearConsole();
						updateMarks(students,studentMarks);
						break;
			case "N" :
			case "n" :  clearConsole();
						options(students,studentMarks);
						break;
		}
	}
	
	//delete student
	public static void deleteStudent(String[][] students,String[][] studentMarks){
		Scanner input=new Scanner(System.in);
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("|                                 DELETE STUDENT                                  |");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println();
		System.out.print("Enter Student ID : ");
		String sID=input.nextLine();
		boolean exist=studentExists(students[0],sID);
		while(!exist){
			System.out.print("Invalid Student ID. Do you want to search again (Y/N)? ");
			String option=input.nextLine();
			switch(option){
				case "Y" :
				case "y" :  break;
				case "N" :
				case "n" :  clearConsole();
							options(students,studentMarks);
							break;
			}
			System.out.print("\nEnter Student ID : ");
			sID=input.nextLine();
			exist=studentExists(students[0],sID);
		}
		int find=findStudents(students[0],sID);
		int count=students[0].length;
		count--;
		String[][] temp=students;
		students=new String[2][count];
		for(int i=0;i<temp.length;i++){
			for(int j=0,k=0;j<temp[i].length;j++){
				if(j==find){continue;
			}
				students[i][k]=temp[i][j];
				k++;
			}
		}
		boolean existMarks=studentExists(studentMarks[0],sID);
		if(existMarks){
			find=findStudents(studentMarks[0],sID);
			int countMarks=studentMarks[0].length;
			countMarks--;
			String[][] tempMarks=studentMarks;
			studentMarks=new String[4][countMarks];
			for(int i=0;i<tempMarks.length;i++){
				for(int j=0,k=0;j<tempMarks[i].length;j++){
					if(j==find){continue;}
					studentMarks[i][k]=tempMarks[i][j];
					k++;
				}
			}
		}
		System.out.println("Student has been deleted successfully.");
		System.out.print("Do you want to delete another student (Y/N)? ");
		String option=input.nextLine();
		switch(option){
			case "Y" :
			case "y" :  clearConsole();
						deleteStudent(students,studentMarks);
						break;
			case "N" :
			case "n" :  clearConsole();
						options(students,studentMarks);
						break;
		}
	}
	
	//print student details
	public static void printStudentDetails(String[][] students,String[][] studentMarks){
		Scanner input=new Scanner(System.in);
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("|                              PRINTS STUDENT DETAILS                             |");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.print("\nEnter Student ID : ");
		String sID=input.nextLine();
		boolean exist=studentExists(students[0],sID);
		boolean existMarks=studentExists(studentMarks[0],sID);
		while(!exist){
			System.out.print("Invalid Student ID. Do you want to search again (Y/N)? ");
			String option=input.nextLine();
			switch(option){
				case "Y" :
				case "y" :  break;
				case "N" :
				case "n" :  clearConsole();
							options(students,studentMarks);
							break;
			}
			System.out.print("\nEnter Student ID : ");
			sID=input.nextLine();
			exist=studentExists(students[0],sID);
			existMarks=studentExists(studentMarks[0],sID);
		}
		if(!existMarks){
			int index=findStudents(students[0],sID);
			System.out.println("Student Name     : "+students[1][index]);
			System.out.println("\nMarks yet to be added.");
			System.out.print("\nDo you want to search another student\'s details (Y/N)? ");
			String option=input.nextLine();
			switch(option){
				case "Y" :
				case "y" :  clearConsole();
							printStudentDetails(students,studentMarks);
							break;
				case "N" :
				case "n" :  clearConsole();
							options(students,studentMarks);
							break;
			}
		}
		int index=findStudents(studentMarks[0],sID);
		System.out.println("Student Name     : "+studentMarks[1][index]);
		String[][] sortMarks=sortStudents(studentMarks);
		int sortIndex=findStudents(sortMarks[1],sID);
		String ordinal=ordinal(sortMarks[0][sortIndex],sortMarks[0].length);
		System.out.println("+----------------------------------+-----------------------+");
		System.out.println("|Programming Fundamentals Marks    |"+rightAlign(studentMarks[2][index],"                       ")+"|");
		System.out.println("|Database Management Systems Marks |"+rightAlign(studentMarks[3][index],"                       ")+"|");
		System.out.println("|Total Marks                       |"+rightAlign(sortMarks[3][sortIndex],"                       ")+"|");
		System.out.println("|Average Marks                     |"+rightAlign(sortMarks[4][sortIndex],"                       ")+"|");
		System.out.println("|Rank                              |"+rightAlign(sortMarks[0][sortIndex]+ordinal,"                       ")+"|");
		System.out.println("+----------------------------------+-----------------------+");
		System.out.println();
		System.out.print("Do you want to search another student\'s details (Y/N)? ");
		String option=input.nextLine();
		switch(option){
			case "Y" :
			case "y" :  clearConsole();
						printStudentDetails(students,studentMarks);
						break;
			case "N" :
			case "n" :  clearConsole();
						options(students,studentMarks);
						break;
		}
	}
	
	//print student rank
	public static void printStudentRanks(String[][] students,String[][] studentMarks){
		Scanner input=new Scanner(System.in);
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("|                              PRINT STUDENT RANKS                                |");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("+-----+-------+-----------------------+-----------+-------------+");
		System.out.println("|Rank |ID     |Name                   |Total Marks|Average Marks|");
		System.out.println("+-----+-------+-----------------------+-----------+-------------+");
		String[][] sortMarks=sortStudents(studentMarks);
		for(int i=0;i<sortMarks[0].length;i++){
			System.out.print("|"+leftAlign(sortMarks[0][i],"     "));
			System.out.print("|"+leftAlign(sortMarks[1][i],"       "));
			System.out.print("|"+leftAlign(sortMarks[2][i],"                       "));
			System.out.print("|"+rightAlign(sortMarks[3][i],"           "));
			System.out.print("|"+rightAlign(sortMarks[4][i],"             ")+"|\n");
		}
		System.out.println("+-----+-------+-----------------------+-----------+-------------+");
		System.out.println();	
		System.out.print("Do you want to go back to main menu (Y/N)? ");
		String option=input.nextLine();
		switch(option){
			case "Y" :
			case "y" :  clearConsole();
						options(students,studentMarks);
						break;
			default  :  clearConsole();
						printStudentRanks(students,studentMarks);
						break;
		}
	}
	
	//best in PF
	public static void bestInPF(String[][] students,String[][] studentMarks){
		Scanner input=new Scanner(System.in);
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("|                        BEST IN PROGRAMMING FUNDAMENTALS                         |");
		System.out.println("-----------------------------------------------------------------------------------");
		String[][] sortPF=sortStudentsPF(studentMarks);
		System.out.println();
		System.out.println("\n+-----+-------------------------+--------+----------+");
		System.out.println("|ID   |Name                     |PF Marks|DBMS Marks|");
		System.out.println("+-----+-------------------------+--------+----------+");
		for(int i=0;i<sortPF[0].length;i++){	
			System.out.print("|"+leftAlign(sortPF[0][i],"     "));
			System.out.print("|"+leftAlign(sortPF[1][i],"                         "));
			System.out.print("|"+leftAlign(sortPF[2][i],"        "));
			System.out.print("|"+leftAlign(sortPF[3][i],"          ")+"|\n");
		}
		System.out.println("+-----+-------------------------+--------+----------+");
		System.out.print("\nDo you want to go back to main menu (Y/N)? ");
		String option=input.nextLine();
		switch(option){
			case "Y" :
			case "y" :  clearConsole();
						options(students,studentMarks);
						break;
			case "N" :
			case "n" :  clearConsole();
						bestInPF(students,studentMarks);
						break;
		}
	}
	
	//best in DBMS
	public static void bestInDBMS(String[][] students,String[][] studentMarks){
		Scanner input=new Scanner(System.in);
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("|                       BEST IN DATABASE MAMAGEMENT SYSTEMS                       |");
		System.out.println("-----------------------------------------------------------------------------------");
		String[][] sortDBMS=sortStudentsDBMS(studentMarks);
		System.out.println("\n+-----+-------------------------+----------+--------+");
		System.out.println("|ID   |Name\t\t\t|DBMS Marks|PF Marks|");
		System.out.println("+-----+-------------------------+----------+--------+");
		for(int i=0;i<sortDBMS[0].length;i++){	
			System.out.print("|"+leftAlign(sortDBMS[0][i],"     "));
			System.out.print("|"+leftAlign(sortDBMS[1][i],"                         "));
			System.out.print("|"+leftAlign(sortDBMS[3][i],"          "));
			System.out.print("|"+leftAlign(sortDBMS[2][i],"        ")+"|\n");
		}
		System.out.println("+-----+-------------------------+----------+--------+");
		System.out.print("\nDo you want to go back to main menu (Y/N)? ");
		String option=input.nextLine();
		switch(option){
			case "Y" :
			case "y" :  clearConsole();
						options(students,studentMarks);
						break;
			case "N" :
			case "n" :  clearConsole();
						bestInDBMS(students,studentMarks);
						break;
		}	
	}
	
	//option method
	public static void options(String[][] students,String[][] studentMarks){
		int option=homePage();
		switch(option){
				case 1 :
					addNewStudent(students,studentMarks);
					break;
				case 2 :
					addNewStudentWithMarks(students,studentMarks);
					break;
				case 3 :
					addMarks(students,studentMarks);
					break;
				case 4 :
					updateStudentDetails(students,studentMarks);
					break;
				case 5 :
					updateMarks(students,studentMarks);
					break;
				case 6 :
					deleteStudent(students,studentMarks);
					break;
				case 7 :
					printStudentDetails(students,studentMarks);
					break;
				case 8 :
					printStudentRanks(students,studentMarks);
					break;
				case 9 :
					bestInPF(students,studentMarks);
					break;
				case 10 :
					bestInDBMS(students,studentMarks);
					break;
				default :
					options(students,studentMarks);
					break;
		}
	}
	
	//main method
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		String[][] students=new String[2][0];
		String[][] studentMarks=new String[4][0];
		while(true){
			System.out.print("> ");
			String initial=input.nextLine();
			switch(initial){
				case "java AppInitializer" : clearConsole();options(students,studentMarks);
				break;
				default : clearConsole();
				break;
			}
		}
	}
}
