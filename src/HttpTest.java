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

		// 拼凑get请求的URL字串，使用URLEncoder.encode对特殊和不可见字符进行编码

		String getURL = GET_URL + "list="

		+ URLEncoder.encode("sz002235", "utf-8");

		URL getUrl = new URL(getURL);

		// 根据拼凑的URL，打开连接，URL.openConnection()函数会根据
		// URL的类型，返回不同的URLConnection子类的对象，在这里我们的URL是一个http，因此它实际上返回的是HttpURLConnection

		HttpURLConnection connection = (HttpURLConnection) getUrl
				.openConnection();

		// 建立与服务器的连接，并未发送数据

		connection.connect();

		// 发送数据到服务器并使用Reader读取返回的数据

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

		// 断开连接

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