package cn.com.test;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.xml.rpc.ServiceException;

import org.apache.axis.message.MessageElement;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import cn.com.WebXml.DomesticAirline;
import cn.com.WebXml.DomesticAirlineLocator;

/**
 * Eclipse 创建WebService 
 * 	步骤：
 * 		1. new -> other	->WebServiceClient	->	Brower	输入	web service 的WSDL	
 * 				http://webservice.webxml.com.cn/webservices/DomesticAirline.asmx?wsdl
 * 		2.	创建客服端 链接web service 的链接
 * 		3.	得到	web service 的返回数据	DataSet
 * 		4.	dom4j 解析 DataSet
 * @author shenwei
 */
public class Test {
	public static void main(String[] args) throws RemoteException,
			ServiceException, MalformedURLException {

		DomesticAirline factory = new DomesticAirlineLocator();
		
		/*MessageElement[] msgs = factory.getDomesticAirlineSoap()
				.getDomesticCity().get_any();*/
		
		MessageElement[] msgs = factory.getDomesticAirlineSoap().getDomesticAirlinesTime("上海", "北京", "", null).get_any();
		List FOCElementHead = msgs[0].getChildren();
		List FOCElementBody = msgs[1].getChildren();

		String nn = FOCElementBody.get(0).toString();// 消息体的字符串形式

		SAXReader reader = new SAXReader();
		Document document = null;
		try {
			document = document = DocumentHelper.parseText(nn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}

		Element root = (Element) document.getRootElement(); // 得到根元素
		List<TicketInfo> ticketInfoList = new ArrayList<TicketInfo>();
		for (Object e : root.elements()) {
			TicketInfo ticketInfo = new TicketInfo();
			Element element = (Element) e;
			
			/*System.out.println(element.elementText("enCityName"));
			System.out.println(element.elementText("cnCityName"));
			System.out.println(element.elementText("Abbreviation"));
			System.out.println("-----------------------------------");*/
			
			System.out.println("航空公司:"+element.elementText("Company"));
			System.out.println("航班号:"+element.elementText("AirlineCode"));
			System.out.println("出发机场:"+element.elementText("StartDrome"));
			System.out.println("到达机场:"+element.elementText("ArriveDrome"));
			System.out.println("出发时间:"+element.elementText("StartTime"));
			System.out.println("到达时间:"+element.elementText("ArriveTime"));
			System.out.println("机型:"+element.elementText("Mode"));
			System.out.println("经停:"+element.elementText("AirlineStop"));
			System.out.println("飞行周期(星期):"+element.elementText("Week"));
			System.out.println("-----------------------------------");
			
			ticketInfo.setCompany(element.elementText("Company"));
			ticketInfo.setAirlineCode(element.elementText("AirlineCode"));
			ticketInfo.setStartDrome(element.elementText("StartDrome"));
			ticketInfo.setArriveDrome(element.elementText("ArriveDrome"));
			
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
				ticketInfo.setStartTime(sdf.parse(element.elementText("StartTime")));
				ticketInfo.setArriveTime(sdf.parse(element.elementText("ArriveTime")));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			ticketInfo.setMode(element.elementText("Mode"));
			ticketInfo.setAirlineStop(element.elementText("AirlineStop"));
			ticketInfo.setWeek(element.elementText("Week"));

			ticketInfoList.add(ticketInfo);
		}
	}
}
