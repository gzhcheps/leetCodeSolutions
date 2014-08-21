import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.junit.Test;

public class HttpTest {

	public static final String GET_URL = " http://hq.sinajs.cn/";

	@Test
	public  void readContentFromGet() throws IOException {

		// ƴ��get�����URL�ִ���ʹ��URLEncoder.encode������Ͳ��ɼ��ַ����б���

		String getURL = GET_URL + "list="

		+ URLEncoder.encode("sz002235", "utf-8");

		URL getUrl = new URL(getURL);

		// ����ƴ�յ�URL�������ӣ�URL.openConnection()���������
		// URL�����ͣ����ز�ͬ��URLConnection����Ķ������������ǵ�URL��һ��http�������ʵ���Ϸ��ص���HttpURLConnection

		HttpURLConnection connection = (HttpURLConnection) getUrl
				.openConnection();

		// ����������������ӣ���δ��������

		connection.connect();

		// �������ݵ���������ʹ��Reader��ȡ���ص�����

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				connection.getInputStream()));

		System.out.println(" ============================= ");

		System.out.println(" Contents of get request ");

		System.out.println(" ============================= ");

		String lines;

		while ((lines = reader.readLine()) != null) {

			System.out.println(lines);

		}

		reader.close();

		// �Ͽ�����

		connection.disconnect();

		System.out.println(" ============================= ");

		System.out.println(" Contents of get request ends ");

		System.out.println(" ============================= ");

	}

	@Test
	public  void main() {

		// TODO Auto-generated method stub

		try {

			readContentFromGet();

		} catch (IOException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

	}

}