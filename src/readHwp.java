

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class readHwp {
	public static void main(String[] args) throws IOException {
		int token;
		String sLine = null;
		String question = null;
		String ex1 = null;
		String ex2 = null;
		String ex3 = null;
		String ex4 = null;
		ArrayList Allquestion = new ArrayList();
		ArrayList Allex1 = new ArrayList();
		ArrayList Allex2 = new ArrayList();
		ArrayList Allex3 = new ArrayList();
		ArrayList Allex4 = new ArrayList();
		ArrayList Allex5 = new ArrayList();
		
		File file = new File("C:\\Users\\jungbo4-01\\Downloads\\test.txt");
		if (file.exists()) {
			BufferedReader inFile = new BufferedReader(new InputStreamReader(new FileInputStream(file),"EUC-KR"));
			while ((sLine = inFile.readLine()) != null){
				if(sLine.matches(".*가\\..*")) {
					if(sLine.matches(".*나\\..*")){ //보기1과 2가 한 줄에 있는 경우
						token = sLine.indexOf("나.");
						ex1 = sLine.substring(0, token);
						ex2 = sLine.substring(token);
						Allex1.add(ex1); //보기1 저장
						Allex2.add(ex2); //보기2 저장
					}else{
						Allex1.add(sLine); //보기1 저장
					}
				}else if(sLine.matches(".*나\\..*")) {
					Allex2.add(sLine); //보기2 저장
				}else if(sLine.matches(".*다\\..*")) {
					token = sLine.indexOf("다."); //다. 로 시작하는 줄인 경우만 받기위해 문자열 위치값 저장
					if(token == 0){ //다. 로 시작하는 문자열인 경우
						if(sLine.matches(".*라\\..*")){ //보기3과 4가 한 줄에 있는 경우
							token = sLine.indexOf("라.");
							ex3 = sLine.substring(0, token);
							ex4 = sLine.substring(token);
							Allex3.add(ex3); //보기3 저장
							Allex4.add(ex4); //보기4 저장
						}else{
							Allex3.add(sLine); //보기3 저장
						}
					}else{ //다. 로 시작하는 문자열이 아닌 경우 (ex: xx이다. )
						if(sLine.matches(".*라\\..*")) {
							Allex4.add(sLine); //보기4 저장 
						}else if(sLine.matches(".*0\\..*") || sLine.matches(".*1\\..*") || sLine.matches(".*2\\..*")
								 || sLine.matches(".*3\\..*") || sLine.matches(".*4\\..*") || sLine.matches(".*5\\..*")
								 || sLine.matches(".*6\\..*") || sLine.matches(".*7\\..*") || sLine.matches(".*8\\..*")
								 || sLine.matches(".*9\\..*")){
							Allquestion.add(sLine);
							question = sLine; //문제 추가
							
						}else{ //문제 하위 내용일 경우
							question += "\n"+sLine; //문제에 하위 내용 추가
						}
					}
				}else if(sLine.matches(".*라\\..*")) {
					Allex4.add(sLine); //보기4 저장
				}else{ //문제 인 경우
					if(sLine.matches(".*0\\..*") || sLine.matches(".*1\\..*") || sLine.matches(".*2\\..*")
							 || sLine.matches(".*3\\..*") || sLine.matches(".*4\\..*") || sLine.matches(".*5\\..*")
							 || sLine.matches(".*6\\..*") || sLine.matches(".*7\\..*") || sLine.matches(".*8\\..*")
							 || sLine.matches(".*9\\..*")){
						Allquestion.add(question);
						question = sLine; //문제 추가
						if(sLine.matches(".*100\\..*")){ //100번 문제일 경우
							Allquestion.add(question);
							Allquestion.remove(0);
						}
					}else{ //문제 하위 내용일 경우
						question += "\n"+sLine; //문제에 하위 내용 추가
					}
				}
			}
			inFile.close();
			for(int i=0; i<Allquestion.size(); i++){
				System.out.println(Allquestion.get(i));
			}
			/*System.out.println(Allex1.size());
			System.out.println(Allex2.size());
			System.out.println(Allex3.size());
			System.out.println(Allex4.size());
			System.out.println(Allquestion.size());*/
		}
	}
}