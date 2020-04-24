package sms;

import java.util.HashMap;
import org.json.simple.JSONObject;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

/**
 * @class ExampleSend
 * @brief This sample code demonstrate how to send sms through CoolSMS Rest API
 *        PHP
 */
public class ExampleSend {

	public ExampleSend(String tel, String msg) {
		String api_key = "NCSPNXAUJ733AB37"; // ����
		String api_secret = "WXC4K2UACMQKFJ2K6TO2H9M1TWXJ35VJ"; // ����
		Message coolsms = new Message(api_key, api_secret);

		// 4 params(to, from, type, text) are mandatory. must be filled
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("to", tel); // ���� ��ȣ
		params.put("from", "01067707037"); // �߽� ��ȣ
		params.put("type", "SMS");
		params.put("text", msg);
		params.put("app_version", "test app 1.2"); // application name and version

		try {
			JSONObject obj = (JSONObject) coolsms.send(params); // .send ȣ���ϸ� �߼۵�

			// params �ؽø� (key, value)�� ��Ƽ� ������
			// ����� �ᱹ String�� ������ ��
			// request�ϸ�(json���� �ٲ��� ����, ���� apikey, apisecret ���� ��,) ������ ���ִ� �� --> ������ ����ȭ
			// ���ִٴ� �ǹ�
			// response���� ����� �޾Ҵ��� Ȯ��(json���� ����)

			// ���������� ��Ʈ���� �ؽøʿ� ��� �������� �� ���� + api ����

			System.out.println(obj.toString()); // toString() ���� string���� �ٲٴ°�
		} catch (CoolsmsException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCode());
		}
	}
}
