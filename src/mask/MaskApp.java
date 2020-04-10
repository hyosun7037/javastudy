package mask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;

public class MaskApp {

	
	public static long getMaskPage() {
		try {
			URL url = new URL("https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/stores/json?page=1");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			StringBuilder sb = new StringBuilder();
			String input = "";
			while ((input = br.readLine()) != null) {
				sb.append(input);
			}
			System.out.println(sb.toString());
			br.close();
			con.disconnect();

			Gson gson = new Gson();
			MaskInfo maskInfo = gson.fromJson(sb.toString(), MaskInfo.class);
		
			return maskInfo.getTotalCount();
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
		}
	
	
	public static MaskInfo maskInfo(int page) {
		try {
		URL url = new URL("https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/stores/json?page=" + page);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
		StringBuilder sb = new StringBuilder();
		String input = "";
		while ((input = br.readLine()) != null) {
			sb.append(input); 
		}
//		System.out.println(sb.toString());
		br.close();
		con.disconnect();

		Gson gson = new Gson();
		MaskInfo maskInfo = gson.fromJson(sb.toString(), MaskInfo.class);

		return maskInfo;
	}catch(Exception e){
		e.printStackTrace();
	}
	return null;
	}

	public static void main(String[] args) {
//		System.out.println(getMaskInfo(1).getStoreInfos().get(1).getAddr());
		
		System.out.println("지역을 입력하세요");
		Scanner sc = new Scanner(System.in);
		String loc = sc.nextLine(); //한줄 다 적용
		
//		ArrayList<MaskInfo> maskInfos = new ArrayList<>();
		
//		System.out.println(getMaskInfo(1).getTotalPages());
//		System.out.println(getMaskInfo(1).getStoreInfos().get(0).getAddr());
		
//		MaskInfo temp = maskInfo(1); //함수를 실행하면 페이지에 접속을 하기 때문에 여러번 접속하지 않기 위해 실행된 값을 리턴값에 넣는다.
		
		System.out.println(maskInfo(1).getTotalPages());
		for (int j = 1; j <= maskInfo(1).getTotalPages(); j++) {
			MaskInfo temp = maskInfo(j);
			for (int i = 0; i < temp.getStoreInfos().size(); i++) {
			if(temp.getStoreInfos().get(i).getAddr().contains(loc)) { //if안 값은 true
				System.out.println(temp.getStoreInfos().get(i).getAddr());
				System.out.println(temp.getStoreInfos().get(i).getName());
			}
		}
		}
		
		
//		for (int i = 0; i < temp.getStoreInfos().size(); i++) {
//			if(temp.getStoreInfos().get(i).getAddr().contains(loc)) { //if안 값은 true
//				System.out.println(temp.getStoreInfos().get(i).getAddr());
//				System.out.println(temp.getStoreInfos().get(i).getName());
//			}
//		}
		
		
		
		
		
	
	}
}
