

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
				if(sLine.matches(".*��\\..*")) {
					if(sLine.matches(".*��\\..*")){ //����1�� 2�� �� �ٿ� �ִ� ���
						token = sLine.indexOf("��.");
						ex1 = sLine.substring(0, token);
						ex2 = sLine.substring(token);
						Allex1.add(ex1); //����1 ����
						Allex2.add(ex2); //����2 ����
					}else{
						Allex1.add(sLine); //����1 ����
					}
				}else if(sLine.matches(".*��\\..*")) {
					Allex2.add(sLine); //����2 ����
				}else if(sLine.matches(".*��\\..*")) {
					token = sLine.indexOf("��."); //��. �� �����ϴ� ���� ��츸 �ޱ����� ���ڿ� ��ġ�� ����
					if(token == 0){ //��. �� �����ϴ� ���ڿ��� ���
						if(sLine.matches(".*��\\..*")){ //����3�� 4�� �� �ٿ� �ִ� ���
							token = sLine.indexOf("��.");
							ex3 = sLine.substring(0, token);
							ex4 = sLine.substring(token);
							Allex3.add(ex3); //����3 ����
							Allex4.add(ex4); //����4 ����
						}else{
							Allex3.add(sLine); //����3 ����
						}
					}else{ //��. �� �����ϴ� ���ڿ��� �ƴ� ��� (ex: xx�̴�. )
						if(sLine.matches(".*��\\..*")) {
							Allex4.add(sLine); //����4 ���� 
						}else if(sLine.matches(".*0\\..*") || sLine.matches(".*1\\..*") || sLine.matches(".*2\\..*")
								 || sLine.matches(".*3\\..*") || sLine.matches(".*4\\..*") || sLine.matches(".*5\\..*")
								 || sLine.matches(".*6\\..*") || sLine.matches(".*7\\..*") || sLine.matches(".*8\\..*")
								 || sLine.matches(".*9\\..*")){
							Allquestion.add(sLine);
							question = sLine; //���� �߰�
							
						}else{ //���� ���� ������ ���
							question += "\n"+sLine; //������ ���� ���� �߰�
						}
					}
				}else if(sLine.matches(".*��\\..*")) {
					Allex4.add(sLine); //����4 ����
				}else{ //���� �� ���
					if(sLine.matches(".*0\\..*") || sLine.matches(".*1\\..*") || sLine.matches(".*2\\..*")
							 || sLine.matches(".*3\\..*") || sLine.matches(".*4\\..*") || sLine.matches(".*5\\..*")
							 || sLine.matches(".*6\\..*") || sLine.matches(".*7\\..*") || sLine.matches(".*8\\..*")
							 || sLine.matches(".*9\\..*")){
						Allquestion.add(question);
						question = sLine; //���� �߰�
						if(sLine.matches(".*100\\..*")){ //100�� ������ ���
							Allquestion.add(question);
							Allquestion.remove(0);
						}
					}else{ //���� ���� ������ ���
						question += "\n"+sLine; //������ ���� ���� �߰�
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