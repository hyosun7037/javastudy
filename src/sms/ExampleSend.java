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
		String api_key = "NCSPNXAUJ733AB37"; // 수정
		String api_secret = "WXC4K2UACMQKFJ2K6TO2H9M1TWXJ35VJ"; // 수정
		Message coolsms = new Message(api_key, api_secret);

		// 4 params(to, from, type, text) are mandatory. must be filled
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("to", tel); // 수신 번호
		params.put("from", "01067707037"); // 발신 번호
		params.put("type", "SMS");
		params.put("text", msg);
		params.put("app_version", "test app 1.2"); // application name and version

		try {
			JSONObject obj = (JSONObject) coolsms.send(params); // .send 호출하면 발송됨

			// params 해시맵 (key, value)를 담아서 날려줌
			// 통신은 결국 String을 날리는 것
			// request하면(json으로 바껴서 날라감, 나의 apikey, apisecret 등이 들어감,) 응답을 해주는 것 --> 세션이 동기화
			// 되있다는 의미
			// response으로 제대로 받았는지 확인(json으로 받음)

			// 내부적으로 스트림에 해시맵에 담긴 정보들이 다 날라감 + api 정보

			System.out.println(obj.toString()); // toString() 모든걸 string으로 바꾸는것
		} catch (CoolsmsException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCode());
		}
	}
}
