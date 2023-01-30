import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class WeatherSaxParser {
	List<WeatherDto> list = new ArrayList<>();

	public List<WeatherDto> getNewsList(String url) {
		list.removeAll(list);
		connectWeather(url);
		return list;
	}

	private List<WeatherDto> connectWeather(String url) {
		SAXParserFactory f = SAXParserFactory.newInstance();
		try {
			SAXParser parser = f.newSAXParser();
			SAXHandler handler = new SAXHandler();
			parser.parse(new URL(url).openConnection().getInputStream(), handler);
			// int i = 1/0; // 어떤 예외가 어디서 왜 발생했는지 확인할것
			return list;
		} catch (Exception e) {
			// e.printStackTrace(); 			// 해결책 1. 예외 원인을 알 수 있다.
			throw new RuntimeException(); 		// 에러 원인을 출력하지 못함. ArithmetricException인데 RuntimeException을 출력해버림
			// throw new RuntimeException(e);	// 해결책 2. e를 매개변수로 전달. 콘솔에 예외 원인이 출력됨
		}
	}

	public class SAXHandler extends DefaultHandler {
		private StringBuilder sb;
		private String content;
		WeatherDto w;

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			String line = new String(ch, start, length);
			sb = new StringBuilder(line);
			content = new String(ch, start, length);
		}

		@Override
		public void endElement(String uri, String localName, String name) throws SAXException {
			if (name.equals("channel")) {
				list.add(w);
				w = null;
			} else if (name.equals("hour")) {
				w.setHour(sb.toString());
			} else if (name.equals("temp")) {
				w.setTemp(sb.toString());
			} else if (name.equals("wfKor")) {
				w.setWfKor(sb.toString());
			} else if (name.equals("reh")) {
				w.setReh(sb.toString());
			}  else if (name.equals("wfEn")) {
				w.setWfEn(sb.toString());
			}
		}

		@Override
		public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
			if (name.equals("data")) {
				w = new WeatherDto();
			}
		}
		
		@Override
		public void endDocument() throws SAXException {
			System.out.println("문서 종료");
		}
	}

}